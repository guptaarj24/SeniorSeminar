import java.util.ArrayList;

public class Session {
  private String name;
  private String speaker;
  private int number;
  private int totalVotes;
  private ArrayList<Student> stuList = new ArrayList<Student>();

  public Session(String name, String speaker, int number) {
    this.name = name;
    this.speaker = speaker;
    this.number = number;
  }

  public void setName(String str) {
    name = str;
  }

  public void setSpeaker(String str) {
    speaker = str;
  }  

  public void setNumber(int num) {
    number = num;
  }

  public void addTotalVotes(int num) {
    totalVotes += num;
  }

  public void subtractTotalVotes(int num) {
    totalVotes -= num;
  }

  public String getName() {
    return name;
  }

  public String getSpeaker() {
    return speaker;
  }  

  public int getNumber() {
    return number;
  }

  public int getTotalVotes() {
    return totalVotes;
  }

  public ArrayList<Student> getStuList() {
    return stuList;
  }

  public String getStuNames() {
    String studentNames = "";
    for (int i = 0; i<stuList.size(); i++) {
      studentNames = studentNames + 
        stuList.get(i).getName() + ", ";
    }
    return studentNames;
  }
}