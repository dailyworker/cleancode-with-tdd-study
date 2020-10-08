package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class RoundTest {

    @ParameterizedTest
    @ValueSource(strings = {"10", "30", "25", "12"})
    @DisplayName("제대로된 라운드 횟수가 입력되는 경우")
    void nomal_round_case(String roundNum){
        Round round = new Round(roundNum);
        assertTrue(round.getRound() <= 30);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "-1", "-2", "-3"})
    @DisplayName("제대로 되지 않은 라운드 횟수가 입력되는 경우")
    void lengthCheckRound(String roundNum){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Round(roundNum)
        );

        assertTrue(thrown.getMessage().contains("라운드 횟수는 1보다 작거나 30보다 크면 안됩니다."));
    }

    @ParameterizedTest
    @ValueSource(strings = {"문자열테스트", "테스트", "test"})
    @DisplayName("문자열을 라운드 횟수로 입력받은 경우")
    void insertStringRound(String roundString){
        IllegalArgumentException thrown = assertThrows(
                IllegalArgumentException.class,
                () -> new Round(roundString)
        );

        assertTrue(thrown.getMessage().contains("문자열을 입력하실 수 없습니다."));
    }

    @Test
    @DisplayName("라운드가 감소하는지 테스트")
    void decreaseRound(){
        Round round = new Round("2");
        round.reduce();
        round.reduce();
        assertTrue(round.isEnd());
    }

    @Test
    @DisplayName("라운드 종료된 후에 reduce 호출")
    void isEndTest(){
        Round round = new Round("1");
        round.reduce();
        RuntimeException thrown = assertThrows(
                RuntimeException.class,
                round::reduce
        );

        assertTrue(thrown.getMessage().contains("모든 라운드가 종료 되었습니다."));
    }

}