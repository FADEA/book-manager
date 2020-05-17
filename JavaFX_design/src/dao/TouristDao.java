package dao;
import java.util.List;
import entity.Tourist;

public interface TouristDao {
    void insert(long tno,String tname,String tpass,String phone,String id,long borrow);
    void erase(long tno);
    int exist(long tno);
}
