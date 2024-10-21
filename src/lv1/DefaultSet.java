package lv1;

public class DefaultSet { // 게임 시작시 숫자 자리수를 설정하는 class
    private int digit =0;

    public void setDigit(int n){ // 숫자 자리수 설정 메서드
        digit = n;
    }

    public int getDigit() { //설정된 자리수 확인메서드
        return digit;
    }
}
