package org.github.jamiebull.model;

import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class BodyTest {

    @Ignore
    @Test
    public void shouldAdvanceToOtherSideOfOrbit() {
        Body centralBody = new Body("central", new BigDecimal(10));
        BigDecimal initialAngularVelocity = new BigDecimal("8.169455306E-6");
        Body orbital = new Body("orbital", new BigDecimal(1), centralBody, new OrbitalParameters(
                new BigDecimal(10),
                ZERO,
                ZERO,
                initialAngularVelocity));
        BigDecimal halfOrbitalPeriod = new BigDecimal("12160649.51");

        assertThat(orbital.getOrbitalAngle(), is(ZERO));
        assertThat(orbital.getOrbitalRadius(), is(new BigDecimal(10)));
        assertThat(orbital.getRadialVelocity(), is(ZERO));
        assertThat(orbital.getAngularVelocity(), is(initialAngularVelocity));

        orbital.advance(halfOrbitalPeriod.longValue());

        assertThat(orbital.getOrbitalAngle(), is(new BigDecimal(Math.PI)));
        assertThat(orbital.getOrbitalRadius(), is(new BigDecimal(10)));
        assertThat(orbital.getRadialVelocity(), is(ZERO));
        assertThat(orbital.getAngularVelocity(), is(initialAngularVelocity.multiply(new BigDecimal(-1))));
    }
}
