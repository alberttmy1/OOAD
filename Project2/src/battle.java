import java.util.Random;

/*
return 0 = tie or no dmg
return 1 = creature dmg
return 2 = hero dmg
 */
public class battle{
    public Integer fight(int id){
        int heroRolls = diceRolls();
        int monstRolls = diceRolls();

        if(id == 1){
            heroRolls += 2;
            return combat(heroRolls, monstRolls);
        }
        else if(id == 2){
            return combat(heroRolls, monstRolls);

        } else if (id == 3) {
            return combat(heroRolls, monstRolls);
        } else{
            heroRolls += 1;
            return combat(heroRolls, monstRolls);
        }
    }

    private Integer diceRolls(){
        int maxDice = 1;
        int minDice = 6;
        int firstRoll = (int)Math.floor(Math.random()*(maxDice-minDice+1)+minDice);
        int secondRoll = (int)Math.floor(Math.random()*(maxDice-minDice+1)+minDice);
        return firstRoll + secondRoll;
    }

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
