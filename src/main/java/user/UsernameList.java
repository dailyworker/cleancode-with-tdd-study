package user;

import javax.lang.model.element.Name;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class UsernameList {

    List<Username> names = new ArrayList<>();

    public UsernameList(List<Username> names) {
        validate(names);
        this.names = names;
    }

    private void validate(List<Username> names){
        validDuplicateName(names);
    }

    // i don't know
    private void validDuplicateName(List<Username> names) {
        List<String> str = new ArrayList<>();
        for(int i=0;i<names.size();i++) {
            str.add(names.get(i).getName());
        }
        List<String> duplicate = new ArrayList<String>(new HashSet<>(str));
        if(names.size()!=duplicate.size()) {
            throw new IllegalArgumentException("There should not be a duplicate name.");
        }
    }
}




