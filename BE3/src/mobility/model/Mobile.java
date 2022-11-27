package mobility.model;

import java.util.Random;

public abstract class Mobile {
	protected double x;
    protected double y;
    protected double speed;
    protected double theta;
    static protected Random rand;

    public Mobile(double x, double y, double speed) {
        this.x = x;
        this.y = y;
        if (speed <= 0) {
            throw new IllegalArgumentException("Speed can not be negative or null");
        }
        this.speed = speed;
    }

    public double getX() {
        return this.x;
    }

    public double getY() {
        return this.y;
    }

    @Override
    public String toString() {
        return "(" + this.x + ", " + this.y + ")";
    }

    public abstract void move(double timeStep);
}
