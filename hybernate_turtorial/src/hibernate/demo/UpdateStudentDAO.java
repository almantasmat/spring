package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateStudentDAO {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//    create session
        Session session = sessionFactory.getCurrentSession();
        try {
            int studentId = 1;


            session = sessionFactory.getCurrentSession();
//            update student obj
   //            start transaction
            session.beginTransaction();
//            save student obj
            System.out.println("getting student whit id " + studentId);

            Student student = session.get(Student.class, studentId);
            System.out.println("get complete");

            student.setLastName("Scoooby");
//            comint transaction

            session.getTransaction().commit();
            System.out.println("done");

//            new code
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
            session.getTransaction().commit();

//            delete
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
            session.createQuery("DELETE FROM Student WHERE id=" + studentId);
            session.getTransaction().commit();
        }finally {
            sessionFactory.close();
        }
    }

}
