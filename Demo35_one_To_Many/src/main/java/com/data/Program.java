package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Program {
    public static void main(String[] args) {
    Program.allDepartment();

    }
    public void creatDepartment() {
        Session session = null;
        try {
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Department department = new Department();
            department.setId(2);
            department.setDepartmentName("Sale");
            department.setAddress("HN");
            session.save(department);
            session.getTransaction().commit();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    public static  void allDepartment(){
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            Query<Department>query = session.createQuery("FROM Department ");
            List<Department>departments= query.getResultList();
            departments.forEach(obj-> System.out.println(obj.toString()));

            Query<Employee>query1 = session.createQuery("FROM Employee ");
            List<Employee> employees = query1.list();
            employees.forEach(obj2-> System.out.println(obj2.toString()));

//            Department department1 = employee.getDepartment();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void updateDepartment(){
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Department>query = session.createQuery("FROM Department WHERE id = 2");
            Department department = query.getSingleResultOrNull();
            if(department != null){
                department.setAddress("DN");
                department.setDepartmentName("KAKA");
            }
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void deleteDepartment(){
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Department>query = session.createQuery("FROM Department WHERE id = 2");
            Department department = query.getSingleResultOrNull();
            if(department != null) {
                session.delete(department);
            }
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Department.class);
        configuration.addAnnotatedClass(Employee.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
