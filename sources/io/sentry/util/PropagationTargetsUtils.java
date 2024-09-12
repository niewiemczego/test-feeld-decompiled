package io.sentry.util;

import java.net.URI;
import java.util.List;

public final class PropagationTargetsUtils {
    public static boolean contain(List<String> list, String str) {
        if (list.isEmpty()) {
            return false;
        }
        for (String next : list) {
            if (str.contains(next)) {
                return true;
            }
            try {
                if (str.matches(next)) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        return false;
    }

    public static boolean contain(List<String> list, URI uri) {
        return contain(list, uri.toString());
    }
}
