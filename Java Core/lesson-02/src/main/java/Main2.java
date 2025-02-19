public class Main2 {
    public static void main(String[] args) {
        Main2 main2 = new Main2();
        main2.goToSchool();
        if(main2.viTri() < 2){
            System.out.println("em gioi suc sac");
        }
    }
    // method khong co ket qua tra ve

    // void khono can ket qua tra ve
    public void goToSchool(){
        System.out.println("Em di den truong");
    }
    // method co ket qua tra ve
    public float viTri(){
        return 5;
    }
    

}
