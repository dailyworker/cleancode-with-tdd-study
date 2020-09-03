package user;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class UserCheck {

    String name;

    public UserCheck(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name){
        CheckOverlap(nameSplit(name));
        CheckLength(name);
        CheckNullpoint(name);
        CheckEmpty(name);
        CheckSpace(name);
    }

    private static List<String> nameSplit(String name) {
        return Arrays.asList(name.split(","));
    }

    private void CheckOverlap(List<String> name) {
        HashSet<String> CheckOL = new HashSet<String>();
        CheckOL.addAll(name);
        if(name.size() != CheckOL.size())
            throw new IllegalArgumentException("The name violate the Overlap rule");
    }

//    public void CheckOverlapAfterSplit(String name) {
//        CheckOverlap(nameSplit(name));
//    }

    private void CheckNullpoint(String name) {
        if(name == null)
            throw new IllegalArgumentException("Name is Null now");
    }

    private void CheckEmpty(String name) {
        if(name.isEmpty())
            throw new IllegalArgumentException("Name is Empty now");
    }

    private void CheckLength(String name) {
        if(name.length()>5)
            throw new IllegalArgumentException("The Name violate the lenght rule");
    }

    private void CheckSpace(String name) {
        if(name.contains(" "))
            throw new IllegalArgumentException("The Name violate the space rule");
    }


}
