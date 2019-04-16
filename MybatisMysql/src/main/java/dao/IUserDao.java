package dao;
import entity.User;
import java.util.List;
public interface IUserDao {
   public  List<User> getAll(User user);
   public int addUser(User user);
   public int deleate(User user);
   public int update (User user);

}


