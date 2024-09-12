package io.sentry;

import com.facebook.hermes.intl.Constants;
import com.google.android.gms.common.Scopes;
import io.sentry.cache.EnvelopeCache;

public enum DataCategory {
    All("__all__"),
    Default(Constants.COLLATION_DEFAULT),
    Error("error"),
    Session(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE),
    Attachment("attachment"),
    Monitor("monitor"),
    Profile(Scopes.PROFILE),
    MetricBucket("metric_bucket"),
    Transaction("transaction"),
    Security("security"),
    UserReport("user_report"),
    Unknown("unknown");
    
    private final String category;

    private DataCategory(String str) {
        this.category = str;
    }

    public String getCategory() {
        return this.category;
    }
}
