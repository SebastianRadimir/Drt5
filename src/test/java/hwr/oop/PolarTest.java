package hwr.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class PolarTest {

    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates00(){
        Polar p = Polar.convertPosToPolar(0,0);
        assertThat(p.getDistance()).isEqualTo(0.0);
        assertThat(p.getAngle()).isEqualTo(0.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(0);
        assertThat(Math.round(cp.getAngle())).isEqualTo(0);

    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates10(){
        Polar p = Polar.convertPosToPolar(1,0);
        assertThat(Math.round(p.getDistance())).isEqualTo(1);
        assertThat(Math.round(p.getAngle())).isEqualTo(0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(0);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates01(){
        Polar p = Polar.convertPosToPolar(0,1);
        assertThat(p.getDistance()).isEqualTo(1.0);
        assertThat(p.getAngle()).isEqualTo(90.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(0);
        assertThat(Math.round(cp.getAngle())).isEqualTo(1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinatesMinus10(){
        Polar p = Polar.convertPosToPolar(-1,0);
        assertThat(p.getDistance()).isEqualTo(1.0);
        assertThat(p.getAngle()).isEqualTo(180.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(-1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(0);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates0Minus1(){
        Polar p = Polar.convertPosToPolar(0,-1);
        assertThat(p.getDistance()).isEqualTo(1.0);
        assertThat(p.getAngle()).isEqualTo(270.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(0);
        assertThat(Math.round(cp.getAngle())).isEqualTo(-1);
    }

    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates11(){
        Polar p = Polar.convertPosToPolar(1,1);
        assertThat(p.getDistance()).isEqualTo(Math.sqrt(2));
        assertThat(p.getAngle()).isEqualTo(45.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinatesMinus11(){
        Polar p = Polar.convertPosToPolar(-1,1);
        assertThat(p.getDistance()).isEqualTo(Math.sqrt(2));
        assertThat(p.getAngle()).isEqualTo(135.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(-1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinatesMinus1Minus1(){
        Polar p = Polar.convertPosToPolar(-1,-1);
        assertThat(p.getDistance()).isEqualTo(Math.sqrt(2));
        assertThat(p.getAngle()).isEqualTo(225.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(-1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(-1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinates1Minus1(){
        Polar p = Polar.convertPosToPolar(1,-1);
        assertThat(p.getDistance()).isEqualTo(Math.sqrt(2));
        assertThat(p.getAngle()).isEqualTo(315.0);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(1);
        assertThat(Math.round(cp.getAngle())).isEqualTo(-1);
    }
    @Test
    void Polar_testsConversionFromCartesianToPolarCoordinatesRandomVars1(){
        Polar p = Polar.convertPosToPolar(3,-0.1);
        assertThat(Math.round(p.getDistance())).isEqualTo(3);
        assertThat(Math.round(p.getAngle())).isEqualTo(358);

        Polar cp = Polar.convertPolarToPos(p);
        assertThat(Math.round(cp.getDistance())).isEqualTo(3);
        assertThat(Math.round(cp.getAngle())).isEqualTo(0);
    }
}
