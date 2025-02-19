public class BreakDemo {
    public static void main(String[] args) {
        //Thoát ra khỏi vòng lặp ngay lập tức
        for (int i = 1 ; i < 10; i++){
            if ( i == 3){
                break;
            }
            System.out.println(i);
        }
    }
}
