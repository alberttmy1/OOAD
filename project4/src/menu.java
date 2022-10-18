import java.util.ArrayList;
import java.util.Scanner;
public class menu {
public Integer start(){
        //initialization of the characters
        ArrayList<Adventurers_stats4> adventures = new ArrayList<Adventurers_stats4>();

        //pass all 4 adventures with their id's
        for(int i = 1; i < 5; i++){
            adventures.add(new Adventurers_stats4(i));
        }
        int id = 0;
        Scanner reader = new Scanner(System.in);
        System.out.println("chose a adventurer: " + adventures.toString());
        String input = reader.nextLine();
        if(input == "Brawlers") {
            id = 1;
        }
        else if(input == "Sneakers") {
            id = 2;
        }
        else if(input == "Runners") {
            id = 3;
        }
        else if(input == "Thieves") {
            id = 4;
        }
        reader.close();
        return id;
    }
    public String name(){
        Scanner reader = new Scanner(System.in);
        System.out.println("Choose a Name for your Adventure(ex: Bob, Ted): ");
        String input = reader.nextLine();
        reader.close();
        return input;
    }
}
