<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<meta charset="UTF-8">
<title>アカウント検索条件入力</title>
</head>
<body>
<nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand" href="ToDoServlet">物品売上管理システム</a>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item"><a class="nav-link active"
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

	<p class="fs-1">アカウント検索条件入力</p>
	<form>
		<div class="mb-3 row align-items-center">
			<label for="name" class="col-sm-1 col-form-label">氏名</label>
			<div class="col-sm-1">
				<h6>
					<span class="badge rounded-pill bg-secondary">部分一致</span>
				</h6>
			</div>
			<div class="col-sm-2">
				<input type="text" readonly class="form-control" id="name"
					placeholder="氏名">
			</div>
		</div>

		<div class="mb-3 row align-items-center">
			<label for="mail" class="col-sm-2 col-form-label">メールアドレス</label>
			<div class="col-sm-3">
				<input type="text" readonly class="form-control" id="mail"
					placeholder="メールアドレス">
			</div>
			<div class="col-sm-2"></div>
		</div>

		<div class="row justify-content-center">
			<div class="col-1">
				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="flexRadioDefault" id="flexRadioDefault2" checked> <label
						class="form-check-label" for="flexRadioDefault1">権限なし</label>
				</div>
			</div>
			<div class="col-2   width: 10%;">
				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="flexRadioDefault" id="flexRadioDefault1"> <label
						class="form-check-label" for="flexRadioDefault2">売上登録</label>
				</div>
			</div>
			<div class="col-3">
				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="flexRadioDefault" id="flexRadioDefault3"> <label
						class="form-check-label" for="flexRadioDefault3">アカウント登録
					</label>
				</div>
			</div>
		</div>

		<div class="row justify-content-center">
			<div class="col-md-2 width: 10%;">
				<button class="btn btn-primary" type="submit">🔍検索</button>
			</div>
			<div class="col-md-3">
				<a href="リンク" class="btn btn-light">クリア</a>
			</div>
		</div>
	</form>

</body>
</html>