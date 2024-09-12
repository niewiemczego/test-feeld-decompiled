package io.sentry;

import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.User;
import java.util.Collection;
import java.util.Map;

public abstract class ScopeObserverAdapter implements IScopeObserver {
    public void addBreadcrumb(Breadcrumb breadcrumb) {
    }

    public void removeExtra(String str) {
    }

    public void removeTag(String str) {
    }

    public void setBreadcrumbs(Collection<Breadcrumb> collection) {
    }

    public void setContexts(Contexts contexts) {
    }

    public void setExtra(String str, String str2) {
    }

    public void setExtras(Map<String, Object> map) {
    }

    public void setFingerprint(Collection<String> collection) {
    }

    public void setLevel(SentryLevel sentryLevel) {
    }

    public void setRequest(Request request) {
    }

    public void setTag(String str, String str2) {
    }

    public void setTags(Map<String, String> map) {
    }

    public void setTrace(SpanContext spanContext) {
    }

    public void setTransaction(String str) {
    }

    public void setUser(User user) {
    }
}
