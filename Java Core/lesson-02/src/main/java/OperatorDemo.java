public class OperatorDemo {
    public static void main(String[] args) {
        // +, -, *, /, %
        System.out.println("5 + 3 = " + (5 + 3));
        System.out.println("5 - 3 = " + (5 - 3));
        System.out.println("5 * 3 = " + (5 * 3));
        System.out.println("5 / 3 = " + (5.0 / 3));
        System.out.println("5 % 3 = " + (5 % 3));

        // +=, -=, *=, /=, %=
        int a = 10;
        a = a % 10;
        System.out.println("a = " + a);

        // ++ , --
        int b = 100;
        int c = ++b;
        // b = b + 1; sau do int c = b;
        System.out.println("b = " + b);
        System.out.println("c = " + c);

        int m = 100;
        int n = m++;
        // int n = m; sau do m = m + 1;
        System.out.println("m = " + m);
        System.out.println("n = " + n);

        // >, <, >=, <=, ==, !=
        boolean u = 5 >3 ;
        System.out.println("u = " + u);

        // &&(AND) , ||(OR) , ! (NOT)
        boolean notTrue = !true;
        System.out.println("notTrue = " + notTrue);
    }
}
