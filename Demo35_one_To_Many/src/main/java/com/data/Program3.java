package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

public class Program3 {
    public static void main(String[] args) {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();

            Employee employee = new Employee();
            employee.setEmployeeName("NGuyen Van 3");

            Query<Department> query = session.createQuery("FROM Department WHERE id = 3");

            Department department = query.getSingleResultOrNull();
            if(department == null){
                return;
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
