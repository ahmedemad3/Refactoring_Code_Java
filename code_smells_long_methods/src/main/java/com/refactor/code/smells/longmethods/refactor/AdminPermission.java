package com.refactor.code.smells.longmethods.refactor;

import java.util.Arrays;
import java.util.List;

public class AdminPermission extends UserPermission{

	@Override
    public List<String> getPermissions() {
        return Arrays.asList("CREATE_USER", "DELETE_USER", "EDIT_USER", "VIEW_ORDERS", "CREATE_PRODUCT", "DELETE_PRODUCT", "EDIT_PRODUCT", "VIEW_PRODUCTS");
    }

}
