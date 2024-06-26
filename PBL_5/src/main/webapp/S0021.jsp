<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<title>売上検索結果表示|物品売上管理システム</title>
<jsp:include page="header.jsp">
<jsp:param name="currentPage" value="searchSales" />
</jsp:include>	

	<div class="container" class="text-left">
		<h2 class="mt-3">売上検索結果表示</h2>
	</div>
	<div class="container text-left">
		<table class="table table-hover">
			<thead>
				<tr>
					<c:if
						test="${sessionScope.LoginUser.getAuthority() eq 1 or sessionScope.LoginUser.getAuthority() eq 11}">
						<th scope="col" class="col-md-1">操作</th>
					</c:if>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">No</th>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">販売日</th>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">担当</th>
					<th scope="col" class="col-md-2" style="white-space:nowrap;">商品カテゴリー</th>
					<th scope="col" class="col-md-3" style="white-space:nowrap;">商品名</th>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">単価</th>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">個数</th>
					<th scope="col" class="col-md-1" style="white-space:nowrap;">小計</th>
				</tr>
			</thead>
			<c:forEach var="obj" items="${slist}">
				<form action="SalesDetailsDisplayServlet" method="get">
					<tr>
						<c:if
							test="${sessionScope.LoginUser.getAuthority() eq 1 or sessionScope.LoginUser.getAuthority() eq 11}">
							<td class="col-md-1"><button type="submit"
									class="btn btn-primary" name="sale_id"
									value="${obj.getSale_id()}" style="white-space:nowrap;">✓ 詳細</button></td>
						</c:if>
						<td class="col-md-1" style="white-space:nowrap;"><c:out value="${obj.getSale_id()}" /></td>
						<td class="col-md-1" style="white-space:nowrap;"><c:out value="${obj.getSale_date()}" /></td>
						<td class="col-md-1" style="white-space:nowrap;"><c:out value="${obj.getName()}" /></td>
						<td class="col-md-2" style="white-space:nowrap;"><c:out value="${obj.getCategory_name()}" /></td>
						<td class="col-md-3" style="white-space:nowrap;"><c:out value="${obj.getTrade_name()}" /></td>
						<td class="col-md-1" style="white-space:nowrap;"><c:out value="${obj.getUnit_price()}" /></td>
						<td class="col-md-1" style="white-space:nowrap;"><c:out value="${obj.getSale_number()}" /></td>
						<td class="col-md-1" style="white-space:nowrap;"><c:out value="${obj.getSubtotal()}" /></td>
					</tr>
				</form>
			</c:forEach>
		</table>
	</div>
<jsp:include page="footer.jsp" />