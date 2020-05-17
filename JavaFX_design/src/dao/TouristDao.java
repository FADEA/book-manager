package dao;
import java.util.List;
import entity.Tourist;

public interface TouristDao {
    void insert(long tno,String tname,String tpass,String phone,String id,long borrow);//往游客表中插入一条完整的记录
    void erase(long tno);//删除游客表中编号为tno的记录
    int exist(long tno);//查看游客表中tno的记录是否存在
    void change_tname(long tno,String tname); //通过tno更改tname，下同
    void change_tpass(long tno,String tpass);
    void change_id(long tno,String id);
    void change_phone(long tno,String phone);
    void change_borrow(long tno,long borrow);
}
