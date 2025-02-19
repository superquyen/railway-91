import java.time.LocalDate;

public class Question02 {
    public static void main(String[] args) {
        Department dep1 = new Department();
        dep1.id = 1;
        dep1.name = "Marketing";
        Department dep2 = new Department();
        dep1.id = 2;
        dep1.name = "Sale";
        Department dep3 = new Department();
        dep1.id = 3;
        dep1.name = "BOD";

        Position pos1 = new Position();
        pos1.id = 1;
        pos1.name = PositionName.DEV;
        Position pos2 = new Position();
        pos1.id = 2;
        pos1.name = PositionName.TEST;
        Position pos3 = new Position();
        pos1.id = 3;
        pos1.name = PositionName.PM;

        Group group1 = new Group();
        group1.id = 1;
        group1.name = "Testing System";
        Group group2 = new Group();
        group1.id = 2;
        group1.name = "Development";
        Group group3 = new Group();
        group1.id = 3;
        group1.name = "Sale";

        Account acc1 = new Account();
        acc1.id = 1;
        acc1.email = "daonq1@gmail.com";
        acc1.username = "daonq1";
        acc1.fullName = "Nguyen Dao 1";
        acc1.department = dep1;
        acc1.position = pos1;
        acc1.createdDate = LocalDate.now();
        Group[] groupAcc1 = {group1, group2};
        acc1.groups = groupAcc1;
        Account acc2 = new Account();
        acc2.id = 2;
        acc2.email = "daonq2@gmail.com";
        acc2.username = "daonq2";
        acc2.fullName = "Nguyen Dao 2";
        acc2.department = dep2;
        acc2.position = pos2;
        acc2.createdDate = LocalDate.of(2021, 03, 17);
        acc2.groups = new Group[]{group3, group2};

        Account acc3 = new Account();
        acc3.id = 3;
        acc3.email = "daonq3@gmail.com";
        acc3.username = "daonq3";
        acc3.fullName = "Nguyen Dao 3";
        acc3.department = dep3;
        acc3.position = pos3;
        acc3.createdDate = LocalDate.now();

        System.out.println("Thông tin các Account trên hệ thống: ");
        System.out.println("Account 1 : ID : " + acc1.id + " Email: " +
                acc1.email + " UserName: " + acc1.username
                                            +" FullName: " + acc1.fullName + " Department: " +
                acc1.department.name + " Position: "
         + acc1.position.name + " Group: " + acc1.groups[0].name + " "+ acc1.groups[1].name + "CreateDate: " + acc1.createdDate);
        System.out.println("Account 2 : ID : " + acc2.id + " Email: " + acc2.email + " UserName: " + acc2.username + " Fullname: " + acc2.fullName + "" +
                " Department: " + acc2.department.name + " Position: " + acc2.position.name + " Group: " + acc2.groups[0].name
        + acc2.groups[1].name + " CreateDate: " + acc2.createdDate);
        System.out.println("Account 3: ID: " + acc3.id + " Email: " + acc3.email + " UserName: " + acc3.username + " Fullname: " + acc3.fullName
        +" Department: " + acc3.department.name + " Position: " + acc3.position.name + " Group: " + "Createdate: " + acc3.createdDate);

    }
}
