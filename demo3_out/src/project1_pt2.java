//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

import java.util.Arrays;
import java.util.Scanner;

public class project1_pt2 {
    public static void main(String[] args) {
        String user_input = "";
        Analyzerpt2 run = new Analyzerpt2();
        boolean again = true;
        while(again) {
            user_input = run.read();
            if (!user_input.equals("")) {
                again = false;
            }
        }
        String name = run.clean(user_input);
        System.out.println("Clean: "+ run.clean(name));
        System.out.println("Sort: "+ run.sort(name));
        System.out.println("Print: "+ run.print(user_input));
    }
}
