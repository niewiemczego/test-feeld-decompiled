package com.google.android.gms.internal.p001authapi;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.google.android.exoplayer2.C;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;

/* renamed from: com.google.android.gms.internal.auth-api.zbn  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbn {
    public static PendingIntent zba(Context context, Auth.AuthCredentialsOptions authCredentialsOptions, HintRequest hintRequest, String str) {
        String str2;
        Preconditions.checkNotNull(context, "context must not be null");
        Preconditions.checkNotNull(hintRequest, "request must not be null");
        if (TextUtils.isEmpty(str)) {
            str2 = zbbj.zba();
        } else {
            str2 = (String) Preconditions.checkNotNull(str);
        }
        Intent putExtra = new Intent("com.google.android.gms.auth.api.credentials.PICKER").setPackage("com.google.android.gms").putExtra("claimedCallingPackage", (String) null).putExtra("logSessionId", str2);
        SafeParcelableSerializer.serializeToIntentExtra(hintRequest, putExtra, "com.google.android.gms.credentials.HintRequest");
        return PendingIntent.getActivity(context, 2000, putExtra, zbbk.zba | C.BUFFER_FLAG_FIRST_SAMPLE);
    }
}
