package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.common.api.Response;

@Deprecated
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public class CredentialRequestResponse extends Response<CredentialRequestResult> {
    public Credential getCredential() {
        return ((CredentialRequestResult) getResult()).getCredential();
    }
}
