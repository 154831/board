<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 목록</title>
<style type= "text/css">
    
    .menu {
        width: 100%;
        height: 150px;
        background-color: antiquewhite;
        text-align: center;
        align-self: baseline;
    }

    
    </style>
</head>

<header> 
    <div class="menu">메뉴</div>

</header>

<body>
    <div class="container">
        <div class="search">
            <input type="text" id="search" placeholder="상품 검색"> 
        </div>
        <div class="search_icon">icon</div>
    </div>
    <div class="container">
        <div class="selction_with_arrows">
            <div id="title">베스트 상품</div>
            <div id="left_arrow">&#60;</div>
            <div id="item">
                <img/>
                <div class="productName">진도 홍망고 1.5Kg</div>
                <div class="price">48,900원</div>
                <div class="rate">★ 4.9 (11)</div>
            </div>
            <div id="item">
                <img/>
                <div class="productName">productName</div>
                <div class="productPrice">productPrice</div>
                <div class="rate">rate(rate_cnt)</div>
            </div>
            <div id="item">
                <img/>
                <div class="productName">productName</div>
                <div class="productPrice">productPrice</div>
                <div class="rate">rate(rate_cnt)</div>
            </div>
            <div id="right_arrow">&#62;</div>
        </div>
        
        <div class="selction_all">
        	<div id="item">
                <img/>
                <div class="productName">productName</div>
                <div class="productPrice">productPrice</div>
                <div class="rate">rate(rate_cnt)</div>
            </div>
        	<div id="item">                <img/>
                <div class="productName">productName</div>
                <div class="productPrice">productPrice</div>
                <div class="rate">rate(rate_cnt)</div></div>
        	<div id="item">
                <img/>
                <div class="productName">productName</div>
                <div class="productPrice">productPrice</div>
                <div class="rate">rate(rate_cnt)</div>
            </div>
        	<div id="item">
                <img/>
                <div class="productName">productName</div>
                <div class="productPrice">productPrice</div>
                <div class="rate">rate(rate_cnt)</div>
            </div>
        	<div id="item">
                <img/>
                <div class="productName">productName</div>
                <div class="productPrice">productPrice</div>
                <div class="rate">rate(rate_cnt)</div>
            </div>
        	<div id="item">                <img/>
                <div class="productName">productName</div>
                <div class="productPrice">productPrice</div>
                <div class="rate">rate(rate_cnt)</div></div>
        </div>

        <div>더보기</div>
    </div>


</body>

</html>