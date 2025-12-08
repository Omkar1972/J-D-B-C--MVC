package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import model.Student;

public class StudentDaoImp implements StudentDao {// implement in SDI to get override methods ...
	
	// C O N N E C T I ON  code of jdbc to mysql.....
	  public Connection getConnect() throws SQLException, ClassNotFoundException
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","omkar123");
		  
		return con;
		  
	  }

	  // Override from StudentDao Interface.....
	@Override
	public int save(Student s) throws SQLException, ClassNotFoundException {
		
		Connection con=getConnect();
		
		String sql="insert into student_tbl (s_id,s_name) values(?,?)";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, s.getS_id());
		ps.setString(2, s.getS_name());
		
		int a=ps.executeUpdate();
		
		con.close();
		
		
		return a;
	}

	@Override
	public int update(Student s) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		
		String sql="UPDATE student_tbl SET s_name=? WHERE s_id=?";
		
        PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(2, s.getS_id());
		ps.setString(1, s.getS_name());
		
		int a1=ps.executeUpdate();
		
		con.close();
		
		
		return a1;
	}


	@Override
	public int delete(Student s) throws ClassNotFoundException, SQLException {
		
		Connection con=getConnect();
		
		String sql="DELETE FROM student_tbl WHERE s_id = ?";
		
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, s.getS_id());
		
		int a2=ps.executeUpdate();
		
		con.close();
		
		return a2;
	}


	@Override
	public ArrayList<Student> getData() throws ClassNotFoundException, SQLException {
		
		ArrayList<Student> al=new ArrayList();
		
		Connection con=getConnect();
		
		 Statement st=con.createStatement();
		    
		   String sql="select * from student_tbl";
		    
		  ResultSet rs=st.executeQuery(sql);
		   
		  while(rs.next())
		    {
			    Student s=new Student(rs.getInt(1), rs.getString(2).toUpperCase());
		  
		    	al.add(s);
		    	
		    }
	      
		 
		con.close();
		
		return al;
	}

	
	

}
