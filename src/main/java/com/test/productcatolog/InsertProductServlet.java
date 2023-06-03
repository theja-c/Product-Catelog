package com.test.productcatolog;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InsertProductServlet extends HttpServlet{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("pId"));
        String productName = request.getParameter("pName");
        String productDescription = request.getParameter("pDescription");
        double productPrice = Double.parseDouble(request.getParameter("pPrice"));
        int productCategory = Integer.parseInt(request.getParameter("pCategory"));
        ProductRepository p = new ProductRepository(); 
        Product product = new Product(productId, productName, productDescription, productPrice,productCategory);
        p.createProduct(product);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/product");
        dispatcher.forward(request, response);
    }
}
