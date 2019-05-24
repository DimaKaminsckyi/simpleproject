package util.records;

import entity.Degree;
import entity.Department;
import entity.Lectors;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class GenerateRecords {

    public static void generate(Session session) {
        session.beginTransaction();

        List<Department> departments = new ArrayList<Department>();
        List<Lectors> lectors = new ArrayList<Lectors>();

        Department department = new Department("Biology" ,lectors);
        Department department1 = new Department("Law" , lectors);
        departments.add(department);
        departments.add(department1);


        Lectors lectors1 = new Lectors( Degree.Assistant , "John John" ,1000 , departments);
        Lectors lectors2 = new Lectors(Degree.Assistant  , "Mike Mike" ,1000 ,departments);
        Lectors lectors3 = new Lectors(Degree.Head_of_Department  , "Jack Jack" ,2000 ,departments);
        Lectors lectors4 = new Lectors(Degree.Associate_Professor  , "Julia Julia" ,1500 , departments);
        lectors.add(lectors1);
        lectors.add(lectors2);
        lectors.add(lectors3);
        lectors.add(lectors4);

        session.saveOrUpdate(department);
        session.saveOrUpdate(department1);

        session.saveOrUpdate(lectors1);
        session.saveOrUpdate(lectors2);
        session.saveOrUpdate(lectors3);
        session.saveOrUpdate(lectors4);



        session.getTransaction().commit();
    }
}
