<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp"/>

<header>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<span class="navbar-brand">物品売上管理システム</span>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-between"
				id="navbarNav">
				<ul class="navbar-nav mt-2">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="DashboardServlet">ダッシュボード</a></li>
					<li class="nav-item"><a class="nav-link"
						href="RegisterServlet">売上登録</a></li>
					<li class="nav-item bg-dark-subtle"><a class="nav-link"
						href="SearchSales">売上検索</a></li>
					<li class="nav-item"><a class="nav-link" href="AccountServlet">アカウント登録</a>
					</li>
					<li class="nav-item"><a class="nav-link"
						href="AccountSearchServlet">アカウント検索</a></li>
				</ul>
				<div class="navbar-nav">
					<form action="LogoutServlet" method="post">
						<button class="nav-link" type="submit">
							ログアウト
							</butn>
					</form>
				</div>
			</div>
		</div>
	</nav>
</header>
<c:if test="${not empty err}">
	<div
		class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
		role="alert">${err}</div>
</c:if>
<%--コメント --%>
<div class="container position-absolute">
	<h2 class="mt-5" style="margin-left: 30px;">売上詳細編集</h2>
	<div class="" style="margin-left: 100px">
		<form class="text-right" action="ConfirmationSalesEdit" method="get">
			<div class="row ">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label"
						style="text-align: end;">
						販売日 <span class="badge rounded-pill bg-secondary">必須</span>
					</h3>
				</div>
				<div class="col-sm-8">
					<input type="date" name="sale_date" class="form-control w-25"
						value="${S0023list.getSale_date()}" aria-label="Last name">
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label"
						style="text-align: end;">
						担当 <span class="badge rounded-pill bg-secondary">必須</span>
					</h3>
				</div>
				<div class="col-sm-8 w-50">
					<select class="form-select" name="account_id"
						aria-label="Default select example">
						<option value="選択して下さい。"><c:out value="選択して下さい。"></c:out></option>
						<c:forEach var="obj" items="${accounts}">
							<c:choose>
								<c:when test="${obj.getName() == s22list.getAccount()}">
									<option value="${obj.getAccount_id()}" selected>
										<c:out value="${obj.getName()}"></c:out>
									</option>
								</c:when>
								<c:otherwise>
									<option value="${obj.getAccount_id()}">
										<c:out value="${obj.getName()}"></c:out>
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label"
						style="text-align: end;">
						商品カテゴリー <span class="badge rounded-pill bg-secondary">必須</span>
					</h3>
				</div>
				<div class="col-sm-8 w-50">
					<select class="form-select" name="category_id"
						aria-label="Default select example">
						<option value="選択して下さい。"><c:out value="選択して下さい。"></c:out></option>
						<c:forEach var="obj" items="${cate}">
							<c:choose>
								<c:when
									test="${obj.getCategory_name() == s22list.getCategory()}">
									<option value="${obj.getCategory_id()}" selected>
										<c:out value="${obj.getCategory_name()}"></c:out>
									</option>
								</c:when>
								<c:otherwise>
									<option value="${obj.getCategory_id()}">
										<c:out value="${obj.getCategory_name()}"></c:out>
									</option>
								</c:otherwise>
							</c:choose>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label"
						style="text-align: end;">
						商品名 <span class="badge rounded-pill bg-secondary">必須</span>
					</h3>
				</div>
				<div class="col-sm-8 w-50">
					<input type="text" name="tard_name" class="form-control"
						value="${S0023list.getTrade_name()}">
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label"
						style="text-align: end;">
						単価 <span class="badge rounded-pill bg-secondary">必須</span>
					</h3>
				</div>
				<div class="col-sm-8">
					<input type="text" name="unit_price" class="form-control w-25"
						value="${S0023list.getUnit_price()}">
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label"
						style="text-align: end;">
						個数 <span class="badge rounded-pill bg-secondary">必須</span>
					</h3>
				</div>
				<div class="col-sm-8">
					<input type="text" name="sale_namber" class="form-control w-25"
						value="${S0023list.getSale_number()}" />
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label"
						style="text-align: end;">備考</h3>
				</div>
				<div class="col-sm-8">

					<textarea name="note" class="form-control w-75"
						id="exampleFormControlTextarea1" rows="5"><c:out
							value="${S0023list.getNote()}" /></textarea>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3"></div>
				<div class="col-sm-8" style="margin-left: 30px;">
					<button type="submit" class="btn btn-primary" name="up_date_id"
						value="${S0023list.getSale_id()}">✔更 新</button>
					<a class="btn btn-outline-secondary"
						href="SalesDetailsDisplayServlet?sale_id=${S0023list.getSale_id()}"
						role="button">キャンセル</a>
				</div>
			</div>
		</form>
	</div>
</div>

<jsp:include page="footer.jsp"/>