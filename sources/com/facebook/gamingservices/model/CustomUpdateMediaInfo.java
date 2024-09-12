package com.facebook.gamingservices.model;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u000f"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "", "url", "", "(Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomUpdateContent.kt */
public final class CustomUpdateMediaInfo {
    private final String url;

    public static /* synthetic */ CustomUpdateMediaInfo copy$default(CustomUpdateMediaInfo customUpdateMediaInfo, String str, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customUpdateMediaInfo.url;
        }
        return customUpdateMediaInfo.copy(str);
    }

    public final String component1() {
        return this.url;
    }

    public final CustomUpdateMediaInfo copy(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        return new CustomUpdateMediaInfo(str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CustomUpdateMediaInfo) && Intrinsics.areEqual((Object) this.url, (Object) ((CustomUpdateMediaInfo) obj).url);
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    public String toString() {
        return "CustomUpdateMediaInfo(url=" + this.url + ')';
    }

    public CustomUpdateMediaInfo(String str) {
        Intrinsics.checkNotNullParameter(str, "url");
        this.url = str;
    }

    public final String getUrl() {
        return this.url;
    }
}
