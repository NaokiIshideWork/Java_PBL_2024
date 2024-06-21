<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="header.jsp" flush="true" />

	<header>
		<nav class="navbar navbar-expand-lg navbar-light bg-light">
			<div class="container-fluid">
				<a class="navbar-brand" href="#">物品売上管理システム</a>
				<div class="collapse navbar-collapse" id="navbarNav">
					<ul class="navbar-nav mr-auto">
						<li class="nav-item"><a class="nav-link"
							href="DashboardServlet">ダッシュボード</a></li>
						<li class="nav-item"><a class="nav-link"
							href="RegisterServlet">売上登録</a></li>
						<li class="nav-item bg-dark-subtle"><a
							class="nav-link active" aria-current="page" href="SearchSales">売上検索</a></li>
						<li class="nav-item"><a class="nav-link"
							href="AccountServlet">アカウント登録</a></li>
						<li class="nav-item"><a class="nav-link"
							href="AccountSearchServlet">アカウント検索</a></li>
					</ul>
				</div>
				<ul class="navbar-nav justify-content-end">
					<li class="nav-item"><a class="nav-link" href="LogoutServlet">ログアウト</a></li>
				</ul>
			</div>
		</nav>
	</header>

	<div class="container position-absolute">
				<h2 class="mt-5" style="margin-left: 30px;">売上詳細編集確認</h2>
				<div class="" style="margin-left: 100px">
					<form class="text-right" action="InsertServlet" method="post">
						<div class="row ">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">販売日</h3>
							</div>
							<div class="col-sm-8">
								<input type="text" 
									class="form-control w-25 bg-secondary-subtle"
									value="${S0024list.getSale_date()}" aria-label="Last name"
									readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">担当</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="txet" value="${S0024list.getAccount()}"
									class="form-control bg-secondary-subtle" aria-label="Last Name"
									readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label"
									style="text-align: end;">商品カテゴリー</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="text" value="${S0024list.getCategory_name()}"
									class="form-control bg-secondary-subtle" aria-label="Last name"
									readonly> 
							</div>

							<div class="row mt-3">
								<div class="col-sm-2">
									<h3 for="inputEmail" class="col-form-label"
										style="text-align: end;">商品名</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="text" 
										class="form-control bg-secondary-subtle"
										value="${S0024list.getTrade_name()}" readonly>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-sm-2">
									<h3 for="inputEmail" class="col-form-label"
										style="text-align: end;">単価</h3>
								</div>
								<div class="col-sm-8">
									<input type="text" 
										class="form-control w-25 bg-secondary-subtle"
										value="${S0024list.getUnit_price() }" readonly>

								</div>
							</div>
							<div class="row mt-3">
								<div class="col-sm-2">
									<h3 for="inputEmail" class="col-form-label"
										style="text-align: end;">個数</h3>
								</div>
								<div class="col-sm-8">
									<input type="text" 
										class="form-control w-25 bg-secondary-subtle"
										value="${S0024list.getSale_number() }" readonly>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-sm-2">
									<h3 for="inputEmail" class="col-form-label"
										style="text-align: end;">備考</h3>
								</div>
								<div class="col-sm-8">

									<textarea 
										class="form-control w-75 bg-secondary-subtle"
										id="exampleFormControlTextarea1" rows="5" readonly><c:out
											value="${S0024list.getNote()}"></c:out></textarea>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-sm-2"></div>
								<div class="col-sm-8" style="margin-left: 30px;">
									<button type="submit" class="btn btn-primary" 
										value="${S0024list.getSale_id()}">✔O K</button>
									<a class="btn btn-outline-secondary"
										href="EditSalesDetails?sale_id=${S0024list.getSale_id()}"
										role="button">キャンセル</a>
								</div>
							</div>
					</form>
				</div>
			</div>
		
<jsp:include page="footer.jsp" flush="true" />