package com.adapty.internal.utils;

import com.adapty.internal.data.models.PaywallDto;
import com.adapty.internal.data.models.RemoteConfigDto;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\t0\bJ\u000e\u0010\n\u001a\u0004\u0018\u00010\t*\u00020\u0004H\u0002J\u0014\u0010\u000b\u001a\u00020\f*\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0002¨\u0006\u000e"}, d2 = {"Lcom/adapty/internal/utils/PaywallPicker;", "", "()V", "pick", "Lcom/adapty/internal/data/models/PaywallDto;", "cachedPaywall", "fallbackPaywall", "locales", "", "", "getLanguageCode", "isNewerThan", "", "other", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PaywallPicker.kt */
public final class PaywallPicker {
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        if ((r5.getPaywallId() != null && (r0.contains((java.lang.Object) null) || r0.contains(getLanguageCode(r5)))) != false) goto L_0x0062;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ com.adapty.internal.data.models.PaywallDto pick(com.adapty.internal.data.models.PaywallDto r5, com.adapty.internal.data.models.PaywallDto r6, java.util.Set r7) {
        /*
            r4 = this;
            java.lang.String r0 = "locales"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.Iterable r7 = (java.lang.Iterable) r7
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = 10
            int r1 = kotlin.collections.CollectionsKt.collectionSizeOrDefault(r7, r1)
            r0.<init>(r1)
            java.util.Collection r0 = (java.util.Collection) r0
            java.util.Iterator r7 = r7.iterator()
        L_0x0018:
            boolean r1 = r7.hasNext()
            r2 = 0
            if (r1 == 0) goto L_0x0041
            java.lang.Object r1 = r7.next()
            java.lang.String r1 = (java.lang.String) r1
            if (r1 == 0) goto L_0x003d
            java.lang.String r1 = com.adapty.internal.utils.UtilsKt.extractLanguageCode(r1)
            if (r1 == 0) goto L_0x003d
            java.util.Locale r2 = java.util.Locale.ENGLISH
            java.lang.String r3 = "ENGLISH"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.String r2 = r1.toLowerCase(r2)
            java.lang.String r1 = "this as java.lang.String).toLowerCase(locale)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r1)
        L_0x003d:
            r0.add(r2)
            goto L_0x0018
        L_0x0041:
            java.util.List r0 = (java.util.List) r0
            if (r5 == 0) goto L_0x0061
            java.lang.String r7 = r5.getPaywallId()
            if (r7 == 0) goto L_0x005d
            boolean r7 = r0.contains(r2)
            if (r7 != 0) goto L_0x005b
            java.lang.String r7 = r4.getLanguageCode(r5)
            boolean r7 = r0.contains(r7)
            if (r7 == 0) goto L_0x005d
        L_0x005b:
            r7 = 1
            goto L_0x005e
        L_0x005d:
            r7 = 0
        L_0x005e:
            if (r7 == 0) goto L_0x0061
            goto L_0x0062
        L_0x0061:
            r5 = r2
        L_0x0062:
            if (r5 != 0) goto L_0x0065
            goto L_0x006f
        L_0x0065:
            if (r6 != 0) goto L_0x0068
            goto L_0x006e
        L_0x0068:
            boolean r7 = r4.isNewerThan(r5, r6)
            if (r7 == 0) goto L_0x006f
        L_0x006e:
            r6 = r5
        L_0x006f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.utils.PaywallPicker.pick(com.adapty.internal.data.models.PaywallDto, com.adapty.internal.data.models.PaywallDto, java.util.Set):com.adapty.internal.data.models.PaywallDto");
    }

    private final boolean isNewerThan(PaywallDto paywallDto, PaywallDto paywallDto2) {
        Long updatedAt = paywallDto.getUpdatedAt();
        long j = 0;
        long longValue = updatedAt != null ? updatedAt.longValue() : 0;
        Long updatedAt2 = paywallDto2.getUpdatedAt();
        if (updatedAt2 != null) {
            j = updatedAt2.longValue();
        }
        return longValue >= j;
    }

    private final String getLanguageCode(PaywallDto paywallDto) {
        String lang;
        List split$default;
        String str;
        RemoteConfigDto remoteConfig = paywallDto.getRemoteConfig();
        if (remoteConfig == null || (lang = remoteConfig.getLang()) == null || (split$default = StringsKt.split$default((CharSequence) lang, new String[]{"-"}, false, 0, 6, (Object) null)) == null || (str = (String) CollectionsKt.getOrNull(split$default, 0)) == null) {
            return null;
        }
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return lowerCase;
    }
}
