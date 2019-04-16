package Dao;

import com.mysql.jdbc.Driver;

import java.sql.*;
import java.util.Queue;

import static Dao.update.releaseConnection;

public class practice {
    public static void main(String[] args) {
        Connection conn = getConnection( "root" ,"123456" );
        query(conn);
        releaseConnection(conn);
    }
public static void query(Connection conn) {
    String Sql ="select *from student ";
    try {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(Sql);
        while (rs.next()) {
            System.out.println("id:" + rs.getString("id") + "name" + rs.getString("name"));
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn!=null)
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
        }
    }catch (Exception e){
        e.printStackTrace();
    }
}
public static Connection getConnection(String user,String pass){
        Connection conn = null;
                String driver ="com.mysql.cj.jdbc.Driver";
                        String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8" // 数据库URL
                                + "useUnicode=true&characterEncoding=UTF8";
                        try{
                            Class .forName(driver);
                            conn = DriverManager.getConnection(url,user,pass);
                        }catch(Exception e){
                            e.printStackTrace();
                        }
                        return conn;
}
public static void releaseConection(Connection conn){
        try{
            if(conn!=null){
                conn .close();
            }
        }catch(Exception e){
            e.printStackTrace();
        }
}

}
