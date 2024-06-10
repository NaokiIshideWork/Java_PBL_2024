<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>売上詳細編集</title>
</head>
<body>
<div class="container position-absolute">
        <h2 class="mt-5" style="margin-left: 30px;">売上詳細編集</h2>
        <div class="" style="margin-left:100px">
        <form class="text-right">
            <div class="row ">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">販売日<span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8">
                <input type="date" name="#" class="form-control w-25" placeholder="Last name" aria-label="Last name">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">担当<span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <select class="form-select" aria-label="Default select example">
                        <option selected>選択してください</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">商品カテゴリー<span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <select class="form-select" aria-label="Default select example">
                        <option selected>選択してください</option>
                        <option value="1">One</option>
                        <option value="2">Two</option>
                        <option value="3">Three</option>
                      </select>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label"style="text-align: end;">商品名<span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8 w-50" >
                    <input type="text" name="#" class="form-control" placeholder="商品名">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">単価<span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8">
                <input type="text" name="#" class="form-control w-25" placeholder="単価">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">個数<span class="badge rounded-pill bg-secondary">必須</span></h3>
                </div>
                <div class="col-sm-8">
                <input type="text" name="#" class="form-control w-25" placeholder="個数">
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">
                    <h3 for="inputEmail" class="col-form-label" style="text-align: end;">備考</h3>
                </div>
                <div class="col-sm-8">
                
                <textarea name="#" class="form-control w-75" id="exampleFormControlTextarea1" rows="5"placeholder="備考"></textarea>
                </div>
            </div>
            <div class="row mt-3">
                <div class="col-sm-2">    
                </div>
                <div class="col-sm-8" style="margin-left: 30px;">
                    <button type="button" class="btn btn-primary">✔更 新</button>
                    <a class="btn btn-outline-secondary" href="#" role="button">キャンセル</a>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>