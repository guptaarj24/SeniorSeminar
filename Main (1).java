/**Author: Arjun Gupta
//Date: 4/9/23
//Main class: This class puts all the seniors into their seminars, //creates a schedule without conflicts, and prints the schedule, //attendance lists, and students' schedules. 
*/
  
import java.util.ArrayList; // import the ArrayList class
import java.util.Arrays; //import for arraysimport java.io.File;  // Import the File class
import java.util.Collections; //import for collections and sort
import java.util.Comparator; //import for comparing and sorting
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.io.File; //import for File
import java.io.FileWriter;   // Import the FileWriter class
import java.io.IOException;  // Import the IOException class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.io.Writer; //import writer class to write out CSV file

/* main class */
class Main {
  //declare all public static variables
  public static ArrayList<Session> allSessions = new ArrayList<Session>();
  public static ArrayList<Integer> allVotes = new ArrayList<Integer>();
  public static ArrayList<Student> allStudents = new ArrayList<Student>();
  public static int minVotes = 0; //minimum votes to hold session
  public static Session[][] actSchedule = new Session[5][5]; //2D array of actual Session objects
  public static int[][] schedule = new int[5][5]; //how all schedules will be placed

  /* main */
  public static void main(String[] args) {
    //add each unique session in arraylist
    allSessions.add(new Session("Adventure Calls: The Benefits and Challenges of Study Abroad", "Gunnar Lykins", 1));
    allSessions.add(new Session("Be Your Own Boss: Entrepreneurship Opportunities in College and Beyond", "Edwin Sam", 2));
    allSessions.add(new Session("Business Clubs: Campus Involvement and Professional Development", "Blake Lykins", 3));
    allSessions.add(new Session("College Decisions: Choosing a Historically Black College over a Predominately White Institution", "Liah Apatira", 4));
    allSessions.add(new Session("Community Organizing and College: Participating in Your College?s Democracy", "Anna Beyette", 5));
    allSessions.add(new Session("Community Service and Volunteering: Making an Impact as a College Student", "Nathan Grant", 6));
    allSessions.add(new Session("Conquering the Concrete Jungle", "Madeleine Morales", 7));
    allSessions.add(new Session("Co-Ops and Engineering Internships: Gaining Professional Experience", "Gunnar Lykins", 8));
    allSessions.add(new Session("Emergency Medical Technician: Working in the Back of an Ambulance", "Grace Pettengill", 9));
    allSessions.add(new Session("Greek Life: From Animal House to Developing Tomorrow's Leaders", "Blake Lykins", 10));
    allSessions.add(new Session("Making an Impact: Being a Leader in Student Government", "Roshan Chandrakumar", 11));
    allSessions.add(new Session("On-Campus Recruiting and the Coveted Junior Year Internship in Finance", "Mia Fatuzzo", 12));
    allSessions.add(new Session("So You Want to Play with Swords: Performance Martial Arts and Club Leadership", "Claire Beyette", 13));
    allSessions.add(new Session("The Ins and Outs of Engineering Internships", "Elizabeth Grace", 14));
    allSessions.add(new Session("The Road Less Traveled: Finding the Right Path for You", "Ishan Ghildyal", 15));
    allSessions.add(new Session("Thriving in a Highly Competitive College Environment", "Mia Fatuzzo", 16));
    allSessions.add(new Session("To Read or Not To Read? Interning in Publishing", "Claire Beyette", 17));
    allSessions.add(new Session("What Is Research When It's Not a R‚sum‚ Builder?", "Elizabeth Johnson", 18));
    
        //load attendees from data file
    try {
      File myObj = new File("SrSeminar.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String dataLine = myReader.nextLine();
        String [] dataInfo = dataLine.split(",");
        allStudents.add(new Student(dataInfo[0], Integer.parseInt(dataInfo[1]), Integer.parseInt(dataInfo[2]), Integer.parseInt(dataInfo[3]), Integer.parseInt(dataInfo[4]), Integer.parseInt(dataInfo[5]))); //create student object with all information
        //add all the votes into arraylist to parse through list
        allVotes.add(Integer.parseInt(dataInfo[1])); 
        allVotes.add(Integer.parseInt(dataInfo[2]));
        allVotes.add(Integer.parseInt(dataInfo[3]));
        allVotes.add(Integer.parseInt(dataInfo[4]));
        allVotes.add(Integer.parseInt(dataInfo[5]));
      }
      myReader.close();
    } //close try 
    catch (FileNotFoundException e) {
        System.out.println("An error occurred.");
        e.printStackTrace();
    } //close catch

    //increment each session counter by going through arrayList of allVotes
    for (int i = 0; i<allVotes.size(); i++) {
      if (allVotes.get(i)==1) {
        allSessions.get(0).addTotalVotes(1);
      }
      else if (allVotes.get(i)==2) {
        allSessions.get(1).addTotalVotes(1);
      }
      else if (allVotes.get(i)==3) {
        allSessions.get(2).addTotalVotes(1);
      }
      else if (allVotes.get(i)==4) {
        allSessions.get(3).addTotalVotes(1);
      }
      else if (allVotes.get(i)==5) {
        allSessions.get(4).addTotalVotes(1);
      }
      else if (allVotes.get(i)==6) {
        allSessions.get(5).addTotalVotes(1);
      }
      else if (allVotes.get(i)==7) {
        allSessions.get(6).addTotalVotes(1);
      }
      else if (allVotes.get(i)==8) {
        allSessions.get(7).addTotalVotes(1);
      }
      else if (allVotes.get(i)==9) {
        allSessions.get(8).addTotalVotes(1);
      }
      else if (allVotes.get(i)==10) {
        allSessions.get(9).addTotalVotes(1);
      }
      else if (allVotes.get(i)==11) {
        allSessions.get(10).addTotalVotes(1);
      }
      else if (allVotes.get(i)==12) {
        allSessions.get(11).addTotalVotes(1);
      }
      else if (allVotes.get(i)==13) {
        allSessions.get(12).addTotalVotes(1);
      }
      else if (allVotes.get(i)==14) {
        allSessions.get(13).addTotalVotes(1);
      }
      else if (allVotes.get(i)==15) {
        allSessions.get(14).addTotalVotes(1);
      }
      else if (allVotes.get(i)==16) {
        allSessions.get(15).addTotalVotes(1);
      }
      else if (allVotes.get(i)==17) {
        allSessions.get(16).addTotalVotes(1);
      }
      else if (allVotes.get(i)==18) {
        allSessions.get(17).addTotalVotes(1);
      }
    } // close for loop incrementing each Sesh variable

    //sort sessions by popularity in descending order
    Collections.sort(allSessions, new Comparator<Session>()
         {
           //example of descending sort
          public int compare(Session s1, Session s2) {
            return Integer.valueOf(s2.getTotalVotes()).compareTo(s1.getTotalVotes());
          }
        });

    //making schedule for placing all the sessions
    boolean found = false;
    int sessionsIndex = 0;
    int column = 0;
    int row = 0;
    for (sessionsIndex = 0; sessionsIndex<18; sessionsIndex++) { //put for loop for allSessions
      column = 0;
      found = false;
      while ((column<5) && (found==false)) {
        row = 0; 
        while ((row<5) && (found==false)) {
          if (schedule[row][column]==0) { //check if spot is not populated
            if ((column == 0) || (checkPresenterConflict(row, allSessions.get(sessionsIndex).getNumber()) == false)) { //either first column or check that presenter isn't already in time slot
              if (allSessions.get(sessionsIndex).getTotalVotes() > minVotes) { //more than 0 (minVotes) people should want to attend session
                schedule[row][column] = allSessions.get(sessionsIndex).getNumber(); //assign number to 2D schedule
                Session s1 = new Session(allSessions.get(sessionsIndex).getName(), allSessions.get(sessionsIndex).getSpeaker(), allSessions.get(sessionsIndex).getNumber()); //make session for 2D schedule of sessions
                actSchedule[row][column] = s1; //add that session to 2D schedule of sessions
                found = true;
              } //close inner if
            } //close outer if         
          }
          row++;
        } //close row while
        column++;
      } //close column while
    } //close for loop for sessions

    //second pass for top 7 popular sessions to repeat them
    for (sessionsIndex = 0; sessionsIndex<7; sessionsIndex++) { //go through top 7 sessions
      column = 0;
      found = false;
      while ((column<5) && (found==false)) {
        row = 0; 
        while ((row<5) && (found==false)) {
          if (schedule[row][column]==0) { //check if spot is not populated
            if ((column == 0) || (checkPresenterConflict(row, allSessions.get(sessionsIndex).getNumber()) == false)) { //either first column or check that presenter isn't already in time slot
              if (allSessions.get(sessionsIndex).getTotalVotes() > minVotes) { //more than 0 (minVotes) people should want to attend session
                schedule[row][column] = allSessions.get(sessionsIndex).getNumber(); //assign number to 2D schedule
                Session s1 = new Session(allSessions.get(sessionsIndex).getName(), allSessions.get(sessionsIndex).getSpeaker(), allSessions.get(sessionsIndex).getNumber()); //make session for 2D schedule of sessions
                actSchedule[row][column] = s1; //add that session to 2D schedule of sessions
                found = true;
              } //close inner if
            } //close outer if         
          }
          row++;
        } //close row while
        column++;
      } //close column while
    } //close for loop for sessions    

    
    //place all students into 2D schedule  
    int desiredSession = 0;
    for (int i = 0; i<allStudents.size(); i++) { //go through all students
      for (int j = 0; j<5; j++) { //place student in five sessions
        desiredSession = allStudents.get(i).getPreferredSessionList().get(j); //grab the session they want
        row = 0;
        found = false;
        while ((row<5) && (found==false)) {
          column = 0;
          while ((column<5) && (found==false)) {
            if (desiredSession==actSchedule[row][column].getNumber()) { //if the session number matches the one they want
              if ((actSchedule[row][column].getStuList().size()<16) //if session isn't full
                  && (allStudents.get(i).getActualSession().get(row)==0)) { //if they aren't already placed in a session at that time
                actSchedule[row][column].getStuList().add(allStudents.get(i)); //add student to student list of session
                allStudents.get(i).getActualSession().set(row, actSchedule[row][column].getNumber()); //add session number to student's list of actual sessions
                found = true;
              }
            }
            column++;
          } //close column while
          row++;
        } //close row while
      } //close loop for preferred session list
    } //close loop for all students

    //place students in sessions during time slots they never got assigned because their preferred sessions weren't available
    boolean alrInSession = false;
    for (int i = 0; i<allStudents.size(); i++) { //go through all the students
      for (int j = 0; j<5; j++) { //go through ActualSession list and j is the row number
        if (allStudents.get(i).getActualSession().get(j)==0) { //make sure their session spot is unfilled
          String name = allStudents.get(i).getName();
          column = 4; //going from back of schedule to use least popular sessions first
          found = false;
          while ((column>-1) && (found==false)) {
            alrInSession = false;
            if (actSchedule[j][column].getStuList().size()<16) { //make sure session isn't full
              for (int k = 0; k<5; k++) { //'k' is just to go through ActualSession and make sure they aren't already in this session in another time slot
                if ((actSchedule[j][column].getNumber()==allStudents.get(i).getActualSession().get(k))) { // check if student is already attending session
                  alrInSession = true;
                }
              }//close for loop searching through ActualSession list if student already attending session
              if (alrInSession==false) { //if they aren't already in the session
                actSchedule[j][column].getStuList().add(allStudents.get(i)); //add student to attendance list
                allStudents.get(i).getActualSession().set(j, actSchedule[j][column].getNumber()); //set student's actual session list with session number
                found = true;
              } //close inner if
            } //close if statement for max capacity
            column--;
          } //close row while
        }
      } //close loop for ActualSession list
    } //close loop for all students
   
    //printing out schedule
    for (int tRow =0; tRow<5; tRow++) {
      for (int tColumn=0; tColumn<5; tColumn++) {
        System.out.print(schedule[tRow][tColumn] + "\t");
      }
      System.out.println();
    }

    //printing out schedule of session objects
    for (int r = 0; r<5; r++) {
      for (int c = 0; c<5; c++) {
        System.out.println(actSchedule[r][c].getName() + ": " + actSchedule[r][c].getStuList().size() + ":" + actSchedule[r][c].getStuNames() + "\n");
      }
    }

    //printing out student's actual session list
    for (int i = 0; i<allStudents.size(); i++) {
      System.out.print("\n" + allStudents.get(i).getName() + ": ");
      for (int j = 0; j<5; j++) {
        System.out.print(allStudents.get(i).getActualSession().get(j) + ", ");
      }
    }

    printCSVFile();
    
  } //close main

  /* method to check if presenter is already in time slot */
  public static boolean checkPresenterConflict(int rowNum, int sessionNumber) {
    for (int i = 0; i < 5; i++) {
      if (getPresenterName(schedule[rowNum][i]).equals(getPresenterName(sessionNumber))) {
        return true;
      }
    }
    return false;
  } //close CheckPresenterConflict

  /* return the name of presenter */
  public static String getPresenterName(int sessionNumber) {
    for (Session s1: allSessions) {
      if (s1.getNumber() == sessionNumber) {
        return s1.getSpeaker();
      }
    }
    return "";
  }

  /* print out all the information in the CSV file */
  public static void printCSVFile() {
    String fName = "SeniorSeminarRoster.txt";
    try {
      File myObj = new File(fName);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
        try {
          FileWriter myWriter = new FileWriter(fName);
          //printing schedule
          myWriter.write("The following shows the sessions running at certain time slots");
          myWriter.write("\n");
          for (int tRow =0; tRow<5; tRow++) {
            myWriter.write(tRow+1 + "pm: \t"); //print actual times
            for (int tColumn=0; tColumn<5; tColumn++) {
              if ((schedule[tRow][tColumn]/10)==0) { //format the schedule grid with equal spacing
                myWriter.write(schedule[tRow][tColumn] + "   ");
              }
              else {
                myWriter.write(schedule[tRow][tColumn] + "  ");
              }
            }
          myWriter.write("\n");
          }
          myWriter.write("\n");
          //printing out schedule of session objects
          myWriter.write("The following shows each session with their session number, number of attendees, and a list of the attending students' names. It is in order of each row. \n\n");
          for (int r = 0; r<5; r++) {
            for (int c = 0; c<5; c++) {
              myWriter.write(actSchedule[r][c].getName() + " (" + actSchedule[r][c].getNumber() + ")" + ": " +  actSchedule[r][c].getStuList().size() + "\n" + actSchedule[r][c].getStuNames() + "\n");
              myWriter.write("\n");
      }
    }
          //printing out student's actual session list
          myWriter.write("The following shows all the students and their five sessions' numbers in chronological order. \n");
          for (int i = 0; i<allStudents.size(); i++) {
            myWriter.write("\n" + allStudents.get(i).getName() + ": ");
            for (int j = 0; j<5; j++) {
              myWriter.write(allStudents.get(i).getActualSession().get(j) + ", ");
            }
          }
          myWriter.close();
        }  
        catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
      } 
      else {
        System.out.println("File already exists.");
      }
    } 
    catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }
}//close whole program