package domain;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Arrays.sort;

public class CarList {

    RandomNum randomNum;
    List<Car> cars;

    public List<Car> getCars() {
        return cars;
    }

    public CarList(List<Car> cars, RandomNum randomNum) {
        validate(cars);
        this.cars = cars;
        this.randomNum = randomNum;
    }

    private void validate(List<Car> cars){
        validDuplicateName(cars);
    }

    public static CarList form(List<String> names){ //차 이름들을 리스트에 저장(이름)
        List<Car> cars = names.stream().map(Car::of).collect(Collectors.toList());
        return new CarList(cars,new RandomNum());
    }

    public CarList move() {   //이름들을 저장한 것을 가지고 차들이 전진하는지 스탑하는지 파악하여 다시 저장 (position)
        for(int i=0;i<cars.size();i++)
            cars.get(i).move(randomNum.movenumber());
        return new CarList(cars,new RandomNum());
    }

    private void validDuplicateName(List<Car> cars) {
        List<String> str = new ArrayList<>();
        for(int i=0;i<cars.size();i++) {
            str.add(cars.get(i).getName());
        }
        List<String> duplicate = new ArrayList<String>(new HashSet<>(str));
        if(cars.size()!=duplicate.size()) {
            throw new IllegalArgumentException("There should not be a duplicate name.");
        }
    }
}




