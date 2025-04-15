package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import java.util.List;

public class DepartmentRepository {

    public void CreateNewGroup() {


        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Group group = new Group();


            System.out.println("Mời bạn nhập tên Group");
            group.setName(ScannerUtils.inputFullName());
            System.out.println("Mời bạn nhập ngày tạo Group");
            group.setCreateDate(ScannerUtils.inputLocalDate());
            session.save(group);
            session.getTransaction().commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

    }
    public void getAllGroups(){
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Group> groupQuery = session.createQuery("From Group");
            List<Group> groups = groupQuery.getResultList();
            groups.forEach(obj->{

                System.out.println(obj.toString());

            });
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public void getGroupById() {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            Query<Group> query = session.createQuery("FROM Group WHERE id = :id");
            System.out.println("Mời bạn nhập Group id cần tìm");

            query.setParameter("id", ScannerUtils.inputInt());
            Group group = query.getSingleResultOrNull();

            if (group == null) {
                System.out.println("Group không tồn tại");
            } else {
                System.out.println(group.toString());

    }

        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }

    }
    public void getGroupByName(){
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Group> query = session.createQuery("FROM Group WHERE name= :name");
            System.out.println("Nhập tên group bạn cần tìm");
            query.setParameter("name", ScannerUtils.inputString());
            Group group = query.getSingleResultOrNull();
            if(group== null){
                System.out.println("Không tồn tại group có tên này");
            }else{
                System.out.println(group.toString());
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void updateGroup(){
        Session session = null;
        session = buildSessionFactory().openSession();
        Query<Group> query = session.createQuery("FROM Group WHERE id =:id ");
        System.out.println("Nhập id Group bạn muốn cập nhật: ");
        query.setParameter("id", ScannerUtils.inputInt());
        Group group = query.getSingleResultOrNull();
        if(group!=null){
            System.out.println("Mời bạn cập nhật tên mới: ");
            group.setName(ScannerUtils.inputString());
            System.out.println("Mời bạn cập nhật ngày tạo group mới: ");
            group.setCreateDate(ScannerUtils.inputLocalDate());
        }else{
            System.out.println("Không tồn tại Group này");
        }
    }
    public void deleteGroup(){
        Session session = null;
        session = buildSessionFactory().openSession();
        session.beginTransaction();
        Query<Group> query= session.createQuery("FROM Group WHERE id=:id");
        System.out.println("Mời bạn nhập id Group cần xoá: ");
        query.setParameter("id",ScannerUtils.inputInt());
        Group group= query.getSingleResultOrNull();
        if(group==null){
            System.out.println("Group khong ton tai");
        }else{
            session.delete(group);
            session.getTransaction().commit();
            System.out.println("Bạn đã xoá thành công");
            System.out.println(group.toString());
        }

    }
    public boolean isGroupExistsById(){
        Session session = null;
        session = buildSessionFactory().openSession();
        Query<Group> query = session.createQuery("FROM Group WHERE id=:id");
        System.out.println("Mời bạn nhập vào Group id để xác nhận");
        query.setParameter("id",ScannerUtils.inputInt());
        Group group= query.getSingleResult();
        if(group== null){
            System.out.println("Không tồn tại group này");
            return false;
        }else{
            System.out.println("có group này");
            System.out.println(group.toString());
            return true;
        }
    }
    public boolean isGroupExistsByName(){
        Session session = null;
        session = buildSessionFactory().openSession();
        Query<Group> query = session.createQuery("FROM Group WHERE name=:name");
        System.out.println("Mời bạn nhập vào Group name để xác nhận");
        query.setParameter("name", ScannerUtils.inputString());
        Group group=  query.getSingleResult();
        if(group== null){
            System.out.println("Group này không tồn tại");
            return false;
        }else{
            System.out.println(" tồn tại Group này");
            System.out.println(group.toString());
            return true;
        }
    }


    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Group.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }

}
