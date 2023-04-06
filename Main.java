import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files
import java.util.*; // import for ArrayList
import java.util.Arrays;

class Main {
  //declare all public static variables
  public static ArrayList<Session> allSessions = new ArrayList<Session>();
  public static ArrayList<Integer> allVotes = new ArrayList<Integer>();
  public static ArrayList<Student> allStudents = new ArrayList<Student>();
  public static int minVotes = 0; //minimum votes to hold session
  public static Session[][] actSchedule = new Session[5][5]; //2D array of actual Session objects
  public static int[][] schedule = new int[5][5]; //how all schedules will be placed
  
  public static void main(String[] args) {
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
        allStudents.add(new Student(dataInfo[0], Integer.parseInt(dataInfo[1]), Integer.parseInt(dataInfo[2]), Integer.parseInt(dataInfo[3]), Integer.parseInt(dataInfo[4]), Integer.parseInt(dataInfo[5])));
        allVotes.add(Integer.parseInt(dataInfo[1]));
        allVotes.add(Integer.parseInt(dataInfo[2]));
        allVotes.add(Integer.parseInt(dataInfo[3]));
        allVotes.add(Integer.parseInt(dataInfo[4]));
        allVotes.add(Integer.parseInt(dataInfo[5]));
        //Attendee g1 = new Attendee(attendee[2], attendee[1], Integer.parseInt(attendee[3]));
        //attendeeList.add(g1);
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

    //sort Session by popularity in descending order
    Collections.sort(allSessions, new Comparator<Session>()
         {
           //example of descending sort
          public int compare(Session s1, Session s2) {
            return Integer.valueOf(s2.getTotalVotes()).compareTo(s1.getTotalVotes());
          }
        });
    
    //declare 2D array of time slots and sessions
    boolean found = false;
    int sessionsIndex = 0;
    int column = 0;
    int row = 0;
    //put for loop for allSessions
    for (sessionsIndex = 0; sessionsIndex<18; sessionsIndex++) {
      column = 0;
      found = false;
      while ((column<5) && (found==false)) {
        row = 0; 
        while ((row<5) && (found==false)) {
          if (schedule[row][column]==0) { //check if spot is not populated
            if ((column == 0) || (checkPresenterConflict(row, allSessions.get(sessionsIndex).getNumber()) == false)) {
              if (allSessions.get(sessionsIndex).getTotalVotes() > minVotes) {
                schedule[row][column] = allSessions.get(sessionsIndex).getNumber();
                Session s1 = new Session(allSessions.get(sessionsIndex).getName(), allSessions.get(sessionsIndex).getSpeaker(), allSessions.get(sessionsIndex).getNumber());
                actSchedule[row][column] = s1;
                found = true;
              } //close inner if
            } //close outer if         
          }
          row++;
        } //close row while
        column++;
      } //close column while
    } //close for loop for sessions

    //second pass for top 7
    for (sessionsIndex = 0; sessionsIndex<7; sessionsIndex++) {
      column = 0;
      found = false;
      while ((column<5) && (found==false)) {
        row = 0; 
        while ((row<5) && (found==false)) {
          if (schedule[row][column]==0) { //check if spot is not populated
            if ((column == 0) || (checkPresenterConflict(row, allSessions.get(sessionsIndex).getNumber()) == false)) {
              if (allSessions.get(sessionsIndex).getTotalVotes() > minVotes) {
                schedule[row][column] = allSessions.get(sessionsIndex).getNumber();
                Session s1 = new Session(allSessions.get(sessionsIndex).getName(), allSessions.get(sessionsIndex).getSpeaker(), allSessions.get(sessionsIndex).getNumber());
                actSchedule[row][column] = s1;
                found = true;
              } //close inner if
            } //close outer if         
          }
          row++;
        } //close row while
        column++;
      } //close column while
    } //close for loop for sessions    

    
    //place students into schedule   
    int desiredSession = 0;
    for (int i = 0; i<allStudents.size(); i++) {
      i = 2; //zzz
      for (int j = 0; j<5; j++) { //place student in five sessions
        desiredSession = allStudents.get(i).getPreferredSessionList().get(j);
        row = 0;
        found = false;
        while ((row<5) && (found==false)) {
          column = 0;
          while ((column<5) && (found==false)) {
            if (desiredSession==actSchedule[row][column].getNumber()) {
              if ((actSchedule[row][column].getStuList().size()<16)
                  && (allStudents.get(i).getActualSession().get(row)==0)) {
                actSchedule[row][column].getStuList().add(allStudents.get(i));
                allStudents.get(i).getActualSession().set(row, actSchedule[row][column].getNumber());
                found = true;
              }
            }
            column++;
          } //close column while
          row++;
        } //close row while
      } //close loop for preferred session list
      i = allStudents.size(); //zzz
    } //close loop for all students

    //place students in sessions during time slots they never got assigned because their preferred sessions weren't available
    for (int i = 0; i<allStudents.size(); i++) { //go through all the students
      i = 2; //zzz
      for (int j = 0; j<5; j++) { //go through ActualSession list
        if (allStudents.get(i).getActualSession().get(j)==0) {
          column = 4;
          found = false;
          while ((column>-1) && (found==false)) {
            if (actSchedule[j][column].getStuList().size()<16) {
              actSchedule[j][column].getStuList().add(allStudents.get(i));
              allStudents.get(i).getActualSession().set(j, actSchedule[j][column].getNumber());
              found = true;
            }
            column++;
          } //close row while
        }
      }
      i = allStudents.size(); //zzz
    } //close loop for all students
    

    /*
     //place students into schedule   
    int desiredSession = 0;
    int currentSlotIndex = 0;
    for (int i = 0; i<allStudents.size(); i++) { //loop for all the students
      for (int j = 0; j<5; j++) { //place student in five sessions so this is length of preferredSessionList
        desiredSession = allStudents.get(i).getPreferredSessionList().get(j);
        found = false;
        int index = 0; //index of searching through ActualSession list
        while ((index < 5) && (found==false)) { //find open slot in ActualSessionList
          if (allStudents.get(i).getActualSession().get(index) == 0) {
            currentSlotIndex = index;
            found = true;
          }
          index++;
        }
        row = currentSlotIndex; //don't want to increment currentSlotIndex and lose value
        column = 0;
        while ((column<5) && (found==false)) {
          if (desiredSession==actSchedule[row][column].getNumber()) {
            if (actSchedule[row][column].getStuList().size()<16) {
              actSchedule[row][column].getStuList().add(allStudents.get(i)); //place student in schedule attendance
              allStudents.get(i).getActualSession().add(currentSlotIndex, actSchedule[row][column].getNumber()); //add the session number into student's list of actual sessions
              found = true;
            }
          }
          column++;
        } //close while loop
      } //close for loop going through all preferred sessions
      for (int m = 0; m < 5; m++) {
        if (allStudents.get(i).getActualSession().get(m)==0) {
          column = 4;
          found = false;
          while ((column>-1) && (found==false)) {
            if (actSchedule[m][column].getStuList().size()<16) {
              actSchedule[m][column].getStuList().add(allStudents.get(i)); //place student in schedule attendance
              allStudents.get(i).getActualSession().add(m, actSchedule[m][column].getNumber()); //add the session number into student's list of actual sessions
            }
            column--;
          }
        }
      } 
      i = allStudents.size(); //zzz 
    } //close allStudents for loop 
    */
    
    
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
        System.out.println(actSchedule[r][c].getName() + ": " + actSchedule[r][c].getStuNames() + "\n");
      }
    }

    //printing out student's actual session list
    for (int i = 0; i<allStudents.size(); i++) {
      System.out.print("\n" + allStudents.get(i).getName() + ": ");
      for (int j = 0; j<5; j++) {
        System.out.print(allStudents.get(i).getActualSession().get(j) + ", ");
      }
    }
    
  } //close main

  public static boolean checkPresenterConflict(int rowNum, int sessionNumber) {
    for (int i = 0; i < 5; i++) {
      if (getPresenterName(schedule[rowNum][i]).equals(getPresenterName(sessionNumber))) {
        return true;
      }
    }
    return false;
  } //close CheckPresenterConflict

  public static String getPresenterName(int sessionNumber) {
    for (Session s1: allSessions) {
      if (s1.getNumber() == sessionNumber) {
        return s1.getSpeaker();
      }
    }
    return "";
  }
} //close whole program