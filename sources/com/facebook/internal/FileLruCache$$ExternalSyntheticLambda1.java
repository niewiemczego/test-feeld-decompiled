package com.facebook.internal;

import java.io.File;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class FileLruCache$$ExternalSyntheticLambda1 implements Runnable {
    public final /* synthetic */ File[] f$0;

    public /* synthetic */ FileLruCache$$ExternalSyntheticLambda1(File[] fileArr) {
        this.f$0 = fileArr;
    }

    public final void run() {
        FileLruCache.m336clearCache$lambda1(this.f$0);
    }
}
