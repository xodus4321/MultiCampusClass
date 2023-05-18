<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<script type="text/javascript">
		$(document).ready(function(){
			$("#noajaxbtn").on("click",function(){
				location.href="/erp/ajax/noajax?id="+$("#id1").val()
			})		
			$("#ajaxbtn").on("click", function() {
				//ajax요청하기
				var querydata = {"id":$("#id1").val()}
				$.ajax({
					url:"/erp/ajax/ajaxtest01",
					type:"get",
					data:querydata,
					success:success_run,
					error:error_run
					
				})//end ajax
			})//end click
		})//end readh
		//ajax요청이 성공하면 success_run이 자동으로 호출되면 서버의 실행 결과가 success_run의 매개변수로 전달이 된다.
		function success_run(data){
			//alert(data);		
			//요청이 성공하면 서버에서 전달한 데이터를 이용해서 원하는 위치에 데이터를 출력하기
			$("#result").html("<h2>jquery:"+data+"</h2>");
		}
		//에러가 발생하면 호출되는 메소드
		//obj - XMLHttpRequest객체, msg - 응답메시지, statusMsg-에러메시지
		function error_run(obj,msg,statusMsg) {
			alert("오류발생~~~~"+obj+","+msg+","+statusMsg)
		}
		$(document).ready(function () {
			$("#guguajaxbtn").on("click",function(){
				var querydata = {"dan":$("#dan").val()}
					$.ajax({
						url:"/erp/ajax/gugu",
						type:"get",
						data:querydata,
						success:success_gugu_run,
						//ajax로 요청하는 경우 response 되는 데이터느 ㄴ무조건 success에서 실행되는 함수
						//내부에서만 사용할 수 있다.
						error:error_gugu_run
						//ajax요청이 실패하는 경우 화면ㅇㄹ 비어둘 수 없으므로 실패항 경우 만들어질 페이지를 출력
				})//end ajax
			})
		})
		function success_gugu_run(data){
			$("#result2").html(data);
		}
		//에러가 발생하면 호출되는 메소드
		//obj - XMLHttpRequest객체, msg - 응답메시지, statusMsg-에러메시지
		function error_gugu_run(obj,msg,statusMsg) {
			alert("실패")
		}
	
</script>
<title>Insert title here</title>
</head>
<body>
	<h3>Ajax테스트하기</h3>
	<form name="myform">
		<input type="text" name="id" id="id1"/>
		<input type="text" name="name" id="name"/>
		<input type="button" id="noajaxbtn" value="no aajx테스트">
		<input type="button" id="ajaxbtn" value="ajax테스트">
	</form>
	<div id="result">${msg }</div>
	
	<h3>구구단 출력하기</h3>
	<form name="myform">
		<input type="text" name="id" id="dan"/>
		<input type="button" id="guguajaxbtn" value="구구단출력">
	</form>
	<div id="result2"></div>


	<h3>Ajax테스트하기(JQuery...post)</h3>
	<form name="myform">
		<input type="text" name="id" id="id3"/>
		<input type="button" id="ajaxbtn3" value="ajax테스트">
	</form>
	<div id="result3"></div>
</body>
</html>