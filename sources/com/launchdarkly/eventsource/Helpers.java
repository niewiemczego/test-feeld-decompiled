package com.launchdarkly.eventsource;

import java.nio.charset.Charset;

abstract class Helpers {
    static final Charset UTF8 = Charset.forName("UTF-8");

    static int pow2(int i) {
        if (i < 31) {
            return 1 << i;
        }
        return Integer.MAX_VALUE;
    }

    private Helpers() {
    }
}
