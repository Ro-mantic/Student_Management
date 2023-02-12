package Student_Management_System;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//连接数据库
public class mysql_Connect {
    public static Connection mysqlConnect() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/work?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";

        Connection connection = DriverManager.getConnection(url, "root","cjw");

        return connection;
    }
}
