package com.google.android.exoplayer2.source;

import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.common.base.Supplier;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda4 implements Supplier {
    public final /* synthetic */ DefaultMediaSourceFactory.DelegateFactoryLoader f$0;
    public final /* synthetic */ DataSource.Factory f$1;

    public /* synthetic */ DefaultMediaSourceFactory$DelegateFactoryLoader$$ExternalSyntheticLambda4(DefaultMediaSourceFactory.DelegateFactoryLoader delegateFactoryLoader, DataSource.Factory factory) {
        this.f$0 = delegateFactoryLoader;
        this.f$1 = factory;
    }

    public final Object get() {
        return this.f$0.m504lambda$maybeLoadSupplier$4$comgoogleandroidexoplayer2sourceDefaultMediaSourceFactory$DelegateFactoryLoader(this.f$1);
    }
}
