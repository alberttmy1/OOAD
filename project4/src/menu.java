import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class menu {

    //Adventurer id is stored
    private Integer id;
    //Unique name the user inputs is stored
    private String names;

    //Shows all available adventurers
    public void pullMenu(){
        //initialization of the characters
        ArrayList<Adventurers_stats4> adventures = new ArrayList<Adventurers_stats4>();

        //pass all 4 adventures with their id's
        for(int i = 1; i < 5; i++){
            adventures.add(new Adventurers_stats4(i));
        }
        List<String> nem = new ArrayList<String>();
        for(int i = 0; i< 4; i++){
            nem.add(adventures.get(i).getName());
        }
        // outputs characters to choose from
        System.out.println("chose a adventurer: " + nem);
    }
    //Asks for a name inputs from the user
    public void name(){
        System.out.println("Choose a Name for your Adventure(ex: Bob, Ted): ");
    }

    //sets id depending on what character you want to use
    public void setStart(String input){
        if(input.equals("Brawlers")) {
            id = 1;
        }
        else if(input.equals("Sneakers")) {
            id = 2;
        }
        else if(input.equals("Runners")) {
            id = 3;
        }
        else if(input.equals("Thieves")) {
            id = 4;
        }else{
            System.out.println("Invalid");
            id = 1;
        }
    }

    //return id
    public Integer getStart(){
        return id;
    }
    public void setNames(String in){
        names = in;
    }
    public String getNames(){
        return names;
    }
}
