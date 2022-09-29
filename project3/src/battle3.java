import java.util.Arrays;
import java.util.List;

/*
 ** out = 0 -> then no one took dmg
 ** out = 1 -> then creature took dmg
 ** out = 2 -> hero took dmg
 */

public class battle3 extends Celebrate{

    static int [] fight(int[] Hlocation, int Hid, int Hhp, String name, int Chp, int[] Clocation, List<String> Hinv){
        searchAndCombat fight = new searchAndCombat();
        System.out.print("in fight" + name);
        Celebrate celeb = new Celebrate();
        int battle_res;
        if(Hid == 1 || Hid == 2 || Hid == 4){
            battle_res = fight.combat(Hid, Hinv);
            if(Arrays.equals(Hlocation, Clocation) && !(Arrays.equals(Clocation, new int[]{0, 0, 0}))) {
                if (battle_res == 0) {
                    System.out.print("tied");
                    return new int[]{Hhp, Chp};
                }
                if (battle_res == 1) {
                    Chp--;
                    System.out.print("creature lost");
                    System.out.print(name+ " celebrates: " + celeb.Cheers());
                    return new int[]{Hhp, Chp};
                }
                if (battle_res == 2) {
                    Hhp--;
                    System.out.print("hero lost");
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
                        System.out.print(name+ " celebrates: " + celeb.Cheers());
                        health = new int[]{Hhp, Chp};
                    }
                    if (battle_res == 2) {
                        Hhp--;
                        health = new int[]{Hhp, Chp};
                    }
                }
                System.out.print("health");
                return health;
            }
        }
        return new int[]{Hhp, Chp};
    }
}
