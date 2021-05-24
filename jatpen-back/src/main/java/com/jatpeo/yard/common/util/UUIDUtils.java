package com.jatpeo.yard.common.util;

import java.util.UUID;

/**
 * Created by rubin on 2020-02-11.
 */

public class UUIDUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().toUpperCase().replaceAll("-", "");
    }

}
