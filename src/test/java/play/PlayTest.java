package play;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import user.Username;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayTest {
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"0","10008","87","31"})
    @DisplayName("If the number is less than 1 and more than 30")
    void ExceedCount(String game){
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,()->new Play(game));
        assertEquals("The number should be from 1 to 30.",e.getMessage());
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"str","!!!","ojy","su30"})
    @DisplayName("In case of string")
    void NotString(String game){
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,()->new Play(game));
        assertEquals("Must be a number",e.getMessage());
    }
}
