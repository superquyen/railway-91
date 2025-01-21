import java.time.LocalDate;
import java.util.Scanner;

public class DataTypeDemo {
    public static void main(String[] args) {
        // Kiểu số nguyên
        // byte, short, int , long
        // giá trị mặc định : 0
        int age = 25;
        System.out.println("age =" + age);

        // Kiểu số thực
        // float, double
        // giá trị mặc định: 0.0
        double score = 8.75f;

        System.out.println("score = " + score);
        char c = 'A';
        System.out.println("c = " + c);
        // Kiểu boolean
        // Giá trị mặc định : flase
        boolean isLoading = true;
        System.out.println("isLoading = " + isLoading);

        // Kiểu enum
        Gende gende = Gende.FEMALE;
        System.out.println("gende = " + gende);


        // Kiểu array
        int[] numbers = {1, 3, 5, 7, 9};
        // Chỉ số của array bắt đầu từ 0
        System.out.println("numbers[0] = " + numbers[0]);

        // length
        System.out.println("numbers.length = " + numbers.length);
        // Phần tử cuối cùng = độ dài của chuỗi đấy - 1
        int lastIndex = numbers.length-1;
        System.out.println("numbers[" + lastIndex + "] = " + numbers[lastIndex]);

        // Kiểu string
        String s = " Võ Long Quyền ";
        System.out.println("s = " + s);
        // Kiểu thời gian
        // LocalDate, LocalTime, LocalDateTime
        LocalDate today = LocalDate.now() ;
        System.out.println("today = " + today);
        LocalDate date = LocalDate.of(2003, 11,16);
        System.out.println("date = " + date);



    }
}