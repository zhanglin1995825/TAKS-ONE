import Entity.User;
import Interface.IUserDao;
import Interface.UserDaoImpl;
import org.junit.Test;
public class UserTest {
    IUserDao userDao = new UserDaoImpl();
    int a=0;
    //多态
    @Test
    public void delete(){
        if (userDao.delete(1)){
        System.out.println("===============");
    }else {
            System.out.println("---------------");
        }
    }
    @Test
    public void Add() {
        User user = new User();
        user.setname("张");
        userDao.add(user);
    }
    @Test
    public void testQueryOne(){
        User user = userDao.queryOne(8);
        System.out.println(user);
    }
    @Test
    public void select(){
        userDao.select(3);
    }
    @Test
    public void update(){
        User user=new User();
        user.setId(1);
        user.setname("set");
        userDao.update(user);
    }

}


