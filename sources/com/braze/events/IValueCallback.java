package com.braze.events;

import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\bç\u0001\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0015\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0007ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\bÀ\u0006\u0001"}, d2 = {"Lcom/braze/events/IValueCallback;", "T", "", "onError", "", "onSuccess", "value", "(Ljava/lang/Object;)V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IValueCallback<T> {
    void onError() {
    }

    void onSuccess(T t);
}
