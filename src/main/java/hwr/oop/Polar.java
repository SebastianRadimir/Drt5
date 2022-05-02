package hwr.oop;

public class Polar {

    private double distance;
    private double angle;

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

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public static Polar convertPosToPolar(double x, double y){
        double angle = (180/Math.PI)*Math.atan2(y,x);
        if (y<=0){
            angle+=360;
        }
        return new Polar(Math.sqrt((x*x)+(y*y)),angle);
    }

    public static Polar convertPolarToPos(Polar p){
        return new Polar(p.getDistance()*Math.cos(p.getAngle()),p.getDistance()*Math.sin(p.getAngle()));
    }

    @Override
    public String toString() {
        return "Polar{" +
                "distance=" + distance +
                ", angle=" + angle +
                '}';
    }
}