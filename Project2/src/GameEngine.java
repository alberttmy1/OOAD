import java.util.ArrayList;

public class GameEngine {
    //game ending variables

    void run(){

        int money = 0;
        int enemies = 12;
        int hero = 4;

        Adventurers_stats Brawler = new Adventurers_stats(1);
        Adventurers_stats Sneaker = new Adventurers_stats(2);
        Adventurers_stats Runner = new Adventurers_stats(3);
        Adventurers_stats Thief = new Adventurers_stats(4);

        ArrayList<Creatures_stats> monsters = new ArrayList<Creatures_stats>();

        for(int i = 0; i < 5; i++) {
            for (int k = 0; k < 4; k++) {
                monsters.add(new Creatures_stats(k));
            }
        }

        while(money != 10 || enemies != 0 || hero !=0){
            //movement & track
        //monsters[1].getloc = 1-1-1
            // brawler.getloc = 1-1-1
        }
    }
}
