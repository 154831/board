<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세</title>
<style type= "text/css">

    .grid {
        display: grid;
        grid-template-columns: 800px 800px;
        grid-auto-rows: repeat(10, 40px) ;
        column-gap: 30px ;
    }


</style>
</head>
<body>
    <div class="detail_container grid">
        <div>
            <img>
            <div>
                <img>
                <img> 
                <img>
                <img>
            </div>
        </div>
        <div class="grid_2">
            <div class="productName">진도 홍망고 1.5kg</div>
            <div class="orign">원산지</div>
            <div class="productPrice">48,900원</div>
            <div class="rate">★4.9(11) + 판매자 닉네임</div>
            <div class="delivery_info">
                <div>배송비</div>
                <div>무료배송</div>
                <div>배송 옵션 안내</div>
            </div>
            <div class="selectBox">
                <select name="option" class="option">
                    <option disabled selected>옵션 선택</option>
                    <option value="option1">옵션1</option>
                    <option value="option2">옵션2</option>
                </select>
            </div>>
            <div class=""
        </div>
        
    </div>

</body>
</html>