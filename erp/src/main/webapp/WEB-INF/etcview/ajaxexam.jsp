<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	$(document).ready(
			function() {
				//id가  testbtn인 버튼을 눌렀을 때 /erp/ajax/exam01요청
				//json object가 response
				$("#testbtn").on("click", function() {
					var querydata = {
						"boardno" : $("#boardno").val()
					}
					$.ajax({
						url : "/erp/ajax/exam01",
						type : "get",
						data : querydata,
						dataType : "json",//응답되는 데이터의 종류
						success : function(data) {
							//alert(data)
							//alert(data.title+","+data.content)
							$("#title").text(data.board_no);
							$("#no").text(data.title);
							$("#writer").text(data.id);
							$("#content").text(data.content);

						},
						error : error_run
					})
				})
				//it가 testjsonbtn을 눌렀을 때 /erp/ajax/exam02/getjsondata를 요청
				//===>json array가 response id가 printarr인 div에 내용을 출력

				$("#testjsonbtn").on(
						"click",
						function() {
							$.ajax({
								url : "/erp/ajax/exam02/getjsondata",
								type : "get",
								dataType : "json",
								success : function(data) {
									var printdata = "";
									for (i = 0; i < data.length; i++) {
										printdata = printdata + data[i].id
												+ "," + data[i].title + "<br/>"
									}
									//console.log(printdata)
									$("#printarr").html(printdata);
								},
								error : error_run
							})
						})
			})
	function error_run(obj, msg, statusMsg) {
		alert("오류발생~~~~" + obj + "," + msg + "," + statusMsg)
	}
</script>
</head>
<body>
	<form>
		글번호:<input type="text" name="boardno" id="boardno" /> <input
			type="button" value="ajax테스트" id="testbtn" /> <input type="button"
			value="ajaxjson테스트" id="testjsonbtn" />
	</form>
	<div id="result">
		<h4>
			글번호:<span id="no"></span>
		</h4>
		<h4>
			제목:<span id="title"></span>
		</h4>
		<h4>
			작성자:<span id="writer"></span>
		</h4>
		<h4>
			내용:<span id="content"></span>
		</h4>
	</div>
	<div id="printarr"></div>
</body>
</html>