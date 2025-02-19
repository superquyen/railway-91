public class Main {
    public static void main(String[] args) {
       Student student = new Student();
       student.id= 1;
       student.fullname = " SuperQuyen";
       student.math = 10;
        System.out.println(student.toString());
        Student student2 = new Student();
        student2.id= 2;
        student2.fullname = " Super Huong";
        student2.math = 10;

        boolean flag = student.equals(student2);
        if (flag){
            System.out.println("Hai bạn sinh viên này bằng nhau");
        }else{
            System.out.println("Hai bạn sinh viên này không điểm bằng nhau");
        }
        Student student3 = student;

    }
}
