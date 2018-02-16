<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>

<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>

<body>

<div align='center'>
<c:if test="${not empty user}">
你好， ${user.name}
</c:if>
</div>

<table align='center' border='1' cellpadding='4'>
    <tr >
        <td>id</td>
        <td>name</td>
        <td>price</td>
        <td colspan='2'>操作</td>
    </tr>
    <c:forEach items="${plist}" var="product">
      <tr>
        <td>${product.id }</td>
        <td>${product.name }</td>
        <td>${product.price }</td>
        <td><a href='deleteProduct?id=${product.id }'>删除</a></td>
        <td><a href='editProduct?id=${product.id }'>编辑</a></td>
      </tr>
    </c:forEach>
</table>
<br><br>
<form action="addProduct" method='post'>
<table align='center'>
    <tr>
        <td>name</td>
        <td><input type='text' name='name' value='${product.name }'></td>
    </tr>
    
    <tr>
        <td>price</td>
        <td><input type='text' name='price' value='${product.price }'></td>
    </tr>
    
    <tr>
      <td><input type='submit' value='增加商品' ></td> 
    </tr>
    
</table>
</form>
</body>
</html>