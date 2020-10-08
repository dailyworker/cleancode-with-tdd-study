package ui;

import java.util.Scanner;

public class InputView {

    private final static Scanner sc = new Scanner(System.in);

    public static String getInput(){
        System.out.println("함께 플레이 할 사용자를 , 기준으로 입력해주세요.");
        return sc.nextLine();
    }

    public static String getTimes() {
        System.out.println("시도하고자 하는 횟수를 입력해주세요.");
        return sc.nextLine();
    }
}
