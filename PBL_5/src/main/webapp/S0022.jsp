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
<title>売上詳細表示</title>
</head>
<body>


	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="ToDoServlet">物品売上管理システム</a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link"
							href="ToDoDoneServlet">ダッシュボード</a></li>
						<li class="nav-item"><a class="nav-link"
							href="RegisterServlet">売上登録</a></li>
						<li class="nav-item bg-dark-subtle"><a
							class="nav-link active" aria-current="page"
							href="SearchSales">売上検索</a></li>
						<li class="nav-item"><a class="nav-link"
							href="ToDoDoneServlet">アカウント登録</a></li>
						<li class="nav-item"><a class="nav-link"
							href="ToDoDoneServlet">アカウント検索</a></li>
					</ul>
				</div>
				<ul class="navbar-nav justify-content-end">
					<li class="nav-item"><a class="nav-link"
						href="ToDoDoneServlet">ログアウト</a></li>
				</ul>
			</div>
		</nav>
	</header>


	<div class="container position-absolute">
		<h2 class="mt-5" style="margin-left: 100px;">売上詳細表示</h2>
		<div class="" style="margin-left: 100px">
			<form class="text-right" action="EditSalesDetails" method="get">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">販売日</h3>
					</div>
					<div class="col-sm-8">
						<p class="text-start" style="margin-top: 5px">
							<c:out value="${list.getSale_date()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">担当</h3>
					</div>
					<div class="col-sm-8">
						<p class="text-start" style="margin-top: 5px">
							<c:out value="${list.getAccount()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">商品カテゴリー</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="text-start" style="margin-top: 5px">
							<c:out value="${list.getCategory()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">商品名</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="text-start" style="margin-top: 5px">
							<c:out value="${list.getTrade_name()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">単価</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="text-start" style="margin-top: 5px">
							<c:out value="${list.getUnit_price()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">個数</h3>
					</div>
					<div class="col-sm-8">
						<p class="text-start" style="margin-top: 5px">
							<c:out value="${list.getSale_number()}" />
						</p>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">備考</h3>
					</div>
					<div class="col-sm-8">
						<p class="text-start" style="margin-top: 5px">
							<c:out value="${list.getNote()}" />
						</p>
					</div>
				</div>

			<div class="row mt-3">
					<div class="col-sm-5 text-end">
						<button type="submit" class="btn btn-primary" name="sale_id"
							value="${list.getSale_id() }">✔編集</button>
					</div>
			</form>
			<div class="col-sm-1" style= "white-space: nowrap;">
				<form method="get" action="ConfirmationSalesDeletion">
					<button type="submit" class="btn btn-danger "
						name="sale_id" value="${list.getSale_id() }">✕削除</button>
				</form>
			</div>
			<div class= "col-sm-1" style= "white-space: nowrap;"> <a
				class="btn btn-outline-secondary" href="SearchSalesServlet"
				role="button">キャンセル</a>
			</div>
			<div class="col-sm-5"></div>
			</div>
	</div>	
</body>
</html>