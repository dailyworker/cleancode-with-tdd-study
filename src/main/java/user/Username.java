package user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Username {


    private final String name;

    public Username(String name) {
        validate(name);
        this.name = name;
    }
    public String getName() {
        return name;
    }
    private void validate(String name){
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

    private void validateOverLength(String name){
        if(name.length()>5)
            throw new IllegalArgumentException("You have exceeded the number of characters in your name.");
    }

    private void validateSpace(String name){
        if(spaceCheck(name))
            throw new IllegalArgumentException("The name must not contain spaces.");
    }

    private void validateNullPoint(String name) {
        if (name==null) {
            throw new NullPointerException("You cannot enter a null value in the name.");
        }
    }

    public boolean spaceCheck(String name)
    {
        for(int i = 0 ; i < name.length() ; i++)
        {
            if(name.charAt(i) == ' ')
                return true;
        }
        return false;
    }
}
