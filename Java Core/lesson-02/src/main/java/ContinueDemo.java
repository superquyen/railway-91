public class ContinueDemo {
    public static void main(String[] args) {
        //Thoát ra khỏi vòng lặp ngay lập tức
        for (int i = 1 ; i < 10; i++){
            if ( i == 3){
                continue;
            }
            System.out.println(i);
        }
        int z = 0;
        while(z < 10){
            if(z != 3){
                System.out.println("z la: "+z);

            }
            z++;

        }
    }
}
