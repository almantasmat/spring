package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class ReadStudentDAO {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//    create session
        Session session = sessionFactory.getCurrentSession();
        try {
//            create student obj
            System.out.println("creating new student obj");
            Student student = new Student("Mantas", "Kalnietis", "Mantas@one.lt");
//            start transaction
            session.beginTransaction();
//            save student obj
            System.out.println("saving student");
            System.out.println(student);
            session.save(student);
//            comint transaction
            session.getTransaction().commit();

//            find out student id: primary key
            System.out.println("saved student. Generated id:" + student.getId());
//            get a new session and start transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();
//            retrieve student based on id: primary key
            System.out.println("Getting student whit Id: " + student.getId());
            Student student1 = session.get(Student.class, student.getId());

            session.getTransaction().commit();
            System.out.println("Get complete: " + student1);

            System.out.println("done");
        }finally {
            sessionFactory.close();
        }
    }

}
