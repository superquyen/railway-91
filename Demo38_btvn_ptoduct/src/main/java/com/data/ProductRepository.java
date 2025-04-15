package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class ProductRepository {

    public void printAllProducts() {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            Query<Product> query = session.createQuery("FROM Product");
            List<Product> productList = query.getResultList();
            productList.forEach(obj-> System.out.println(obj.toString())
            );
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getProductByID() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Product> query = session.createQuery("FROM Product WHERE id=:id");
            System.out.println("Mời bạn nhập Id product cần tìm: ");
            query.setParameter("id",ScannerUtils.inputInt());
            Product product= query.getSingleResultOrNull();
            if(product== null){
                System.out.println("Không có Product này");
            }else{
                System.out.println("Đã tìm thấy: ");
                System.out.println(product.toString());
            }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getProductByName() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Product>query=session.createQuery("FROM Product WHERE name=:name");
            System.out.println("Mời bạn nhập tên sản phẩm cần tìm: ");
            query.setParameter("name", ScannerUtils.inputString());
            Product product = query.getSingleResultOrNull();
            if(product== null){
                System.out.println(" Không có sản phẩm nào có tên bạn tìm");
            }else {
                System.out.println("Đã tìm thấy: ");
                System.out.println(product.toString());
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void getProductByPrice() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Product> query = session.createQuery("FROM Product WHERE price >:price");
            System.out.println("Mời bạn nhập giá sản phẩm cần tìm");
            query.setParameter("price", ScannerUtils.inputIntPositive());
            List<Product> product = query.getResultList();
            product.forEach(obj-> System.out.println(obj.toString()));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void addNewProduct() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Product product = new Product();
            System.out.println("Mời bạn nhập tên sản phẩm mới");
            product.setName(ScannerUtils.inputString());
            System.out.println("Mời bạn nhập giá sản phẩm");
            product.setPrice(ScannerUtils.inputIntPositive());
            System.out.println("Mời bạn nhập nơi sản xuất");
            product.setCountry(ScannerUtils.inputString());
            System.out.println("Mời bạn nhập ngày sản xuất");
            product.setCreateDate(ScannerUtils.inputLocalDate());
            System.out.println("Mời bạn nhập số lượng sản phẩm: ");
            product.setQuantity(ScannerUtils.inputInt());
            session.save(product);
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void updateProduct() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();

            Query<Product> query = session.createQuery("FROM Product WHERE id=:id");
            System.out.println("Mời bạn nhập id sản phẩm muốn cập nhật");
            query.setParameter("id", ScannerUtils.inputInt());
            Product product = query.getSingleResultOrNull();
            if(product != null){
                System.out.println("Mời bạn nhập tên mới");
                product.setName(ScannerUtils.inputString());
                System.out.println("Mời bạn nhập giá mới");
                product.setPrice(ScannerUtils.inputIntPositive());
                System.out.println("Mời bạn nhập nơi sản xuất mới");
                product.setCountry(ScannerUtils.inputString());
                System.out.println("Mời bạn nhập ngày sản xuất mới");
                product.setCreateDate(ScannerUtils.inputLocalDate());
                System.out.println("Mời bạn nhập số lượng sản phẩm mới");
                product.setQuantity(ScannerUtils.inputInt());


            }else {
                System.out.println("Không có sản phẩm này");

            }
            session.save(product);
            session.getTransaction().commit();

        }catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteProductById() {
        Session session = null;
        try{
            session= buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Product>query = session.createQuery("FROM Product WHERE id=:id");
            System.out.println("mời bạn nhập Id sản phẩm cần xoá");
            query.setParameter("id", ScannerUtils.inputInt());
            Product product= query.getSingleResultOrNull();
            if(product!= null){
                session.delete(product);
            }else {
                System.out.println("không tồn tại product này");
            }

            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteProductByQuantity() {
        Session session = null;
        try{
            session= buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Product>query = session.createQuery("FROM Product WHERE quantity=:quantity");
            System.out.println("mời bạn nhập số lượng sản phẩm cần xoá");
            query.setParameter("quantity", ScannerUtils.inputInt());
            Product product= query.getSingleResultOrNull();
            if(product!= null){
                session.delete(product);
            }else {
                System.out.println("không tồn tại product này");
            }

            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Product.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
