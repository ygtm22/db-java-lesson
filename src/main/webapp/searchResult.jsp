<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>SerchResult</title>
</head>
<body>
	<h1>検索結果</h1>
	
	<table border = 1>
	<tr>
      <th>product_id</th>
      <th>product_name</th>
      <th>price</th>
    </tr>
    <c:forEach var="product" items="${list}">
      <tr>
        <td>${fn:escapeXml(product.productId)}</td>
        <td>${fn:escapeXml(product.productName)}</td>
        <td>${fn:escapeXml(product.price)}</td>
      </tr>
    </c:forEach>
      <tr>
	</table>
  
  <a href="top.jsp">戻る</a>
  
</body>
</html>
