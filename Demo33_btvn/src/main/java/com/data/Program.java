package com.data;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DepartmentRepository dp = new DepartmentRepository();
        while (true) {
            String leftAlignFormat = "| %-54s |%n";
            System.out.format("+--------------------------------------------------------------+%n");
            System.out.format("|--------------   MỜI BẠN CHỌN CHỨC NĂNG  ---------------------|%n");
            System.out.format("+--------------------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. CreateGroups");
            System.out.format(leftAlignFormat, "2. GetAllGroup");
            System.out.format(leftAlignFormat, "3. getGroupById");
            System.out.format(leftAlignFormat, "4. getGroupByName");
            System.out.format(leftAlignFormat, "5. updateGroup");
            System.out.format(leftAlignFormat, "6. deleteGroup");
            System.out.format(leftAlignFormat, "7. isGroupExistsByID");
            System.out.format(leftAlignFormat, "8. isGroupExistsByName");
            System.out.format(leftAlignFormat, "9.Exit");
            System.out.format("+--------------------------------------------------------+%n");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                   dp.CreateNewGroup();
                    System.out.println("Tạo mới Group thành công");
                    break;
                case 2:
                    System.out.println("Tất cả các group");
                    dp.getAllGroups();
                    break;
                case 3:
                    dp.getGroupById();
                    break;

                case 4:
                    dp.getGroupByName();
                    return;
                case 5:
                    dp.updateGroup();
                    System.out.println("Cập nhật group thành công!");
                    break;
                case 6:
                    dp.deleteGroup();
                    break;
                case 7:
                    dp.isGroupExistsById();
                    break;
                case 8:
                    dp.isGroupExistsByName();
                    break;
                case 9:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ");
                    return ;
                default:
                    System.out.println("chọn lại số");
                    break;
            }
        }

    }


}
