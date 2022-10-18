import java.util.Scanner;

public class Decision {
    public String command(){
        Scanner reader = new Scanner(System.in);
        System.out.println("What command would you like to execute 1, 2, 3 or 4:  Move(1), Search(2), Celebrate(3), Fight(4),");
        String input = reader.nextLine();
        reader.close();
        return input;
    }
}
