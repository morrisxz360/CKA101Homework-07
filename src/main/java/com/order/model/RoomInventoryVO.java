package com.order.model;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ROOM_INVENTORY")
public class RoomInventoryVO {
	
	@EmbeddedId
	private RoomInventoryId id;
	
	@Column(name = "TOTAL_COUNT")
	private Integer totalCount;
	
	@Column(name = "BOOKED_COUNT")
	private Integer bookedCount;

	public RoomInventoryVO() {
		super();
	}

	public RoomInventoryId getId() {
		return id;
	}

	public void setId(RoomInventoryId id) {
		this.id = id;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public Integer getBookedCount() {
		return bookedCount;
	}

	public void setBookedCount(Integer bookedCount) {
		this.bookedCount = bookedCount;
	}
	
	
}
