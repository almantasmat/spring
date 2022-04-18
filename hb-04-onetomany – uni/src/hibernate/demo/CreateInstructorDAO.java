package hibernate.demo;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateInstructorDAO {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .buildSessionFactory();
//    create session
        Session session = sessionFactory.getCurrentSession();
        try {
//            create obj
            Instructor instructor = new Instructor("Petras", "Jonaitis", "jonas@one.lt");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/petras", "kasis");
//            associate obj
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
//            save student obj
            System.out.println("saving student");
            session.save(instructor);
//            comint transaction
            session.getTransaction().commit();
            System.out.println("new entity craeted succesfully");
        }finally {
            sessionFactory.close();
        }
    }

}
