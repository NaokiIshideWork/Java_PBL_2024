<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
body {
	overflow-x: hidden;
}

.sp-left {
	margin-left: 10%;	
}

@media screen and (max-width:500px) {
	.sp-left {
		margin-left: 0;
	}
}

@media screen and (min-width:800px) {
	.pc-right {
		margin-right: 300px;
	}
}

@media screen and (min-width:400px) {
	.pc-right {
		margin-right: 100px;
	}
}
</style>
<title>売上詳細削除確認|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="searchSales" />
</jsp:include>

<div class="container position-absolute">
	<h2 class="mt-5 sp-left">売上詳細削除確認</h2>
	<div class="sp-left">
		<form class="text-right" action="DeleteServlet" method="post">
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label text-sm-end">販売日</h3>
				</div>
				<div class="col-sm-8">
					<input type="text" name="sale_date" value="${list.getSale_date()}"
						class="form-control w-25" placeholder="Last name"
						aria-label="Last name" disabled>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label text-sm-end">担当</h3>
				</div>
				<div class="col-sm-8 w-50">
					<input type="text" value="${list.getName()}"
						class="form-control  bg-secondary-subtle" aria-label="Last name"
						name="name" readonly>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label text-sm-end">商品カテゴリー</h3>
				</div>
				<div class="col-sm-8 w-50">
					<input type="text" value="${list.getCategory_name()}"
						class="form-control  bg-secondary-subtle" name="category_name"
						aria-label="Last name" readonly>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label text-sm-end">商品名</h3>
				</div>
				<div class="col-sm-8 w-50">
					<input type="text" name="trade_name"
						class="form-control bg-secondary-subtle"
						value="${list.getTrade_name()}" readonly>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label text-sm-end">単価</h3>
				</div>
				<div class="col-sm-8">
					<input type="text" name="unit_price"
						class="form-control w-25 bg-secondary-subtle" placeholder="単価"
						value="${list.getUnir_price()}" readonly>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label text-sm-end">個数</h3>
				</div>
				<div class="col-sm-8">
					<input type="text" name="sale_number"
						class="form-control w-25 bg-secondary-subtle"
						value="${list.getSale_number() }" readonly>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label text-sm-end">小計</h3>
				</div>
				<div class="col-sm-8">
					<input type="text" name="subtotal"
						class="form-control w-25 bg-secondary-subtle"
						value="${list.getSubtotal()}" readonly>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3">
					<h3 for="inputEmail" class="col-form-label text-sm-end">備考</h3>
				</div>
				<div class="col-sm-8">

					<textarea name="#" class="form-control w-75 bg-secondary-subtle"
						id="exampleFormControlTextarea1" rows="5" placeholder="備考"
						readonly><c:out value="${list.getNote()}" /></textarea>
				</div>
			</div>
			<div class="row mt-3">
				<div class="col-sm-3"></div>
				<div class="col-sm-9" style="padding-left: 15%;">
					<button type="submit" class="btn btn-danger" name="delete_id"
						value="${list.getSale_id()}">✕ O K</button>
					<a class="btn btn-outline-secondary"
						href="SalesDetailsDisplayServlet?sale_id=${list.getSale_id()}"
						role="button">キャンセル</a>
				</div>
			</div>
		</form>
	</div>
</div>

<jsp:include page="footer.jsp" />