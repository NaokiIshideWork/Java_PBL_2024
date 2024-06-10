<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>売上登録確認</title>
</head>
<body>
<div class="container position-absolute">
        <h2 class="mt-5" style="margin-left: 30px;">売上登録確認</h2>
        <div class="" style="margin-left:100px">
        <form class="text-right">
            <div class="row ">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">販売日</h3>
                </div>
                <div class="col-sm-8">
                <input type="date" name="#" class="form-control w-25" placeholder="Last name" aria-label="Last name" disabled>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">担当</h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <select class="form-select" aria-label="Default select example" disabled>
                        <option selected>選択してください</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">商品カテゴリー</h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <select class="form-select" aria-label="Default select example" disabled>
                        <option selected>選択してください</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">商品名</h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <input type="text" name="#" class="form-control" placeholder="商品名" disabled>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">単価</h3>
                </div>
                <div class="col-sm-8">
                <input type="text" name="#" class="form-control w-25" placeholder="単価" disabled>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">個数</h3>
                </div>
                <div class="col-sm-8">
                <input type="text" name="#" class="form-control w-25" placeholder="個数" disabled>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">小計</h3>
                </div>
                <div class="col-sm-8">
                <input type="text" name="#" class="form-control w-25" placeholder="個数" disabled>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">備考</h3>
                </div>
                <div class="col-sm-8">
                
                <textarea name="#" class="form-control w-75" id="exampleFormControlTextarea1" rows="5"placeholder="備考" disabled></textarea>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">    
                </div>
                <div class="col-sm-8" style="margin-left: 30px;">
                    <button type="button" class="btn btn-primary">✔OK</button>
                    <a class="btn btn-outline-secondary" href="#" role="button">キャンセル</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>