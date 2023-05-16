<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <script type="text/javascript">
        // 자바스크립트에서 json 객체를 표현(자바스크립트의 사용자 정의 객체와 유사함)
        var person = {
                "name":"BTS",
                "age":"30",
                "subject":["자바","하둡","스프링"],
                "addr":{
                    "zip":"111-222",
                    "addr1":"인천시"
                },
                "history":[
                    {
                        "subject":"java",
                        "month":"11"
                    },
                    {
                        "subject":"자바스크립트",
                        "month":"12"
                    }
                ]
        }

        //person이 json object
        //json object의 속성은 객체.속성명 ->으로 접근
        //json array는 배열처럼 
        alert(person);
        document.write("<h3>"+person.name+"</h3>");
        document.write("<h3>"+person.age+"</h3>");
        document.write("<h3>"+person.addr+"</h3>");
        document.write("<h3>"+person.addr.zip+"</h3>");
        document.write("<h3>"+person.addr.addr1+"</h3>");
        document.write("<h3>"+person.subject[0]+"</h3>");
        document.write("<h3>"+person.subject[1]+"</h3>");
        document.write("<h3>"+person.history[0].subject+"</h3>");
        document.write("<h3>"+person.history[1].subject+"</h3>");
    </script>
</body>
</html>