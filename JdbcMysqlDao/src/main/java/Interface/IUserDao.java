package Interface;
import Entity.User;
public interface IUserDao {
    void add(User user);
    boolean delete(int ID);
    User queryOne(int ID);
    void select(int ID);
    void update (User user);
}
