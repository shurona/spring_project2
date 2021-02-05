<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="com.springbook.biz.user.impl.UserDAO" %>    
<%@ page import="com.springbook.biz.user.UserVO" %>    
<%
	String id = request.getParameter("id");
	String password = request.getParameter("password");

	UserVO vo = new UserVO();
	vo.setId(id);
	vo.setPassword(password);
	
	UserDAO userDAO = new UserDAO();
	UserVO user = userDAO.getUser(vo);
	
	if(user != null){
		response.sendRedirect("getBoardList.jsp");
		System.out.println(user.getRole());
	} else{
		response.sendRedirect("login.jsp");
	}
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

</body>
</html>