<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>売上詳細表示|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="searchSales" />
</jsp:include>

<style>
body {
	overflow-x: hidden;
}

.sp-left {
	margin-left: 100px;
}

@media screen and (max-width:500px) {
	.sp-left {
		margin-left: 0 !important;
	}
}

@media screen and (min-width:800px) {
	.pc-right {
		margin-right: 300px;
	}
}

@media screen and (min-width:400px) {
	.pc-right {
		margin-right: 120px;
	}
}
</style>	

	

	<div class="container">
		<h2 class="mt-5 sp-left">売上詳細表示</h2>
		<div class="sp-left">
			<form action="EditSalesDetails" method="get">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">販売日</h3>
					</div>
					<div class="col-sm-8">
						<p class="mt-1">
							<c:out value="${s22list.getSale_date()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">担当</h3>
					</div>
					<div class="col-sm-8">
						<p class="mt-1">
							<c:out value="${s22list.getAccount()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">商品カテゴリー</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="mt-1">
							<c:out value="${s22list.getCategory()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">商品名</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="mt-1">
							<c:out value="${s22list.getTrade_name()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">単価</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="mt-1">
							<c:out value="${s22list.getUnit_price()}" />
						</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">個数</h3>
					</div>
					<div class="col-sm-8">
						<p class="mt-1">
							<c:out value="${s22list.getSale_number()}" />
						</p>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">備考</h3>
					</div>
					<div class="col-sm-8">
						<p class="mt-1">
							<c:out value="${s22list.getNote()}" />
						</p>
					</div>
				</div>
				<div class="d-flex justify-content-center mt-3 pc-right"
					>
					<form method="post" action="EditSaleServlet" style="">
						<button type="submit" class="btn btn-primary" name="sale_id"
							value="${s22list.getSale_id()}" style="margin-right: 10px;">
							<span style="margin-right: 5px;">✔<span>編集 
						</button>
					</form>
					<form method="get" action="ConfirmationSalesDeletion"
						style="margin: 0 10px 0 0">
						<button type="submit" class="btn btn-danger" name="sale_id"
							value="${s22list.getSale_id()}">
							<span style="margin-right: 5px;">✕</span>削除
						</button>
					</form>
					<a class="btn btn-outline-secondary" href="SearchSalesServlet"
						role="button">キャンセル</a>
				</div>
		</div>
<jsp:include page="footer.jsp"/>