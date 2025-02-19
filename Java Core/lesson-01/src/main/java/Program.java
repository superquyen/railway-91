public class Program {
    public static void main(String[] args) {
       Department department = new Department();
       department.id = 1;
       department.name = "Giám đốc";
       System.out.println("Tên phòng  = " + department);
       Position position = new Position();
       position.id = 1;
       Account account = new Account();
       Group group = new Group();
       GroupAccount groupAccount = new GroupAccount();
       TypeQuestion typeQuestion = new TypeQuestion();
       CategoryQuestion categoryQuestion = new CategoryQuestion();
       Question question = new Question();
       Answer answer = new Answer();
       Exam exam  = new Exam();
       ExamQuestion examQuestion = new ExamQuestion();
    }
}