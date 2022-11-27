package mobility.model;

import mobility.Simulation;

public class Follower extends Mobile {
    
    private int M;
    private Mobile leader;

    public Follower(double x0, double y0, Mobile leader, int M) {
        super(x0, y0, leader.speed);
        this.M = M;
        this.leader = leader;
        this.theta = leader.theta;
    }

    @Override
    public String toString() {
        return "F (" + this.x + ", " + this.y + ") -> " + this.leader.toString();
    }

    public void move(double timeStep) {
        double alpha = 0;
        if (Simulation.step % this.M == 0) {
            if (this.leader.x < this.x) {
                alpha = Math.PI + Math.atan((this.leader.y - this.y)/(this.leader.x - this.x));
                this.theta = Mobile.rand.nextGaussian()*(Math.PI/12) + alpha;
            } else if (this.leader.x > this.x) {
                alpha = Math.atan((this.leader.y - this.y)/(this.leader.x - this.x));
                this.theta = Mobile.rand.nextGaussian()*(Math.PI/12) + alpha;
            } else {
                this.theta = Math.PI / 2 * (this.leader.y - this.y)/Math.abs(this.leader.y - this.y);
            }
            
        }
        double dx = this.speed*timeStep*Math.cos(this.theta);
        double dy = this.speed*timeStep*Math.sin(this.theta);
        this.x += dx;
        this.y += dy;
    }
}
