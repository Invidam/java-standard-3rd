package ch04;

public class SwitchTest {

    void getSeason(int month) {
        System.out.println("month = " + month);
        switch (month) {
            case 3:
            case 4:
            case 5:
                System.out.println("Spring");
                break;
            case 6:
            case 7:
            case 8:
                System.out.println("Summer");
                break;
            case 9:
            case 10:
            case 11:
                System.out.println("Fall");
                break;
            default:
                System.out.println("Winter");
        }
    }
    public static void main(String[] args) {
        SwitchTest app = new SwitchTest();
        for(int i=0;i<12;++i) app.getSeason(i + 1);
    }
}
