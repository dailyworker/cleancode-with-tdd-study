package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static domain.Name.Split_String;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

public  class nameTest {


    @Test
    @DisplayName("잘 나눠지는지 테스트")
    void splitTest(){
        String str="abc,drg,gfdh,sdfa";
        HashSet  set1 =Name.Split_String(str);
        HashSet<String> set=new HashSet<String>();
        set.add("abc");
        set.add("drg");
        set.add("gfdh");
        set.add("sdfa");
        assertEquals(set1,set);
    }
    @Test
    @DisplayName("중복테스트")
    void DuplicateTest(){
        String value="abc";
        HashSet<String>  set =new HashSet<String>();
        set.add("abc");
        set.add("bcd");
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,() ->
                Name.Valid_Duplicate(set,value));
        String message =e.getMessage();
        assertEquals(message,"동일한 이름");
    }
    @Test
    @DisplayName("null값 확인")
    void nullTest(){
        NullPointerException e = assertThrows(NullPointerException.class,() ->
                new Name(null));
        String message =e.getMessage();
        assertEquals(e.getMessage(),null);

    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {"dgffs","fgdf","fdgfg","fdgfdgfg"})
    @DisplayName("5글자가 넘는지 테스트")
     void lengthTest(String Username){

        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,() -> new Name(Username));
        String message =e.getMessage();
        assertEquals(message,"길이가 깁니다");
    }

    @ParameterizedTest(name = "{index} {displayName} message = {0}")
    @ValueSource(strings = {""," ","  dd", "   ","    "})
    @DisplayName("공백이 있는지 확인하는 테스트")
    public void EmptyTest(String name){
        IllegalArgumentException e = assertThrows(IllegalArgumentException.class,() -> new Name(name));
        String message =e.getMessage();
        assertEquals(message,"공백을 입력할 수 없다");
    }


}