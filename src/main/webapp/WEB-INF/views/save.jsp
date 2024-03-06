<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- 구글에서 ajzx.jquery 3버전용으로 가져옴 -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
<title>회원가입</title>
</head>
<body>
	<form action="/member/save" method="post">
		<!-- input type 종류 자세히 알아보기 -->
	    <!-- 데이터베이스  -->
		<p> 아 이 디 : <input type="text" name="memberEmail" placeholder="이메일" id="memberEmail" onblur="emailCheck()" /></p>
		<p id="check-result"></p>
		<p> 비밀번호 : <input type="text" name="memberPassword" placeholder="비밀번호" /></p>
		<p> 이   름 : <input type="text" name="memberName" placeholder="이름" /></p>
		<p> 나   이 : <input type="text" name="memberAge" placeholder="나이" /></p>
		<p> 전화번호 : <input type="text" name="memberMobile" placeholder="전화번호" /></p>
		<input type="submit" value="회원가입" />
	</form>
</body>

<script>
// 이메일 입력값을 가져오고,
// 입력값을 서버로 전송하고 똑같은 이메일이 있는지 체크한 후
// 사용 가능 여부를 이메일 입력창 아래에 표시
    const emailCheck = () => {
        const email = document.getElementById("memberEmail").value;
        const checkResult = document.getElementById("check-result");
        console.log("입력한 이메일", email);
        $.ajax({ // 화면의 일부분만을 변경하기 위해서 ajax를 사용한다.
            // 요청방식: post, url: "email-check", 데이터: 이메일
            type: "post",
            url: "/member/email-check",
            data: {
                "memberEmail": email
            },
            success: function(res) {
                console.log("요청성공", res);
                if (res == "ok") {
                    console.log("사용가능한 이메일");
                    checkResult.style.color = "green";
                    checkResult.innerHTML = "사용가능한 이메일";//innerHTML웹브라우저안에서 html내용을 바꿔주는 것
                } else {
                    console.log("이미 사용중인 이메일");
                    checkResult.style.color = "red";
                    checkResult.innerHTML = "이미 사용중인 이메일";
                }
            },
            error: function(err) {
                console.log("에러발생", err);
            }
        });
    }
</script>

</html>
















