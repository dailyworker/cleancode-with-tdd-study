import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import util.StringUtils;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsIterableContainingInAnyOrder.containsInAnyOrder;


class UserInputTest {

    @Test
    @DisplayName("사용자 이름을 올바르게 ,로 구분한 경우")
    void splitTest(){
        List<String> actual = StringUtils.parseByComma("seansin,sunmyoung,yena,jyoung");
        List<String> expected = Arrays.asList("sunmyoung", "jyoung", "seansin", "yena");
        assertThat(actual, containsInAnyOrder(expected.toArray()));  // static method

    }

}