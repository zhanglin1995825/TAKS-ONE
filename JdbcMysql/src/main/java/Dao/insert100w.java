package Dao;
import org.junit.Test;
import java.sql.*;
public class insert100w {
    private String url = "jdbc:mysql://localhost:3306/first?rewriteBatchedStatements=true&serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    private String user = "root";
    private String password = "123456";
    @Test
    public void Test(){
        Connection conn = null;
        PreparedStatement pstm =null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO one(id,name) VALUES(?,'二大爷')";
            pstm = conn.prepareStatement(sql);
            Long startTime = System.currentTimeMillis();
            for (int i = 1; i <= 20; i++) {
               for (int j = 1; j <= 100; j++) {
                    pstm.setInt(1, ((i-1)*10000)+j);
                    pstm.addBatch();
                }
                pstm.executeBatch();
            }
            Long endTime = System.currentTimeMillis();
            System.out.println("OK,用时：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }finally{
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }
    }
    @Test
    public void Test1() {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "select*from one where ID=123590";
            pstm = conn.prepareStatement(sql);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } finally {
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    throw new RuntimeException(e);
                }
            }
        }

    }
}
