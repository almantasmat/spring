package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseDAO {
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
//  get instructor from db
            int id = 2;
            Instructor instructor1 = session.get(Instructor.class, id);
//            creat some courses
            Course course = new Course("Spring");
            Course course1 = new Course("DB");
//            add courses to instructor
            instructor1.add(course);
            instructor1.add(course1);
//            save courses
            session.save(course);
            session.save(course1);
            session.getTransaction().commit();
            System.out.println("new entity craeted succesfully");
        }finally {
//            add clean up code
            session.close();
            sessionFactory.close();
        }
    }

}
