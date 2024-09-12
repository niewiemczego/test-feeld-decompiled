package com.google.android.gms.auth;

import android.accounts.Account;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;

/* compiled from: com.google.android.gms:play-services-auth-base@@18.0.4 */
public class AccountChangeEventsRequest extends AbstractSafeParcelable {
    public static final Parcelable.Creator<AccountChangeEventsRequest> CREATOR = new zzb();
    final int zza;
    int zzb;
    @Deprecated
    String zzc;
    Account zzd;

    public AccountChangeEventsRequest() {
        this.zza = 1;
    }

    public Account getAccount() {
        return this.zzd;
    }

    @Deprecated
    public String getAccountName() {
        return this.zzc;
    }

    public int getEventIndex() {
        return this.zzb;
    }

    public AccountChangeEventsRequest setAccount(Account account) {
        this.zzd = account;
        return this;
    }

    @Deprecated
    public AccountChangeEventsRequest setAccountName(String str) {
        this.zzc = str;
        return this;
    }

    public AccountChangeEventsRequest setEventIndex(int i) {
        this.zzb = i;
        return this;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zza);
        SafeParcelWriter.writeInt(parcel, 2, this.zzb);
        SafeParcelWriter.writeString(parcel, 3, this.zzc, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzd, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    AccountChangeEventsRequest(int i, int i2, String str, Account account) {
        this.zza = i;
        this.zzb = i2;
        this.zzc = str;
        if (account != null || TextUtils.isEmpty(str)) {
            this.zzd = account;
        } else {
            this.zzd = new Account(str, "com.google");
        }
    }
}
