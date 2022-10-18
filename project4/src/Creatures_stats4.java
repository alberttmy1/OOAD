public class Creatures_stats4 {

    //Private variables
    // This private members are an example of encapsulation
    private int hp;
    private String name;
    private int id;
    private int[] loc;

    //Initialize the Object
    public Creatures_stats4(int num){
        hp  = 1;
        if(num == 1){
            name = "Orbitor";
            id = 1;
        }
        if (num == 2) {
            name = "Seekers";
            id = 2;
        }
        if(num == 3){
            name = "Blinkers";
            id = 3;
        }
    }

    //return the id
    public Integer getID(){
        return id;
    }

    //return the spawn coordinates
    public int[] getSpawn(){
        return loc;
    }

    //set how much health they have
    public void setHP(int health){
        hp = health;
    }

    public int getHP(){
        return hp;
    }
    //set the spawn
    public void setSpawn(int[] place){
        loc = place;
    }
    public void setName(String Name){
        name = Name;
    }
    public String getName(){
        return name;
    }

}