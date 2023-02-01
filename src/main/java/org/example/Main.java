package org.example;

import database.Database;
import database.DatabaseQueryService;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database date = Database.getInstance();
        date.getConnection();
        System.out.println(new DatabaseQueryService().findMaxSalary().toString());
        System.out.println(new DatabaseQueryService().findMaxProjectCountClient().toString());
        System.out.println(new DatabaseQueryService().findLongestPrs().toString());
        System.out.println(new DatabaseQueryService().findYoungOldWorker().toString());
        System.out.println(new DatabaseQueryService().printPrPrice().toString());
        date.close();
    }
}
