<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String authority = (String) request.getAttribute("authority");

boolean salesSelected = false;
boolean accountSelected = false;
boolean noneSelected = false;

// 受け取った値がnullでない場合、それぞれの値に対応する変数をtrueに設定する
if (authority.equals("1")) {
	salesSelected = true;
} else if (authority.equals("10")) {
	accountSelected = true;
} else if (authority.equals("11")) {
	salesSelected = true;
	accountSelected = true;
} else if (authority.equals("0")) {
	noneSelected = true;
}

%>


<title>アカウント登録確認|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="registerAccount" />
</jsp:include>


<style>
body {
	overflow-x: hidden;
}

.sp-left {
	margin-left: 100px;
}

.sp-center {
		text-align: center;
	}
	
	

@media screen and (min-width:500px) {
	.sp-left {
		margin-left: 30 !important;
		
	}
}

@media screen and (min-width:375px) {
	.sp-left {
		margin-left: 20 !important;
		
	}
}

@media screen and (min-width:767px) {

	.sp-left {
		margin-left: 50px;
	}
	
	.sp-center {
		text-align: center;
	}
	
}
@media screen and (min-width:991px) {

	.sp-left {
		margin-left: 100px;
	}
	
}

@media screen and (min-width:1024px) {
	.sp-left {
		margin-left: 150px;
	}
}
</style>

	
	<c:choose>
		<c:when
			test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
			<div class="container">
				<h2 class="mt-5 sp-left">アカウントを登録してよろしいですか?</h2>
				<div style="margin-left: 100px">
					<form class="text-right" action="AccountRegisterServlet"
						method="post">
						<form class="text-right">
							<div class="row ">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label text-sm-end">
										氏名 <span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="text" name="name"
										class="form-control bg-secondary-subtle" value="${name}"
										readonly>
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label text-sm-end">
										メールアドレス <span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="email" name="mail"
										class="form-control bg-secondary-subtle" value="${mail}"
										placeholder="メールアドレス" readonly>
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label text-sm-end">
										パスワード <span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="password" name="password"
										class="form-control bg-secondary-subtle" value="${password}"
										placeholder="パスワード" readonly>
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label text-sm-end">
										パスワード（確認）<span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8 w-50">
									<input type="password" name="password"
										class="form-control bg-secondary-subtle" value="${password}"
										placeholder="パスワード" readonly>
								</div>
							</div>

							<div class="row mt-3">
								<div class="col-sm-3">
									<h3 for="inputEmail" class="col-form-label text-sm-end">
										権限 <span class="badge rounded-pill bg-secondary">必須</span>
									</h3>
								</div>
								<div class="col-sm-8" style="margin-top: 10px;">
									<input type="checkbox" name="authority" value="1"
										id="flexRadioDefault1" <%=salesSelected ? "checked" : ""%>
										disabled> <label for="flexRadioDefault1"> 売上登録
									</label> <input type="checkbox" name="authority" value="10"
										id="flexRadioDefault2" <%=accountSelected ? "checked" : ""%>
										disabled> <label for="flexRadioDefault2">
										アカウント登録 </label> <input type="hidden" name="submitAuthority"
										value="<%=authority%>" />
								</div>
							</div>

							<div class="row mt-4">
					<div class="col-sm-4"></div>
					<div class="col-sm-4 d-flex sp-center">
						<button type="submit" class="btn btn-primary mb-3"
							style="margin-left: 0px">✓OK</button>
						</form>
						
						<form action="AccountServlet" method="get"style="margin-left: 8px;">
						
							<input type="hidden" name="tmpName" value="${name}" /> 
							<input type="hidden" name="tmpMail" value="${mail}" /> 
							<input type="hidden" name="tmpPassword" value="${password}" />
							<input type="hidden" name="tmpAuthority" value="${authority}" />
							<input type="hidden" name="S0031Cancel" value="true">
							<button class="btn btn-outline-secondary" type="submit"
								role="button">キャンセル</button>
						</form>
					</div>
					<div class="col-sm-3"></div>
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