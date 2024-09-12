package io.sentry;

import io.sentry.SentryOptions;
import io.sentry.protocol.App;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.Request;
import io.sentry.protocol.TransactionNameSource;
import io.sentry.protocol.User;
import io.sentry.util.CollectionUtils;
import io.sentry.util.Objects;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public final class Scope implements IScope {
    private List<Attachment> attachments = new CopyOnWriteArrayList();
    private final Queue<Breadcrumb> breadcrumbs;
    private Contexts contexts = new Contexts();
    private List<EventProcessor> eventProcessors = new CopyOnWriteArrayList();
    private Map<String, Object> extra = new ConcurrentHashMap();
    private List<String> fingerprint = new ArrayList();
    private SentryLevel level;
    private final SentryOptions options;
    private PropagationContext propagationContext;
    private final Object propagationContextLock = new Object();
    private Request request;
    private String screen;
    private volatile Session session;
    private final Object sessionLock = new Object();
    private Map<String, String> tags = new ConcurrentHashMap();
    private ITransaction transaction;
    private final Object transactionLock = new Object();
    private String transactionName;
    private User user;

    public interface IWithPropagationContext {
        void accept(PropagationContext propagationContext);
    }

    interface IWithSession {
        void accept(Session session);
    }

    public interface IWithTransaction {
        void accept(ITransaction iTransaction);
    }

    public Scope(SentryOptions sentryOptions) {
        SentryOptions sentryOptions2 = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.options = sentryOptions2;
        this.breadcrumbs = createBreadcrumbsList(sentryOptions2.getMaxBreadcrumbs());
        this.propagationContext = new PropagationContext();
    }

    private Scope(Scope scope) {
        this.transaction = scope.transaction;
        this.transactionName = scope.transactionName;
        this.session = scope.session;
        this.options = scope.options;
        this.level = scope.level;
        User user2 = scope.user;
        Request request2 = null;
        this.user = user2 != null ? new User(user2) : null;
        this.screen = scope.screen;
        Request request3 = scope.request;
        this.request = request3 != null ? new Request(request3) : request2;
        this.fingerprint = new ArrayList(scope.fingerprint);
        this.eventProcessors = new CopyOnWriteArrayList(scope.eventProcessors);
        Breadcrumb[] breadcrumbArr = (Breadcrumb[]) scope.breadcrumbs.toArray(new Breadcrumb[0]);
        Queue<Breadcrumb> createBreadcrumbsList = createBreadcrumbsList(scope.options.getMaxBreadcrumbs());
        for (Breadcrumb breadcrumb : breadcrumbArr) {
            createBreadcrumbsList.add(new Breadcrumb(breadcrumb));
        }
        this.breadcrumbs = createBreadcrumbsList;
        Map<String, String> map = scope.tags;
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        for (Map.Entry next : map.entrySet()) {
            if (next != null) {
                concurrentHashMap.put((String) next.getKey(), (String) next.getValue());
            }
        }
        this.tags = concurrentHashMap;
        Map<String, Object> map2 = scope.extra;
        ConcurrentHashMap concurrentHashMap2 = new ConcurrentHashMap();
        for (Map.Entry next2 : map2.entrySet()) {
            if (next2 != null) {
                concurrentHashMap2.put((String) next2.getKey(), next2.getValue());
            }
        }
        this.extra = concurrentHashMap2;
        this.contexts = new Contexts(scope.contexts);
        this.attachments = new CopyOnWriteArrayList(scope.attachments);
        this.propagationContext = new PropagationContext(scope.propagationContext);
    }

    public SentryLevel getLevel() {
        return this.level;
    }

    public void setLevel(SentryLevel sentryLevel) {
        this.level = sentryLevel;
        for (IScopeObserver level2 : this.options.getScopeObservers()) {
            level2.setLevel(sentryLevel);
        }
    }

    public String getTransactionName() {
        ITransaction iTransaction = this.transaction;
        return iTransaction != null ? iTransaction.getName() : this.transactionName;
    }

    public void setTransaction(String str) {
        if (str != null) {
            ITransaction iTransaction = this.transaction;
            if (iTransaction != null) {
                iTransaction.setName(str, TransactionNameSource.CUSTOM);
            }
            this.transactionName = str;
            for (IScopeObserver transaction2 : this.options.getScopeObservers()) {
                transaction2.setTransaction(str);
            }
            return;
        }
        this.options.getLogger().log(SentryLevel.WARNING, "Transaction cannot be null", new Object[0]);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r0.getLatestActiveSpan();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.ISpan getSpan() {
        /*
            r2 = this;
            io.sentry.ITransaction r0 = r2.transaction
            if (r0 == 0) goto L_0x000b
            io.sentry.Span r1 = r0.getLatestActiveSpan()
            if (r1 == 0) goto L_0x000b
            return r1
        L_0x000b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.Scope.getSpan():io.sentry.ISpan");
    }

    public void setTransaction(ITransaction iTransaction) {
        synchronized (this.transactionLock) {
            this.transaction = iTransaction;
            for (IScopeObserver next : this.options.getScopeObservers()) {
                if (iTransaction != null) {
                    next.setTransaction(iTransaction.getName());
                    next.setTrace(iTransaction.getSpanContext());
                } else {
                    next.setTransaction((String) null);
                    next.setTrace((SpanContext) null);
                }
            }
        }
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user2) {
        this.user = user2;
        for (IScopeObserver user3 : this.options.getScopeObservers()) {
            user3.setUser(user2);
        }
    }

    public String getScreen() {
        return this.screen;
    }

    public void setScreen(String str) {
        this.screen = str;
        Contexts contexts2 = getContexts();
        App app2 = contexts2.getApp();
        if (app2 == null) {
            app2 = new App();
            contexts2.setApp(app2);
        }
        if (str == null) {
            app2.setViewNames((List<String>) null);
        } else {
            ArrayList arrayList = new ArrayList(1);
            arrayList.add(str);
            app2.setViewNames(arrayList);
        }
        for (IScopeObserver contexts3 : this.options.getScopeObservers()) {
            contexts3.setContexts(contexts2);
        }
    }

    public Request getRequest() {
        return this.request;
    }

    public void setRequest(Request request2) {
        this.request = request2;
        for (IScopeObserver request3 : this.options.getScopeObservers()) {
            request3.setRequest(request2);
        }
    }

    public List<String> getFingerprint() {
        return this.fingerprint;
    }

    public void setFingerprint(List<String> list) {
        if (list != null) {
            this.fingerprint = new ArrayList(list);
            for (IScopeObserver fingerprint2 : this.options.getScopeObservers()) {
                fingerprint2.setFingerprint(list);
            }
        }
    }

    public Queue<Breadcrumb> getBreadcrumbs() {
        return this.breadcrumbs;
    }

    private Breadcrumb executeBeforeBreadcrumb(SentryOptions.BeforeBreadcrumbCallback beforeBreadcrumbCallback, Breadcrumb breadcrumb, Hint hint) {
        try {
            return beforeBreadcrumbCallback.execute(breadcrumb, hint);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeBreadcrumbCallback callback threw an exception. Exception details will be added to the breadcrumb.", th);
            if (th.getMessage() == null) {
                return breadcrumb;
            }
            breadcrumb.setData("sentry:message", th.getMessage());
            return breadcrumb;
        }
    }

    public void addBreadcrumb(Breadcrumb breadcrumb, Hint hint) {
        if (breadcrumb != null) {
            if (hint == null) {
                hint = new Hint();
            }
            SentryOptions.BeforeBreadcrumbCallback beforeBreadcrumb = this.options.getBeforeBreadcrumb();
            if (beforeBreadcrumb != null) {
                breadcrumb = executeBeforeBreadcrumb(beforeBreadcrumb, breadcrumb, hint);
            }
            if (breadcrumb != null) {
                this.breadcrumbs.add(breadcrumb);
                for (IScopeObserver next : this.options.getScopeObservers()) {
                    next.addBreadcrumb(breadcrumb);
                    next.setBreadcrumbs(this.breadcrumbs);
                }
                return;
            }
            this.options.getLogger().log(SentryLevel.INFO, "Breadcrumb was dropped by beforeBreadcrumb", new Object[0]);
        }
    }

    public void addBreadcrumb(Breadcrumb breadcrumb) {
        addBreadcrumb(breadcrumb, (Hint) null);
    }

    public void clearBreadcrumbs() {
        this.breadcrumbs.clear();
        for (IScopeObserver breadcrumbs2 : this.options.getScopeObservers()) {
            breadcrumbs2.setBreadcrumbs(this.breadcrumbs);
        }
    }

    public void clearTransaction() {
        synchronized (this.transactionLock) {
            this.transaction = null;
        }
        this.transactionName = null;
        for (IScopeObserver next : this.options.getScopeObservers()) {
            next.setTransaction((String) null);
            next.setTrace((SpanContext) null);
        }
    }

    public ITransaction getTransaction() {
        return this.transaction;
    }

    public void clear() {
        this.level = null;
        this.user = null;
        this.request = null;
        this.screen = null;
        this.fingerprint.clear();
        clearBreadcrumbs();
        this.tags.clear();
        this.extra.clear();
        this.eventProcessors.clear();
        clearTransaction();
        clearAttachments();
    }

    public Map<String, String> getTags() {
        return CollectionUtils.newConcurrentHashMap(this.tags);
    }

    public void setTag(String str, String str2) {
        this.tags.put(str, str2);
        for (IScopeObserver next : this.options.getScopeObservers()) {
            next.setTag(str, str2);
            next.setTags(this.tags);
        }
    }

    public void removeTag(String str) {
        this.tags.remove(str);
        for (IScopeObserver next : this.options.getScopeObservers()) {
            next.removeTag(str);
            next.setTags(this.tags);
        }
    }

    public Map<String, Object> getExtras() {
        return this.extra;
    }

    public void setExtra(String str, String str2) {
        this.extra.put(str, str2);
        for (IScopeObserver next : this.options.getScopeObservers()) {
            next.setExtra(str, str2);
            next.setExtras(this.extra);
        }
    }

    public void removeExtra(String str) {
        this.extra.remove(str);
        for (IScopeObserver next : this.options.getScopeObservers()) {
            next.removeExtra(str);
            next.setExtras(this.extra);
        }
    }

    public Contexts getContexts() {
        return this.contexts;
    }

    public void setContexts(String str, Object obj) {
        this.contexts.put(str, obj);
        for (IScopeObserver contexts2 : this.options.getScopeObservers()) {
            contexts2.setContexts(this.contexts);
        }
    }

    public void setContexts(String str, Boolean bool) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", bool);
        setContexts(str, (Object) hashMap);
    }

    public void setContexts(String str, String str2) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", str2);
        setContexts(str, (Object) hashMap);
    }

    public void setContexts(String str, Number number) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", number);
        setContexts(str, (Object) hashMap);
    }

    public void setContexts(String str, Collection<?> collection) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", collection);
        setContexts(str, (Object) hashMap);
    }

    public void setContexts(String str, Object[] objArr) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", objArr);
        setContexts(str, (Object) hashMap);
    }

    public void setContexts(String str, Character ch) {
        HashMap hashMap = new HashMap();
        hashMap.put("value", ch);
        setContexts(str, (Object) hashMap);
    }

    public void removeContexts(String str) {
        this.contexts.remove(str);
    }

    public List<Attachment> getAttachments() {
        return new CopyOnWriteArrayList(this.attachments);
    }

    public void addAttachment(Attachment attachment) {
        this.attachments.add(attachment);
    }

    public void clearAttachments() {
        this.attachments.clear();
    }

    private Queue<Breadcrumb> createBreadcrumbsList(int i) {
        return SynchronizedQueue.synchronizedQueue(new CircularFifoQueue(i));
    }

    public List<EventProcessor> getEventProcessors() {
        return this.eventProcessors;
    }

    public void addEventProcessor(EventProcessor eventProcessor) {
        this.eventProcessors.add(eventProcessor);
    }

    public Session withSession(IWithSession iWithSession) {
        Session clone;
        synchronized (this.sessionLock) {
            iWithSession.accept(this.session);
            clone = this.session != null ? this.session.clone() : null;
        }
        return clone;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: io.sentry.Scope$SessionPair} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: io.sentry.Session} */
    /* JADX WARNING: type inference failed for: r3v0 */
    /* JADX WARNING: type inference failed for: r3v3 */
    /* JADX WARNING: type inference failed for: r3v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.Scope.SessionPair startSession() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.sessionLock
            monitor-enter(r0)
            io.sentry.Session r1 = r8.session     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x000c
            io.sentry.Session r1 = r8.session     // Catch:{ all -> 0x0057 }
            r1.end()     // Catch:{ all -> 0x0057 }
        L_0x000c:
            io.sentry.Session r1 = r8.session     // Catch:{ all -> 0x0057 }
            io.sentry.SentryOptions r2 = r8.options     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r2.getRelease()     // Catch:{ all -> 0x0057 }
            r3 = 0
            if (r2 == 0) goto L_0x0045
            io.sentry.Session r2 = new io.sentry.Session     // Catch:{ all -> 0x0057 }
            io.sentry.SentryOptions r4 = r8.options     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = r4.getDistinctId()     // Catch:{ all -> 0x0057 }
            io.sentry.protocol.User r5 = r8.user     // Catch:{ all -> 0x0057 }
            io.sentry.SentryOptions r6 = r8.options     // Catch:{ all -> 0x0057 }
            java.lang.String r6 = r6.getEnvironment()     // Catch:{ all -> 0x0057 }
            io.sentry.SentryOptions r7 = r8.options     // Catch:{ all -> 0x0057 }
            java.lang.String r7 = r7.getRelease()     // Catch:{ all -> 0x0057 }
            r2.<init>(r4, r5, r6, r7)     // Catch:{ all -> 0x0057 }
            r8.session = r2     // Catch:{ all -> 0x0057 }
            if (r1 == 0) goto L_0x0038
            io.sentry.Session r3 = r1.clone()     // Catch:{ all -> 0x0057 }
        L_0x0038:
            io.sentry.Scope$SessionPair r1 = new io.sentry.Scope$SessionPair     // Catch:{ all -> 0x0057 }
            io.sentry.Session r2 = r8.session     // Catch:{ all -> 0x0057 }
            io.sentry.Session r2 = r2.clone()     // Catch:{ all -> 0x0057 }
            r1.<init>(r2, r3)     // Catch:{ all -> 0x0057 }
            r3 = r1
            goto L_0x0055
        L_0x0045:
            io.sentry.SentryOptions r1 = r8.options     // Catch:{ all -> 0x0057 }
            io.sentry.ILogger r1 = r1.getLogger()     // Catch:{ all -> 0x0057 }
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.WARNING     // Catch:{ all -> 0x0057 }
            java.lang.String r4 = "Release is not set on SentryOptions. Session could not be started"
            r5 = 0
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ all -> 0x0057 }
            r1.log((io.sentry.SentryLevel) r2, (java.lang.String) r4, (java.lang.Object[]) r5)     // Catch:{ all -> 0x0057 }
        L_0x0055:
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            return r3
        L_0x0057:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0057 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.Scope.startSession():io.sentry.Scope$SessionPair");
    }

    static final class SessionPair {
        private final Session current;
        private final Session previous;

        public SessionPair(Session session, Session session2) {
            this.current = session;
            this.previous = session2;
        }

        public Session getPrevious() {
            return this.previous;
        }

        public Session getCurrent() {
            return this.current;
        }
    }

    public Session endSession() {
        Session session2;
        synchronized (this.sessionLock) {
            session2 = null;
            if (this.session != null) {
                this.session.end();
                Session clone = this.session.clone();
                this.session = null;
                session2 = clone;
            }
        }
        return session2;
    }

    public void withTransaction(IWithTransaction iWithTransaction) {
        synchronized (this.transactionLock) {
            iWithTransaction.accept(this.transaction);
        }
    }

    public SentryOptions getOptions() {
        return this.options;
    }

    public Session getSession() {
        return this.session;
    }

    public void setPropagationContext(PropagationContext propagationContext2) {
        this.propagationContext = propagationContext2;
    }

    public PropagationContext getPropagationContext() {
        return this.propagationContext;
    }

    public PropagationContext withPropagationContext(IWithPropagationContext iWithPropagationContext) {
        PropagationContext propagationContext2;
        synchronized (this.propagationContextLock) {
            iWithPropagationContext.accept(this.propagationContext);
            propagationContext2 = new PropagationContext(this.propagationContext);
        }
        return propagationContext2;
    }

    public IScope clone() {
        return new Scope(this);
    }
}
