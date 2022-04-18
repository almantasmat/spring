package hibernate.demo;

import hibernate.demo.entity.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class AddCorsesForJonasDAO {
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
//            create obj
            Instructor instructor = new Instructor("Petras", "Jonaitis", "jonas@one.lt");
            InstructorDetail instructorDetail = new InstructorDetail("http://www.youtube.com/petras", "kasis");

            //            associate obj
            instructor.setInstructorDetail(instructorDetail);
            session.beginTransaction();
//            create course
            Course course = new Course("Html");
//save course
            System.out.println("Saving course: " + course);
            session.save(course);
            System.out.println("Saved course: " + course);
//            create student
            Student student1=new Student("Petras", "Petraitis", "pertras@one.lt");
            Student student2=new Student("Jonas", "Jonaitis", "jonas@one.lt");
//            add student to the course
            course.addStudent(student1);
            course.addStudent(student2);
//            save student
            System.out.println("saving student: ");
            session.save(student1);
            session.save(student2);
            System.out.println("Saved students: " + course.getStudents());
            session.getTransaction().commit();
            System.out.println("new entity craeted succesfully");
        }finally {
//            add clean up code
            session.close();
            sessionFactory.close();
        }
    }

}
