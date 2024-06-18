<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">
<title>売上詳細削除確認</title>
</head>
<body>


	<nav class="navbar navbar-expand-lg navbar-light bg-light">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">物品売上管理システム</a>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link"
						aria-current="page" href="DashboardServlet">ダッシュボード</a></li>
					<li class="nav-item"><a class="nav-link"
						href="RegisterServlet">売上登録</a></li>
					<li class="nav-item bg-dark-subtle"><a class="nav-link"
						href="SearchSales">売上検索</a></li>
					<li class="nav-item"><a class="nav-link"
						href="AccountServlet">アカウント登録</a></li>
					<li class="nav-item"><a class="nav-link"
						href="AccountSearchServlet">アカウント検索</a></li>
				</ul>
			</div>
			<ul class="navbar-nav justify-content-end">
				<li class="nav-item"><a class="nav-link" href="LogoutServlet">ログアウト</a></li>
			</ul>
		</div>
	</nav>

<c:choose>

		<c:when
			test="${sessionScope.accounts.getAuthority() eq 1 or sessionScope.accounts.getAuthority() eq 11}">
	<div class="container position-absolute">
		<h2 class="mt-5" style="margin-left: 30px;">売上詳細削除確認</h2>
		<div class="" style="margin-left: 100px">
			<form class="text-right" action="DeleteServlet" method="post">
				<div class="row ">
					<div class="col-sm-2">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">販売日</h3>
					</div>
					<div class="col-sm-8">
						<input type="text" name="sale_date" value="${list.getSale_date()}" class="form-control w-25"
							placeholder="Last name" aria-label="Last name" disabled>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-2">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">担当</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" value="${list.getName()}"
							class="form-control  bg-secondary-subtle" 
							aria-label="Last name" name="name" readonly>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-2">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">商品カテゴリー</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" value="${list.getCategory_name()}"
							class="form-control  bg-secondary-subtle" 
							name="category_name"aria-label="Last name" readonly>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-2">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">商品名</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="trade_name" class="form-control bg-secondary-subtle" value="${list.getTrade_name()}"
							readonly>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-2">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">単価</h3>
					</div>
					<div class="col-sm-8">
						<input type="text" name="unit_price" class="form-control w-25 bg-secondary-subtle"
							placeholder="単価" value="${list.getUnir_price()}" readonly>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-2">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">個数</h3>
					</div>
					<div class="col-sm-8">
						<input type="text" name="sale_number" class="form-control w-25 bg-secondary-subtle"
							value="${list.getSale_number() }" readonly>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-2">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">小計</h3>
					</div>
					<div class="col-sm-8">
						<input type="text" name="subtotal" class="form-control w-25 bg-secondary-subtle"
							value="${list.getSubtotal()}" readonly>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-2">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">備考</h3>
					</div>
					<div class="col-sm-8">

						<textarea name="#" class="form-control w-75 bg-secondary-subtle"
							id="exampleFormControlTextarea1" rows="5" placeholder="備考"
							readonly><c:out value="${list.getNote()}"/></textarea>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-2"></div>
					<div class="col-sm-8" style="margin-left: 30px;">
						<button type="submit" class="btn btn-danger" name="delete_id" value="${list.getSale_id()}">✕ O K</button>
						<a class="btn btn-outline-secondary" href="SalesDetailsDisplayServlet?sale_id=${list.getSale_id()}" role="button">キャンセル</a>
					</div>
				</div>
			</form>
		</div>
	</div>
	</c:when>
		<c:otherwise>
			<div
				class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
				role="alert">売上編集権限がありません</div>
		</c:otherwise>
	</c:choose>
</body>
</html>