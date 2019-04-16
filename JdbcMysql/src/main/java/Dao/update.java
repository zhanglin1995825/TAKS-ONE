package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class update {
    //数据库连接
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
    // 释放数据库连接
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
        update(conn);     //方法名调用数据库连接
        releaseConnection(conn);// 释放数据库连接
    }
    //更新数据
    public static void update(Connection conn){
        String Sql = "update  student set name=张飞 where ID=10";
        try {
            Statement stmt1 = conn.createStatement();//或者用PreparedStatement方法
            stmt1.executeUpdate(Sql);//执行sql语句
            if (stmt1 != null) {
                try {
                    stmt1.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
