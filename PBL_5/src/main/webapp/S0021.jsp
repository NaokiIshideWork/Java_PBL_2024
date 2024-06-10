<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <meta name="viewport" content="width=device-width, initial-scale=1">
 <link rel="stylesheet" href="./css/bootstrap.min.css"  text="text/css">
 
<title>Insert title here</title>
 
 
</head>
<body>
    <div class="container" class="text-left">
        <h2 class="mt-3" >売上検索結果表示</h2>
    </div>
    <div class="container text-left">
        <table class="table table-hover">
            <thead>
                <tr>
   
                    <th scope="col" class="col-md-1">操作</th>
                    <th scope="col" class="col-md-1">No</th>
                    <th scope="col" class="col-md-1">販売日</th>
                    <th scope="col" class="col-md-1">担当</th>
                    <th scope="col" class="col-md-2">商品カテゴリー</th>
                    <th scope="col" class="col-md-3">商品名</th>
                    <th scope="col" class="col-md-1">単価</th>
                    <th scope="col" class="col-md-1">個数</th>
                    <th scope="col" class="col-md-1">小計</th>
 
                </tr>
            </thead>
            <!-- <c:forEach var="obj" items="${list}"> -->
                <form action="#" method="post">
                    <tr>
                        <!-- <c:out value="${obj.getDate()}" /> -->
                        
                        <!-- 詳細ページに遷移 -->
                        <td class="col-md-1"><button type="button" class="btn btn-primary">✓ 詳細</button>
                        </td>
                        <td class="col-md-1">${obj.getNumber()}</td>
                        <td class="col-md-1">${obj.getSaleDay()}</td>
                        <td class="col-md-1">${obj.getTantou()}</td>
                        <td class="col-md-2">${obj.getCategory()}</td>
                        <td class="col-md-3">${obj.getName()}</td>
                        <td class="col-md-1">${obj.getPrice()}</td>
                        <td class="col-md-1">${obj.getQuantity()}</td>
                        <td class="col-md-1">${obj.getSubtotal()}</td>

                    </tr>
                </form>
               
   
            <!-- </c:forEach> -->
           
               
           
        </table>
    </div>
</body>
</html>
