package com.test.productcatolog;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;
public class ProductRepository {
	Connection con;
	public ProductRepository() {
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
	public List<Product> getProduct(){
		List<Product> productList=new ArrayList<>();
		String sql="SELECT * FROM product";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				Product p =new Product();
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setCategory(rs.getInt(5));
				productList.add(p);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return productList;
	}
	public Product getProduct(int id) {
		String sql="SELECT * FROM product where id="+id;
		Product p =new Product();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			while(rs.next()){
				p.setId(rs.getInt(1));
				p.setName(rs.getString(2));
				p.setDescription(rs.getString(3));
				p.setPrice(rs.getDouble(4));
				p.setCategory(rs.getInt(5));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return p;
	}
	public void createProduct(Product p) {
		// TODO Auto-generated method stub
		String sql="insert into product values (?,?,?,?,?)";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1,p.getId());
			st.setString(2,p.getName());
			st.setString(3,p.getDescription());
			st.setDouble(4,p.getPrice());
			st.setInt(5, p.getCategory());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public void updateProduct(Product p) {
		// TODO Auto-generated method stub
		String sql="update product set name=? where id=?";
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setString(1,p.getName());
			st.setInt(2, p.getId());
			st.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		String sql="delete from product where id=?";
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
