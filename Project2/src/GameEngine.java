import java.util.ArrayList;
import java.util.Arrays;

public class GameEngine {

    void run(){
        Facility move = new Facility();
        //initializing the game and game ending variables
        int money = 0;
        int enemies = 12;
        int hero = 4;
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
        for(int i = 0; i < 5; i++) {
            for (int k = 0; k < 4; k++) {
                monsters.add(new Creatures_stats(k));
            }
        }

        //money != 10 || enemies != 0 || hero !=0)
        while(round != 10){
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
                    }else{
                        temp += "e";
                    }
                    System.out.printf("%s %-15s", coor, temp );
                    temp = "";
                }
                System.out.println("");
            }

            Brawler.setSpawn(move.heroMove(Brawler.getSpawn()));
            //Sneaker.setSpawn(move.heroMove(Sneaker.getSpawn()));
            round++;
        }//end of while
    }
}