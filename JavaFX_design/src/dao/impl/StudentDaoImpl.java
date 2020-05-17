package dao.impl;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import dao.StudentDao;
import entity.Student;

public class StudentDaoImpl implements StudentDao{
    private   String driver=null;
    private   String url=null;
    private   String user=null;
    private   String password=null;
    {
        try{
            //使用类加载器的方式加载资源配置文件，配置文件必须在SRC下
            InputStream  in=UserDaoImpl.class.getClassLoader().getResourceAsStream("jdbc.properties");
            //专门用来操作properties
            Properties properties=new Properties();
            properties.load(in);
            driver=properties.getProperty("driver");
            url=properties.getProperty("url");
            user=properties.getProperty("user");
            password=properties.getProperty("password");
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }
    //获取连接对象
    public  Connection getConnection(){
        Connection conn=null;
        try{
            Class.forName(driver);
            conn=DriverManager.getConnection(url,user,password);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
    //释放资源
    public void release(Connection conn,Statement st,ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }//如果对象为null，java虚拟机会尽快使用垃圾回收机制释放对象
        //像c/c++需要手动申请并释放指针内存，而java虚拟机基本上是自动的
        finally{
            rs=null;
        }
        try{
            if(st!=null){
                st.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            rs=null;
        }
        try{
            if(conn!=null){
                conn.close();
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            rs=null;
        }
    }
    Connection conn=null;
    Statement st=null;
    ResultSet rs=null;
    @Override
    public void insert(long sno, String sname, String spass, String phone, String id, long borrow)
    //往学生表中插入一条完整的记录，不判断该表中是否存在有一条记录的sno与要插入的sno相同，其他的插入函数同理
        {
        String sql="insert into Student values("+String.valueOf(sno)+",'"+sname+"','"+spass+"','"+phone+"','"+id+"',"+String.valueOf(borrow)+")";
        try{
            conn= getConnection();
            st=conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
    }

    @Override
    public void erase(long sno) {
        //通过学生的学号从学生表中删除一条学生的记录
        String sql="delete from Student where Sno = "+String.valueOf(sno);
        try{
            conn=getConnection();
            st=conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
    }

    @Override
    public void change_sname(long sno, String sname) {
        //将学号为sno的学生的名字改成sname
        String sql="update Student set sname='"+sname+"' where sno="+String.valueOf(sno);
        try{
            conn=getConnection();
            st=conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
    }

    @Override
    public void change_spass(long sno, String spass) {
        String sql="update Student set spass='"+spass+"' where sno="+String.valueOf(sno);
        try{
            conn=getConnection();
            st=conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
    }

    @Override
    public void change_id(long sno, String id) {
        String sql="update Student set id='"+id+"' where sno="+String.valueOf(sno);
        try{
            conn=getConnection();
            st=conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
    }

    @Override
    public void change_phone(long sno, String phone) {
        String sql="update Student set phone='"+phone+"' where sno="+String.valueOf(sno);
        try{
            conn=getConnection();
            st=conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
    }

    @Override
    public void change_borrow(long sno, long borrow) {
        String sql="update Student set borrow='"+String.valueOf(borrow)+"' where sno="+String.valueOf(sno);
        try{
            conn=getConnection();
            st=conn.createStatement();
            st.executeUpdate(sql);
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
    }

    @Override
    public int exist(long sno) {
        //通过学生的学号sno查找该学生是否存在于学生表中，如果存在返回1，如果不存在返回0
        String sql="select count(*) from Student where Sno= "+String.valueOf(sno);
        try{
            conn= getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            int i=0;
            if(rs.next()){
                i=rs.getInt(1);
            }
            return i;
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
        return 0;
    }
}
