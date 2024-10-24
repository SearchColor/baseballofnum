

import display.BaseballGameDisplay;

import java.util.*;

public class BaseballGame {
    private final int DIGIT ;
    private int INPUT_NUM = 0;
    private int GAME_NUM = 0;
    private int CURRENT_STRIKE = 0;
    private int CURRENT_BALL = 0;
    BaseballGameDisplay baseballGameDisplay = new BaseballGameDisplay();

    Set<Integer> numberSet = new HashSet<Integer>();
    List<Integer> correctList;
    List<Integer> inputList = new ArrayList<Integer>();

    // 객체 생성시 정답을 만들도록 함
    public BaseballGame(int DIGIT) {
        this.DIGIT = DIGIT;
        createCorrectList();
    }

    public int play() {

        while (true) {

            System.out.println("중복되지않는 숫자 " + DIGIT + "자리를 입력해주세요(0은 제외)");
            while (true) {
                // 1. 유저에게 입력값을 받음
                checkNumber();
                // 2. 올바른 입력값을 받았는지 검증
                if (!checkDIGIT()) {
                    System.out.println(DIGIT + "자리로 입력해주세요");
                } else if (checkZeroNum()) {
                    System.out.println("0을 제외한 숫자를 입력해주세요");
                } else if (!checkDuplication()) {
                    System.out.println("중복된 숫자는 입력할수없습니다.");
                } else {
                    // 3. 게임 진행횟수 증가
                    GAME_NUM++;
                    // 4. 스트라이크,ball 계산
                    countPoint();
                    // 점수화면 출력
                    baseballGameDisplay.displayHint(CURRENT_STRIKE, CURRENT_BALL, DIGIT);
                    break;
                }
            }
            // 5. 정답여부 확인, 만약 정답이면 break 를 이용해 반복문 탈출
            if (CURRENT_STRIKE == DIGIT) {
                System.out.println("*****정답입니다.*****");
                break;
            }
            // 7. 힌트 출력
            getHint(GAME_NUM, DIGIT);
        }
        // 게임 진행횟수 반환
        return GAME_NUM;
    }


    // 자리수 확인
    public boolean checkDIGIT() {
        return (int) (Math.log10(INPUT_NUM) + 1) == DIGIT;
    }

    // 0 포함여부 확인
    public boolean checkZeroNum() {
        String str = "" + INPUT_NUM;
        return str.contains("0");
    }

    //중복 숫자여부 확인
    public boolean checkDuplication() {
        String str = "" + INPUT_NUM;
        if (inputList.isEmpty()) { // 처음 inputList 에 값을 넣을때
            for (int i = 0; i < str.length(); i++) {
                inputList.add((Integer.parseInt(str.substring(i, i + 1))));
            }
        } else { // inputList 에 이미 값이 있을때
            for (int i = 0; i < str.length(); i++) {
                inputList.set(i, (Integer.parseInt(str.substring(i, i + 1))));
            }
        }
        return DIGIT == inputList.stream().distinct().count();
    }

    //숫자 입력 메서드
    private void checkNumber() {
        try {
            Scanner sc = new Scanner(System.in);
            INPUT_NUM = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("숫자를 입력해주세요");
            checkNumber();
        }
    }

    //strike , ball 계산 메서드
    private void countPoint() {
        int strikecount = 0;
        int ballcount = 0;
        for (int i = 0; i < DIGIT; i++) {
            if (correctList.get(i) == inputList.get(i)) {
                strikecount++;
            } else if (correctList.get(i) != inputList.get(i)) {
                if (correctList.contains(inputList.get(i))) {
                    ballcount++;
                }
            }
        }
        CURRENT_STRIKE = strikecount;
        CURRENT_BALL = ballcount;
    }

    //게임시도 횟수와 , 설정난이도 자리수에 따른 힌트 출력 메서드
    public void getHint(int GAME_NUM, int DIGIT) {
        for (int i = 1; i <= DIGIT; i++) {
            if (GAME_NUM >= 5 * i) {
                System.out.println(i + "번째 자리는 : " + correctList.get(i - 1));
            }
        }
    }

    //1~9까지 랜덤한수로 Collection 배열에 대입
    public void createCorrectList(){
        while (numberSet.size() != DIGIT) {
            int randomNum = (int) (Math.random() * 9) + 1; //1부터9까지 랜덤수 생성
            numberSet.add(randomNum);
        }
        correctList = new ArrayList<Integer>(numberSet); //유저가 입력한 배열과 비교하기위해 Set->List 로변환
        Collections.shuffle(correctList);
        System.out.println(correctList.toString());
    }
}
