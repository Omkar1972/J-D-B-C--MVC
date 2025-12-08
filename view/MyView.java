package view;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import controller.StudentDaoImp;
import model.Student;

public class MyView { // This View for user . .
	 
	// create a constructor only create an obj to call....
	public MyView() throws ClassNotFoundException, SQLException {
		
	//System.out.println("hello om");
		int s_id= 0;
		int choice=0;
		String s_name=" ";
		
		//s_id,s_name
		Scanner s=new Scanner(System.in);
		
		
		do{
			
			System.out.println("\n======== Student menu ==========");
			System.out.println("1.Add student");
			System.out.println("2.View Student");
			System.out.println("3.Update Student");
			System.out.println("4.Delete Student");
			System.out.println("0.Exite");
			System.out.println("Enter your choice:-");
			choice=s.nextInt();
			
			switch(choice)
			{
			
			case 1:
				System.out.println("== ADD STUDENT ==");
				
				System.out.println("Enter Student Id:- ");
				s_id=s.nextInt();
				s.nextLine();
				
				System.out.println("Enter Student Name:- ");
				s_name=s.nextLine();
				
				Student s1=new Student(s_id,s_name);
				
				StudentDaoImp db=new StudentDaoImp(); 
				
				int a= db.save(s1);
				
				if(a>0)
				{
					System.out.println("Student Data Inserted Successfully!!");
				}
				else
				{
					System.out.println("Data NOT Inserted");
				}
			
			break;
			
			case 2:
				System.out.println("\n==== View Students ====");
				
				
				
				StudentDaoImp db0=new StudentDaoImp();
				
			     ArrayList<Student> sl=new ArrayList<>();
			     
			     sl = db0.getData();
			     
			     for(Student x:sl)
			     System.out.println(x.getS_id()+" "+x.getS_name());
			    
				
				
				
			break;
			
		
			case 3:
				System.out.println("== UPDATE DATA ==");
				
				System.out.println("Enter NEW Student ID: ");
				s_id=s.nextInt();
				s.nextLine();
				
				System.out.println("Enter NEW Student Name: ");
				s_name=s.nextLine();
				
				Student s2=new Student(s_id,s_name);
				
				StudentDaoImp db1=new StudentDaoImp();
				
				int a1=db1.update(s2);
				
				if(a1>0)
				{
					System.out.println("Student record UPDATE Successfully!!");
				}
				else
				{
					System.out.println("REcord not Update");
				}
				
	
		    break;		
		        
			case 4:
				System.out.println("Enter NEW Student ID: ");
				s_id=s.nextInt();
				
				Student s3=new Student(s_id, s_name);
				
				StudentDaoImp db2=new StudentDaoImp();
				
				int a2=db2.delete(s3);
				
				if(a2>0)
				{
					System.out.println("Student record DELETE Successfully!!");
				}
				else
				System.out.println("Student Record not Deleted..");
				
				break;
				
			case 0:
				System.out.println("Exit..... T H A N K   Y O U !!");
				
				break;
		
			default:
				System.out.println("Invalid choice ! please try again..");
				
			}
			
			
		} while (choice !=0);
		
		
		s.close();
		
	}
	
	

}
