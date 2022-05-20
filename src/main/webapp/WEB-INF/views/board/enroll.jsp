<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 등록 페이지</title>
</head>
<body>

	<h1>게시판 등록</h1>

	<form action="/board/enroll" method="post">

		<div class="input_wrap">
			<label>제목</label> <input name="title">
		</div>

		<div class="input_wrap">
			<label>내용</label>
			<textarea rows="3" name="content"></textarea>
		</div>

		<div class="input_wrap">
			<label>작성자</label> <input name="writer">
		</div>
		<!-- input 태그의 name속성과 VO클래스의 해당 변수명과 일치 시켜야 한다. -->
		
		<button class="btn">등록</button>

	</form>

</body>
</html>