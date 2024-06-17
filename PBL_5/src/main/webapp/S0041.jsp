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
            <a class="navbar-brand" href="#">物品売上管理システム</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link "
                        aria-current="page" href="DashboardServlet">ダッシュボード</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="RegisterServlet">売上登録</a></li>
                    <li class="nav-item"><a class="nav-link"
                            href="SearchSales">売上検索</a></li>  
                    <li class="nav-item"><a class="nav-link"
                                href="AccountServlet">アカウント登録</a></li>  
                    <li class="nav-item bg-dark-subtle"><a class="nav-link"
                                    href="AccountSearchServlet">アカウント検索</a></li>
                </ul>
            </div>
            <ul class="navbar-nav justify-content-end">
                <li class="nav-item"><a class="nav-link"
                    href="LogoutServlet">ログアウト</a></li>
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
			<c:forEach var="obj" items="${AccountSearch}">
				<tr>
					<td class="col-md-1">
	    				<div class="d-flex align-items-center">
					        <form action="S0042EditAccountServlet" method="post" class="me-2">
					            <input type="hidden" name="tmpId" value="${obj.getAccount_id()}" />
					            <input type="hidden" name="tmpName" value="${obj.getName()}" />
					            <input type="hidden" name="tmpMail" value="${obj.getMail()}" />
					            <input type="hidden" name="tmpAuthority" value="${obj.getAuthority()}" />
					            <input type="hidden" name="tmpPassword" value="${obj.getPassword()}" />
					            <button type="submit" class="btn btn-primary">✓ 編集</button>
					        </form>
					        
					        <form action="S0044DeleteAccountServlet" method="post">
					            <input type="hidden" name="tmpId" value="${obj.getAccount_id()}" />
					            <input type="hidden" name="tmpName" value="${obj.getName()}" />
					            <input type="hidden" name="tmpMail" value="${obj.getMail()}" />
					            <input type="hidden" name="tmpAuthority" value="${obj.getAuthority()}" />
					            <input type="hidden" name="tmpPassword" value="${obj.getPassword()}" />
					            <button type="submit" class="btn btn-danger">× 削除</button>
					        </form>
					    </div>
					</td>

					
					<td class="col-md-1">${obj.getAccount_id()}</td>
					<td class="col-md-1">${obj.getName()}</td>
					<td class="col-md-1">${obj.getMail()}</td>
					<td class="col-md-2"><c:if test="${obj.getAuthority() == 0}">権限なし</c:if><c:if test="${obj.getAuthority() == 1}">売上登録</c:if><c:if test="${obj.getAuthority() == 2}">アカウント登録</c:if></td>
				</tr>
				
			</c:forEach>
		</table>
	</div>
</body>
</html>


































