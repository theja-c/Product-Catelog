package com.test.productcatolog;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {
	Connection con;
	public CategoryRepository() {
		String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "theja2001";
		try {
			Class.forName("org.postgresql.Driver");
			con=DriverManager.getConnection(url,username,password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("con error");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("class con error");
			e.printStackTrace();
		}
	}
	public List<Category> getCategory(){
		List<Category> cList=new ArrayList<>();
		String sql="SELECT * FROM category";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Category c =new Category();
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
				cList.add(c);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return cList;
	}
	public Category getCategory(int id) {
		String sql="SELECT * FROM category where id="+id;
		Category c =new Category();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				c.setId(rs.getInt(1));
				c.setName(rs.getString(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return c;
	}
	public void createCategory(Category c) {
		// TODO Auto-generated method stub
		String sql="insert into category values (?,?)";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,c.getId());
			st.setString(2,c.getName());
			st.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public void updateCategory(Category c) {
		// TODO Auto-generated method stub
		String sql="update category set name=? where id=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,c.getName());
			st.setInt(2, c.getId());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public void deleteCategory(int id) {
		// TODO Auto-generated method stub
		String sql="delete from category where id=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
