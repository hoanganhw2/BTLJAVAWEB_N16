<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form method="post" action="${pageContext.request.contextPath}/admin/product/update1" enctype="multipart/form-data">
	<label>Image</label>
			<input name="file" type="file">
			<input type="submit" value="Gửi">
	</form>
</body>
</html>