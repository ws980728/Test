<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<%
	pageContext.setAttribute("APP_PATH", request.getContextPath());
%>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${APP_PATH }/static/js/jquery-3.3.1.min.js"></script>
<link href="${APP_PATH }/static/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<script src="${APP_PATH }/static/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
<button class="btn btn-primary" id="ajaxTest">新增</button>
<script type="text/javascript">
$("#ajaxTest").click(function() {
	$.ajax({
		url: "https://www.baidu.com/?tn=93153557_hao_pg",//目标页面
		dataType: "html",
		type: "GET",
		cache: false,
		success: function(html)
		{
		console.log(html);
		}
		});
});
</script>
</body>
</html>