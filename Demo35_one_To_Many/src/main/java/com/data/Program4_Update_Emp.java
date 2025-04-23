package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Program4_Update_Emp {
    public static void main(String[] args) {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Employee>query = session.createQuery("FROM Employee WHERE id = 2");
            Employee employee = query.getSingleResultOrNull();
            if(employee == null) {
                System.out.println("khong co emp nao co id nay");
                return;
            }else {
                employee.setPhone("12345679");
            }
            session.save(employee);
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

