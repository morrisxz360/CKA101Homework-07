package com.order.service;

import java.sql.Date;
import java.util.List;

import com.order.dao.OrderDAO_interface;
import com.order.dao.OrderHibernateDAO;
import com.order.model.OrderVO;

public class OrderService {

	private OrderDAO_interface dao;

	public OrderService() {
		dao = new OrderHibernateDAO();

	}

	public OrderVO addOrder(Integer memberId, Integer employeeId, Integer couponId, Byte orderStatus,
			Date checkInDate, Date checkOutDate, Integer totalAmount, Integer discountAmount, Integer paidAmount,
			String merchantTradeNo, String ecpayTradeNo, Byte paymentMethod) {
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
		orderVO.setMerchantTradeNo(merchantTradeNo);
		orderVO.setEcpayTradeNo(ecpayTradeNo);
		orderVO.setPaymentMethod(paymentMethod);
		dao.insert(orderVO);

		return orderVO;

	}

	public OrderVO updateOrder(Integer orderId, Byte orderStatus, Date checkInDate, Date checkOutDate) {
		OrderVO orderVO = new OrderVO();
		orderVO.setOrderId(orderId);
		orderVO.setOrderStatus(orderStatus);
		orderVO.setCheckInDate(checkInDate);
		orderVO.setCheckOutDate(checkOutDate);
		dao.update(orderVO);
		return orderVO;
	}

	public void deleteOrder(Integer orderId) {
		dao.delete(orderId);
	}

	public OrderVO getOneOrder(Integer orderId) {

		return dao.findByPrimaryKey(orderId);
	}

	public List<OrderVO> getAll() {
		return dao.getAll();
	}
}
