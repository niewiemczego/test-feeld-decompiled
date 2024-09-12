package com.facebook.gamingservices.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u000b\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\u000b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\u0006\u0010\u0011\u001a\u00020\u0012J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateMedia;", "", "gif", "Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "video", "(Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;)V", "getGif", "()Lcom/facebook/gamingservices/model/CustomUpdateMediaInfo;", "getVideo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomUpdateContent.kt */
public final class CustomUpdateMedia {
    private final CustomUpdateMediaInfo gif;
    private final CustomUpdateMediaInfo video;

    public CustomUpdateMedia() {
        this((CustomUpdateMediaInfo) null, (CustomUpdateMediaInfo) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CustomUpdateMedia copy$default(CustomUpdateMedia customUpdateMedia, CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i, Object obj) {
        if ((i & 1) != 0) {
            customUpdateMediaInfo = customUpdateMedia.gif;
        }
        if ((i & 2) != 0) {
            customUpdateMediaInfo2 = customUpdateMedia.video;
        }
        return customUpdateMedia.copy(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    public final CustomUpdateMediaInfo component1() {
        return this.gif;
    }

    public final CustomUpdateMediaInfo component2() {
        return this.video;
    }

    public final CustomUpdateMedia copy(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2) {
        return new CustomUpdateMedia(customUpdateMediaInfo, customUpdateMediaInfo2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateMedia)) {
            return false;
        }
        CustomUpdateMedia customUpdateMedia = (CustomUpdateMedia) obj;
        return Intrinsics.areEqual((Object) this.gif, (Object) customUpdateMedia.gif) && Intrinsics.areEqual((Object) this.video, (Object) customUpdateMedia.video);
    }

    public int hashCode() {
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        int i = 0;
        int hashCode = (customUpdateMediaInfo == null ? 0 : customUpdateMediaInfo.hashCode()) * 31;
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        if (customUpdateMediaInfo2 != null) {
            i = customUpdateMediaInfo2.hashCode();
        }
        return hashCode + i;
    }

    public String toString() {
        return "CustomUpdateMedia(gif=" + this.gif + ", video=" + this.video + ')';
    }

    public CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2) {
        this.gif = customUpdateMediaInfo;
        this.video = customUpdateMediaInfo2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomUpdateMedia(CustomUpdateMediaInfo customUpdateMediaInfo, CustomUpdateMediaInfo customUpdateMediaInfo2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : customUpdateMediaInfo, (i & 2) != 0 ? null : customUpdateMediaInfo2);
    }

    public final CustomUpdateMediaInfo getGif() {
        return this.gif;
    }

    public final CustomUpdateMediaInfo getVideo() {
        return this.video;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        CustomUpdateMediaInfo customUpdateMediaInfo = this.gif;
        if (customUpdateMediaInfo != null) {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("url", (Object) customUpdateMediaInfo.getUrl());
            jSONObject.put("gif", (Object) jSONObject2);
        }
        CustomUpdateMediaInfo customUpdateMediaInfo2 = this.video;
        if (customUpdateMediaInfo2 != null) {
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("url", (Object) customUpdateMediaInfo2.getUrl());
            jSONObject.put("video", (Object) jSONObject3);
        }
        return jSONObject;
    }
}
