package com.clipit.clipitback.model.dto;

public class UserInfo {

	private String id;
	private String password;
	private String username;
	private String createDate;
	private String status;

	public UserInfo() {
		super();
	}

	public UserInfo(String id, String password, String username, String createDate, String status) {
		super();
		this.id = id;
		this.password = password;
		this.username = username;
		this.createDate = createDate;
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getCreateDate() {
		return createDate;
	}

	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UserInfo [id=" + id + ", password=" + password + ", username=" + username + ", createDate=" + createDate
				+ ", status=" + status + "]";
	}

}