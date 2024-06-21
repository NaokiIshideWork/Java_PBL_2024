<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" flush="true" />

	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">物品売上管理システム</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-between" id="navbarNav">
				<ul class="navbar-nav mt-2">
					<li class="nav-item bg-dark-subtle">
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
					<li class="nav-item">
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
	
	<div class="container" class="text-left">
		<h2 class="mt-3">アカウント検索結果表示</h2>
	</div>
	<div class="container text-left">
		<table class="table table-hover">
			<thead>
				<tr>
					<c:if
						test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
						<th scope="col" class="col-md-1">操作</th>
					</c:if>
					<th scope="col" class="col-md-1">No</th>
					<th scope="col" class="col-md-1">氏名</th>
					<th scope="col" class="col-md-1">メールアドレス</th>
					<th scope="col" class="col-md-2">権限</th>
				</tr>
			</thead>
			<c:forEach var="obj" items="${AccountSearch}">
				<tr>
					<c:if
						test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
						<td class="col-md-1">
							<div class="d-flex align-items-center">
								<form action="EditAccountServlet" method="post" class="me-2">
									<input type="hidden" name="tmpId"
										value="${obj.getAccount_id()}" /> 
										<input type="hidden"
										name="tmpName" value="${obj.getName()}" /> 
										<input
										type="hidden" name="tmpMail" value="${obj.getMail()}" /> <input
										type="hidden" name="tmpAuthority"
										value="${obj.getAuthority()}" /> 
										<input type="hidden"
										name="tmpPassword" value="${obj.getPassword()}" />
									<button type="submit" class="btn btn-primary">✓ 編集</button>
								</form>
								<form action="DeleteAccountServlet" method="post">
									<input type="hidden" name="tmpId"
										value="${obj.getAccount_id()}" /> <input type="hidden"
										name="tmpName" value="${obj.getName()}" /> <input
										type="hidden" name="tmpMail" value="${obj.getMail()}" /> <input
										type="hidden" name="tmpAuthority"
										value="${obj.getAuthority()}" /> <input type="hidden"
										name="tmpPassword" value="${obj.getPassword()}" />
									<button type="submit" class="btn btn-danger">× 削除</button>
								</form>
							</div>
						</td>
					</c:if>
					<td class="col-md-1">${obj.getAccount_id()}</td>
					<td class="col-md-1">${obj.getName()}</td>
					<td class="col-md-1">${obj.getMail()}</td>
					<td class="col-md-2"><c:if test="${obj.getAuthority() == 0}">権限なし</c:if>
						<c:if test="${obj.getAuthority() == 1}">売上登録</c:if> <c:if
							test="${obj.getAuthority() == 10}">アカウント登録</c:if> <c:if
							test="${obj.getAuthority() == 11}">売上登録/アカウント登録</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
<jsp:include page="footer.jsp" flush="true" />


































