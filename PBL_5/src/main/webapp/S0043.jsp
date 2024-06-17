<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List" %>	
<%
// 今は片方の権限しか受け取れない
// 10, 11でも受け取って 11なら両方ちぇっくずみにｓて　10でも反応するように
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

// List<String> authorityList = (List<String>) request.getAttribute("authorities");
 
 
// 受け取った値がnullでない場合、それぞれの値に対応する変数をtrueに設定する
/*
// 複数受け取りの場合
if (authorityList != null) {
    for (String authority : authorityList) {
        if (authority.equals("1")) {
            salesSelected = true;
        } else if (authority.equals("2")) {
            accountSelected = true;
        }
    }
}
*/
 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">
<title>アカウント詳細編集確認</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="ToDoServlet">物品売上管理システム</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link"
                        aria-current="page" href="ToDoDelayServlet">ダッシュボード</a></li>
                    <li class="nav-item"><a class="nav-link"
                        href="ToDoDoneServlet">売上登録</a></li>
                    <li class="nav-item"><a class="nav-link"
                            href="ToDoDoneServlet">売上検索</a></li>  
                    <li class="nav-item"><a class="nav-link"
                                href="ToDoDoneServlet">アカウント登録</a></li>  
                    <li class="nav-item bg-dark-subtle"><a class="nav-link"
                                    href="ToDoDoneServlet">アカウント検索</a></li>
                </ul>
            </div>
            <ul class="navbar-nav justify-content-end">
                <li class="nav-item"><a class="nav-link"
                    href="ToDoDoneServlet">ログアウト</a></li>
            </ul>
        </div>
    </nav>


	<div class="container position-absolute">
		<h2 class="mt-5"  style="margin-left: 130px;">アカウント詳細編集確認</h2>
		<div class="" style="margin-left: 100px">
			<form class="text-right" action="S0043_EditConfirmServlet" method="post">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							氏名
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="name" class="form-control"
							placeholder="${name}" disabled>
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
							placeholder="${mail}" disabled>
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
							value="${password}" disabled>
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
							value="${confirmPassword}" disabled>
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
				</div>
				<div class="row mt-3">
					<div class="col-sm-3"></div>
					<div class="col-sm-8">
						<% 
					        String id = (String) request.getAttribute("id");
					        String name = (String) request.getAttribute("name");
					        String mail = (String) request.getAttribute("mail");
					        String confirm_authority = (String) request.getAttribute("authority");
					        String password = (String) request.getAttribute("password");
					        System.out.println("S0043jsp authority: " + authority); 
					    %>
					    
					    <input type="hidden" name="tmpId" value="<%= id %>" />
					    <input type="hidden" name="tmpName" value="<%= name %>" />
					    <input type="hidden" name="tmpMail" value="<%= mail %>" />
					    <input type="hidden" name="tmpAuthority" value="<%= confirm_authority %>" />
					    <input type="hidden" name="tmpPassword" value="<%= password %>" />
					    
						<button type="submit" class="btn btn-primary"
							style="margin-left: 30px;">✓OK</button>
						<a class="btn btn-outline-secondary" href="#" role="button">キャンセル</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>