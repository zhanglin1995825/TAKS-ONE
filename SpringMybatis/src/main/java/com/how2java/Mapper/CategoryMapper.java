package com.how2java.Mapper;
import java.util.List;
import com.how2java.pojo.Category;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryMapper {

     int add(Category category);

     void delete(int id);

     Category get(int id);

     int update(Category category);

     List<Category> list();

     //int count();

}
