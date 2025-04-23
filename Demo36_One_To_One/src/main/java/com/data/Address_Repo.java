package com.data;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;

import java.util.List;

public class Address_Repo {
    public void addAddress() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
//            person.setAddress();
            Address address = new Address();
            address.setCity("DN");
            address.setStreet("Le Loi");
            Person person = new Person();
//            address.setPerson();
//            address.setPerson(id, 2);
            session.save(address);
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void updateAddress() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Address> query = session.createQuery("FROM Address WHERE id = 2");
            Address address = query.getSingleResultOrNull();
            if(address!=null){
//                person.setAddress();
               address.setStreet("leductho");
               address.setCity("Govap");
            }else{
                System.out.println("khong co dia chi nay");
            }
            session.save(address);
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void deleteAddress() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Address>query = session.createQuery("FROM Address WHERE id = 1");
            Address address = query.getSingleResultOrNull();
            if(address != null){
                session.detach(address);
            }else{
                System.out.println("khong ton tai noi nay");
            }
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void test () {
        Session session = null;
        try {

            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Person> query = session.createQuery("FROM Person");
            List<Person> personList = query.getResultList();
            personList.forEach(person -> {
                System.out.println(person.getId());
                System.out.println(person.getFullName());
                System.out.println(person.getEmail());
                System.out.println(person.getPhone());
                Address address = person.getAddress();
                if (address != null) {
                    System.out.println("Street: " + address.getStreet());
                    System.out.println("City: " + address.getCity());
                } else {
                    System.out.println("person nay khong co dia chi");
                }
            });


        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }


    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(Person.class);
        configuration.addAnnotatedClass(Address.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}


