package com.davi.shop.entities.role;

public enum Roles {
    ROLE_CUSTOMER("ROLE_CUSTOMER"), 
    ROLE_SELLER("ROLE_SELLER"),
    ROLE_ADMIN("ROLE_ADMIN");

    private final String role;

    Roles(String string) {
	this.role = string;
    }

    public String getRoleString() {
	return role;
    }
}
