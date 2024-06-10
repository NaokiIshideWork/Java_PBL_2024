<%@ page language="java" contentType="text/html; charset=UTF-8"
<<<<<<< HEAD
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="ja">
<head>
<meta charset="UTF-8">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="./css/bootstrap.min.css" text="text/css">
<title>フォーム</title>
</head>
<body>
	<div class="container position-absolute">
		<h2 class="mt-5" style="margin-left: 30px;">アカウントを登録してよろしいでしょうか</h2>
		<div class="" style="margin-left: 100px">
			<form class="text-right">
				<div class="row ">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							氏名<span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="text" name="#" class="form-control"
							placeholder="メールアドレス">
					</div>
				</div>


				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							メールアドレス<span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="email" name="#" class="form-control"
							placeholder="メールアドレス">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							パスワード<span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="password" name="#" class="form-control "
							placeholder="パスワード">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							パスワード確認<span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8 w-50">
						<input type="password" name="#" class="form-control "
							placeholder="パスワード">
					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3">
						<h3 for="inputEmail" class="col-form-label"
							style="text-align: end;">
							権限<span class="badge rounded-pill bg-secondary">必須</span>
						</h3>
					</div>
					<div class="col-sm-8" style="margin-top: 10px;">

						<input type="radio" name="flexRadioDefault" id="flexRadioDefault1">
						<label for="flexRadioDefault1"> 権限なし </label> <input type="radio"
							name="flexRadioDefault" id="flexRadioDefault1"> <label
							for="flexRadioDefault1"> 参照 </label> <input type="radio"
							name="flexRadioDefault" id="flexRadioDefault1"> <label
							for="flexRadioDefault1"> 更新 </label>

					</div>
				</div>
				<div class="row mt-3">
					<div class="col-sm-3"></div>
					<div class="col-sm-8">
						<button type="button" class="btn btn-primary"
							style="margin-left: 30px;">O K</button>
						<a class="btn btn-outline-secondary" href="#" role="button">キャンセル</a>
					</div>
				</div>
			</form>
		</div>
	</div>
=======
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<meta charset="UTF-8">
<title>アカウント登録確認</title>
</head>
<body>
	<div class="row ">
		<div class="col-sm-2">
			<h3 for="inputEmail" class="col-form-label" style="text-align: end;">氏名</h3>
		</div>
		<div class="col-sm-8">
			<input type="text" name="#" class="form-control w-25"
				placeholder="氏名" aria-label="Last name" disabled>
		</div>
	</div>

	<div class="row ">
		<div class="col-sm-2">
			<h3 for="inputEmail" class="col-form-label" style="text-align: end;">メールアドレス</h3>
		</div>
		<div class="col-sm-8">
			<input type="email" name="#" class="form-control w-25"
				placeholder="メールアドレス" aria-label="Last name" disabled>
		</div>
	</div>

	<div class="row ">
		<div class="col-sm-2">
			<h3 for="inputEmail" class="col-form-label" style="text-align: end;">パスワード</h3>
		</div>
		<div class="col-sm-8">
			<input type="password" name="#" class="form-control w-25"
				placeholder="パスワード" aria-label="Last name" disabled>
		</div>
	</div>

	<div class="row ">
		<div class="col-sm-2">
			<h3 for="inputEmail" class="col-form-label" style="text-align: end;">パスワード（確認）</h3>
		</div>
		<div class="col-sm-8">
			<input type="password" name="#" class="form-control w-25"
				placeholder="パスワード（確認）" aria-label="Last name" disabled>
		</div>
	</div>
	
	<div class="form-group">
        <div class="form-check form-check-inline">
        
          権限<input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio1" value="option1">
          <label class="form-check-label" for="inlineRadio1">権限なし</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio2" value="option2">
          <label class="form-check-label" for="inlineRadio2">参照</label>
        </div>
        <div class="form-check form-check-inline">
          <input class="form-check-input" type="radio" name="inlineRadioOptions" id="inlineRadio3" value="option3">
          <label class="form-check-label" for="inlineRadio3">更新</label>
        </div>
      </div>

	<button type="submit" >✓登録</button>
>>>>>>> branch 'main' of https://github.com/NaokiIshideWork/Java_PBL_2024.git
</body>
</html>