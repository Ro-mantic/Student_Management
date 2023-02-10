package Student_Management_System;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

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

        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()) {
            String Stu_id = resultSet.getString("Stu_id");
            String name = resultSet.getString("name");
            String class_id = resultSet.getString("class_id");
            String Dor_id = resultSet.getString("Dor_id");

            System.out.print("学号：" + Stu_id);
            System.out.print(" 姓名：" + name);
            System.out.print(" 班级：" + class_id);
            System.out.print(" 宿舍号：" + Dor_id);
            System.out.println();
        }
        resultSet.close();
        statement.close();
    }
}
