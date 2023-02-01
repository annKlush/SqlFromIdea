package database;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import table.*;


public class DatabaseQueryService {
    public static final String FIND_MAX_PR_CL = "./sql/find_max_projects_client.sql";
    public static final String FIND_MAX_SALARY = "./sql/find_max_salary_worker.sql";
    public static final String FIND_LONGEST_Pr = "./sql/find_longest_project.sql";
    public static final String FIND_YOUNG_OLD_WORKER = "./sql/find_youngest_eldest_workers.sql";
    public static final String PRINT_PR_PRICES = "./sql/print_project_prices.sql";

    public List<MaxSalary> findMaxSalary(){
        Database date = Database.getInstance();
        List<MaxSalary> maxSalaryList = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_MAX_SALARY)));
            Statement st = date.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maxSalaryList.add(new MaxSalary(rs.getInt("SALARY"), rs.getString("NAME")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }
        return maxSalaryList;
    }

    public List<MaxProjectCountClient> findMaxProjectCountClient() {
        Database date = Database.getInstance();
        List <MaxProjectCountClient> maxProjectCountClientList = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_MAX_PR_CL)));
            Statement st = date.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                maxProjectCountClientList.add(new MaxProjectCountClient(rs.getString("NAME"), rs.getInt("PROJECT_COUNT")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }
        return maxProjectCountClientList;
    }

    public List<LongestPr> findLongestPrs() {
        Database date = Database.getInstance();
        List<LongestPr> longestPrList = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_LONGEST_Pr)));
            Statement st = date.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                longestPrList.add(new LongestPr(rs.getInt("ID"), rs.getInt("MONTH_COUNT")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }
        return longestPrList;
    }

    public List<YoungOldWorker> findYoungOldWorker()  {
        Database date = Database.getInstance();
        List<YoungOldWorker> youngOldWorkerList = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(FIND_YOUNG_OLD_WORKER)));
            Statement st = date.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                youngOldWorkerList.add(new YoungOldWorker(rs.getString("TYPE"), rs.getString("NAME"), LocalDate.parse(rs.getString("BIRTHDAY"))));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }
        return youngOldWorkerList;
    }

    public List<PrPrice> printPrPrice() {
        Database date = Database.getInstance();
        List<PrPrice> prPriceList = new ArrayList<>();
        try {
            String sql = String.join("\n", Files.readAllLines(Paths.get(PRINT_PR_PRICES)));
            Statement st = date.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                prPriceList.add(new PrPrice(rs.getInt("PROJECT_ID"), rs.getInt("PRICE")));
            }
        } catch (Exception ex) {
            System.out.println("Connection failed...");
        }
        return prPriceList;
    }
}


