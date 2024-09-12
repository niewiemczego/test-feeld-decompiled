package com.appsflyer.internal;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0000\u0018\u0000 \u00012\u00020\u0012:\u0001\u0001B\u001b\b\u0007\u0012\u0006\u0010\u000b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\r\u001a\u00020\f*\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\r\u0010\u000eR\u0014\u0010\u0005\u001a\u00020\u00028\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b"}, d2 = {"Lcom/appsflyer/internal/AFf1gSDK;", "AFa1zSDK", "Lcom/appsflyer/internal/AFf1bSDK;", "AFInAppEventParameterName", "Lcom/appsflyer/internal/AFf1bSDK;", "AFInAppEventType", "Lcom/appsflyer/internal/AFc1vSDK;", "valueOf", "Lcom/appsflyer/internal/AFc1vSDK;", "values", "", "p0", "", "AFKeystoreWrapper", "(Ljava/lang/String;Z)Ljava/lang/String;", "p1", "<init>", "(Lcom/appsflyer/internal/AFc1vSDK;Lcom/appsflyer/internal/AFf1bSDK;)V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AFf1gSDK {
    public static final String AFInAppEventType;
    public static final String AFKeystoreWrapper = "https://%sadrevenue.%s/api/v2/generic/v6.10.3/android?app_id=";
    public static String AFLogger;
    private static final String AFVersionDeclaration;
    public static final AFa1zSDK AFa1zSDK = new AFa1zSDK((DefaultConstructorMarker) null);
    public static String afDebugLog;
    public static final String afErrorLog;
    public static final String afInfoLog;
    public static String afRDLog;
    public static String afWarnLog;
    public static String getLevel;
    public static final String values;
    public final AFf1bSDK AFInAppEventParameterName;
    public final AFc1vSDK valueOf;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AFf1gSDK(AFc1vSDK aFc1vSDK) {
        this(aFc1vSDK, (AFf1bSDK) null, 2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(aFc1vSDK, "");
    }

    private AFf1gSDK(AFc1vSDK aFc1vSDK, AFf1bSDK aFf1bSDK) {
        Intrinsics.checkNotNullParameter(aFc1vSDK, "");
        Intrinsics.checkNotNullParameter(aFf1bSDK, "");
        this.valueOf = aFc1vSDK;
        this.AFInAppEventParameterName = aFf1bSDK;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AFf1gSDK(AFc1vSDK aFc1vSDK, AFf1bSDK aFf1bSDK, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(aFc1vSDK, (i & 2) != 0 ? new AFf1fSDK() : aFf1bSDK);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0011\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\u0013B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0004\u001a\u00020\u00018\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0006\u001a\u00020\u00018\u0006XD¢\u0006\u0006\n\u0004\b\u0005\u0010\u0003R\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010\u0003R\u0014\u0010\b\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0003R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\t\u0010\u0003R\u0014\u0010\u0007\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0003R\u0018\u0010\r\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\f\u0010\u0003R\u0014\u0010\u000b\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u0003R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u000e\u0010\u0003R\u0014\u0010\t\u001a\u00020\u00018\u0006X\u0004¢\u0006\u0006\n\u0004\b\u0004\u0010\u0003R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u00018\u0006@\u0006X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010\u0003"}, d2 = {"Lcom/appsflyer/internal/AFf1gSDK$AFa1zSDK;", "", "AFVersionDeclaration", "Ljava/lang/String;", "AFInAppEventType", "AFKeystoreWrapper", "values", "AFLogger", "AFInAppEventParameterName", "afDebugLog", "valueOf", "afErrorLog", "getLevel", "afInfoLog", "afWarnLog", "afRDLog", "afErrorLogForExcManagerOnly", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1zSDK {
        public /* synthetic */ AFa1zSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private AFa1zSDK() {
        }
    }

    static {
        String obj = new StringBuilder().append(AFb1xSDK.AFKeystoreWrapper).append("/androidevent?app_id=").toString();
        AFVersionDeclaration = obj;
        AFInAppEventType = new StringBuilder("https://%sattr.%s/api/v").append(obj).toString();
        values = new StringBuilder("https://%sconversions.%s/api/v").append(obj).toString();
        afInfoLog = new StringBuilder("https://%slaunches.%s/api/v").append(obj).toString();
        afErrorLog = new StringBuilder("https://%sinapps.%s/api/v").append(obj).toString();
    }

    public static String AFKeystoreWrapper(String str, boolean z) {
        return new StringBuilder().append(str).append(!z ? "&buildnumber=6.10.3" : "").toString();
    }
}
