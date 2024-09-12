package com.launchdarkly.sdk.android.subsystems;

public interface Callback<T> {
    void onError(Throwable th);

    void onSuccess(T t);
}
