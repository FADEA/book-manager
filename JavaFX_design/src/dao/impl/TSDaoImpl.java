package dao.impl;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import dao.TSDao;
import entity.Ts;

public class TSDaoImpl implements TSDao{
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
    public void insert(long bno, long tno, String btime, String rtime) {
        String sql="insert into TS values("+String.valueOf(bno)+","+String.valueOf(tno)+",'"+btime+"','"+rtime+"')";
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
    public void erase(long bno, long tno) {
        String sql="delete from TS where Bno = "+String.valueOf(bno) + " and Tno="+String.valueOf(tno);
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
    public int exist(long bno, long tno) {
        String sql="select count(*) from TS where Bno = "+String.valueOf(bno) + " and Tno="+String.valueOf(tno);;
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
        }finally {
            release(conn, st, rs);
        }
        return 0;
    }

    @Override
    public void change_btime(long bno, long tno, String btime) {
        String sql="update TS set Btime='"+btime+"' where Bno="+String.valueOf(bno)+" and Tno="+String.valueOf(tno);
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
    public void change_rtime(long bno, long tno, String rtime) {
        String sql="update TS set Rtime='"+rtime+"' where Bno="+String.valueOf(bno)+" and Tno="+String.valueOf(tno);
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
