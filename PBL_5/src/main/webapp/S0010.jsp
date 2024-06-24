<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" flush="true" />

<header>
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<a class="navbar-brand" href="#">物品売上管理システム</a>
			<button class="navbar-toggler" type="button"
				data-bs-toggle="collapse" data-bs-target="#navbarNav"
				aria-controls="navbarNav" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>
			<div class="collapse navbar-collapse justify-content-between"
				id="navbarNav">
				<ul class="navbar-nav mt-2">
					<li class="nav-item "><a class="nav-link" aria-current="page"
						href="DashboardServlet">ダッシュボード</a></li>
					
					<li class="nav-item bg-dark-subtle"><a class="nav-link"
						href="RegisterServlet" onclick="clearText()">売上登録</a></li>
						</form>
					<li class="nav-item"><a class="nav-link" href="SearchSales">売上検索</a>
					</li>
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


<c:choose>
	<c:when
		test="${sessionScope.LoginUser.getAuthority() eq 1 or sessionScope.LoginUser.getAuthority() eq 11}">
		<div class="container position-absolute">
			<h2 class="mt-5" style="margin-left: 30px;">売上登録</h2>
			<div class="" style="margin-left: 100px">
				<form class="text-right" action="RegisterServlet" method="post">
					<div class="row ">
						<div class="col-sm-3">
							<h3 for="inputEmail" class="col-form-label"
								style="text-align: end;">
								販売日 <span class="badge rounded-pill bg-secondary">必須</span>
							</h3>
						</div>
						<div class="col-sm-8">
							<input type="date" name="sale_date" class="form-control w-25"
								aria-label="Last name" placeholder="年/月/日" id="sale_date"
								value="${empty sblist.getSale_date() ? '' :sblist.getSale_date()}">
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
							<select name="account" class="form-select"
								aria-label="Default select example">
								<c:choose>
									<c:when test="${sblist.getAccout() == '選択して下さい。'}">

										<option value="選択して下さい。"><c:out value="選択して下さい。"></c:out></option>

										<c:forEach var="obj" items="${accounts}">
											<option value="${obj.getAccount_id()}"><c:out
													value="${obj.getName()}" /></option>
										</c:forEach>
									</c:when>
									<c:otherwise>

										<option value="選択して下さい。"><c:out value="選択して下さい。"></c:out></option>
										<c:forEach var="obj" items="${accounts}">

											<c:choose>
												<c:when test="${obj.getName() == sblist.getAccout()}">
													<option value="${obj.getAccount_id()}" selected><c:out
															value="${obj.getName()}" /></option>
												</c:when>
												<c:otherwise>
													<option value="${obj.getAccount_id()}"><c:out
															value="${obj.getName()}" /></option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:otherwise>
								</c:choose>

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
							<select name="item_category" class="form-select"
								aria-label="Default select example">
								
								<c:choose>
									<c:when test="${sblist.getItem_category() == '選択して下さい。'}">
										<option value="選択して下さい。"><c:out value="選択して下さい。"></c:out></option>
										<c:forEach var="obj" items="${cate}">
											<option value="${obj.getCategory_id()}"><c:out
													value="${obj.getCategory_name()}" /></option>
										</c:forEach>
									</c:when>
									<c:otherwise>
										<option value="選択して下さい。"><c:out value="選択して下さい。"></c:out></option>
										<c:forEach var="obj" items="${cate}">
											<c:choose>
												<c:when test="${obj.getCategory_name() == sblist.getItem_category()}">
													<option value="${obj.getCategory_id()}" selected><c:out
															value="${obj.getCategory_name()}" /></option>
												</c:when>
												<c:otherwise>
													<option value="${obj.getCategory_id()}"><c:out
															value="${obj.getCategory_name()}" /></option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</c:otherwise>
								</c:choose>
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
							<input type="text" name="trade_name" class="form-control"
								placeholder="商品名"
								value="${empty sblist.getTrade_name() ? '' :sblist.getTrade_name()}">
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
								placeholder="単価"
								value="${empty sblist.getUnit_price() ? '' :sblist.getUnit_price()}">
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
							<input type="text" name="sale_number" class="form-control w-25"
								placeholder="個数"
								value="${empty sblist.getSale_number() ? '' : sblist.getSale_number()}">
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-sm-3">
							<h3 for="inputEmail" class="col-form-label"
								style="text-align: end;">備考</h3>
						</div>
						<div class="col-sm-8">

							<textarea name="note" class="form-control w-75"
								id="exampleFormControlTextarea1" rows="5" placeholder="備考">
								<c:out value="${empty sblist.getNote() ? '' :sblist.getNote()}" />
								</textarea>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-sm-3"></div>
						<div class="col-sm-8">
							<button type="submit" class="btn btn-primary"
								style="margin-left: 30px;">✔登 録</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</c:when>
	<c:otherwise>
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">売上登録権限がありません</div>
	</c:otherwise>
</c:choose>
<jsp:include page="footer.jsp" flush="true" />