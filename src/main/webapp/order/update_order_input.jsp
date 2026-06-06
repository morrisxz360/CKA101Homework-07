<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>修改訂單 - update_order_input.jsp</title>
<style>
table { width: 600px; background-color: #CCCCFF; margin: 5px 0; border: 2px solid #666; }
table, th, td { border: 1px solid #999; border-collapse: collapse; padding: 5px; }
th { background-color: #9999CC; color: white; }
</style>
</head>
<body bgcolor="white">

<h3>修改訂單 (訂單編號: ${orderVO.orderId})</h3>

<%-- 錯誤訊息區 --%>
<c:if test="${not empty errorMsgs}">
    <ul style="color:red">
        <c:forEach var="msg" items="${errorMsgs}">
            <li>${msg}</li>
        </c:forEach>
    </ul>
</c:if>

<%-- 唯讀顯示區:員工看得到但不能改 --%>
<table>
    <tr><th>會員編號</th><td>${orderVO.memberId}</td>
        <th>員工編號</th><td>${orderVO.employeeId}</td></tr>
    <tr><th>總金額</th><td>${orderVO.totalAmount}</td>
        <th>實付金額</th><td>${orderVO.paidAmount}</td></tr>
    <tr><th>折扣金額</th><td>${orderVO.discountAmount}</td>
        <th>付款方式</th><td>${orderVO.paymentMethod}</td></tr>
    <tr><th>商家交易編號</th><td>${orderVO.merchantTradeNo}</td>
        <th>綠界交易編號</th><td>${orderVO.ecpayTradeNo}</td></tr>
    <tr><th>建立時間</th><td>${orderVO.createdTime}</td>
        <th>更新時間</th><td>${orderVO.updatedTime}</td></tr>
</table>

<hr>

<%-- 可編輯區 --%>
<form method="post" action="order.do">

    訂單狀態:
    <select name="orderStatus">
        <option value="0" ${orderVO.orderStatus == 0 ? 'selected' : ''}>0 待付款</option>
        <option value="1" ${orderVO.orderStatus == 1 ? 'selected' : ''}>1 已確認</option>
        <option value="2" ${orderVO.orderStatus == 2 ? 'selected' : ''}>2 已完成</option>
        <option value="3" ${orderVO.orderStatus == 3 ? 'selected' : ''}>3 已取消</option>
    </select>
    <br><br>

    入住日期:
    <input type="date" name="checkInDate" value="${orderVO.checkInDate}">
    <br><br>

    退房日期:
    <input type="date" name="checkOutDate" value="${orderVO.checkOutDate}">
    <br><br>

    <input type="hidden" name="orderId" value="${orderVO.orderId}">
    <input type="hidden" name="action" value="update">
    <input type="submit" value="送出修改">
</form>

</body>
</html>