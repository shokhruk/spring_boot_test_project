package com.example.spring_boot_project.dao;


import com.example.spring_boot_project.entity.Employee;
import org.hibernate.Session;;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class EmployeeDaoImplementation implements EmployeeDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Employee> getAllEmployees() {
        Session session = entityManager.unwrap(Session.class);
        List<Employee> allEmployees = session.createQuery("from Employee", Employee.class)
                .getResultList();

        return allEmployees;
    }

//    @Override
//    public void setEmployee(Employees employee) {
//        Session session = sessionFactory.getCurrentSession();
//        session.saveOrUpdate(employee);
//    }
//
//    @Override
//    public Employees getEmployee(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Employees employee = session.get(Employees.class, id);
//        return employee;
//    }
//
//    @Override
//    public void deleteEmployee(int id) {
//        Session session = sessionFactory.getCurrentSession();
//        Employees employee = session.get(Employees.class, id);
//        session.delete(employee);
//    }


}
