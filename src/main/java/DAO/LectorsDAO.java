package DAO;

import entity.Lectors;
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
        Query query = session.createSQLQuery("Select count(degree) FROM lectors WHERE degree = 'Assistant' and lectors.id in " +
                "(Select lectors_id From department_lectors Where department_id in " +
                "(Select id from department where name = :departmentName));");
        query.setParameter("departmentName" , departmentName);
        List result = query.list();
        return result;
    }

    public List<Integer> showProfessor(String departmentName){
        Query query = session.createSQLQuery("Select count(degree) FROM lectors WHERE degree = 'Professor' and lectors.id in " +
                "(Select lectors_id From department_lectors Where department_id in " +
                "(Select id from department where name = :departmentName));");
        query.setParameter("departmentName" , departmentName);
        List result = query.list();
        return result;
    }

    public List<Integer> showAssociateProfessor(String departmentName){
        Query query = session.createSQLQuery("Select count(degree) FROM lectors WHERE degree = 'Associate_Professor' and lectors.id in " +
                "(Select lectors_id From department_lectors Where department_id in " +
                "(Select id from department where name = :departmentName));");
        query.setParameter("departmentName" , departmentName);
        List result = query.list();
        return result;
    }
}
