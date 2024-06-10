<%@ page language="java" contentType="text/html; charset=UTF-8"
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
</body>
</html>