package com.tap.model;

import com.tap.entities.Employee;
import com.tap.entities.Project;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;

public class ManyTOMany {
    public static void main(String[] args) {
        SessionFactory sessionFactory  = null;
        Session session = null;
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .addAnnotatedClass(Employee.class)
                    .addAnnotatedClass(Project.class)
                    .buildSessionFactory();

            //Create Session
            session = sessionFactory.openSession();

//            Create Transaction
            Transaction transaction = session.beginTransaction();

//             Curd Operation
            Employee alex=new Employee(1,"Alex","alex@gmail.com");
            Employee bob=new Employee(2,"bob","bob@gmail.com");
            Employee charli=new Employee(3,"Charli","Charli@gmail.com");

//          Creating Projects
            Project pr = new Project(1,"primerPro");
            Project af = new Project(2,"afterEffect");
//          Creating list to store projects given to empliyee
            ArrayList<Employee> prEmploye=new ArrayList<Employee>();
            ArrayList<Employee> afEmploye=new ArrayList<Employee>();

//            assigning employess to the premier pro project
            prEmploye.add(alex);
            prEmploye.add(bob);
            prEmploye.add(charli);
            pr.setEmployee(prEmploye);

//            assigning employees to the after effect project
            afEmploye.add(charli);
            afEmploye.add(bob);
            af.setEmployee(afEmploye);

            session.persist(alex);
            session.persist(bob);
            session.persist(charli);


            session.persist(pr);
            session.persist(af);
            transaction.commit();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
