public class TernaryDemo {
    public static void main(String[] args) {
        int a = 100;
        int b = 1000;
        int c = 99;
        int max = a > b ? a : b;
        System.out.println("max = " + max);

//        int a = 100;
//        int b = 1000;
//        int c = 99;
//        int max = a > b ? (a > c ? a : c) : (b > c ? b : c);
//        System.out.println("max = " + max);
    }
}
