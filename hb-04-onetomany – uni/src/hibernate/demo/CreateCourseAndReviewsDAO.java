package hibernate.demo;

import hibernate.demo.entity.Course;
import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import hibernate.demo.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateCourseAndReviewsDAO {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Instructor.class)
                .addAnnotatedClass(InstructorDetail.class)
                .addAnnotatedClass(Course.class)
                .addAnnotatedClass(Review.class)
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
//            create course
            Course course = new Course("Html");
//            add some reviews
            course.addReview(new Review("Super course"));
            course.addReview(new Review("Good course"));
            course.addReview(new Review("Bad course, you are and idiot"));
//            save course and leverage cascade course
            System.out.println("saving course: " + course);
            System.out.println("Saving reviews: " + course.getReviews());
            session.save(course);

            session.getTransaction().commit();
            System.out.println("new entity craeted succesfully");
        }finally {
//            add clean up code
            session.close();
            sessionFactory.close();
        }
    }

}
