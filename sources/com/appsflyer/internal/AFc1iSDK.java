package com.appsflyer.internal;

import androidx.browser.trusted.sharing.ShareTarget;
import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.appsflyer.AppsFlyerLib;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\u0018\u0000 \u00012\u00020\r:\u0001\u0001BE\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0004\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0004\b\u000b\u0010\f"}, d2 = {"Lcom/appsflyer/internal/AFc1iSDK;", "AFa1wSDK", "", "p0", "", "p1", "", "p2", "p3", "", "p4", "<init>", "(Ljava/lang/String;Ljava/util/Map;[BLjava/lang/String;Z)V", "Lcom/appsflyer/internal/AFc1bSDK;"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class AFc1iSDK extends AFc1rSDK {
    public static final AFa1wSDK AFa1wSDK = new AFa1wSDK((DefaultConstructorMarker) null);

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ AFc1iSDK(String str, Map map, byte[] bArr, String str2, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, map, (i & 4) != 0 ? null : bArr, (i & 8) != 0 ? ShareTarget.METHOD_GET : str2, (i & 16) != 0 ? false : z);
    }

    private AFc1iSDK(String str, Map<String, String> map, byte[] bArr, String str2, boolean z) {
        super(str, bArr, str2, map, z);
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000b\n\u0002\u0010\u0000\b\u0003\u0018\u00002\u00020\rB\t\b\u0002¢\u0006\u0004\b\u000b\u0010\fJ=\u0010\u0007\u001a\u0006*\u00020\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\b\u0010\u0004\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0005\u001a\u00020\u00012\u0006\u0010\u0006\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u0007\u0010\bJ)\u0010\t\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\b\u0010\u0003\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0001H\u0002¢\u0006\u0004\b\t\u0010\n"}, d2 = {"Lcom/appsflyer/internal/AFc1iSDK$AFa1wSDK;", "", "p0", "p1", "p2", "p3", "p4", "valueOf", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "values", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;", "<init>", "()V", ""}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class AFa1wSDK {
        public /* synthetic */ AFa1wSDK(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private AFa1wSDK() {
        }

        static String values(String str, String str2, String str3) {
            return new StringBuilder().append(String.format(AFc1kSDK.AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), AFb1xSDK.AFInAppEventType().getHostName()})).append(str).append(str3).append("?device_id=").append(str2).toString();
        }

        public static String valueOf(String str, String str2, String str3, String str4, String str5) {
            Intrinsics.checkNotNullParameter(str, "");
            Intrinsics.checkNotNullParameter(str2, "");
            Intrinsics.checkNotNullParameter(str4, "");
            Intrinsics.checkNotNullParameter(str5, "");
            return AFb1ySDK.values(AFb1ySDK.AFKeystoreWrapper(str5, str3, new StringBuilder().append(str).append(str2).toString()), str4);
        }
    }

    @JvmStatic
    public static final AFc1iSDK AFKeystoreWrapper(String str, String str2, String str3, String str4) {
        Intrinsics.checkNotNullParameter(str, "");
        Intrinsics.checkNotNullParameter(str3, "");
        Intrinsics.checkNotNullParameter(str4, "");
        String values = AFa1wSDK.values(str, str2, str3);
        String valueOf = String.valueOf(System.currentTimeMillis());
        AFc1iSDK aFc1iSDK = new AFc1iSDK(values, MapsKt.mapOf(TuplesKt.to("Connection", AdaptyUIActionTypeAdapterFactory.TYPE_CLOSE), TuplesKt.to("af_request_epoch_ms", valueOf), TuplesKt.to("af_sig", AFa1wSDK.valueOf(str, str3, str2, str4, valueOf))), (byte[]) null, (String) null, false, 28, (DefaultConstructorMarker) null);
        aFc1iSDK.AFInAppEventParameterName(10000);
        return aFc1iSDK;
    }
}
