<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>訂單資料 - listOneOrder.jsp</title>

<style>
table {
	width: 800px;
	background-color: #CCCCFF;
	margin-top: 5px;
	margin-bottom: 10px;
	border: 2px solid #666;
}

table, th, td {
	border: 1px solid #999;
	border-collapse: collapse;
	padding: 5px;
}

th {
	background-color: #9999CC;
	color: white;
}
</style>

</head>
<body bgcolor='white'>

	<h3>訂單資料 (orderId = ${orderVO.orderId}):</h3>

	<table>
		<tr>
			<th>訂單編號</th>
			<th>會員編號</th>
			<th>員工編號</th>
			<th>優惠券編號</th>
			<th>訂單狀態</th>
			<th>入住日期</th>
			<th>退房日期</th>
			<th>總金額</th>
		</tr>
		<tr>
			<td>${orderVO.orderId}</td>
			<td>${orderVO.memberId}</td>
			<td>${orderVO.employeeId}</td>
			<td>${orderVO.couponId}</td>
			<td><c:choose>
					<c:when test="${orderVO.orderStatus == 0}">待付款</c:when>
					<c:when test="${orderVO.orderStatus == 1}">已確認</c:when>
					<c:when test="${orderVO.orderStatus == 2}">已完成</c:when>
					<c:when test="${orderVO.orderStatus == 3}">已取消</c:when>
					<c:otherwise>${orderVO.orderStatus}</c:otherwise>
				</c:choose></td>
			<td>${orderVO.checkInDate}</td>
			<td>${orderVO.checkOutDate}</td>
			<td>${orderVO.totalAmount}</td>
		</tr>
		<tr>
			<th>折扣金額</th>
			<th>實付金額</th>
			<th>商家交易編號</th>
			<th>綠界交易編號</th>
			<th>付款方式</th>
			<th>建立時間</th>
			<th>更新時間</th>
			<th></th>
		</tr>
		<tr>
			<td>${orderVO.discountAmount}</td>
			<td>${orderVO.paidAmount}</td>
			<td>${orderVO.merchantTradeNo}</td>
			<td>${orderVO.ecpayTradeNo}</td>
			<td>${orderVO.paymentMethod}</td>
			<td>${orderVO.createdTime}</td>
			<td>${orderVO.updatedTime}</td>
			<td></td>
		</tr>
	</table>
	<c:if test="${not empty oldOrder}">
		<h3>修改前後比對</h3>
		<table>
			<tr>
				<th>欄位</th>
				<th>修改前</th>
				<th>修改後</th>
			</tr>
			<tr>
				<td>訂單狀態</td>
				<td>${oldOrder.orderStatus}</td>
				<td>${orderVO.orderStatus}</td>
			</tr>
			<tr>
				<td>入住日期</td>
				<td>${oldOrder.checkInDate}</td>
				<td>${orderVO.checkInDate}</td>
			</tr>
			<tr>
				<td>退房日期</td>
				<td>${oldOrder.checkOutDate}</td>
				<td>${orderVO.checkOutDate}</td>
			</tr>
		</table>
	</c:if>
	<br>
	<a href="select_page.jsp">回查詢頁</a>
	<a href="order.do?action=getOne_for_Update&orderId=${orderVO.orderId}">修改</a>
</body>
</html>