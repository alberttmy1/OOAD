import java.util.Random;

public class Celebrate {

    public String Cheers(){
        Random rand = new Random();
        String[] words = {"shout", "dance", "jump", "spin"};
        String output = "";
        int rep = 0;
        for(int i = 0; i < 4; i++){
            rep = rand.nextInt(3);
            for(int j = 0; j < rep; rep++){
                output += words[i];
            }
        }
        return output;
    }
}