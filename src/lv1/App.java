package lv1;

public class App {
    public static void main(String[] args) {
        DefaultSet defaultSet = new DefaultSet();
        defaultSet.setDigit(3);
        defaultSet.setNumber();

        System.out.println(defaultSet.getDigit());
    }
}
