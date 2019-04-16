import dal.dataaccess.IAdminInfoMapper;
import dal.dataaccess.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import java.io.InputStream;
import java.util.List;
public class MybatisTest {
    @Test
    public void getAll() throws Exception {
        String resource = "mybatisConf.xml";
        //将硬盘中的xml变成一个输入流
        InputStream inputStream = Resources.getResourceAsStream(resource);
        //使用流对象创建一个会话工厂
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        //session就是程序员与数据库交互的入口
        SqlSession session = sf.openSession();
        IAdminInfoMapper mapper = session.getMapper(IAdminInfoMapper.class);
        List<Student> all = mapper.getAll();
        for (Student item : all) {
            System.out.println(item.getName());
        }
        session.commit();
        session.close();
    }





 /*   @Test
    public void SelectAll() {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        IAdminInfoMapper mapper = sqlSession.getMapper(IAdminInfoMapper.class);
        List<Student> bean = mapper.getAll();
        sqlSession.close();

        System.out.println(bean.size());
    }*/

    @Test
    public void inserts() throws Exception {
        String resource = "mybatisConf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sf.openSession();
        Student stu = new Student();
        stu.setName("张话");
        int count = session.insert("dal.dataaccess.IAdminInfoMapper.add", stu);
        session.commit();
        session.close();
    }


    @Test
    public void Update() throws Exception {
        String resource = "mybatisConf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sf.openSession();
        Student bean = new Student();
        bean.setId(1);
        bean.setName("Admin" );
        int count = session.update("dal.dataaccess.IAdminInfoMapper.update", bean);
        session.commit();
        session.close();
    }

   @Test
    public void Delete() throws Exception{
        String resource = "mybatisConf.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sf = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession session = sf.openSession();
        Student stu = new Student();
        stu.setId(9);
        int count = session.insert("dal.dataaccess.IAdminInfoMapper.deleteById", stu);
        session.commit();
        session.close();
    }
}
