package user;

import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class UserListCheck {

    List<String> name = new ArrayList<>();

    public UserListCheck(List<String> name) {
        validate(name);
        this.name = name;

    }

    private void validate(List<String> name) {
        CheckOverlap(name);
    }

    private void CheckOverlap(List<String> name) {
        HashSet<String> CheckOL = new HashSet<String>();
        CheckOL.addAll(name);
        if(name.size() != CheckOL.size())
            throw new IllegalArgumentException("The name violate the Overlap rule");
    }
}
