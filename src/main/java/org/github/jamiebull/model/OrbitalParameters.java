package org.github.jamiebull.model;

import java.math.BigDecimal;

import static java.math.BigDecimal.ZERO;

public class OrbitalParameters {

    private BigDecimal orbitalRadius;
    private BigDecimal orbitalAngle;
    private BigDecimal radialVelocity;
    private BigDecimal angularVelocity;

    public OrbitalParameters(){
        this(ZERO, ZERO, ZERO, ZERO);
    }

    public OrbitalParameters(BigDecimal orbitalRadius, BigDecimal orbitalAngle, BigDecimal radialVelocity, BigDecimal angularVelocity){
        this.orbitalRadius = orbitalRadius;
        this.orbitalAngle = orbitalAngle;
        this.radialVelocity = radialVelocity;
        this.angularVelocity =  angularVelocity;
    }

    public BigDecimal getOrbitalRadius() {
        return orbitalRadius;
    }

    public BigDecimal getOrbitalAngle() {
        return orbitalAngle;
    }

    public BigDecimal getRadialVelocity() {
        return radialVelocity;
    }

    public BigDecimal getAngularVelocity() {
        return angularVelocity;
    }
}
