<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" flush="true" />

<body class="bg-secondary-subtle">
	
	<c:if test="${not empty error_display}">
	<div
		class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
		role="alert">${error_display}</div>
	
	</c:if>
	<div class="container text-center w-50" style="margin-top: 60px">
		<h2>物品売上管理システム</h2>
		<form action="LoginServlet" method="post">
			<input type="text" class="form-control w-50 mx-auto mb-1"
				placeholder="メールアドレス" name="mail"/> <input type="text"
				class="form-control w-50 mx-auto" placeholder="パスワード" name="password"/>
			<button id="btn" class="btn btn-primary btn-rounded mt-1  w-50 ">ログイン</button>
		</form>
	</div>
<jsp:include page="footer.jsp" flush="true" />