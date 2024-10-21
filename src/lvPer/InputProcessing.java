package lvPer;

import java.util.InputMismatchException;
import java.util.Scanner;



public class InputProcessing extends DefaultSet {

    private int intPutNum = 0;
//    int digit = super.getDigit();

    public void readNumber(){

        try {
            Scanner sc = new Scanner(System.in);
            intPutNum = sc.nextInt();
            if(!checkDigit()){
                System.out.println("3자리 숫자를 입력해주세요.");
                readNumber();
            }
            if(checkZeroNum()){
                System.out.println("0을 포함할수없습니다.");
                readNumber();
            }
        }catch (InputMismatchException inputMismatchException) {
            System.out.println("숫자로 입력해주세요");
            readNumber();
        }
    }

    public boolean checkDigit(){
        return (int) (Math.log10(intPutNum) + 1) == super.getDigit();
    }

    public boolean checkZeroNum(){
        String str = ""+intPutNum;
        return str.contains("0");
    }

//    public void checkNum(){
//        try {
//            int intPutNum = readNumber();
//        } catch (Exception e) {
//            System.out.println("0을제외한 숫자 3자리를 다시 입력해주세요.");
//        }
//    }
//


//    public boolean checkDigit(){
//
//    }

}
