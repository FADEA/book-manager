package dao;
import java.util.List;
import entity.Ts;
public interface TSDao {
    void insert(long tno,long sno,java.sql.Date btime,java.sql.Date rtime);
    void erase(long tno,long sno);
    int exist(long tno,long sno);
}
