package hibernate.demo;

import hibernate.demo.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDAO {
    public static void main(String[] args) {
        //    create session factory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
//    create session
        Session session = sessionFactory.getCurrentSession();
        try {
            session.beginTransaction();

//            query students
            List<Student> students = session.createQuery("FROM Student").getResultList();
//            display students
            System.out.println("Display all students: ");
            diplayStudents(students);

           List<Student> students1 = session.createQuery("FROM Student s WHERE s.lastName = 'Kestaitis'").getResultList();
            System.out.println("Display student whit lastname Kestaitis");
           diplayStudents(students1);

//           query students: lastnName Kestaitis Or firstName Jonas
            List<Student> students2 = session.createQuery("FROM Student s where s.lastName = 'Kestaitis' " +
                    "OR s.firstName = 'Jonas'").getResultList();
            System.out.println("Students whit last name Kestaitis or firstName Jonas");
            diplayStudents(students2);

            String lName = "ait";
            List<Student> students3 = session.createQuery("FROM Student s WHERE s.lastName LIKE '%" + lName + "%'").getResultList();
            System.out.println("atrinkti pagal like: ");
            diplayStudents(students3);

           session.getTransaction().commit();
            System.out.println("done");
        } finally {
            sessionFactory.close();
        }
    }

    public static void diplayStudents(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }
}
