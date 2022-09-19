import java.util.Arrays;
import java.util.ArrayList;
import java.util.Scanner;

public class Analyzer {
    static double[] run() {
        double[] lst = new double[0];
        Scanner reader = new Scanner(System.in);
        boolean again = true;
        while(again){
            System.out.println("Enter a number: ");
            String input = reader.nextLine();
            // takes in a real number and adds it to the array
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
        System.out.println("Median: "+ median(lst));
        System.out.println("Mean: "+ mean(lst));
        System.out.println("Mode: "+ mode(lst));
        System.out.println("Variance: "+ variance(lst));
        System.out.println("Standard Deviation:"+ Std(lst));
        System.out.println("Min:"+ Min(lst));
        System.out.println("Max:"+ Max(lst));
        System.out.println(MaxOcur(lst));
        reader.close();
        return lst;
    }
    //https://www.geeksforgeeks.org/median/
    static double median(double[] lst) {
        // sort array
        Arrays.sort(lst);
        double median;
        int totalElements = lst.length;
        //checks if the list is even if it is takes the average of the two middle numbers
        if(totalElements % 2 == 0) {
            median = (lst[((totalElements)/2)] + lst[((totalElements)/2) - 1])/2;
            return median;
        }
        else{
            // if the list is odd take the middle value
            median = (totalElements/2)+1;
            return median;
        }

    }
    static double mean(double[] lst) {
        // sort array
        Arrays.sort(lst);
        double mean;
        double sum = 0;
        // adds all of the elements in the list together
        for(int i = 0; i < lst.length;i++) {
             sum = sum + lst[i];
        }
        // divides by the number of elements
        mean = sum/lst.length;
        return mean;
    }
    // https://stackoverflow.com/questions/8858327/finding-multiple-modes-in-an-array
    static ArrayList<Double> mode(double[] lst) {
        ArrayList<Double> mode_lst = new ArrayList<Double>();
        Arrays.sort(lst);
        int bigcount = 0;
        for (int i = 0; i < lst.length; i++) {
            // keeps track of the number of duplicates
            int count = 0;
            for (int j = 0; j < lst.length; j++) {
                if (lst[j] == lst[i]) {
                    count++;
                }
            }
            // if count is greater than the previous mode set that as new mode
            if (count > bigcount) {
                bigcount = count;
                mode_lst.clear();
                // checks if mode already exists in list
                if(!mode_lst.contains(lst[i])){
                    mode_lst.add(lst[i]);
                }
            }
            // if they are equal then there are multiple modes
            else if(count == bigcount){
                // checks if mode already exists in list if not it will add it
                if(!mode_lst.contains(lst[i])){
                    mode_lst.add(lst[i]);
                }
            }
        }
        return mode_lst;
    }

    //https://www.includehelp.com/java-programs/calculate-the-mean-variance-and-standard-deviation-of-real-numbers.aspx
    static double variance(double[] lst) {
        double sum = 0;
        double mean = 0;
        double sqDiff = 0;
        // Calculate the mean
        for (int i = 0; i < lst.length; i++)
            sum = sum + lst[i];
        mean = sum / lst.length;
        // Converts mean to variance by sumation
        for (int i = 0; i < lst.length; i++)
            sqDiff = sqDiff + Math.pow((lst[i] - mean), 2);
        return sqDiff / lst.length;
    }
    static double Std(double[] lst) {
        double sum = 0;
        double mean = 0;
        double sqDiff = 0;
        double std = 0;
        double var = 0;
        // calculates the mean
        for (int i = 0; i < lst.length; i++)
            sum = sum + lst[i];
        mean = sum / lst.length;
        // gets the variance
        for (int i = 0; i < lst.length; i++)
            sqDiff = sqDiff + Math.pow((lst[i] - mean), 2);
        var = sqDiff / lst.length;
        // square roots variance to find standard deviation
        std = Math.sqrt(var);
        return std;
    }
    static double Min(double[] lst) {
        // sorts array and takes the first element
        Arrays.sort(lst);
        return lst[0];
    }
    static double Max(double[] lst) {
        // sorts array and takes the last element
        Arrays.sort(lst);
        return lst[lst.length -1];
    }
    static double MaxOcur(double[] lst) {

        ArrayList<Double> mode_lst = new ArrayList<Double>();
        Arrays.sort(lst);
        int bigcount = 0;
        // takes the median but also returns the counter
        for (int i = 0; i < lst.length; i++) {
            int count = 0;
            for (int j = 0; j < lst.length; j++) {
                if (lst[j] == lst[i]) {
                    count++;
                }
            }
            if (count > bigcount) {
                bigcount = count;
                mode_lst.clear();
                if(!mode_lst.contains(lst[i])){
                    mode_lst.add(lst[i]);
                }
            }
            else if(count == bigcount){
                if(!mode_lst.contains(lst[i])){
                    mode_lst.add(lst[i]);
                }
            }
        }
        System.out.println("Maximum Occurrences:"+ mode_lst);
        System.out.print("Which has a count of: ");
        return bigcount;

    }
}