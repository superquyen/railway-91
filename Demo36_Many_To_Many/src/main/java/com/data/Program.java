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
        Program program= new Program();
        program.addSinhVien();
    }
    public void addSinhVien() {
        Session session = null;
        try{
            session = buildSessionFactory().openSession();
            session.beginTransaction();
            MonHocSinhVien monHocSinhVien1 = new MonHocSinhVien();

            SinhVien sinhVien1 = new SinhVien();
//            sinhVien.setFullName("Tran Duc Bo");
            sinhVien1.setId(1);
//            sinhVien.setGioiTinh(GioiTinh.Nam);
            MonHoc monHoc1 = new MonHoc();
            monHoc1.setId(3);
//            monHoc1.setName("tieng viet");
//            monHoc1.setSoBuoi(10);
//            monHoc.setSoGio(100);
            monHocSinhVien1.setMonHoc(monHoc1);
            monHocSinhVien1.setSinhVien(sinhVien1);

            session.save(monHocSinhVien1);
            MonHocSinhVien monHocSinhVien2 = new MonHocSinhVien();
            SinhVien sinhVien2 = new SinhVien();
            sinhVien2.setId(2);
            monHocSinhVien2.setSinhVien(sinhVien2);
            monHocSinhVien2.setMonHoc(monHoc1);
            session.save(monHocSinhVien2);
            session.getTransaction().commit();

        }catch (Exception exception){
            System.out.println(exception.getMessage());
        }
    }
        public static void showMonHoc () {
            Session session = null;
            try {
                session = buildSessionFactory().openSession();

                Query<MonHoc> query = session.createQuery("FROM MonHoc ");
                List<MonHoc> monHocs = query.getResultList();
                monHocs.forEach(obj -> System.out.println(obj.toString()));
            } catch (Exception ex) {
                System.out.println(ex.getMessage());
            }
        }

    private static SessionFactory buildSessionFactory(){
        Configuration configuration = new Configuration();
        configuration.configure("hibernate.cfg.xml");
        configuration.addAnnotatedClass(SinhVien.class);
        configuration.addAnnotatedClass(MonHoc.class);
        configuration.addAnnotatedClass(MonHocSinhVien.class);
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties()).build();
        return configuration.buildSessionFactory(serviceRegistry);
    }
}
