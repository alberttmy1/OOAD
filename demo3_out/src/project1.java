import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
public class project1{
    public static void main(String[] args) {
        double[] lst = new double[0];
        Scanner reader = new Scanner(System.in);
        boolean again = true;
        while(again){
            System.out.println("Enter a number: ");
            String input = reader.nextLine();
            if(!(input.equals(""))){
                // makes array bigger https://stackoverflow.com/questions/13197702/resize-an-array-while-keeping-current-elements-in-java
                lst = Arrays.copyOf(lst, lst.length +1);
                lst [lst.length -1] = Double.parseDouble(input);
                System.out.println(Arrays.toString(lst));
            }
            else {
                again = false;
            }
        }
        Analyzer calculate = new Analyzer();
        System.out.println("Median: "+ calculate.median(lst));
        System.out.println("Mean: "+ calculate.mean(lst));
        System.out.println("Mode: "+ calculate.mode(lst));
        System.out.println("Variance: "+ calculate.variance(lst));
        System.out.println("Standard Deviation:"+ calculate.Std(lst));
        System.out.println("Min:"+ calculate.Min(lst));
        System.out.println("Max:"+ calculate.Max(lst));
        System.out.println(calculate.MaxOcur(lst));
        reader.close();

    }
}