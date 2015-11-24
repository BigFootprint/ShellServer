package com.shell.server.base.utils;

import java.util.Collection;
import java.util.Map;

/**
 * Created by liquanmin on 15/11/24.
 */
public class CollectionUtils {
    public static boolean isEmpty(Collection<?> collection) {
        if (collection == null || collection.size() == 0)
            return true;

        return false;
    }

    public static boolean isMapEmpty(Map<?, ?> map) {
        if (map == null || map.size() == 0)
            return true;

        return false;
    }
}
