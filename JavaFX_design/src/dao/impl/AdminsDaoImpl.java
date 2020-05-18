package dao.impl;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import dao.AdminsDao;
import entity.Admins;
public class AdminsDaoImpl implements AdminsDao{

    private   String driver=null;
    private   String url=null;
    private   String user=null;
    private   String password=null;
    {
        try{
            //使用类加载器的方式加载资源配置文件，配置文件必须在SRCz下
            InputStream  in= UserDaoImpl.class.getClassLoader().getResourceAsStream("jdbc.properties");
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
    public List<Admins> findAll() {
        String sql="select * from Admins";
        List<Admins> list=new ArrayList<Admins>();
        try{
            conn= getConnection();
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            while(rs.next()){
                Admins admins=new Admins();
                admins.setAno(rs.getInt("Ano"));
                admins.setAname(rs.getString("Aname"));
                admins.setApass(rs.getString("Apass"));
                admins.setId(rs.getString("ID"));
                admins.setPhone(rs.getString("Phone"));
                list.add(admins);
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
    public void insert(long ano, String aname, String apass, String phone, String id) {
        String sql="insert into Admins values("+String.valueOf(ano)+",'"+aname+"','"+apass+"','"+phone+"','"+id+"')";
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
    public void erase(long ano) {
        String sql="delete from Admins where Ano = "+String.valueOf(ano);
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
    public int exist(long ano) {
        String sql="select count(*) from Admins where Ano= "+String.valueOf(ano);
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
    public void change_aname(long ano, String aname) {
        String sql="update Admins set aname='"+aname+"' where ano="+String.valueOf(ano);
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
    public void change_apass(long ano, String apass) {
        String sql="update Admins set apass='"+apass+"' where ano="+String.valueOf(ano);
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
    public void change_phone(long ano, String phone) {
        String sql="update Admins set phone='"+phone+"' where ano="+String.valueOf(ano);
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
    public void change_id(long ano, String id) {
        String sql="update Admins set id='"+id+"' where ano="+String.valueOf(ano);
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
