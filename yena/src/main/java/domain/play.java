package domain;

public class play {

    Integer num;

    public play(Integer num) {
        Valid(num);
        this.num = num;
    }

    public Integer getNum() {
        return num;
    }
    public void Valid(Integer num){
        Valid_size(num);
        Valid_String(num);
        Valid_Positive(num);
    }

    private void Valid_String(Integer num) {
         if(!Character.isDigit(num)){
             throw new IllegalArgumentException("숫자를 입력하세요");
         }
    }

    private void Valid_size(Integer num) {
        if(num>=30){
            throw new IllegalArgumentException("정해진 범위내에 입력하세요");
        }
    }

    private void Valid_Positive(Integer num) {
        if(num<1)
            throw new IllegalArgumentException("양수를 입력하세요");
    }
}
