package com.appsflyer.internal;

import android.util.Base64;
import com.appsflyer.AFLogger;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.Charsets;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0000\b\u0016\u0018\u0000 \u00012\u00020\u0017:\u0001\u0001B\u0017\u0012\u0006\u0010\u0013\u001a\u00020\t\u0012\u0006\u0010\u0014\u001a\u00020\u000f¢\u0006\u0004\b\u0015\u0010\u0016R\u0013\u0010\u0005\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\u0003\u0010\u0004R\u0013\u0010\u0006\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\u0006\u0010\u0004R\u0011\u0010\b\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\u000b\u001a\u00020\t8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010\nR\u0014\u0010\u000e\u001a\u00020\f8CX\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\rR\u0014\u0010\u0011\u001a\u00020\u000f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010\u0010R\u0011\u0010\u0012\u001a\u00020\u00028G¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0007"}, d2 = {"Lcom/appsflyer/internal/AFd1xSDK;", "AFa1wSDK", "", "afDebugLog", "Lkotlin/Lazy;", "values", "AFInAppEventParameterName", "()Ljava/lang/String;", "AFKeystoreWrapper", "Lcom/appsflyer/internal/AFb1bSDK;", "Lcom/appsflyer/internal/AFb1bSDK;", "valueOf", "", "()Z", "AFInAppEventType", "Lcom/appsflyer/internal/AFc1xSDK;", "Lcom/appsflyer/internal/AFc1xSDK;", "afRDLog", "afErrorLog", "p0", "p1", "<init>", "(Lcom/appsflyer/internal/AFb1bSDK;Lcom/appsflyer/internal/AFc1xSDK;)V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
public class AFd1xSDK {
    public static String AFInAppEventType = "https://%scdn-%ssettings.%s/android/v1/%s/settings";
    /* access modifiers changed from: private */
    public static AFd1zSDK AFLogger;
    public static final AFa1wSDK AFa1wSDK = new AFa1wSDK((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final List<String> afRDLog = CollectionsKt.listOf("googleplay", "playstore", "googleplaystore");
    public static String values = "https://%scdn-%stestsettings.%s/android/v1/%s/settings";
    public final Lazy AFInAppEventParameterName = LazyKt.lazy(new Function0<String>(this) {
        private /* synthetic */ AFd1xSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: values */
        public final String invoke() {
            String packageName = this.AFInAppEventParameterName.AFKeystoreWrapper.values.AFKeystoreWrapper.getPackageName();
            Intrinsics.checkNotNullExpressionValue(packageName, "");
            return AFd1xSDK.values(packageName, AFd1xSDK.valueOf(this.AFInAppEventParameterName));
        }
    });
    /* access modifiers changed from: private */
    public final AFb1bSDK AFKeystoreWrapper;
    private final Lazy afDebugLog = LazyKt.lazy(new Function0<String>(this) {
        private /* synthetic */ AFd1xSDK AFInAppEventParameterName;

        {
            this.AFInAppEventParameterName = r1;
        }

        /* renamed from: valueOf */
        public final String invoke() {
            String values = AFb1xSDK.values(this.AFInAppEventParameterName.valueOf, this.AFInAppEventParameterName.AFKeystoreWrapper.values());
            CharSequence charSequence = values;
            String str = "";
            if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                String obj = StringsKt.trim(charSequence).toString();
                AFa1wSDK aFa1wSDK = AFd1xSDK.AFa1wSDK;
                List<String> AFInAppEventParameterName2 = AFa1wSDK.AFInAppEventParameterName();
                Locale locale = Locale.getDefault();
                Intrinsics.checkNotNullExpressionValue(locale, str);
                String lowerCase = obj.toLowerCase(locale);
                Intrinsics.checkNotNullExpressionValue(lowerCase, str);
                if (!AFInAppEventParameterName2.contains(lowerCase)) {
                    values = "-".concat(String.valueOf(obj));
                } else {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    String format = String.format("AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix.", Arrays.copyOf(new Object[]{obj}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, str);
                    AFLogger.afWarnLog(format);
                    values = str;
                }
            }
            if (values != null) {
                str = values;
            }
            return StringsKt.trim((CharSequence) str).toString();
        }
    });
    /* access modifiers changed from: private */
    public final AFc1xSDK valueOf;

    public /* synthetic */ class AFa1zSDK {
        public static final /* synthetic */ int[] AFInAppEventType;

        static {
            int[] iArr = new int[AFd1vSDK.values().length];
            iArr[AFd1vSDK.DEFAULT.ordinal()] = 1;
            iArr[AFd1vSDK.API.ordinal()] = 2;
            iArr[AFd1vSDK.RC.ordinal()] = 3;
            AFInAppEventType = iArr;
        }
    }

    public static final void values(AFd1zSDK aFd1zSDK) {
        AFa1wSDK.AFKeystoreWrapper(aFd1zSDK);
    }

    public AFd1xSDK(AFb1bSDK aFb1bSDK, AFc1xSDK aFc1xSDK) {
        Intrinsics.checkNotNullParameter(aFb1bSDK, "");
        Intrinsics.checkNotNullParameter(aFc1xSDK, "");
        this.AFKeystoreWrapper = aFb1bSDK;
        this.valueOf = aFc1xSDK;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\u0012B\t\b\u0002¢\u0006\u0004\b\u0010\u0010\u0011R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00018\u0007X\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\t\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\u0007\u0010\bR\u0012\u0010\u000b\u001a\u00020\u0002X\u0002¢\u0006\u0006\n\u0004\b\n\u0010\bR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\f@\u0007X\n¢\u0006\f\n\u0004\b\r\u0010\u000e\"\u0004\b\u000b\u0010\u000f"}, d2 = {"Lcom/appsflyer/internal/AFd1xSDK$AFa1wSDK;", "", "", "afRDLog", "Ljava/util/List;", "AFInAppEventParameterName", "()Ljava/util/List;", "AFInAppEventType", "Ljava/lang/String;", "valueOf", "values", "AFKeystoreWrapper", "Lcom/appsflyer/internal/AFd1zSDK;", "AFLogger", "Lcom/appsflyer/internal/AFd1zSDK;", "(Lcom/appsflyer/internal/AFd1zSDK;)V", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1wSDK {
        public /* synthetic */ AFa1wSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private AFa1wSDK() {
        }

        public static List<String> AFInAppEventParameterName() {
            return AFd1xSDK.afRDLog;
        }

        public static void AFKeystoreWrapper(AFd1zSDK aFd1zSDK) {
            AFd1xSDK.AFLogger = aFd1zSDK;
        }
    }

    public static boolean valueOf() {
        return AFLogger == null;
    }

    public final String values() {
        AFd1vSDK aFd1vSDK;
        String str;
        if (valueOf()) {
            aFd1vSDK = AFd1vSDK.DEFAULT;
        } else {
            aFd1vSDK = AFd1vSDK.API;
        }
        int i = AFa1zSDK.AFInAppEventType[aFd1vSDK.ordinal()];
        if (i == 1) {
            return (String) this.AFInAppEventParameterName.getValue();
        }
        if (i == 2) {
            AFd1zSDK aFd1zSDK = AFLogger;
            if (aFd1zSDK != null) {
                str = aFd1zSDK.values;
            } else {
                str = null;
            }
            if (str == null) {
                return "";
            }
            return str;
        } else if (i == 3) {
            return "";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public final String AFInAppEventParameterName() {
        AFd1vSDK aFd1vSDK;
        if (valueOf()) {
            aFd1vSDK = AFd1vSDK.DEFAULT;
        } else {
            aFd1vSDK = AFd1vSDK.API;
        }
        int i = AFa1zSDK.AFInAppEventType[aFd1vSDK.ordinal()];
        if (i == 1) {
            return "appsflyersdk.com";
        }
        if (i == 2) {
            AFd1zSDK aFd1zSDK = AFLogger;
            String str = aFd1zSDK != null ? aFd1zSDK.AFInAppEventType : null;
            if (str == null) {
                return "";
            }
            return str;
        } else if (i == 3) {
            return "";
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static final /* synthetic */ String values(String str, String str2) {
        StringBuilder sb = new StringBuilder();
        String obj = new StringBuilder().append(str).append(str2).toString();
        Intrinsics.checkNotNullParameter(obj, "");
        MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
        byte[] bytes = obj.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue(bytes, "");
        byte[] digest = instance.digest(bytes);
        Intrinsics.checkNotNullExpressionValue(digest, "");
        String encodeToString = Base64.encodeToString(digest, 2);
        Intrinsics.checkNotNullExpressionValue(encodeToString, "");
        String lowerCase = encodeToString.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "");
        String substring = new Regex("[^\\w]+").replace((CharSequence) lowerCase, "").substring(0, 6);
        Intrinsics.checkNotNullExpressionValue(substring, "");
        return sb.append(substring).append('-').toString();
    }

    public static final /* synthetic */ String valueOf(AFd1xSDK aFd1xSDK) {
        return (String) aFd1xSDK.afDebugLog.getValue();
    }
}
