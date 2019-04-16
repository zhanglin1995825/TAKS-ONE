import dao.IUserDao;
import entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;
public class UserTest {
    @Test
    public void getAll() throws Exception{
        String resource = "mybatis-config.xml";
        //将硬盘中的xml变成一个输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用流对象创建一个会话工厂
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        //session就是程序员与数据库交互的入口
        SqlSession session = sf.openSession();
        IUserDao mapper = session.getMapper(IUserDao.class);
        User user=new User();
        user.setName("张飞");
//      user.setId(4);
        List<User> all = mapper.getAll(user);
        for (User item:all){
            System.out.println(item.getId()+"\t"+item.getName());
        }
        session.commit();
        session.close();
    }
@Test
    public void inserts() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sf.openSession();
        User student = new User();
        student.setName("张飞");
        int count = session.insert("dao.IUserDao.addUser",student);
        System.out.println(count);
        session.commit();
        session.close();
    }
    @Test
    public void deleate()throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sf.openSession();
        User student = new User();
        student.setId(24);
        int count = session.update("dao.IUserDao.deleate",student);
        System.out.println(count);
        session.commit();
        session.close();
    }
    @Test
    public void update()throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sf.openSession();
        User student = new User();
        student.setId(23);
        student.setName("haha");
        int count = session.update("dao.IUserDao.update",student);
        System.out.println(count);
        session.commit();
        session.close();

    }
}
