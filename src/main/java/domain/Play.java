package domain;

import java.util.List;

public class Play {
    CarList carList;
    int round;

    public Play(CarList carList, int round) {
        this.carList = carList;
        this.round = round;
    }
    public static Play of(String round){
        CarList cars=null;
        validate(round);
        return new Play(cars,Integer.parseInt(round));

    }
    public static Play paying(int round, List<String> names){
        int r = round;
        CarList carList = CarList.form(names);
        return new Play(carList,r);
    }
    public CarList playOneRound() {
        this.round--;
        return carList.move();
    }

    public boolean isGameOver() {
        if(this.round>0)
            return false;
        return true;
    }

    public List<String> getResult() {

        return Winner.FindWinner(carList);
    }
    private static void validate(String ngame){
        validateNotInteger(ngame);
        validateExceedCount(ngame);
    }

    private static void validateExceedCount(String ngame){
        Integer ngame1 = Integer.parseInt(ngame);
        if(ngame1>30||ngame1<1){
            throw new IllegalArgumentException("The number should be from 1 to 30.");
        }
    }
    private static void validateNotInteger(String ngame){
        String str = ngame;
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);
            if(Character.isDigit(tmp)==false)
                throw new IllegalArgumentException("Must be a number");
        }
    }



}
