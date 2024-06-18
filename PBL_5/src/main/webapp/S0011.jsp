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
<title>売上登録確認</title>
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
						<li class="nav-item bg-dark-subtle"><a
							class="nav-link active" aria-current="page"
							href="RegisterServlet">売上登録</a></li>
						<li class="nav-item"><a class="nav-link" href="SearchSales">売上検索</a></li>
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
	</header>
	<c:choose>
		<c:when
			test="${sessionScope.LoginUser.getAuthority() eq 1 or sessionScope.LoginUser.getAuthority() eq 11}">
			<div class="container position-absolute">
				<h2 class="mt-5" style="margin-left: 30px;">売上登録確認</h2>
				<div class="" style="margin-left: 100px">
					<form class="text-right" action="RegisterSalesServlet"
						method="post">
						<div class="row ">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">販売日</h3>
							</div>
							<div class="col-sm-8">
								<input type="text" name="sale_date"
									value="${list.getSale_date()}"
									class="form-control w-25 bg-secondary-subtle"
									placeholder="Last name" aria-label="Last name" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">担当</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="text" value="${list.getAccout()}"
									class="form-control  bg-secondary-subtle"
									aria-label="Last name" readonly> <input type="hidden"
									name="account_id" value="${list.getAccout_id()}"
									class="form-control  bg-secondary-subtle"
									aria-label="Last name" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">商品カテゴリー</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="text" value="${list.getItem_category()}"
									class="form-control bg-secondary-subtle" aria-label="Last name"
									readonly> <input type="hidden" name="category_id"
									value="${list.getCategory_id()}"
									class="form-control  bg-secondary-subtle"
									aria-label="Last name" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">商品名</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="text" name="trade_name"
									value="${list.getTrade_name()}"
									class="form-control bg-secondary-subtle" placeholder="商品名"
									readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">単価</h3>
							</div>
							<div class="col-sm-8">
								<input type="text" name="unit_price"
									value="${list.getUnit_price()}"
									class="form-control w-25 bg-secondary-subtle" placeholder="単価"
									readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">個数</h3>
							</div>
							<div class="col-sm-8">
								<input type="text" name="sale_number"
									value="${list.getSale_number()}"
									class="form-control w-25 bg-secondary-subtle" placeholder="個数"
									readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">小計</h3>
							</div>
							<div class="col-sm-8">
								<input type="text" name="subtotal" value="${list.getSubtotal()}"
									class="form-control w-25 bg-secondary-subtle" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">備考</h3>
							</div>
							<div class="col-sm-8">

								<textarea class="form-control w-75 bg-secondary-subtle"
									name="note" id="exampleFormControlTextarea1" rows="5" readonly><c:out
										value="${list.getNote()}" />
                </textarea>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2"></div>
							<div class="col-sm-8" style="margin-left: 30px;">
								<button type="submit" class="btn btn-primary">✔OK</button>
								<a class="btn btn-outline-secondary" href="RegisterServlet"
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
</body>
</html>