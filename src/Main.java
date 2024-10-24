

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import display.OptionDisplay;

public class Main {


    static Map<Integer, Integer> gameMap = new HashMap<Integer, Integer>();
    static OptionDisplay optionDisplay = new OptionDisplay();
    static Scanner sc = new Scanner(System.in);
    private static int GAME_NUM = 0;


    public static void main(String[] args) {

        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        label:
        while (true) {
            optionDisplay.displayOption();
            String selectNum = sc.next();
            switch (selectNum) {
                case "1":
                    goPlay(3);
                    break;
                case "2":
                    getGameMap();
                    break;
                case "3":
                    System.out.println("<숫자 야구 게임을 종료합니다.>");
                    break label;
                case "0":
                    checkDigit(sc);
                    break;
                default:
                    System.out.println("다시 입력해주세요");
                    break;
            }
        }
    }



    //entrySet() 메서드를 사용하여 게임기록 출력
    public static void getGameMap() {
        for (Map.Entry<Integer, Integer> entry : gameMap.entrySet()) {
            System.out.printf("%s번째 게임 -> %s번 시도하여 성공\n", entry.getKey(), entry.getValue());
        }
    }
    // BaseballGame 객체 생성 & 게임 시작
    public static void goPlay(int digit) {
        BaseballGame baseballGame = new BaseballGame(digit);
        GAME_NUM++;
        int gameCount = baseballGame.play();
        gameMap.put(GAME_NUM, gameCount);
    }

    //입력받은 자리수가 숫자인지 확인하고 숫자이면자리수를 설정하고 게임을 시작
    public static void checkDigit(Scanner sc) {
        System.out.println("설정 하고자 하는 자리수(3~5)를 입력하세요.");
        String digitNum = sc.next();
        if (digitNum.length() >= 2) {
            System.out.println("1자리수만 가능합니다.");
            checkDigit(sc);
        } else {
            switch (digitNum) {
                case "0","1","2","6","7","8","9": checkDigit(sc);
                break;
                default :
                    try {
                        Integer.parseInt(digitNum);
                        goPlay(Integer.parseInt(digitNum));
                    } catch (Exception e) {
                        checkDigit(sc);
                    }
                    break;
            }
        }
    }
}
