package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class TypeProduceRepository {
    public void showAllTypes() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<TypeProduce>query = session.createQuery("FROM TypeProduce ");
            List<TypeProduce>typeProduceList = query.getResultList();
            typeProduceList.forEach(obj->
                    System.out.println(obj.toString()));
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void addNewType() {
        Session session = null;
        try{
            session= buildSessionFactory().openSession();
            session.beginTransaction();
            TypeProduce typeProduce = new TypeProduce();
            System.out.println("Mời bạn nhập mới thể loại");
            typeProduce.setType(ScannerUtils.inputString());
            session.save(typeProduce);
            session.getTransaction().commit();
            System.out.println("Cập nhật thành công");
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void updateType() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<TypeProduce>query = session.createQuery("FROM TypeProduce WHERE id=:id");
            System.out.println("Mời bạn nhập vào id thể loại muốn thay đổi");
            query.setParameter("id", ScannerUtils.inputInt());
            TypeProduce typeProduce = query.getSingleResultOrNull();
            if(typeProduce != null){
                System.out.println("Mời bạn đổi thể loại mới");
                typeProduce.setType(ScannerUtils.inputString());
                session.save(typeProduce);
                session.getTransaction().commit();
            }else{
                System.out.println("Không có id thể loại bạn muốn thay đổi");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }

    public void deleteType() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<TypeProduce>query = session.createQuery("FROM TypeProduce WHERE id=:id");
            System.out.println("Nhập vào id thể loại bạn muốn xoá");
            query.setParameter("id", ScannerUtils.inputInt());
            TypeProduce typeProduce = query.getSingleResultOrNull();
            if(typeProduce != null){
                if(ScannerUtils.confirmYesNo("Bạn có chắc chắn muốn xoá thể loại này không?")){
                    session.delete(typeProduce);
                    System.out.println("Xoá thành công");
                }else{
                    System.out.println("Huỷ thao tác xoá");
                    session.getTransaction().rollback();
                }
            }else {
                System.out.println("Không có thể loại bạn muốn xoá");
            }
            session.getTransaction().commit();
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
