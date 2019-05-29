package DAO;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class LectorsDAO {

    private Session session;

    public LectorsDAO(Session session){
        this.session = session;
    }

    public List<String> getRegex(String regex){
        Query query = session.createSQLQuery("SELECT full_name FROM lectors where full_name LIKE :regex");
        query.setParameter("regex" , "%" + regex + "%");
        List result = query.list();
        return result;
    }

    public List<Integer> showAssistant(String departmentName){
        Query query = session.createSQLQuery("Select count(degree) from lectors " +
                "Inner Join department_lectors dl on dl.lectors_id = lectors.id and lectors.degree = 'Assistant'" +
                "Inner Join department d on d.id = dl.department_id and d.name = :departmentName ;");
        query.setParameter("departmentName" , departmentName);
        List result = query.list();
        return result;
    }

    public List<Integer> showProfessor(String departmentName){
        Query query = session.createSQLQuery("Select count(degree) from lectors " +
                "Inner Join department_lectors dl on dl.lectors_id = lectors.id and lectors.degree = 'Professor'" +
                "Inner Join department d on d.id = dl.department_id and d.name = :departmentName ;");
        query.setParameter("departmentName" , departmentName);
        List result = query.list();
        return result;
    }

    public List<Integer> showAssociateProfessor(String departmentName){
        Query query = session.createSQLQuery("Select count(degree) from lectors " +
                "Inner Join department_lectors dl on dl.lectors_id = lectors.id and lectors.degree = 'Associate_Professor'" +
                "Inner Join department d on d.id = dl.department_id and d.name = :departmentName ;");
        query.setParameter("departmentName" , departmentName);
        List result = query.list();
        return result;
    }
}
