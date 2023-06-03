<%@page import="com.test.productcatolog.Category"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Category Catalog</title>
</head>
<body>
    <h1>Category Catalog</h1>
    <ul>
        <%-- Loop over the products and display their information --%>
        <%
            List<Category> cList = (List<Category>) request.getAttribute("category");
            if (cList != null && !cList.isEmpty()) {
                for (Category c : cList) {
        %>
                    <li>
                        <strong>ID:</strong> <%= c.getId() %><br>
                        <strong>Name:</strong> <%= c.getName() %><br>
                    </li>
        <%
                }
            } else {
        %>
                <li>No category found</li>
        <%
            }
        %>
    </ul>
</body>
</html>