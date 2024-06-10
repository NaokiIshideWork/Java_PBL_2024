<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">
<title>売上詳細表示</title>
</head>
<body>

	<div class="container position-absolute">
		<h2 class="mt-5" style="margin-left: 100px;">売上詳細表示</h2>
		<div class="" style="margin-left: 100px">
			<form class="text-right">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">販売日</h3>
					</div>
					<div class="col-sm-8">
						<p class="text-start" style="margin-top: 5px">2015/1/15</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">担当</h3>
					</div>
					<div class="col-sm-8">
						<p class="text-start" style="margin-top: 5px">イチロー</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">商品カテゴリー</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="text-start" style="margin-top: 5px">食料品</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">商品名</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="text-start" style="margin-top: 5px">からあげ弁当</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">単価</h3>
					</div>
					<div class="col-sm-8 w-50">
						<p class="text-start" style="margin-top: 5px">450</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">個数</h3>
					</div>
					<div class="col-sm-8">
						<p class="text-start" style="margin-top: 5px">3</p>
					</div>
				</div>

				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">備考</h3>
					</div>
					<div class="col-sm-8">
						<p class="text-start" style="margin-top: 5px">3</p>
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3"></div>
					<div class="col-sm-8">
						<button type="button" class="btn btn-primary"
							style="margin-left: 30px;">✔編集</button>
						<a type="submit" class="btn btn-danger btn-search">✕削除</a>
						<a class="btn btn-outline-secondary" href="#" role="button">キャンセル</a>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>
</html>