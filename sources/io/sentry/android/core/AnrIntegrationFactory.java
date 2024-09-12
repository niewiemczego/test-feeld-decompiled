package io.sentry.android.core;

import android.content.Context;
import io.sentry.Integration;

public final class AnrIntegrationFactory {
    public static Integration create(Context context, BuildInfoProvider buildInfoProvider) {
        if (buildInfoProvider.getSdkInfoVersion() >= 30) {
            return new AnrV2Integration(context);
        }
        return new AnrIntegration(context);
    }
}
