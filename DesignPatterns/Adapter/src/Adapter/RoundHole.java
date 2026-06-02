package Adapter;

public class RoundHole {
    private float radius;

    public RoundHole(float radius){
        this.radius = radius;
    }

    public boolean fits(RoundPeg peg){
        return this.radius >= peg.getRadius();
    }
}
