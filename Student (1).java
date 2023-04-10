/** Author: Arjun Gupta
Date: 4/9/23
Student class: This class has all the variables and info for the student, such as their name, list of sessions they want, and a list of sessions they actually got. It also has get and set methods.
*/
import java.util.ArrayList;

public class Student {
  private String name;
  private ArrayList<Integer> preferredSession = new ArrayList<Integer>();
  private ArrayList<Integer> actualSession = new ArrayList<Integer>();

  /* constructor */
  public Student(String name, int num1, int num2, int num3, int num4, int num5) {
    this.name = name;
    preferredSession.add(num1);
    preferredSession.add(num2);
    preferredSession.add(num3);
    preferredSession.add(num4);
    preferredSession.add(num5);
    actualSession.add(0); //make all values 0 to start with in arraylist
    actualSession.add(0);
    actualSession.add(0);
    actualSession.add(0);
    actualSession.add(0);
  }

  /* get methods */
  public String getName() {
    return name;
  }

  public ArrayList<Integer> getPreferredSessionList() {
    return preferredSession;
  }

  public ArrayList<Integer> getActualSession() {
    return actualSession;
  }  

  /* add method */
  public void addActualSession(int num) {
    actualSession.add(num);
  }

  /* set method */
  public void setName(String name) {
    this.name = name;
  }


}