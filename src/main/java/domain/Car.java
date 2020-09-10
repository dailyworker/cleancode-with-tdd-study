package domain;

import java.util.ArrayList;
import java.util.List;

public class Car {
    private String name;
    private int position;

    public Car(String name,int position) {
        validate(name);
        this.name = name;
        this.position=position;
    }

    public static Car of(String name){
        validate(name);
        return new Car(name,0);
    }

    public boolean isMatchPosition(int position) {

        return this.position == position;
    }
    public int move(int num){
        if(num==1)
            this.position++;
        return this.position;
    }

    public int compare(Car that){
        return this.position-that.position;
    }

    public  int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    private static void validate(String name){
        validateNullPoint(name);
        validateOverLength(name);
        validateSpace(name);
    }


    public static List<String> nameSplit(String name){
        List<String> list = new ArrayList<>();
        String[] commasplit = name.split(",");
        for(int i=0;i<commasplit.length;i++)
            list.add(commasplit[i]);
        return list;
    }

    private static void validateOverLength(String name){
        if(name.length()>5)
            throw new IllegalArgumentException("You have exceeded the number of characters in your name.");
    }

    private static void validateSpace(String name){
        if(spaceCheck(name))
            throw new IllegalArgumentException("The name must not contain spaces.");
    }

    private static void validateNullPoint(String name) {
        if (name==null) {
            throw new NullPointerException("You cannot enter a null value in the name.");
        }
    }

    public static boolean spaceCheck(String name)
    {
        for(int i = 0 ; i < name.length() ; i++)
        {
            if(name.charAt(i) == ' ')
                return true;
        }
        return false;
    }
}
