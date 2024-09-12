package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.Task;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
final class w implements IntegrityManager {
    private final ad a;

    w(ad adVar) {
        this.a = adVar;
    }

    public final Task<IntegrityTokenResponse> requestIntegrityToken(IntegrityTokenRequest integrityTokenRequest) {
        return this.a.b(integrityTokenRequest);
    }
}
