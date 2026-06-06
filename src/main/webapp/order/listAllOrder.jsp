<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<title>所有訂單 - listAllOrder.jsp</title>
<style>
table {
	background-color: #CCCCFF;
	border: 2px solid #666;
	border-collapse: collapse;
}

th, td {
	border: 1px solid #999;
	padding: 5px;
	text-align: center;
}

th {
	background-color: #9999CC;
	color: white;
}
</style>
</head>
<body bgcolor="white">

	<h3>所有訂單</h3>

	<jsp:useBean id="ordSvc" scope="page"
		class="com.order.service.OrderService" />

	<table>
		<tr>
			<th>訂單編號</th>
			<th>會員編號</th>
			<th>訂單狀態</th>
			<th>入住日期</th>
			<th>退房日期</th>
			<th>總金額</th>
			<th>實付金額</th>
			<th>修改</th>
			<th>刪除</th>

		</tr>
		<c:forEach var="orderVO" items="${ordSvc.all}">
			<tr>
				<td>${orderVO.orderId}</td>
				<td>${orderVO.memberId}</td>
				<td><c:choose>
						<c:when test="${orderVO.orderStatus == 0}">待付款</c:when>
						<c:when test="${orderVO.orderStatus == 1}">已確認</c:when>
						<c:when test="${orderVO.orderStatus == 2}">已完成</c:when>
						<c:when test="${orderVO.orderStatus == 3}">已取消</c:when>
					</c:choose></td>
				<td>${orderVO.checkInDate}</td>
				<td>${orderVO.checkOutDate}</td>
				<td>${orderVO.totalAmount}</td>
				<td>${orderVO.paidAmount}</td>
				<td><a
					href="order.do?action=getOne_for_Update&orderId=${orderVO.orderId}">修改</a></td>
				
				<td><a href="order.do?action=delete&orderId=${orderVO.orderId}"
					onclick="return confirm('確定刪除訂單 ${orderVO.orderId}?')">刪除</a></td>
			</tr>
		</c:forEach>
	</table>

	<br>
	<a href="select_page.jsp">回查詢頁</a>
	<a href="addOrder.jsp">新增訂單</a>

</body>
</html>