package dao;
import java.util.List;
import entity.Admins;
public interface AdminsDao {
    List<Admins> findAll();
    void insert(long ano,String aname,String apass,String phone,String id);
    void erase(long ano);
    int exist(long ano);
}
