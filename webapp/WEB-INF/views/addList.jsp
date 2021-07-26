<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<h1>방명록 리스트</h1>

	<form action="${pageContext.request.contextPath}/add" method="get">
		<table border="1" width="600">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" value=""></td>
				<td>비밀번호</td>
				<td><input type="password" name="password" value=""></td>
			</tr>
			<tr>
				<td colspan="4"><textarea rows="8" cols="82" name="content"></textarea>
			</tr>
			<tr>
				<td colspan="4">
					<button type="submit">확인</button>
				</td>
			</tr>
		</table>
	</form>

	<c:forEach items="${requestScope.gList}" var="vo">
		<table border="1" width="607">
			<tr>
				<td>${vo.no}</td>
				<td>${vo.name}</td>
				<td>${vo.regDate}</td>
				<td><a href="${pageContext.request.contextPath}/dform?no=${vo.no}">삭제</a></td>
			</tr>
			<tr>
				<td colspan="4">${vo.content}</td>
			</tr>

		</table>
	</c:forEach>


</body>
</html>