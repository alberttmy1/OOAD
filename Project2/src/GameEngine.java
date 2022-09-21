import java.util.ArrayList;
import java.util.Arrays;

public class GameEngine {

    void run(){
        Facility move = new Facility();
        battle battle = new battle();
        //initializing the game and game ending variables
        int money = 0;
        int enemies = 12;
        int hero = 4;
        boolean casino = true;
        //Default
        int[] start = {0,1,1};
        int[] start1 = {0,1,1};
        int[] start2 = {0,1,1};
        int[] start3 = {0,1,1};
        int round = 0;
        String temp = "";

        //floor values
        int minD = 0;
        int maxD = 2;
        int minf = 1;
        int maxf = 4;

        //Map initialization
        Map tower = new Map();
        int[][] floor0 = tower.lv0();
        int[][] floor1 = tower.lv1();
        int[][] floor2 = tower.lv2();
        int[][] floor3 = tower.lv3();
        int[][] floor4 = tower.lv4();
        int[][][] test = {floor1,floor2,floor3,floor4}; //floor, room coordinates, coordinates index

        //initialization of the characters
        Adventurers_stats Brawler = new Adventurers_stats(1);
        Adventurers_stats Sneaker = new Adventurers_stats(2);
        Adventurers_stats Runner = new Adventurers_stats(3);
        Adventurers_stats Thief = new Adventurers_stats(4);
        Brawler.setSpawn(start);
        Sneaker.setSpawn(start1);
        Runner.setSpawn(start2);
        Thief.setSpawn(start3);

        //array to hold all creatures
        ArrayList<Creatures_stats> monsters = new ArrayList<Creatures_stats>();

        //initializing 12 creatures
        for(int i = 0; i < 4; i++) {
            for (int k = 1; k <= 3; k++) {
                monsters.add(new Creatures_stats(k));
            }
        }
        //Set the spawn for all
        for(int i = 0; i< 12; i++){
            monsters.get(i).setSpawn(move.creatureSpawn(monsters.get(i).getID()));
            //System.out.println(Arrays.toString(monsters.get(i).getSpawn()));
        }

        //money != 10 || enemies != 0 || hero !=0)
        while(round != 5){

            //Roll for treasure
            for(int j = 0; j < 12;j++){
                if(Arrays.equals(Brawler.getSpawn(), monsters.get(j).getSpawn())){
                    casino = false;
                }
            }
            if(casino){
                Brawler.setTreasure(move.getTresure());
            }
            casino = true;
            for(int j = 0; j < 12;j++){
                if(Arrays.equals(Sneaker.getSpawn(), monsters.get(j).getSpawn())){
                    casino = false;
                }
            }
            if(casino){
                Sneaker.setTreasure(move.getTresure());
            }
            casino = true;
            for(int j = 0; j < 12;j++){
                if(Arrays.equals(Runner.getSpawn(), monsters.get(j).getSpawn())){
                    casino = false;
                }
            }
            if(casino){
                Runner.setTreasure(move.getTresure());
            }
            casino = true;
            for(int j = 0; j < 12;j++){
                if(Arrays.equals(Thief.getSpawn(), monsters.get(j).getSpawn())){
                    casino = false;
                }
            }
            if(casino){
                Thief.setTreasure(move.getTresure());
            }

            System.out.println("Turn: " + round);
            for(int i =0; i < floor0.length; i++){
                System.out.print(floor0[i][0]+"-"+floor0[i][1]+"-"+floor0[i][2]+": ");
                if(Arrays.equals(Brawler.getSpawn(), floor0[i])){
                    System.out.print("B, ");
                }
                if (Arrays.equals(Sneaker.getSpawn(), floor0[i])){
                    System.out.print("S, ");
                }
                if (Arrays.equals(Runner.getSpawn(), floor0[i])) {
                    System.out.print("R, ");
                }
                if (Arrays.equals(Thief.getSpawn(), floor0[i])){
                    System.out.print("T, ");
                }else{
                    System.out.print("e");
                }
            }
            System.out.println("");

            //Print out floors 1-4
            for(int j=0; j < 4; j++){
                for(int k = 0; k < 9; k++){
                    if (k % 3 == 0){
                        System.out.println("");
                    }
                    String coor = test[j][k][0]+"-"+test[j][k][1]+"-"+test[j][k][2]+": ";
                    if(Arrays.equals(Brawler.getSpawn(), test[j][k])){
                        temp += "B, ";
                    }
                    if (Arrays.equals(Sneaker.getSpawn(), test[j][k])){
                        temp += "S, ";
                    }
                    if (Arrays.equals(Runner.getSpawn(), test[j][k])) {
                        temp += "R, ";
                    }
                    if (Arrays.equals(Thief.getSpawn(), test[j][k])){
                        temp += "T, ";
                    }
                    for(int m = 0; m < 12; m++){
                        if(Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 1){
                            temp += "OB, ";
                        }
                        if(Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 2){
                            temp += "SE, ";
                        }
                        if(Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 3){
                            temp += "BL, ";
                        }
                    }

                    System.out.printf("%s %-15s", coor, temp );
                    temp = "";
                }
                System.out.println("");
            }

            for(int i = 0; i < 12; i++){
                if(monsters.get(i).getID() == 1){
                    if(Arrays.equals(monsters.get(i).getSpawn(), Brawler.getSpawn())){
                        int res = battle.fight(Brawler.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Brawler.setHP(Brawler.getHP() - 1);
                            if(Brawler.getHP() == 0){
                                Brawler.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Sneaker.getSpawn())){
                        int res = battle.fight(Sneaker.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Sneaker.setHP(Sneaker.getHP() - 1);
                            if(Sneaker.getHP() == 0){
                                Sneaker.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Runner.getSpawn())){
                        int res = battle.fight(Runner.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Runner.setHP(Runner.getHP() - 1);
                            if(Runner.getHP() == 0){
                                Runner.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Thief.getSpawn())){
                        int res = battle.fight(Thief.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Thief.setHP(Thief.getHP() - 1);
                            if(Thief.getHP() == 0){
                                Thief.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                }
                if(monsters.get(i).getID() == 2){
                    if(Arrays.equals(monsters.get(i).getSpawn(), Brawler.getSpawn())){
                        int res = battle.fight(Brawler.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Brawler.setHP(Brawler.getHP() - 1);
                            if(Brawler.getHP() == 0){
                                Brawler.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Sneaker.getSpawn())){
                        int res = battle.fight(Sneaker.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Sneaker.setHP(Sneaker.getHP() - 1);
                            if(Sneaker.getHP() == 0){
                                Sneaker.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Runner.getSpawn())){
                        int res = battle.fight(Runner.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Runner.setHP(Runner.getHP() - 1);
                            if(Runner.getHP() == 0){
                                Runner.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Thief.getSpawn())){
                        int res = battle.fight(Thief.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Thief.setHP(Thief.getHP() - 1);
                            if(Thief.getHP() == 0){
                                Thief.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                }
                if(monsters.get(i).getID() == 3){
                    if(Arrays.equals(monsters.get(i).getSpawn(), Brawler.getSpawn())){
                        int res = battle.fight(Brawler.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Brawler.setHP(Brawler.getHP() - 1);
                            if(Brawler.getHP() == 0){
                                Brawler.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Sneaker.getSpawn())){
                        int res = battle.fight(Sneaker.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Sneaker.setHP(Sneaker.getHP() - 1);
                            if(Sneaker.getHP() == 0){
                                Sneaker.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Runner.getSpawn())){
                        int res = battle.fight(Runner.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Runner.setHP(Runner.getHP() - 1);
                            if(Runner.getHP() == 0){
                                Runner.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                    else if(Arrays.equals(monsters.get(i).getSpawn(), Thief.getSpawn())){
                        int res = battle.fight(Thief.getID());
                        if(res == 1){
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0,0,0});
                        }
                        if(res == 2){
                            Thief.setHP(Thief.getHP() - 1);
                            if(Thief.getHP() == 0){
                                Thief.setSpawn(new int[]{0,0,0});
                            }
                        }
                    }
                }
            }

            Brawler.setSpawn(move.heroMove(Brawler.getSpawn()));
            Sneaker.setSpawn(move.heroMove(Sneaker.getSpawn()));
            Runner.setSpawn(move.heroMove(Runner.getSpawn()));
            Thief.setSpawn(move.heroMove(Thief.getSpawn()));

            //check monster location

            // fix this code
            for(int i = 0; i < 12; i++){
                if(monsters.get(i).getID() == 1){
                    monsters.get(i).setSpawn(move.orbitorsMove2(monsters.get(i).getSpawn(), Brawler.getSpawn()));
                    monsters.get(i).setSpawn(move.orbitorsMove2(monsters.get(i).getSpawn(), Sneaker.getSpawn()));
                    monsters.get(i).setSpawn(move.orbitorsMove2(monsters.get(i).getSpawn(), Runner.getSpawn()));
                    monsters.get(i).setSpawn(move.orbitorsMove2(monsters.get(i).getSpawn(), Thief.getSpawn()));
                } else if (monsters.get(i).getID() == 2) {
                    monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), Brawler.getSpawn()));
                    monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), Sneaker.getSpawn()));
                    monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), Runner.getSpawn()));
                    monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), Thief.getSpawn()));
                }else{
                    monsters.get(i).setSpawn(move.blinkersMove(monsters.get(i).getSpawn(), Brawler.getSpawn()));
                    monsters.get(i).setSpawn(move.blinkersMove(monsters.get(i).getSpawn(), Sneaker.getSpawn()));
                    monsters.get(i).setSpawn(move.blinkersMove(monsters.get(i).getSpawn(), Runner.getSpawn()));
                    monsters.get(i).setSpawn(move.blinkersMove(monsters.get(i).getSpawn(), Thief.getSpawn()));
                }
            }


            round++;
        }//end of while
    }
}