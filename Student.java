//import java.util.*;

public class Student extends User implements StudentInterface, java.io.Serializable{
	
	
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	//The two following methods all help us create a new student object
	//But according to different parameters
	//different methods will be called
	//So, different student objects will be created
	
	public Student(String a, String b) {
		FirstName = a;
		LastName =b;
		Username = "1";
		Password = "1";
		
	}
	
	
	public Student (String a, String b, String c, String d) {
		FirstName = a;
		LastName = b;
		Username = c;
		Password = d;
		
	}
	
	
	
	//Override viewAllCourse Method  in Class User
	public void ViewAllCourse() {
		
		
		for (int i = 0;i<Directory.CourseList.size();i++) {
			//System.out.println(i);
					
			Directory.CourseList.get(i).PrintAllInfo();
			System.out.println();
	
				}
		
		System.out.println("All course information are displayed");
		System.out.println();
		
				
		
		
		
	}

	@Override
	public void ViewNotFullCourse() {
		for (int i = 0; i<Directory.CourseList.size();i++) {
			if (Directory.CourseList.get(i).getCurrentStudentNumber()<Directory.CourseList.get(i).getMaxStudentNumber()) {
				Directory.CourseList.get(i).PrintAllInfo();
				 System.out.println();
			
			}//end of if
		
		}//end of for loop
	
		System.out.println("All not full course information are displayed");
		System.out.println();
		
		
	}

	

	
		
	
	public void StudentRegisteraCourse(String fn, String ln, String Coursename, int Coursesection) {
		Course pc = new Course();
		Student ps = new Student();
		String courseflag = "F";
		String studentflag = "F";
		int courseindexkey = -102;
		int studentindexkey = -1000;
		
		
		for (int i = 0; i<Directory.CourseList.size();i++) {
			
			if (Directory.CourseList.get(i).getCourseName().equals(Coursename)&&Directory.CourseList.get(i).getCourseSection()==Coursesection) {
				courseflag = "T";
				courseindexkey = i;
				break;
				
			}//end of if two properties match up
			
		
		}// end of for loop
		
		if (courseflag.equals("F")) {
			System.out.println("The course you typed doesn't exist due to wrong name or wrong section number");
			System.out.println("Try one more time");
			System.out.println();
			//input.nextLine();
		}// if courseflag = F
		
		
		else if (Directory.CourseList.get(courseindexkey).getCurrentStudentNumber()==Directory.CourseList.get(courseindexkey).getMaxStudentNumber()) {
			System.out.println("This course is already full");
			System.out.println();
			//input.nextLine();

		}
		
		else {// the first check: the course is correct is checked
			
			for (int j = 0; j<Directory.StudentList.size();j++) {
				
				
				
				if (Directory.StudentList.get(j).FirstName.equals(fn)&&Directory.StudentList.get(j).LastName.equals(ln)) {
					studentflag = "T";
					studentindexkey = j;
					//System.out.println("Found this name");
					
				}//end of if
				
			}//end of for loop for studentlist
			
			if (studentflag.equals("F")) {
				
				System.out.println("The first name and last name you typed are not in our system");
				System.out.println("Please try again");
				System.out.println();
			}//end of studentflag = f
			
			else {
				//studentflag = T
				
				//Directory.CourseList.get(courseindexkey).
				Directory.CourseList.get(courseindexkey).getThisCourseRegisteredStudentList().add(Directory.StudentList.get(studentindexkey));
				
				//Since a new student registered, the current number of this course must +1
				Directory.CourseList.get(courseindexkey).setCurrentStudentNumber(Directory.CourseList.get(courseindexkey).getCurrentStudentNumber()+1);
				System.out.println("Action Completed");
				//System.out.println("This course is not full and registration is done");
				System.out.println();
				//input.nextLine();
			}//end of else
			
			
		}//else: if courseflag is T
		
		
		
		
	}// end of the method registering
	
	
	
	
	
	
	

	@Override
	public void StudentWithdrawaCourse(String fn, String ln, String coursename, int section) {
		String crflag = "F";
		int ccindex = -102;
		
		for (int i = 0; i<Directory.CourseList.size();i++) {
			
			if (Directory.CourseList.get(i).getCourseName().equals(coursename)&&Directory.CourseList.get(i).getCourseSection()==section) {
				crflag = "T";
				ccindex = i;
				break;
				
			} //end of if
		
		}//end of for
		
		
		
		if (crflag.equals("F")) {
			System.out.println("The course you inputted is not in our system");
			System.out.println();
			
			
		}
		
		else {
			//Course is in the system
		
			if (Directory.CourseList.get(ccindex).getCurrentStudentNumber()==0) {
				System.out.println("There is no student in the course");
				System.out.println("Action cancelled");
				System.out.println();
				
			}
			
			else {
				
				
				//Course is in the system and current student is not zero
				
				if (crflag.equals("T")) {
					//course is in the system
					String nrflag = "false";
					int cnw = -102;
					
					
					for (int p = 0; p < Directory.CourseList.get(ccindex).getThisCourseRegisteredStudentList().size();p++) {
						
						
						
						
						String suspiciousfn = Directory.CourseList.get(ccindex).getThisCourseRegisteredStudentList().get(p).FirstName;
						String suspiciousln = Directory.CourseList.get(ccindex).getThisCourseRegisteredStudentList().get(p).LastName;
						
						if(suspiciousfn.equals(fn)&&suspiciousln.equals(ln)) {
							
							//System.out.println("Found!!!!!!!!!!!");
							nrflag = "true";
							
							Directory.CourseList.get(ccindex).getThisCourseRegisteredStudentList().remove(p);
							Directory.CourseList.get(ccindex).setCurrentStudentNumber(Directory.CourseList.get(ccindex).getCurrentStudentNumber()-1);
							
							
							break;
						}//end of if
						
						
						
						
						
			
							
						//}// end of if 
						
			
					}// end of for
					
					
					if (nrflag.equals("false")) {
						
						System.out.println("There is no such a student in the registered list of this course" );
						System.out.println( );
						
					}//end of if
					
					else {
						System.out.println("Remove was sucessful");
						System.out.println();
					}//end of else
					
					
				
				
							}// end of if crflag is true
			
				
			
				}// end of else
			
			}
		
	}// end of the withdraw method

	@Override
	public void ViewAllCoursesalreadyRegistered(String fn, String ln) {
		
		
		String insystemflag = "F";
		
		for (int j =0;j<Directory.StudentList.size();j++) {
			if(Directory.StudentList.get(j).getFirstName().equals(fn)&&Directory.StudentList.get(j).getLastName().equals(ln)) {
				
				insystemflag = "T";
			}//end of if
			
			
			
		}//end of for loop
		
		for (int i =0;i<Directory.CourseList.size();i++) {
			
			for (int j = 0;j<Directory.CourseList.get(i).getThisCourseRegisteredStudentList().size();j++) {
				
				if(Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(j).getFirstName().equals(fn)&&Directory.CourseList.get(i).getThisCourseRegisteredStudentList().get(j).getLastName().equals(ln)) {
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
		
		
		
		
		
		
		// TODO Auto-generated method stub
		
	}

	
	
	

}
