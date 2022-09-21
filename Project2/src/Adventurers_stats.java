public class Adventurers_stats {

    private int hp;
    private String name;
    private int id;
    private int atk;
    private int[] loc;
    private int treasure;

    public Adventurers_stats(int num){
        hp  = 3;
        atk = 1;
        treasure = 0;
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
    public Integer getID(){
        return id;
    }

    //return the spawn coordinates
    public int[] getSpawn(){
        return loc;
    }

    //
    public void setHP(int health){
        hp = health;
    }
    public int getHP(){
        return hp;
    }

    public void setSpawn(int[] place){
        loc = place;
    }

    public Integer getTreasure(){return treasure;}

    public void setTreasure(int money){ treasure += money;}

}