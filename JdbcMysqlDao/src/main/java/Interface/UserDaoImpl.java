package Interface;
import Entity.User;
import java.sql.*;
public class UserDaoImpl implements IUserDao {
    @Override
    public boolean delete(int ID) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接：与数据库建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root", "123456");
            //3.获得sql的预编译对象
            statement = connection.createStatement();
            //4.执行sql语句    ex:创建表t_user
            String sql = "delete from student where ID = " + ID + ";";
            return statement.executeUpdate(sql) == 1 ? true : false;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
        return false;
    }

    @Override
    public void add(User user) {
        Connection connection = null;
        Statement statement = null;
        PreparedStatement pstm = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接：与数据库建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root", "123456");
            //3.获得sql的预编译对象
            statement = connection.createStatement();
            //4.执行sql语句    ex:创建表t_user
            String sql = "insert into one(name )values(?)";
            pstm = connection.prepareStatement(sql);
            for (int j = 1; j <= 1000; j++) {
                pstm.setString(1, user.getname());
                //pstm.addBatch();
                pstm.executeUpdate();
            }
            //pstm.executeBatch();
            //pstm.clearBatch();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                try {
                    if (pstm != null) {
                        pstm.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();

                }
            }
        }
    }

    @Override
    public User queryOne(int id) {
        Connection connection = null;
        Statement statement = null;
        ResultSet rs = null;
        User user = null;
        try {
            //1.加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接：与数据库建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root", "123456");
            //3.获得sql的预编译对象
            statement = connection.createStatement();
            //String sql="select * from student where id="+id+";";
            String sql = "select * from student where id =" + id + "";
            rs = statement.executeQuery(sql);
            while (rs.next()) {
                user = new User();
                user.setname(rs.getString("name"));
                user.setId(rs.getInt("id"));

            }
        } catch (Exception e) {

            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (statement != null) statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (connection != null) connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return user;
    }

    @Override
    public void select(int ID) {
        Connection connection = null;
        Statement statement = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            //2.获取连接：与数据库建立连接
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root", "123456");
            //3.获得sql的预编译对象
            statement = connection.createStatement();
            String sql = " select *from student";

            statement.executeQuery(sql);
            System.out.println();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Override
    public void update(User user) {
        Connection conn = null;
        PreparedStatement pstm = null;
        try {
        String sql = "update student set name=? where id=?";
        Class.forName("com.mysql.cj.jdbc.Driver");
        //2.获取连接：与数据库建立连接
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/first?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8", "root", "123456");
        //3.获得sql的预编译对象
            pstm = conn.prepareStatement(sql);
            pstm.setString(1, user.getname());
            pstm.setInt(2, user.getId());
            pstm.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (pstm != null) {
                    pstm.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();

            }
                try {
                    if (conn != null) {
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
