package dao;
import java.util.List;
import entity.Bs;
public interface BSDao {
    void insert(long bno,long sno,String btime,String rtime);//往BS表中插入一条完整的记录
    void erase(long bno,long sno);//在BS表中删除图书编号为bno，学生编号为sno的记录
    int exist(long bno,long sno);//查看bs表中图书编号为bno，学生编号为sno的记录是否存在
    void change_btime(long bno,long sno,String btime);//更改借书的时间
    void change_rtime(long bno,long sno,String rtime);//更改还书的时间
}
