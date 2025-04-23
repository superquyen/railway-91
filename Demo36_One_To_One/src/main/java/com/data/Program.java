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
        Program program = new Program();
//        program.addPerson();
        program.updateIdpersonvaoIdaddress();
//        program.updatePerson();
//        Address_Repo address_repo = new Address_Repo();
//        address_repo.updateAddress();
    }
    public void addPerson() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Person person = new Person();
            person.setFullName("Tran Van CC");
            person.setPhone("0867890976");
            person.setEmail("TranVccc@gmail.com");
//            person.setAddress();
            Address address = new Address();
            address.setCity("sdftyu");
            address.setStreet("ojhgf");
            address.setPerson(person);
            session.save(address);
            session.save(person);
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void updatePerson() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Person>query = session.createQuery("FROM Person WHERE id = 1");
            Person person = query.getSingleResultOrNull();
            if(person!=null){
//                person.setAddress();
                person.setEmail("ngaoig@gmail.com");
                person.setFullName("nguyen alo");
            }else{
                System.out.println("khong co nguoi nay");
            }
            session.save(person);
            session.getTransaction().commit();
        }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public void deletePerson() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Person>query = session.createQuery("FROM Person WHERE id = 1");
            Person person = query.getSingleResultOrNull();
            if(person != null){
                session.delete(person);
            }else{
                System.out.println("khong ton tai nguoi nay");
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
    public void updateIdpersonvaoIdaddress() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            Query<Person>query = session.createQuery("FROM Person WHERE id = 2");
            Query<Address>queryaddress = session.createQuery("FROM Address WHERE id = 2");
            Query<Address> addressQuery2 = session.createQuery("FROM Address WHERE person =: person_id");
            Person person = query.getSingleResultOrNull();
            Address address = queryaddress.getSingleResultOrNull();
            if(addressQuery2 !=null){
                System.out.println("da co nguoi nay");
                return;
            }else{
                address.setPerson(person);
            }
            session.save(address);
            session.getTransaction().commit();
        }catch (Exception ex){
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
