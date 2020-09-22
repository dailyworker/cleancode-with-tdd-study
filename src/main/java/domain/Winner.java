package domain;

import java.util.ArrayList;
import java.util.List;

public class Winner {
        public static List<String> FindWinner(CarList cars){
        Car maxcar = cars.getCars().stream().max(Car::compare).get();
        int max =maxcar.getPosition();
        List<Car> cars1 = cars.getCars();
        List<String> win=new ArrayList<>();
        for(int i=0;i<cars1.size();i++){
            if(cars1.get(i).isMatchPosition(max))
                win.add(cars1.get(i).getName());
        }
        return win;

    }
}
