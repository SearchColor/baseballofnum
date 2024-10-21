

import java.util.*;

public class BaseballGame {
    private int digit = 3;
    private int intPutNum = 0;
    private int gameNum = 0;
    private int currentStrike=0;
    private int currentBall=0;
    BaseballGameDisplay baseballGameDisplay= new BaseballGameDisplay();

    Set<Integer> numberset = new HashSet<Integer>();
    List<Integer> CorrectList ;
    List<Integer> inputList = new ArrayList<Integer>();

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame(int digit) {
        this.digit= digit;
        while(numberset.size() != digit){
            int randomNum = (int) (Math.random() * 9) + 1; //1부터9까지 랜덤수 생성
            numberset.add(randomNum);
        }
        CorrectList = new ArrayList<Integer>(numberset);
        System.out.println(numberset.toString());
    }

    public int play() {
        while (true) {
            // 1. 유저에게 입력값을 받음
            System.out.println("중복되지않는 숫자 "+digit+"자리를 입력해주세요(0은 제외)");
            while (true){  // 2. 올바른 입력값을 받았는지 검증
                intputNumber();
                if(!checkDigit()){
                    System.out.println(digit+"자리로 입력해주세요");
                } else if (checkZeroNum()) {
                    System.out.println("0을 제외한 숫자를 입력해주세요");
                } else if (!checkDuplication()){
                    System.out.println("중복된 숫자는 입력할수없습니다.");
                }else{
                    // 3. 게임 진행횟수 증가
                    addGameNum();
                    // 4. 스트라이크 개수 계산
                    countStrike();
                    // 6. 볼 개수 계산
                    countBall();
                    baseballGameDisplay.displayHint(currentStrike,currentBall);
                    break;
                }
            }
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if(currentStrike==digit){
                System.out.println("*****정답입니다.*****");
                break;
            }
            // 7. 힌트 출력
            if(gameNum >= 5 && gameNum < 10){
                getHint();
            } else if (gameNum >= 10) {
                getHint2();
            }

        }
        // 게임 진행횟수 반환
        return gameNum;
    }
    // 자리수 확인
    public boolean checkDigit(){
        return (int) (Math.log10(intPutNum) + 1) == digit;
    }
    // 0 포함여부 확인
    public boolean checkZeroNum(){
        String str = ""+intPutNum;
        return str.contains("0");
    }

    //중복 숫자여부 확인
    public boolean checkDuplication(){
        String str = ""+intPutNum;
        if(inputList.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                inputList.add((Integer.parseInt(str.substring(i, i + 1))));
            }
        }else{
            for (int i = 0; i < str.length(); i++) {
                inputList.set(i,(Integer.parseInt(str.substring(i,i+1))));
            }
        }
//        System.out.println("inputList size : "+inputList.stream().distinct().count());
        return digit == inputList.stream().distinct().count();
    }
    //숫자 입력 메서드
    private void intputNumber(){
        try {
            Scanner sc = new Scanner(System.in);
            intPutNum = sc.nextInt();
        }catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            intputNumber();
        }
    }
    //게임카운트 증가 메서드
    private void addGameNum(){gameNum++;}

    private int countStrike() {
        int strikecount = 0;
        for(int i=0;i<digit ; i++){
            if(CorrectList.get(i) == inputList.get(i) ){
                strikecount ++;
            }
        }
        currentStrike = strikecount;
        return strikecount;
    }

    private int countBall() {
        int ballcount = 0;
        for(int i=0;i<digit ; i++){
            if(CorrectList.get(i) != inputList.get(i) ){
                if(CorrectList.contains(inputList.get(i))){
                    ballcount++;
                }
            }
        }
        currentBall = ballcount;
        return ballcount;
    }
    public void setDigit(int n){
        digit = n;
    }

    public void getHint() {
        System.out.println("첫번째 자리는 : " + CorrectList.get(0));
    }
    public void getHint2() {
        System.out.println("두번째 자리는 : " + CorrectList.get(1));
    }
}
