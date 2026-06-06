package com.order.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROOM_ORDER")
public class OrderVO {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ORDER_ID", updatable = false)
	private Integer orderId;
	
	@Column(name = "MEMBER_ID")
	private Integer memberId;
	
	@Column(name = "EMPLOYEE_ID")
	private Integer employeeId;
	
	@Column(name = "COUPON_ID")
	private Integer couponId;
	
	@Column(name = "ORDER_STATUS")
	private Byte orderStatus;
	
	@Column(name ="CHECK_IN_DATE")
	private Date checkInDate;
	
	@Column(name ="CHECK_OUT_DATE")
	private Date checkOutDate;
	
	@Column(name ="TOTAL_AMOUNT")
	private Integer totalAmount;
	
	@Column(name ="DISCOUNT_AMOUNT")
	private Integer discountAmount;
	
	@Column(name ="PAID_AMOUNT")
	private Integer paidAmount;
	
	@Column(name ="MERCHANT_TRADE_NO")
	private String merchantTradeNo;
	
	@Column(name ="ECPAY_TRADE_NO")
	private String ecpayTradeNo;
	
	@Column(name ="PAYMENT_METHOD")
	private Byte paymentMethod;
	
	@CreationTimestamp 
	@Column(name ="CREATED_TIME")
	private Timestamp createdTime;
	@UpdateTimestamp
	@Column(name ="UPDATED_TIME")
	private Timestamp updatedTime;
	
	@OneToMany(mappedBy = "ordervo", fetch = FetchType.LAZY)
	private List<OrderListVO> orderList;
	
	@OneToOne(mappedBy ="ordervo",fetch = FetchType.LAZY)
	private RefundListVO refundvo;
	 

	public OrderVO() {
		super();
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Integer getCouponId() {
		return couponId;
	}

	public void setCouponId(Integer couponId) {
		this.couponId = couponId;
	}

	public Byte getOrderStatus() {
		return orderStatus;
	}

	public void setOrderStatus(Byte orderStatus) {
		this.orderStatus = orderStatus;
	}

	public Date getCheckInDate() {
		return checkInDate;
	}

	public void setCheckInDate(Date checkInDate) {
		this.checkInDate = checkInDate;
	}

	public Date getCheckOutDate() {
		return checkOutDate;
	}

	public void setCheckOutDate(Date checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	public Integer getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Integer totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Integer getDiscountAmount() {
		return discountAmount;
	}

	public void setDiscountAmount(Integer discountAmount) {
		this.discountAmount = discountAmount;
	}

	public Integer getPaidAmount() {
		return paidAmount;
	}

	public void setPaidAmount(Integer paidAmount) {
		this.paidAmount = paidAmount;
	}

	public String getMerchantTradeNo() {
		return merchantTradeNo;
	}

	public void setMerchantTradeNo(String merchantTradeNo) {
		this.merchantTradeNo = merchantTradeNo;
	}

	public String getEcpayTradeNo() {
		return ecpayTradeNo;
	}

	public void setEcpayTradeNo(String ecpayTradeNo) {
		this.ecpayTradeNo = ecpayTradeNo;
	}

	public Byte getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(Byte paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public Timestamp getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Timestamp createdTime) {
		this.createdTime = createdTime;
	}

	public Timestamp getUpdatedTime() {
		return updatedTime;
	}

	public RefundListVO getRefundvo() {
		return refundvo;
	}

	public void setRefundvo(RefundListVO refundvo) {
		this.refundvo = refundvo;
	}

	public void setUpdatedTime(Timestamp updatedTime) {
		this.updatedTime = updatedTime;
	}
	
	public List<OrderListVO> getOrderList() {
		return orderList;
	}

	public void setOrderList(List<OrderListVO> orderList) {
		this.orderList = orderList;
	}

}
