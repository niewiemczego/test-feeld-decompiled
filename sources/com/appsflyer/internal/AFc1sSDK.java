package com.appsflyer.internal;

import android.util.Base64;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\b\b\u0018\u0000 \u00012\u00020\u000b:\u0001\u0001B)\u0012\u0006\u0010\f\u001a\u00020\u0006\u0012\u0006\u0010\u0016\u001a\u00020\u0006\u0012\u0006\u0010\u0017\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0002¢\u0006\u0004\b\u0019\u0010\u001aJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fJ\u0010\u0010\u0010\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u000f\u0010\u0007\u001a\u00020\u0012H\u0007¢\u0006\u0004\b\u0007\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0006H×\u0001¢\u0006\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0005\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0011\u0010\t\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\n\u0010\bR\u0011\u0010\n\u001a\u00020\u0006X\u0007¢\u0006\u0006\n\u0004\b\u0005\u0010\b"}, d2 = {"Lcom/appsflyer/internal/AFc1sSDK;", "AFa1zSDK", "", "AFInAppEventParameterName", "I", "AFInAppEventType", "", "AFKeystoreWrapper", "Ljava/lang/String;", "values", "valueOf", "", "p0", "", "equals", "(Ljava/lang/Object;)Z", "hashCode", "()I", "Lorg/json/JSONObject;", "()Lorg/json/JSONObject;", "toString", "()Ljava/lang/String;", "p1", "p2", "p3", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AFc1sSDK {
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK((DefaultConstructorMarker) null);
    public int AFInAppEventParameterName;
    public final String AFInAppEventType;
    public final String AFKeystoreWrapper;
    public final String valueOf;

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AFc1sSDK)) {
            return false;
        }
        AFc1sSDK aFc1sSDK = (AFc1sSDK) obj;
        return Intrinsics.areEqual((Object) this.valueOf, (Object) aFc1sSDK.valueOf) && Intrinsics.areEqual((Object) this.AFKeystoreWrapper, (Object) aFc1sSDK.AFKeystoreWrapper) && Intrinsics.areEqual((Object) this.AFInAppEventType, (Object) aFc1sSDK.AFInAppEventType) && this.AFInAppEventParameterName == aFc1sSDK.AFInAppEventParameterName;
    }

    public final int hashCode() {
        return (((((this.valueOf.hashCode() * 31) + this.AFKeystoreWrapper.hashCode()) * 31) + this.AFInAppEventType.hashCode()) * 31) + Integer.hashCode(this.AFInAppEventParameterName);
    }

    public final String toString() {
        return new StringBuilder("AFc1sSDK(AFKeystoreWrapper=").append(this.valueOf).append(", values=").append(this.AFKeystoreWrapper).append(", valueOf=").append(this.AFInAppEventType).append(", AFInAppEventType=").append(this.AFInAppEventParameterName).append(')').toString();
    }

    public AFc1sSDK(String str, String str2, String str3, int i) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str2, "");
        Intrinsics.checkNotNullParameter(str3, "");
        this.valueOf = str;
        this.AFKeystoreWrapper = str2;
        this.AFInAppEventType = str3;
        this.AFInAppEventParameterName = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFc1sSDK(String str, String str2, String str3, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, str3, (i2 & 8) != 0 ? 1 : i);
    }

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\u000fB\t\b\u0002¢\u0006\u0004\b\r\u0010\u000eJ1\u0010\u0007\u001a\u00020\u00062\b\u0010\u0002\u001a\u0004\u0018\u00010\u00012\u0016\u0010\u0005\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00040\u0003\"\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u0007\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0002\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/appsflyer/internal/AFc1sSDK$AFa1zSDK;", "", "p0", "", "", "p1", "", "AFInAppEventParameterName", "(Ljava/lang/Integer;[Ljava/lang/String;)Z", "Lcom/appsflyer/internal/AFc1sSDK;", "(Ljava/lang/String;)Lcom/appsflyer/internal/AFc1sSDK;", "valueOf", "(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1zSDK {
        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private AFa1zSDK() {
        }

        public static AFc1sSDK AFInAppEventParameterName(String str) {
            Intrinsics.checkNotNullParameter(str, "");
            List<String> split$default = StringsKt.split$default((CharSequence) str, new String[]{"\n"}, false, 0, 6, (Object) null);
            if (split$default.size() != 4) {
                return null;
            }
            String str2 = null;
            String str3 = null;
            String str4 = null;
            Integer num = null;
            for (String str5 : split$default) {
                if (!StringsKt.startsWith$default(str5, "label=", false, 2, (Object) null)) {
                    if (!StringsKt.startsWith$default(str5, "hashName=", false, 2, (Object) null)) {
                        if (!StringsKt.startsWith$default(str5, "stackTrace=", false, 2, (Object) null)) {
                            if (!StringsKt.startsWith$default(str5, "c=", false, 2, (Object) null)) {
                                break;
                            }
                            String substring = str5.substring(2);
                            Intrinsics.checkNotNullExpressionValue(substring, "");
                            num = Integer.valueOf(Integer.parseInt(StringsKt.trim((CharSequence) substring).toString()));
                        } else {
                            str4 = valueOf(str5, "stackTrace=");
                        }
                    } else {
                        str3 = valueOf(str5, "hashName=");
                    }
                } else {
                    str2 = valueOf(str5, "label=");
                }
            }
            if (AFInAppEventParameterName(num, str2, str3, str4)) {
                return null;
            }
            Intrinsics.checkNotNull(str2);
            Intrinsics.checkNotNull(str3);
            Intrinsics.checkNotNull(str4);
            Intrinsics.checkNotNull(num);
            return new AFc1sSDK(str2, str3, str4, num.intValue());
        }

        private static boolean AFInAppEventParameterName(Integer num, String... strArr) {
            boolean z;
            boolean z2 = num == null;
            int length = strArr.length;
            for (int i = 0; i < 3; i++) {
                String str = strArr[i];
                if (!z2) {
                    CharSequence charSequence = str;
                    if (!(charSequence == null || charSequence.length() == 0)) {
                        z = false;
                    }
                }
                z = true;
            }
            return z2;
        }

        private static String valueOf(String str, String str2) {
            String substring = str.substring(str2.length());
            Intrinsics.checkNotNullExpressionValue(substring, "");
            String obj = StringsKt.trim((CharSequence) substring).toString();
            Intrinsics.checkNotNullParameter(obj, "");
            byte[] bytes = obj.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "");
            Intrinsics.checkNotNullParameter(bytes, "");
            byte[] decode = Base64.decode(bytes, 2);
            Intrinsics.checkNotNullExpressionValue(decode, "");
            return new String(decode, Charsets.UTF_8);
        }
    }

    public final JSONObject AFKeystoreWrapper() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("label", (Object) this.valueOf);
        jSONObject.put("hash_name", (Object) this.AFKeystoreWrapper);
        jSONObject.put("st", (Object) this.AFInAppEventType);
        jSONObject.put("c", (Object) String.valueOf(this.AFInAppEventParameterName));
        return jSONObject;
    }
}
