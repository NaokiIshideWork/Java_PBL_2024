<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">

<title>アカウント検索結果表示画面</title>


</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="ToDoServlet">物品売上管理システム</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link active"
                        aria-current="page" href="ToDoDelayServlet">ダッシュボード</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="ToDoDoneServlet">売上登録</a></li>
                    <li class="nav-item"><a class="nav-link"
                            href="ToDoDoneServlet">売上検索</a></li>  
                    <li class="nav-item"><a class="nav-link"
                                href="ToDoDoneServlet">アカウント登録</a></li>  
                    <li class="nav-item bg-dark-subtle"><a class="nav-link"
                                    href="ToDoDoneServlet">アカウント検索</a></li>
                </ul>
            </div>
            <ul class="navbar-nav justify-content-end">
                <li class="nav-item"><a class="nav-link"
                    href="ToDoDoneServlet">ログアウト</a></li>
            </ul>
        </div>
    </nav>


	<div class="container" class="text-left">
		<h2 class="mt-3">アカウント検索結果表示</h2>
	</div>
	<div class="container text-left">
		<table class="table table-hover">
			<thead>
				<tr>

					<th scope="col" class="col-md-1">操作</th>
					<th scope="col" class="col-md-1">No</th>
					<th scope="col" class="col-md-1">氏名</th>
					<th scope="col" class="col-md-1">メールアドレス</th>
					<th scope="col" class="col-md-2">権限</th>

				</tr>
			</thead>
			<!-- <c:forEach var="obj" items="${list}"> -->
			<form action="#" method="post">
				<tr>
					<!-- <c:out value="${obj.getDate()}" /> -->

					<!-- 詳細ページに遷移 -->
					<td class="col-md-1">
						<button type="button" class="btn btn-primary">✓ 編集</button>
						<button type="button" class="btn btn-danger">× 削除</button>
					</td>
					<td class="col-md-1">${obj.getNumber()}</td>
					<td class="col-md-1">${obj.getName()}</td>
					<td class="col-md-1">${obj.getMail()}</td>
					<td class="col-md-2">${obj.getPermission()}</td>
				</tr>
			</form>


			<!-- </c:forEach> -->



		</table>
	</div>
</body>
</html>