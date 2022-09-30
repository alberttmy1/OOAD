import java.util.Arrays;
import java.util.List;

/*
 ** out = 0 -> then no one took dmg
 ** out = 1 -> then creature took dmg
 ** out = 2 -> hero took dmg
 */
import java.util.Random;
public class battle3{
    public int [] fight(int[] Hlocation, int Hid, int Hhp, String name, int Chp, int[] Clocation, List<String> Hinv){
        searchAndCombat fight = new searchAndCombat();
//        System.out.print("in fight" + name);
        int battle_res;
        if(Hid == 1 || Hid == 2 || Hid == 4){
            battle_res = fight.combat(Hid, Hinv);
            if(Arrays.equals(Hlocation, Clocation) && !(Arrays.equals(Clocation, new int[]{0, 0, 0}))) {
                if (battle_res == 0) {
//                    System.out.print("tied");
                    return new int[]{Hhp, Chp};
                }
                if (battle_res == 1) {
                    Chp--;
//                    System.out.print("creature lost");
                    System.out.println(name+ " celebrates: " + party());
                    return new int[]{Hhp, Chp};
                }
                if (battle_res == 2) {
                    Hhp--;
//                    System.out.print("hero lost");
                    return new int[]{Hhp, Chp};
                }
            }
        }
        else{
            if(Arrays.equals(Hlocation, Clocation) && !(Arrays.equals(Clocation, new int[]{0, 0, 0}))) {
                int[] health = new int[]{0, 0};
                for(int i = 0; i < 2; i++) {
                    battle_res = fight.combat(Hid, Hinv);
                    if (battle_res == 0) {
                        health = new int[]{Hhp, Chp};
                    }
                    if (battle_res == 1 && Chp != 0) {
                        Chp--;
                        System.out.println(name+ " celebrates: " + party());
                        health = new int[]{Hhp, Chp};
                    }
                    if (battle_res == 2) {
                        Hhp--;
                        health = new int[]{Hhp, Chp};
                    }
                }
//                System.out.print("health");
                return health;
            }
        }
        return new int[]{Hhp, Chp};
    }

    private String party(){
        Random rand = new Random();
        String temp = "";

        //Decorator
        Celebrate post = new jump(new standardCeleb());
        Celebrate post2 = new spin(post);
        Celebrate post3 = new dance(post2);
        String output = post3.celeb();

        //Store into array
        String[] words = output.split(",");

        //System.out.println(Arrays.toString(words));
        //System.out.println(output);

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < rand.nextInt(3); j++){
                temp += words[i] + ", ";
            }
        }
        return temp;
    }
}
