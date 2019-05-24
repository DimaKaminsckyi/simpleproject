package DAO;

import entity.Department;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class DepartmentDAO {

    private Session session;

    public DepartmentDAO(Session session){
        this.session = session;
    }

    public Integer showStatistic(String departmentName){
        Query query = session.
                createSQLQuery("Select count(lectors_id) From department_lectors Where department_id in " +
                        "(Select id From department Where name = :departmentName );");
        query.setParameter("departmentName" , departmentName);
        Integer size = (Integer) query.getSingleResult();
        return size;
    }

    public List<Integer> getSalary(String departmentName){
        Query query = session.createSQLQuery(
                "Select sum(salary)/count(salary) From task.lectors where id in" +
                        " (Select lectors_id From department_lectors where department_id in " +
                        "(Select id From department Where name = :departmentName));"
        );
        query.setParameter("departmentName" , departmentName);
        List result = query.list();
        return result;
    }


    public String getHeadOfDepartment(String departmentName){
        Query query = session
                .createSQLQuery("Select full_name FROM lectors WHERE degree = 'Head_of_Department' and lectors.id in" +
                " (Select lectors_id From department_lectors Where department_id in" +
                "(Select id from department where name = :departmentName));");
        query.setParameter("departmentName" , departmentName);
        String result = (String) query.getSingleResult();
        return result;
    }

    public void addDepartment(Department department) {
        session.save(department);
    }
}
