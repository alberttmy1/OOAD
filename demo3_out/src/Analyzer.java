import java.util.Arrays;
import java.util.ArrayList;
public class Analyzer {
    //https://www.geeksforgeeks.org/median/
    static double median(double[] lst) {
        // sort array
        Arrays.sort(lst);
        double median;
        int totalElements = lst.length;
        System.out.println(totalElements);
        if(totalElements % 2 == 0) {
            median = (lst[((totalElements)/2)] + lst[((totalElements)/2) - 1])/2;
            return median;
        }
        else{
            median = (totalElements/2)+1;
            return median;
        }

    }
    static double mean(double[] lst) {
        // sort array
        Arrays.sort(lst);
        double mean;
        double sum = 0;
        for(int i = 0; i < lst.length;i++) {
             sum = sum + lst[i];
        }
        mean = sum/lst.length;
        return mean;
    }
    // https://stackoverflow.com/questions/8858327/finding-multiple-modes-in-an-array
    static ArrayList<Double> mode(double[] lst) {
        ArrayList<Double> mode_lst = new ArrayList<Double>();
        Arrays.sort(lst);
        int bigcount = 0;
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
        return mode_lst;
    }

    //https://www.includehelp.com/java-programs/calculate-the-mean-variance-and-standard-deviation-of-real-numbers.aspx
    static double variance(double[] lst) {
        double sum = 0;
        double mean = 0;
        double sqDiff = 0;
        for (int i = 0; i < lst.length; i++)
            sum = sum + lst[i];
        mean = sum / lst.length;

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
        for (int i = 0; i < lst.length; i++)
            sum = sum + lst[i];
        mean = sum / lst.length;
        for (int i = 0; i < lst.length; i++)
            sqDiff = sqDiff + Math.pow((lst[i] - mean), 2);
        var = sqDiff / lst.length;
        std = Math.sqrt(var);
        return std;
    }
    static double Min(double[] lst) {
        Arrays.sort(lst);
        return lst[0];
    }
    static double Max(double[] lst) {
        Arrays.sort(lst);
        return lst[lst.length -1];
    }
    static double MaxOcur(double[] lst) {

        ArrayList<Double> mode_lst = new ArrayList<Double>();
        Arrays.sort(lst);
        int bigcount = 0;
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