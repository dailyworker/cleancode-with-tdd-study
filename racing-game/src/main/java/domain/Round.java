package domain;

import exception.RoundLengthOverflowException;

public class Round {

    private int round;

    public Round(String round) {
        validate(round);
        this.round = Integer.parseInt(round);
    }

    private void validate(String round) {
        checkIntegerFormat(round);
        checkLength(round);
    }

    private void checkIntegerFormat(String round) {
       try {
           Integer.parseInt(round);
       } catch (NumberFormatException e){
           throw new NumberFormatException("문자열을 입력하실 수 없습니다.");
       }
    }

    private void checkLength(String round) {
        int rounds = Integer.parseInt(round);
        if(rounds < 1 || rounds > 30){
            throw new RoundLengthOverflowException("라운드 횟수는 1보다 작거나 30보다 크면 안됩니다.");
        }
    }

    public int getRound() {
        return round;
    }

    public boolean isEnd() {
       return this.round == 0;
    }

    public void reduce(){
        if(isEnd()){
            throw new RuntimeException("모든 라운드가 종료 되었습니다.");
        }
        this.round--;
    }
}
