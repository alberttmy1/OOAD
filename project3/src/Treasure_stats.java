public class Treasure_stats {
    //Private variables
    // This private members are an example of encapsulation
    private String name;
    private int id;
    private int[] loc;

    //Initialize the Object
    public Treasure_stats(int num){
        if(num == 1){
            name = "Sword";
            id = 1;
        }
        if (num == 2) {
            name = "Gem";
            id = 2;
        }
        if(num == 3){
            name = "Armor";
            id = 3;
        }
        if(num == 4){
            name = "Portal";
            id = 4;
        }
        if(num == 5){
            name = "Trap";
            id = 5;
        }
        if(num == 6){
            name = "Potion";
            id = 6;
        }
    }

    //return the id
    public Integer getID(){
        return id;
    }
    // return name
    public String getName(){
        return name;
    }

    //return the spawn coordinates
    public int[] getSpawn(){
        return loc;
    }

    //set the spawn
    public void setSpawn(int[] place){
        loc = place;
    }
}
