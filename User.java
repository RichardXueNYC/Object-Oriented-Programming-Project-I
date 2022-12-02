
public abstract class User implements java.io.Serializable{
	
	
	
	//A user should at least has username, password, first name, and last name
	//Because the Admin Class and the Student Class inherit the User Class
	//Add the protected keyword
	
	protected String Username;
	protected String Password;
	protected String FirstName;
	protected String LastName;
	
	
	
	
	public String getUsername() {
		return Username;
	}

	


	public void setUsername(String username) {
		Username = username;
	}




	public String getPassword() {
		return Password;
	}




	public void setPassword(String password) {
		Password = password;
	}




	public String getFirstName() {
		return FirstName;
	}




	public void setFirstName(String firstName) {
		FirstName = firstName;
	}




	public String getLastName() {
		return LastName;
	}




	public void setLastName(String lastName) {
		LastName = lastName;
	}




	public User() {
		// TODO Auto-generated constructor stub
	}

	//Overriding example 1
	//Because student and Admin all have a function to view all courses
	//I first write a prototype method here
	//And overrides it later with a new version in class Admin and Class Student
	
	public void ViewAllCourse() {
		
		for (int i = 0; i<Directory.CourseList.size();i++) {
					
					Directory.CourseList.get(i).PrintAllInfo();
					
					
					
				}
		
		System.out.println("Default view all courses, as a user");
				
			}// end of view all courses
	
	
	//Overriding example 2
	//Same thing goes here
	//I know that both students and admins are able to enroll a student in a course
	//So I first write a prototypical version here and override it later in class Admin and class Student
	//This prototype doesn't have the ability to check if a course is already full or not
	//But the overriding method in Class Student is able to do that
	//But I remember it's only overrode in class Student
	
	public void StudentRegisteraCourse(String fn, String ln, String Coursename, int Coursesection) {
		
		
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
		
		
		
		
		
		
		
	}// end of student register a course method




	public abstract void StudentWithdrawaCourse(String fn, String ln, String coursename, int section);
		
		
	
	




	




	
	
	

}
