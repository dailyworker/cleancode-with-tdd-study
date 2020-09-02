package user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


public class UsernameTest {

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"ojy","ojy1","ojy2","ojy3"})
    @DisplayName("There is no abnormality")
    void nameCorrect(String name){
        Username newUsername = new Username(name);
    }

    @Test
    @DisplayName("If there is a comma in the name")
    void namesplit(){
        String str1 = "hey,ho,hi";
        List<String> list = Username.nameSplit(str1);
        List<String> list1= Arrays.asList("hey","ho","hi");
        assertEquals(list,list1);

    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"ojywkfjs","ojydfsfkj","ojydfsf","ojysss"})
    @DisplayName("If the name is more than 5 characters long")
    void nameCountExceed(String name){
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,()->new Username(name));
        assertEquals("You have exceeded the number of characters in your name.",e.getMessage());
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {" ","  ","   ","    "})
    @DisplayName("If there is a space in it")
    void spaceforname(String name){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new Username(name));
        assertEquals("The name must not contain spaces.",e.getMessage());
    }

    @Test
    @DisplayName("If name is null value")
    void nullname(){
        NullPointerException e = assertThrows(NullPointerException.class,()->new Username(null));
        assertEquals("You cannot enter a null value in the name.",e.getMessage());
    }

}
