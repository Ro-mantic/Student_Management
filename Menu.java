package Student_Management_System;

import java.sql.SQLException;
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) throws SQLException {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;

        //连接数据库
        mysql_Connect.mysqlConnect();

        //菜单
        while(flag) {
            ShowMenu();
            String choice = scanner.next();
            switch (choice) {
                case "1":
                    System.out.println("添加学生");
                    Add.addStudent();
                    break;
                case "2":
                    System.out.println("删除学生");
                    delete.deleteStu();
                    break;
                case "3":
                    System.out.println("修改学生");
                    update.updateStu();
                    break;
                case "4":
                    System.out.println("查看学生");
                    query.mysqlQuery();
                    break;
                case "5":
                    System.out.println("退出");
                    flag = false;
                    break;
            }
        }
    }
    private static void ShowMenu() {
        System.out.println("---------学生管理系统---------");
        System.out.println("1.添加学生");
        System.out.println("2.删除学生");
        System.out.println("3.修改学生");
        System.out.println("4.查看学生");
        System.out.println("5.退出系统");
        System.out.println("请输入你的操作");
    }
}
