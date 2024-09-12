package com.google.firebase.dynamiclinks.internal;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.firebase.dynamiclinks.ShortDynamicLink;
import java.util.ArrayList;
import java.util.List;

public final class ShortDynamicLinkImpl extends AbstractSafeParcelable implements ShortDynamicLink {
    public static final Parcelable.Creator<ShortDynamicLinkImpl> CREATOR = new ShortDynamicLinkImplCreator();
    private final Uri previewLink;
    private final Uri shortLink;
    private final List<WarningImpl> warnings;

    public ShortDynamicLinkImpl(Uri uri, Uri uri2, List<WarningImpl> list) {
        this.shortLink = uri;
        this.previewLink = uri2;
        this.warnings = list == null ? new ArrayList<>() : list;
    }

    public Uri getShortLink() {
        return this.shortLink;
    }

    public Uri getPreviewLink() {
        return this.previewLink;
    }

    public List<WarningImpl> getWarnings() {
        return this.warnings;
    }

    public void writeToParcel(Parcel parcel, int i) {
        ShortDynamicLinkImplCreator.writeToParcel(this, parcel, i);
    }

    public static class WarningImpl extends AbstractSafeParcelable implements ShortDynamicLink.Warning {
        public static final Parcelable.Creator<WarningImpl> CREATOR = new WarningImplCreator();
        private final String message;

        public String getCode() {
            return null;
        }

        public WarningImpl(String str) {
            this.message = str;
        }

        public String getMessage() {
            return this.message;
        }

        public void writeToParcel(Parcel parcel, int i) {
            WarningImplCreator.writeToParcel(this, parcel, i);
        }
    }
}
