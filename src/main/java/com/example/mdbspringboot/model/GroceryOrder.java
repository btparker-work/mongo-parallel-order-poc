package com.example.mdbspringboot.model;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.example.mdbspringboot.util.constants;

@Document("GroceryOrder")
public class GroceryOrder {
	@Id
	private String id;

	private String ordernum;
	private String status;

	public GroceryOrder() {
		super();
		// this.id = id;
		this.ordernum = "ORD" + RandomStringUtils.randomAlphanumeric(17).toUpperCase();
		this.status = constants.STATUS_OPEN;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
