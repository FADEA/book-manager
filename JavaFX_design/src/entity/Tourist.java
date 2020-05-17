package entity;


public class Tourist {

  private long tno;
  private String tname;
  private String tpass;
  private String phone;
  private String id;
  private long borrow;
  private long acces;


  public long getTno() {
    return tno;
  }

  public void setTno(long tno) {
    this.tno = tno;
  }


  public String getTname() {
    return tname;
  }

  public void setTname(String tname) {
    this.tname = tname;
  }


  public String getTpass() {
    return tpass;
  }

  public void setTpass(String tpass) {
    this.tpass = tpass;
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


  public long getAcces() {
    return acces;
  }

  public void setAcces(long acces) {
    this.acces = acces;
  }

}
