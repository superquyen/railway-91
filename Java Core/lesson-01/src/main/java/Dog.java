public class Dog {
    //  1. thuộc tính (property)
    String name;
    int age;
    // 2. Phương thức (method)
    int sum(int a, int b){
        return a + b;
    }
    void showInfor(){
        System.out.println("thông tin chó ");
        System.out.println("Tên:     " + name);
        System.out.println("Tuổi:    " + age);
    }
}
