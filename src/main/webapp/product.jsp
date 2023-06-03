<%@page import="com.test.productcatolog.Product"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Catalog</title>
</head>
<body>
    <h1>Product Catalog</h1>
    <ul>
        <%-- Loop over the products and display their information --%>
        <%
            List<Product> productList = (List<Product>) request.getAttribute("products");
            if (productList != null && !productList.isEmpty()) {
                for (Product product : productList) {
        %>
                    <li>
                        <strong>ID:</strong> <%= product.getId() %><br>
                        <strong>Name:</strong> <%= product.getName() %><br>
                        <strong>Description:</strong> <%= product.getDescription() %><br>
                        <strong>Price:</strong> <%= product.getPrice() %><br>
                        <strong>Category:</strong> <%= product.getCategory() %><br>
                    </li>
        <%
                }
            } else {
        %>
                <li>No products found</li>
        <%
            }
        %>
    </ul>
</body>
</html>
