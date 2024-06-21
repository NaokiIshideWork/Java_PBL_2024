<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" flush="true" />

	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">物品売上管理システム</a>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link " aria-current="page"
						href="DashboardServlet">ダッシュボード</a></li>
					<li class="nav-item"><a class="nav-link"
						href="RegisterServlet">売上登録</a></li>
					<li class="nav-item"><a class="nav-link" href="SearchSales">売上検索</a></li>
					<li class="nav-item"><a class="nav-link" href="AccountServlet">アカウント登録</a></li>
					<li class="nav-item bg-dark-subtle"><a class="nav-link"
						href="AccountSearchServlet">アカウント検索</a></li>
				</ul>
			</div>
			<ul class="navbar-nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">ログアウト</a></li>
			</ul>
		</div>
	</nav>

	<c:if test="${not empty err}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">${err}</div>
	</c:if>
	<c:if
		test="${sessionScope.LoginUser.getAuthority() eq 0 or sessionScope.LoginUser.getAuthority() eq 1}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">アカウント編集権限はありません</div>
	</c:if>
	<div class="container position-absolute">
		<h2 class="mt-5" style="margin-left: 30px;">アカウント検索条件入力</h2>
		<div class="" style="margin-left: 100px">
			<form class="text-right" action="AccountSearchServlet" method="POST">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							氏名 <span class="badge rounded-pill bg-secondary">部分一致</span>
						</h3>
					</div>
					<div class="col-sm-8 w-75">
						<input type="text" name="name" class="form-control"
							placeholder="氏名">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">メールアドレス</h3>
					</div>
					<div class="col-sm-8 w-75">
						<input type="email" name="mail" class="form-control"
							placeholder="メールアドレス">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">権限</h3>
					</div>
					<div class="col-sm-8" style="margin-top: 10px;">
						<input type="checkbox" name="authority" value="0"
							id="authorityNone"> <label for="authorityNone">
							権限なし </label> <input type="checkbox" name="authority" value="1"
							id="authoritySale"> <label for="authoritySale">
							売上登録 </label> <input type="checkbox" name="authority" value="10"
							id="authorityAccount"> <label for="authorityAccount">
							アカウント登録 </label>
					</div>
				</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-6"></div>
			<div class="col-sm-3">
				<button type="submit" class="btn btn-primary me-3"
					href="AccountSearchServlet">🔍検 索</button>
				<button type="reset" class="btn btn-outline-secondary">クリア</button>
			</div>
			</form>
		</div>
	</div>
<jsp:include page="footer.jsp" flush="true" />