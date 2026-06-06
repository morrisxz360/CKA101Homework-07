package com.order.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.order.model.OrderVO;

public class OrderJDBCDAO implements OrderDAO_interface {

	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/thestar?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "123456";

	private static final String INSERT_STMT = "INSERT INTO room_order (member_id, employee_id, coupon_id, order_status, "
			+ "check_in_date, check_out_date, total_amount, discount_amount, paid_amount, "
			+ "merchant_trade_no, ecpay_trade_no, payment_method) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = "SELECT * FROM room_order ORDER BY order_id";

	private static final String GET_ONE_STMT = "SELECT order_id, member_id, employee_id, coupon_id, order_status, "
			+ "check_in_date, check_out_date, total_amount, discount_amount, paid_amount, "
			+ "merchant_trade_no, ecpay_trade_no, payment_method, created_time, updated_time "
			+ "FROM room_order WHERE order_id = ?";

	private static final String DELETE = "DELETE FROM room_order where order_id = ?";

	private static final String UPDATE = "UPDATE ROOM_ORDER "
			+ " SET ORDER_STATUS = ?, CHECK_IN_DATE = ?, CHECK_OUT_DATE = ?, UPDATED_TIME = NOW() "
			+ " WHERE ORDER_ID = ?";

	@Override
	public void insert(OrderVO ordervo) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, ordervo.getMemberId());

			if (ordervo.getEmployeeId() != null) {
				pstmt.setInt(2, ordervo.getEmployeeId());
			} else {
				pstmt.setNull(2, java.sql.Types.INTEGER);
			}
			if (ordervo.getCouponId() != null) {
				pstmt.setInt(3, ordervo.getCouponId());
			} else {
				pstmt.setNull(3, java.sql.Types.INTEGER);
			}

			pstmt.setByte(4, ordervo.getOrderStatus());
			pstmt.setDate(5, ordervo.getCheckInDate());
			pstmt.setDate(6, ordervo.getCheckOutDate());
			pstmt.setInt(7, ordervo.getTotalAmount());
			pstmt.setInt(8, ordervo.getDiscountAmount());
			pstmt.setInt(9, ordervo.getPaidAmount());
			pstmt.setString(10, ordervo.getMerchantTradeNo());
			pstmt.setString(11, ordervo.getEcpayTradeNo());
			pstmt.setByte(12, ordervo.getPaymentMethod());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void update(OrderVO ordervo) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

			pstmt.setByte(1, ordervo.getOrderStatus());
			pstmt.setDate(2, ordervo.getCheckInDate());
			pstmt.setDate(3, ordervo.getCheckOutDate());
			pstmt.setInt(4, ordervo.getOrderId());

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public void delete(Integer orderId) {
		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, orderId);

			pstmt.executeUpdate();

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());

		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
	}

	@Override
	public OrderVO findByPrimaryKey(Integer orderId) {

		OrderVO orderVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, orderId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderId(rs.getInt("order_id"));
				orderVO.setMemberId(rs.getInt("member_id"));
				orderVO.setEmployeeId((Integer) rs.getObject("employee_id"));
				orderVO.setCouponId((Integer) rs.getObject("coupon_id"));
				orderVO.setOrderStatus(rs.getByte("order_status"));
				orderVO.setCheckInDate(rs.getDate("check_in_date"));
				orderVO.setCheckOutDate(rs.getDate("check_out_date"));
				orderVO.setTotalAmount(rs.getInt("total_amount"));
				orderVO.setDiscountAmount(rs.getInt("discount_amount"));
				orderVO.setPaidAmount(rs.getInt("paid_amount"));
				orderVO.setMerchantTradeNo(rs.getString("merchant_trade_no"));
				orderVO.setEcpayTradeNo(rs.getString("ecpay_trade_no"));
				orderVO.setPaymentMethod(rs.getByte("payment_method"));
				orderVO.setCreatedTime(rs.getTimestamp("created_time"));
				orderVO.setUpdatedTime(rs.getTimestamp("updated_time"));
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return orderVO;
	}

	@Override
	public List<OrderVO> getAll() {

		List<OrderVO> list = new ArrayList<OrderVO>();
		OrderVO orderVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				orderVO = new OrderVO();
				orderVO.setOrderId(rs.getInt("order_id"));
				orderVO.setMemberId(rs.getInt("member_id"));
				orderVO.setEmployeeId((Integer) rs.getObject("employee_id"));
				orderVO.setCouponId((Integer) rs.getObject("coupon_id"));
				orderVO.setOrderStatus(rs.getByte("order_status"));
				orderVO.setCheckInDate(rs.getDate("check_in_date"));
				orderVO.setCheckOutDate(rs.getDate("check_out_date"));
				orderVO.setTotalAmount(rs.getInt("total_amount"));
				orderVO.setDiscountAmount(rs.getInt("discount_amount"));
				orderVO.setPaidAmount(rs.getInt("paid_amount"));
				orderVO.setMerchantTradeNo(rs.getString("merchant_trade_no"));
				orderVO.setEcpayTradeNo(rs.getString("ecpay_trade_no"));
				orderVO.setPaymentMethod(rs.getByte("payment_method"));
				orderVO.setCreatedTime(rs.getTimestamp("created_time"));
				orderVO.setUpdatedTime(rs.getTimestamp("updated_time"));

				list.add(orderVO);
			}

		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver." + e.getMessage());
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured." + se.getMessage());

		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

		return list;

	}

	public static void main(String[] args) {

		OrderJDBCDAO dao = new OrderJDBCDAO();
		long ts = System.currentTimeMillis(); // 時間戳產唯一編號,跑幾次都不撞

		// ===== 1. insert =====
		OrderVO vo1 = new OrderVO();
		vo1.setMemberId(1);
		vo1.setEmployeeId(1);
		vo1.setCouponId(1);
		vo1.setOrderStatus((byte) 0);
		vo1.setCheckInDate(java.sql.Date.valueOf("2026-08-01"));
		vo1.setCheckOutDate(java.sql.Date.valueOf("2026-08-03"));
		vo1.setTotalAmount(10000);
		vo1.setDiscountAmount(500);
		vo1.setPaidAmount(9500);
		vo1.setMerchantTradeNo("MT" + ts);
		vo1.setEcpayTradeNo("EC" + ts);
		vo1.setPaymentMethod((byte) 0);
		dao.insert(vo1);
		System.out.println("=== insert 完成, trade_no=MT" + ts + " ===\n");
		System.out.println("=== getAll 結果 ===");
		List<OrderVO> list = dao.getAll();
		for (OrderVO vo : list) {
			System.out.println("orderId=" + vo.getOrderId() + ", memberId=" + vo.getMemberId() + ", totalAmount="
					+ vo.getTotalAmount() + ", trade_no=" + vo.getMerchantTradeNo() + ", status="
					+ vo.getOrderStatus());
		}
		OrderVO latest = list.get(list.size() - 1);
		Integer newOrderId = latest.getOrderId();
		System.out.println("\n剛新增的 orderId = " + newOrderId);

		// ===== 3. findByPrimaryKey =====
		System.out.println("\n=== findByPrimaryKey 結果 ===");
		OrderVO found = dao.findByPrimaryKey(newOrderId);
		if (found != null) {
			System.out.println("orderId: " + found.getOrderId());
			System.out.println("memberId: " + found.getMemberId());
			System.out.println("trade_no: " + found.getMerchantTradeNo());
			System.out.println("checkInDate: " + found.getCheckInDate());
			System.out.println("checkOutDate: " + found.getCheckOutDate());
			System.out.println("totalAmount: " + found.getTotalAmount());
			System.out.println("paidAmount: " + found.getPaidAmount());
			System.out.println("orderStatus: " + found.getOrderStatus());
			System.out.println("paymentMethod: " + found.getPaymentMethod());
		} else {
			System.out.println("查無資料");
		}

		// ===== 4. update (只動 status + 兩個日期, 其餘應保留) =====
		found.setOrderStatus((byte) 2); // 0 改成 2(completed)
		found.setCheckOutDate(java.sql.Date.valueOf("2026-08-05")); // 退房日期改一下
		dao.update(found);
		System.out.println("\n=== update 完成 ===");

		OrderVO afterUpdate = dao.findByPrimaryKey(newOrderId);
		System.out.println("update 後 status=" + afterUpdate.getOrderStatus() // 應為 2
				+ ", checkOut=" + afterUpdate.getCheckOutDate() // 應為 2026-08-05
				+ ", paidAmount=" + afterUpdate.getPaidAmount() // 應仍為 9500(沒被動到)
				+ ", trade_no=" + afterUpdate.getMerchantTradeNo() // 應仍為 MT...(沒被動到)
				+ ", updatedTime=" + afterUpdate.getUpdatedTime()); // 應有更新

		// ===== 5. delete =====
		dao.delete(newOrderId);
		System.out.println("\n=== delete orderId=" + newOrderId + " 完成 ===");

		OrderVO afterDelete = dao.findByPrimaryKey(newOrderId);
		System.out.println(afterDelete == null ? "確認已刪除, 查不到 orderId=" + newOrderId : "刪除失敗, 資料還在");
	}
}