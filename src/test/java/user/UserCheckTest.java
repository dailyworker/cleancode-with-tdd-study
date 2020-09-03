package user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class UserCheckTest {

    @ValueSource(strings = {"sm", "smm", "suung"})
    @DisplayName("normal test")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    void normalTest(String name) {
        UserCheck userCheck = new UserCheck(name);
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"smm,suung,yena,ojy,smm"})
    @DisplayName("Check Overlaping name")
    void OverlapTest(String name){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new UserCheck(name));
        String message = e.getMessage();
        assertEquals("The name violate the Overlap rule", message);
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"smmmmmm","smmmmm","sinsuung"})
    @DisplayName("Check over Length name")
    void OverLenghtTest(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new UserCheck(name));
        String message = e.getMessage();
        assertEquals("The Name violate the lenght rule", message);
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {""})
    @DisplayName("Check name is empty")
    void EmptyTest(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new UserCheck(name));
        String message = e.getMessage();
        assertEquals("Name is Empty now", message);
    }

    @Test
    @DisplayName("Check name is empty")
    void NullTest(String name) {
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new UserCheck(name));
        String message = e.getMessage();
        assertEquals("Name is Null now", message);
    }
}
