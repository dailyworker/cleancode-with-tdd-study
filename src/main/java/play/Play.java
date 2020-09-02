package play;

public class Play {
    Object ngame; //number of game

    public Play(Object ngame) {
        validate(ngame);
        this.ngame = ngame;
    }

    void validate(Object ngame){
        validateNotInteger(ngame);
        validateExceedCount(ngame);
    }

    void validateExceedCount(Object ngame){
        Integer ngame1 = Integer.parseInt(ngame.toString());
        if(ngame1>30||ngame1<1){
            throw new IllegalArgumentException("The number should be from 1 to 30.");
        }
    }
    void validateNotInteger(Object ngame){
        String str = ngame.toString();
        for(int i=0;i<str.length();i++){
            char tmp = str.charAt(i);
            if(Character.isDigit(tmp)==false)
                throw new IllegalArgumentException("Must be a number");
        }
    }
}
