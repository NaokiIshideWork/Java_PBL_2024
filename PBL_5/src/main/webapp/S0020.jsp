<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">
<title>売上検索条件入力</title>
</head>
<body>

	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">物品売上管理システム</a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link"
							href="DashboardServlet">ダッシュボード</a></li>
						<li class="nav-item"><a class="nav-link"
							href="RegisterServlet">売上登録</a></li>
						<li class="nav-item bg-dark-subtle"><a
							class="nav-link active" aria-current="page"
							href="SearchSales">売上検索</a></li>
						<li class="nav-item"><a class="nav-link"
							href="AccountServlet">アカウント登録</a></li>
						<li class="nav-item"><a class="nav-link"
							href="AccountSearchServlet">アカウント検索</a></li>
					</ul>
				</div>
				<ul class="navbar-nav justify-content-end">
					<li class="nav-item"><a class="nav-link"
						href="LogoutServlet">ログアウト</a></li>
				</ul>
			</div>
		</nav>
	</header>
	<c:if test="${not empty err}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">${err}</div>
	</c:if>
	<c:if
		test="${sessionScope.LoginUser.getAuthority() eq 0 or sessionScope.LoginUser.getAuthority() eq 10}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">売上編集権限はありません</div>
	</c:if>
	<div class="container">
		<h1 class="ml-5 mt-5 mb-4">売上検索条件入力</h1>

		<div class="row" style="padding-right: 350px;">
			<div class="col-12 ">
				<form class="text-center" style="
					margin-left: -15px;"action="SearchSalesServlet" method="post">
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="salesDate" class="col-form-label ">販売日</label>
						</div>

						<div class="col-sm-3" style="width: 23%">
							<input type="date" class="form-control" id="salesDate"
								name="salesDateB">
						</div>
						～
						<div class="col-sm-3">
							<input type="date" class="form-control" id="salesDate"
								name="salesDateA">
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="salesPerson" class="col-form-label">担当</label>
						</div>
						<div class="col-sm-6">
							<select class="form-control" id="salesPerson" name="salesPerson">
								<c:forEach var="obj" items="${accounts}">
									<option value="${obj.getAccount_id()}"><c:out
											value="${obj.getName()}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="productCategory" class="col-form-label">商品カテゴリー</label>
						</div>
						<div class="col-sm-6">
							<select class="form-control" id="productCategory"
								name="productCategory">
								<c:forEach var="obj" items="${cate}">
								<option value="${obj.getCategory_id()}"><c:out
										value="${obj.getCategory_name()}" /></option>
							</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="productName" class="col-form-label">商品名 <span
								class="badge bg-secondary">部分一致</span></label>
						</div>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="productName"
								name="productName" placeholder="商品名">
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="remarks" class="col-form-label">備考 <span
								class="badge bg-secondary">部分一致</span></label>
						</div>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="remarks"
								name="remarks" placeholder="備考">
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-2"></div>
						<div class="col-sm-4">
							<button type="submit" class="btn btn-primary btn-search me-1">
								🔍検索</a>
								<button type="reset" class="btn btn-outline-secondary btn-clear">クリア</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS (Optional) -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-33L5K/ez9oWsKy8jxQv0IUpSAXS2tkF/EAK+TM8f6L2sz/GbUqG+1uQuBkPWZhQz"
		crossorigin="anonymous"></script>
</body>
</html>
