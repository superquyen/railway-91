import java.util.Scanner;

public class Exercise3 {
    public static void main(String[] args) {
        // question1
        String a = "abc def acd";
        System.out.println(a.length());

        String[] words = a.split("\\s+");
        System.out.println("Số từ trong xâu: " + words.length);

        String b = " ope ";
        String c = "def";
        System.out.println(b+c);

        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten bat ky: ");
        String d = sc.nextLine().trim();
        String[] abc = d.split("\\s+");
        String chuCaidau = d.substring(0,1);
        boolean chu = d.matches("^[A-Z]+");
        if(!chu){
            String tenMoi = d.substring(0,1).toUpperCase()+d.substring(1);
            System.out.println(tenMoi);
        }
        Scanner scb = new Scanner(System.in);
        System.out.println("Nhap 1 so bat ky 5 chu so tro xuong: ");
        int so = scb.nextInt();
        String number = String.format("%05d", so);

        System.out.println("so nay la: " + number);
        String convert = number.substring(3);
        System.out.println("hai so cuoi : "+ convert);
        int haiTu = so % 100;
        System.out.println("Hai so cuoi cung: " + haiTu);

    }
}
