<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	/* /^: 以什么开始 
	 * $/: 以什么结束
	 * []: 中的内容为可选字符集。eg：[a-zA-Z0-9]表示a到z,或者A到Z,或者0到9
	 * {n}: 前面的内容出现n次
	 * {n,m}: 前面的内容出现n~m次
	 * \w: 用于匹配字母,数字或下划线字符。eg:/^(\w){6,20}$/表示6-20个字母、数字、下划线
	 * \d: 用于匹配从0到9的数字； 
	 * *: 前面的内容出现0到正无穷次
	 * +: 前面的内容出现1到正无穷次
	 * ?: 前面的内容出现零次或一次
	 * 
	 * 只能输入中的正则表达式: /^[\u4E00-\u9FA5]+$/
	 */
	var str = 11;
	var reg = /^\d+$/;
	alert(reg.test(str));
</script>
</head>
<body>

</body>
</html>