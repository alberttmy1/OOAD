import java.util.Scanner;

// this is a example of polymorphism as its a class of movements and each character has its own version of how it moves
public class Facility4 {
// this class is an example of cohesion as it focuses on the location of charachte
    public int[] heroMove(int[] heroPlace, String input) {

        int[] heroLoc = heroPlace;

        //heroLoc = {z,y,x}

        if(input.equals("north")){
            // Checks if y is at the end room
            if (heroLoc[1] == 2) {
                heroLoc[1] = heroLoc[1] - 1;
                return heroLoc;
            }
            // Checks if y is at the beginning room
            else if (heroLoc[1] == 0){
                System.out.println("Invalid input");
                ifmove(heroLoc);
            }
            //if its in the middle it can move freely
            else if (heroLoc[1] == 1){
                heroLoc[1] = heroLoc[1] - 1;
                return heroLoc;
            }
        }
        if(input.equals("south")){
            // Checks if y is at the end room
            if (heroLoc[1] == 2) {
                System.out.println("Invalid input");
                ifmove(heroLoc);
            }
            // Checks if y is at the beginning room
            else if (heroLoc[1] == 0){
                heroLoc[1] = heroLoc[1] + 1;
                return heroLoc;
            }
            //if its in the middle it can move freely
            else if (heroLoc[1] == 1){
                heroLoc[1] = heroLoc[1] + 1;
                return heroLoc;
            }
        }
        if(input.equals("east")){
            // checks if its at the most eastern room
            if (heroLoc[2] == 2) {
                System.out.println("Invalid input");
                ifmove(heroLoc);
            }
            // checks if its at the most western room
            else if (heroLoc[2] == 0){
                heroLoc[2] = heroLoc[2] + 1;
                return heroLoc;
            }
            //if in middle room they can move freely
            else if (heroLoc[2] == 1){
                heroLoc[2] = heroLoc[2] + 1;
                return heroLoc;
            }
        }
        if(input.equals("west")){
            // checks if its at the most eastern room
            if (heroLoc[2] == 2) {
                heroLoc[2] = heroLoc[2] - 1;
                return heroLoc;
            }
            // checks if its at the most western room
            else if (heroLoc[2] == 0){
                System.out.println("Invalid input");
                ifmove(heroLoc);
            }
            //if in middle room they can move freely
            else if (heroLoc[2] == 1){
                heroLoc[2] = heroLoc[2] - 1;
                return heroLoc;
            }
        }
        if(input.equals("up a level")){
            if(heroLoc[1] == 1 && heroLoc[2] == 1){
                // if at top floor
                if (heroLoc[0] == 4) {
                    System.out.println("Invalid input");
                    ifmove(heroLoc);
                }
                // if at bottom floor
                else if (heroLoc[0] == 0) {
                    heroLoc[0] = heroLoc[0] + 1;
                    return heroLoc;
                }
                //if its floor 2 or 3 it can move freely
                else if (heroLoc[0] >= 1 || heroLoc[0] <= 3 ) {
                    heroLoc[0] = heroLoc[0] + 1;
                    return heroLoc;
                }
            }
            else{
                System.out.println("Invalid input");
                ifmove(heroLoc);
            }
        }
        if(input.equals("down a level")){
            if(heroLoc[1] == 1 && heroLoc[2] == 1){
                // if at top floor
                if (heroLoc[0] == 4) {
                    heroLoc[0] = heroLoc[0] - 1;
                    return heroLoc;
                }
                // if at bottom floor
                else if (heroLoc[0] == 0) {
                    System.out.println("Invalid input");
                    ifmove(heroLoc);
                }
                //if its floor 2 or 3 it can move freely
                else if (heroLoc[0] >= 1 || heroLoc[0] <= 3 ) {
                    heroLoc[0] = heroLoc[0] - 1;
                    return heroLoc;
                }
            }
            else{
                System.out.println("Invalid input");
                ifmove(heroLoc);
            }
        }
        return heroLoc;
    }

    public void ifmove(int[] heroPlace){
        int[] heroLoc = heroPlace;
        System.out.println("Chose a direction");
        if (heroLoc[0] == 0 && heroLoc[1] == 1 && heroLoc[2] == 1){
            System.out.println("up a level");
        }
        else{
            if (heroLoc[1] == 2){
                System.out.println("south");
            }
            if (heroLoc[1] == 0){
                System.out.println("north");
            }
            if (heroLoc[1] == 1){
                System.out.println("south");
                System.out.println("north");
            }
            if (heroLoc[2] == 2){
                System.out.println("west");
            }
            if (heroLoc[2] == 0){
                System.out.println("east");
            }
            if (heroLoc[2] == 1){
                System.out.println("west");
                System.out.println("east");
            }
            if(heroLoc[1] == 1 && heroLoc[2] == 1){
                if (heroLoc[0] == 4) {
                    System.out.println("down a level");
                }
                if (heroLoc[0] == 0) {
                    System.out.println("up a level");
                }
                else if (heroLoc[0] >= 1 || heroLoc[0] <= 3 ) {
                    System.out.println("down a level");
                    System.out.println("up a level");
                }
            }
        }
    }

    // intailize treasure spawn
    public int [] treasureSpawn(int id){
        int x = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int y = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int z = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);
        if(id == 1){
            int[] sword_Spawn = new int[]{z,y,x};
            return sword_Spawn;
        }
        if(id == 2){
            int[] gem_Spawn = new int[]{z,y,x};
            return gem_Spawn;
        }
        if(id == 3){
            int[] armor_Spawn = new int[]{z,y,x};
            return armor_Spawn;
        }
        if(id == 4){
            int[] portal_Spawn = new int[]{z,y,x};
            return portal_Spawn;
        }
        if(id == 5){
            int[] trap_Spawn = new int[]{z,y,x};
            return trap_Spawn;
        }
        else{
            int[] potion_Spawn = new int[]{z,y,x};
            return potion_Spawn;
        }
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

    // if they use the treasure portal this will spawn them in a random location
    public int[] teleport(){
        int X = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int Y = (int) Math.floor(Math.random() * (2 - 0 + 1) + 0);
        int Z = (int) Math.floor(Math.random() * (4 - 1 + 1) + 1);

        return new int[]{Z,Y,X};
    }
}
