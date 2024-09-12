package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class bd {
    private final ax a;

    bd(ax axVar) {
        this.a = axVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task a(long j, long j2, StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.a.c(standardIntegrityTokenRequest.a(), j, j2);
    }
}
