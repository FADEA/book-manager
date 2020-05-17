package dao;
import java.util.List;
import entity.Admins;
public interface AdminsDao {
    List<Admins> findAll();
    void insert(long ano,String aname,String apass,String phone,String id);//往管理员表中插入一条完整的记录
    void erase(long ano);//通过管理员的编号删除一条记录
    int exist(long ano);//通过管理员的编号查看某一条记录是否存在
    void change_aname(long ano,String aname);//将编号为ano的管理员的aname更改为新的值，下同
    void change_apass(long ano,String apass);
    void change_phone(long ano,String phone);
    void change_id(long ano,String id);
}
