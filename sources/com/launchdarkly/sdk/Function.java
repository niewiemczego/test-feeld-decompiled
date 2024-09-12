package com.launchdarkly.sdk;

interface Function<A, B> {
    B apply(A a);
}
