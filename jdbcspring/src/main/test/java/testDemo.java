import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.spring.bean.User;
import com.spring.dao.UserDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
//@RunWith(SpringJUnit4ClassRunner.class)
public class testDemo {
    UserDao dao;
//    @Before
//    public void init() {
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        this.dao=context.getBean(UserDao.class);
//    }
    @Test
    public void fun1() throws Exception{
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/first");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        //2、创建JDBC模板对象
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource);
        //3、书写sql语句,并执行
        String sql = "insert into student values(null,'rose') ";
        jt.update(sql);
    }
    @Test
    public void fun2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dao=context.getBean(UserDao.class);
        User t = new User();
        t.setName("tom");
        dao.save(t);
    }
    @Test
    public void fun3() throws Exception{
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dao=context.getBean(UserDao.class);
        User u = new User();
        u.setid(1);
        u.setName("jack");
        dao.update(u);
    }

    @Test
    public void fun4() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        this.dao=context.getBean(UserDao.class);
        dao.delete(3);
    }

    @Test
    public void fun5() throws Exception{
        System.out.println(dao.getTotalCount());
    }

    @Test
    public void fun6() throws Exception{
        System.out.println(dao.getById(1));
    }

    @Test
    public void fun7() throws Exception{
        System.out.println(dao.getAll());
    }
}
