package org.github.jamiebull.model;

import org.github.jamiebull.PhysicalConstants;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static java.math.BigDecimal.ONE;
import static org.github.jamiebull.PhysicalConstants.GRAVITATIONAL_CONSTANT;

public class Body {

    private String name;
    private BigDecimal mass;
    private Body centralBody;
    private OrbitalParameters orbitalParameters;

    private BigDecimal eccentricity;

    public Body(String name, BigDecimal mass){
        this(name, mass, null, new OrbitalParameters());
    }

    public Body(String name, BigDecimal mass, Body centralBody, OrbitalParameters orbitalParameters){
        this.name = name;
        this.mass = mass;
        this.centralBody = centralBody;
        this.orbitalParameters = orbitalParameters;
    }

    public BigDecimal getOrbitalAngle(){
        return this.orbitalParameters.getOrbitalAngle();
    }

    public BigDecimal getOrbitalRadius(){
        return this.orbitalParameters.getOrbitalRadius();
    }

    public BigDecimal getRadialVelocity(){
        return this.orbitalParameters.getRadialVelocity();
    }

    public BigDecimal getAngularVelocity(){
        return this.orbitalParameters.getAngularVelocity();
    }

    public BigDecimal getMass(){
        return this.mass;
    }

    private BigDecimal calculateEccentricity(){
        if(this.eccentricity != null){
            return eccentricity;
        } else {
            BigDecimal multiplicationFactors = calculateAngularMomentum().pow(2).divide(
                    mass.pow(2).multiply(GRAVITATIONAL_CONSTANT).multiply(centralBody.getMass()).multiply(new BigDecimal(-1)),
                    RoundingMode.HALF_UP
            );
            BigDecimal eccentricity = multiplicationFactors.subtract(ONE).divide(new BigDecimal(Math.cos(getOrbitalAngle().doubleValue())), RoundingMode.HALF_UP);
            this.eccentricity = eccentricity;
            return eccentricity;
        }
    }

    public void advance(long addedTimeSeconds){

    }

    private BigDecimal calculateAngularMomentum(){
        return getAngularVelocity().multiply(this.mass)
                .multiply(getOrbitalRadius()).multiply(getOrbitalRadius());
    }
}
