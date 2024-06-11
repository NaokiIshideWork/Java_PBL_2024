<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title>売上登録</title>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="./css/bootstrap.min.css"  text="text/css">
<title>売上登録画面</title>


<title>Insert title here１</title>

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
                <li class="nav-item bg-dark-subtle"><a class="nav-link active"
                  aria-current="page" href="ToDoDelayServlet">売上登録</a></li>
                <li class="nav-item"><a class="nav-link"
                    href="ToDoDoneServlet">売上検索</a></li>
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
        <h2 class="mt-5" style="margin-left: 30px;">売上登録</h2>
        <div class="" style="margin-left:100px">
        <form class="text-right"  action="RegisterSalesServlet" method="post">
            <div class="row ">
                <div class="col-sm-3">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">販売日  <span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8">
                <input type="date" name="sale_date" class="form-control w-25"  aria-label="Last name"placeholder="年/月/日">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-3">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">担当  <span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <select name="account" class="form-select" aria-label="Default select example">
                       <c:forEach var="obj" items="${account}">
                       	　<option><c:out value="${account.getSale_date()}"></c:out></option>
                       </c:forEach>
                      </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-3">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">商品カテゴリー   <span class="badge rounded-pill bg-secondary" >必須</span></h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <select name="item_category" class="form-select" aria-label="Default select example">
                        <c:forEach var="obj" items="${category}">
                       	　<option><c:out value="${category.getCategory_name()}"></c:out></option>
                       </c:forEach>
                      </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-3">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">商品名  <span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <input type="text" name="trade_name" class="form-control" placeholder="商品名">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-3">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">単価  <span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8">
                <input type="text" name="unit_price" class="form-control w-25" placeholder="単価">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-3">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">個数  <span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8">
                <input type="text" name="sale_number" class="form-control w-25" placeholder="個数">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-3">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">備考</h3>
                </div>
                <div class="col-sm-8">
                
                <textarea name="note" class="form-control w-75" id="exampleFormControlTextarea1" rows="5"placeholder="備考"></textarea>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-3">    
                </div>
                <div class="col-sm-8">
                    <button type="submit" class="btn btn-primary" style="margin-left: 30px;">✔登 録</button>
                </div>
            </div>
        </form>
    </div>
</div>

</body>
</html>