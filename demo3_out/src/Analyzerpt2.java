import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Analyzerpt2 {
    static String read() {
        Scanner reader = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = reader.nextLine();
        reader.close();
        return input;
    }
    //https://www.geeksforgeeks.org/how-to-remove-all-white-spaces-from-a-string-in-java/
    static String clean(String text) {
        String upper = text.toUpperCase();
        String str = upper;
        str = str.replaceAll("\\s", "");
        return str;
    }
    //https://www.geeksforgeeks.org/how-to-remove-all-white-spaces-from-a-string-in-java/
    static String sort(String text)
    {
        // Converting input string to character array
        char tempArray[] = text.toCharArray();

        // Sorting temp array using
        Arrays.sort(tempArray);

        // Returning new sorted string
        return new String(tempArray);
    }
//    public static String palindrome(String text){
//        char tempArray[] = text.toCharArray();
//        for(int i = 0; i < tempArray.length; i++){
//
//        }
//
//    }
    public static String print(String text){
        return text;
    }

}