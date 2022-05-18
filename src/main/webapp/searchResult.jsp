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
  <p>データを取得しました。  </p>
  <div>
  <label>product_id:</label>${fn:escapeXml(product.productId)}<br>
  <label>product_name:</label>${fn:escapeXml(product.productName)}<br>
  <label>price:</label>${fn:escapeXml(product.price)}<br>
  </div>
  
  <a href="top.jsp">戻る</a>
</body>
</html>
