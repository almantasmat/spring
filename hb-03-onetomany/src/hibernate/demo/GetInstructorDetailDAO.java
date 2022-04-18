package hibernate.demo;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetInstructorDetailDAO {
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
//            get InstructorDetail object
            int id = 3;
            InstructorDetail instructorDetail1 = session.get(InstructorDetail.class, id);
//            print InstructorDeatail obj.
            System.out.println("Geted instructor detail: " + instructorDetail1);
//            print associated
            System.out.println("Associated Instructor: " + instructorDetail1.getInstructor());
//            now lets delete instructor detail;
            System.out.println("deleting instructor detail: " + instructorDetail1);
            session.delete(instructorDetail1);
            session.getTransaction().commit();
        } catch (Exception exception){
            exception.printStackTrace();
        }
        finally {
//            handle connection leak issue
            session.close();
            sessionFactory.close();
        }
    }

}
