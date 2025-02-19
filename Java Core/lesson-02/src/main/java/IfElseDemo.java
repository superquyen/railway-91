import java.util.Scanner;

public class IfElseDemo {
    public static void main(String[] args) {
        int age;
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhap tuoi vao di cung ");
        age = sc.nextInt();

        if ( age >= 18 ){
            System.out.println("bạn đã đủ tuổi rồi");
        }else{
            System.out.println("chưa đủ tuổi nha cưng");
        }
        Scanner sb = new Scanner(System.in);
        int month ;
        System.out.println("Nhập số tháng bạn muốn biết có bao nhiêu ngày ");
        month = sb.nextInt();
        if (month == 2){
            System.out.println(" Có 28 hoặc 29 ngày");

        }else if(month == 4 || month == 6 || month == 9 || month == 11){
            System.out.println(" có 30 ngày ");
        }else{
            System.out.println(" có 31 ngày");
        }
    }
}
