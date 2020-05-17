package dao;
import java.util.List;
import entity.Books;
public interface BooksDao {
    void insert(long bno,String bname,String author,String press,long amount,long btype,String bday);//往图书表中插入一条完整的记录
    void erase(long bno);//删除图书编号为bno的图书
    int exist(long bno);//查看图书编号为bno的图书是否存在,如果存在返回所剩图书的数量，如果不存在则返回0
    void change_bname(long bno,String bname);//通过bno更改bname，下同
    void change_author(long bno,String author);
    void change_press(long bno,String press);
    void change_amount(long bno,long amount);
    void change_btype(long bno,long btype);
    void change_bday(long bno,String bday);
}
