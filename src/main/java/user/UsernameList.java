package user;


import javax.lang.model.element.Name;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UsernameList {

    List<String> names = new ArrayList<>();

    public UsernameList(List<String> names) {
        validate(names);
        this.names = names;
    }

    private void validate(List<String> names){
        validDuplicateName(names);
    }
    private void validDuplicateName(List<String> names) {
        List<String> hashSet = new ArrayList<String>(new HashSet<String>(names));
        System.out.println(hashSet.size());
        System.out.println(names.size());
        if(names.size()!=hashSet.size()) {
            throw new IllegalArgumentException("There should not be a duplicate name.");
        }
    }
}




