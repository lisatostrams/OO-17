
import java.util.List;


/**
 *
 * @author Sjaak Smetsers
 */
public class Main
{
    public static void main(String[] args) {
        int [] game = {1,2,3, 4,5,6, 7,9,8};

        SlidingGame s = new SlidingGame (game);
        System.out.println(s);
        s.toString();
        //s.equals(game);
//        Solver solver = new Solver(s);
//        System.out.println(solver.solve());
    }
}
