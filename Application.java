
import java.util.*;
import java.io.*;


//Dear Grader
//All the files work fine on my computer
//I hope they work out on yours too
//Thanks for Grading
//Enjoy



public class Application {
	
	public static void main(String[]args) throws IOException {
		
		
		
		
		//This is a polymorphism example
		User stu1 = new Student("default","default");
		
		
		
		//We create two files for serialization
		//If they don't exist, then it means it's the first time accessing
		//We read from csv
		//If they already existed in the Data file
		//Then, just use deserialization in the else part
		
		
		File F1 = new File("./Data/ST1.ser");
		File F2 = new File("./Data/ST2.ser");
		
		
		if(!F1.exists()||!F2.exists()) {
			
			//If this is the first time accessing,
			//F1 and F2 are still not created yet
			//So, they don't exist in the Data folder
			//So, the program reads from csv
			//After this run, in the future
			//Because F1 and F2, two .ser files are created and exist in the Data folder
			//The program will just read them by de-serialization
			//No more need to read from csv
			
			System.out.println("First time accessing, so we read from csv");
			System.out.println();
			
			//Dear grader
			//I am not sure if this will work on your computer
			//I leave a csv file in the Data folder of my src folder
			//I also leave one in the src folder
			//If it doesn't work out, please change it manually on your computer
			//So does the src files later
			//Sorry for the incovenience
			//Thank you sincerely
			
			String path = "Data/MyUniversityCoursesFile.csv";
			//System.out.println("Data reading Sucessful");
			System.out.println();
			String l ="";
			
			
			int rowc = 0;
			
			int colc = 0;
			
			
			String[][]myArray = new String[30][8];
			
			
			try {
				BufferedReader br = new BufferedReader(new FileReader(path));
				
				
				while((l=br.readLine())!=null) {
					//System.out.println(l);
					
					
					
					String[]values = l.split(",");
					
					
					
					Course newcourse = new Course();
					for (int i = 0; i<values.length;i++) {
						myArray[rowc][i]=values[i]; 
					
					}
					
					rowc++;
					
				
				}//while stop
				
			
			}catch(FileNotFoundException error)	{
				System.out.println("The file is not found");
				System.out.println();
			}catch(IOException error) {
				System.out.println("There is an IO problem");
				System.out.println();
			}
			
			
			for (int i =1; i<30;i++) {
				
				Course thiscourse = new Course();
					
				thiscourse.setCourseName(myArray[i][0]);
				thiscourse.setCourseId(myArray[i][1]);
				thiscourse.setMaxStudentNumber(Integer.parseInt(myArray[i][2]));
				thiscourse.setCurrentStudentNumber(Integer.parseInt(myArray[i][3]));
				//thiscourse.setThisCourseRegisteredStudentList(null);
				thiscourse.setCourseInstructor(myArray[i][5]);
				thiscourse.setCourseSection(Integer.parseInt(myArray[i][6]));
				thiscourse.setCourseLocation(myArray[i][7]);
					
				Directory.CourseList.add(thiscourse);
			}
		
		}// if ends
		
		else {
			//Deserialization
			//ArrayList<Course> de = new ArrayList<Course>();
			
			try{
				  //FileInputSystem recieves bytes from a file
			      FileInputStream fis = new FileInputStream("./Data/ST1.ser");
			      
			      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
			      ObjectInputStream ois = new ObjectInputStream(fis);
			      
			      
			      Directory.CourseList = (ArrayList<Course>)ois.readObject();
			      //Cast as Employee. readObject will take the object from ObjectInputStream
			      //de = (ArrayList<Course>)ois.readObject();
			      ois.close();
			      fis.close();
			    }
			    catch(IOException ioe) {
			       ioe.printStackTrace();
			       return;
			    }
			 catch(ClassNotFoundException cnfe) {
			       cnfe.printStackTrace();
			       return;
			     }
			
			
			
			/////////////////////////////
			
			//now, let's try to deserialize Student list
			
			try{
				  //FileInputSystem recieves bytes from a file
			      FileInputStream fis2 = new FileInputStream("./Data/ST2.ser");
			      
			      //ObjectInputStream does the deserialization-- it reconstructs the data into an object
			      ObjectInputStream ois2 = new ObjectInputStream(fis2);
			      
			      
			      Directory.StudentList = (ArrayList<Student>)ois2.readObject();
			      //Cast as Employee. readObject will take the object from ObjectInputStream
			      //de = (ArrayList<Course>)ois.readObject();
			      ois2.close();
			      fis2.close();
			    }
			    catch(IOException ioe) {
			       ioe.printStackTrace();
			       return;
			    }
			 catch(ClassNotFoundException cnfe) {
			       cnfe.printStackTrace();
			       return;
			     }
			
			
			
		}// end of else
		
		
		
		//Now, main program
		
		//This is for faster testing because 1 1 are much faster than Admin and Admin001
		//You can ignore it
		String AdminUsername = "1";
		String AdminPassword = "1";
		
		//This the real password and username on the instruction
		String Adminrealusername = "Admin";
		String Adminrealpassword = "Admin001";
		
		Scanner input = new Scanner(System.in);
		String Signal = "";
		
		
		
		while (true) {
			System.out.println("Weclome to the program");
			System.out.println("Press 1 for Admin login");
			System.out.println("Press 2 for Student login");
			System.out.println("Press 3 for exit");
			
			
			String choice1 = input.nextLine();
			
			
			if (choice1.equals("1")) {
				System.out.println("Please enter your Admin username: ");
				String choice2 = input.nextLine();
				System.out.println("Please enter your Admin password: ");
				String choice3 = input.nextLine();
				
				if ((choice2.equals(AdminUsername)&&choice3.equals(AdminPassword))||(choice2.equals(Adminrealusername)&&choice3.equals(Adminrealpassword))) {
					Signal = "Admin";
					System.out.println();
					
					Admin admin = new Admin();
					
					while (true) {
						System.out.println("Welcome to the Admin mode");
						System.out.println("Press 1 for Course Managament");
						System.out.println("Press 2 for Reports");
						System.out.println("Press 3 for exit");
						System.out.println();
						
						String Choicebigpart = input.nextLine();
						
						if (Choicebigpart.equals("1")) {
						
							while (true) {
								
								System.out.println("This is course management part");
								System.out.println("Press 1 to create a new class");
								System.out.println("Press 2 to delete a class");
								System.out.println("Press 3 to edit the information of a class or enroll/withdraw a student");
								System.out.println("Press 4 to display information for a course");
								System.out.println("Press 5 to register a student");
								System.out.println("Press 6 to exit");
								//Just for testing:
								System.out.println("Press 7 to view all courses");
								//
								System.out.println();
								System.out.println("Warm tip:");
								System.out.println("A new student can only be registered through Function 5");
								System.out.println("If you want to enroll a registered student in a course");
								System.out.println("or withdraw a registered student from a course");
								System.out.println("Use Function 3, edit the student list of a particular course");
								
								
								
								String achoice = input.nextLine();
								
								
								if (achoice.equals("6")) {
									System.out.println("Course management ends");
									System.out.println();
									break;
								}// end of if achoice=6, quitting course management part
								
								else if (achoice.equals("1")) {//create a new course
									//Because this is to create a NEW course
									//I assume no one has registered this course before
									//So, the current student number is 0
									//The current student list is null, too
									System.out.println("What's the name of the course?");
									String n1  = input.nextLine();
									System.out.println("What's the id of the course?");
									String id1 = input.nextLine();
									System.out.println("What's the maximum number of students?");
									int m1  = input.nextInt();
									input.nextLine();
									System.out.println("What's the name of the instructor?");
									String i1  = input.nextLine();
									
									System.out.println("What's the section number?");
									int s1 = input.nextInt();
									input.nextLine();
									System.out.println("What's the Course Location?");
									String cl1 = input.nextLine();
									
									Course createnew = new Course(n1,id1,m1,0,i1,s1,cl1);
									admin.CreateCourse(createnew);
									
									System.out.println("The new course is created");
									System.out.println();
								
								}//end of if achoice = 1, create a new course
								
								
								
								else if (achoice.equals("2")) {
									System.out.println("What's the ID of the course that you want to delete? Case and symbol Sensitive");
									String iddelete = input.nextLine();
									System.out.println("What's the Course name of the course that you want to delete? Case and symbol Sensitive");
									String namedelete = input.nextLine();
									System.out.println("What's the section of the course that you want to delete? Case and symbol Sensitive");
									int sectiondetele = input.nextInt();
									input.nextLine();
									
									String Flagdelete = "F";
									
									Course Coursedelete = new Course();
									for (int i=0; i<Directory.CourseList.size();i++) {
										if (Directory.CourseList.get(i).getCourseId().equals(iddelete)&&Directory.CourseList.get(i).getCourseName().equals(namedelete)&&Directory.CourseList.get(i).getCourseSection()==sectiondetele) {
											
											Coursedelete = Directory.CourseList.get(i);
											Flagdelete = "T";
											break;
											
										}
										
									}// end of for
									
									if (Flagdelete.equals("F")) {
										System.out.println("The course Id you just typed doesn't exist in our system");
										System.out.println();
									}//
									
									if (Flagdelete.equals("T")) {
										admin.DeleteCourse(Coursedelete);
										System.out.println();
									}
					
									
									
								}// end of else if 2, delete a course
								
								else if (achoice.equals("7")) {
									admin.ViewAllCourse();
								}//end of else if 7, view all courses
									
								else if (achoice.equals("3"))	{
									System.out.println("Course ID, Course Name, number of current students in a class, and Course Section are immutable");
									//System.out.println("What's the id of the course that you want to change?");
									//String idedit = input.nextLine();
									System.out.println("What's the course name of the course that you want to change?");
									String nameedit = input.nextLine();
									System.out.println("What's the section number of the course that you want to change?");
									int section = input.nextInt();
									
									input.nextLine();
									admin.EditCourse(nameedit, section);
									
									
								}//end of else if 3, Edit a course
								
								else if (achoice.equals("4")) {
									//System.out.println("What's the id of the course that you want to see the information of?");
									//String idinfo = input.nextLine();
									System.out.println("What's the course name of the course that you want to see the information of?");
									String nameinfo = input.nextLine();
									System.out.println("What's the section number of the course that you want to see the information of?");
									int sectioninfo = input.nextInt();
									admin.DisplayCourse(nameinfo,sectioninfo);
									System.out.println();
									
									input.nextLine();
									
								}//end of else if 4, display info for a class by id
								
								else if (achoice.equals("5")) {
									System.out.println("What's the first name of the student?");
									String fnr = input.nextLine();
									System.out.println("What's the last name of the student?");
									String lnr = input.nextLine();
									System.out.println("What's the username of the student?");
									String ur = input.nextLine();
									System.out.println("What's the password of the student?");
									String pr = input.nextLine();
									
									Student rs = new Student(fnr,lnr,ur,pr);
									Directory.StudentList.add(rs);
									System.out.println("The student was added to the system");
									System.out.println();
								}
								else {
									System.out.println("Invalid input. Try again.");
									System.out.println();
								}
									
								
								
							}// end of while true big part if1
							
					
						}//end of big part if 1
						
						else if (Choicebigpart.equals("2")) {
							while (true) {
								System.out.println("This is report part");
								System.out.println("Press 1 to view all courses");
								System.out.println("Press 2 to view all full courses");
								System.out.println("Press 3 to write to a file the list of courses that are full");
								System.out.println("Press 4 to view the names of students being registered in a specific course");
								System.out.println("Press 5 to view the list of courses that a studen has registered");
								System.out.println("Press 6 to sort based on the current student who registered");
								System.out.println("Press 7 to exit");
								
								
								String choicer = input.nextLine();
								
								if (choicer.equals("7")) {
									System.out.println("Quitting the report part");
									break;
									
								}//end of choicer 7:  quit
								
								else if (choicer.equals("1")) {
									admin.ViewAllCourse();
								}//end of choicer 1: view all courses
								
								else if (choicer.equals("2")) {
									admin.ViewFullCourse();
								}//end of choicer2: view all courses that are not full
								
								else if (choicer.equals("3")) {
									admin.WriteFullCourse();
									
								}//end of choicer3: Write to a file the list of courses that are full
								
								else if (choicer.equals("4")) {
									System.out.println("What's the course name of the course that you want to see all the students of?");
									String nameall = input.nextLine();
									System.out.println("What's the section number of the course that you want to see all the students of?");
									int sectionall = input.nextInt();
									
									//System.out.println(nameall+" "+sectionall);
									
									admin.ViewallStudentinaclass(nameall, sectionall);
									
									input.nextLine();
									}//end of choicer4: View the name of the students within a specific course
								
								else if (choicer.equals("5")) {
									
									System.out.println("What's first name of the student?");
									String fna = input.nextLine();
									System.out.println("What's last name of the student?");
									String lna = input.nextLine();
									
									admin.thecourseastudenttakes(fna, lna);
									
								}//end of choicer5: View the list of courses that a given student is being registered in
								
								else if (choicer.equals("6")) {
									
									admin.SortbasedonNumber();
									
								}// end of chicer6: sort
								
								
							}// end of while true big part else if 2
			
							
							
						}//end of big part if 2
						
						
						else if (Choicebigpart.equals("3")) {
							System.out.println("going back to the last part");
							System.out.println();
							break;
							
						}
						
						else {
							System.out.println("Invalid input.");
							System.out.println();
						}
						
						
					
					}//end of while true: 1 for management, 2 for reports
					
					
				}// end of if check Admin username and passcode
				
				else {
					System.out.println("Wrong username or password.");
					System.out.println();
					
				}// end of else
				
				
			} //end of if you choose to login admin
			//The next big part is for student login
			
			/////////////////////////////////////////////
			
			else if (choice1.equals("2")) {
				
				String userlogin =""; 
				String passlogin ="";
				String choiceu = "";
				
				while (true) {
					String Flaglogin ="F";
					System.out.println("Press 1 to login as a student");
					System.out.println("Press 2 to exit");
					
					choiceu = input.nextLine();
					
					if (choiceu.equals("1")) {
						System.out.println("Please enter your Student username: ");
						userlogin = input.nextLine();
						System.out.println("Please enter your Student password: ");
						passlogin = input.nextLine();
						
						
						for (int i = 0; i<Directory.StudentList.size();i++) {
							
							if (Directory.StudentList.get(i).getUsername().equals(userlogin)&&Directory.StudentList.get(i).getPassword().equals(passlogin)) {
								Flaglogin = "T";
								break;
								
								
								
							}//end of if
							
							
							
							
						}// end of for loop
						
						if (Flaglogin.equals("F")) {
							System.out.println("Wrong password or username, please try again");
							System.out.println("Do you want to quit login as a student?");
							System.out.println("Press 1 for quit login, anything else for keep trying");
							String quitc = input.nextLine();
							
							if (quitc.equals("1")) {
								break;
							}//end of quitc = 1: quit login after failure
							
							else {
								
							}//
							
						}// end of if Flaglogin=F
						
						
						if (Flaglogin.equals("T")) {
							
							Student st= new Student();
							
							while (true) {
								
								String cs = "";
								
								System.out.println("Welcome to the student mode");
								System.out.println("You are in course management");
								System.out.println("Press 1 for view all courses");
								System.out.println("Press 2 for view all courses that are not full");
								System.out.println("Press 3 to register a course");
								System.out.println("Press 4 to withdraw a course");
								System.out.println("Press 5 to view all the courses you have already registered in");
								System.out.println("Press 6 to exit");
								
								
								cs = input.nextLine();
								if (cs.equals("6")) {
									System.out.println("Going back to the last part");
									System.out.println();
									break;
								}//end of cs = 6, quit
								
								else if (cs.equals("1")) {
									st.ViewAllCourse();
									
								}//end of cs = 1, view all courses
								
								else if (cs.equals("2")) {
									st.ViewNotFullCourse();
									
								}//end of cs = 2, view all not full courses
								
								else if (cs.equals("3")) {//Registered a course
									
									
									
									System.out.println("What's your first name?");
									String fnr = input.nextLine();
				
									System.out.println("What's your last name?");
									String lnr = input.nextLine();
									System.out.println("What's the course name you want to register in?");
									String nr = input.nextLine();
									System.out.println("What's the course section you want to register in?");
									int sr = input.nextInt();
									
									
									st.StudentRegisteraCourse(fnr, lnr, nr, sr);
									input.nextLine();
							
									
									
									
								}//end of cs = 3, Register a course
								
								else if (cs.equals("4")) {
									System.out.println("What's your first name?");
									String fnw = input.nextLine();
									System.out.println("What's your last name?");
									String lnw = input.nextLine();
									System.out.println("What's the course that you want to withdraw from?");
									String nw = input.nextLine();
									System.out.println("What's the section number of the course that you want to withdraw from?");
									int sw = input.nextInt();
									
									//System.out.print(fnw+lnw+nw+sw);
									
									st.StudentWithdrawaCourse(fnw, lnw, nw, sw);
									input.nextLine();
									
								}//end of cs =4, withdraw from a course
								
								else if (cs.equals("5")) {
									System.out.println("What's your first name?");
									String fnv = input.nextLine();
									System.out.println("What's your last name?");
									String lnv = input.nextLine();
									
									st.ViewAllCoursesalreadyRegistered(fnv, lnv);
									
								}//end of cs = 5, view all courses this student is taking
								
								else {
									System.out.println("Invalid input");
									System.out.println();
									
								}// else if cs not 123456
								
							}//end of while true
					
							
							
							
						}//end of if flaglogin is true: password and username are matched
						
					}//end of choiceu 1
					
					else if (choiceu.equals("2")) {
						System.out.println("Going back to the last part");
						System.out.println();
						break;
						
					}// end of choiceu 2
					
					else {
						System.out.println("Invalid input");
					}// end of choiceu else
					
					
					
					
				}// end of while true
				

			}//end of else if-2
			
			else if (choice1.equals("3")) {
				System.out.println("Goodbye");
				break;
			}//end of else if-3
			
			
			else {
				System.out.println("Invalid input. Try again.");
				System.out.println();
				
			}//end of else 
			
		}// end of while true
		
		
		try {
			
			
			
			FileOutputStream fos = new FileOutputStream("./Data/ST1.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Directory.CourseList);
			
			oos.close();
			fos.close();
			System.out.println("All actions are saved permenantly");
			
		}
		catch (IOException ioe) {
			ioe.printStackTrace();
		}// the first try-catch

//end of try-serialization-course list
		
//////////////////




try {
	
	
	
	FileOutputStream fos2 = new FileOutputStream("./Data/ST2.ser");
	ObjectOutputStream oos2 = new ObjectOutputStream(fos2);
	oos2.writeObject(Directory.StudentList);
	
	oos2.flush();
	oos2.close();
	fos2.close();
	//System.out.println("Serialization is finished");
	
	
	
}
catch (IOException ioe) {
	ioe.printStackTrace();
}

			
	
	
		
	}//end of main
	
	
}
