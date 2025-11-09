package school.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import school.entity.Students;

public class StudentsService {

	private static String url="jdbc:postgresql://localhost:5432/management";
	private static String user="postgres";
	private static String password="123";
	private static Connection connection;
	
	
	static {
		try {
			Class.forName("org.postgresql.Driver");
			
			connection=DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int save(Students student) {
		int res=0;
		String sql="INSERT into students values(?,?,?)";
		try {
			PreparedStatement pstm = connection.prepareStatement(sql);
			pstm.setInt(1,student.getId());
			pstm.setString(2, student.getName());
			pstm.setInt(3, student.getAge()); 
			
			res= pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public List<Students> fetchAll(){
		List<Students> list=new ArrayList<Students>();
		String sql="SELECT * from students";
		try {
			Statement stm=connection.createStatement();
			
			ResultSet rs=stm.executeQuery(sql);
			while(rs.next()) {
				list.add(new Students(rs.getInt(1),rs.getString(2),rs.getInt(3)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
		
	}

	public int delete(int id) {
		int res=0;
		String sql="DELETE from students where id=?";
		
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setInt(1, id);
			
			res=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}

	public int edit(Students student) {
		int res=0;
		String sql="UPDATE students set name=?,age=? where id=?";
		
		try {
			PreparedStatement pstm=connection.prepareStatement(sql);
			pstm.setString(1, student.getName());
			pstm.setInt(2, student.getAge());
			pstm.setInt(3, student.getId());
			
			res=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
}
