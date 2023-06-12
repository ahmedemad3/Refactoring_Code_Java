package com.refactor.code.smells.longmethods.model;

import java.util.List;

public class UserDTO {
	
	private Long id;
    private String username;
    private List<OrderDTO> orderDTOs;
    private String role;
    private List<String> permissions;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<OrderDTO> getOrderDTOs() {
		return orderDTOs;
	}
	public void setOrderDTOs(List<OrderDTO> orderDTOs) {
		this.orderDTOs = orderDTOs;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public List<String> getPermissions() {
		return permissions;
	}
	public void setPermissions(List<String> permissions) {
		this.permissions = permissions;
	}
    
    

}
