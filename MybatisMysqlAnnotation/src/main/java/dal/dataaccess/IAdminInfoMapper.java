package dal.dataaccess;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface IAdminInfoMapper {
  /*  //使用@Select注解指明getById方法要执行的SQL
    @Select("select * from student where id=#{id}")
    public Student getById(int id);
    //使用@Select注解指明getAll方法要执行的SQL*/
    @Select("select * from student")
    List<Student> getAll();

    //使用@Insert注解指明add方法要执行的SQL
    @Insert("insert into student(name) values(#{name})")
    int add(String name);

    //使用@Update注解指明update方法要执行的SQL
    @Update("update student set name=#{name} where id=#{id}")
    public int update(Student user);

    //使用@Delete注解指明deleteById方法要执行的SQL
    @Delete("delete from student where id=#{id}")
    int deleteById(int id);
}
