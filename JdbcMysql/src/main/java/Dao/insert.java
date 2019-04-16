package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class insert {
    public static Connection getConnection(String user, String pass) {
        Connection conn = null;//声明连接对象
        String driver = "com.mysql.cj.jdbc.Driver";// 驱动程序类名
        String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8" // 数据库URL
                + "useUnicode=true&characterEncoding=UTF8";// 防止乱码
        try {
            Class.forName(driver);// 注册(加载)驱动程序
            conn = DriverManager.getConnection(url, user, pass);// 获取数据库连接
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
    //释放数据库连接
    public static void releaseConnection(Connection conn) {
        try {
            if (conn != null)
                conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Connection conn = getConnection("root", "123456");    // 获取数据库连接
        insert(conn);    //方法名调用数据库连接
        releaseConnection(conn);// 释放数据库连接
    }
    public static void insert(Connection conn) {
        try {
            String sql = "insert into one(id,name)";
            // 插入数据的sql语句
            Statement stmt1 =conn.createStatement();    // 创建用于执行静态sql语句的Statement对象
            int count = stmt1.executeUpdate(sql);  // 执行插入操作的sql语句，并返回插入数据的个数
           // System.out.println("成功 " ); //输出插入操作的处理结果
            conn.close();   //关闭数据库连接
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
