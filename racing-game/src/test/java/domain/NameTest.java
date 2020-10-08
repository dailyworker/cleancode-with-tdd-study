package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @ParameterizedTest
    @ValueSource(strings = {"suung", "myung", "yena", "young"})
    @DisplayName("이름 규칙에 문제가 없는 경우")
    void noErrorNamingConvention(String name){
        Name newName = new Name(name);
        assertTrue(newName.getName().length() <= 5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"seansin", "sunmyung", "leeyena", "ohjyoung"})
    @DisplayName("이름 규칙에 문제가 있는 경우")
    void hasErrorNamingConvention(String name){
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

}