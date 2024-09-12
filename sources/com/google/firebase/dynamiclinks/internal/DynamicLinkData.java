package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

public class DynamicLinkData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<DynamicLinkData> CREATOR = new DynamicLinkDataCreator();
    private long clickTimestamp;
    private String deepLink;
    private String dynamicLink;
    private Bundle extensionBundle;
    private int minVersion;
    private Uri redirectUrl;

    public String getDynamicLink() {
        return this.dynamicLink;
    }

    public void setDynamicLink(String str) {
        this.dynamicLink = str;
    }

    public String getDeepLink() {
        return this.deepLink;
    }

    public void setDeepLink(String str) {
        this.deepLink = str;
    }

    public int getMinVersion() {
        return this.minVersion;
    }

    public void setMinVersion(int i) {
        this.minVersion = i;
    }

    public long getClickTimestamp() {
        return this.clickTimestamp;
    }

    public void setClickTimestamp(long j) {
        this.clickTimestamp = j;
    }

    public Bundle getExtensionBundle() {
        Bundle bundle = this.extensionBundle;
        return bundle == null ? new Bundle() : bundle;
    }

    public void setRedirectUrl(Uri uri) {
        this.redirectUrl = uri;
    }

    public Uri getRedirectUrl() {
        return this.redirectUrl;
    }

    public void setExtensionData(Bundle bundle) {
        this.extensionBundle = bundle;
    }

    public DynamicLinkData(String str, String str2, int i, long j, Bundle bundle, Uri uri) {
        this.dynamicLink = str;
        this.deepLink = str2;
        this.minVersion = i;
        this.clickTimestamp = j;
        this.extensionBundle = bundle;
        this.redirectUrl = uri;
    }

    public void writeToParcel(Parcel parcel, int i) {
        DynamicLinkDataCreator.writeToParcel(this, parcel, i);
    }
}
