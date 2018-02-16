<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>

<form action="saveProduct" method='post'>

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
        <td><input type='submit' value='保存' ></td>
        <td><input type='button' value='返回' onclick="location.href='listProduct'"></td>
    </tr>
    
    <tr> <td><input type='hidden' name='id' value='${product.id }'></td> </tr>
</table>


</form>
</body>
</html>