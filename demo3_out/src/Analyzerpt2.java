import java.util.Arrays;
import java.util.Scanner;
import java.util.Collections;
import java.util.ArrayList;

public class Analyzerpt2 {
    static String read() {
        Scanner reader = new Scanner(System.in); // takes user input
        System.out.println("Enter a string: ");
        String input = reader.nextLine();
        boolean again = true;
        while(again) {
            if (!input.equals("")) { // if empty run functions
                again = false;
            }
        }
        print(clean(input));
        String name = clean(input);
        print(sort(name));
        name = sort(name);
        print(palindrome(name));
        reader.close();
        return input;
    }
    //https://www.geeksforgeeks.org/how-to-remove-all-white-spaces-from-a-string-in-java/
    static String clean(String text) {
        // converts all letters to upper case
        String upper = text.toUpperCase();
        // gets rid of white spaces
        upper = upper.replaceAll("\\s", "");
        return upper;
    }
    static String sort(String text)
    {
        // makes a string into character array and then sorts it
        char tempArray[] = text.toCharArray();

        Arrays.sort(tempArray);


        return new String(tempArray);
    }
    //https://www.techiedelight.com/reverse-a-string-using-character-array-in-java/
    static String reverse(String str)
    {
        // return if the string is null or empty
        if (str == null || str.equals("")) {
            return str;
        }

        // get string length
        int n = str.length();

        // create a character array of the same size as that of string
        char[] temp = new char[n];

        // fill character array backward with characters in the string
        for (int i = 0; i < n; i++) {
            temp[n - i - 1] = str.charAt(i);
        }

        // convert character array to string and return it
        return String.copyValueOf(temp);
    }
    static String palindrome(String text){
        // makes character array
        char non_rev[] = text.toCharArray();
        // gets rid of first element therefore get rid of first letter
        char mod[] = Arrays.copyOfRange(non_rev, 1, non_rev.length);
        // reverses text
        char rev[] = reverse(text).toCharArray();
        // appends array with the first element removed to the reverse
        for(int k =0; k < mod.length; k++){
            rev = Arrays.copyOf(rev, rev.length +1);
            rev[rev.length -1] = mod[k];
        }

        return new String(rev);
    }
    static String print(String text){
        System.out.println(text);
        return text;
    }

}