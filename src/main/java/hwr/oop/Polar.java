package hwr.oop;

public class Polar {

    private final double distance;
    private final double angle;

    public Polar(double distance, double angle){
        this.distance = distance;
        this.angle = angle;

    }

    public double getDistance() {
        return distance;
    }

    public double getAngle() {
        return angle;
    }

    public static Polar convertPosToPolar(double x, double y){
        double angle = (180/Math.PI)*Math.atan2(y,x);
        if (y<0){
            angle+=360;
        }
        return new Polar(Math.sqrt((x*x)+(y*y)),angle);
    }

    public static Polar convertPolarToPos(Polar p){
        return new Polar(p.getDistance()*Math.cos(Math.toRadians(p.getAngle())),p.getDistance()*Math.sin(Math.toRadians(p.getAngle())));
    }

    @Override
    public String toString() {
        return "Polar{" + "distance=" + distance + ", angle=" + angle + "}";
    }
}