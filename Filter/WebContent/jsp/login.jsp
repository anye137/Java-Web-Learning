<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title></title>
</head>
<body>

    <form action="${pageContext.request.contextPath}/loginServlet" method="post">
        姓名：<input type="text"  name="name"/><br>
        <input type="submit" value="登录"/><br>
    </form>
</body>
</html>