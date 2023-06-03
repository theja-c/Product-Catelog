package com.test.productcatolog;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CategoryServlet extends HttpServlet{
	private Connection con;
	@Override
    public void init() throws ServletException {
        String url = "jdbc:postgresql://localhost:5432/test";
        String username = "postgres";
        String password = "theja2001";
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.out.println("Connection error");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found error");
            e.printStackTrace();
        }
    }
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Category> cList = getCategory();

        // Set the product list as a request attribute
        request.setAttribute("category", cList);

        // Forward the request to the JSP for rendering
        request.getRequestDispatcher("category.jsp").forward(request, response);
    }

    private List<Category> getCategory() {
        List<Category> cList = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Category c = new Category();
                c.setId(rs.getInt(1));
                c.setName(rs.getString(2));
                cList.add(c);
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return cList;
    }
    @Override
    public void destroy() {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
