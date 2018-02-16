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

<c:if test="${ not empty error}">

<script type="text/javascript" language="javascript">
        alert("${ error }");        
</script>   
<%session.removeAttribute("error"); %>
</c:if>



<form action="loginServlet" method='post'>
<table align='center' >
    <tr>
        <td>用户名</td>
        <td><input type='text' name='name'></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type='text' name='pwd'></td>
    </tr>
    <tr>
        <td><input type='submit' value='登录'></td>
    </tr>
</table>
</form>
<br><br>
<form action="registerServlet" method='post'>
<table align='center' >
    <tr>
        <td>用户名</td>
        <td><input type='text' name='name'></td>
    </tr>
    <tr>
        <td>密码</td>
        <td><input type='text' name='pwd'></td>
    </tr>
    <tr>
        <td><input type='submit' value='注册' ></td>
    </tr>
</table>
</form>
</body>
</html>