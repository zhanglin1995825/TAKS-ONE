package Dao;
import org.junit.Test;
import java.sql.*;
public class forinsert {
    private String url = "jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8";
    private String user = "root";
    private String password = "123456";
    @Test
    public void Test(){
        Connection conn = null;
            PreparedStatement pstm =null;
            //ResultSet rt = null;
            try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
            String sql = "INSERT INTO one(id,name) VALUES(?,'任务一')";
            pstm = conn.prepareStatement(sql);
            StringBuffer suffix = new StringBuffer();
            conn.setAutoCommit(false);
            //Long startTime = System.currentTimeMillis();
           // Random rand = new Random();
            //int a,b;
            for (int i = 1; i <= 1000000; i++) {
                pstm.setInt(1, i);
                //pstm.setInt(2, i);
              //  a = rand.nextInt(10);
                //b = rand.nextInt(10);
                pstm.addBatch();
            }
            pstm.executeBatch();
                conn.commit();
           // Long endTime = System.currentTimeMillis();
           // System.out.println("OK,用时：" + (endTime - startTime));
        } catch (Exception e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
        }finally{
            if(pstm!=null){
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    //throw new RuntimeException(e);
                }
            }
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                    //throw new RuntimeException(e);
                }
            }
        }
    }
}
