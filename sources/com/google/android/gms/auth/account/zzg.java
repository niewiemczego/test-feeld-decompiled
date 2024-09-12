package com.google.android.gms.auth.account;

import com.google.android.gms.auth.account.WorkAccountApi;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.internal.PendingResultUtil;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
final class zzg implements PendingResultUtil.ResultConverter {
    zzg(WorkAccountClient workAccountClient) {
    }

    public final /* synthetic */ Object convert(Result result) {
        return ((WorkAccountApi.AddAccountResult) result).getAccount();
    }
}
