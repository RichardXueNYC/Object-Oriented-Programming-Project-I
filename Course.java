import java.util.*;

public class Course implements java.io.Serializable{

	public Course() {	
	}
	
	
	//Encapsulation Example
		private String CourseName = "default";
		private String CourseId;
		private int MaxStudentNumber;
		private int CurrentStudentNumber;		
		private ArrayList<Student> ThisCourseRegisteredStudentList = new ArrayList<Student>();
		private String CourseInstructor;
		private int CourseSection;
		private String CourseLocation;
	

	
	
	//This is the constructor that takes all the necessary info
	//to create a new class
	//This constructor combined with some codes in the main method
	//should be enough for 'creating a new course'
	
	public Course(String a, String b, int c, int d, String f, int g, String h) {
		
		CourseName = a;
		CourseId = b;
		MaxStudentNumber = c;
		CurrentStudentNumber = d;
		ThisCourseRegisteredStudentList = new ArrayList<Student>();
		CourseInstructor = f;
		CourseSection = g;
		CourseLocation = h;
		
		
		
	}
	
	public Course (int currentstudentn) {
		CurrentStudentNumber = currentstudentn;
	}
	
	
	
	
	public void PrintAllInfo() {
		
		System.out.println("Course name: "+CourseName);
		System.out.println("Course id: "+CourseId);
		System.out.println("Max Student number: "+MaxStudentNumber);
		System.out.println("Current Student Number: "+CurrentStudentNumber);
		System.out.print("The current registered student list: ");
		System.out.println();
		
		
		
		if (ThisCourseRegisteredStudentList==null) {
			System.out.println("Right now, no student");
			
		}
		else {
			for(Student student:ThisCourseRegisteredStudentList) {
				System.out.println(student.getFirstName()+" "+ student.getLastName());
				
            
			}// end of for
		}
		
		System.out.println("Course Instructor: "+CourseInstructor);
		System.out.println("Course Section: "+CourseSection);
		System.out.println("Course Location: "+CourseLocation);
	
	}
	
	
	//All the getters and setters
	public String getCourseName() {
		return CourseName;
	}

	public void setCourseName(String courseName) {
		CourseName = courseName;
	}

	public String getCourseId() {
		return CourseId;
	}

	public void setCourseId(String courseId) {
		CourseId = courseId;
	}

	public int getMaxStudentNumber() {
		return MaxStudentNumber;
	}

	public void setMaxStudentNumber(int maxStudentNumber) {
		MaxStudentNumber = maxStudentNumber;
	}

	public int getCurrentStudentNumber() {
		return CurrentStudentNumber;
	}

	public void setCurrentStudentNumber(int currentStudentNumber) {
		CurrentStudentNumber = currentStudentNumber;
	}

	

	public ArrayList<Student> getThisCourseRegisteredStudentList() {
		return ThisCourseRegisteredStudentList;
	}

	public void setThisCourseRegisteredStudentList(ArrayList<Student> ThisCourseRegisteredStudentList) {
		ThisCourseRegisteredStudentList = ThisCourseRegisteredStudentList;
	}

	public String getCourseInstructor() {
		return CourseInstructor;
	}

	public void setCourseInstructor(String courseInstructor) {
		CourseInstructor = courseInstructor;
	}

	public int getCourseSection() {
		return CourseSection;
	}

	public void setCourseSection(int courseSection) {
		CourseSection = courseSection;
	}

	public String getCourseLocation() {
		return CourseLocation;
	}

	public void setCourseLocation(String courseLocation) {
		CourseLocation = courseLocation;
	}
	
	

}
