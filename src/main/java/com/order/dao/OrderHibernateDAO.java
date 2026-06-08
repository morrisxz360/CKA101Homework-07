package com.order.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.order.model.OrderVO;
import com.order.util.HibernateUtil;

public class OrderHibernateDAO implements OrderDAO_interface {

//	private SessionFactory factory;
//
//	public OrderHibernateDAO() {
//		factory = HibernateUtil.getSessionFactory();
//	}

	public List<OrderVO> getAll() {

//		Session session = factory.openSession();
//
//		try {
//			return session.createQuery("from OrderVO", OrderVO.class).getResultList();
//		} finally {
//			session.close();
//		}
//	
//		=============================================================

		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			List<OrderVO> list = session.createQuery("from OrderVO", OrderVO.class).getResultList();
			session.getTransaction().commit();
			return list;

		} catch (Exception e) {
			session.getTransaction().rollback();
			throw e;
		}
	}

	@Override
	public void insert(OrderVO ordervo) {

//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			session.persist(ordervo);
//			tx.commit();
//		}catch(Exception e) {
//			tx.rollback();
//			throw e;
//		}finally {
//			session.close();
//		}
		
//		=======================================================
		
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			session.persist(ordervo);
			session.getTransaction().commit();
			
			
		}catch(Exception e) {
			session.getTransaction().rollback();
			throw e;
		}

	}

	@Override
	public void update(OrderVO ordervo) {

//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			session.merge(ordervo);
//			tx.commit();
//			
//		}catch(Exception e) {
//			tx.rollback();
//			throw e;
//		}finally {
//			session.close();
//		}
//		===================================================
		    Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		    try {
		        session.beginTransaction();

		        OrderVO db = session.find(OrderVO.class, ordervo.getOrderId()); 

		        db.setCheckInDate(ordervo.getCheckInDate());
		        db.setCheckOutDate(ordervo.getCheckOutDate());
		        db.setOrderStatus(ordervo.getOrderStatus());
		        
		        session.getTransaction().commit(); 
		    } catch (Exception e) {
		        session.getTransaction().rollback();
		        throw e;
		    }
		}

	@Override
	public void delete(Integer orderId) {
//		Session session = factory.openSession();
//		Transaction tx = session.beginTransaction();
//		try {
//			OrderVO order = session.get(OrderVO.class, orderId);
//			if(order != null) {
//				session.remove(order);
//			}
//			tx.commit();
//		}catch(Exception e) {
//			tx.rollback();
//			throw e;
//		}finally {
//			session.close();
//		}
//		===============================================
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			OrderVO ordervo = session.find(OrderVO.class, orderId);
			if(ordervo != null) {
				session.remove(ordervo);
			}
			session.getTransaction().commit();
		}catch(Exception e) {
			session.getTransaction().rollback();
			throw e;
		}

	}

	@Override
	public OrderVO findByPrimaryKey(Integer orderId) {
//		Session session = factory.openSession();
//		try {
//			return session.get(OrderVO.class, orderId);
//		}finally {
//			session.close();
//		}
//		=====================================
		Session session = HibernateUtil.getSessionFactory().getCurrentSession();
		try {
			session.beginTransaction();
			OrderVO ordervo= session.find(OrderVO.class,orderId);
			session.getTransaction().commit();
			return ordervo;
		}catch(Exception e){
			session.getTransaction().rollback();
			throw e;
		}
		
	}
}
