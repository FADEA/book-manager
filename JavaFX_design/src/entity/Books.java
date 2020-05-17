package entity;


public class Books {

  private long bno;
  private String bname;
  private String author;
  private String press;
  private long amount;
  private long btype;
  private java.sql.Date bday;

  public long getBno() {
    return bno;
  }

  public void setBno(long bno) {
    this.bno = bno;
  }


  public String getBname() {
    return bname;
  }

  public void setBname(String bname) {
    this.bname = bname;
  }


  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }


  public String getPress() {
    return press;
  }

  public void setPress(String press) {
    this.press = press;
  }


  public long getAmount() {
    return amount;
  }

  public void setAmount(long amount) {
    this.amount = amount;
  }


  public long getBtype() {
    return btype;
  }

  public void setBtype(long btype) {
    this.btype = btype;
  }


  public java.sql.Date getBday() {
    return bday;
  }

  public void setBday(java.sql.Date bday) {
    this.bday = bday;
  }

}
