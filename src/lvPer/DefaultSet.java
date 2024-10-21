package lvPer;

import java.util.HashSet;
import java.util.Set;

public class DefaultSet { // 게임 시작시 숫자 자리수를 설정하는 class
    private int digit = 0;
    Set<Integer> numberset = new HashSet<Integer>();

    // 숫자 자리수 set 메서드
    public void setDigit(int n){
        this.digit = n;
    }

    //설정된 자리수 get 메서드
    public int getDigit() {
        System.out.println("getDigit");
        System.out.println(this.digit);
        return this.digit;
    }

    //랜덤 수 set add
    public void setNumber(){
        while(numberset.size() != this.digit){
            int randomNum = (int) (Math.random() * 9) + 1; //1부터9까지 랜덤수 생성
            numberset.add(randomNum);
        }
    }


}
