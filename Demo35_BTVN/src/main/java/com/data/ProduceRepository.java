package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;
import java.util.Scanner;

public class ProduceRepository {
        Scanner sc2 = new Scanner(System.in);
    public void showAllProduces() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Produce> query = session.createQuery("FROM Produce ");
            List<Produce> produceList = query.getResultList();
            produceList.forEach(obj->{
                System.out.println(obj.toString());
                TypeProduce typeProduce = obj.getTypeProduce();
                if(typeProduce != null){
                    System.out.println(typeProduce.toString());
                }else {
                    System.out.println("sản phẩm này chưa được phân loại");
                }

            });
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void showProduceByID() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Produce> query = session.createQuery("FROM Produce WHERE id=: id");
            System.out.println("Mời bạn nhập id sản phẩm cần tìm");
            query.setParameter("id", ScannerUtils.inputInt());
            Produce produce = query.getSingleResultOrNull();
            if(produce != null){
                System.out.println(produce.toString());
                TypeProduce typeProduce = produce.getTypeProduce();
                System.out.println(typeProduce.toString());
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void addNewProduce() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Produce produce = new Produce();
            System.out.println("Mời bạn nhập tên sản phẩm mới");
            produce.setName(ScannerUtils.inputString());
            System.out.println("Mời bạn nhập giá");
            produce.setPrice(ScannerUtils.inputDouble());
            System.out.println("Mời bạn nhập số lượng tồn kho");
            produce.setStock(ScannerUtils.inputInt());
            System.out.println("Mời bạn nhập ngày sản xuất");
            produce.setCreateDate(ScannerUtils.inputLocalDate());
            TypeProduce typeProduce = new TypeProduce();
            System.out.println("Mời bạn nhập loại sản phẩm");
            typeProduce.setType(ScannerUtils.inputString());
            typeProduce.setProduce(produce);
            session.save(produce);
            session.save(typeProduce);
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void updateProduce() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Produce>query = session.createQuery("FROM Produce WHERE id=:id");
            System.out.println("Mời bạn nhập id sản phẩm muốn sửa");
            query.setParameter("id", ScannerUtils.inputInt());
            Produce produce = query.getSingleResultOrNull();
            if(produce != null){
                System.out.println("Mời bạn sửa lại tên");
                produce.setName(ScannerUtils.inputString());
                System.out.println("Mời bạn sửa lại giá ");
                produce.setPrice(ScannerUtils.inputDouble());
                System.out.println("Mời bạn sửa lại số lượng tồn kho");
                produce.setStock(ScannerUtils.inputInt());
                System.out.println("Mời bạn sửa lại ngày sản xuất");
                produce.setCreateDate(ScannerUtils.inputLocalDate());

            }else {
                System.out.println("không có sản phẩm có id như trên");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteProduce() {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();

            System.out.println("Mời bạn nhập vào id của sản phẩm muốn xoá");
            int id = ScannerUtils.inputInt();
            Query<Produce>query = session.createQuery("FROM Produce WHERE id=:id");
            query.setParameter("id", id);
            Produce produce = query.getSingleResultOrNull();
            if (produce == null) {
                System.out.println("Không tồn tại sản phẩm có id này");
                return;
            }
            Query<TypeProduce> query1 = session.createQuery("FROM TypeProduce WHERE produce.id=:produce_id");
            query1.setParameter("produce_id", id);
            TypeProduce typeProduce = query1.getSingleResultOrNull();
            if (ScannerUtils.confirmYesNo("Bạn có chắc chắn muốn xoá sản phẩm này không?")) {

                if (typeProduce != null) {
                    session.delete(typeProduce);
                }
                session.delete(produce);
                session.getTransaction().commit();
                System.out.println("Đã xoá thành công!");

            } else {
                System.out.println("Hủy thao tác xoá.");
                session.getTransaction().rollback();
            }

        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
    }

    public void findProduceByName() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Produce> query = session.createQuery("FROM Produce WHERE name=:name");
            System.out.println("Mời bạn nhập tên sản phẩm");
            query.setParameter("name", ScannerUtils.inputString());
            Produce produce = query.getSingleResultOrNull();
            if(produce != null){
                System.out.println(produce.toString());
                TypeProduce typeProduce = produce.getTypeProduce();
                System.out.println(typeProduce.toString());
            }else{
                System.out.println("Không có sản phẩm có tên bạn vừa nhập, vui lòng nhập lại");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void findProduceByPrice() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Produce>query = session.createQuery("FROM Produce WHERE price>:price");
            System.out.println("Mời bạn nhập giá sản phẩm bạn muốn tìm (sẽ hiển thị sản phẩm có giá đó trở lên)");
            query.setParameter("price", ScannerUtils.inputDouble());
            Produce produce = query.getSingleResultOrNull();
            if(produce != null){
                System.out.println(produce.toString());
                TypeProduce typeProduce = produce.getTypeProduce();
                System.out.println(typeProduce.toString());
            }else{
                System.out.println("Không có sản phẩm có giá bạn vừa nhập, vui lòng nhập lại");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void findProduceByCreatedDate() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Produce> query = session.createQuery("FROM Produce WHERE createDate>:createDate");
            System.out.println("Mời bạn nhập ngày sản xuất để tìm sản phẩm (sẽ hiển thị những sản phẩm từ ngày bạn nhập tới nay)");
            query.setParameter("createDate", ScannerUtils.inputLocalDate());
            Produce produce =query.getSingleResultOrNull();
            if(produce != null){
                System.out.println(produce.toString());
                TypeProduce typeProduce = produce.getTypeProduce();
                System.out.println(typeProduce.toString());
            }else{
                System.out.println("Không có sản phẩm có ngày sản xuất bạn vừa nhập, vui lòng nhập lại");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Produce.class);
        configuration.addAnnotatedClass(TypeProduce.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }


}
