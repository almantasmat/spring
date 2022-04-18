package hibernate.demo;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteSpringCourseDAO {
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

//            get Spring course from db
            int id = 12;
            Course course = session.get(Course.class, id);
            System.out.println("Deleting course: " + course);
//            delete Sprig
            session.delete(course);

            session.getTransaction().commit();
        }finally {
//            add clean up code
            session.close();
            sessionFactory.close();
        }
    }

}
