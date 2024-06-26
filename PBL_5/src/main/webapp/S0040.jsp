<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="searchAccounts" />
</jsp:include>


	<c:if test="${not empty err}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">${err}</div>
	</c:if>
	<c:if
		test="${sessionScope.LoginUser.getAuthority() eq 0 or sessionScope.LoginUser.getAuthority() eq 1}">
		<div
			class="alert alert-danger animate__animated animate__fadeOut animate__delay-3s"
			role="alert">アカウント編集権限はありません</div>
	</c:if>
	<div class="container">
		<h2 class="mt-5" style="margin-left: 150px;">アカウント検索条件入力</h2>
		<div style="margin-left: 100px">
			<form class="text-right" action="AccountSearchServlet" method="POST">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">
							氏名 <span class="badge rounded-pill bg-secondary">部分一致</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="name" class="form-control"
							placeholder="氏名">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">メールアドレス</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="email" name="mail" class="form-control"
							placeholder="メールアドレス">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label text-sm-end">権限</h3>
					</div>
					<div class="col-sm-8" style="margin-top: 10px;">
						<input type="checkbox" name="authority" value="0"
							id="authorityNone"> <label for="authorityNone">
							権限なし </label> <input type="checkbox" name="authority" value="1"
							id="authoritySale"> <label for="authoritySale">
							売上登録 </label> <input type="checkbox" name="authority" value="10"
							id="authorityAccount"> <label for="authorityAccount">
							アカウント登録 </label>
					</div>
				</div>
		</div>
		<div class="row mt-3">
			<div class="col-sm-4"></div>
			<div class="col-sm-8">
				<button type="submit" class="btn btn-primary me-2"
					href="AccountSearchServlet">🔍検 索</button>
				<button type="reset" class="btn btn-outline-secondary">クリア</button>
			</div>
			</form>
		</div>
	</div>
<jsp:include page="footer.jsp"/>