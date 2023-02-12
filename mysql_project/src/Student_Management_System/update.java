package Student_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class update {
    public static void updateStu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生学号");
        String Stu_id = scanner.next();

        System.out.println("请输入新学生姓名");
        String name = scanner.next();

        System.out.println("请输入新班级");
        String class_id = scanner.next();

        System.out.println("请输入新宿舍号");
        String Dor_id = scanner.next();

        mysqlUpdate(Stu_id,name,class_id,Dor_id);

    }
    public static void mysqlUpdate(String Stu_id, String name, String class_id, String Dor_id) throws SQLException {
        Connection connection = mysql_Connect.mysqlConnect();
        PreparedStatement preparedStatement = null;

        String sql = "update manger set Stu_id = ?,name = ?,class_id = ?,Dor_id = ?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,Stu_id);
        preparedStatement.setString(2,name);
        preparedStatement.setString(3,class_id);
        preparedStatement.setString(4,Dor_id);

        int res = preparedStatement.executeUpdate();

        if (res > 0) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }
}
