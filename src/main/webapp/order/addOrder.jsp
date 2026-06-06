<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新增訂單 - addOrder.jsp</title>
</head>
<body bgcolor="white">

<h3>新增訂單</h3>

<%-- 錯誤訊息區 --%>
<c:if test="${not empty errorMsgs}">
    <ul style="color:red">
        <c:forEach var="msg" items="${errorMsgs}">
            <li>${msg}</li>
        </c:forEach>
    </ul>
</c:if>

<form method="post" action="order.do">

    會員編號: <input type="text" name="memberId" value="${orderVO.memberId}"><br><br>

    員工編號: <input type="text" name="employeeId" value="${orderVO.employeeId}"><br><br>

    優惠券編號(可空): <input type="text" name="couponId" value="${orderVO.couponId}"><br><br>

    訂單狀態:
    <select name="orderStatus">
        <option value="0" ${orderVO.orderStatus == 0 ? 'selected' : ''}>0 待付款</option>
        <option value="1" ${orderVO.orderStatus == 1 ? 'selected' : ''}>1 已確認</option>
        <option value="2" ${orderVO.orderStatus == 2 ? 'selected' : ''}>2 已完成</option>
        <option value="3" ${orderVO.orderStatus == 3 ? 'selected' : ''}>3 已取消</option>
    </select><br><br>

    付款方式:
    <select name="paymentMethod">
        <option value="0" ${orderVO.paymentMethod == 0 ? 'selected' : ''}>0 信用卡</option>
        <option value="1" ${orderVO.paymentMethod == 1 ? 'selected' : ''}>1 線上</option>
        <option value="2" ${orderVO.paymentMethod == 2 ? 'selected' : ''}>2 現金</option>
    </select><br><br>

    入住日期: <input type="date" name="checkInDate" value="${orderVO.checkInDate}"><br><br>

    退房日期: <input type="date" name="checkOutDate" value="${orderVO.checkOutDate}"><br><br>

    總金額: <input type="text" name="totalAmount" value="${orderVO.totalAmount}"><br><br>

    折扣金額: <input type="text" name="discountAmount" value="${orderVO.discountAmount}"><br><br>

    實付金額: <input type="text" name="paidAmount" value="${orderVO.paidAmount}"><br><br>

    <input type="hidden" name="action" value="insert">
    <input type="submit" value="新增訂單">
    <a href="select_page.jsp">回首頁</a>
</form>
	
</body>
</html>