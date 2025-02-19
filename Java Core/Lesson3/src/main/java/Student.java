public class Student {
    int id;
    String name;
    String fullname;
    double math ;

    public String toString(){
        return this.id + "";

    }
    public boolean equals(Object obj){
        Student student2 = (Student) obj;
        boolean flag = this.math == student2.math ? true : false;
        return flag;
    }

}
