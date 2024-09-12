package com.adapty.internal.utils;

import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0001\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bJ\u0016\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/adapty/internal/utils/PayloadProvider;", "", "hashingHelper", "Lcom/adapty/internal/utils/HashingHelper;", "metaInfoRetriever", "Lcom/adapty/internal/utils/MetaInfoRetriever;", "(Lcom/adapty/internal/utils/HashingHelper;Lcom/adapty/internal/utils/MetaInfoRetriever;)V", "getPayloadHashForPaywallBuilderRequest", "", "locale", "builderVersion", "getPayloadHashForPaywallRequest", "segmentId", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PayloadProvider.kt */
public final class PayloadProvider {
    private final HashingHelper hashingHelper;
    private final MetaInfoRetriever metaInfoRetriever;

    public PayloadProvider(HashingHelper hashingHelper2, MetaInfoRetriever metaInfoRetriever2) {
        Intrinsics.checkNotNullParameter(hashingHelper2, "hashingHelper");
        Intrinsics.checkNotNullParameter(metaInfoRetriever2, "metaInfoRetriever");
        this.hashingHelper = hashingHelper2;
        this.metaInfoRetriever = metaInfoRetriever2;
    }

    public final String getPayloadHashForPaywallRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "locale");
        Intrinsics.checkNotNullParameter(str2, "segmentId");
        StringBuilder append = new StringBuilder().append("{\"locale\":\"");
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return this.hashingHelper.md5(append.append(lowerCase).append("\",\"segment_hash\":\"").append(str2).append("\",\"store\":\"").append(this.metaInfoRetriever.getStore()).append("\"}").toString());
    }

    public final String getPayloadHashForPaywallBuilderRequest(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "locale");
        Intrinsics.checkNotNullParameter(str2, "builderVersion");
        StringBuilder append = new StringBuilder().append("{\"builder_version\":\"").append(str2).append("\",\"locale\":\"");
        Locale locale = Locale.ENGLISH;
        Intrinsics.checkNotNullExpressionValue(locale, ViewHierarchyConstants.ENGLISH);
        String lowerCase = str.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        return this.hashingHelper.md5(append.append(lowerCase).append("\"}").toString());
    }
}
