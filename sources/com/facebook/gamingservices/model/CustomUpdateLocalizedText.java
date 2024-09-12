package com.facebook.gamingservices.model;

import com.facebook.hermes.intl.Constants;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\u0017\u0010\f\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0003J+\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\b\u0002\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\u0006\u0010\u0013\u001a\u00020\u0014J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001f\u0010\u0004\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/facebook/gamingservices/model/CustomUpdateLocalizedText;", "", "default", "", "localizations", "Ljava/util/HashMap;", "(Ljava/lang/String;Ljava/util/HashMap;)V", "getDefault", "()Ljava/lang/String;", "getLocalizations", "()Ljava/util/HashMap;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toJSONObject", "Lorg/json/JSONObject;", "toString", "facebook-gamingservices_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: CustomUpdateContent.kt */
public final class CustomUpdateLocalizedText {

    /* renamed from: default  reason: not valid java name */
    private final String f0default;
    private final HashMap<String, String> localizations;

    public static /* synthetic */ CustomUpdateLocalizedText copy$default(CustomUpdateLocalizedText customUpdateLocalizedText, String str, HashMap<String, String> hashMap, int i, Object obj) {
        if ((i & 1) != 0) {
            str = customUpdateLocalizedText.f0default;
        }
        if ((i & 2) != 0) {
            hashMap = customUpdateLocalizedText.localizations;
        }
        return customUpdateLocalizedText.copy(str, hashMap);
    }

    public final String component1() {
        return this.f0default;
    }

    public final HashMap<String, String> component2() {
        return this.localizations;
    }

    public final CustomUpdateLocalizedText copy(String str, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, Constants.COLLATION_DEFAULT);
        return new CustomUpdateLocalizedText(str, hashMap);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CustomUpdateLocalizedText)) {
            return false;
        }
        CustomUpdateLocalizedText customUpdateLocalizedText = (CustomUpdateLocalizedText) obj;
        return Intrinsics.areEqual((Object) this.f0default, (Object) customUpdateLocalizedText.f0default) && Intrinsics.areEqual((Object) this.localizations, (Object) customUpdateLocalizedText.localizations);
    }

    public int hashCode() {
        int hashCode = this.f0default.hashCode() * 31;
        HashMap<String, String> hashMap = this.localizations;
        return hashCode + (hashMap == null ? 0 : hashMap.hashCode());
    }

    public String toString() {
        return "CustomUpdateLocalizedText(default=" + this.f0default + ", localizations=" + this.localizations + ')';
    }

    public CustomUpdateLocalizedText(String str, HashMap<String, String> hashMap) {
        Intrinsics.checkNotNullParameter(str, Constants.COLLATION_DEFAULT);
        this.f0default = str;
        this.localizations = hashMap;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CustomUpdateLocalizedText(String str, HashMap hashMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : hashMap);
    }

    public final String getDefault() {
        return this.f0default;
    }

    public final HashMap<String, String> getLocalizations() {
        return this.localizations;
    }

    public final JSONObject toJSONObject() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put(Constants.COLLATION_DEFAULT, (Object) this.f0default);
        HashMap<String, String> hashMap = this.localizations;
        if (hashMap != null) {
            JSONObject jSONObject2 = new JSONObject();
            for (Map.Entry entry : hashMap.entrySet()) {
                jSONObject2.put((String) entry.getKey(), (Object) (String) entry.getValue());
            }
            jSONObject.put("localizations", (Object) jSONObject2);
        }
        return jSONObject;
    }
}
