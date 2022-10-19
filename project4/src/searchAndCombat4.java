import java.util.Random;
import java.util.List;

/*
* Strategy Pattern
* Created, assigned, and implemented search and combat algorithms for our adventures
* Each hava unique id that is assigned to an algorithm output
 */
public class searchAndCombat4 extends Dice4 {
    /*
    ** out = 0 -> then no one took dmg
    ** out = 1 -> then creature took dmg
    ** out = 2 -> hero took dmg
     */
    public int combat(int id, List<String> inventory){
        //generate a random number between 0 and 1
        Random rand = new Random();
        int stealth = rand.nextInt(2);

        //determine the dice rolls and pass id to get each adventures specific combat advantage
        Dice c = new Dice();
        int out = c.fight(id, inventory);

        //will only apply to stealth combatant
        if(id == 3 && stealth == 0 && out == 2){
            return 0;
        }else if(stealth != 0 && id == 3){
            return out;
        }
        return out;
    }

    public int search(int id, List<String> inventory, int treasureId, String treasureName){
        Random temp = new Random();

        //check for duplicates
        for(int i = 0; i < inventory.size(); i++){
            if(inventory.get(i) == treasureName){
                return 0;
            }
        }

        //returns the dice rolls
        int out = rollForTreasure();
        //Brawlers algorithm
        if(id == 1) {
            if (out >= 7) {
                return 1;
            }
            return 0;
            //Runner and Sneaker algorithm for treasure
        }else if (id == 2 || id == 3) {
            if (out >= 6) {
                return  1;
            }
        }else if (id == 4 && treasureId == 5) {
            //If they found a treasure, and it's a trap then roll for 50% chance of effect
            if(out >= 7) {
                //got hit by the trap
                if (temp.nextInt(2) == 0) {
                    return 3;
                }
                //found no effect
                return 2;
            }
            return 0;
        }else{
            //check to see if the thief gets a treasure
            if(out >= 4){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    //Determine their default rolls without advantages by rolling 2 dice and adding their outputs
    private int rollForTreasure(){
        Random rand = new Random();
        int num1 = rand.nextInt(6) + 1;
        int num2 = rand.nextInt(6) + 1;
        return num1 + num2;
    }
}
