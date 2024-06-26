<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>売上検索条件入力|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="searchSales" />
</jsp:include>

	<c:if test="${not empty err}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">${err}</div>
	</c:if>
	<c:if
		test="${sessionScope.LoginUser.getAuthority() eq 0 or sessionScope.LoginUser.getAuthority() eq 10}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">売上編集権限はありません</div>
	</c:if>
	<div class="container">
		<h2 class="mt-5" style="margin-left: 150px;">売上検索</h2>
		<div class="row" style="padding-right: 350px;">
				<form class="text-center" action="SearchSalesServlet" method="post">
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="salesDate" class="col-form-label ">販売日</label>
						</div>

						<div class="col-sm-3" style="width: 23%">
							<input type="date" class="form-control" id="salesDate"
								name="salesDateB">
						</div>
						～
						<div class="col-sm-3">
							<input type="date" class="form-control" id="salesDate"
								name="salesDateA">
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="salesPerson" class="col-form-label">担当</label>
						</div>
						<div class="col-sm-6">
							<select class="form-control" id="salesPerson" name="salesPerson">
							<option value="選択して下さい。"><c:out value="選択して下さい。"></c:out></option>
								<c:forEach var="obj" items="${accounts}">
									<option value="${obj.getAccount_id()}"><c:out
											value="${obj.getName()}" /></option>
								</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="productCategory" class="col-form-label">商品カテゴリー</label>
						</div>
						<div class="col-sm-6">
							<select class="form-control" id="productCategory"
								name="productCategory">
								<option value="選択して下さい。"><c:out value="選択して下さい。"></c:out></option>
								<c:forEach var="obj" items="${cate}">
								<option value="${obj.getCategory_id()}"><c:out
										value="${obj.getCategory_name()}" /></option>
							</c:forEach>
							</select>
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="productName" class="col-form-label">商品名 <span
								class="badge bg-secondary">部分一致</span></label>
						</div>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="productName"
								name="productName" placeholder="商品名">
						</div>
					</div>
					<div class="row mb-3 justify-content-center">
						<div class="col-sm-4" style="text-align: right">
							<label for="remarks" class="col-form-label">備考 <span
								class="badge bg-secondary">部分一致</span></label>
						</div>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="remarks"
								name="remarks" placeholder="備考">
						</div>
					</div>
					<div class="row mb-3 ">
						<div class="col-sm-4"></div>
						<div class="col-sm-8">
							<button type="submit" class="btn btn-primary btn-search me-1">
								🔍検索</a>	
						<button type="reset" class="btn btn-outline-secondary btn-clear">クリア</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

	<!-- Bootstrap JS (Optional) -->

<jsp:include page="footer.jsp"/>