package com.google.firebase.auth.internal;

import android.net.Uri;
import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final /* synthetic */ class zzbf implements Continuation {
    private /* synthetic */ Uri zza;

    public /* synthetic */ zzbf(Uri uri) {
        this.zza = uri;
    }

    public final Object then(Task task) {
        return GenericIdpActivity.zza(this.zza, task);
    }
}
