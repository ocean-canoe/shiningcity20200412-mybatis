<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script src="${pageContext.request.contextPath }/js/jQuery/jquery-1.11.3.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/ECharts/echarts.min.js"></script>
<script type="text/javascript">
$(function(){
	$.ajax({
		type:"POST",
		url:"http://114.116.69.248:8082/jasperReport/jasper/workCountList",
		data:{},
		dataType:"json",//"text","html"
		success:function(data){
            console.log("success");
			console.log(data);
			//$.each(data,function(index,item){
			//	console.log(index);
			//	console.log(item);
			//})
		},
		error:function(){
            console.log("error");
        }
		
	})
	
	
})


</script>
</head>
<body>
value = ${value };

</body>
</html>