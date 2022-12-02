import java.io.IOException;

public interface AdminInterface{
	
	//CourseManagement Part
	public void CreateCourse(Course course);
	public void DeleteCourse(Course course);
	public void EditCourse(String Coursename, int Section);
	public void DisplayCourse(String Coursename, int Section);
	public void Register(Student student);
	
	//Report Part
	public void ViewAllCourse();
	public void ViewFullCourse();
	public void WriteFullCourse() throws IOException;
	public void ViewallStudentinaclass(String Coursename, int section);
	public void thecourseastudenttakes(String a, String b);
	public void SortbasedonNumber();
	

}
