<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%
    if(request!=null){
        String action = request.getParameter("action");
        if("logout".equals(action)){
            out.println("jjj");
            session.removeAttribute("userName");
            response.sendRedirect(request.getContextPath()+"/jsp/login.jsp");
        }
    }
%>
<html>
<head>
<title></title>
<script type="text/javascript">
<!-- 每5秒刷新一次 -->
setTimeout("location=location; ", 5000);
</script>

</head>
<body>
用户名： <%= session.getAttribute("userName") %>
您已成功登陆
<br>
<a href="${pageContext.request.requestURI}?action=logout">退出</a>
</body>
</html>