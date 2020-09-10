package domain;
import domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CarTest {
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"ojy","ojy1","ojy2","ojy3"})
    @DisplayName("There is no abnormality")
    void nameCorrect(String name){
        Car car=Car.of(name);
    }

    @Test
    @DisplayName("If there is a comma in the name")
    void namesplit(){
        String str1 = "hey,ho,hi";
        List<String> list = Car.nameSplit(str1);
        List<String> list1= Arrays.asList("hey","ho","hi");
        assertEquals(list,list1);
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"ojywkfjs","ojydfsfkj","ojydfsf","ojysss"})
    @DisplayName("If the name is more than 5 characters long")
    void nameCountExceed(String name){
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,()->Car.of(name));
        assertEquals("You have exceeded the number of characters in your name.",e.getMessage());
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {" ","  ","   ","    "})
    @DisplayName("If there is a space in it")
    void spaceforname(String name){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->Car.of(name));
        assertEquals("The name must not contain spaces.",e.getMessage());
    }

    @Test
    @DisplayName("If name is null value")
    void nullname(){
        NullPointerException e = assertThrows(NullPointerException.class,()->Car.of(null));
        assertEquals("You cannot enter a null value in the name.",e.getMessage());
    }
    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName("If the value is less than 3")
    void stop(int num){
        Car car = new Car("ojy",num);
        int n = car.move(0);
        assertEquals(n,num);
    }

    @ParameterizedTest
    @ValueSource(ints = {4,5,6})
    @DisplayName("If the value is more than 4")
    public void move(int num){
        Car car = new Car("ojy",num);
        int n= car.move(1);
        assertEquals(n,num+1);
        //값이 1->거리->차가 달리는 것(play?)
    }
}
