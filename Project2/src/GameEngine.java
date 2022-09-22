import java.util.ArrayList;
import java.util.Arrays;

public class GameEngine {

    void run(){
        //Initiate both Facility and battle class
        Facility move = new Facility();
        battle battle = new battle();

        //initializing the game and game ending variables
        int money = 0;
        int enemies = 12;
        int hero = 4;
        boolean casino = true;

        //Default spawn locations
        int[] start = {0,1,1};
        int[] start1 = {0,1,1};
        int[] start2 = {0,1,1};
        int[] start3 = {0,1,1};

        //Variables to keep track of turns
        int round = 0;
        String temp = "";

        //Map initialization
        Map tower = new Map();
        int[][] floor0 = tower.lv0();
        int[][] floor1 = tower.lv1();
        int[][] floor2 = tower.lv2();
        int[][] floor3 = tower.lv3();
        int[][] floor4 = tower.lv4();
        int[][][] test = {floor1,floor2,floor3,floor4}; //floor, room coordinates, coordinates index

        //initialization of the characters
        // This is an example of inheritance as each character is a category of adventurers
        Adventurers_stats Brawler = new Adventurers_stats(1);
        //This is and example of identity as it distinguishes each adventurer's object by naming each adventurer
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
        //Set the spawn for all Creatures
        for(int i = 0; i< 12; i++){
            monsters.get(i).setSpawn(move.creatureSpawn(monsters.get(i).getID()));
        }

        /*
        *Continue to run until either they collect all the treasure(money), all the creatures(enemies),
        * or all the Adventures(hero) die
         */
        while(money  < 10 && enemies > 0 && hero > 0){

            //Boolean variables to track if a adventure can move or not
            boolean BMove = true;
            boolean SMove = true;
            boolean RMove = true;
            boolean TMove = true;

            //Roll for treasure
            casino = true;
            for (int j = 0; j < 12; j++) {
                if (Arrays.equals(Brawler.getSpawn(), monsters.get(j).getSpawn())) {
                    casino = false;
                }
            }
            if (casino) {
                Brawler.setTreasure(move.getTresure(Brawler.getID()));
            }
            casino = true;
            for (int j = 0; j < 12; j++) {
                if (Arrays.equals(Sneaker.getSpawn(), monsters.get(j).getSpawn())) {
                    casino = false;
                }
            }
            if (casino) {
                Sneaker.setTreasure(move.getTresure(Sneaker.getID()));
            }
            casino = true;
            for (int j = 0; j < 12; j++) {
                if (Arrays.equals(Runner.getSpawn(), monsters.get(j).getSpawn())) {
                    casino = false;
                }
            }
            if (casino) {
                Runner.setTreasure(move.getTresure(Runner.getID()));
                Runner.setTreasure(move.getTresure(Runner.getID()));
            }
            casino = true;
            for (int j = 0; j < 12; j++) {
                if (Arrays.equals(Thief.getSpawn(), monsters.get(j).getSpawn())) {
                    casino = false;
                }
            }
            if (casino) {
                Thief.setTreasure(move.getTresure(Thief.getID()));
            }

            //Print out the number of turns
            System.out.println("Turn: " + round);
            //Prints out the entrance floor layout and checks if anyone is in there
            for (int i = 0; i < floor0.length; i++) {
                System.out.print(floor0[i][0] + "-" + floor0[i][1] + "-" + floor0[i][2] + ": ");
                if (Arrays.equals(Brawler.getSpawn(), floor0[i])) {
                    System.out.print("B, ");
                }
                if (Arrays.equals(Sneaker.getSpawn(), floor0[i])) {
                    System.out.print("S, ");
                }
                if (Arrays.equals(Runner.getSpawn(), floor0[i])) {
                    System.out.print("R, ");
                }
                if (Arrays.equals(Thief.getSpawn(), floor0[i])) {
                    System.out.print("T, ");
                } else {
                    System.out.print("");
                }
            }
            System.out.println("");

            //Print out floors 1-4
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 9; k++) {
                    if (k % 3 == 0) {
                        System.out.println("");
                    }
                    String coor = test[j][k][0] + "-" + test[j][k][1] + "-" + test[j][k][2] + ": ";
                    if (Arrays.equals(Brawler.getSpawn(), test[j][k])) {
                        temp += "B, ";
                    }
                    if (Arrays.equals(Sneaker.getSpawn(), test[j][k])) {
                        temp += "S, ";
                    }
                    if (Arrays.equals(Runner.getSpawn(), test[j][k])) {
                        temp += "R, ";
                    }
                    if (Arrays.equals(Thief.getSpawn(), test[j][k])) {
                        temp += "T, ";
                    }
                    for (int m = 0; m < 12; m++) {
                        if (Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 1) {
                            temp += "OB, ";
                        }
                        if (Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 2) {
                            temp += "SE, ";
                        }
                        if (Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 3) {
                            temp += "BL, ";
                        }
                    }

                    System.out.printf("%s %-15s", coor, temp);
                    temp = "";
                }
                System.out.println("");
            }

            //Battle System that check if any of the 12 creatures can engage in a battle with a adventure
            for (int i = 0; i < 12; i++) {
                //checks if an Orbitor is in battle with any of the Adventures
                if (monsters.get(i).getID() == 1) {
                    //Checks to see if they are in the same room and if they are they can fight
                    if (Arrays.equals(monsters.get(i).getSpawn(), Brawler.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        //Rolls dice and inputs Brawler buffs
                        int res = battle.fight(Brawler.getID());
                        //if the creature dies then set its hp to zero and reduce the count of creatures
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                        }
                        //Reduce the adventures health and if they die set their spawn point to all zeroes(graveyard)
                        if (res == 2) {
                            Brawler.setHP(Brawler.getHP() - 1);
                            if (Brawler.getHP() == 0) {
                                Brawler.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                        }
                    }
                    // if the monster and sneaker are in the same location and they are not in the graveyard then fight
                    else if (Arrays.equals(monsters.get(i).getSpawn(), Sneaker.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Sneaker.getID());
                        // checks for 50% to leave or fight
                        int choice = move.chance();
                        if(choice == 1){
                            if (res == 1) {
                                //creature is defeated and its health is set to 0 and sent to the grave yard
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;
                            }
                            // adventerur takes damage and if it hits 0 then  it dies and sent to the grave yard
                            if (res == 2) {
                                Sneaker.setHP(Sneaker.getHP() - 1);
                                if (Sneaker.getHP() == 0) {
                                    Sneaker.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                    }
                    // The rest follow the same logic as above
                    else if (Arrays.equals(monsters.get(i).getSpawn(), Runner.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Runner.getID());
                        //If the Runner kills the monster he can move
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                            Runner.setSpawn(move.heroMove(Runner.getSpawn()));
                        }
                        //if he takes damage he can try to attack again
                        if (res == 2) {
                            Runner.setHP(Runner.getHP() - 1);
                            if (Runner.getHP() == 0) {
                                Runner.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                            res = battle.fight(Runner.getID());
                            if (res == 1) {
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;

                            }
                            if (res == 2) {
                                Runner.setHP(Runner.getHP() - 1);
                                if (Runner.getHP() == 0) {
                                    Runner.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                        //If the creature and runner tie he can try to fight him again
                        if (res == 0) {
                            res = battle.fight(Runner.getID());
                            if (res == 1) {
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;

                            }
                            if (res == 2) {
                                Runner.setHP(Runner.getHP() - 1);
                                if (Runner.getHP() == 0) {
                                    Runner.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                    }//Same as logic as above for Orbitor
                    else if (Arrays.equals(monsters.get(i).getSpawn(), Thief.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Thief.getID());
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                        }
                        if (res == 2) {
                            Thief.setHP(Thief.getHP() - 1);
                            if (Thief.getHP() == 0) {
                                Thief.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                        }
                    }
                }
                //The actions are the same as when a Adventure comes in contact with a Orbitor
                if (monsters.get(i).getID() == 2) {
                    if (Arrays.equals(monsters.get(i).getSpawn(), Brawler.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Brawler.getID());
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                        }
                        if (res == 2) {
                            Brawler.setHP(Brawler.getHP() - 1);
                            if (Brawler.getHP() == 0) {
                                Brawler.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                        }
                    } else if (Arrays.equals(monsters.get(i).getSpawn(), Sneaker.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Sneaker.getID());
                        int choice = move.chance();
                        if(choice == 1){
                            if (res == 1) {
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;
                            }
                            if (res == 2) {
                                Sneaker.setHP(Sneaker.getHP() - 1);
                                if (Sneaker.getHP() == 0) {
                                    Sneaker.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                    } else if (Arrays.equals(monsters.get(i).getSpawn(), Runner.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Runner.getID());
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                            Runner.setSpawn(move.heroMove(Runner.getSpawn()));
                        }
                        if (res == 2) {
                            Runner.setHP(Runner.getHP() - 1);
                            if (Runner.getHP() == 0) {
                                Runner.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                            res = battle.fight(Runner.getID());
                            if (res == 1) {
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;

                            }
                            if (res == 2) {
                                Runner.setHP(Runner.getHP() - 1);
                                if (Runner.getHP() == 0) {
                                    Runner.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                        if (res == 0) {
                            res = battle.fight(Runner.getID());
                            if (res == 1) {
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;

                            }
                            if (res == 2) {
                                Runner.setHP(Runner.getHP() - 1);
                                if (Runner.getHP() == 0) {
                                    Runner.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                    } else if (Arrays.equals(monsters.get(i).getSpawn(), Thief.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Thief.getID());
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                        }
                        if (res == 2) {
                            Thief.setHP(Thief.getHP() - 1);
                            if (Thief.getHP() == 0) {
                                Thief.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                        }
                    }
                }
                //The actions are the same as when a adventure comes in contact with Orbitor
                if (monsters.get(i).getID() == 3) {
                    if (Arrays.equals(monsters.get(i).getSpawn(), Brawler.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Brawler.getID());
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                        }
                        if (res == 2) {
                            Brawler.setHP(Brawler.getHP() - 1);
                            if (Brawler.getHP() == 0) {
                                Brawler.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                        }
                    } else if (Arrays.equals(monsters.get(i).getSpawn(), Sneaker.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Sneaker.getID());
                        int choice = move.chance();
                        if(choice == 1){
                            if (res == 1) {
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;
                            }
                            if (res == 2) {
                                Sneaker.setHP(Sneaker.getHP() - 1);
                                if (Sneaker.getHP() == 0) {
                                    Sneaker.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                    } else if (Arrays.equals(monsters.get(i).getSpawn(), Runner.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Runner.getID());
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                            Runner.setSpawn(move.heroMove(Runner.getSpawn()));
                        }
                        if (res == 2) {
                            Runner.setHP(Runner.getHP() - 1);
                            if (Runner.getHP() == 0) {
                                Runner.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                            res = battle.fight(Runner.getID());
                            if (res == 1) {
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;

                            }
                            if (res == 2) {
                                Runner.setHP(Runner.getHP() - 1);
                                if (Runner.getHP() == 0) {
                                    Runner.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                        if (res == 0) {
                            res = battle.fight(Runner.getID());
                            if (res == 1) {
                                monsters.get(i).setHP(0);
                                monsters.get(i).setSpawn(new int[]{0, 0, 0});
                                enemies--;

                            }
                            if (res == 2) {
                                Runner.setHP(Runner.getHP() - 1);
                                if (Runner.getHP() == 0) {
                                    Runner.setSpawn(new int[]{0, 0, 0});
                                    hero--;
                                }
                            }
                        }
                    } else if (Arrays.equals(monsters.get(i).getSpawn(), Thief.getSpawn()) && !(Arrays.equals(monsters.get(i).getSpawn(), new int[]{0,0,0}))) {
                        int res = battle.fight(Thief.getID());
                        if (res == 1) {
                            monsters.get(i).setHP(0);
                            monsters.get(i).setSpawn(new int[]{0, 0, 0});
                            enemies--;
                        }
                        if (res == 2) {
                            Thief.setHP(Thief.getHP() - 1);
                            if (Thief.getHP() == 0) {
                                Thief.setSpawn(new int[]{0, 0, 0});
                                hero--;
                            }
                        }
                    }
                }
            }

            //check monster location

            // Checks to see if a creature can move
            for (int i = 0; i < 12; i++) {
                //while the creatures is still alive it can move
                if (monsters.get(i).getHP() != 0) {
                    //booleans to check if a creature is in combat with a adventure
                    boolean checkB = Arrays.equals(Brawler.getSpawn(), monsters.get(i).getSpawn());
                    boolean checkS = Arrays.equals(Sneaker.getSpawn(), monsters.get(i).getSpawn());
                    boolean checkR = Arrays.equals(Runner.getSpawn(), monsters.get(i).getSpawn());
                    boolean checkT = Arrays.equals(Thief.getSpawn(), monsters.get(i).getSpawn());
                    if (monsters.get(i).getID() == 1) {
                        //If Orbitor is not in combat then move
                        if (!checkB && !checkS && !checkR && !checkT) {
                            monsters.get(i).setSpawn(move.orbitorsMove2(monsters.get(i).getSpawn(), false));
                        }
                    } else if (monsters.get(i).getID() == 2) {
                        //Checks to see if it can move based on the adventures coordinates
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), Brawler.getSpawn()));
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), Sneaker.getSpawn()));
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), Runner.getSpawn()));
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), Thief.getSpawn()));
                    } else {
                        //If the Blinker is not in combat then move
                        if (!checkB && !checkS && !checkR && !checkT) {
                            monsters.get(i).setSpawn(move.blinkersMove(monsters.get(i).getSpawn(), false));
                        }
                    }
                }
            }
            //For loop to check if a Hero is in combat
            for (int y = 0; y < 12; y++) {
                if (Arrays.equals(Brawler.getSpawn(), monsters.get(y).getSpawn())) {
                    //brawler is in combat can't move
                    BMove = false;
                }
                if (Arrays.equals(Sneaker.getSpawn(), monsters.get(y).getSpawn())) {
                    //Sneaker is in combat can't move
                    SMove = false;
                }
                if (Arrays.equals(Runner.getSpawn(), monsters.get(y).getSpawn())) {
                    //Runner is in combat can't move
                    RMove = false;
                }
                if (Arrays.equals(Thief.getSpawn(), monsters.get(y).getSpawn())) {
                    //Thief is in combat can't move
                    TMove = false;
                }
            }

            //list that determines if an adventure is alive and not in combat then it can move
            if (BMove && Brawler.getHP() != 0) {
                Brawler.setSpawn(move.heroMove(Brawler.getSpawn()));
            }
            if (SMove && Sneaker.getHP() != 0) {
                Sneaker.setSpawn(move.heroMove(Sneaker.getSpawn()));
            }
            if (RMove && Runner.getHP() != 0) {
                Runner.setSpawn(move.heroMove(Runner.getSpawn()));
            }
            if (TMove && Thief.getHP() != 0) {
                Thief.setSpawn(move.heroMove(Thief.getSpawn()));
            }
            round++;
            System.out.println("");
            System.out.println("Brawler - " +Brawler.getTreasure()+ " Treasures(s) - "+Brawler.getHP()+" Damage");
            System.out.println("Sneaker - " +Sneaker.getTreasure()+ " Treasures(s) - " +Sneaker.getHP()+" Damage");
            System.out.println("Runner - " +Runner.getTreasure()+ " Treasures(s) - " +Runner.getHP()+" Damage");
            System.out.println("Thief - " +Thief.getTreasure()+ " Treasures(s) - "+Thief.getHP()+" Damage");
            System.out.println("");
            money = Brawler.getTreasure() + Sneaker.getTreasure() + Runner.getTreasure() + Thief.getTreasure();


        }//end of while loop

//        if(money  >= 10 ){
//            return 0;
//        }else if ( enemies <= 0){
//            return 1;
//        }else {
//            return 2;
//        }
    }
}
