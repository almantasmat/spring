package com.springdemo.dao;

import com.springdemo.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
//   need to inject seesion factory
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public List<Customer> getCustomers() {
        //    get current hibernate session
        Session session = sessionFactory.getCurrentSession();

//    create query
        Query<Customer> query = session.createQuery("FROM Customer ORDER BY last_name", Customer.class);

//    execute query and get result list
        List<Customer> customers = query.getResultList();
//    return result
        return customers;
    }

    @Override
    public void saveCustomer(Customer customer) {
//        get current hybernate session
        Session session = sessionFactory.getCurrentSession();
//        save / update customer(finaly)
        session.saveOrUpdate(customer);
    }

    @Override
    public Customer getCustomer(int id) {
        Session session = sessionFactory.getCurrentSession();
        Customer customer = session.get(Customer.class, id);
        return customer;
    }

    @Override
    public void delete(int id) {
        Session session = sessionFactory.getCurrentSession();
//        delete obj whit primary key
  //      Query query = session.createQuery("DELETE FROM Customer where id =:customerId");
//        :customer kintamasis query
 //       query.setParameter("customerId", id);
 //       query.executeUpdate();
        Customer customer = getCustomer(id);
        session.delete(customer);
    }
}
