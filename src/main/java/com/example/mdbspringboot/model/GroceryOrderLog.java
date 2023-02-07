package com.example.mdbspringboot.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.time.LocalDateTime;

@Document("GroceryOrderLog")
public class GroceryOrderLog {
	@Id
	private String id;

	private String ordernum;
	private String status;
	private String instance;
	private String message;
	private LocalDateTime timestamp;

	public GroceryOrderLog(String ordernum, String status, String message, String instance) {
		super();
		// this.id = id;
		this.ordernum = ordernum;
		this.timestamp = LocalDateTime.now();;
		this.status = status;
		this.message = message;
		this.instance = instance;
	}

	public String getOrdernum() {
		return ordernum;
	}

	public void setOrdernum(String ordernum) {
		this.ordernum = ordernum;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getInstance() {
		return instance;
	}

	public void setInstance(String instance) {
		this.instance = instance;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
