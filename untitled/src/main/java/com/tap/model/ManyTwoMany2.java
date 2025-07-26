package com.tap.model;

import com.tap.entities.Employee;
import com.tap.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ManyTwoMany2 {
    public static void main(String[] args) {
        SessionFactory sessionFactory = null;
        Session session = null;
        try {

//            Creating Session Factory
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Project.class)
                    .buildSessionFactory();
//            Creating Session
            session = sessionFactory.openSession();

//            Creating Transaction Object
            Transaction transaction = session.beginTransaction();

//            Curd Operation
//            Employee employee=session.byId(Employee.class).load(2);
//            List<Project> projects=employee.getProjects();

            Project project = session.byId(Project.class).load(1);
             List<Employee> employee =project.getEmployee();

            System.out.println(project);
            for(Employee p:employee) {
                System.out.print(p);
            }


transaction.commit();
        } catch (Exception e) {
            System.out.print("Exception Is Occured");
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
