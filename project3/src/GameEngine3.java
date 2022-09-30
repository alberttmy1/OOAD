import jdk.jshell.execution.LoaderDelegate;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Observable;
import java.util.Observer;

public class GameEngine3 extends battle3 implements Observer {
    battle3 attack = new battle3();
    @Deprecated
    private Logger gameUpdate;

    @Override
    @Deprecated
    public void update(Observable observable, Object arg){
        gameUpdate = (Logger) observable;
    }

    void run(){

        //observer stuff
        Logger observable = new Logger(null);
        GameEngine3 observer = new GameEngine3();
        observable.addObserver(observer);

        //initiate stuff
        Facility3 move = new Facility3();
        searchAndCombat look = new searchAndCombat();

        //initializing the game and game ending variables
        int money = 24;
        int enemies = 12;
        int hero = 4;

        //Variables to keep track of turns
        int round = 0;
        int prob = 0;
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


        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;

        /*
        *Continue to run until either they collect all the treasure(money), all the creatures(enemies),
        * or all the Adventures(hero) die
         */

        while( money > 0 && enemies > 0 && hero > 0){
            System.setOut(ps);
            //Boolean variables to track if an adventure can move or not
            boolean BMove = true;
            boolean SMove = true;
            boolean RMove = true;
            boolean TMove = true;

            //Print out the number of turns
            System.out.println("Tracker Turn: " + round);
            System.out.println("");
            //Prints out the entrance floor layout and checks if anyone is in there
//            for (int i = 0; i < 1; i++) {
//                System.out.print(test[i][0][0] + "-" + test[i][0][1] + "-" + test[i][0][2] + ": ");
//                if (Arrays.equals(adventures.get(0).getSpawn(), test[i][0])) {
//                    System.out.print("B, ");
//                }
//                if (Arrays.equals(adventures.get(1).getSpawn(), test[i][0])) {
//                    System.out.print("S, ");
//                }
//                if (Arrays.equals(adventures.get(2).getSpawn(), test[i][0])) {
//                    System.out.print("R, ");
//                }
//                if (Arrays.equals(adventures.get(3).getSpawn(), test[i][0])) {
//                    System.out.print("T, ");
//                } else {
//                    System.out.print("");
//                }
//            }
//            System.out.println("");
//
//            //Print out floors 1-4
//            for (int j = 1; j < 5; j++) {
//                for (int k = 0; k < 9; k++) {
//                    if (k % 3 == 0) {
//                        System.out.println("");
//                    }
//                    String coor = test[j][k][0] + "-" + test[j][k][1] + "-" + test[j][k][2] + ": ";
//                    if (Arrays.equals(adventures.get(0).getSpawn(), test[j][k])) {
//                        temp += "B, ";
//                    }
//                    if (Arrays.equals(adventures.get(1).getSpawn(), test[j][k])) {
//                        temp += "S, ";
//                    }
//                    if (Arrays.equals(adventures.get(2).getSpawn(), test[j][k])) {
//                        temp += "R, ";
//                    }
//                    if (Arrays.equals(adventures.get(3).getSpawn(), test[j][k])) {
//                        temp += "T, ";
//                    }
//                    for (int m = 0; m < 12; m++) {
//                        if (Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 1) {
//                            temp += "OB, ";
//                        }
//                        if (Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 2) {
//                            temp += "SE, ";
//                        }
//                        if (Arrays.equals(monsters.get(m).getSpawn(), test[j][k]) && monsters.get(m).getID() == 3) {
//                            temp += "BL, ";
//                        }
//                    }
//                    for (int i = 0; i < 24; i++) {
//                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 1) {
//                            temp += "SW, ";
//                        }
//                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 2) {
//                            temp += "GE, ";
//                        }
//                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 3) {
//                            temp += "AR, ";
//                        }
//                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 4) {
//                            temp += "PO, ";
//                        }
//                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 5) {
//                            temp += "TR, ";
//                        }
//                        if (Arrays.equals(treasures.get(i).getSpawn(), test[j][k]) && treasures.get(i).getID() == 6) {
//                            temp += "POT, ";
//                        }
//                    }
//
//                    System.out.printf("%s %-15s", coor, temp);
//                    temp = "";
//                }
//                System.out.println("");
//            }
//
//            System.out.println("");



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
                for(int z = 0; z < 4; z++){
                    if(Arrays.equals(adventures.get(z).getSpawn(),monsters.get(y).getSpawn())){
                        if(adventures.get(z).getID() == 1){
                            BMove = false;
                        }else if(adventures.get(z).getID() == 2){
                            SMove = false;
                        }else if(adventures.get(z).getID() == 3) {
                            RMove = false;
                        }else if (adventures.get(z).getID() == 4){
                            TMove = false;
                        }
                    }
                }
            }

            //Combat
            for(int i = 0; i < 4; i++){
                for(int k = 0; k < 12; k++){
                    if (Arrays.equals(adventures.get(i).getSpawn(), monsters.get(k).getSpawn()) && monsters.get(k).getHP() != 0 && adventures.get(i).getHP() != 0){
                        int[] attack_res = attack.fight(adventures.get(i).getSpawn(), adventures.get(i).getID(), adventures.get(i).getHP(), adventures.get(i).getName(), monsters.get(k).getHP(),monsters.get(k).getSpawn(), adventures.get(i).getTreasure());
//                        System.out.print(Arrays.toString(attack_res));
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
            for(int i = 0; i < 4; i++){
                for(int j = 0; j < 24; j++){
                    if(Arrays.equals(treasures.get(j).getSpawn(), adventures.get(i).getSpawn())) {
                        prob = look.search(adventures.get(i).getID(), adventures.get(i).getTreasure(), treasures.get(j).getID(), treasures.get(j).getName());
                        //got the treasure
                        if(prob == 1 && treasures.get(j).getID() != 5){
                            //add item to adventure inventory
                            adventures.get(i).setTreasure(treasures.get(j).getName());
                            //remove the treasure
                            treasures.get(j).setSpawn(new int[] {-1,-1,-1});
                            money--;
                        }else if(prob == 1 && treasures.get(j).getID() == 5){
                            adventures.get(i).setHP(adventures.get(i).getHP() - 1);
                            treasures.get(j).setSpawn(new int[] {-1,-1,-1});
                            money--;
                            if(adventures.get(i).getHP() == 0){
                                adventures.get(i).setSpawn(new int[] {0,0,0});
                                hero--;
                            }
                        }else if(prob == 2){
                            treasures.get(j).setSpawn(new int[] {-1,-1,-1});
                            money--;
                        }else if(prob == 3){
                            treasures.get(j).setSpawn(new int[] {-1,-1,-1});
                            money--;
                            adventures.get(i).setHP(adventures.get(i).getHP() - 1);
                            if(adventures.get(i).getHP() == 0){
                                adventures.get(i).setSpawn(new int[] {0,0,0});
                                hero--;
                            }
                        }
                    }
                }
            }

            round++;
            //The printout everything properly in here
            System.out.println("Total Active Adventures: " + hero);
            System.out.printf("%-10s %-10s %-10s %s", "Adventures", "Room", "Damage", "Treasure");
            System.out.println("");
            for(int i = 0; i < 4; i++){
                System.out.printf("%-10s %-10s %-10s %s",adventures.get(i).getName(), Arrays.toString(adventures.get(i).getSpawn()), adventures.get(i).getHP(),adventures.get(i).getTreasure().toString());
                System.out.println("");
            }
            System.out.println("");

//            System.out.println("Brawler - " +adventures.get(0).getTreasure()+ " Treasures(s) - "+adventures.get(0).getHP()+" Damage");
//            System.out.println("Sneaker - " +adventures.get(1).getTreasure()+ " Treasures(s) - " +adventures.get(1).getHP()+" Damage");
//            System.out.println("Runner - " +adventures.get(2).getTreasure()+ " Treasures(s) - " +adventures.get(2).getHP()+" Damage");
//            System.out.println("Thief - " +adventures.get(3).getTreasure()+ " Treasures(s) - "+adventures.get(3).getHP()+" Damage");
//            System.out.println("");
//
//            System.out.println("Hero: "+ hero);
//            System.out.println("Treasure: " + money);
//            System.out.println("Creatures: "+ enemies);

            System.out.println("Total Active Creatures: " + enemies);
            System.out.printf("%-10s %s", "Creatures", "Room");
            System.out.println("");
            for(int i = 0; i < 12; i++){
                System.out.printf("%-10s %s",monsters.get(i).getName(), Arrays.toString(monsters.get(i).getSpawn()));
                System.out.println("");
            }

            //tracker takes in bytearrayoutput and returns a normal System.out()
            System.out.flush();
            System.setOut(old);
            observable.setInputs(baos.toString());
            observable.Tracker(baos.toString());
            baos.reset();

        }//end of while loop
        System.out.println("End");
        //logger write and create txt file
        observable.createFile(round);
        observable.writeFile(observable.getInputs());
//        if(hero == 0){
//            return 0;
//        }else if(enemies == 0){
//            return 1;
//        }else{
//            return 2;
//        }

    }
}
