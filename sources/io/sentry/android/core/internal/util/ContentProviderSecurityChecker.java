package io.sentry.android.core.internal.util;

import android.content.ContentProvider;
import io.sentry.NoOpLogger;
import io.sentry.android.core.BuildInfoProvider;

public final class ContentProviderSecurityChecker {
    private final BuildInfoProvider buildInfoProvider;

    public ContentProviderSecurityChecker() {
        this(new BuildInfoProvider(NoOpLogger.getInstance()));
    }

    public ContentProviderSecurityChecker(BuildInfoProvider buildInfoProvider2) {
        this.buildInfoProvider = buildInfoProvider2;
    }

    public void checkPrivilegeEscalation(ContentProvider contentProvider) {
        int sdkInfoVersion = this.buildInfoProvider.getSdkInfoVersion();
        if (sdkInfoVersion >= 26 && sdkInfoVersion <= 28) {
            String callingPackage = contentProvider.getCallingPackage();
            String packageName = contentProvider.getContext().getPackageName();
            if (callingPackage == null || !callingPackage.equals(packageName)) {
                throw new SecurityException("Provider does not allow for granting of Uri permissions");
            }
        }
    }
}
