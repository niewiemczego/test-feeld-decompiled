package com.google.android.exoplayer2.ext.okhttp;

import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import okhttp3.CacheControl;
import okhttp3.Call;

@Deprecated
public final class OkHttpDataSourceFactory extends HttpDataSource.BaseFactory {
    private final CacheControl cacheControl;
    private final Call.Factory callFactory;
    private final TransferListener listener;
    private final String userAgent;

    public OkHttpDataSourceFactory(Call.Factory factory) {
        this(factory, (String) null, (TransferListener) null, (CacheControl) null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str) {
        this(factory, str, (TransferListener) null, (CacheControl) null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, CacheControl cacheControl2) {
        this(factory, str, (TransferListener) null, cacheControl2);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, TransferListener transferListener) {
        this(factory, str, transferListener, (CacheControl) null);
    }

    public OkHttpDataSourceFactory(Call.Factory factory, String str, TransferListener transferListener, CacheControl cacheControl2) {
        this.callFactory = factory;
        this.userAgent = str;
        this.listener = transferListener;
        this.cacheControl = cacheControl2;
    }

    /* access modifiers changed from: protected */
    public OkHttpDataSource createDataSourceInternal(HttpDataSource.RequestProperties requestProperties) {
        OkHttpDataSource okHttpDataSource = new OkHttpDataSource(this.callFactory, this.userAgent, this.cacheControl, requestProperties);
        TransferListener transferListener = this.listener;
        if (transferListener != null) {
            okHttpDataSource.addTransferListener(transferListener);
        }
        return okHttpDataSource;
    }
}
