package dao;
import java.util.List;
import entity.Bs;
public interface BSDao {
    void insert(long bno,long sno,java.sql.Date btime,java.sql.Date rtime);
    void erase(long bno,long sno);
    int exist(long bno,long sno);
}
