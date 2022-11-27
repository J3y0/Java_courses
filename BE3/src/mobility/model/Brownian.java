package mobility.model;

public class Brownian extends Mobile {
    public Brownian(double x0, double y0, double speed) {
        super(x0, y0, speed);
    }

    @Override
    public String toString() {
        return "B (" + this.x + ", " + this.y + ")";
    }

    public void move(double timeStep) {
        this.theta = Mobile.rand.nextDouble()*2*Math.PI;
        double dx = this.speed*timeStep*Math.cos(this.theta);
        double dy = this.speed*timeStep*Math.sin(this.theta);
        this.x += dx;
        this.y += dy;
    }
}
