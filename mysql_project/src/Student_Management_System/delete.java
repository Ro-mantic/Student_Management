package Student_Management_System;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class delete {
    public static void deleteStu() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生学号");
        String deleteID = scanner.next();
        mysqlDelete(deleteID);
    }
    public static void mysqlDelete(String Stu_id) throws SQLException {
        Connection connection = mysql_Connect.mysqlConnect();
        PreparedStatement preparedStatement = null;

        String sql = "delete from manger where Stu_id=?";
        preparedStatement = connection.prepareStatement(sql);
        preparedStatement.setString(1,Stu_id);
        int index = preparedStatement.executeUpdate();

        if (index == 0) {
            System.out.println("删除失败，请输入正确的编号");
            return;
        }else {
            System.out.println("删除成功");
        }
    }
}
