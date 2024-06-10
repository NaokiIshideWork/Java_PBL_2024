<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="css/bootstrap.min.css" type="text/css">
<title>売上検索条件入力</title>
</head>
<body>

<div class="container">
  <h2 class="ml-5 mt-5 mb-1">売上検索条件入力</h2>

  <div class="row justify-content-center">
    <div class="col-8">
        <form class="text-center">
          <div class="row mb-3 justify-content-center">
            <div class="col-sm-4">
              <label for="salesDate" class="col-form-label">販売日</label>
            </div>
            
            <div class="col-sm-3">
              <input type="date" class="form-control" id="salesDate" name="salesDate">
            </div>
            ～
            <div class="col-sm-3">
              <input type="date" class="form-control" id="salesDate" name="salesDate">
            </div>
          </div>
          <div class="row mb-3 justify-content-center">
            <div class="col-sm-4">
              <label for="salesPerson" class="col-form-label">担当</label>
            </div>
            <div class="col-sm-6">
              <select class="form-control" id="salesPerson" name="salesPerson">
                <option value="">選択してください</option>
                <option value="斎藤">斎藤</option>
                <option value="高橋">高橋</option>
                <option value="山田">山田</option>
              </select>
            </div>
          </div>
          <div class="row mb-3 justify-content-center">
            <div class="col-sm-4">
              <label for="productCategory" class="col-form-label">商品カテゴリー</label>
            </div>
            <div class="col-sm-6">
              <select class="form-control" id="productCategory" name="productCategory">
                <option value="">選択してください</option>
                <option value="食品">食品</option>
                <option value="家電">家電</option>
                <option value="その他">その他</option>
              </select>
            </div>
          </div>
          <div class="row mb-3 justify-content-center">
            <div class="col-sm-4">
              <label for="productName" class="col-form-label">商品名 <span class="badge bg-secondary">部分一致</span></label>
            </div>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="productName" name="productName" placeholder="商品名">
            </div>
          </div>
          <div class="row mb-3 justify-content-center">
            <div class="col-sm-4">
              <label for="remarks" class="col-form-label">備考 <span class="badge bg-secondary">部分一致</span></label>
            </div>
            <div class="col-sm-6">
              <input type="text" class="form-control" id="remarks" name="remarks" placeholder="備考">
            </div>
          </div>
          <div class="row mb-3 justify-content-center">
            <div class="col-sm-2"></div>
            <div class="col-sm-4">
              <a type="submit" class="btn btn-primary btn-search">🔍検索</a>
              <button type="reset" class="btn btn-secondary btn-clear">クリア</button>
            </div>
          </div>
        </form>
    </div>
  </div>
</div>

<!-- Bootstrap JS (Optional) -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-33L5K/ez9oWsKy8jxQv0IUpSAXS2tkF/EAK+TM8f6L2sz/GbUqG+1uQuBkPWZhQz" crossorigin="anonymous"></script>
</body>
</html>
