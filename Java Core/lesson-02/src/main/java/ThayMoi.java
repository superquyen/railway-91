import java.sql.SQLOutput;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ThayMoi {
    public static void main(String[] args) throws ParseException {
        Scanner sc = new Scanner(System.in);
//        System.out.println("Mời bạn nhập số thứ nhất: ");
//        int a = sc.nextInt();
//        System.out.println("Mời bạn nhập số thứ hai: ");
//        int b = sc.nextInt();
//        System.out.println("moi ban nhap so thu 3: ");
//        int c = sc.nextInt();
//        System.out.println("cac so ban da nhap la " + a + b + c);
//        System.out.println("nhap so thu 4: ");
//        Double d = sc.nextDouble();
//        System.out.println("nhap so thu 5 ");
//        Double e = sc.nextDouble();
//        System.out.println("2 so thuc ma ban da nhap la: " + d +","+ e);
//
//        String sinhNhat = sc.next();
//        String hoTen = sc.nextLine();
//        String birthDay ="dd-mm-yyyy";
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(birthDay);
//        Date date = simpleDateFormat.parse(sinhNhat);
//        System.out.println("Input" + date);
//        sc.close();
        System.out.println("nhap ID account:");
        Account acc = new Account();
        int id = sc.nextInt();
        switch (id){
            case 1:
                System.out.println(PositionName.DEV);
                break;
            case 2:
                System.out.println(PositionName.TEST);
                break;
            case 3:
                System.out.println(PositionName.SCRUM_MASTER);
                break;
            case 4:
                System.out.println(PositionName.PM);
            default:
                System.out.println("nhap loi");
                break;
        }

    }
}
