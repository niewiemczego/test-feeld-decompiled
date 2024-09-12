package com.facebook.datasource;

import com.facebook.common.internal.Preconditions;
import java.util.Map;

public class SimpleDataSource<T> extends AbstractDataSource<T> {
    private SimpleDataSource() {
    }

    public static <T> SimpleDataSource<T> create() {
        return new SimpleDataSource<>();
    }

    public boolean setResult(T t, boolean z, Map<String, Object> map) {
        return super.setResult(Preconditions.checkNotNull(t), z, map);
    }

    public boolean setResult(T t) {
        return super.setResult(Preconditions.checkNotNull(t), true, (Map<String, Object>) null);
    }

    public boolean setFailure(Throwable th) {
        return super.setFailure((Throwable) Preconditions.checkNotNull(th));
    }

    public boolean setProgress(float f) {
        return super.setProgress(f);
    }
}
