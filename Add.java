package Student_Management_System;

import java.sql.*;
import java.util.Scanner;

public class Add {
    public static void addStudent() throws SQLException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("请输入学生学号");
        String Stu_id = scanner.next();

        System.out.println("请输入学生姓名");
        String name = scanner.next();

        System.out.println("请输入学生班级");
        String class_id = scanner.next();

        System.out.println("请输入学生宿舍号");
        String Dor_id = scanner.next();

        Insert(Stu_id,name,class_id,Dor_id);
    }
    public static void Insert(String Stu_id, String name, String class_id, String Dor_id) throws SQLException {
        Connection connection = mysql_Connect.mysqlConnect();
        PreparedStatement preparedStatement = null;

        boolean flag = check(Stu_id);
        if (flag) {
            System.out.println("学号已存在");
            return;
        }

        String sql = "insert into manger(Stu_id,name,class_id,Dor_id) values(?,?,?,?)";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,Stu_id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,class_id);
        preparedStatement.setString(4,Dor_id);

        int res = preparedStatement.executeUpdate();

        if (res == 1) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
        preparedStatement.close();
    }
    public static boolean check(String student) throws SQLException {
        boolean flag = false;
        Connection connection = mysql_Connect.mysqlConnect();
        //执行sql语句
        Statement statement = null;
        statement = connection.createStatement();

        //sql语句
        String sql = "select * from manger";
        ResultSet resultSet = statement.executeQuery(sql);

        while(resultSet.next()) {
            String Stu_id = resultSet.getString("Stu_id");
            if (student.equals(Stu_id)) {
                return true;
            }
        }
        return flag;
    }
}
