import java.util.ArrayList;

public class GameEngine {

    void run(){
        Facility move = new Facility();
        //initializing the game and game ending variables
        int money = 0;
        int enemies = 12;
        int hero = 4;
        //Default
        int[] start = {0,1,1};

        //floor values
        int minD = 0;
        int maxD = 2;
        int minf = 1;
        int maxf = 4;

        //initialization of the characters
        Adventurers_stats Brawler = new Adventurers_stats(1);
        Adventurers_stats Sneaker = new Adventurers_stats(2);
        Adventurers_stats Runner = new Adventurers_stats(3);
        Adventurers_stats Thief = new Adventurers_stats(4);
        Brawler.setSpawn(start);
        Sneaker.setSpawn(start);
        Runner.setSpawn(start);
        Thief.setSpawn(start);

        //array to hold all creatures
        ArrayList<Creatures_stats> monsters = new ArrayList<Creatures_stats>();

        //initializing 12 creatures
        for(int i = 0; i < 5; i++) {
            for (int k = 0; k < 4; k++) {
                monsters.add(new Creatures_stats(k));
            }
        }

        while(money != 10 || enemies != 0 || hero !=0){
            //movement & track

        }
    }
}