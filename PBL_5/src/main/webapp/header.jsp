<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="css/bootstrap.min.css" text="text/css">
</head>
 
<nav class="navbar navbar-expand-lg bg-body-tertiary">
    <div class="container-fluid">
        <a class="navbar-brand">物品売上管理システム</a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
            data-bs-target="#navbarNav" aria-controls="navbarNav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse justify-content-between"
            id="navbarNav">
            <ul class="navbar-nav">
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${param['currentPage'] == 'dashboard'}">
                            <a class="nav-link bg-dark-subtle" href="DashboardServlet">ダッシュボード</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="DashboardServlet">ダッシュボード</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${param['currentPage'] == 'registerSales'}">
                            <a class="nav-link bg-dark-subtle" href="RegisterServlet">売上登録</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="RegisterServlet">売上登録</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${param['currentPage'] == 'searchSales'}">
                            <a class="nav-link bg-dark-subtle" href="SearchSales">売上検索</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="SearchSales">売上検索</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${param['currentPage'] == 'registerAccount'}">
                            <a class="nav-link bg-dark-subtle" href="AccountServlet">アカウント登録</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="AccountServlet">アカウント登録</a>
                        </c:otherwise>
                    </c:choose>
                </li>
                <li class="nav-item">
                    <c:choose>
                        <c:when test="${param['currentPage'] == 'searchAccounts'}">
                            <a class="nav-link bg-dark-subtle" href="AccountSearchServlet">アカウント検索</a>
                        </c:when>
                        <c:otherwise>
                            <a class="nav-link" href="AccountSearchServlet">アカウント検索</a>
                        </c:otherwise>
                    </c:choose>
                </li>
            </ul>
            <div class="navbar-nav">
                <form action="LogoutServlet" method="post" style="margin-bottom:0;">
                    <button class="nav-link" type="submit">
                        ログアウト
                    </button>
                </form>
            </div>
        </div>
    </div>
</nav>
<style>
button,a{
white-space: nowrap;
}
body{
    overflow-x: hidden;}
</style>
