<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<meta charset="UTF-8">
<title>アカウント登録</title>
</head>
<body>
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
						class="form-check-label" for="flexRadioDefault1"> 権限なし </label>
				</div>
			</div>
			<div class="col-2   width: 10%;">
				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="flexRadioDefault" id="flexRadioDefault1"> <label
						class="form-check-label" for="flexRadioDefault2"> 売上登録 </label>
				</div>
			</div>
			<div class="col-3">
				<div class="form-check">
					<input class="form-check-input" type="radio"
						name="flexRadioDefault" id="flexRadioDefault3"> <label
						class="form-check-label" for="flexRadioDefault3"> アカウント登録
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