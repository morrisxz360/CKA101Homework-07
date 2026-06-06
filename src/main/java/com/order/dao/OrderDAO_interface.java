package com.order.dao;

import java.util.List;

import com.order.model.OrderVO;

public interface OrderDAO_interface {
	
	public void insert(OrderVO ordervo);
	
	public void update(OrderVO ordervo);
	
	public void delete(Integer orderId);
	
	public OrderVO findByPrimaryKey(Integer orderId);
	
	public List<OrderVO> getAll();
	
	//萬用複合查詢(傳入參數型態Map)(回傳 List)
//  public List<OrderVO> getAll(Map<String, String[]> map);

}
