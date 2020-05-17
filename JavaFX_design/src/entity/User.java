package entity;

public class User {
    private String username;
    private String password;
    public User(){
    }
    public User(String S_username,String S_password){
        this.username=S_username;
        this.password=S_password;
    }
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public void setPassword(String password){
        this.password=password;
    }
    public String toString(){
        return "username="+username+" password="+password;
    }
    public void output(){
        System.out.printf("%-20s",username);
        System.out.printf("%-20s",password);
        System.out.println();
    }
}
