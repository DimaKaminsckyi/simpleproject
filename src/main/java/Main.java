import DAO.DepartmentDAO;
import DAO.LectorsDAO;
import org.hibernate.Session;
import util.SessionUtil;
import util.records.GenerateRecords;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Session session = SessionUtil.getSession();
        DepartmentDAO departmentDAO = new DepartmentDAO(session);
        LectorsDAO lectorsDAO = new LectorsDAO(session);
        GenerateRecords.generate(session);

        int n ;
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);

        System.out.println("1.Show count of employee for Department");
        System.out.println("2.Global search");
        System.out.println("3.Calculate department salary");
        System.out.println("4.Show head of Department");
        System.out.println("5.Department Statistic");
        System.out.println("0.Exit");
        n = intScan.nextInt();
        while( n != 0){
            switch (n){
                case 1 :
                    System.out.println("Enter department name : ");
                    System.out.println("Answer : "  + departmentDAO.showStatistic(strScan.next()));
                    break;
                case 2 :
                    System.out.println("Enter name : ");
                    System.out.println("Answer : " + lectorsDAO.getRegex(strScan.next()));
                    break;
                case 3 :
                    System.out.println("Enter department name : ");
                    System.out.println("Answer : " + departmentDAO.getSalary(strScan.next()));
                    break;
                case 4 :
                    System.out.println("Enter department name : ");
                    String departmentHead = strScan.next();
                    System.out.println("Head of " + departmentHead + " department is " +
                            departmentDAO.getHeadOfDepartment(departmentHead));
                    break;
                case 5 :
                    System.out.println("Enter Department Name : ");
                    String departmentStatistic = strScan.next();
                    System.out.println("Answer : \n assistant - " + lectorsDAO.showAssistant(departmentStatistic) + "\n"
                    + "professor - " + lectorsDAO.showProfessor(departmentStatistic) + "\n"
                    + "associate professors - " + lectorsDAO.showAssociateProfessor(departmentStatistic));
                    break;
            }
            System.out.println("Select operation : ");
            n = intScan.nextInt();
        }
    }
}
