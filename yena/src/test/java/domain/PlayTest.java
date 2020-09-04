package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class PlayTest {


    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource( ints = {1,2,6,30,31} )
    @DisplayName("숫자가 30이 넘을 때 테스트")
    void longTest(Integer num){
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,
                () -> new play(num));
        String message = e.getMessage();
        assertEquals(message,"정해진 범위내에 입력하세요");
    }

    @ParameterizedTest(name ="{index} {displayName} message={0}")
    @ValueSource( ints ={ -1,0,1,2})
    @DisplayName("1보다 작은 수 테스트")
    void PositiveTest(Integer num){
        IllegalArgumentException e =assertThrows(IllegalArgumentException.class,
                () -> new play(num));
        String message = e.getMessage();
        assertEquals(message,"양수를 입력하세요");

    }
    @ParameterizedTest(name ="{index} {displayName} message={0}")
    @ValueSource( strings ={ "12","sfsr","qwert"})
    @DisplayName("문자열 처리 테스트")
    void StringTest(String num){
        IllegalArgumentException e=assertThrows(IllegalArgumentException.class,
                () -> new play(Integer.parseInt(num)));
        String message = e.getMessage();
        assertEquals(message,"숫자를 입력하세요");
    }
}
