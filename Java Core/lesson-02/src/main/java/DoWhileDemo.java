public class DoWhileDemo {
    public static void main(String[] args) {
        for (int i = 2; i <= 10; i += 2){
            System.out.println(i);

        }
        int i = 2;
        do {
            System.out.println(i);
            i += 2;
        }while(i<= 10);
    }
}
