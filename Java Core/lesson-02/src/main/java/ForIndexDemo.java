public class ForIndexDemo {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i += 2 )
            System.out.println("i = " + i);
        for(int i = 10; i >= 2; i= i-2) {
            System.out.println(i);
        }
        String[] fruits = {" cam ", "le ", "xoai", "tao"};
        for (int i = 0; i < fruits.length; i ++){
            System.out.println(fruits[i]);
        }

    }

}
