package com.order.controller;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import com.order.model.OrderVO;
import com.order.service.OrderService;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/order/order.do")
public class OrderServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		doPost(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		String action = req.getParameter("action");

		if ("getOne_For_Display".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();

			req.setAttribute("errorMsgs", errorMsgs);

			// 第一次檢查
			String str = req.getParameter("orderId");
			if (str == null || (str.trim()).length() == 0) {
				errorMsgs.add("請輸入訂單編號");
			}

			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			Integer orderId = null;
			// 第二次檢查
			try {

				orderId = Integer.valueOf(str);

			} catch (Exception e) {
				errorMsgs.add("訂單編號格式不正確");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			OrderService ordSvc = new OrderService();
			OrderVO orderVO = ordSvc.getOneOrder(orderId);

			if (orderVO == null) {
				errorMsgs.add("查無資料");
			}
			if (!errorMsgs.isEmpty()) {
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;
			}
			req.setAttribute("orderVO", orderVO);
			String url = "/order/listOneOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);

		}

		if ("getOne_for_Update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			String str = req.getParameter("orderId");
			if (str == null || str.trim().length() == 0) {
				errorMsgs.add("請選擇要修改的訂單");
				RequestDispatcher failureView = req.getRequestDispatcher("/order/select_page.jsp");
				failureView.forward(req, res);
				return;
			}

			Integer orderId = Integer.valueOf(str.trim());

			OrderService orderSvc = new OrderService();
			OrderVO orderVO = orderSvc.getOneOrder(orderId);

			req.setAttribute("orderVO", orderVO);
			String url = "/order/update_order_input.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("update".equals(action)) {

			List<String> errorMsgs = new LinkedList<String>();
			req.setAttribute("errorMsgs", errorMsgs);

			Integer orderId = Integer.valueOf(req.getParameter("orderId").trim());

			String orderStatusStr = req.getParameter("orderStatus");
			String statusReg = "^[0-3]$";
			Byte orderStatus = null;
			if (orderStatusStr == null || orderStatusStr.trim().length() == 0) {
				errorMsgs.add("訂單狀態: 請勿空白");
			} else if (!orderStatusStr.trim().matches(statusReg)) {
				errorMsgs.add("訂單狀態: 只能是 0(pending)、1(confirmed)、2(completed)、3(canceled)");
			} else {
				orderStatus = Byte.valueOf(orderStatusStr.trim());
			}

			java.sql.Date checkInDate = null;
			try {
				checkInDate = java.sql.Date.valueOf(req.getParameter("checkInDate").trim());
			} catch (Exception e) {
				checkInDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入入住日期!");
			}

			java.sql.Date checkOutDate = null;
			try {
				checkOutDate = java.sql.Date.valueOf(req.getParameter("checkOutDate").trim());
			} catch (Exception e) {
				checkOutDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入退房日期!");
			}

			if (checkOutDate.before(checkInDate)) {
				errorMsgs.add("退房日期不能早於入住日期");
			}

			OrderService orderSvc = new OrderService();
			OrderVO oldOrder = orderSvc.getOneOrder(orderId);

			long oldNights = (oldOrder.getCheckOutDate().getTime() - oldOrder.getCheckInDate().getTime())
					/ (1000 * 60 * 60 * 24);
			long newNights = (checkOutDate.getTime() - checkInDate.getTime()) / (1000 * 60 * 60 * 24);

			if (oldNights != newNights) {
				errorMsgs.add("只能平移日期,住宿天數必須維持 " + oldNights + " 晚");
			}

			OrderVO orderVO = new OrderVO();
			orderVO.setOrderId(orderId);
			orderVO.setOrderStatus(orderStatus);
			orderVO.setCheckInDate(checkInDate);
			orderVO.setCheckOutDate(checkOutDate);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("orderVO", orderVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/order/update_order_input.jsp");
				failureView.forward(req, res);
				return;
			}

			orderSvc.updateOrder(orderId, orderStatus, checkInDate, checkOutDate);

			// 重新撈出更新後的訂單
			OrderVO newOrder = orderSvc.getOneOrder(orderId);

			req.setAttribute("oldOrder", oldOrder); // 修改前(你前面已撈)
			req.setAttribute("orderVO", newOrder); // 修改後,完整資料

			String url = "/order/listOneOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("insert".equals(action)) {
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			// 會員編號 (必填)
			String memberIdStr = req.getParameter("memberId");
			Integer memberId = null;
			if (memberIdStr == null || memberIdStr.trim().length() == 0) {
				errorMsgs.add("會員編號: 請勿空白");
			} else {
				try {
					memberId = Integer.valueOf(memberIdStr.trim());
				} catch (Exception e) {
					errorMsgs.add("會員編號: 請填數字");
				}
			}

			// 員工編號 (必填)
			String employeeIdStr = req.getParameter("employeeId");
			Integer employeeId = null;
			if (employeeIdStr == null || employeeIdStr.trim().length() == 0) {
				errorMsgs.add("員工編號: 請勿空白");
			} else {
				try {
					employeeId = Integer.valueOf(employeeIdStr.trim());
				} catch (Exception e) {
					errorMsgs.add("員工編號: 請填數字");
				}
			}

			// 優惠券編號 (選填)
			String couponIdStr = req.getParameter("couponId");
			Integer couponId = null;
			if (couponIdStr != null && couponIdStr.trim().length() > 0) {
				try {
					couponId = Integer.valueOf(couponIdStr.trim());
				} catch (Exception e) {
					errorMsgs.add("優惠券編號: 請填數字");
				}
			}

			// 訂單狀態 (必填, 0~3)
			String orderStatusStr = req.getParameter("orderStatus");
			Byte orderStatus = null;
			if (orderStatusStr == null || orderStatusStr.trim().length() == 0) {
				errorMsgs.add("訂單狀態: 請勿空白");
			} else if (!orderStatusStr.trim().matches("^[0-3]$")) {
				errorMsgs.add("訂單狀態: 只能是 0~3");
			} else {
				orderStatus = Byte.valueOf(orderStatusStr.trim());
			}

			// 付款方式 (必填)
			String paymentMethodStr = req.getParameter("paymentMethod");
			Byte paymentMethod = null;
			if (paymentMethodStr == null || paymentMethodStr.trim().length() == 0) {
				errorMsgs.add("付款方式: 請勿空白");
			} else if (!paymentMethodStr.trim().matches("^[0-2]$")) {
				errorMsgs.add("付款方式: 數值不正確");
			} else {
				paymentMethod = Byte.valueOf(paymentMethodStr.trim());
			}

			// 入住日期 (必填)
			java.sql.Date checkInDate = null;
			try {
				checkInDate = java.sql.Date.valueOf(req.getParameter("checkInDate").trim());
			} catch (Exception e) {
				checkInDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入入住日期!");
			}

			// 退房日期 (必填)
			java.sql.Date checkOutDate = null;
			try {
				checkOutDate = java.sql.Date.valueOf(req.getParameter("checkOutDate").trim());
			} catch (Exception e) {
				checkOutDate = new java.sql.Date(System.currentTimeMillis());
				errorMsgs.add("請輸入退房日期!");
			}

			// 退房要晚於入住 (至少 1 晚)
			if (!checkOutDate.after(checkInDate)) {
				errorMsgs.add("退房日期必須晚於入住日期");
			}

			// 金額三欄 (必填)
			Integer totalAmount = null;
			String totalAmountStr = req.getParameter("totalAmount");
			if (totalAmountStr == null || totalAmountStr.trim().length() == 0) {
				errorMsgs.add("總金額: 請勿空白");
			} else {
				try {
					totalAmount = Integer.valueOf(totalAmountStr.trim());
				} catch (Exception e) {
					errorMsgs.add("總金額: 請填數字");
				}
			}

			Integer discountAmount = null;
			String discountAmountStr = req.getParameter("discountAmount");
			if (discountAmountStr == null || discountAmountStr.trim().length() == 0) {
				errorMsgs.add("折扣金額: 請勿空白");
			} else {
				try {
					discountAmount = Integer.valueOf(discountAmountStr.trim());
				} catch (Exception e) {
					errorMsgs.add("折扣金額: 請填數字");
				}
			}

			Integer paidAmount = null;
			String paidAmountStr = req.getParameter("paidAmount");
			if (paidAmountStr == null || paidAmountStr.trim().length() == 0) {
				errorMsgs.add("實付金額: 請勿空白");
			} else {
				try {
					paidAmount = Integer.valueOf(paidAmountStr.trim());
				} catch (Exception e) {
					errorMsgs.add("實付金額: 請填數字");
				}
			}

			// 實付 = 總額 - 折扣
			if (totalAmount != null && discountAmount != null && paidAmount != null
					&& paidAmount != totalAmount - discountAmount) {
				errorMsgs.add("實付金額應等於總金額 - 折扣金額");
			}

			OrderVO orderVO = new OrderVO();
			orderVO.setMemberId(memberId);
			orderVO.setEmployeeId(employeeId);
			orderVO.setCouponId(couponId);
			orderVO.setOrderStatus(orderStatus);
			orderVO.setCheckInDate(checkInDate);
			orderVO.setCheckOutDate(checkOutDate);
			orderVO.setTotalAmount(totalAmount);
			orderVO.setDiscountAmount(discountAmount);
			orderVO.setPaidAmount(paidAmount);
			orderVO.setPaymentMethod(paymentMethod);

			if (!errorMsgs.isEmpty()) {
				req.setAttribute("orderVO", orderVO);
				RequestDispatcher failureView = req.getRequestDispatcher("/order/addOrder.jsp");
				failureView.forward(req, res);
				return;
			}

			OrderService orderSvc = new OrderService();
			orderSvc.addOrder(memberId, employeeId, couponId, orderStatus, checkInDate, checkOutDate, totalAmount,
					discountAmount, paidAmount, null, null, paymentMethod);

			String url = "/order/listAllOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}

		if ("delete".equals(action)) {
			List<String> errorMsgs = new LinkedList<>();
			req.setAttribute("errorMsgs", errorMsgs);

			String str = req.getParameter("orderId");
			if (str == null || str.trim().length() == 0) {
				errorMsgs.add("訂單編號不得為空");
				RequestDispatcher failureView = req.getRequestDispatcher("/order/listAllOrder.jsp");
				failureView.forward(req, res);
				return;
			}
			Integer orderId = Integer.valueOf(str.trim());

			OrderService orderSvc = new OrderService();
			orderSvc.deleteOrder(orderId);

			String url = "/order/listAllOrder.jsp";
			RequestDispatcher successView = req.getRequestDispatcher(url);
			successView.forward(req, res);
		}
	}
}
