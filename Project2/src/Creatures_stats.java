public class Creatures_stats {

    //Private variables
    private int hp;
    private String name;
    private int id;
    private String loc;

    //Initialize the Object
    public Creatures_stats(int num){
        hp  = 1;
        if(num == 1){
            name = "Orbitor";
            id = 1;
        } else if (num == 2) {
            name = "Seekers";
            id = 2;
        }else{
            name = "Blinkers";
            id = 3;
        }
    }

    //return the id
    public Integer getID(){
        return id;
    }

    //return the spawn coordinates
    public String getSpawn(){
        return loc;
    }

    //set how much health they have
    public void setHP(int health){
        hp = health;
    }

    //set the spawn
    public void setSpawn(String place){
        loc = place;
    }

}
