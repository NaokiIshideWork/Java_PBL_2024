<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

Object authorityObj = request.getAttribute("authority");
String authority = (authorityObj != null) ? authorityObj.toString() : "";

boolean salesSelected = false;
boolean accountSelected = false;
boolean noneSelected = false;

if (authority.equals("0")) {
    noneSelected = true;
}
if (authority.equals("1")) {
    salesSelected = true;
}
if (authority.equals("10")) {
    accountSelected = true;
}
if (authority.equals("11")) {
    salesSelected = true;
    accountSelected = true;
}

%>

<jsp:include page="header.jsp"/>

    <nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<span class="navbar-brand">物品売上管理システム</span>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-between" id="navbarNav">
				<ul class="navbar-nav mt-2">
					<li class="nav-item">
						<a class="nav-link" aria-current="page" href="DashboardServlet">ダッシュボード</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="RegisterServlet">売上登録</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="SearchSales">売上検索</a>
					</li>
					<li class="nav-item">
						<a class="nav-link" href="AccountServlet">アカウント登録</a>
					</li>
					<li class="nav-item  bg-dark-subtle">
						<a class="nav-link" href="AccountSearchServlet">アカウント検索</a>
					</li>
				</ul>
					<div class="navbar-nav">
						<form action="LogoutServlet" method="post">
							<button class="nav-link" type="submit">ログアウト</butn>
						</form>
					</div>
			</div>
		</div>
	</nav>
    
    <c:if test="${not empty err}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">${err}</div>
	</c:if>
    
    <c:choose>
        <c:when test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
            <div class="container position-absolute">
                <h2 class="mt-5" style="margin-left: 80px;">アカウント詳細編集</h2>
                <div class="" style="margin-left: 100px">
                    <form class="text-right" action="EditScreenServlet" method="POST">
                        <%
                        String id = (String) request.getAttribute("id");
                        System.out.println("S0042jsp id: " + id);
                        %>
                        <input type="hidden" name="id" value="<%=id%>" />
                        <div class="row ">
                            <div class="col-sm-3">
                                <h3 for="inputEmail" class="col-form-label" style="text-align: end;">氏名</h3>
                            </div>
                            <div class="col-sm-8 w-50">
                                <input type="text" name="name" class="form-control" value="${name}">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-sm-3">
                                <h3 for="inputEmail" class="col-form-label" style="text-align: end;">メールアドレス</h3>
                            </div>
                            <div class="col-sm-8 w-50">
                                <input type="email" name="mail" class="form-control" value="${mail}">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-sm-3">
                                <h3 for="inputEmail" class="col-form-label" style="text-align: end;">パスワード</h3>
                            </div>
                            <div class="col-sm-8 w-50">
                                <input type="password" name="password" class="form-control " value="${password}">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-sm-3">
                                <h3 for="inputEmail" class="col-form-label" style="text-align: end;">パスワード（確認）</h3>
                            </div>
                            <div class="col-sm-8 w-50">
                                <input type="password" name="confirmPassword" class="form-control " value="${password}">
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-sm-3">
                                <h3 for="inputEmail" class="col-form-label" style="text-align: end;">権限</h3>
                            </div>
                            <div class="col-sm-8" style="margin-top: 10px;">
                                <input type="checkbox" name="authority" value="1" id="authoritySale" <%=salesSelected ? "checked" : ""%>>
                                <label for="authoritySale"> 売上登録 </label> 
                                <input type="checkbox" name="authority" value="10" id="authorityAccount" <%=accountSelected ? "checked" : ""%>> 
                                <label for="authorityAccount"> アカウント登録 </label> 
                                <input type="hidden" name="authority" value="0" id="authorityNone" <%=noneSelected ? "checked" : ""%>> 
                                <label for="authorityNone"> </label>
                            </div>
                        </div>
                        <div class="row mt-3">
                            <div class="col-sm-3"></div>
                            <div class="col-sm-8">
                                <div class="btn-group" role="group">
                                    <!-- Update Button Form -->
                                    <form class="d-inline" action="EditScreenServlet" method="POST">
                                        <input type="hidden" name="id" value="<%=id%>" />
                                        <button type="submit" class="btn btn-primary rounded" style="margin-right: 10px;">✔更 新</button>
                                    </form>
                                    
                                    <!-- Cancel Button Form -->
                                    <form class="d-inline" action="AccountSearchServlet" method="post">
                                        <input type="hidden" name="cancel" value="true">
                                        <button type="submit" class="btn btn-outline-secondary">キャンセル</button>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </c:when>
        <c:otherwise>
            <div class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s" role="alert">アカウント編集権限がありません</div>
        </c:otherwise>
    </c:choose>
<jsp:include page="footer.jsp"/>
