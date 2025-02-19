import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" nhap ten ban zo ");

        if (sc.hasNextInt()) {
            String ten = sc.nextLine();
            System.out.println("nhap tuoi ban zo: ");
            int age = sc.nextInt();
            System.out.println(" ten cua ban la: " + ten);
            System.out.println(" tuoi cua ban la: " + age);
        }else{
            System.out.println(" nhap loi ");
        } sc.close();
    }
}

