package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class PrimaryKeyDemo {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//    create session
        Session session = sessionFactory.getCurrentSession();
        try {
//            create student 3 student
            System.out.println("creating 3 student");
            Student student = new Student("Jonas", "Jonaitais", "Jonas3@one.lt");
            Student student1 = new Student("Kestas", "Kestaitis", "Kestas4@one.lt");
            Student student2 = new Student("Petras", "Petraitis", "Petras5@one.lt");
//            start transaction
            session.beginTransaction();
//            save student obj
            System.out.println("saving students");
            session.save(student);
            session.save(student1);
            session.save(student2);
//            comint transaction
            session.getTransaction().commit();
            System.out.println("done");
        }finally {
            sessionFactory.close();
        }
    }

}
