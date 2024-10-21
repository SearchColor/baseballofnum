

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Map<Integer,Integer> gameMap = new HashMap<Integer,Integer>();
    private static int gameNumber =0;
    private static int gameCount =0;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("환영합니다! 원하시는 번호를 입력해주세요");
        while(true) {
            // BaseballGame 객체 생성 & 게임 시작
            BaseballGame baseballGame =new BaseballGame();
            System.out.println("1. 게임시작하기 2.게임 기록 보기 3.종료하기");
            String selectNum = sc.next();
            if (selectNum.equals("1")) {
                gameNumber++;
                gameCount = baseballGame.play();
                addGameMap();
            } else if (selectNum.equals("2")) {
                getGameMap();
            } else if (selectNum.equals("3")) {
                System.out.println("<숫자 야구 게임을 종료합니다.>");
                break;
            }else{
                System.out.println("다시 입력해주세요");
            }
        }
    }
    //게임 기록 메서드
    public static void addGameMap(){
        gameMap.put(gameNumber,gameCount);
    }
    public static void getGameMap(){
        for (Map.Entry<Integer, Integer> entry : gameMap.entrySet()) {
            System.out.printf("%s번째 게임 -> %s번\n", entry.getKey(), entry.getValue());
        }
    }

}