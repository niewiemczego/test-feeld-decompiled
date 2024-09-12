package com.google.android.recaptcha.internal;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzeh implements zzen {
    private final Context zzb;

    public zzeh(Context context) {
        this.zzb = context;
    }

    public final /* synthetic */ Object cs(Object[] objArr) {
        return zzel.zza(this, objArr);
    }

    public final Object zza(Object... objArr) {
        Context context = this.zzb;
        Cursor query = context.getContentResolver().query(Uri.parse("content://com.google.android.gsf.gservices"), (String[]) null, (String) null, new String[]{"android_id"}, (String) null);
        if (query == null || !query.moveToFirst() || query.getColumnCount() < 2) {
            return "";
        }
        String valueOf = String.valueOf(Long.parseLong(query.getString(1)));
        query.close();
        return valueOf;
    }
}
