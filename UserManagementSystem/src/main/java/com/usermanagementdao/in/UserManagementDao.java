package com.usermanagementdao.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.managementmodel.in.UserManagementModel;

public class UserManagementDao {
	private static String url="jdbc:mysql://localhost:3306/MVCProgramAssignment";
	private static String user="root";
	private static String password="Sarath#*2468";
	private static Connection connection=null;
	private static Statement statement=null;
	private static PreparedStatement prepareStatement=null;
	private static ResultSet resultset=null;
	private static String insert="insert into User_Management_System(Name,Email_Id,City) values (?,?,?)";
	private static String display="select * from User_Management_System";
	private static String delete="delete from User_Management_System where id=?";
	private static String edit="select * from User_Management_System where id=?";
	private static String update="update User_Management_System set Name=?, Email_Id=?, City=? where id=?";
	
	public static void insert(UserManagementModel ums)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			prepareStatement=connection.prepareStatement(insert);
			prepareStatement.setString(1, ums.getName());
			prepareStatement.setString(2, ums.getEmail());
			prepareStatement.setString(3, ums.getCity());
			prepareStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public static ArrayList<UserManagementModel> display()
	{
		ArrayList<UserManagementModel> al=new ArrayList<UserManagementModel>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			statement=connection.createStatement();
			resultset = statement.executeQuery(display);
			while(resultset.next())
			{
				int id = resultset.getInt("id");
				String name = resultset.getString("Name");
				String email = resultset.getString("Email_Id");
				String city=resultset.getString("City");
				
				UserManagementModel ums = new UserManagementModel(id, name, email, city);
				
				al.add(ums);
			}
				
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				resultset.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return al;
	}
	//Delete User
	public static void delete(int id)
	{

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			prepareStatement = connection.prepareStatement(delete);
			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	//Edite User
	
	public static UserManagementModel edit(int id1)
	{
		UserManagementModel ums=null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			prepareStatement = connection.prepareStatement(edit);
			prepareStatement.setInt(1, id1);
			resultset = prepareStatement.executeQuery();
			resultset.next();
			int id = resultset.getInt("id");
			String name = resultset.getString("Name");
			String email = resultset.getString("Email_Id");
			String city = resultset.getString("City");
			 ums = new UserManagementModel(id, name, email, city);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				resultset.close();
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return ums;
	}
	
	//Updating User
	
	public static void update(UserManagementModel ums)
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(url, user, password);
			prepareStatement = connection.prepareStatement(update);
			prepareStatement.setString(1, ums.getName());
			prepareStatement.setString(2, ums.getEmail());
			prepareStatement.setString(3, ums.getCity());
			prepareStatement.setInt(4, ums.getId());
			prepareStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			try {
				prepareStatement.close();
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
