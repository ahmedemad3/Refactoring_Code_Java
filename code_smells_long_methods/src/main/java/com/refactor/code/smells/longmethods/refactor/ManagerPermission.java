package com.refactor.code.smells.longmethods.refactor;

import java.util.Arrays;
import java.util.List;

public class ManagerPermission extends UserPermission{

	@Override
    public List<String> getPermissions() {
        return Arrays.asList("VIEW_ORDERS", "CREATE_PRODUCT", "DELETE_PRODUCT", "EDIT_PRODUCT", "VIEW_PRODUCTS");
    }

}
