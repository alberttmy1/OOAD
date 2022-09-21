import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;
public class Facility {

    public int[] heroMove(int[] heroPlace) {
//        System.out.println("hero: " + Arrays.toString(heroPlace));
        int direction = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int moveSpace = (int) Math.floor(Math.random() * (1 - 0 + 1) + 0);
        int[] heroLoc = heroPlace;

        //heroLoc = {z,y,x}

        if(heroLoc[0] == 0 && heroLoc[1] == 1 && heroLoc[2] == 1){
            heroLoc[0] = heroLoc[0] + 1;
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
        return heroLoc;
    }

    public int [] creatureSpawn(int id){
        int x = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int y = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int z = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        int[] orbiter_Spawn = new int[3];
        int[] temp = new int[0];
        if (id == 1) {
            if(x != 1 && y !=1){
                orbiter_Spawn = new int[]{z, y, x};
                return orbiter_Spawn;
            }
            else{
                creatureSpawn(1);
            }
        }
        if (id == 2){
            int[] seekers_Spawn = new int[]{z,y,x};
            return seekers_Spawn;
        }
        else{
            int[] blinkers_Spawn = new int[]{4,y,x};
            return blinkers_Spawn;
        }

    }

    public int[] blinkersMove(int[] creaturePlace, int[] heroLoc){
        int z =  creaturePlace[0];
        int y =  creaturePlace[1];
        int x =  creaturePlace[2];
        int[] temp = new int[3];

        if(z == heroLoc[0] && y == heroLoc[1] && x == heroLoc[2]){
            temp = new int[]{z, y, x};
            return temp;

        }
        else{
            int tempX = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            int tempY = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            int tempZ = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);

            z = tempZ;
            y = tempY;
            x = tempX;

            temp = new int[]{z, y, x};
            return temp;
        }
    }

    public int[] orbitorsMove2(int[]  creaturePlace, int[] heroLoc) {
        int z = creaturePlace[0];
        int y = creaturePlace[1];
        int x = creaturePlace[2];

        if(z == heroLoc[0] && y == heroLoc[1] && x == heroLoc[2]){

            return creaturePlace;
        }else{
            int tempX = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            int tempY = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            return new int[]{z, tempY, tempX};
        }
    }
    public int[] seekersMove(int[]  creaturePlace, int[] heroLoc) {
        int z =  creaturePlace[0];
        int y =  creaturePlace[1];
        int x =  creaturePlace[2];
        int[] temp = new int[3];
        if (z == heroLoc[0] && y == heroLoc[1] && x == heroLoc[2]) {
            temp = new int[]{z, y, x};
            return temp;
        }
        else if(z == heroLoc[0] && (y <2 &&(y +1 == (heroLoc[1])) || (x < 2 && (x+1 == (heroLoc[2]))))){
            y = heroLoc[1];
            x = heroLoc[2];
            // battle
            temp = new int[]{z, y, x};
            return temp;
        }
        else if(z == heroLoc[0] && ((y>0 && (y - 1 == (heroLoc[1]))) || (x>0 && (x-1 == (heroLoc[2]))))){
            y = heroLoc[1];
            x = heroLoc[2];
            // battle
            temp = new int[]{z, y, x};
            return temp;
        }
        else {
            temp = new int[]{z, y, x};
            return temp;
        }
    }
    public int getTresure(){
        int dice_1 = (int) Math.floor(Math.random() * (6 - 1 + 1) + 0);
        int dice_2 = (int) Math.floor(Math.random() * (6 - 1 + 1) + 0);

        if((dice_1 + dice_2) > 10){
            return 1;
        }
        else{
            return 0;
        }
    }
}
