package domain;


import java.util.Objects;

public class Name {

    public static final int MAX_LENGTH = 5;
    public static final int MIN_LENGTH = 1;

    private final String name;
    private int position;

    public Name(String name){
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void validate(String name){
        checkNull(name);
        checkBlank(name);
        checkLength(name);
    }

    public void checkLength(String name) {
        if(name.length() > MAX_LENGTH){
            throw new IllegalArgumentException("이름의 길이가 5를 초과하였습니다.");
        }

        if(name.length() < MIN_LENGTH){
            throw new IllegalArgumentException("이름의 길이가 0보다 작습니다.");
        }
    }

    public void checkNull(String name){
        if(name == null){
            throw new NullPointerException("이름에 널 값이 들어가 있습니다.");
        }
    }

    private void checkBlank(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("공백은 입력 할 수 없습니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name1 = (Name) o;
        return Objects.equals(getName(), name1.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
