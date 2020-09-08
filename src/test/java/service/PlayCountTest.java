package service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import user.UserCheck;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class PlayCountTest {

    @ValueSource(ints = {15, 1, 30})
    @DisplayName("normal test")
    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    void normalTest(Integer count) {
        PlayCount playCount = new PlayCount(count);
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(ints = {20, 30, 35, 40})
    @DisplayName("Check Over 30")
    void OverNumTest(Integer count){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new PlayCount(count));
        String message = e.getMessage();
        assertEquals("PlayCount must be under than 30.", message);
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"smm", "15", "suung"})
    @DisplayName("Check String")
    void IsStringTest(String count){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,()->new PlayCount(Integer.parseInt(count)));
        String message = e.getMessage();
        assertEquals("PlayCount must be number.", message);
    }

}