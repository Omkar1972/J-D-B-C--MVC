package controller;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Student;

public interface StudentDao {

	    public Connection getConnect() throws SQLException, ClassNotFoundException;
	    
	    public int save(Student s) throws SQLException, ClassNotFoundException;
	    public int update(Student s) throws ClassNotFoundException, SQLException;
	    public int delete(Student s);
	    public ArrayList<Student> getData(Student s);

		
	
	
}
