

import display.BaseballGameDisplay;

import java.util.*;

public class BaseballGame {
    private final int digit ;
    private int intPutNum = 0;
    private int gameNum = 0;
    private int currentStrike = 0;
    private int currentBall = 0;
    BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();

    Set<Integer> numberset = new HashSet<Integer>();
    List<Integer> CorrectList;
    List<Integer> inputList = new ArrayList<Integer>();

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame(int digit) {
        this.digit = digit;
        createCorrectList();
    }

    public int play() {

        while (true) {

            System.out.println("중복되지않는 숫자 " + digit + "자리를 입력해주세요(0은 제외)");
            while (true) {
                // 1. 유저에게 입력값을 받음
                checkNumber();
                // 2. 올바른 입력값을 받았는지 검증
                if (!checkDigit()) {
                    System.out.println(digit + "자리로 입력해주세요");
                } else if (checkZeroNum()) {
                    System.out.println("0을 제외한 숫자를 입력해주세요");
                } else if (!checkDuplication()) {
                    System.out.println("중복된 숫자는 입력할수없습니다.");
                } else {
                    // 3. 게임 진행횟수 증가
                    gameNum++;
                    // 4. 스트라이크,ball 계산
                    countPoint();
                    // 점수화면 출력
                    baseballGameDisplay.displayHint(currentStrike, currentBall, digit);
                    break;
                }
            }
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (currentStrike == digit) {
                System.out.println("*****정답입니다.*****");
                break;
            }
            // 7. 힌트 출력
            getHint(gameNum, digit);
        }
        // 게임 진행횟수 반환
        return gameNum;
    }


    // 자리수 확인
    public boolean checkDigit() {
        return (int) (Math.log10(intPutNum) + 1) == digit;
    }

    // 0 포함여부 확인
    public boolean checkZeroNum() {
        String str = "" + intPutNum;
        return str.contains("0");
    }

    //중복 숫자여부 확인
    public boolean checkDuplication() {
        String str = "" + intPutNum;
        if (inputList.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                inputList.add((Integer.parseInt(str.substring(i, i + 1))));
            }
        } else {
            for (int i = 0; i < str.length(); i++) {
                inputList.set(i, (Integer.parseInt(str.substring(i, i + 1))));
            }
        }
        return digit == inputList.stream().distinct().count();
    }

    //숫자 입력 메서드
    private void checkNumber() {
        try {
            Scanner sc = new Scanner(System.in);
            intPutNum = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            checkNumber();
        }
    }

    //strike , ball 계산 메서드
    private void countPoint() {
        int strikecount = 0;
        int ballcount = 0;
        for (int i = 0; i < digit; i++) {
            if (CorrectList.get(i) == inputList.get(i)) {
                strikecount++;
            } else if (CorrectList.get(i) != inputList.get(i)) {
                if (CorrectList.contains(inputList.get(i))) {
                    ballcount++;
                }
            }
        }
        currentStrike = strikecount;
        currentBall = ballcount;
    }

    //게임시도 횟수와 , 설정난이도 자리수에 따른 힌트 출력 메서드
    public void getHint(int gameNum, int digit) {
        for (int i = 1; i <= digit; i++) {
            if (gameNum >= 5 * i) {
                System.out.println(i + "번째 자리는 : " + CorrectList.get(i - 1));
            }
        }
    }

    //1~9까지 랜덤한수로 Collection 배열에 대입
    public void createCorrectList(){
        while (numberset.size() != digit) {
            int randomNum = (int) (Math.random() * 9) + 1; //1부터9까지 랜덤수 생성
            numberset.add(randomNum);
        }
        CorrectList = new ArrayList<Integer>(numberset); //유저가 입력한 배열과 비교하기위해 Set->List 로변환
        Collections.shuffle(CorrectList);
        System.out.println(CorrectList.toString());
    }
}
