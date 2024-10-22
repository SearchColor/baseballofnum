

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer,Integer> gameMap = new HashMap<Integer,Integer>();
    static BaseballGame baseballGame;
    static Scanner sc = new Scanner(System.in);
    private static int gameNumber =0;
    private static int gameCount =0;
    public static void main(String[] args) {


        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        while(true) {
            // BaseballGame 객체 생성 & 게임 시작
            System.out.println("0.자리수 설정 1. 게임시작하기 2.게임 기록 보기 3.종료하기");
            String selectNum = sc.next();
            if (selectNum.equals("1")) {
                goPlay(baseballGame,3);
            } else if (selectNum.equals("2")) {
                getGameMap();
            } else if (selectNum.equals("3")) {
                System.out.println("<숫자 야구 게임을 종료합니다.>");
                break;
            } else if (selectNum.equals("0")) {
                checkDigit(sc);
            } else{
                System.out.println("다시 입력해주세요");
            }
        }
    }
    //게임 기록 메서드
    public static void addGameMap(){gameMap.put(gameNumber,gameCount);}
    public static void getGameMap(){
        for (Map.Entry<Integer, Integer> entry : gameMap.entrySet()) {
            System.out.printf("%s번째 게임 -> %s번\n", entry.getKey(), entry.getValue());
        }
    }
    public static void goPlay(BaseballGame baseballGame ,int digit){
        baseballGame =new BaseballGame(digit);
        gameNumber++;
        gameCount = baseballGame.play();
        addGameMap();
    }

    //입력받은 자리수가 숫자인지 확인하고 숫자이면자리수를 설정하고 게임을 시작하는 메서드
    public static void checkDigit(Scanner sc ){
        System.out.println("설정 하고자 하는 자리수(1~9)를 입력하세요.");
        String digitNum = sc.next();
        if(digitNum.length()>=2){
            System.out.println("1자리수만 가능합니다.");
            checkDigit(sc);
        }else {
            if (digitNum.equals("0")){
                checkDigit(sc);
            }else{
                try {
                    Integer.parseInt(digitNum);
                    goPlay(baseballGame,Integer.parseInt(digitNum));
                }
                catch (Exception e) {
                    checkDigit(sc);
                }
            }
        }

    }
}