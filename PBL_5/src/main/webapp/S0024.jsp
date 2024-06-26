<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>売上詳細編集確認|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="searchSales" />
</jsp:include>

	<div class="container">
				<h2 class="mt-5" style="margin-left: 150px;">売上詳細編集確認</h2>
				<div style="margin-left: 100px">
					<form class="text-right" action="InsertServlet" method="post">
						<div class="row ">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">販売日</h3>
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
								<h3 for="inputEmail" class="col-form-label text-sm-end">担当</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="txet" value="${S0024list.getAccount()}"
									class="form-control bg-secondary-subtle" aria-label="Last Name"
									readonly>
							</div>
						</div>
						<div class="row mt-3">
							<div class="col-sm-2">
								<h3 for="inputEmail" class="col-form-label text-sm-end">商品カテゴリー</h3>
							</div>
							<div class="col-sm-8 w-50">
								<input type="text" value="${S0024list.getCategory_name()}"
									class="form-control bg-secondary-subtle" aria-label="Last name"
									readonly> 
							</div>

							<div class="row mt-3">
								<div class="col-sm-2">
									<h3 for="inputEmail" class="col-form-label text-sm-end">商品名</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="text" 
										class="form-control bg-secondary-subtle"
										value="${S0024list.getTrade_name()}" readonly>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-sm-2">
									<h3 for="inputEmail" class="col-form-label text-sm-end">単価</h3>
								</div>
								<div class="col-sm-8">
									<input type="text" 
										class="form-control w-25 bg-secondary-subtle"
										value="${S0024list.getUnit_price() }" readonly>

								</div>
							</div>
							<div class="row mt-3">
								<div class="col-sm-2">
									<h3 for="inputEmail" class="col-form-label text-sm-end">個数</h3>
								</div>
								<div class="col-sm-8">
									<input type="text" 
										class="form-control w-25 bg-secondary-subtle"
										value="${S0024list.getSale_number() }" readonly>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-sm-2">
									<h3 for="inputEmail" class="col-form-label text-sm-end">備考</h3>
								</div>
								<div class="col-sm-8">

									<textarea 
										class="form-control w-75 bg-secondary-subtle"
										id="exampleFormControlTextarea1" rows="5" readonly><c:out
											value="${S0024list.getNote()}"></c:out></textarea>
								</div>
							</div>
							<div class="row mt-3">
								<div class="col-sm-4"></div>
								<div class="col-sm-8">
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
		
<jsp:include page="footer.jsp"/>