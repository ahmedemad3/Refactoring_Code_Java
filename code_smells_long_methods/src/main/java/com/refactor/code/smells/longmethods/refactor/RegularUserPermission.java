package com.refactor.code.smells.longmethods.refactor;

import java.util.Arrays;
import java.util.List;

public class RegularUserPermission extends UserPermission {

	@Override
    public List<String> getPermissions() {
        return Arrays.asList("VIEW_ORDERS", "VIEW_PRODUCTS");
    }

}
