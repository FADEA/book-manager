package dao.impl;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import dao.UserDao;
import entity.User;

public class UserDaoImpl implements UserDao{


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
    public List<User> findAll() {
        // TODO Auto-generated method stub
        String sql="select * from user";
        List<User> list=new ArrayList<User>();
        try{
            conn= getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                User user=new User();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
            return list;
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
        return null;
    }
    @Override
    public void insert(String username, String password) {
        // TODO Auto-generated method stub
        String sql="insert into user values('"+username+"','"+password+"')";
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
    public void erase(String username) {
        // TODO Auto-generated method stub
        String sql="delete from user where username = '"+username+"'";
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
    public int exist(String username) {
        // TODO Auto-generated method stub
        String sql="select count(*) from user where username= '"+username+"'";
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
    public String get_username() {
        Connection conn=null;
        Statement st=null;
        ResultSet rs=null;
        String sql="select * from user";
        try{
            conn= getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                return rs.getString("username");
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }finally{
            release(conn, st, rs);
        }
        return null;
    }

    @Override
    public int exist_username_password(String username, String password) {
        String sql="select count(*) from user where username= '" + username + "' and password= '" +password+"'";
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
