package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public class StudentDaoImp implements StudentDao {
	
	
	  public Connection getConnect() throws SQLException, ClassNotFoundException
	  {
		  Class.forName("com.mysql.cj.jdbc.Driver");
		  
		  Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/student","root","omkar123");
		  
		return con;
		  
	  }

	@Override
	public int save(Student s) throws SQLException, ClassNotFoundException {
		
		Connection con=getConnect();
		
		String sql="insert into student_tbl (s_id,s_name) values(1,'OMKAR')";
		PreparedStatement ps=con.prepareStatement(sql);
		
		ps.setInt(1, s.getS_id());
		ps.setString(2, s.getS_name());
		
		int a=ps.executeUpdate();
		
		con.close();
		
		
		return a;
	}

	@Override
	public int update(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public int delete(Student s) {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public ArrayList<Student> getData(Student s) {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
