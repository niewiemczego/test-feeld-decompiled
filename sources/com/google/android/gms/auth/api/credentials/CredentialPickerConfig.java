package com.google.android.gms.auth.api.credentials;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Deprecated
/* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
public final class CredentialPickerConfig extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<CredentialPickerConfig> CREATOR = new zbb();
    final int zba;
    private final boolean zbb;
    private final boolean zbc;
    private final int zbd;

    /* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
    public static class Builder {
        private boolean zba = false;
        private boolean zbb = true;
        private int zbc = 1;

        public CredentialPickerConfig build() {
            return new CredentialPickerConfig(2, this.zba, this.zbb, false, this.zbc);
        }

        @Deprecated
        public Builder setForNewAccount(boolean z) {
            int i = 1;
            if (true == z) {
                i = 3;
            }
            this.zbc = i;
            return this;
        }

        public Builder setPrompt(int i) {
            this.zbc = i;
            return this;
        }

        public Builder setShowAddAccountButton(boolean z) {
            this.zba = z;
            return this;
        }

        public Builder setShowCancelButton(boolean z) {
            this.zbb = z;
            return this;
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    /* compiled from: com.google.android.gms:play-services-auth@@20.7.0 */
    public @interface Prompt {
        public static final int CONTINUE = 1;
        public static final int SIGN_IN = 2;
        public static final int SIGN_UP = 3;
    }

    CredentialPickerConfig(int i, boolean z, boolean z2, boolean z3, int i2) {
        this.zba = i;
        this.zbb = z;
        this.zbc = z2;
        if (i < 2) {
            this.zbd = true == z3 ? 3 : 1;
        } else {
            this.zbd = i2;
        }
    }

    @Deprecated
    public boolean isForNewAccount() {
        return this.zbd == 3;
    }

    public boolean shouldShowAddAccountButton() {
        return this.zbb;
    }

    public boolean shouldShowCancelButton() {
        return this.zbc;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 1, shouldShowAddAccountButton());
        SafeParcelWriter.writeBoolean(parcel, 2, shouldShowCancelButton());
        SafeParcelWriter.writeBoolean(parcel, 3, isForNewAccount());
        SafeParcelWriter.writeInt(parcel, 4, this.zbd);
        SafeParcelWriter.writeInt(parcel, 1000, this.zba);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
