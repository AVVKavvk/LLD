package Adapter;

public class SquarePegAdapter extends RoundPeg {
    private SquarePeg sp;

    public SquarePegAdapter(SquarePeg sp){
        this.sp = sp;
    }

    @Override
    public float getRadius() {
        return (float) (sp.getWidth() * Math.sqrt(2) / 2);
    }
}
