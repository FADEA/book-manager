package dao;
import java.util.List;
import entity.Books;
public interface BooksDao {
    void insert(long bno,String bname,String author,String press,long amount,long btype,java.sql.Date bday);
    void erase(long bno);
    int exist(long bno);
}
