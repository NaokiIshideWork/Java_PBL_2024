<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<title>売上登録|物品売上管理システム</title>

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
		margin-left: 50px;
	}
}

@media screen and (min-width:768px) {
	.sp-left {
		margin-left: 80px;
	}
}@media screen and (min-width:1024px) {
	.sp-left {
		margin-left: 150px;
	}
}
</style>	


<c:if test="${not empty err}">
	<div
		class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
		role="alert">${err}</div>
</c:if>


<c:choose>
	<c:when
		test="${sessionScope.LoginUser.getAuthority() eq 1 or sessionScope.LoginUser.getAuthority() eq 11}">
		<div class="container">
			<h2 class="mt-5 sp-left">売上登録</h2>
			<div style="margin-left: 100px">
				<form class="text-right" action="RegisterConfirm" method="post">
					<div class="row ">
						<div class="col-sm-3">
							<h3 for="inputEmail" class="col-form-label text-sm-end">
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
							<h3 for="inputEmail" class="col-form-label text-sm-end">
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
							<h3 for="inputEmail" class="col-form-label text-sm-end">
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
							<h3 for="inputEmail" class="col-form-label text-sm-end">
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
							<h3 for="inputEmail" class="col-form-label text-sm-end">
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
							<h3 for="inputEmail" class="col-form-label text-sm-end">
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
							<h3 for="inputEmail" class="col-form-label text-sm-end">備考</h3>
						</div>
						<div class="col-sm-8">

							<textarea name="note" class="form-control w-75"
								id="exampleFormControlTextarea1" rows="5" placeholder="備考">
								<c:out value="${empty sblist.getNote() ? '' :sblist.getNote()}" />
								</textarea>
						</div>
					</div>
					<div class="row mt-3">
						<div class="col-sm-4"></div>
						<div class="col-sm-8">
							<button type="submit" class="btn btn-primary"
								style="margin-left: 100px;">✔登 録</button>
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