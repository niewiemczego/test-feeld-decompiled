package com.launchdarkly.sdk.internal.http;

import java.net.URI;

public abstract class HttpHelpers {
    private HttpHelpers() {
    }

    public static URI concatenateUriPath(URI uri, String str) {
        String uri2 = uri.toString();
        String str2 = "/";
        if (str.startsWith(str2)) {
            str = str.substring(1);
        }
        StringBuilder append = new StringBuilder().append(uri2);
        if (uri2.endsWith(str2)) {
            str2 = "";
        }
        return URI.create(append.append(str2).append(str).toString());
    }

    public static boolean isAsciiHeaderValue(String str) {
        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if ((charAt < ' ' || charAt > '~') && charAt != 9) {
                return false;
            }
        }
        return true;
    }
}
