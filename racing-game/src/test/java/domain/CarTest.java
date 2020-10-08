package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class CarTest {
    @ParameterizedTest
    @ValueSource(strings = {"sean", "sin", "test"})
    @DisplayName("이름 규칙에 문제가 없어서 정상적으로 생성되는 경우")
    void nomal_case(String name){
        Car newCar = new Car(name);
        assertTrue(newCar.getName().length() <= 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"dddddd", "cccccc", "dddddd"})
    void overLength_case(String name){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Name(name)
        );

        assertTrue(thrown.getMessage().contains("길이가"));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "   ", "     "})
    @DisplayName("이름에 공백이 있는 경우")
    void hasWhiteSpaceNamingConvention(String name){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Name(name)
        );

        assertTrue(thrown.getMessage().contains("공백"));
    }

    @Test
    @DisplayName("이름에 널 값이 있는 경우")
    void hasNullNamingConvention(){
        NullPointerException thrown = assertThrows(
                NullPointerException.class,
                () -> new Name(null)
        );

        assertTrue(thrown.getMessage().contains("널 값"));
    }

    @ParameterizedTest
    @ValueSource(ints = {4, 7, 9})
    @DisplayName("4이상의 수가 들어올 경우")
    void carForwardTest(int num){
        Car car = new Car("sean");
        car.foward(num);
        assertEquals(car.getPosition(), 1);
    }

    @ParameterizedTest
    @ValueSource(ints = {3, 2, 1})
    @DisplayName("3이하의 수가 들어올 경우")
    void carStopTest(int num){
        Car car =new Car("sean");
        car.foward(num);
        assertEquals(car.getPosition(), 0);
    }



}
