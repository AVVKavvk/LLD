import Adapter.RoundHole;
import Adapter.SquarePeg;
import Adapter.SquarePegAdapter;

void main() {
    RoundHole rh = new RoundHole(5);
    SquarePeg sp = new SquarePeg(10);

    SquarePegAdapter sqa  = new SquarePegAdapter(sp);
    System.out.println("Does square peg fit? " + rh.fits(sqa));
}