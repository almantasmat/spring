package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateStudentDAO {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//    create session
        Session session = sessionFactory.getCurrentSession();
        try {
//            create student obj
            System.out.println("creating new student obj");
            Student student = new Student("Jonas", "Jonaitais", "Jonas1@one.lt");
//            start transaction
            session.beginTransaction();
//            save student obj
            System.out.println("saving student");
            session.save(student);
//            comint transaction
            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            sessionFactory.close();
        }
    }

}
