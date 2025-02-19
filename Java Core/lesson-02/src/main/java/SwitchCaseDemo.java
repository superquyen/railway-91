public class SwitchCaseDemo {
    public static void main(String[] args) {
        int month = 5;
        switch (month){
            case 2 :
                System.out.println(" Có 28 hoặc 29 ngày ");
                break;
            case 4 :

            case 6 :

            case 9 :

            case 11:
                System.out.println(" co 30 ngay");
                break;
            default:
                System.out.println("co 31 ngay");
                break;

        }
    }
}
