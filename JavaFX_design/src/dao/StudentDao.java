package dao;
import java.util.List;
import entity.Student;

public interface StudentDao {
    void insert(long sno,String sname,String spass,String phone,String id,long borrow); //往学生表中插入一条完整的记录
    void erase(long sno);//通过学生的学号从学生表中删除一条学生的记录
    void change_sname(long sno,String sname); //将学号为sno的学生的名字改成sname,接下来的change函数同理
    void change_spass(long sno,String spass);
    void change_id(long sno,String id);
    void change_phone(long sno,String phone);
    void change_borrow(long sno,long borrow);
    int exist(long sno); //通过学生的学号sno查找该学生是否存在于学生表中，如果存在返回1，如果不存在返回0
}
