import jdk.jshell.execution.LoaderDelegate;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

public class GameEngine4 extends battle4 implements Observer {

    public static final Scanner scan = new Scanner(System.in);
    battle4 attack = new battle4();
    @Deprecated
    private Logger4 gameUpdate;

    @Override
    @Deprecated
    public void update(Observable observable, Object arg){
        gameUpdate = (Logger4) observable;
    }

    void run(){
        Unit_Test tes = new Unit_Test();
        //observer stuff
        Logger4 observable = new Logger4(null);
        GameEngine4 observer = new GameEngine4();
        observable.addObserver(observer);

        //initiate stuff
        Facility4 move = new Facility4();
        searchAndCombat4 look = new searchAndCombat4();

        //initializing the game and game ending variables
        int money = 6;
        int enemies = 12;
        int hero = 1;
        int roomEnd = 1;
        boolean leftRoom = false;

        //Variables to keep track of turns
        int round = 0;
        int prob = 0;
        String temp = "";

        //Map initialization
        Map4 tower = new Map4();
        int[][][] test = tower.allfloors(); //floor, room coordinates, coordinates index

        //initialization of the characters
        ArrayList<Adventurers_stats4> adventures = new ArrayList<Adventurers_stats4>();

        menu adventerur = new menu();

        //pass chosen adventure with their id
        adventerur.pullMenu();
        String persona = scan.nextLine();
        adventerur.setStart(persona);
        adventures.add(new Adventurers_stats4(adventerur.getStart()));

        //Chooses A name for their hero
        adventerur.name();
        String name = scan.nextLine();
        adventerur.setNames(name);

        //array to hold all creatures
        ArrayList<Creatures_stats4> monsters = new ArrayList<Creatures_stats4>();

        //initializing 12 creatures
        for(int i = 0; i < 4; i++) {
            for (int k = 1; k <= 3; k++) {
                monsters.add(new Creatures_stats4(k));
            }
        }
        //Set the spawn for all Creatures
        for(int i = 0; i< 12; i++){
            monsters.get(i).setSpawn(move.creatureSpawn(monsters.get(i).getID()));
        }

        //array to hold all treasure
        ArrayList<Treasure_stats4> treasures = new ArrayList<Treasure_stats4>();

        //initializing 12 treasure
        for(int i = 0; i < 4; i++) {
            for (int k = 1; k <= 6; k++) {
                treasures.add(new Treasure_stats4(k));
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
        tes.ch_type();
        tes.ch_type2();
        tes.ch_type3();
        tes.ch_type4();
        tes.cre_name();
        tes.cre_name2();
        tes.cre_name3();
        tes.t_name();
        tes.t_name2();
        tes.t_name3();
        tes.t_name4();
        tes.t_name5();
        tes.t_name6();
        tes.ch_s();
        tes.ch_hp();
        //Initialize User options
        Decision choice = new Decision();
        String options = "";
        String dir = "";

        while(hero > 0 && roomEnd > 0){

            //The moment the hero leaves the room the condition is met
            if(!(Arrays.equals(adventures.get(0).getSpawn(), new int[]{0,1,1}))){
                leftRoom = true;
                System.out.println("bird left the house");
            }

            System.setOut(ps);
            //Boolean variables to track if an adventure can move or not
            boolean AMove = true;

            //Print out the number of turns
            System.out.println("Tracker Turn: " + round);
            System.out.println("");

            // Checks to see if a creature can move
            for (int i = 0; i < 12; i++) {
                //while the creatures is still alive it can move
                if (monsters.get(i).getHP() != 0) {
                    //booleans to check if a creature is in combat with an adventure
                    boolean check = Arrays.equals(adventures.get(0).getSpawn(), monsters.get(i).getSpawn());

                    if (monsters.get(i).getID() == 1) {
                        //If Orbitor is not in combat then move
                        if (!check) {
                            monsters.get(i).setSpawn(move.orbitorsMove2(monsters.get(i).getSpawn(), false));
                        }
                    } else if (monsters.get(i).getID() == 2) {
                        //Checks to see if it can move based on the adventures coordinates
                        monsters.get(i).setSpawn(move.seekersMove(monsters.get(i).getSpawn(), adventures.get(0).getSpawn()));
                    } else {
                        //If the Blinker is not in combat then move
                        if (!check) {
                            monsters.get(i).setSpawn(move.blinkersMove(monsters.get(i).getSpawn(), false));
                        }
                    }
                }
            }

            boolean moved = true;
            //User interface commands with program
            choice.command();
            options = scan.nextLine();
            // if fight
            if(options.equals("1")){
                int count = 0;
                // if runner
                if(adventures.get(0).getID() == 3 ){
                    if (AMove && adventures.get(0).getHP() != 0) {
                        for(int i = 0; i < adventures.get(0).getTreasure().size(); i++) {
                            if (adventures.get(0).getTreasure().get(i).equals("Teleport")) {
                                adventures.get(0).setSpawn(move.teleport());
                                moved = false;
                            }
                        }
                        if(moved){
//                            move.ifmove(adventures.get(0).getSpawn());
                            dir = scan.nextLine();
                            adventures.get(0).setSpawn(move.heroMove(adventures.get(0).getSpawn(), dir));
                        }
                    }
                    choice.command();
                    options = scan.nextLine();

                    if(options.equals("1")){
                        if (AMove && adventures.get(0).getHP() != 0) {
                            for(int i = 0; i < adventures.get(0).getTreasure().size(); i++) {
                                if (adventures.get(0).getTreasure().get(i).equals("Teleport")) {
                                    adventures.get(0).setSpawn(move.teleport());
                                    moved = false;
                                }
                            }
                            if(moved){
//                                move.ifmove(adventures.get(0).getSpawn());
                                dir = scan.nextLine();
                                adventures.get(0).setSpawn(move.heroMove(adventures.get(0).getSpawn(), dir));
                            }
                        }
                    }
                }
                else{
                    //list that determines if an adventure is alive and not in combat then it can move
                    // if player moves from a room= that has a active creature it takes damage
                    for(int k = 0; k < 12; k++){
                        if (Arrays.equals(adventures.get(0).getSpawn(), monsters.get(k).getSpawn()) && monsters.get(k).getHP() != 0 && adventures.get(0).getHP() != 0){
                            adventures.get(0).setHP(adventures.get(0).getHP() - 1);
                        }
                    }

                    if(adventures.get(0).getHP() <= 0){
                        hero--;
                        break;
                    }

                    if (AMove && adventures.get(0).getHP() != 0) {
                        for(int i = 0; i < adventures.get(0).getTreasure().size(); i++) {
                            if (adventures.get(0).getTreasure().get(i).equals("Teleport")) {
                                adventures.get(0).setSpawn(move.teleport());
                                moved = false;
                            }
                        }
                        if(moved){
                            //Print out menu
//                            move.ifmove(adventures.get(0).getSpawn());
                            dir = scan.nextLine();
                            adventures.get(0).setSpawn(move.heroMove(adventures.get(0).getSpawn(), dir));
                        }
                    }
                }

            }
            // if Search
            else if(options.equals("2")){
                //Search
                for(int i = 0; i < 24; i++){
                    if(Arrays.equals(adventures.get(0).getSpawn(), treasures.get(i).getSpawn())){
                        prob = look.search(adventures.get(0).getID(), adventures.get(0).getTreasure(), treasures.get(i).getID(), treasures.get(i).getName());
                        if(prob == 1 && treasures.get(i).getID() != 5){
                            adventures.get(0).setTreasure(treasures.get(i).getName());
                            treasures.get(i).setSpawn(new int[] {-1,-1,-1});
                            money--;
                        }else if (prob == 1 && treasures.get(i).getID() == 4) {
                            adventures.get(0).setSpawn(move.teleport());
                            adventures.get(0).setTreasure(treasures.get(i).getName());
                            treasures.get(i).setSpawn(new int[] {-1,-1,-1});
                            money--;
                        }else if((prob == 1 || prob == 3) && treasures.get(i).getID() == 5){
                            adventures.get(0).setHP(adventures.get(0).getHP() - 1);
                            adventures.get(0).setTreasure(treasures.get(i).getName());
                            treasures.get(i).setSpawn(new int[] {-1,-1,-1});
                            money--;
                        }else if (prob == 2){
                            adventures.get(0).setTreasure(treasures.get(i).getName());
                            treasures.get(i).setSpawn(new int[] {-1,-1,-1});
                            money--;
                        }else{
                            System.out.println("Nothing Happened");
                            break;
                        }
                    }
                }
            }
            // if Celebrate
            else if(options.equals("3")){
                //Celebrate
                System.out.println(adventures.get(0).getName()+ " "+adventerur.getNames()+": " + attack.party());
            }
            // if fight
            if(options.equals("4")){
                //fight
                for(int k = 0; k < 12; k++){
                    if (Arrays.equals(adventures.get(0).getSpawn(), monsters.get(k).getSpawn()) && monsters.get(k).getHP() != 0 && adventures.get(0).getHP() != 0){
                        int[] attack_res = attack.fight(adventures.get(0).getSpawn(), adventures.get(0).getID(), adventures.get(0).getHP(), adventures.get(0).getName(), monsters.get(k).getHP(),monsters.get(k).getSpawn(), adventures.get(0).getTreasure());
//                        System.out.print(Arrays.toString(attack_res));
                        if(attack_res[0] == 0){
                            adventures.get(0).setSpawn(new int[] {0,0,0});
                            adventures.get(0).setHP(0);
                            hero--;
                        }
                        else if(attack_res[1] == 0){
                            monsters.get(k).setSpawn(new int[] {0,0,0});
                            monsters.get(k).setHP(0);
                            enemies--;
                        }
                        else if (attack_res[0] > 0){
                            adventures.get(0).setHP(attack_res[0]);
                        }
                    }
                }
            }

            //Prints out the entrance floor layout and checks if anyone is in there
            for (int i = 0; i < 1; i++) {
                System.out.print(test[i][0][0] + "-" + test[i][0][1] + "-" + test[i][0][2] + ": ");
                if (Arrays.equals(adventures.get(0).getSpawn(), test[i][0])) {
                    System.out.print(adventerur.getNames());
                }else{
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
                        temp += name + ", ";
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

            //Check to see if the hero comes back to start
            if(leftRoom == true && Arrays.equals(adventures.get(0).getSpawn(), new int[] {0,1,1})){
                if(enemies == 0 || money == 0){
                    System.out.println("You won");
                    roomEnd = 0;
                }
                else{
                    System.out.println("You lost");
                    roomEnd = 0;
                }
            }
            round++;
            //The printout everything properly in here
            System.out.printf("%-10s %-10s %-10s %-10s %s", "Name","Adventures", "Damage", "Room", "Treasure");
            System.out.println("");

            System.out.printf("%-10s %-10s %-10s %-10s %s", adventerur.getNames(), adventures.get(0).getName(), adventures.get(0).getHP(), Arrays.toString(adventures.get(0).getSpawn()), adventures.get(0).getTreasure().toString());
            System.out.println("");

            System.out.println("Total Active Creatures: " + enemies);

            //tracker takes in bytearrayoutput and returns a normal System.out()
            System.out.flush();
            System.setOut(old);
            observable.setInputs(baos.toString());
            observable.Tracker(baos.toString());
            baos.reset();

        }//end of while loop
        //logger write and create txt file
        observable.createFile(round);
        observable.writeFile(observable.getInputs());


    }
}
