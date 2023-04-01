package com.example.pp3_1_2.entity;

public enum Permission {
    USER("USER"), ADMIN("ADMIN");

    private final String permission;
    Permission(String permission){
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
