package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteCorseDAO {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
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
//            get a course
            int id = 10;
            Course course = session.get(Course.class, id);
//            delete course
            System.out.println("deleting course: " + course);
            if(course != null){
                session.delete(course);
            }
//           comit transaction
            session.getTransaction().commit();
            System.out.println("new entity craeted succesfully");
        }finally {
//            add clean up code
            session.close();
            sessionFactory.close();
        }
    }

}
