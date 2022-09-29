import jdk.jshell.execution.LoaderDelegate;
import java.util.ArrayList;
import java.util.Arrays;

public class GameEngine3{
battle3 attack = new battle3();
    void run(){
        //Initiate Facility
        Facility3 move = new Facility3();

        //initializing the game and game ending variables
        int money = 24;
        int enemies = 12;
        int hero = 4;

        //Variables to keep track of turns
        int round = 0;
        String temp = "";

        //Map initialization
        Map3 tower = new Map3();
        int[][][] test = tower.allfloors(); //floor, room coordinates, coordinates index

        //initialization of the characters
        ArrayList<Adventurers_stats3> adventures = new ArrayList<Adventurers_stats3>();

        //pass all 4 adventures with their id's
        for(int i = 1; i < 5; i++){
            adventures.add(new Adventurers_stats3(i));
        }

        //array to hold all creatures
        ArrayList<Creatures_stats3> monsters = new ArrayList<Creatures_stats3>();

        //initializing 12 creatures
        for(int i = 0; i < 4; i++) {
            for (int k = 1; k <= 3; k++) {
                monsters.add(new Creatures_stats3(k));
            }
        }
        //Set the spawn for all Creatures
        for(int i = 0; i< 12; i++){
            monsters.get(i).setSpawn(move.creatureSpawn(monsters.get(i).getID()));
        }

        //array to hold all treasure
        ArrayList<Treasure_stats> treasures = new ArrayList<Treasure_stats>();

        //initializing 12 treasure
        for(int i = 0; i < 4; i++) {
            for (int k = 1; k <= 6; k++) {
                treasures.add(new Treasure_stats(k));
            }
        }

        //Set the spawn for all treasures
        for(int i = 0; i< 24; i++){
            treasures.get(i).setSpawn(move.treasureSpawn(treasures.get(i).getID()));
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

            //Print out the number of turns
            System.out.println("Turn: " + round);
            //Prints out the entrance floor layout and checks if anyone is in there
            for (int i = 0; i < 1; i++) {
                System.out.print(test[i][0][0] + "-" + test[i][0][1] + "-" + test[i][0][2] + ": ");
                if (Arrays.equals(adventures.get(0).getSpawn(), test[i][0])) {
                    System.out.print("B, ");
                }
                if (Arrays.equals(adventures.get(1).getSpawn(), test[i][0])) {
                    System.out.print("S, ");
                }
                if (Arrays.equals(adventures.get(2).getSpawn(), test[i][0])) {
                    System.out.print("R, ");
                }
                if (Arrays.equals(adventures.get(3).getSpawn(), test[i][0])) {
                    System.out.print("T, ");
                } else {
                    System.out.print("");
                }
            }
            System.out.println("");

            //Print out floors 1-4
            for (int j = 1; j < 5; j++) {
                for (int k = 0; k < 9; k++) {
                    if (k % 3 == 0) {
                        System.out.println("");
                    }
                    String coor = test[j][k][0] + "-" + test[j][k][1] + "-" + test[j][k][2] + ": ";
                    if (Arrays.equals(adventures.get(0).getSpawn(), test[j][k])) {
                        temp += "B, ";
                    }
                    if (Arrays.equals(adventures.get(1).getSpawn(), test[j][k])) {
                        temp += "S, ";
                    }
                    if (Arrays.equals(adventures.get(2).getSpawn(), test[j][k])) {
                        temp += "R, ";
                    }
                    if (Arrays.equals(adventures.get(3).getSpawn(), test[j][k])) {
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
                    for (int i = 0; i < 24; i++) {
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 1) {
                            temp += "SW, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 2) {
                            temp += "GE, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 3) {
                            temp += "AR, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 4) {
                            temp += "PO, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 5) {
                            temp += "TR, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 6) {
                            temp += "POT, ";
                        }
                    }

                    System.out.printf("%s %-15s", coor, temp);
                    temp = "";
                }
                System.out.println("");
            }

            System.out.println("");



            // Checks to see if a creature can move
            for (int i = 0; i < 12; i++) {
                //while the creatures is still alive it can move
                if (monsters.get(i).getHP() != 0) {
                    //booleans to check if a creature is in combat with an adventure
                    boolean checkB = Arrays.equals(adventures.get(0).getSpawn(), monsters.get(i).getSpawn());
                    boolean checkS = Arrays.equals(adventures.get(1).getSpawn(), monsters.get(i).getSpawn());
                    boolean checkR = Arrays.equals(adventures.get(2).getSpawn(), monsters.get(i).getSpawn());
                    boolean checkT = Arrays.equals(adventures.get(3).getSpawn(), monsters.get(i).getSpawn());
                    if (monsters.get(i).getID() == 1) {
                        //If Orbitor is not in combat then move
                        if (!checkB && !checkS && !checkR && !checkT) {
                            monsters.get(i).setSpawn(move.orbitorsMove2(monsters.get(i).getSpawn(), false));
                        }
                    } else if (monsters.get(i).getID() == 2) {
                        //Checks to see if it can move based on the adventures coordinates
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), adventures.get(0).getSpawn()));
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), adventures.get(1).getSpawn()));
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), adventures.get(2).getSpawn()));
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), adventures.get(3).getSpawn()));
                    } else {
                        //If the Blinker is not in combat then move
                        if (!checkB && !checkS && !checkR && !checkT) {
                            monsters.get(i).setSpawn(move.blinkersMove(monsters.get(i).getSpawn(), false));
                        }
                    }
                }
            }

            boolean moved = true;
            //list that determines if an adventure is alive and not in combat then it can move
            if (BMove && adventures.get(0).getHP() != 0) {

                for(int i = 0; i < adventures.get(0).getTreasure().size(); i++) {
                    if (adventures.get(0).getTreasure().get(i) == "Teleport") {
                        adventures.get(0).setSpawn(move.teleport());
                        moved = false;
                    }
                }
                if(moved){
                    adventures.get(0).setSpawn(move.heroMove(adventures.get(0).getSpawn()));
                }
            }
            if (SMove && adventures.get(1).getHP() != 0) {
                for(int i = 0; i < adventures.get(1).getTreasure().size(); i++) {
                    if (adventures.get(1).getTreasure().get(i) == "Teleport") {
                        adventures.get(1).setSpawn(move.teleport());
                        moved = false;
                    }
                }
                if(moved){
                    adventures.get(1).setSpawn(move.heroMove(adventures.get(1).getSpawn()));
                }
            }
            if (RMove && adventures.get(2).getHP() != 0) {
                for(int i = 0; i < adventures.get(2).getTreasure().size(); i++) {
                    if (adventures.get(2).getTreasure().get(i) == "Teleport") {
                        adventures.get(2).setSpawn(move.teleport());
                        moved = false;

                    }
                }
                if(moved){
                    adventures.get(2).setSpawn(move.heroMove(adventures.get(2).getSpawn()));
                }
            }
            if (TMove && adventures.get(3).getHP() != 0) {
                for(int i = 0; i < adventures.get(3).getTreasure().size(); i++) {
                    if (adventures.get(3).getTreasure().get(i) == "Teleport") {
                        adventures.get(3).setSpawn(move.teleport());
                        moved = false;

                    }
                }
                if(moved){
                    adventures.get(3).setSpawn(move.heroMove(adventures.get(3).getSpawn()));
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

            //Combat
            for(int i = 0; i < 4; i++){
                for(int k = 0; k < 12; k++){
                    if (Arrays.equals(adventures.get(i).getSpawn(), monsters.get(k).getSpawn()) && monsters.get(k).getHP() != 0 && adventures.get(i).getHP() != 0){
                        int[] attack_res = attack.fight(adventures.get(i).getSpawn(), adventures.get(i).getID(), adventures.get(i).getHP(), adventures.get(i).getName(), monsters.get(k).getHP(),monsters.get(k).getSpawn(), adventures.get(i).getTreasure());
                        System.out.print(Arrays.toString(attack_res));
                        if(attack_res[0] == 0){
                            adventures.get(i).setSpawn(new int[] {0,0,0});
                            adventures.get(i).setHP(0);
                            hero--;
                        }
                        else if(attack_res[1] == 0){
                            monsters.get(k).setSpawn(new int[] {0,0,0});
                            monsters.get(k).setHP(0);
                            enemies--;
                        }
                        else if (attack_res[0] > 0){
                            adventures.get(i).setHP(attack_res[0]);
                        }
                    }
                }
            }

            //Roll for treasure
            for(int i = 0; i < 24; i++){

            }

            //Print out the number of turns
            System.out.println("Turn: " + round);
            //Prints out the entrance floor layout and checks if anyone is in there
            for (int i = 0; i < 1; i++) {
                System.out.print(test[i][0][0] + "-" + test[i][0][1] + "-" + test[i][0][2] + ": ");
                if (Arrays.equals(Brawler.getSpawn(), test[i][0])) {
                    System.out.print("B, ");
                }
                if (Arrays.equals(Sneaker.getSpawn(), test[i][0])) {
                    System.out.print("S, ");
                }
                if (Arrays.equals(Runner.getSpawn(), test[i][0])) {
                    System.out.print("R, ");
                }
                if (Arrays.equals(Thief.getSpawn(), test[i][0])) {
                    System.out.print("T, ");
                } else {
                    System.out.print("");
                }
            }
            System.out.println("");

            //Print out floors 1-4
            for (int j = 1; j < 5; j++) {
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
                    for (int i = 0; i < 24; i++) {
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 1) {
                            temp += "SW, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 2) {
                            temp += "GE, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 3) {
                            temp += "AR, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 4) {
                            temp += "PO, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 5) {
                            temp += "TR, ";
                        }
                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 6) {
                            temp += "POT, ";
                        }
                    }

                    System.out.printf("%s %-15s", coor, temp);
                    temp = "";
                }
                System.out.println("");
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
            //money = Brawler.getTreasure() + Sneaker.getTreasure() + Runner.getTreasure() + Thief.getTreasure();


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
