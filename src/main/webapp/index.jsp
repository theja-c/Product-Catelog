<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="product">
		Click submit to see all products list
		<input type="submit">
	</form>
	<form action="category">
		Click submit to see all category list
		<input type="submit">
	</form>
	<form action="InsertProductServlet" >
        <label for="pId">Product ID:</label>
        <input type="text" id="pId" name="pId" required><br><br>
        
        <label for="pName">Product Name:</label>
        <input type="text" id="pName" name="pName" required><br><br>
        
        <label for="pDescription">Product Description:</label>
        <textarea id="pDescription" name="pDescription" required></textarea><br><br>
        
        <label for="pPrice">Product Price:</label>
        <input type="number" id="pPrice" name="pPrice" required><br><br>
        
        <label for="pCategory">Product Category:</label>
        <input type="number" id="pCategory" name="pCategory" required><br><br>
        <input type="submit" value="Insert Product">
    </form>
    <br>
    <form action="UpdateProductServlet" >
        <label for="pId">Product ID:</label>
        <input type="text" id="pId" name="pId" required><br><br>
        
        <label for="pName">Product Name:</label>
        <input type="text" id="pName" name="pName" required><br><br>
        
        <label for="pDescription">Product Description:</label>
        <textarea id="pDescription" name="pDescription" required></textarea><br><br>
        
        <label for="pPrice">Product Price:</label>
        <input type="number" id="pPrice" name="pPrice" required><br><br>
        
        <label for="pCategory">Product Category:</label>
        <input type="number" id="pCategory" name="pCategory" required><br><br>
        <input type="submit" value="Update Product">
    </form>
</body>
</html>