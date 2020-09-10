package domain;
import domain.Car;
import domain.CarList;
import domain.RandomNum;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarListTest {

    @Test
    @DisplayName("If there is a duplicate name")
    void duplicatename(){
        String str = "ojy";
        RandomNum randomNum = new RandomNum();
        Car user = Car.of(str);
        Car user1 = Car.of(str);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new CarList(Arrays.asList(user,user1),randomNum));
        assertEquals("There should not be a duplicate name.",e.getMessage());
    }
}
