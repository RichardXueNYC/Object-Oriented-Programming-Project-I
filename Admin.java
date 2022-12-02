//import java.io.IOException;
import java.io.*;
import java.util.*;

public class Admin extends User implements AdminInterface{

	public Admin() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void CreateCourse(Course course) {
		Directory.CourseList.add(course);
		System.out.println("A new course is created in the system");
		
		
	}

	@Override
	public void DeleteCourse(Course course) {
		Directory.CourseList.remove(course);
		System.out.println("The course is deleted");
		
	}

	
		//According to Chris
		//We are fine (and supposed to) require ID, Course name, and Section number to
		//identify the course precisely without errors
	
		//Also after consulting with him,
		//Course ID, Course name, Course section, and current number of students
		//shouldn't be able to be edited freely
		
		
		//If the admin users decides to use "edit the student list of this class" of this edit function
		//He/She can do two things:
		//Help an already registered student (who is in the Student ArrayList) enroll in this particular class
		//Help an already registered student who is also in this course withdraw from it
		
	
	public void StudentWithdrawaCourse(String fn, String ln, String coursename, int section) {
		//I was going to write something here, but I finished this function
		//in the edit function below
	}
	
	
	public void EditCourse(String Coursename, int Section) {
		
		Scanner input = new Scanner(System.in);
		//String pr = "";
		//String Rflag = "F";
		
		
		
		
		String Flag = "false";
		
		
		for (int i = 0; i<Directory.CourseList.size();i++) {
		
			if (Directory.CourseList.get(i).getCourseName().equals(Coursename)&&Directory.CourseList.get(i).getCourseSection()==Section) {
				
		
				System.out.println("What do you want to edit?");
				System.out.println("1. Maximum number of students registered in the course");
				System.out.println("2. The list of names of students being enrolled in the given course");
				System.out.println("3. Course instructor");
				System.out.println("4. Course Location");
		
		
				String choice = input.nextLine();
				
				if (choice.equals("1")) {
					System.out.println("What's the new maximum number of students of this class?");
					int n = input.nextInt();
					
					
					if(n<=0||n<Directory.CourseList.get(i).getCurrentStudentNumber()) {
						
						System.out.println("Invalid input");
						System.out.println("New max number can't be smaller than current number");
						System.out.println();
					}
					
					else {
					
					
					
					
					
					
					Directory.CourseList.get(i).setMaxStudentNumber(n);
					
					}
				}
				
			
				else if (choice.equals("2")) {
					////////////////////////////////////
					System.out.println("What kind of change you want to do to the list of students of this class?");
					System.out.println("Press 1 to add an already registered student (Function 5 helps you register a student) to the student list of this course");
					System.out.println("Press 2 to delete an already registered student in the student list of this course ");
					System.out.println("Press 3 to do nothing ");
					
					int choice2 = input.nextInt();
					if (choice2 == 1) {
						
						if (Directory.CourseList.get(i).getCurrentStudentNumber()==Directory.CourseList.get(i).getMaxStudentNumber()) {
							System.out.println("This course has reached its maxmimum number");
							System.out.println("Action cancelled");
							System.out.println();
						}
						
						else {
						
						input.nextLine();
						System.out.println("What's the first name of this already registered student?");
						String fn1 ="";
						fn1 = input.nextLine();
						//input.nextLine();
						System.out.println("What's the last name of this already registered student?");
						String ln1 ="";
						ln1 = input.nextLine();
						
						//System.out.println(fn1+ln1);
						//Student  newstu = new Student();
						String studentflag = "F";
						int studentindexkey = -102;
						
						
						
						
						for (int j = 0; j<Directory.StudentList.size();j++) {
							
							if (Directory.StudentList.get(j).FirstName.equals(fn1)&&Directory.StudentList.get(j).LastName.equals(ln1)) {
								studentflag = "T";
								studentindexkey = j;
								//System.out.println("found");
								
							}//end of if
							
							
							
	
							
						}//end of for
						
						if (studentflag.equals("F")) {
							System.out.println("We didn't find this student in our system");
							System.out.println("Make sure he is already registered through Admin Course Management Function 5");
							System.out.println();
							
							
							
						}// end of if studentflag = T
						
						else {//help the student register
							Directory.CourseList.get(i).getThisCourseRegisteredStudentList().add(Directory.StudentList.get(studentindexkey));
							//also, the current number must +1
							Directory.CourseList.get(i).setCurrentStudentNumber(Directory.CourseList.get(i).getCurrentStudentNumber()+1);
							
							System.out.println("This student has already registered in this course");
							System.out.println();
							
							
							
							
							
							
							
							
							
						}// end of if else inner
						
						
						
						
						}// end of else
						
						
						
					}//end of if choice2 == 1
					
					else if (choice2 == 2) {
						//if current = 0, stop his action
						
						
						if (Directory.CourseList.get(i).getCurrentStudentNumber()==0) {
							System.out.println("There is no student in the course");
							System.out.println("Action cancelled");
							System.out.println();
							
							
						}//if student = 0
							
						
						
						else {
						
						
						String Flag2 = "false";
						int criticaln = -102;
						
						input.nextLine();
						System.out.println("What's the first name of this student?");
						String fnc = input.nextLine();
						
						System.out.println("What's the last name of this student?");
						String lnc = input.nextLine();
						
						
						//System.out.println("Your typed first name is "+ fnc);
						//System.out.println("Your typed last name is "+ lnc);
						
						for (int p = 0; p < Directory.CourseList.get(i).getThisCourseRegisteredStudentList().size();p++) {
							
							
							//System.out.println(Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(p).FirstName);
							//System.out.println(Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(p).LastName);
							
							
							String qwe = Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(p).FirstName;
							String wer = Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(p).LastName;
							
							if(qwe.equals(fnc)&&wer.equals(lnc)) {
								
								//System.out.println("Found!!!!!!!!!!!");
								Flag2 = "true";
								
								Directory.CourseList.get(i).getThisCourseRegisteredStudentList().remove(p);
								Directory.CourseList.get(i).setCurrentStudentNumber(Directory.CourseList.get(i).getCurrentStudentNumber()-1);
								
								
								break;
							}//end of if
							
							
							
							
							
				
								
							//}// end of if 
							
				
						}// end of for
						
						
						if (Flag2.equals("false")) {
							
							System.out.println("There is no such a student in the registered list of this course" );
							System.out.println( );
							
						}//end of if
						
						else {
							System.out.println("Remove was sucessful");
							System.out.println();
						}//end of else
							
							
						}
						
						
					}//end of else if 2
					else if (choice2 == 3) {
						System.out.println("Nothing happened");
						System.out.println();
						
					}// end of else if 
					 
				}//else if 3
				
				else if (choice.equals("3")) {
					System.out.println("What's the first name and last name of the new instructor?");
					String theinstructor = input.nextLine();
					Directory.CourseList.get(i).setCourseInstructor(theinstructor);
					
				}
				//According to Chris, section number is a prime factor 
				//So, it shouldn't be edited easily
				
				/*else if (choice.equals("5")) {
					System.out.println("What's the new course section number?");
					int thenumber = input.nextInt();
					Directory.CourseList.get(i).setCourseSection(thenumber);
					
				}*/
				else if (choice.equals("4")) {
					System.out.println("What's the new course location?");
					String l = input.nextLine();
					Directory.CourseList.get(i).setCourseLocation(l);}
				
				else {
					System.out.println("Invalid input. Please try again.");
				}
					
					
					
				Flag = "true";
				//System.out.println("Edit Success");
				break;//THIS BREAK'S POSITION MAY BE A PROBLEM
				}//end of the if
			
			
		}//end of the for loop
		
	if (Flag == "false")	{
		
		System.out.println("The course name and course section you typed are not matched");
		System.out.println("Please try again");
		System.out.println();
		
	}
		
		
		
		
	}//end of edit method
	
	//So does this display information of a specific course method
	//Three essential properties will help us find the course exactly
	
	@Override
	public void DisplayCourse(String Coursename, int Section) {
		String Flag1 = "false";
		
		
		for (int i = 0; i<Directory.CourseList.size();i++) {
			if (Directory.CourseList.get(i).getCourseName().equals(Coursename)&&Directory.CourseList.get(i).getCourseSection()==Section) {
				Flag1 = "true";
				Directory.CourseList.get(i).PrintAllInfo();
				break;
			}//end of if
		}//end of for
		
		if (Flag1.equals("false")) {
			System.out.println("The information you provided doesn't correspond to any courses in the system");
		}
		
	}//end of the method Display
		
	

	@Override
	//It seems like I wrote a small function in main
	//to finish this goal
	
	
	public void Register(Student student) {
		Directory.StudentList.add(student);
		System.out.println("The student has been registered");
		
		
	}

	//Override viewAllCourse Method  in Class User
	public void ViewAllCourse() {
		for (int i = 0; i<Directory.CourseList.size();i++) {
			
			Directory.CourseList.get(i).PrintAllInfo();
			System.out.println();
			
		}
		System.out.println("All course information are displayed");
	}

	@Override
	public void ViewFullCourse() {
		
		for (int i = 0; i<Directory.CourseList.size();i++) {
			if (Directory.CourseList.get(i).getCurrentStudentNumber()==Directory.CourseList.get(i).getMaxStudentNumber()) {
				Directory.CourseList.get(i).PrintAllInfo();
				System.out.println();
				
			}//end of if
			
		}//end of for loop
		
		System.out.println("All full course information are displayed");
		System.out.println();
		
		
		
	}// end of view full course method

	@Override
	public void WriteFullCourse() throws IOException {
		Writer myWriter = new BufferedWriter(new OutputStreamWriter(
		          new FileOutputStream("./Data/FullCourse.txt"), "utf-8"));
			//Please check the file in the Data folder
		try {			
				
			
			for (int i = 0; i<Directory.CourseList.size();i++) {
				if (Directory.CourseList.get(i).getCurrentStudentNumber()==Directory.CourseList.get(i).getMaxStudentNumber()) {
					myWriter.write(Directory.CourseList.get(i).getCourseName()+"\n");
					
				}//end of if
				
			}//end of for
			
		}catch(IOException e) {
			System.out.println("An IO error occurred.");
		}//end of catch
		System.out.println("All courses that are full are written to the file");
		System.out.println();
		myWriter.close();
		
	}//end of writefullcourse method

	@Override
	public void ViewallStudentinaclass(String Coursename, int section) {
		
		
		
		int Courseindex = -2;
		
		for (int i = 0; i<Directory.CourseList.size();i++) {
			
			if (Directory.CourseList.get(i).getCourseName().equals(Coursename)&&Directory.CourseList.get(i).getCourseSection()==section) {
				Courseindex = i;
				break;
				
			
					
			}//end of if
			
		}//end of for loop
		
		if (Courseindex==-2) {
			System.out.println("This course is not in our system");
			System.out.println("");
		
		}//end of if course index == -2
		
		else {
		
		
		for ( int j = 0; j <Directory.CourseList.get(Courseindex).getThisCourseRegisteredStudentList().size();j++) {
			
			System.out.println(Directory.CourseList.get(Courseindex).getThisCourseRegisteredStudentList().get(j).getFirstName()+" "+Directory.CourseList.get(Courseindex).getThisCourseRegisteredStudentList().get(j).getLastName());
			//System.out.println(Directory.CourseList.get(Courseindex).getThisCourseRegisteredStudentList().get(j).FirstName+" "+Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(j).LastName);
		}// end of for
		
		
		
		System.out.println("All students who are registered for this class are displayed above");
		System.out.println();
		
	
		
			}//end of big else
		
		
		
		
	}//end of view all students in the class

	@Override
	public void thecourseastudenttakes(String fna, String lna) {
		String insystemflag = "F";
		
		for (int j =0;j<Directory.StudentList.size();j++) {
			if(Directory.StudentList.get(j).getFirstName().equals(fna)&&Directory.StudentList.get(j).getLastName().equals(lna)) {
				
				insystemflag = "T";
			}//end of if
			
			
			
		}//end of for loop
		
		for (int i =0;i<Directory.CourseList.size();i++) {
			
			for (int j = 0;j<Directory.CourseList.get(i).getThisCourseRegisteredStudentList().size();j++) {
				
				if(Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(j).getFirstName().equals(fna)&&Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(j).getLastName().equals(lna)) {
					System.out.println(Directory.CourseList.get(i).getCourseName());
					
				}// end of if
				
				
			}//for-loop-inner-j
			
		}// for loop-outer-i
		
		
		if (insystemflag.equals("T")) {
			System.out.println("All courses this student has registered was displayed");
			System.out.println();
			
		}
		else {
			System.out.println("This student is not in the system");
			System.out.println();
			
		}
		
		
	}// end of the method a student is taking
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	@Override
	public void SortbasedonNumber() {
		
			
		Course e = new Course();
		
			//PhoneBookEntry t = new PhoneBookEntry();
			
			for (int i = 0; i<Directory.CourseList.size();i++) {
				
				for (int j = i+1; j< Directory.CourseList.size(); j++) {
					
					
					if (Directory.CourseList.get(i).getCurrentStudentNumber()>Directory.CourseList.get(j).getCurrentStudentNumber()) {
						e = Directory.CourseList.get(i);
						Directory.CourseList.set(i,Directory.CourseList.get(j));
						Directory.CourseList.set(j,e);
						
						
					}//end of if
					
				}// end of inner for loop
				
				
			}//end of for outer for loop
			
			System.out.println("The sort is over");
			
			System.out.println("Now, print the course name based on the number of current registered students:");
			
			for (int k =0; k<Directory.CourseList.size();k++) {
				
				System.out.println(Directory.CourseList.get(k).getCourseName());
			}
			System.out.println();
			
		}// end of the sort method
		
	
		
	
	

}// end of the Admin Class
