import java.util.ArrayList;
import java.util.Random;
public class Facility {

    public int[] heroMove(int[] heroPlace) {
        int z = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int y = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int x = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int ns = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int ew = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int du = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int direction = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int directionCenter = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
        int moveSpaceCenter = (int) Math.floor(Math.random() * (3 - 0 + 1) + 0);
        int moveSpace = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int[] heroLoc = heroPlace;

        //heroLoc = {z,y,x}


        // if n/s
        if(direction == 0){
            if (heroLoc[1] == 2) {
                // if S
                if (moveSpace == 0) {
                    heroLoc[1] = heroLoc[1] - 1;
                    return heroLoc;
                }
                //if north
                else{
                    //re do direction
                }
            }
            else if (heroLoc[1] == 0){

                // if S
                if (moveSpace == 0) {
                    // re do direction
                }
                // if N
                else{
                    heroLoc[1] = heroLoc[1] + 1;
                    return heroLoc;
                }
            }
            else if (heroLoc[1] == 1){

                // if S
                if (moveSpace == 0) {
                    heroLoc[1] = heroLoc[1] - 1;
                    return heroLoc;
                }
                // if N
                else{
                    heroLoc[1] = heroLoc[1] + 1;
                    return heroLoc;
                }
            }
        }
        else if(direction == 1){
            // if center
            if(heroLoc[1] == 1 && heroLoc[2] == 1){
                // if up/down(level)
                if(directionCenter == 0) {
                    if (heroLoc[0] == 4) {
                        // if down
                        if (moveSpace == 0) {
                            heroLoc[0] = heroLoc[0] - 1;
                            return heroLoc;
                        }
                        //if up
                        else if (moveSpaceCenter == 1) {
                            // redo movement
                        }
                    }
                    if (heroLoc[0] == 0) {
                        // if down
                        if (moveSpace == 0) {
                            // redo movement

                        }
                        //if up
                        else if (moveSpaceCenter == 1) {
                            heroLoc[0] = heroLoc[0] + 1;
                            return heroLoc;
                        }
                    }
                }
            }
            else{
                //redo movment
            }
        }
        // if E/W
        else{
            if (heroLoc[2] == 2) {
                // if E
                if (moveSpace == 0) {
                    heroLoc[2] = heroLoc[2] - 1;
                    return heroLoc;
                }
                //if W
                else{
                    //re do direction
                }
            }
            else if (heroLoc[2] == 0){

                // if E
                if (moveSpace == 0) {
                    // re do direction
                }
                // if W
                else{
                    heroLoc[2] = heroLoc[2] + 1;
                    return heroLoc;
                }
            }
            else if (heroLoc[2] == 1){

                // if E
                if (moveSpace == 0) {
                    heroLoc[2] = heroLoc[2] - 1;
                    return heroLoc;
                }
                // if W
                else{
                    heroLoc[2] = heroLoc[2] + 1;
                    return heroLoc;
                }
            }
        }
        return (heroLoc);
    }

    /*
    ****
    map: 3D object
    first(int) - level
    second(int[]) - room location
    third(String) - people in that room
    ****
        object[0][1][0] = 0-1-1
         object[1][0][0] = Level 1
         object[1][1][0] = 1-0-0
         object[1][2][0] = 1-0-1

     */
    private Object[][][] map = new Object[5][9][5];

    public Facility(){
        //initiate first floor and heroes
        map[0][1][0] = new int[] {0,1,1};
        map[0][0][0] = "B";
        map[0][0][1] = "S";
        map[0][0][2] = "R";
        map[0][0][3] = "T";

        //maps out floors 1 - 4
        for(int i = 1; i < 4; i++){
            int room = 0;
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    room += 1;
                    int[] temp = {i,j,k};
                    map[i][room][0] = temp;
                }
            }
        }
    }

    /*
       map print out example round 0:
       0-1-1: B,S,R,T : -
       1-0-0: - : -       1-0-1: - : -      1-0-2: - : -
       1-1-0: - : -       1-1-1: - : -      1-1-2: - : -
     */
    public void draw(){

        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 3; j++){
                for(int k = 0; k < 3; k++){
                    System.out.printf("%-10s %s\n");
                }
            }
        }
    }

}
