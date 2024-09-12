package io.sentry;

import io.sentry.Scope;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.User;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public final class NoOpScope implements IScope {
    private static final NoOpScope instance = new NoOpScope();
    private final SentryOptions emptyOptions = SentryOptions.empty();

    public void addAttachment(Attachment attachment) {
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Hint hint) {
    }

    public void addEventProcessor(EventProcessor eventProcessor) {
    }

    public void clear() {
    }

    public void clearAttachments() {
    }

    public void clearBreadcrumbs() {
    }

    public void clearTransaction() {
    }

    public Session endSession() {
        return null;
    }

    public SentryLevel getLevel() {
        return null;
    }

    public Request getRequest() {
        return null;
    }

    public String getScreen() {
        return null;
    }

    public Session getSession() {
        return null;
    }

    public ISpan getSpan() {
        return null;
    }

    public ITransaction getTransaction() {
        return null;
    }

    public String getTransactionName() {
        return null;
    }

    public User getUser() {
        return null;
    }

    public void removeContexts(String str) {
    }

    public void removeExtra(String str) {
    }

    public void removeTag(String str) {
    }

    public void setContexts(String str, Boolean bool) {
    }

    public void setContexts(String str, Character ch) {
    }

    public void setContexts(String str, Number number) {
    }

    public void setContexts(String str, Object obj) {
    }

    public void setContexts(String str, String str2) {
    }

    public void setContexts(String str, Collection<?> collection) {
    }

    public void setContexts(String str, Object[] objArr) {
    }

    public void setExtra(String str, String str2) {
    }

    public void setFingerprint(List<String> list) {
    }

    public void setLevel(SentryLevel sentryLevel) {
    }

    public void setPropagationContext(PropagationContext propagationContext) {
    }

    public void setRequest(Request request) {
    }

    public void setScreen(String str) {
    }

    public void setTag(String str, String str2) {
    }

    public void setTransaction(ITransaction iTransaction) {
    }

    public void setTransaction(String str) {
    }

    public void setUser(User user) {
    }

    public Scope.SessionPair startSession() {
        return null;
    }

    public Session withSession(Scope.IWithSession iWithSession) {
        return null;
    }

    public void withTransaction(Scope.IWithTransaction iWithTransaction) {
    }

    private NoOpScope() {
    }

    public static NoOpScope getInstance() {
        return instance;
    }

    public List<String> getFingerprint() {
        return new ArrayList();
    }

    public Queue<Breadcrumb> getBreadcrumbs() {
        return new ArrayDeque();
    }

    public Map<String, String> getTags() {
        return new HashMap();
    }

    public Map<String, Object> getExtras() {
        return new HashMap();
    }

    public Contexts getContexts() {
        return new Contexts();
    }

    public List<Attachment> getAttachments() {
        return new ArrayList();
    }

    public List<EventProcessor> getEventProcessors() {
        return new ArrayList();
    }

    public SentryOptions getOptions() {
        return this.emptyOptions;
    }

    public PropagationContext getPropagationContext() {
        return new PropagationContext();
    }

    public PropagationContext withPropagationContext(Scope.IWithPropagationContext iWithPropagationContext) {
        return new PropagationContext();
    }

    public IScope clone() {
        return getInstance();
    }
}
