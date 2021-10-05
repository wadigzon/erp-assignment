package com.erp.assignment.question2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.ListIterator;

@Component
public class EmployeesCollection {
    @Autowired
    List<Employee> collection;

    EmployeesCollection() {
    }

    public void addEmployee(Employee employee) {
        if (employee.getID() != null && employee.getName() != null) {
            collection.add(employee);
        }
    }
    public void printAllEmployees() {
        ListIterator<Employee> itr = collection.listIterator();
        while (itr.hasNext()) {
            System.out.println(itr.next().toString());
        }
    }
    @PostConstruct
    public void postCreation() {
        collection.clear();
    }
}
