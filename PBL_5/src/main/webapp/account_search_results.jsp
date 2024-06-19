<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">
<title>アカウント検索結果表示画面</title>
<script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
<script type="text/javascript">
    google.charts.load('current', {'packages':['corechart']});
    google.charts.setOnLoadCallback(drawChart);

    function drawChart() {
        var data = google.visualization.arrayToDataTable([
            ['権限', '人数'],
            ['権限なし', <%= (Integer) request.getAttribute("noAuthCount") %>],
            ['売上登録', <%= (Integer) request.getAttribute("salesAuthCount") %>],
            ['アカウント登録', <%= (Integer) request.getAttribute("accountAuthCount") %>],
            ['売上登録/アカウント登録', <%= (Integer) request.getAttribute("bothAuthCount") %>]
        ]);

        var options = {
            title: '権限の割合',
            pieHole: 0.4,
        };

        var chart = new google.visualization.PieChart(document.getElementById('donutchart'));
        chart.draw(data, options);
    }
</script>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
        <a class="navbar-brand" href="#">物品売上管理システム</a>
        <div class="collapse navbar-collapse" id="navbarNav">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item"><a class="nav-link " aria-current="page" href="DashboardServlet">ダッシュボード</a></li>
                <li class="nav-item"><a class="nav-link" href="RegisterServlet">売上登録</a></li>
                <li class="nav-item"><a class="nav-link" href="SearchSales">売上検索</a></li>
                <li class="nav-item"><a class="nav-link" href="AccountServlet">アカウント登録</a></li>
                <li class="nav-item bg-dark-subtle"><a class="nav-link" href="AccountSearchServlet">アカウント検索</a></li>
            </ul>
        </div>
        <ul class="navbar-nav justify-content-end">
            <li class="nav-item"><a class="nav-link" href="LogoutServlet">ログアウト</a></li>
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
                <th scope="col" class="col-md-1">No</th>
                <th scope="col" class="col-md-1">氏名</th>
                <th scope="col" class="col-md-1">メールアドレス</th>
                <th scope="col" class="col-md-2">権限</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="account" items="${accountsList}">
                <tr>
                    <td class="col-md-1">${account.getAccount_id()}</td>
                    <td class="col-md-1">${account.getName()}</td>
                    <td class="col-md-1">${account.getMail()}</td>
                    <td class="col-md-2">
                        <c:if test="${account.getAuthority() == 0}">権限なし</c:if>
                        <c:if test="${account.getAuthority() == 1}">売上登録</c:if>
                        <c:if test="${account.getAuthority() == 10}">アカウント登録</c:if>
                        <c:if test="${account.getAuthority() == 11}">売上登録/アカウント登録</c:if>
                    </td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    <div id="donutchart" style="width: 900px; height: 500px;"></div>
</div>
</body>
</html>
