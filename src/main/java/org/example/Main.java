package org.example;

import database.Database;
import database.DatabaseQueryService;

import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        Database date = Database.getInstance();

        System.out.println(new DatabaseQueryService(date).findMaxSalary().toString());
        System.out.println(new DatabaseQueryService(date).findMaxProjectCountClient().toString());
        System.out.println(new DatabaseQueryService(date).findLongestPrs().toString());
        System.out.println(new DatabaseQueryService(date).findYoungOldWorker().toString());
        System.out.println(new DatabaseQueryService(date).printPrPrice().toString());
        date.close();
    }
}
