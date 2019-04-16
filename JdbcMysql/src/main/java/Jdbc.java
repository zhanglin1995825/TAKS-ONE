import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class Jdbc {
  /*  //8public static void main(String[] args) throws SQLException  {
        //1.注册数据库驱动
        DriverManager.registerDriver(new Driver());
        //2.获取数据库的连接
        Connection conn = DriverManager.getConnection("Jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root", "123456");
        //3.创建传输器对象
        Statement  stat = conn.createStatement();
        //4.利用传输器对象传输sql语句到数据库中执行操作，将结果用结果集返回
        ResultSet rs =  stat.executeQuery("select * from student");
        //5.遍历结果集，并获取查询结果
        while(rs.next()) {
            String name = rs.getString("name");
            System.out.println(name);
        }
        //6.关闭连接（后开先关）
        rs.close();
        stat.close();
        conn.close();
    }*/
    public static void main(String[] args)  {
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //1.注册数据库驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取数据库的连接
            conn = DriverManager.getConnection("Jdbc:mysql://39.97.170.158/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8","root","123456");
            //3.创建传输器对象
            stat = conn.createStatement();
            //4.利用传输器对象传输sql语句到数据库中执行操作，将结果用结果集返回
            rs =  stat.executeQuery("select * from student ");
            //5.遍历结果集，并获取查询结果
            while(rs.next()) {
                //String ID = rs.getString("ID");
                //String name = rs.getString("name");
                System.out.println(rs.getString("id"));
            }
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            //6.关闭连接（后开先关）
            if(rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    rs = null;
                }
            }
            if(stat != null) {
                try {
                    stat.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    stat = null;
                }
            }
            if(conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    conn = null;
                }
            }
        }
    }
}