package com.data;



import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProduceRepository produceRepository = new ProduceRepository();
        TypeProduceRepository typeProduceRepository = new TypeProduceRepository();
        while (true) {
            String leftAlignFormat = "| %-54s |%n";
            System.out.format("+--------------------------------------------------------+%n");
            System.out.format("|--------------   MỜI BẠN CHỌN CHỨC NĂNG  ---------------|%n");
            System.out.format("+--------------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. Show All Types");
            System.out.format(leftAlignFormat, "2. Add new Type");
            System.out.format(leftAlignFormat, "3. Update type");
            System.out.format(leftAlignFormat, "4. Delete type");
            System.out.format(leftAlignFormat, "5. Show All Produce");
            System.out.format(leftAlignFormat, "6. Show by id Produce");
            System.out.format(leftAlignFormat, "7. Add New Produce");
            System.out.format(leftAlignFormat, "8. Update Produce");
            System.out.format(leftAlignFormat, "9. Delete Produce");
            System.out.format(leftAlignFormat, "10. Find Produce by name");
            System.out.format(leftAlignFormat, "11. Find Produce by Price");
            System.out.format(leftAlignFormat, "12. Find Produce by Created Date");
            System.out.format(leftAlignFormat, "13.Exit");
            System.out.format("+--------------------------------------------------------+%n");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Tất cả các thể loại");
                    typeProduceRepository.showAllTypes();
                    break;
                case 2:
                    typeProduceRepository.addNewType();
                    break;
                case 3:
                    typeProduceRepository.updateType();
                    break;
                case 4:
                    typeProduceRepository.deleteType();
                    break;
                case 5:
                    produceRepository.showAllProduces();
                    break;
                case 6:
                    produceRepository.showProduceByID();
                    break;
                case 7:
                    produceRepository.addNewProduce();
                    System.out.println("Bạn đã thêm thành công sản phẩm mới");
                    break;
                case 8:
                    produceRepository.updateProduce();
                    System.out.println("Cập nhật thông tin sản phẩm thành công");
                    break;
                case 9:
                    produceRepository.deleteProduce();
                    break;
                case 10:
                    produceRepository.findProduceByName();
                    break;
                case 11:
                    produceRepository.findProduceByPrice();
                    break;
                case 12:
                    produceRepository.findProduceByCreatedDate();
                    break;
                case 13:
                    System.out.println("Cảm ơn bạn đã sử dụng dịch vụ");
                    return ;
                default:
                    System.out.println("chọn lại số");
                    break;
            }
        }

    }


}
