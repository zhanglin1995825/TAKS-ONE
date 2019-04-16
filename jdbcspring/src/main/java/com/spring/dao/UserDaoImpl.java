package com.spring.dao;
import com.spring.bean.User;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public class UserDaoImpl implements UserDao {
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private JdbcTemplate jdbcTemplate;
    public void save(User u) {
        String sql = "insert into student (name) values (?) ";
        jdbcTemplate.update(sql, u.getName());
    }

    public void delete(int id) {
        String sql = "delete from student where id = ? ";
        jdbcTemplate.update(sql, id);
    }

    public void update(User u) {
        String sql = "update  student set name = ? where id=? ";
        jdbcTemplate.update(sql, u.getName(), u.getid());
    }

    public User getById(int id) {
        String sql = "select * from student where id = ? ";
        return jdbcTemplate.queryForObject(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setid(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        }, id);

    }

    public int getTotalCount() {
        String sql = "select count(*) from student  ";
        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);
        return count;
    }

    public List<User> getAll() {
        String sql = "select * from student  ";
        List<User> list = jdbcTemplate.query(sql, new RowMapper<User>() {
            public User mapRow(ResultSet rs, int arg1) throws SQLException {
                User u = new User();
                u.setid(rs.getInt("id"));
                u.setName(rs.getString("name"));
                return u;
            }
        });
        return list;
    }
}
