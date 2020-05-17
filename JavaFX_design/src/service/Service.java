package service;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import dao.UserDao;
import entity.User;
import dao.TSDao;
import dao.TouristDao;
import dao.StudentDao;
import dao.BSDao;
import dao.BooksDao;
import dao.AdminsDao;
import entity.Ts;
import entity.Tourist;
import entity.Student;
import entity.Bs;
import entity.Books;
import entity.Admins;


public class Service {
    public  void insert_into_Student(long sno,String sname,String spass,String phone,String id,long borrow)
            //往学生表中插入一条完整的记录，不判断该表中是否存在有一条记录的sno与要插入的sno相同，其他的插入函数同理
            throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        StudentDao dao =(StudentDao)Class.forName("dao.impl.StudentDaoImpl").newInstance();
        dao.insert(sno, sname,spass,phone,id,borrow);
    }
    public Boolean is_exist_Studnent(long sno)
            //通过学生的学号sno查找该学生是否存在于学生表中，如果存在返回true，如果不存在返回false
            throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        StudentDao dao =(StudentDao)Class.forName("dao.impl.StudentDaoImpl").newInstance();
        if(dao.exist(sno)==0)return false;
        return true;
    }
    public void erase_Student(long sno)
            //通过学生的学号从学生表中删除一条学生的记录
            throws InstantiationException, IllegalAccessException, ClassNotFoundException {
        StudentDao dao =(StudentDao)Class.forName("dao.impl.StudentDaoImpl").newInstance();
        dao.erase(sno);
    }
    public void insert_into_Admins(long ano,String aname,String apass,String phone,String id)
            //往管理员表插入一条完整的记录
            throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        AdminsDao dao=(AdminsDao)Class.forName("dao.impl.AdminsDaoImpl").newInstance();
        dao.insert(ano,aname,apass,phone,id);
    }
    public void  insert_into_Tourist(long tno,String tname,String tpass,String phone,String id,long borrow)
            //往游客表中插入一条完整的记录
            throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        TouristDao dao=(TouristDao)Class.forName("dao.impl.TouristDaoImpl").newInstance();
        dao.insert(tno,tname,tpass,phone,id,borrow);
    }

    public void insert_into_Books(long bno,String bname,String author,String press,long amount,long btype,java.sql.Date bday)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException{
    }
    public  void insert_into_BS(long bno,long sno,java.sql.Date btime,java.sql.Date rtime)
            throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        BSDao dao=(BSDao)Class.forName("dao.impl.BSDaoImpl").newInstance();
        dao.insert(bno,sno,btime,rtime);
    }
    /*
    public Boolean isDigit(String strnum){
        Pattern pattern =Pattern.compile("[0-9]{1,}");
        Matcher matcher=pattern.matcher((CharSequence)strnum);
        return matcher.matches();
    }
    public List<User> findAll_user() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        UserDao dao =(UserDao)Class.forName("dao.impl.UserDaoImpl").newInstance();
        List<User> list=dao.findAll();
        System.out.println("User");
        System.out.printf("%-20s","username");
        System.out.printf("%-20s","password");
        System.out.println();
        for(User user: list){
            //System.out.println(user);
            user.output();
        }
        return list;
    }
    public  void insert_user(String username,String password) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        UserDao dao =(UserDao)Class.forName("dao.impl.UserDaoImpl").newInstance();
        dao.insert(username, password);
    }
    public Boolean isExistUser(String s) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        UserDao dao1 =(UserDao)Class.forName("dao.impl.UserDaoImpl").newInstance();
        if(dao1.exist(s)==0)return false;
        return true;
    }
    public Boolean isExistUserAndPassword(String s1,String s2) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
        UserDao dao1 =(UserDao)Class.forName("dao.impl.UserDaoImpl").newInstance();
        if(dao1.exist_username_password(s1,s2)==0)return false;
        return true;
    }
     */

	public static void main(String []args) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		Service s=new Service();
        StudentDao dao1 =(StudentDao)Class.forName("dao.impl.StudentDaoImpl").newInstance();
        //dao1.change_sname(1,"ab");
        //dao1.change_id(1,"1");
        //dao1.change_spass(1,"1");
        //dao1.change_phone(1,"1");
        //dao1.change_borrow(1,2);
		//s.erase_Student(2);
        //System.out.println(s.is_exist_Studnent(3));
		//s.insert_into_Tourist(1,"xb","123456","123456","123456",1);
		//s.insert_into_Student(2,"xb","123456","123456","123456",1);
        //s.insert_into_Admins(2,"xb","123456","123456","123456");
		//s.insert_user("eeaaee", "123");
		//System.out.println(s.isExistUser("abc"));
		//System.out.println(s.isExistUser("aaa"));
		//s.findAll_user();
	}

}
