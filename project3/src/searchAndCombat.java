import java.util.Random;
import java.util.List;
public class searchAndCombat extends Dice {

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
        if(id == 3 && stealth == 0){
            return out;
        }else if(stealth != 0){
            return 0;
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

        if(id == 1) {
            if (out >= 10) {
                return 1;
            }
            return 0;
        }else if (id == 2 || id == 3) {
            if(temp.nextInt(3) == 0){
                return 0;
            }
            if (out >= 9) {
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
            if(out >= 7){
                return 1;
            }
            return 0;
        }
        return 0;
    }

    private int rollForTreasure(){
        Random rand = new Random();
        int num1 = rand.nextInt(6) + 1;
        int num2 = rand.nextInt(6) + 1;
        return num1 + num2;
    }
}
