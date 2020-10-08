package domain;

import java.util.ArrayList;
import java.util.List;

public class CarFactory {
    public static RacingCars create(List<String> names){
        List<Car> racingCars = new ArrayList<>();
        for (String name : names){
            racingCars.add(new Car(name));
        }
        return new RacingCars(racingCars);
    }
}
