
<%@ page language="java" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title></title> 
  </head>
  <body>
  <h1>post提交</h1>
    <form action="${pageContext.request.contextPath }/testEncoding" method="post">
    	姓名：<input type="text"  name="name"/><br>
    	<input type="submit" value="提交"/><br>
    </form>
    <h1>get提交</h1>
    <form action="${pageContext.request.contextPath }/testEncoding" method="get">
    	姓名：<input type="text"  name="name"/><br>
    	<input type="submit" value="提交"/><br>
    </form>
  </body>
</html>

