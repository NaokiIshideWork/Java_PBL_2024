<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>売上登録確認|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="registerSales" />
</jsp:include>

<style>
body {
	overflow-x: hidden;
}

.sp-left {
	margin-left: 100px;
}
@media screen and (min-width:320px) {
	.sp-left {
		margin-left: 0 !important;
	}
}

@media screen and (min-width:375px) {
	.sp-left {
		margin-left: 0 !important;
	}
}

@media screen and (min-width:425px) {
	.sp-left {
		margin-left: 30px;
	}
}

@media screen and (min-width:768px) {
	.sp-left {
		margin-left: 50px;
	}
}@media screen and (min-width:1024px) {
	.sp-left {
		margin-left: 150px;
	}
}
</style>	

	<c:choose>
		<c:when
			test="${sessionScope.LoginUser.getAuthority() eq 1 or sessionScope.LoginUser.getAuthority() eq 11}">
			<div class="container ">
				<h2 class="mt-5 sp-left">売上登録確認</h2>
				<div  style="margin-left: 100px">
					<form class="text-right" action="RegisterSalesServlet"
						method="post">
						<div class="row ">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">販売日</h3>
							</div>
							<div class="col-sm-8">
								<input type="date" value="${sblist.getSale_date()}"
									class="form-control w-25 bg-secondary-subtle"
									placeholder="Last name" aria-label="Last name" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">担当</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="text" value="${sblist.getAccout()}"
									class="form-control  bg-secondary-subtle"
									aria-label="Last name" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">商品カテゴリー</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="text" value="${sblist.getItem_category()}"
									class="form-control bg-secondary-subtle" aria-label="Last name"
									readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">商品名</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="text" value="${sblist.getTrade_name()}"
									class="form-control bg-secondary-subtle" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">単価</h3>
							</div>
							<div class="col-sm-8">
								<input type="text" value="${sblist.getUnit_price()}"
									class="form-control w-25 bg-secondary-subtle" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">個数</h3>
							</div>
							<div class="col-sm-8">
								<input type="text" value="${sblist.getSale_number()}"
									class="form-control w-25 bg-secondary-subtle" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">小計</h3>
							</div>
							<div class="col-sm-8">
								<input type="text" name="subtotal"
									value="${sblist.getSubtotal()}"
									class="form-control w-25 bg-secondary-subtle" readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">備考</h3>
							</div>
							<div class="col-sm-8">

								<textarea class="form-control w-75 bg-secondary-subtle"
									id="exampleFormControlTextarea1" rows="5" readonly><c:out
										value="${sblist.getNote()}" />
                </textarea>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2"></div>
							<div class="col-sm-8" style="margin-left: 100px;">
								<button type="submit" class="btn btn-primary">✔OK</button>
								<a class="btn btn-outline-secondary" href="RegisterServlet?cancel=true"
									role="button">キャンセル</a>
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
	
<jsp:include page="footer.jsp"/>