package com.adapty.internal.crossplatform;

import com.adapty.models.AdaptyAttributionSource;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\t"}, d2 = {"Lcom/adapty/internal/crossplatform/EnumConverter;", "", "()V", "toAttributionSourceType", "Lcom/adapty/models/AdaptyAttributionSource;", "value", "", "toLogLevel", "Lcom/adapty/utils/AdaptyLogLevel;", "crossplatform_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: EnumConverter.kt */
public final class EnumConverter {
    public final AdaptyAttributionSource toAttributionSourceType(String str) {
        if (str != null) {
            switch (str.hashCode()) {
                case -1892076242:
                    if (str.equals("appsflyer")) {
                        return AdaptyAttributionSource.APPSFLYER;
                    }
                    break;
                case -1422313585:
                    if (str.equals("adjust")) {
                        return AdaptyAttributionSource.ADJUST;
                    }
                    break;
                case -1381030494:
                    if (str.equals("branch")) {
                        return AdaptyAttributionSource.BRANCH;
                    }
                    break;
                case -1349088399:
                    if (str.equals(AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM)) {
                        return AdaptyAttributionSource.CUSTOM;
                    }
                    break;
            }
        }
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:?, code lost:
        return com.adapty.utils.AdaptyLogLevel.VERBOSE;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0010, code lost:
        if (r2.equals(app.notifee.core.event.LogEvent.LEVEL_VERBOSE) == false) goto L_0x004f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0025, code lost:
        if (r2.equals(app.notifee.core.event.LogEvent.LEVEL_DEBUG) == false) goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.adapty.utils.AdaptyLogLevel toLogLevel(java.lang.String r2) {
        /*
            r1 = this;
            if (r2 == 0) goto L_0x004f
            int r0 = r2.hashCode()
            switch(r0) {
                case 3237038: goto L_0x0043;
                case 3387192: goto L_0x0037;
                case 3641990: goto L_0x002b;
                case 95458899: goto L_0x001f;
                case 96784904: goto L_0x0013;
                case 351107458: goto L_0x000a;
                default: goto L_0x0009;
            }
        L_0x0009:
            goto L_0x004f
        L_0x000a:
            java.lang.String r0 = "verbose"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0028
            goto L_0x004f
        L_0x0013:
            java.lang.String r0 = "error"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x001c
            goto L_0x004f
        L_0x001c:
            com.adapty.utils.AdaptyLogLevel r2 = com.adapty.utils.AdaptyLogLevel.ERROR
            goto L_0x0050
        L_0x001f:
            java.lang.String r0 = "debug"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0028
            goto L_0x004f
        L_0x0028:
            com.adapty.utils.AdaptyLogLevel r2 = com.adapty.utils.AdaptyLogLevel.VERBOSE
            goto L_0x0050
        L_0x002b:
            java.lang.String r0 = "warn"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0034
            goto L_0x004f
        L_0x0034:
            com.adapty.utils.AdaptyLogLevel r2 = com.adapty.utils.AdaptyLogLevel.WARN
            goto L_0x0050
        L_0x0037:
            java.lang.String r0 = "none"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0040
            goto L_0x004f
        L_0x0040:
            com.adapty.utils.AdaptyLogLevel r2 = com.adapty.utils.AdaptyLogLevel.NONE
            goto L_0x0050
        L_0x0043:
            java.lang.String r0 = "info"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x004c
            goto L_0x004f
        L_0x004c:
            com.adapty.utils.AdaptyLogLevel r2 = com.adapty.utils.AdaptyLogLevel.INFO
            goto L_0x0050
        L_0x004f:
            r2 = 0
        L_0x0050:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.crossplatform.EnumConverter.toLogLevel(java.lang.String):com.adapty.utils.AdaptyLogLevel");
    }
}
