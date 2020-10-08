package domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Names {

    private final List<Name> names;

    public Names(List<Name> names) {
        validate(names);
        this.names = names;
    }

    public void validate(List<Name> names){
        checkDuplicated(names);
    }

    private void checkDuplicated(List<Name> names) {
        Set<Name> set = new HashSet<>(names);
        if(set.size() != names.size()){
            throw new IllegalArgumentException("중복된 이름이 존재합니다.");
        }
    }
}
