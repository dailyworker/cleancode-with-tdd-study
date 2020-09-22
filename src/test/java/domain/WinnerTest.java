package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static domain.Winner.FindWinner;

public class WinnerTest {
    @Test
    @DisplayName("Winner Name")
    void winner(){

        Car car = new Car("ojy",5);
        List<Car> cars= Arrays.asList(car,new Car("aaa",2),
                new Car("ptr",1));
        CarList carList = new CarList(cars,new RandomNum());
        List<String> names = Winner.FindWinner(carList);
        for(int i=0;i<names.size();i++)
            System.out.println(names.get(i));
        //assertEquals(names,);
    }
}
