<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
    a:link, a:hover, a:visited, a:active {
        color: #333;
        text-decoration: none;
    }

    div.grid {
        display: grid;
        grid-template-columns: 100px 1fr;
        grid-template-rows: 28px 28px 28px 380px 28px 28px 28px 1fr;
        row-gap: 10px;
        padding-right: 15px;
    }
    div.grid > div.btn-group {
        display: grid;
        grid-column: 1/3;
    }

    div.grid div.right-align{
        text-align: right;
    }

    label { 
        padding-left: 10px;

    }

    button, input, textarea {
        padding: 10px;
    }
</style>
</head>
<body>

<jsp:include page="../member/membermenu.jsp"></jsp:include>
    <h1>게시글 작성</h1>
    <div class="grid">

        <label for="subject">제목</label>
        <div>${boardVO.subject}</div>
        
        <label for="email">메일</label>
        <div>${boardVO.email}/${boardVO.ipAddr}</div>
        
        
        <label for="viewCnt">조회수</label>
        <div>${boardVO.viewCnt}</div>

        <label for="content">내용</label>
        <div>${boardVO.content}</div>
        
        <label for=file>첨부파일</label>
        <div>
        	<a href = "/board/file/download/${boardVO.id }">${boardVO.originFileName}</a> 
        </div>
        
        <label for=file>encrypted</label>
        <div>${boardVO.fileName}</div>
        
        
        <label for="crtDt">등록일</label>
        <div>${boardVO.crtDt}</div>

        <label for="mdfyDt">수정일</label>
        <div>${boardVO.mdfyDt}</div>
		<c:if text="${not empty sessionScope._LOGIN_USER_ && sessionScope._LOGIN_USER_.email eq boardVO.memberVO.email}">
		<!-- 세션 스콥 로그인 되어있는지, 세션 스콥의 유저와 글작성자가 같다면 확인 -->
	        <div class="btn-group">
	            <div class="right-align">
	                <a href="/board/modify/${boardVO.id}">수정</a>
	                <a href="/board/delete/${boardVO.id}">삭제</a>
	            </div>
	        </div>
        </c:if>
    </div>
</body>
</html>