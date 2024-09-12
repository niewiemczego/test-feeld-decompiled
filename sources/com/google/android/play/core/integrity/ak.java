package com.google.android.play.core.integrity;

import com.google.android.gms.tasks.SuccessContinuation;
import com.google.android.gms.tasks.Task;
import com.google.android.play.core.integrity.StandardIntegrityManager;

/* compiled from: com.google.android.play:integrity@@1.2.0 */
public final /* synthetic */ class ak implements SuccessContinuation {
    public final /* synthetic */ al a;
    public final /* synthetic */ StandardIntegrityManager.PrepareIntegrityTokenRequest b;

    public /* synthetic */ ak(al alVar, StandardIntegrityManager.PrepareIntegrityTokenRequest prepareIntegrityTokenRequest) {
        this.a = alVar;
        this.b = prepareIntegrityTokenRequest;
    }

    public final Task then(Object obj) {
        return this.a.a(this.b, (Long) obj);
    }
}
