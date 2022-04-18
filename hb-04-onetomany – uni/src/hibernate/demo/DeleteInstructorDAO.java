package hibernate.demo;

import hibernate.demo.entity.Instructor;
import hibernate.demo.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDAO {
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
//get instructor by primary key /id
            int id = 1;
            Instructor instructor2 = session.get(Instructor.class, id);
            System.out.println("found instructor: " + instructor2);
//            delete instructor
            if (instructor2 != null) {

                System.out.println("deleting instructor id: " + id);
                session.delete(instructor2);
            }
//            comint transaction
            session.getTransaction().commit();
//            will also delete associatioted details object, becouse of CacadeType.ALL
        }finally {
            sessionFactory.close();
        }
    }

}
