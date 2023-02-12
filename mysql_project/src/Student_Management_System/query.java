package Student_Management_System;

import pojo.Account;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class query {
    public static boolean query_Stu(String sql) throws SQLException {
        boolean flag = false;
        Connection connection = mysql_Connect.mysqlConnect();
        Statement statement = null;
        statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            flag = true;
            return flag;
        }
        return flag;
    }
    public static void mysqlQuery() throws SQLException {
        Connection connection = mysql_Connect.mysqlConnect();
        Statement statement = null;
        statement = connection.createStatement();

        String sql = "select * from manger";
        boolean flag = query_Stu(sql);
        if (!flag) {
            System.out.println("无数据，请添加");
            return;
        }

        List<Account> list = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            Account account = new Account();

            String Stu_id = resultSet.getString("Stu_id");
            String name = resultSet.getString("name");
            String class_id = resultSet.getString("class_id");
            String Dor_id = resultSet.getString("Dor_id");

            account.setStu_id(Stu_id);
            account.setName(name);
            account.setClass_id(class_id);
            account.setDor_id(Dor_id);

            list.add(account);
        }

        System.out.println(list);

        resultSet.close();
        statement.close();
    }
}
