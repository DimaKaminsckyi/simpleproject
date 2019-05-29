package DAO;

import entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.math.BigInteger;
import java.util.List;

public class DepartmentDAO {

    private Session session;

    public DepartmentDAO(Session session){
        this.session = session;
    }

    public BigInteger showStatistic(String departmentName){
        Query query = session.
                createSQLQuery("SELECT count(lectors_id) FROM department_lectors " +
                        "Inner Join department d on d.id = department_id and d.name = :departmentName ;");
        query.setParameter("departmentName" , departmentName);
        BigInteger size = (BigInteger) query.getSingleResult();
        return size;
    }

    public List<Integer> getSalary(String departmentName){
        Query query = session.createSQLQuery(
                "Select sum(salary)/count(salary) from lectors " +
                        "Inner join department_lectors dl on dl.lectors_id = lectors.id " +
                        "Inner join department d on d.id = dl.department_id and d.name = :departmentName ;"
        );
        query.setParameter("departmentName" , departmentName);
        List result = query.list();
        return result;
    }


    public String getHeadOfDepartment(String departmentName){
        Query query = session
                .createSQLQuery("Select full_name From lectors " +
                        "Inner Join department_lectors dl on dl.lectors_id = lectors.id and lectors.degree = 'Head_of_Department' " +
                        "Inner Join department d on d.id = dl.department_id and name = :departmentName ;");
        query.setParameter("departmentName" , departmentName);
        String result = (String) query.getSingleResult();
        return result;
    }

    public void addDepartment(Department department) {
        session.save(department);
    }
}
