package hibernate.demo;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteJonasStudentDAO {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//    create session
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();
//            get student Jonas from db
            int id = 2;
            Student student = session.get(Student.class, id);
            System.out.println("Loaded student: " + student);
            System.out.println("Courses: " + student.getCourses());
//            delete student
            System.out.println("Deleting student: " + student);
            session.delete(student);
            session.getTransaction().commit();
        }finally {
//            add clean up code
            session.close();
            sessionFactory.close();
        }
    }

}
