/*
-- Both adventurer and creature objects are passed back to the engine
 */

public class Factory {

    //Takes in a id for the creature and returns back the object
    public Creatures_stats4 createC(Integer id){
        if(id == 1){
            return new Creatures_stats4(id);
        }else if(id == 2){
            return new Creatures_stats4(id);
        }else{
            return new Creatures_stats4(id);
        }
    }

    //Same thing take in an id and returns back a object of an adventurerS
    public Adventurers_stats4 createA(Integer id){
        return new Adventurers_stats4(id);
    }
}
