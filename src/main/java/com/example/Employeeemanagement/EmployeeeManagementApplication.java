package com.example.Employeeemanagement;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;


@EnableCaching
@SpringBootApplication
public class EmployeeeManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeeManagementApplication.class, args);
		
		/*SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session1 = factory.openSession();
		Employees employees1= session1.get(Employees.class,1);
		System.out.println(employees1);
		session1.close();
		
		Session session2 = factory.openSession();
		Employees employees2= session1.get(Employees.class,1);
		System.out.println(employees2);
		session2.close();*/
	}

}
