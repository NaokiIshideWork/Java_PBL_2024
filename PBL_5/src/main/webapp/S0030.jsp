<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String tmpName = (String) request.getAttribute("name");
String tmpMail = (String) request.getAttribute("mail");
String tmpPassword = (String) request.getAttribute("password");
String authorityStr = (String) request.getAttribute("authority");

String name = null;
String mail = null;
String password = null;
int authority = 0;

if (authorityStr != null && tmpName != null && tmpMail != null && tmpPassword != null) {
	authority = Integer.parseInt(authorityStr);
    name = tmpName;
    mail = tmpMail;
    password = tmpPassword;
}


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
<title>アカウント登録|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="registerAccount" />
</jsp:include>

<style>
body {
	overflow-x: hidden;
}

.sp-left {
	margin-left: 100px;
}

.sp-center {
		text-align: center;
	}

@media screen and (min-width:500px) {
	.sp-left {
		margin-left: 0;
	}
}

@media screen and (min-width:767px) {

	.sp-left {
		margin-left: 50px;
	}
	
	.sp-center {
		text-align: center;
	}
	
}
@media screen and (min-width:991px) {

	.sp-left {
		margin-left: 100px;
	}
	
}

@media screen and (min-width:1024px) {
	.sp-left {
		margin-left: 150px;
	}
}
</style>
	
	<c:if test="${not empty err}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">${err}</div>
	</c:if>
	
<c:choose>	
	<c:when test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
	<div class="container">
		<h2 class="mt-5 sp-left">アカウント登録</h2>
		<div style="margin-left: 100px">
			<form class="text-right" action="AccountServlet" method="post">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail"  class="col-form-label text-sm-end">氏名 <span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="name" class="form-control" value="${not empty name ? name : ''}" placeholder="氏名">
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-sm-3">	
						<h3 for="inputEmail" class="col-form-label text-sm-end">
							メールアドレス <span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="mail" class="form-control"value="${not empty mail ? mail : ''}"  placeholder="メールアドレス">
					</div>
				</div>
				
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" value="${not empty password ? password : ''}" class="col-form-label text-sm-end">
							パスワード <span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="password" name="password" class="form-control" value="${not empty password ? password : ''}" placeholder="パスワード">
					</div>
				</div>
				
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">
							パスワード確認 <span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="password" name="confirmPassword"
							class="form-control " value="${not empty password ? password : ''}" placeholder="パスワード（確認）">
					</div>
				</div>
				
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">
							権限 <span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>

					<div class="col-sm-8" style="margin-top: 10px;">
						     <input type="checkbox" name="authority" value="1"
									id="authoritySale" <%=salesSelected ? "checked" : ""%> >
								<label for="authoritySale"> 売上登録 </label> <input type="checkbox"
									name="authority" value="10" id="authorityAccount"
									<%=accountSelected ? "checked" : ""%> > <label
									for="authorityAccount"> アカウント登録 </label> <input type="hidden"
									name="authority" value="0" id="authorityNone"
									<%=noneSelected ? "checked" : ""%> > <label
									for="authorityNone"> </label>
							</div>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-sm-5"></div>
					<div class="col-sm-2 text-center">
						<button type="submit" class="btn btn-primary" style="text-align: center; white-space:nowrap; ">
						✓登録
						</button>
					</div>
					<div class="col-sm-5"></div>
				</div>
				
			</form>

		</div>
	</div>
	</c:when>
	<c:otherwise>
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">アカウント登録権限がありません</div>
	</c:otherwise>
</c:choose>
<jsp:include page="footer.jsp"/>