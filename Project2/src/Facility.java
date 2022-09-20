import java.util.ArrayList;
import java.util.Random;
public class Facility {

    public int[] heroMove(int[] heroPlace) {
        int direction = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int moveSpace = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int[] heroLoc = heroPlace;

        //heroLoc = {z,y,x}

        if(heroLoc[0] == 0 && heroLoc[1] == 1 && heroLoc[2] == 1){
            heroLoc[0] = heroLoc[0] - 1;
            return heroLoc;
        }

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
                    heroMove(heroPlace);
                }
            }
            else if (heroLoc[1] == 0){

                // if S
                if (moveSpace == 0) {
                    heroMove(heroPlace);
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
                if (heroLoc[0] == 4) {
                    // if down
                    if (moveSpace == 0) {
                        heroLoc[0] = heroLoc[0] - 1;
                        return heroLoc;
                    }
                    //if up
                    else if (moveSpace == 1) {
                        heroMove(heroPlace);
                    }
                }
                else if (heroLoc[0] == 1) {
                    // if down
                    if (moveSpace == 0) {
                        heroMove(heroPlace);

                    }
                    //if up
                    else if (moveSpace == 1) {
                        heroLoc[0] = heroLoc[0] + 1;
                        return heroLoc;
                    }
                }
                else if (heroLoc[0] >= 2 || heroLoc[0] <= 3 ) {
                    // if down
                    if (moveSpace == 0) {
                        heroLoc[0] = heroLoc[0] - 1;
                        return heroLoc;

                    }
                    //if up
                    else if (moveSpace == 1) {
                        heroLoc[0] = heroLoc[0] + 1;
                        return heroLoc;
                    }
                }
            }
            else{
                heroMove(heroPlace);
            }
        }
        // if E/W
        else{
            if (heroLoc[2] == 2) {
                // if w
                if (moveSpace == 0) {
                    heroLoc[2] = heroLoc[2] - 1;
                    return heroLoc;
                }
                //if E
                else{
                    heroMove(heroPlace);
                }
            }
            else if (heroLoc[2] == 0){

                // if W
                if (moveSpace == 0) {
                    heroMove(heroPlace);
                }
                // if E
                else{
                    heroLoc[2] = heroLoc[2] + 1;
                    return heroLoc;
                }
            }
            else if (heroLoc[2] == 1){

                // if W
                if(moveSpace == 0) {
                    heroLoc[2] = heroLoc[2] - 1;
                    return heroLoc;
                }
                // if E
                else{
                    heroLoc[2] = heroLoc[2] + 1;
                    return heroLoc;
                }
            }
        }
        return (heroLoc);
    }
    public int[][] creaturesSpawn() {
        int x = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int y = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int z = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        int[] orbiter_Spawn = new int[3];
        if(x != 1 && y !=1){
            orbiter_Spawn = new int[]{z, y, x};
        }
        int[] seekers_Spawn = new int[]{z,y,x};
        int[] blinkers_Spawn = new int[]{4,y,x};
        int[][] creatureS = {seekers_Spawn,blinkers_Spawn,orbiter_Spawn};
        return creatureS;
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
        int[] start = {0,1,1};
        map[0][1][0] = start;
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
                    if(k == 0 && j == 0){
                        Object room = map[i][j][k];
                        System.out.printf("%s %s\n");
                    }
                }
            }
        }
    }

}
