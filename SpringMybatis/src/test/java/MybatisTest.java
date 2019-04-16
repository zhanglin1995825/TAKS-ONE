import java.util.List;
import com.how2java.Mapper.CategoryMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.how2java.pojo.Category;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MybatisTest {
    @Autowired
    private CategoryMapper categoryMapper;

    @Test
    public void testAdd() {
        Category category = new Category();
        category.setName("你没");
        categoryMapper.add(category);
    }

    @Test
    public void select() {
        //System.out.println(categoryMapper);
        List<Category> cs = categoryMapper.list();
        for (Category c : cs) {
            System.out.println(c.getId()+"  "+c.getName());
        }
    }
    @Test
    public void delete(){
        categoryMapper.delete(23);
    }
    @Test
    public void update(){
        Category category = new Category();
        category.setId(22);
        category.setName("你没");
        categoryMapper.update(category);
    }
}
