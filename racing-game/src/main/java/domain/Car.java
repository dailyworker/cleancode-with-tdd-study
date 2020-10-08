package domain;


public class Car implements Comparable<Car>{
    public static final int MAX_LENGTH = 5;
    public static final int MIN_LENGTH = 1;

    private String name;
    private int position = 0;

    public Car(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        checkNull(name);
        checkBlank(name);
        checkLength(name);
    }

    public String getName() {
        return name;
    }

    private void checkLength(String name) {
        if(name.length() > MAX_LENGTH){
            throw new IllegalArgumentException("이름의 길이가 5를 초과하였습니다.");
        }

        if(name.length() < MIN_LENGTH){
            throw new IllegalArgumentException("이름의 길이가 0보다 작습니다.");
        }
    }

    private void checkNull(String name){
        if(name == null){
            throw new NullPointerException("이름에 널 값이 들어가 있습니다.");
        }
    }

    private void checkBlank(String name) {
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("공백은 입력 할 수 없습니다.");
        }
    }

    public void forward(int randomNum) {
        if(randomNum >= 4){
            position++;
        }
    }

    public int getPosition() {
        return position;
    }

    @Override
    public int compareTo(Car anotherCar) {
        return position - anotherCar.position;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}