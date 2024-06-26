	<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>アカウント検索結果表示|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="searchAccounts" />
</jsp:include>
	
	<div class="container" class="text-left">
		<h2 class="mt-3">アカウント検索結果表示</h2>
	</div>
	<div class="container text-left" style="
    overflow: auto;">
		<table class="table table-hover">
			<thead>
				<tr>
					<c:if
						test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
						<th scope="col" class="col-md-1">操作</th>
					</c:if>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">No</th>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">氏名</th>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">メールアドレス</th>
					<th scope="col" class="col-md-2" style="white-space:nowrap;">権限</th>
				</tr>
			</thead>
			<c:forEach var="obj" items="${AccountSearch}">
				<tr>
					<c:if
						test="${sessionScope.LoginUser.getAuthority() eq 10 or sessionScope.LoginUser.getAuthority() eq 11}">
						<td class="col-md-1">
							<div class="d-flex align-items-center">
								<form action="EditAccountServlet" method="post" class="me-2">
									<input type="hidden" name="tmpId"
										value="${obj.getAccount_id()}" /> 
										<input type="hidden"
										name="tmpName" value="${obj.getName()}" /> 
										<input
										type="hidden" name="tmpMail" value="${obj.getMail()}" /> <input
										type="hidden" name="tmpAuthority"
										value="${obj.getAuthority()}" /> 
										<input type="hidden"
										name="tmpPassword" value="${obj.getPassword()}" />
									<button type="submit" class="btn btn-primary" style="white-space:nowrap;">✓ 編集</button>
								</form>
								<form action="DeleteAccountServlet" method="post">
									<input type="hidden" name="tmpId"
										value="${obj.getAccount_id()}" /> <input type="hidden"
										name="tmpName" value="${obj.getName()}" /> <input
										type="hidden" name="tmpMail" value="${obj.getMail()}" /> <input
										type="hidden" name="tmpAuthority"
										value="${obj.getAuthority()}" /> <input type="hidden"
										name="tmpPassword" value="${obj.getPassword()}" />
									<button type="submit" class="btn btn-danger" style="white-space:nowrap;">× 削除</button>
								</form>
							</div>
						</td>
					</c:if>
					<td class="col-md-1" style="white-space:nowrap;">${obj.getAccount_id()}</td>
					<td class="col-md-1" style="white-space:nowrap;">${obj.getName()}</td>
					<td class="col-md-1" style="white-space:nowrap;">${obj.getMail()}</td>
					<td class="col-md-2" style="white-space:nowrap;"><c:if test="${obj.getAuthority() == 0}">権限なし</c:if>
						<c:if test="${obj.getAuthority() == 1}">売上登録</c:if> <c:if
							test="${obj.getAuthority() == 10}">アカウント登録</c:if> <c:if
							test="${obj.getAuthority() == 11}">売上登録/アカウント登録</c:if></td>
				</tr>
			</c:forEach>
		</table>
	</div>
<jsp:include page="footer.jsp"/>


