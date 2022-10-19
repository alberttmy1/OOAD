import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
public class menu {
public Integer start(){
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

        int id = 0;
        Scanner reader = new Scanner(System.in);
        System.out.println("chose a adventurer: " + nem);
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
        Scanner sub = new Scanner(System.in);
        System.out.println("Choose a Name for your Adventure(ex: Bob, Ted): ");
        // print the next line
//        System.out.println("" + sub.nextLine());
        String pub = "";
        if(sub.hasNextLine()){
            pub = sub.nextLine();
        }
        sub.close();
        return pub;
    }
}
