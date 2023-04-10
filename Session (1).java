/**Author: Arjun Gupta
Date: 4/9/23
Session class: holds the variables and information for a session such as the name, speaker's name, session number, total votes for session, and a list of the students attending it. It has also has get and set methods for these variables.
*/
import java.util.ArrayList;

public class Session {
  private String name;
  private String speaker;
  private int number;
  private int totalVotes;
  private ArrayList<Student> stuList = new ArrayList<Student>();

  /* constructor */
  public Session(String name, String speaker, int number) {
    this.name = name;
    this.speaker = speaker;
    this.number = number;
  }

  /* set methods */
  public void setName(String str) {
    name = str;
  }

  public void setSpeaker(String str) {
    speaker = str;
  }  

  public void setNumber(int num) {
    number = num;
  }

  /* add method */
  public void addTotalVotes(int num) {
    totalVotes += num;
  }

  /* subtract method */
  public void subtractTotalVotes(int num) {
    totalVotes -= num;
  }

  /* get methods */
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

  /* get all the students' names */
  public String getStuNames() {
    String studentNames = "";
    for (int i = 0; i<stuList.size(); i++) {
      studentNames = studentNames + 
        stuList.get(i).getName() + ", ";
    }
    return studentNames;
  }
}