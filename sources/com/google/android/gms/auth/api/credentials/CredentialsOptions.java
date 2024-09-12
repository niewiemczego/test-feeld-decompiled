package com.google.android.gms.auth.api.credentials;

import com.google.android.gms.auth.api.Auth;

@Deprecated
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class CredentialsOptions extends Auth.AuthCredentialsOptions {
    public static final CredentialsOptions DEFAULT = new Builder().build();

    /* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
    public static final class Builder extends Auth.AuthCredentialsOptions.Builder {
        public CredentialsOptions build() {
            return new CredentialsOptions(this, (zbd) null);
        }

        public Builder forceEnableSaveDialog() {
            this.zba = true;
            return this;
        }
    }

    /* synthetic */ CredentialsOptions(Builder builder, zbd zbd) {
        super(builder);
    }
}
