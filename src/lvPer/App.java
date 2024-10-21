package lvPer;


public class App {
    public static void main(String[] args) {
        DefaultSet defaultSet = new DefaultSet();

        InputProcessing inputProcessing = new InputProcessing();
        inputProcessing.setDigit(3);
         //게임 숫자 자리수 3 기본설정

        defaultSet.getDigit();
//        System.out.println("0을 제외한 숫자를 3자리 입력해주세요."+defaultSet.getDigit());
        inputProcessing.readNumber();

    }

}
