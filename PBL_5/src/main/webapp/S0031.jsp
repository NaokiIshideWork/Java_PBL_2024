<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
// String[] authorities = request.getParameterValues("authorities");
String authority = (String) request.getAttribute("authority");
System.out.println("S0031 あたま　Authority: " + authority);

boolean salesSelected = false;
boolean accountSelected = false;
boolean noneSelected = false;

// 受け取った値がnullでない場合、それぞれの値に対応する変数をtrueに設定する
if (authority.equals("1")) {
	System.out.println("Authority==1");
	salesSelected = true;
} else if (authority.equals("10")) {
	System.out.println("Authority==10");
	accountSelected = true;
} else if (authority.equals("11")) {
	System.out.println("Authority==11");
	salesSelected = true;
	accountSelected = true;
} else if (authority.equals("0")) {
	System.out.println("Authority==0");
	noneSelected = true;
}
%>
<jsp:include page="header.jsp" flush="true" />

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">物品売上管理システム</a>
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
	<c:choose>
		<c:when
			test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
			<div class="container position-absolute">
				<h2 class="mt-5" style="margin-left: 40px;">アカウントを登録してよろしいですか?</h2>
				<div class="" style="margin-left: 100px">

					<form class="text-right" action="AccountRegisterServlet"
						method="post">

						<form class="text-right">

							<div class="row ">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label"
										style="text-align: end;">
										氏名 <span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="text" name="name"
										class="form-control bg-secondary-subtle" value="${name}"
										readonly>
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label"
										style="text-align: end;">
										メールアドレス <span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="email" name="mail"
										class="form-control bg-secondary-subtle" value="${mail}"
										placeholder="メールアドレス" readonly>
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label"
										style="text-align: end;">
										パスワード <span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="password" name="password"
										class="form-control bg-secondary-subtle" value="${password}"
										placeholder="パスワード" readonly>
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label"
										style="text-align: end;">
										パスワード（確認）<span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="password" name="password"
										class="form-control bg-secondary-subtle" value="${password}"
										placeholder="パスワード" readonly>
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
										id="flexRadioDefault1" <%=salesSelected ? "checked" : ""%>
										disabled> <label for="flexRadioDefault1"> 売上登録
									</label> <input type="checkbox" name="authority" value="10"
										id="flexRadioDefault2" <%=accountSelected ? "checked" : ""%>
										disabled> <label for="flexRadioDefault2">
										アカウント登録 </label> <input type="hidden" name="submitAuthority"
										value="<%=authority%>" />
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-sm-3"></div>
								<div class="col-sm-8">
									<button type="submit" class="btn btn-primary"
										style="margin-left: 30px;">O K</button>
									<a class="btn btn-outline-secondary" href="AccountServlet"
										role="button">キャンセル</a>
								</div>
							</div>
						</form>
				</div>
			</div>
		</c:when>
		<c:otherwise>
			<div
				class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
				role="alert">売上登録権限がありません</div>
		</c:otherwise>
	</c:choose>
<jsp:include page="footer.jsp" flush="true" />