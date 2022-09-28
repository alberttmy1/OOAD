import java.util.List;
public class Dice {
    //Output the results a fight and take in an id to determine the Adventure fighting
    public Integer fight(int id, List<String> items){
        int heroRolls = diceRolls();    //the adventures roll
        int monsterRolls = diceRolls();   //the creatures roll
        
        for(int i = 0; i < items.size(); i++){
            if(items.get(i) == "Sword"){
                heroRolls++;
            }else if(items.get(i) == "Gem"){
                monsterRolls++;
            } else if (items.get(i) == "Armor") {
                monsterRolls--;
            } else if(items.get(i) == "Potion"){
                monsterRolls++;
            }
        }
        
        //Determine which adventure is rolling and apply their advantages
        if(id == 1){
            heroRolls += 2;
            return combat(heroRolls, monsterRolls);
        }
        else if(id == 2){
            return combat(heroRolls, monsterRolls);

        } else if (id == 3) {
            return combat(heroRolls, monsterRolls);
        } else{
            heroRolls += 1;
            return combat(heroRolls, monsterRolls);
        }
    }
    
    //Roll two dice and add them 
    private Integer diceRolls(){
        int maxDice = 1;
        int minDice = 6;
        int firstRoll = (int)Math.floor(Math.random()*(maxDice-minDice+1)+minDice);
        int secondRoll = (int)Math.floor(Math.random()*(maxDice-minDice+1)+minDice);
        return firstRoll + secondRoll;
    }
    
    /*
    *Determine who takes damage or no damage:
    * 0 - both take zero damage 
    * 1 - creature takes damage
    * 2 - hero takes damage
     */
    private Integer combat(int hero, int monst){
        if(hero > monst){
            return 1;
        } else if(monst > hero){
            return 2;
        } else{
            return 0;
        }
    }

}
