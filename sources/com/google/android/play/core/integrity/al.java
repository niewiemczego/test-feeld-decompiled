package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class al implements StandardIntegrityManager {
    private final ax a;
    private final bd b;

    al(ax axVar, bd bdVar) {
        this.a = axVar;
        this.b = bdVar;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Task a(StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest, Long l) throws Exception {
        return Tasks.forResult(new bc(this.b, prepareIntegrityTokenRequest.a(), l.longValue()));
    }

    public final Task<StandardIntegrityManager.StandardIntegrityTokenProvider> prepareIntegrityToken(StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest) {
        return this.a.d(prepareIntegrityTokenRequest.a()).onSuccessTask(new ak(this, prepareIntegrityTokenRequest));
    }
}
