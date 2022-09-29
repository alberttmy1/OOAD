import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Adventurers_stats3 {

    //Private Variables
    private int hp;
    private String name;
    private int id;
    private int[] loc;
    private List<String> treasure = new ArrayList<String>();

    /*
    *Upon Initiating the class it takes in a number in order to determine the Adventurer
    *All Adventurers should have a unique id
     */
    public Adventurers_stats3(int num){
        hp  = 3;        //sets the health to 3
        loc = new int[] {0,1,1};
        //Sets a object up with a id and name
        if(num == 1){
            name = "Brawlers";
            id = 1;
        } else if (num == 2) {
            name = "Sneakers ";
            id = 2;
        }else if (num == 3){
            name = "Runners";
            id = 3;
        }else{
            name = "Thieves";
            id = 4;
        }
    }
    //returns Id
    public Integer getID(){
        return id;
    }

    public String getName() {return name;}

    //return the spawn coordinates
    public int[] getSpawn(){
        return loc;
    }

    //set the new amount of hp
    public void setHP(int health){
        hp = health;
    }

    //return the current hp
    public int getHP(){
        return hp;
    }

    //set the adventures new coordinates
    public void setSpawn(int[] place){
        loc = place;
    }

    //return the amount of treasure they have
    public List<String> getTreasure(){return treasure;}

    //increment treasure count
    public void setTreasure(String item){
        treasure.add(item);
    }
}