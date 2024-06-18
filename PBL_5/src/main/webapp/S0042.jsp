<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>	
<%
// 今は片方の権限しか受け取れない
String authorityStr = (String) request.getAttribute("authority");
int authority = Integer.parseInt(authorityStr);


boolean salesSelected = false;
boolean accountSelected = false;
boolean noneSelected = false;

if(authority==0) {
	noneSelected = true;
}
if(authority==1) {
	salesSelected = true;
}
if(authority==10) {
	accountSelected = true;
}
if(authority==11) {
	salesSelected = true;
	accountSelected = true;
}
%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">
	<title>アカウント詳細編集</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="#">物品売上管理システム</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
              <li class="nav-item"><a class="nav-link "
                        aria-current="page" href="DashboardServlet">ダッシュボード</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="AccountRegisterServlet">売上登録</a></li>
                    <li class="nav-item"><a class="nav-link"
                            href="SearchSalesServlet">売上検索</a></li>  
                    <li class="nav-item"><a class="nav-link"
                                href="AccountRegisterServlet">アカウント登録</a></li>  
                    <li class="nav-item bg-dark-subtle"><a class="nav-link"
                                    href="AccountSearchServlet">アカウント検索</a></li>
                </ul>
            </div>
            <ul class="navbar-nav justify-content-end">
                <li class="nav-item"><a class="nav-link"
                    href="LogoutServlet">ログアウト</a></li>
            </ul>
        </div>
    </nav>

<div class="container position-absolute">
		<h2 class="mt-5" style="margin-left: 80px;">アカウント詳細編集</h2>
		<div class="" style="margin-left: 100px">
			<form class="text-right" action="S0043EditScreenServlet" method="POST">
				
				<% 
					        String id = (String) request.getAttribute("id");
					        System.out.println("S0042jsp id: " + id); 
					    %>
					    
				<input type="hidden" name="id" value="<%= id %>" />
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							氏名
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="name" class="form-control"
							value= "${name}">
					</div>
				</div>


				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							メールアドレス
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="email" name="mail" class="form-control"
							value= "${mail}"  >
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							パスワード
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="password" name="password" class="form-control "
							value= "${password}"  >
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label" 
							style="text-align: end;">
							パスワード（確認）
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="password" name="confirmPassword" class="form-control "
							value= "${password}"  >
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							権限
						</h3>
					</div>

				<div class="col-sm-8" style="margin-top: 10px;">
				    <input type="checkbox" name="authority" value="1" id="authoritySale" <%= salesSelected ? "checked" : "" %> >
				    <label for="authoritySale"> 売上登録 </label>
				    
				    <input type="checkbox" name="authority" value="10" id="authorityAccount" <%= accountSelected ? "checked" : "" %> >
				    <label for="authorityAccount"> アカウント登録 </label>
				    
				    <input type="hidden" name="authority" value="0" id="authorityNone" <%= noneSelected ? "checked" : "" %> >
				    <label for="authorityNone">  </label>
				</div>

				</div>
				<div class="row mt-3">
					<div class="col-sm-3"></div>
					<div class="col-sm-8">
					    <button type="submit" class="btn btn-primary" style="margin-left: 30px;">✔更 新</button>
						<a class="btn btn-outline-secondary" href="" role="button">キャンセル</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>