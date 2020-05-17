package dao;
import java.util.List;
import entity.Ts;
public interface TSDao {
    void insert(long bno,long tno,String btime,String rtime);
    void erase(long bno,long tno);
    int exist(long bno,long tno);
    void change_btime(long bno,long tno,String btime);//更改借书的时间
    void change_rtime(long bno,long tno,String rtime);//更改还书的时间
}
