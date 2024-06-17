<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">
<title>売上検索結果表示</title>
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

	<div class="container" class="text-left">
		<h2 class="mt-3">売上検索結果表示</h2>
	</div>
	<div class="container text-left">
		<table class="table table-hover">
			<thead>
				<tr>
					<th scope="col" class="col-md-1">操作</th>
					<th scope="col" class="col-md-1">No</th>
					<th scope="col" class="col-md-1">販売日</th>
					<th scope="col" class="col-md-1">担当</th>
					<th scope="col" class="col-md-2">商品カテゴリー</th>
					<th scope="col" class="col-md-3">商品名</th>
					<th scope="col" class="col-md-1">単価</th>
					<th scope="col" class="col-md-1">個数</th>
					<th scope="col" class="col-md-1">小計</th>

				</tr>
			</thead>
			<c:forEach var="obj" items="${list}">
				<form action="SalesDetailsDisplayServlet" method="get">
					<tr>


						<!-- 詳細ページに遷移 -->
						<td class="col-md-1"><button type="submit"
								class="btn btn-primary" name="sale_id" value="${obj.getSale_id()}">✓
								詳細</button></td>
						<td class="col-md-1"><c:out value="${obj.getSale_id()}" /></td>
						<td class="col-md-1"><c:out value="${obj.getSale_date()}" /></td>
						<td class="col-md-1"><c:out value="${obj.getName()}" /></td>
						<td class="col-md-2"><c:out value="${obj.getCategory_name()}" /></td>
						<td class="col-md-3"><c:out value="${obj.getTrade_name()}" /></td>
						<td class="col-md-1"><c:out value="${obj.getUnit_price()}" /></td>
						<td class="col-md-1"><c:out value="${obj.getSale_number()}" /></td>
						<td class="col-md-1"><c:out value="${obj.getSubtotal()}" /></td>
					</tr>
				</form>


			</c:forEach>



		</table>
	</div>
</body>
</html>
