package com.google.android.gms.internal.p001authapi;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.google.android.gms.auth.api.identity.CredentialSavingClient;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenRequest;
import com.google.android.gms.auth.api.identity.SaveAccountLinkingTokenResult;
import com.google.android.gms.auth.api.identity.SavePasswordRequest;
import com.google.android.gms.auth.api.identity.SavePasswordResult;
import com.google.android.gms.auth.api.identity.zbh;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApi;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.internal.TaskApiCall;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.SafeParcelableSerializer;
import com.google.android.gms.tasks.Task;

/* renamed from: com.google.android.gms.internal.auth-api.zbaw  reason: invalid package */
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class zbaw extends GoogleApi implements CredentialSavingClient {
    private static final Api.ClientKey zba;
    private static final Api.AbstractClientBuilder zbb;
    private static final Api zbc;
    private final String zbd = zbbj.zba();

    static {
        Api.ClientKey clientKey = new Api.ClientKey();
        zba = clientKey;
        zbat zbat = new zbat();
        zbb = zbat;
        zbc = new Api("Auth.Api.Identity.CredentialSaving.API", zbat, clientKey);
    }

    public zbaw(Activity activity, zbh zbh) {
        super(activity, zbc, zbh, GoogleApi.Settings.DEFAULT_SETTINGS);
    }

    public final Status getStatusFromIntent(Intent intent) {
        if (intent == null) {
            return Status.RESULT_INTERNAL_ERROR;
        }
        Status status = (Status) SafeParcelableSerializer.deserializeFromIntentExtra(intent, "status", Status.CREATOR);
        return status == null ? Status.RESULT_INTERNAL_ERROR : status;
    }

    public final Task<SaveAccountLinkingTokenResult> saveAccountLinkingToken(SaveAccountLinkingTokenRequest saveAccountLinkingTokenRequest) {
        Preconditions.checkNotNull(saveAccountLinkingTokenRequest);
        SaveAccountLinkingTokenRequest.Builder zba2 = SaveAccountLinkingTokenRequest.zba(saveAccountLinkingTokenRequest);
        zba2.zba(this.zbd);
        SaveAccountLinkingTokenRequest build = zba2.build();
        return doRead(TaskApiCall.builder().setFeatures(zbbi.zbg).run(new zbar(this, build)).setAutoResolveMissingFeatures(false).setMethodKey(1535).build());
    }

    public final Task<SavePasswordResult> savePassword(SavePasswordRequest savePasswordRequest) {
        Preconditions.checkNotNull(savePasswordRequest);
        SavePasswordRequest.Builder zba2 = SavePasswordRequest.zba(savePasswordRequest);
        zba2.zba(this.zbd);
        SavePasswordRequest build = zba2.build();
        return doRead(TaskApiCall.builder().setFeatures(zbbi.zbe).run(new zbas(this, build)).setAutoResolveMissingFeatures(false).setMethodKey(1536).build());
    }

    public zbaw(Context context, zbh zbh) {
        super(context, zbc, zbh, GoogleApi.Settings.DEFAULT_SETTINGS);
    }
}
