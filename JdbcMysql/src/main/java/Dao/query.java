package Dao;
import java.sql.*;
public class query {
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
        Connection conn = getConnection("root", "123456");// 获取数据库连接
        query(conn);     //方法名调用数据库连接
        releaseConnection(conn);//释放数据库连接
    }
    //查询数据，定义的query方法
    public static void query(Connection conn){
        String Sql="select * from student";
        try{
            Statement stmt=conn.createStatement(); //也可以使用PreparedStatement来做
            ResultSet rs=stmt.executeQuery(Sql);//执行sql语句并返还结束

            while(rs.next()){//遍历结果集 ，向下一行
                System.out.println("id:"+rs.getString("id")+"\t"+"name:"+rs.getString("name"));
            }
            if(rs !=null){
                try{
                    rs.close();
                } catch (SQLException e){
                    e.printStackTrace();
                }
            }
            if(stmt !=null){
                try{
                    stmt.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
            if(conn !=null){
                try{
                    conn.close();
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    }
