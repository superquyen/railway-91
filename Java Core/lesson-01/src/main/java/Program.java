public class Program {
    public static void main(String[] args) {
        Dog dog1 = new Dog();
        dog1.name = " Cooking Oil";
        dog1.age = 18;
        dog1.showInfor();
        int sum = dog1.sum(1, 99);
        System.out.println("sum = " + sum);
    }
}