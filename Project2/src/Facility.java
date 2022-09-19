import java.util.ArrayList;
import java.util.Random;
public class Facility {

    Random rand = new Random();
    static int[] creature_pos(){
        ArrayList<Integer> loc = new ArrayList<Integer>();
        int z = rand.nextInt(4);
        int y = rand.nextInt(4);
        int x = rand.nextInt(4);
        loc.add((z,y,x));
        return(loc);
    }

}
