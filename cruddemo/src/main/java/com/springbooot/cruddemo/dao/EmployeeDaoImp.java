package com.springbooot.cruddemo.dao;

import com.springbooot.cruddemo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImp implements EmployeeDao{
//    define field for entity manager
    private EntityManager entityManager;
//    set up constructor injection
    @Autowired
    public  EmployeeDaoImp(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
//        get current hibernate session
        Session session = entityManager.unwrap(Session.class);
//        creat query
      Query<Employee> query = session.createQuery("FROM Employee", Employee.class);
//        execute query and get result list
        List<Employee> employees = query.getResultList();
//        return result
        return employees;
    }

    @Override
    public Employee findById(int id) {
//        get curent hibernate sesion
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
//        Employee employee = findById(id);
//        session.delete(employee);

        Query query = session.createQuery("DELETE FROM Employee where id = : employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
