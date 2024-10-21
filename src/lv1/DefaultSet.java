package lv1;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class DefaultSet { // 게임 시작시 숫자 자리수를 설정하는 class
    private int digit =0;
    Random random =new Random();
    Set<Integer> numberset = new HashSet<Integer>();
    private int randomNum = 0;


    public void setDigit(int n){ // 숫자 자리수 설정 메서드
        digit = n;
    }

    public int getDigit() { //설정된 자리수 확인메서드
        return digit;
    }

    public void setNumber(){ //랜덤 수 set add
        while(numberset.size()!=digit){
            randomNum = (int) (Math.random() * 9)+1;
            numberset.add(randomNum);
        }
    }


}
