import java.util.Random;

public class searchAndCombat extends Dice {

    public int combat(int id){
        //generate a random number between 0 and 1
        Random rand = new Random();
        int stealth = rand.nextInt(2);

        //determine the dice rolls and pass id to get each adventures specific combat advantage
        Dice c = new Dice();
        int out = c.fight(id);

        //will only apply to stealth combatant
        if(id == 3 && stealth == 0){
            return out;
        }else if(stealth != 0){
            return 0;
        }
        return out;
    }

    public int search(int id, int treasureId){
        Random temp = new Random();

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
        } else if (id == 4 && treasureId == 5) {
            //If they found a treasure, and it's a trap then roll for 50% chance of effect
            if(out >= 7) {
                if (temp.nextInt(2) == 0) {
                    return 1;
                }
                return 0;
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