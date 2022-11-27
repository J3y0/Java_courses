package mobility.model;

public class Drunkard extends Mobile {

    public Drunkard(double x0, double y0, double speed) {
        super(x0, y0, speed);
        this.theta = 0;
    }

    @Override
    public String toString() {
        return "D (" + this.x + ", " + this.y + ")";
    }

    public void move(double timeStep) {
        this.theta = Mobile.rand.nextGaussian()*(Math.PI/12) + this.theta;
        double dx = this.speed*timeStep*Math.cos(this.theta);
        double dy = this.speed*timeStep*Math.sin(this.theta);
        this.x += dx;
        this.y += dy;
    }
}
