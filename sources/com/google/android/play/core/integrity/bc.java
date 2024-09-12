package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final /* synthetic */ class bc implements StandardIntegrityManager.StandardIntegrityTokenProvider {
    public final /* synthetic */ bd a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public /* synthetic */ bc(bd bdVar, long j, long j2) {
        this.a = bdVar;
        this.b = j;
        this.c = j2;
    }

    public final Task request(StandardIntegrityManager.StandardIntegrityTokenRequest standardIntegrityTokenRequest) {
        return this.a.a(this.b, this.c, standardIntegrityTokenRequest);
    }
}
