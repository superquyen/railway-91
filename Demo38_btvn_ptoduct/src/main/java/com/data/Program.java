package com.data;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductRepository pr = new ProductRepository();
        while (true) {
            String leftAlignFormat = "| %-54s |%n";
            System.out.format("+--------------------------------------------------------------+%n");
            System.out.format("|--------------   MỜI BẠN CHỌN CHỨC NĂNG  ---------------------|%n");
            System.out.format("+--------------------------------------------------------------+%n");
            System.out.format(leftAlignFormat, "1. Print all products");
            System.out.format(leftAlignFormat, "2. Get product by id");
            System.out.format(leftAlignFormat, "3. get product by name");
            System.out.format(leftAlignFormat, "4. get product by price");
            System.out.format(leftAlignFormat, "5. Add new product");
            System.out.format(leftAlignFormat, "6. update product");
            System.out.format(leftAlignFormat, "7. delete product by id");
            System.out.format(leftAlignFormat, "8. delete product by quantity");
            System.out.format(leftAlignFormat, "9.Exit");
            System.out.format("+--------------------------------------------------------+%n");
            int choose = sc.nextInt();
            switch (choose) {
                case 1:
                    System.out.println("Hiển thị toàn bộ product");
                    pr.printAllProducts();
                    break;

                case 2:
                    pr.getProductByID();
                    break;
                case 3:
                    pr.getProductByName();
                    break;

                case 4:
                    pr.getProductByPrice();
                    break;
                case 5:
                    pr.addNewProduct();
                    System.out.println("Thêm mới sản phẩm thành công");
                    break;
                case 6:
                    pr.updateProduct();
                    break;
                case 7:
                    pr.deleteProductById();
                    break;
                case 8:
                    pr.deleteProductByQuantity();

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
