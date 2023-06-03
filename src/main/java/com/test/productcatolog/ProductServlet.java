package com.test.productcatolog;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProductServlet extends HttpServlet {
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
        List<Product> productList = getProduct();

        // Set the product list as a request attribute
        request.setAttribute("products", productList);

        // Forward the request to the JSP for rendering
        request.getRequestDispatcher("product.jsp").forward(request, response);
    }

    private List<Product> getProduct() {
        List<Product> productList = new ArrayList<>();
        String sql = "SELECT * FROM product";
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                Product p = new Product();
                p.setId(rs.getInt(1));
                p.setName(rs.getString(2));
                p.setDescription(rs.getString(3));
                p.setPrice(rs.getDouble(4));
                p.setCategory(rs.getInt(5));
                productList.add(p);
            }
        } catch (SQLException e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return productList;
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
