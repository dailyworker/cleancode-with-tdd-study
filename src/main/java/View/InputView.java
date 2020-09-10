package View;

import java.util.Scanner;

public class InputView {
    static Scanner sc = new Scanner(System.in);
    public static String receivecarnames(){
        System.out.println("Please enter a car name(used ,)");
        return sc.nextLine();
    }
    public static String receiveround(){
        System.out.println("How many rounds do you want?");
        return sc.nextLine();
    }
}
