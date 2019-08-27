<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="../">
<meta charset="UTF-8">
<title></title>
</head>
<body>
<script type="text/javascript">
function testajax(){
	$.ajax({
	    headers: {
	        'Content-Type': 'application/json'
	    },
	    type: "post",
	    url: "Book/sss.action",
	    data: JSON.stringify([{name:"a1"},{name:"a2"}]),
	    success: function (data) {
	    },
	    error: function (data) {
	    }
	});
}
</script>
<button onclick="testajax();">测试</button>
<form method="post" action="Book/sss.action" enctype="multipart/form-data">
<input type="file">
<input  name="name">

<input name="name">
<input type="submit">
</body>
</html>