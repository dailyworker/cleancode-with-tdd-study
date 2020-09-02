package user;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class UsernameListTest {

    @Test
    @DisplayName("If there is a duplicate name")
    void duplicatename(){
        String str = "ojy";
        Username user = new Username(str);
        Username user1 = new Username(str);
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new UsernameList(Arrays.asList(user.getName(),user1.getName())));
        String message = e.getMessage();
        assertEquals("There should not be a duplicate name.",message);
    }
}
