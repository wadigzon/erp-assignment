package com.erp.assignment.question2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.time.LocalDateTime;

@SpringBootApplication
public class Question2Application {

	public static void main(String[] args) {
		SpringApplication.run(Question2Application.class, args);

		AnnotationConfigApplicationContext context =
				new AnnotationConfigApplicationContext(AppConfig.class);
		System.out.println("Application Started!");
		// create the single collection of employees
		EmployeesCollection employeesBucket = context.getBean(EmployeesCollection.class);
		// set up 1st employee (full time, non-manager)
		Employee emp1 = context.getBean(Employee.class);
		emp1.setId(1);
		emp1.setName("Jeff Johnson");
		emp1.setDateHired(LocalDateTime.now());
		employeesBucket.addEmployee(emp1);
		// set up 2nd employee (part-time, non-manager)
		Employee emp2 = context.getBean(Employee.class);
		emp2.setId(2);
		emp2.setName("Javel Diaz");
		emp2.setDateHired(LocalDateTime.now());
		emp2.setPartTime(true);
		employeesBucket.addEmployee(emp2);
		// set up 3rd employee (part-time-manager)
		Employee emp3 = context.getBean(Employee.class);
		emp3.setId(3);
		emp3.setName("Silvia Wong");
		emp3.setDateHired(LocalDateTime.now());
		emp3.setPartTime(true);
		emp3.setManager(true);
		employeesBucket.addEmployee(emp3);

		// we list all employees in the company
		employeesBucket.printAllEmployees();
		context.close();

	}

}
