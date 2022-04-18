package com.springbooot.cruddemo.dao;


import com.springbooot.cruddemo.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao{

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
//        create query
        Query query = entityManager.createQuery("from Employee");
//        execute query and get result list
        List<Employee> employees = query.getResultList();
//        return results
        return employees;
    }

    @Override
    public Employee findById(int id) {
//        E
        Employee employee = entityManager.find(Employee.class, id);
        return employee;
    }

    @Override
    public void save(Employee employee) {
//        save or update Employee
        Employee emmployee1 = entityManager.merge(employee);
//        update whitt id from db so we can get generated id
        employee.setId(emmployee1.getId());
    }

    @Override
    public void deleteById(int id) {
//        delete whit primary key
        Query query = entityManager.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
