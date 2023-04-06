import java.util.ArrayList;

public class Student {
  private String name;
  private ArrayList<Integer> preferredSession = new ArrayList<Integer>();
  private ArrayList<Integer> actualSession = new ArrayList<Integer>();

  public Student(String name, int num1, int num2, int num3, int num4, int num5) {
    this.name = name;
    preferredSession.add(num1);
    preferredSession.add(num2);
    preferredSession.add(num3);
    preferredSession.add(num4);
    preferredSession.add(num5);
    actualSession.add(0);
    actualSession.add(0);
    actualSession.add(0);
    actualSession.add(0);
    actualSession.add(0);
  }
  public String getName() {
    return name;
  }

  public void addActualSession(int num) {
    actualSession.add(num);
  }

  public ArrayList<Integer> getPreferredSessionList() {
    return preferredSession;
  }

  public ArrayList<Integer> getActualSession() {
    return actualSession;
  }  

  public void setName(String name) {
    this.name = name;
  }


}