package display;

public class BaseballGameDisplay {
    public void displayHint(int strike, int ball , int digit) {
        int out = digit-strike-ball;
        System.out.println("strike : "+strike);
        System.out.println("ball : "+ball);
        System.out.println("out : "+out);
    }
}
