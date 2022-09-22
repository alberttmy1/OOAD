import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

// this is a example of polymorphism as its a class of movements and each character has its own version of how it moves
public class Facility {
// this class is an example of cohesion as it focuses on the location of charachte
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
            // Checks if y is at the end room
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
            // Checks if y is at the beginning room
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
            //if its in the middle it can move freely
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
        // if up or down levels
        else if(direction == 1){
            // if in center room 
            if(heroLoc[1] == 1 && heroLoc[2] == 1){
                // if at top floor
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
                // if at bottom floor 
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
                //if its floor 2 or 3 it can move freely
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
            // if not in the center room
            else{
                heroMove(heroPlace);
            }
        }
        // if E/W
        else{
            // checks if its at the most eastern room
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
            // checks if its at the most western room
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
            //if in middle room they can move freely
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

    //this an example of abstraction
    public int [] creatureSpawn(int id){
        // randomizes coordinates for creatures to spawn
        int x = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int y = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int z = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        int[] orbiter_Spawn = new int[3];
        int[] temp = new int[0];
        //if orbitior
        if (id == 1) {
            //makes sure it cant spawn in the middle room
            if(x != 1 && y !=1){
                orbiter_Spawn = new int[]{z, y, x};
                return orbiter_Spawn;
            }
            else{
                creatureSpawn(1);
            }
        }
        // if seeker
        if (id == 2){
            // sets spawn to random coords 
            int[] seekers_Spawn = new int[]{z,y,x};
            return seekers_Spawn;
        }
        // if blinker
        else{
            //allos blinkers to spawn at an room in room 4
            int[] blinkers_Spawn = new int[]{4,y,x};
            return blinkers_Spawn;
        }

    }



    public int[] blinkersMove(int[] creaturePlace, boolean flight){
        int z =  creaturePlace[0];
        int y =  creaturePlace[1];
        int x =  creaturePlace[2];
        int[] temp = new int[3];
        // if its in the same room as adventure it wont move
        if(flight){
            return creaturePlace;
        }
        // moves to another position
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

    public int[] orbitorsMove2(int[]  creaturePlace, boolean flight) {
        int z = creaturePlace[0];
        int y = creaturePlace[1];
        int x = creaturePlace[2];
        // if its in the same room as adventure it wont move
        if(flight) {
            return creaturePlace;
        }
        // move to different rooms on the same floor
        else{
            int tempX = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            int tempY = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
            //makes sure its not in middle room

            if(tempX == 1 && tempY == 1){
                //System.out.println("Bitch:" +tempX +tempY);
                return new int[]{z, tempY+1, tempX};
            }
            return new int[]{z, tempY, tempX};
        }
    }

    public int[] seekersMove(int[]  creaturePlace, int[] heroLoc) {
        int z =  creaturePlace[0];
        int y =  creaturePlace[1];
        int x =  creaturePlace[2];
        int[] temp = new int[3];
        // checks if its the same room as a adventurer
        if (z == heroLoc[0] && y == heroLoc[1] && x == heroLoc[2]) {
            temp = new int[]{z, y, x};
            return temp;
        }
        //checks if adventurer is to the right or or above
        else if(z == heroLoc[0] && (y <2 &&(y +1 == (heroLoc[1])) || (x < 2 && (x+1 == (heroLoc[2]))))){
            y = heroLoc[1];
            x = heroLoc[2];
            // battle
            temp = new int[]{z, y, x};
            return temp;
        }
        //checks if an adventurer is behind or to the left
        else if(z == heroLoc[0] && ((y>0 && (y - 1 == (heroLoc[1]))) || (x>0 && (x-1 == (heroLoc[2]))))){
            y = heroLoc[1];
            x = heroLoc[2];
            // battle
            temp = new int[]{z, y, x};
            return temp;
        }
        // if nothing is around it dont move
        else {
            temp = new int[]{z, y, x};
            return temp;
        }
    }

    public int getTresure(int id){
        // checks if its higher than a 10 to get treasure
        int dice_1 = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        int dice_2 = (int) Math.floor(Math.random() * (6 - 1 + 1) + 1);
        int sum = dice_1 + dice_2;
        // if its a Theif it adds one to the roll
        if(id == 4){
            sum += 1;
        }
        // you got treasure
        if(sum >= 10){
            return 1;
        }
        // you didnt get treasure
        else{
            return 0;
        }
    }

    public int chance(){
        int chance = (int) Math.floor(Math.random() * (2- 1 + 1) + 1);

        if(chance == 1){
            return chance;
        }
        return chance;
    }
}
