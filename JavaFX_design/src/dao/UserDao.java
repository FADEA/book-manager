package dao;
import java.util.List;
import entity.User;
public interface UserDao {
    List<User> findAll();
    void insert(String username,String password);
    void erase(String username);
    int exist(String username);
    String get_username();
    int exist_username_password(String username,String password);
}
