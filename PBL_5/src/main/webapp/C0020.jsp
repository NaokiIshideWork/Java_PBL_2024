<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<!-- 遷移先未作成  -->
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">物品売上管理システム</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item bg-dark-subtle"><a class="nav-link"
                        aria-current="page" href="DashboardServlet">ダッシュボード</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="RegisterServlet">売上登録</a></li>
                    <li class="nav-item"><a class="nav-link"
                            href="SearchSales">売上検索</a></li>  
                    <li class="nav-item"><a class="nav-link"
						href="AccountServlet">アカウント登録</a></li>  
                    <li class="nav-item"><a class="nav-link"
                                    href="AccountSearchServlet">アカウント検索</a></li>
                </ul>
            </div>
            <div class="navbar-nav justify-content-end">
                <form action="LogoutServlet" method="post"><button class="nav-link"
                    type="submit">ログアウト</butn></form></li>
            </div>
        </div>
    </nav>
</body>
</html>