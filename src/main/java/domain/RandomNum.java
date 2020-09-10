package domain;

import java.util.Random;

public class RandomNum {
    public int movenumber(){
        int number=0;
        if(random()>=4)
            number=1;
        return number;
    }
    public int random(){
        Random randomnum = new Random();
        return randomnum.nextInt(10);
    }
}
