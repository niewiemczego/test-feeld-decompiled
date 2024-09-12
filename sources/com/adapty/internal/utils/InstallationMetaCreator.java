package com.adapty.internal.utils;

import com.adapty.internal.data.models.InstallationMeta;
import io.sentry.protocol.OperatingSystem;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0001\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/adapty/internal/utils/InstallationMetaCreator;", "", "metaInfoRetriever", "Lcom/adapty/internal/utils/MetaInfoRetriever;", "(Lcom/adapty/internal/utils/MetaInfoRetriever;)V", "create", "Lcom/adapty/internal/data/models/InstallationMeta;", "adId", "", "appSetId", "storeCountry", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InstallationMetaCreator.kt */
public final class InstallationMetaCreator {
    private final MetaInfoRetriever metaInfoRetriever;

    public InstallationMetaCreator(MetaInfoRetriever metaInfoRetriever2) {
        Intrinsics.checkNotNullParameter(metaInfoRetriever2, "metaInfoRetriever");
        this.metaInfoRetriever = metaInfoRetriever2;
    }

    public final InstallationMeta create(String str, String str2, String str3) {
        String str4 = str3;
        Intrinsics.checkNotNullParameter(str, "adId");
        Intrinsics.checkNotNullParameter(str2, "appSetId");
        Intrinsics.checkNotNullParameter(str4, "storeCountry");
        Pair appBuildAndVersion = this.metaInfoRetriever.getAppBuildAndVersion();
        String str5 = (String) appBuildAndVersion.component1();
        String str6 = (String) appBuildAndVersion.component2();
        String installationMetaId = this.metaInfoRetriever.getInstallationMetaId();
        String adaptySdkVersion = this.metaInfoRetriever.getAdaptySdkVersion();
        String androidId = this.metaInfoRetriever.getAndroidId();
        String deviceName = this.metaInfoRetriever.getDeviceName();
        String currentLocaleFormatted = this.metaInfoRetriever.getCurrentLocaleFormatted();
        String os = this.metaInfoRetriever.getOs();
        String platform = this.metaInfoRetriever.getPlatform();
        if (!(str4.length() > 0)) {
            str4 = null;
        }
        String str7 = str4;
        String timezone = this.metaInfoRetriever.getTimezone();
        String userAgent = this.metaInfoRetriever.getUserAgent();
        Intrinsics.checkNotNullExpressionValue(os, OperatingSystem.TYPE);
        Intrinsics.checkNotNullExpressionValue(timezone, "timezone");
        Intrinsics.checkNotNullExpressionValue(androidId, "androidId");
        return new InstallationMeta(installationMetaId, adaptySdkVersion, str5, str6, deviceName, currentLocaleFormatted, os, platform, timezone, userAgent, str, str2, androidId, str7);
    }
}
