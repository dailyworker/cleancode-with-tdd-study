package util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class RandomUtil {

    public static final int RANDOMIZED_NUMBER = 10000;

    @Test
    void create(){
        for(int i =0; i < RANDOMIZED_NUMBER; i++){
            assertTrue(() -> {
                if(RandomGenerator.create() > 0 || RandomGenerator.create() < 10){
                    return true;
                } else {
                    return false;
                }
            });
        }
    }


}
