package service;

public class PlayCount {

    Integer count; // 플레이 횟수

    public PlayCount(Integer num) {
    }

    public void PlayConut(Integer count) {
        validate(count);
        this.count = count;
    }

    public void validate(Integer count) {
        CheckIsString(count);
        CheckOverNum(count);
        CheckUnderNum(count);
    }

    public void CheckIsString(Integer count) {
        if(!Character.isDigit(count))
            throw new IllegalArgumentException("PlayCount must be number.");
    }

    public void CheckOverNum(Integer count) {
        if(count > 30)
            throw new IllegalArgumentException("PlayCount must be under than 30.");
    }

    public void CheckUnderNum(Integer count) {
        if(count < 1)
            throw new IllegalArgumentException("PlayCount must be over than 0.");
    }
}
