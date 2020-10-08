package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RacingCarsTest {

    @Test
    @DisplayName("중복된 이름이 존재하는 경우")
    void hasDuplicatedName(){

        List<Name> names = new ArrayList<>();
        names.add(new Name("tobi"));
        names.add(new Name("tobi"));

        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Names(names)
        );

        assertTrue(thrown.getMessage().contains("중복된"));
    }

}