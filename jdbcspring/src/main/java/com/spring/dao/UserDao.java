package com.spring.dao;
import com.spring.bean.User;
import java.util.List;
public interface UserDao {
        public void save(User u);
        //删
        public void delete(int id);
        //改
        public void update(User u);
        //查
        public User getById(int id);
        //查
        public int getTotalCount();
        //查
        public List<User> getAll();
    }
