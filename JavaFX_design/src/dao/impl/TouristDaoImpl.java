package dao.impl;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import dao.TouristDao;
import entity.Tourist;

public class TouristDaoImpl implements TouristDao{
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
    public void insert(long tno, String tname, String tpass, String phone, String id, long borrow) {
        String sql="insert into Tourist values("+String.valueOf(tno)+",'"+tname+"','"+tpass+"','"+phone+"','"+id+"',"+String.valueOf(borrow)+")";

      //  String sql="insert into Tourist values("+String.valueOf(tno)+",'"+tname+"','"+tpass+"','"+phone+"','"+id+"',"+String.valueOf(borrow)+")";
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
    public void erase(long tno) {
        String sql="delete from Tourist where tno = "+String.valueOf(tno);
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
    public int exist(long tno) {
        String sql="select count(*) from Tourist where tno= "+String.valueOf(tno);
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
    @Override
    public void change_tname(long tno, String tname) {
        //将学号为sno的学生的名字改成sname
        String sql="update Tourist set tname='"+tname+"' where tno="+String.valueOf(tno);
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
    public void change_tpass(long tno, String tpass) {
        String sql="update Tourist set tpass='"+tpass+"' where tno="+String.valueOf(tno);
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
    public void change_id(long tno, String id) {
        String sql="update Tourist set id='"+id+"' where tno="+String.valueOf(tno);
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
    public void change_phone(long tno, String phone) {
        String sql="update Tourist set phone='"+phone+"' where tno="+String.valueOf(tno);
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
    public void change_borrow(long tno, long borrow) {
        String sql="update Tourist set borrow='"+String.valueOf(borrow)+"' where tno="+String.valueOf(tno);
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

}
