package org.example.data.enums;

public enum RoleEnum {
    Boutiquier,Client,Admin;

    public static RoleEnum getValue(String roleName) {
        for (RoleEnum role : RoleEnum.values()) {
            if (role.name().compareToIgnoreCase(roleName)==0){
                return role;
            }
        }
        return null;
    }
}
