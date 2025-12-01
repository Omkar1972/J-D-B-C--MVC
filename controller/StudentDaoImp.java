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
		
		ps.setString(1, s.getS_name());
		ps.setInt(2, s.getS_id());
		
		int a1=ps.executeUpdate();
		
		con.close();
		
		
		return a1;
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
