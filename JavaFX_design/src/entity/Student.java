package entity;


public class Student {

  private long sno;
  private String sname;
  private String spass;
  private String phone;
  private String id;
  private long borrow;


  public long getSno() {
    return sno;
  }

  public void setSno(long sno) {
    this.sno = sno;
  }
  public String getSname() {
    return sname;
  }

  public void setSname(String sname) {
    this.sname = sname;
  }


  public String getSpass() {
    return spass;
  }

  public void setSpass(String spass) {
    this.spass = spass;
  }

  public String getPhone() {
    return phone;
  }
  public void setPhone(String phone) {
    this.phone = phone;
  }
  public String getId() {
    return id;
  }
  public void setId(String id) {
    this.id = id;
  }
  public long getBorrow() {
    return borrow;
  }
  public void setBorrow(long borrow) {
    this.borrow = borrow;
  }

}
