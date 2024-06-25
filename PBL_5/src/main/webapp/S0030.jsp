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
    System.out.println("S0030最初name" + name);
} else {
    System.out.println("authorityがsetされていません");
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

<jsp:include page="header.jsp"/>

	<header>
		<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<span class="navbar-brand">物品売上管理システム</span>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-between" id="navbarNav">
				<ul class="navbar-nav mt-2">
					<li class="nav-item">
						<a class="nav-link" aria-current="page" href="DashboardServlet">ダッシュボード</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="RegisterServlet">売上登録</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="SearchSales">売上検索</a>
					</li>
					<li class="nav-item  bg-dark-subtle">
						<a class="nav-link" href="AccountServlet">アカウント登録</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="AccountSearchServlet">アカウント検索</a>
					</li>
				</ul>
					<div class="navbar-nav">
						<form action="LogoutServlet" method="post">
							<button class="nav-link" type="submit">ログアウト</butn>
						</form>
					</div>
			</div>
		</div>
	</nav>
	</header>
	
	<c:if test="${not empty err}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">${err}</div>
	</c:if>
	
<c:choose>	
	<c:when test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
	<div class="container position-absolute">
		<h1 class="mt-5" style="margin-left: 50px;">アカウント登録</h1>
		<div class="" style="margin-left: 10px">
			<form class="text-right" action="AccountServlet" method="post">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail"  class="col-form-label"
							style="text-align: end;">氏名 <span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="name" class="form-control" value="${not empty name ? name : ''}" placeholder="氏名">
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label" style="text-align: end;">
							メールアドレス <span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="mail" class="form-control"value="${not empty mail ? mail : ''}"  placeholder="メールアドレス">
					</div>
				</div>
				
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" value="${not empty password ? password : ''}" class="col-form-label" style="text-align: end;">
							パスワード <span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="password" name="password" class="form-control" value="${not empty password ? password : ''}" placeholder="パスワード">
					</div>
				</div>
				
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label" style="text-align: end;">
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
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
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
					<div class="col-sm-3"></div>
					<div class="col-sm-8">
						<button type="submit" class="btn btn-primary" style="margin-left: 30px;">
						✓登録
						</button>
					</div>
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