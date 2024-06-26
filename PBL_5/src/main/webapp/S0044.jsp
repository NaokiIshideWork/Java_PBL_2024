<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

String authorityStr = (String) request.getAttribute("authority");
int authority = Integer.parseInt(authorityStr);

boolean salesSelected = false;
boolean accountSelected = false;
boolean noneSelected = false;

if (authority == 0) {
	noneSelected = true;
}
if (authority == 1) {
	salesSelected = true;
}
if (authority == 10) {
	accountSelected = true;
}
if (authority == 11) {
	salesSelected = true;
	accountSelected = true;
}
%>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="searchAccounts" />
</jsp:include>


<c:choose>
	<c:when
		test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
		<div class="container position-absolute">
			<h2 class="mt-5" style="margin-left: 100px;">アカウント詳細削除確認</h2>
			<div class="" style="margin-left: 100px">
				<form class="text-right" action="AccountSearchServlet" method="POST">
					<div class="row ">
						<div class="col-sm-3">
							<h3 for="inputEmail" class="col-form-label text-sm-end">氏名</h3>
						</div>
						<div class="col-sm-8 w-50">
							<input type="text" name="#" class="form-control" value="${name}"
								disabled>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-sm-3">
							<h3 for="inputEmail" class="col-form-label text-sm-end">メールアドレス</h3>
						</div>
						<div class="col-sm-8 w-50">
							<input type="email" name="#" class="form-control" value="${mail}"
								disabled>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-sm-3">
							<h3 for="inputEmail" class="col-form-label text-sm-end">パスワード</h3>
						</div>
						<div class="col-sm-8 w-50">
							<input type="password" name="#" class="form-control "
								value="${password}" disabled>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-sm-3">
							<h3 for="inputEmail" class="col-form-label text-sm-end"">パスワード（確認）</h3>
						</div>
						<div class="col-sm-8 w-50">
							<input type="password" name="#" class="form-control "
								value="${password}" disabled>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-sm-3">
							<h3 for="inputEmail" class="col-form-label text-sm-end">権限</h3>
						</div>
						<div class="col-sm-8" style="margin-top: 10px;">
							<input type="checkbox" name="authority" value="1"
								id="authoritySale" <%=salesSelected ? "checked" : ""%> disabled>
							<label for="authoritySale"> 売上登録 </label> <input type="checkbox"
								name="authority" value="10" id="authorityAccount"
								<%=accountSelected ? "checked" : ""%> disabled> <label
								for="authorityAccount"> アカウント登録 </label> <input type="hidden"
								name="authority" value="0" id="authorityNone"
								<%=noneSelected ? "checked" : ""%> disabled> <label
								for="authorityNone"> </label>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-sm-4"></div>
						<div class="col-sm-8">
							<%
							String id = (String) request.getAttribute("id");
							String name = (String) request.getAttribute("name");
							String mail = (String) request.getAttribute("mail");
							String confirm_authority = (String) request.getAttribute("authority");
							String password = (String) request.getAttribute("password");
							%>
							<input type="hidden" name="tmpId" value="<%=id%>" /> <input
								type="hidden" name="tmpName" value="<%=name%>" /> <input
								type="hidden" name="tmpMail" value="<%=mail%>" /> <input
								type="hidden" name="tmpAuthority" value="<%=confirm_authority%>" />
							<input type="hidden" name="tmpPassword" value="<%=password%>" />
							<input type="hidden" name="deleteOK" value="true">
							<button type="submit" class="btn btn-danger me-2">✕OK</button>
				</form>
				<form class="d-inline" action="AccountSearchServlet" method="post">
					<input type="hidden" name="cancel" value="true">
					<button type="submit" class="btn btn-outline-secondary">キャンセル</button>
				</form>
			</div>
		</div>
		</form>
		</div>
		</div>
	</c:when>
	<c:otherwise>
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">アカウント編集権限がありません</div>
	</c:otherwise>
</c:choose>
<jsp:include page="footer.jsp"/>