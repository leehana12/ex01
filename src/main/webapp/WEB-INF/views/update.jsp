<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정</title>
</head>
<body>
	<form action="/member/update" method="post" name="updateForm">
		<!-- input type 종류 자세히 알아보기 -->
	    <!-- 데이터베이스  -->
		<p> 아 이 디 : <input type="text" name="id" value="${member.id}" readonly /></p><!-- readonly는 수정을 못하게 하는 것이다. -->
		<p> 이 메 일 : <input type="text" name="memberEmail" value="${member.memberEmail}" readonly /></p>
		<!-- 패스워드가맞을때만 수정이 가능하도록 할것이기 떄문에 비밀번호를 알수 없도록 value값을 가져 오지 않음 -->
		<p> 비밀번호 : <input type="text" name="memberPassword" id="memberPassword" /></p> 
		<p> 이   름 : <input type="text" name="memberName" value="${member.memberName}" readonly /></p>
		<p> 나   이 : <input type="text" name="memberAge" value="${member.memberAge}"  /></p>
		<p> 전화번호 : <input type="text" name="memberMobile" value="${member.memberMobile}" /></p>
		<input type="button" value="수정" onclick="update()" /><!-- onclick은 클릭을 할때 자바스크립트를 불러오겠다는것 -->
	</form>
</body>

<!-- 자바스크립트의 단점은 웹브라우저에서 소스보기로 모든 정보를 볼 수 있기 때문에 이방법의 사용은 위험하다. -->
<!-- 리엑트에서는 자바스크립트를 써도 소스정보를 볼 수 없다. 컴파일러를 시키기 때문에 볼수 없는 것이다. -->
<script>
    const update = () => {
        const passwordDB = '${member.memberPassword}';
        const password = document.getElementById("memberPassword").value;
        if (passwordDB == password) {
            document.updateForm.submit();
        } else {
            alert("비밀번호가 일치하지 않습니다!");
        }
    }
</script>
</html>