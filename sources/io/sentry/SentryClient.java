package io.sentry;

import io.sentry.SentryOptions;
import io.sentry.Session;
import io.sentry.clientreport.DiscardReason;
import io.sentry.exception.SentryEnvelopeException;
import io.sentry.hints.AbnormalExit;
import io.sentry.metrics.EncodedMetrics;
import io.sentry.metrics.IMetricsClient;
import io.sentry.metrics.NoopMetricsAggregator;
import io.sentry.protocol.Contexts;
import io.sentry.protocol.SentryId;
import io.sentry.protocol.SentryTransaction;
import io.sentry.transport.ITransport;
import io.sentry.transport.RateLimiter;
import io.sentry.util.CheckInUtils;
import io.sentry.util.HintUtils;
import io.sentry.util.Objects;
import io.sentry.util.TracingUtils;
import java.io.Closeable;
import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class SentryClient implements ISentryClient, IMetricsClient {
    static final String SENTRY_PROTOCOL_VERSION = "7";
    private boolean enabled;
    private final IMetricsAggregator metricsAggregator;
    private final SentryOptions options;
    private final SecureRandom random;
    private final SortBreadcrumbsByDate sortBreadcrumbsByDate = new SortBreadcrumbsByDate();
    private final ITransport transport;

    static /* synthetic */ void lambda$captureEvent$0(Session session) {
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    SentryClient(SentryOptions sentryOptions) {
        IMetricsAggregator iMetricsAggregator;
        SecureRandom secureRandom = null;
        this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "SentryOptions is required.");
        this.enabled = true;
        ITransportFactory transportFactory = sentryOptions.getTransportFactory();
        if (transportFactory instanceof NoOpTransportFactory) {
            transportFactory = new AsyncHttpTransportFactory();
            sentryOptions.setTransportFactory(transportFactory);
        }
        this.transport = transportFactory.create(sentryOptions, new RequestDetailsResolver(sentryOptions).resolve());
        if (sentryOptions.isEnableMetrics()) {
            iMetricsAggregator = new MetricsAggregator(sentryOptions, this);
        } else {
            iMetricsAggregator = NoopMetricsAggregator.getInstance();
        }
        this.metricsAggregator = iMetricsAggregator;
        this.random = sentryOptions.getSampleRate() != null ? new SecureRandom() : secureRandom;
    }

    private boolean shouldApplyScopeData(SentryBaseEvent sentryBaseEvent, Hint hint) {
        if (HintUtils.shouldApplyScopeData(hint)) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Event was cached so not applying scope: %s", sentryBaseEvent.getEventId());
        return false;
    }

    private boolean shouldApplyScopeData(CheckIn checkIn, Hint hint) {
        if (HintUtils.shouldApplyScopeData(hint)) {
            return true;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Check-in was cached so not applying scope: %s", checkIn.getCheckInId());
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:68:0x0163 A[Catch:{ SentryEnvelopeException | IOException -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0165 A[Catch:{ SentryEnvelopeException | IOException -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0168 A[Catch:{ SentryEnvelopeException | IOException -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x016e A[Catch:{ SentryEnvelopeException | IOException -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x017a A[Catch:{ SentryEnvelopeException | IOException -> 0x017f }] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x01ad  */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x01bc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public io.sentry.protocol.SentryId captureEvent(io.sentry.SentryEvent r15, io.sentry.IScope r16, io.sentry.Hint r17) {
        /*
            r14 = this;
            r7 = r14
            r0 = r15
            r8 = r16
            java.lang.String r1 = "SentryEvent is required."
            io.sentry.util.Objects.requireNonNull(r15, r1)
            if (r17 != 0) goto L_0x0012
            io.sentry.Hint r1 = new io.sentry.Hint
            r1.<init>()
            r9 = r1
            goto L_0x0014
        L_0x0012:
            r9 = r17
        L_0x0014:
            boolean r1 = r14.shouldApplyScopeData((io.sentry.SentryBaseEvent) r15, (io.sentry.Hint) r9)
            if (r1 == 0) goto L_0x001d
            r14.addScopeAttachmentsToHint(r8, r9)
        L_0x001d:
            io.sentry.SentryOptions r1 = r7.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.DEBUG
            r10 = 1
            java.lang.Object[] r3 = new java.lang.Object[r10]
            io.sentry.protocol.SentryId r4 = r15.getEventId()
            r11 = 0
            r3[r11] = r4
            java.lang.String r4 = "Capturing event: %s"
            r1.log((io.sentry.SentryLevel) r2, (java.lang.String) r4, (java.lang.Object[]) r3)
            if (r0 == 0) goto L_0x0069
            java.lang.Throwable r1 = r15.getThrowable()
            if (r1 == 0) goto L_0x0069
            io.sentry.SentryOptions r2 = r7.options
            boolean r2 = r2.containsIgnoredExceptionForType(r1)
            if (r2 == 0) goto L_0x0069
            io.sentry.SentryOptions r0 = r7.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r3 = new java.lang.Object[r10]
            java.lang.Class r1 = r1.getClass()
            r3[r11] = r1
            java.lang.String r1 = "Event was dropped as the exception %s is ignored"
            r0.log((io.sentry.SentryLevel) r2, (java.lang.String) r1, (java.lang.Object[]) r3)
            io.sentry.SentryOptions r0 = r7.options
            io.sentry.clientreport.IClientReportRecorder r0 = r0.getClientReportRecorder()
            io.sentry.clientreport.DiscardReason r1 = io.sentry.clientreport.DiscardReason.EVENT_PROCESSOR
            io.sentry.DataCategory r2 = io.sentry.DataCategory.Error
            r0.recordLostEvent(r1, r2)
            io.sentry.protocol.SentryId r0 = io.sentry.protocol.SentryId.EMPTY_ID
            return r0
        L_0x0069:
            boolean r1 = r14.shouldApplyScopeData((io.sentry.SentryBaseEvent) r15, (io.sentry.Hint) r9)
            if (r1 == 0) goto L_0x0087
            io.sentry.SentryEvent r0 = r14.applyScope(r15, r8, r9)
            if (r0 != 0) goto L_0x0087
            io.sentry.SentryOptions r0 = r7.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r11]
            java.lang.String r3 = "Event was dropped by applyScope"
            r0.log((io.sentry.SentryLevel) r1, (java.lang.String) r3, (java.lang.Object[]) r2)
            io.sentry.protocol.SentryId r0 = io.sentry.protocol.SentryId.EMPTY_ID
            return r0
        L_0x0087:
            io.sentry.SentryOptions r1 = r7.options
            java.util.List r1 = r1.getEventProcessors()
            io.sentry.SentryEvent r0 = r14.processEvent(r0, r9, r1)
            if (r0 == 0) goto L_0x00b5
            io.sentry.SentryEvent r0 = r14.executeBeforeSend(r0, r9)
            if (r0 != 0) goto L_0x00b5
            io.sentry.SentryOptions r1 = r7.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r3 = new java.lang.Object[r11]
            java.lang.String r4 = "Event was dropped by beforeSend"
            r1.log((io.sentry.SentryLevel) r2, (java.lang.String) r4, (java.lang.Object[]) r3)
            io.sentry.SentryOptions r1 = r7.options
            io.sentry.clientreport.IClientReportRecorder r1 = r1.getClientReportRecorder()
            io.sentry.clientreport.DiscardReason r2 = io.sentry.clientreport.DiscardReason.BEFORE_SEND
            io.sentry.DataCategory r3 = io.sentry.DataCategory.Error
            r1.recordLostEvent(r2, r3)
        L_0x00b5:
            if (r0 != 0) goto L_0x00ba
            io.sentry.protocol.SentryId r0 = io.sentry.protocol.SentryId.EMPTY_ID
            return r0
        L_0x00ba:
            r12 = 0
            if (r8 == 0) goto L_0x00c7
            io.sentry.SentryClient$$ExternalSyntheticLambda0 r1 = new io.sentry.SentryClient$$ExternalSyntheticLambda0
            r1.<init>()
            io.sentry.Session r1 = r8.withSession(r1)
            goto L_0x00c8
        L_0x00c7:
            r1 = r12
        L_0x00c8:
            if (r0 == 0) goto L_0x0107
            if (r1 == 0) goto L_0x00d5
            boolean r2 = r1.isTerminated()
            if (r2 != 0) goto L_0x00d3
            goto L_0x00d5
        L_0x00d3:
            r2 = r12
            goto L_0x00d9
        L_0x00d5:
            io.sentry.Session r2 = r14.updateSessionData(r0, r9, r8)
        L_0x00d9:
            boolean r3 = r14.sample()
            if (r3 != 0) goto L_0x0104
            io.sentry.SentryOptions r3 = r7.options
            io.sentry.ILogger r3 = r3.getLogger()
            io.sentry.SentryLevel r4 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r5 = new java.lang.Object[r10]
            io.sentry.protocol.SentryId r0 = r0.getEventId()
            r5[r11] = r0
            java.lang.String r0 = "Event %s was dropped due to sampling decision."
            r3.log((io.sentry.SentryLevel) r4, (java.lang.String) r0, (java.lang.Object[]) r5)
            io.sentry.SentryOptions r0 = r7.options
            io.sentry.clientreport.IClientReportRecorder r0 = r0.getClientReportRecorder()
            io.sentry.clientreport.DiscardReason r3 = io.sentry.clientreport.DiscardReason.SAMPLE_RATE
            io.sentry.DataCategory r4 = io.sentry.DataCategory.Error
            r0.recordLostEvent(r3, r4)
            r4 = r2
            r2 = r12
            goto L_0x0109
        L_0x0104:
            r4 = r2
            r2 = r0
            goto L_0x0109
        L_0x0107:
            r2 = r0
            r4 = r12
        L_0x0109:
            boolean r0 = r14.shouldSendSessionUpdateForDroppedEvent(r1, r4)
            if (r2 != 0) goto L_0x0123
            if (r0 != 0) goto L_0x0123
            io.sentry.SentryOptions r0 = r7.options
            io.sentry.ILogger r0 = r0.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r11]
            java.lang.String r3 = "Not sending session update for dropped event as it did not cause the session health to change."
            r0.log((io.sentry.SentryLevel) r1, (java.lang.String) r3, (java.lang.Object[]) r2)
            io.sentry.protocol.SentryId r0 = io.sentry.protocol.SentryId.EMPTY_ID
            return r0
        L_0x0123:
            io.sentry.protocol.SentryId r0 = io.sentry.protocol.SentryId.EMPTY_ID
            if (r2 == 0) goto L_0x0131
            io.sentry.protocol.SentryId r1 = r2.getEventId()
            if (r1 == 0) goto L_0x0131
            io.sentry.protocol.SentryId r0 = r2.getEventId()
        L_0x0131:
            r13 = r0
            java.lang.Class<io.sentry.hints.Backfillable> r0 = io.sentry.hints.Backfillable.class
            boolean r0 = io.sentry.util.HintUtils.hasType(r9, r0)     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            if (r0 == 0) goto L_0x0147
            if (r2 == 0) goto L_0x0160
            io.sentry.SentryOptions r0 = r7.options     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            io.sentry.Baggage r0 = io.sentry.Baggage.fromEvent(r2, r0)     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            io.sentry.TraceContext r0 = r0.toTraceContext()     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            goto L_0x0153
        L_0x0147:
            if (r8 == 0) goto L_0x0160
            io.sentry.ITransaction r0 = r16.getTransaction()     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            if (r0 == 0) goto L_0x0155
            io.sentry.TraceContext r0 = r0.traceContext()     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
        L_0x0153:
            r5 = r0
            goto L_0x0161
        L_0x0155:
            io.sentry.SentryOptions r0 = r7.options     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            io.sentry.PropagationContext r0 = io.sentry.util.TracingUtils.maybeUpdateBaggage(r8, r0)     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            io.sentry.TraceContext r0 = r0.traceContext()     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            goto L_0x0153
        L_0x0160:
            r5 = r12
        L_0x0161:
            if (r2 == 0) goto L_0x0165
            r0 = r10
            goto L_0x0166
        L_0x0165:
            r0 = r11
        L_0x0166:
            if (r0 == 0) goto L_0x016e
            java.util.List r0 = r14.getAttachments(r9)     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            r3 = r0
            goto L_0x016f
        L_0x016e:
            r3 = r12
        L_0x016f:
            r6 = 0
            r1 = r14
            io.sentry.SentryEnvelope r0 = r1.buildEnvelope(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            r9.clear()     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            if (r0 == 0) goto L_0x0195
            io.sentry.protocol.SentryId r13 = r14.sendEnvelope(r0, r9)     // Catch:{ IOException -> 0x0181, SentryEnvelopeException -> 0x017f }
            goto L_0x0195
        L_0x017f:
            r0 = move-exception
            goto L_0x0182
        L_0x0181:
            r0 = move-exception
        L_0x0182:
            io.sentry.SentryOptions r1 = r7.options
            io.sentry.ILogger r1 = r1.getLogger()
            io.sentry.SentryLevel r2 = io.sentry.SentryLevel.WARNING
            java.lang.Object[] r3 = new java.lang.Object[r10]
            r3[r11] = r13
            java.lang.String r4 = "Capturing event %s failed."
            r1.log(r2, r0, r4, r3)
            io.sentry.protocol.SentryId r13 = io.sentry.protocol.SentryId.EMPTY_ID
        L_0x0195:
            if (r8 == 0) goto L_0x01c1
            io.sentry.ITransaction r0 = r16.getTransaction()
            if (r0 == 0) goto L_0x01c1
            java.lang.Class<io.sentry.hints.TransactionEnd> r1 = io.sentry.hints.TransactionEnd.class
            boolean r1 = io.sentry.util.HintUtils.hasType(r9, r1)
            if (r1 == 0) goto L_0x01c1
            java.lang.Object r1 = io.sentry.util.HintUtils.getSentrySdkHint(r9)
            boolean r2 = r1 instanceof io.sentry.hints.DiskFlushNotification
            if (r2 == 0) goto L_0x01bc
            io.sentry.hints.DiskFlushNotification r1 = (io.sentry.hints.DiskFlushNotification) r1
            io.sentry.protocol.SentryId r2 = r0.getEventId()
            r1.setFlushable(r2)
            io.sentry.SpanStatus r1 = io.sentry.SpanStatus.ABORTED
            r0.forceFinish(r1, r11, r9)
            goto L_0x01c1
        L_0x01bc:
            io.sentry.SpanStatus r1 = io.sentry.SpanStatus.ABORTED
            r0.forceFinish(r1, r11, r12)
        L_0x01c1:
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryClient.captureEvent(io.sentry.SentryEvent, io.sentry.IScope, io.sentry.Hint):io.sentry.protocol.SentryId");
    }

    private void addScopeAttachmentsToHint(IScope iScope, Hint hint) {
        if (iScope != null) {
            hint.addAttachments(iScope.getAttachments());
        }
    }

    private boolean shouldSendSessionUpdateForDroppedEvent(Session session, Session session2) {
        if (session2 == null) {
            return false;
        }
        if (session == null) {
            return true;
        }
        if (session2.getStatus() == Session.State.Crashed && session.getStatus() != Session.State.Crashed) {
            return true;
        }
        return session2.errorCount() > 0 && session.errorCount() <= 0;
    }

    private List<Attachment> getAttachments(Hint hint) {
        List<Attachment> attachments = hint.getAttachments();
        Attachment screenshot = hint.getScreenshot();
        if (screenshot != null) {
            attachments.add(screenshot);
        }
        Attachment viewHierarchy = hint.getViewHierarchy();
        if (viewHierarchy != null) {
            attachments.add(viewHierarchy);
        }
        Attachment threadDump = hint.getThreadDump();
        if (threadDump != null) {
            attachments.add(threadDump);
        }
        return attachments;
    }

    private SentryEnvelope buildEnvelope(SentryBaseEvent sentryBaseEvent, List<Attachment> list, Session session, TraceContext traceContext, ProfilingTraceData profilingTraceData) throws IOException, SentryEnvelopeException {
        SentryId sentryId;
        ArrayList arrayList = new ArrayList();
        if (sentryBaseEvent != null) {
            arrayList.add(SentryEnvelopeItem.fromEvent(this.options.getSerializer(), sentryBaseEvent));
            sentryId = sentryBaseEvent.getEventId();
        } else {
            sentryId = null;
        }
        if (session != null) {
            arrayList.add(SentryEnvelopeItem.fromSession(this.options.getSerializer(), session));
        }
        if (profilingTraceData != null) {
            arrayList.add(SentryEnvelopeItem.fromProfilingTrace(profilingTraceData, this.options.getMaxTraceFileSize(), this.options.getSerializer()));
            if (sentryId == null) {
                sentryId = new SentryId(profilingTraceData.getProfileId());
            }
        }
        if (list != null) {
            for (Attachment fromAttachment : list) {
                arrayList.add(SentryEnvelopeItem.fromAttachment(this.options.getSerializer(), this.options.getLogger(), fromAttachment, this.options.getMaxAttachmentSize()));
            }
        }
        if (!arrayList.isEmpty()) {
            return new SentryEnvelope(new SentryEnvelopeHeader(sentryId, this.options.getSdkVersion(), traceContext), arrayList);
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0048 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private io.sentry.SentryEvent processEvent(io.sentry.SentryEvent r9, io.sentry.Hint r10, java.util.List<io.sentry.EventProcessor> r11) {
        /*
            r8 = this;
            java.util.Iterator r11 = r11.iterator()
        L_0x0004:
            boolean r0 = r11.hasNext()
            if (r0 == 0) goto L_0x006e
            java.lang.Object r0 = r11.next()
            io.sentry.EventProcessor r0 = (io.sentry.EventProcessor) r0
            r1 = 0
            r2 = 1
            boolean r3 = r0 instanceof io.sentry.BackfillingEventProcessor     // Catch:{ all -> 0x002c }
            java.lang.Class<io.sentry.hints.Backfillable> r4 = io.sentry.hints.Backfillable.class
            boolean r4 = io.sentry.util.HintUtils.hasType(r10, r4)     // Catch:{ all -> 0x002c }
            if (r4 == 0) goto L_0x0023
            if (r3 == 0) goto L_0x0023
            io.sentry.SentryEvent r9 = r0.process((io.sentry.SentryEvent) r9, (io.sentry.Hint) r10)     // Catch:{ all -> 0x002c }
            goto L_0x0046
        L_0x0023:
            if (r4 != 0) goto L_0x0046
            if (r3 != 0) goto L_0x0046
            io.sentry.SentryEvent r9 = r0.process((io.sentry.SentryEvent) r9, (io.sentry.Hint) r10)     // Catch:{ all -> 0x002c }
            goto L_0x0046
        L_0x002c:
            r3 = move-exception
            io.sentry.SentryOptions r4 = r8.options
            io.sentry.ILogger r4 = r4.getLogger()
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r6 = new java.lang.Object[r2]
            java.lang.Class r7 = r0.getClass()
            java.lang.String r7 = r7.getName()
            r6[r1] = r7
            java.lang.String r7 = "An exception occurred while processing event by processor: %s"
            r4.log(r5, r3, r7, r6)
        L_0x0046:
            if (r9 != 0) goto L_0x0004
            io.sentry.SentryOptions r10 = r8.options
            io.sentry.ILogger r10 = r10.getLogger()
            io.sentry.SentryLevel r11 = io.sentry.SentryLevel.DEBUG
            java.lang.Object[] r2 = new java.lang.Object[r2]
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            r2[r1] = r0
            java.lang.String r0 = "Event was dropped by a processor: %s"
            r10.log((io.sentry.SentryLevel) r11, (java.lang.String) r0, (java.lang.Object[]) r2)
            io.sentry.SentryOptions r10 = r8.options
            io.sentry.clientreport.IClientReportRecorder r10 = r10.getClientReportRecorder()
            io.sentry.clientreport.DiscardReason r11 = io.sentry.clientreport.DiscardReason.EVENT_PROCESSOR
            io.sentry.DataCategory r0 = io.sentry.DataCategory.Error
            r10.recordLostEvent(r11, r0)
        L_0x006e:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.SentryClient.processEvent(io.sentry.SentryEvent, io.sentry.Hint, java.util.List):io.sentry.SentryEvent");
    }

    private SentryTransaction processTransaction(SentryTransaction sentryTransaction, Hint hint, List<EventProcessor> list) {
        Iterator<EventProcessor> it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            EventProcessor next = it.next();
            try {
                sentryTransaction = next.process(sentryTransaction, hint);
                continue;
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, th, "An exception occurred while processing transaction by processor: %s", next.getClass().getName());
                continue;
            }
            if (sentryTransaction == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Transaction was dropped by a processor: %s", next.getClass().getName());
                this.options.getClientReportRecorder().recordLostEvent(DiscardReason.EVENT_PROCESSOR, DataCategory.Transaction);
                break;
            }
        }
        return sentryTransaction;
    }

    public void captureUserFeedback(UserFeedback userFeedback) {
        Objects.requireNonNull(userFeedback, "SentryEvent is required.");
        if (SentryId.EMPTY_ID.equals(userFeedback.getEventId())) {
            this.options.getLogger().log(SentryLevel.WARNING, "Capturing userFeedback without a Sentry Id.", new Object[0]);
            return;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing userFeedback: %s", userFeedback.getEventId());
        try {
            sendEnvelope(buildEnvelope(userFeedback), (Hint) null);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing user feedback %s failed.", userFeedback.getEventId());
        }
    }

    private SentryEnvelope buildEnvelope(UserFeedback userFeedback) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SentryEnvelopeItem.fromUserFeedback(this.options.getSerializer(), userFeedback));
        return new SentryEnvelope(new SentryEnvelopeHeader(userFeedback.getEventId(), this.options.getSdkVersion()), arrayList);
    }

    private SentryEnvelope buildEnvelope(CheckIn checkIn, TraceContext traceContext) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(SentryEnvelopeItem.fromCheckIn(this.options.getSerializer(), checkIn));
        return new SentryEnvelope(new SentryEnvelopeHeader(checkIn.getCheckInId(), this.options.getSdkVersion(), traceContext), arrayList);
    }

    /* access modifiers changed from: package-private */
    public Session updateSessionData(SentryEvent sentryEvent, Hint hint, IScope iScope) {
        if (HintUtils.shouldApplyScopeData(hint)) {
            if (iScope != null) {
                return iScope.withSession(new SentryClient$$ExternalSyntheticLambda1(this, sentryEvent, hint));
            }
            this.options.getLogger().log(SentryLevel.INFO, "Scope is null on client.captureEvent", new Object[0]);
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: lambda$updateSessionData$1$io-sentry-SentryClient  reason: not valid java name */
    public /* synthetic */ void m876lambda$updateSessionData$1$iosentrySentryClient(SentryEvent sentryEvent, Hint hint, Session session) {
        boolean z = false;
        if (session != null) {
            String str = null;
            Session.State state = sentryEvent.isCrashed() ? Session.State.Crashed : null;
            if (Session.State.Crashed == state || sentryEvent.isErrored()) {
                z = true;
            }
            String str2 = (sentryEvent.getRequest() == null || sentryEvent.getRequest().getHeaders() == null || !sentryEvent.getRequest().getHeaders().containsKey("user-agent")) ? null : sentryEvent.getRequest().getHeaders().get("user-agent");
            Object sentrySdkHint = HintUtils.getSentrySdkHint(hint);
            if (sentrySdkHint instanceof AbnormalExit) {
                str = ((AbnormalExit) sentrySdkHint).mechanism();
                state = Session.State.Abnormal;
            }
            if (session.update(state, str2, z, str) && session.isTerminated()) {
                session.end();
                return;
            }
            return;
        }
        this.options.getLogger().log(SentryLevel.INFO, "Session is null on scope.withSession", new Object[0]);
    }

    public void captureSession(Session session, Hint hint) {
        Objects.requireNonNull(session, "Session is required.");
        if (session.getRelease() == null || session.getRelease().isEmpty()) {
            this.options.getLogger().log(SentryLevel.WARNING, "Sessions can't be captured without setting a release.", new Object[0]);
            return;
        }
        try {
            captureEnvelope(SentryEnvelope.from(this.options.getSerializer(), session, this.options.getSdkVersion()), hint);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to capture session.", (Throwable) e);
        }
    }

    public SentryId captureEnvelope(SentryEnvelope sentryEnvelope, Hint hint) {
        Objects.requireNonNull(sentryEnvelope, "SentryEnvelope is required.");
        if (hint == null) {
            hint = new Hint();
        }
        try {
            hint.clear();
            return sendEnvelope(sentryEnvelope, hint);
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.ERROR, "Failed to capture envelope.", (Throwable) e);
            return SentryId.EMPTY_ID;
        }
    }

    private SentryId sendEnvelope(SentryEnvelope sentryEnvelope, Hint hint) throws IOException {
        SentryOptions.BeforeEnvelopeCallback beforeEnvelopeCallback = this.options.getBeforeEnvelopeCallback();
        if (beforeEnvelopeCallback != null) {
            try {
                beforeEnvelopeCallback.execute(sentryEnvelope, hint);
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, "The BeforeEnvelope callback threw an exception.", th);
            }
        }
        if (hint == null) {
            this.transport.send(sentryEnvelope);
        } else {
            this.transport.send(sentryEnvelope, hint);
        }
        SentryId eventId = sentryEnvelope.getHeader().getEventId();
        return eventId != null ? eventId : SentryId.EMPTY_ID;
    }

    public SentryId captureTransaction(SentryTransaction sentryTransaction, TraceContext traceContext, IScope iScope, Hint hint, ProfilingTraceData profilingTraceData) {
        SentryTransaction sentryTransaction2 = sentryTransaction;
        IScope iScope2 = iScope;
        Objects.requireNonNull(sentryTransaction, "Transaction is required.");
        Hint hint2 = hint == null ? new Hint() : hint;
        if (shouldApplyScopeData((SentryBaseEvent) sentryTransaction, hint2)) {
            addScopeAttachmentsToHint(iScope, hint2);
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing transaction: %s", sentryTransaction.getEventId());
        SentryId sentryId = SentryId.EMPTY_ID;
        if (sentryTransaction.getEventId() != null) {
            sentryId = sentryTransaction.getEventId();
        }
        SentryId sentryId2 = sentryId;
        if (shouldApplyScopeData((SentryBaseEvent) sentryTransaction, hint2)) {
            sentryTransaction2 = (SentryTransaction) applyScope(sentryTransaction, iScope);
            if (!(sentryTransaction2 == null || iScope2 == null)) {
                sentryTransaction2 = processTransaction(sentryTransaction2, hint2, iScope.getEventProcessors());
            }
            if (sentryTransaction2 == null) {
                this.options.getLogger().log(SentryLevel.DEBUG, "Transaction was dropped by applyScope", new Object[0]);
            }
        }
        if (sentryTransaction2 != null) {
            sentryTransaction2 = processTransaction(sentryTransaction2, hint2, this.options.getEventProcessors());
        }
        if (sentryTransaction2 == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Transaction was dropped by Event processors.", new Object[0]);
            return SentryId.EMPTY_ID;
        }
        SentryTransaction executeBeforeSendTransaction = executeBeforeSendTransaction(sentryTransaction2, hint2);
        if (executeBeforeSendTransaction == null) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Transaction was dropped by beforeSendTransaction.", new Object[0]);
            this.options.getClientReportRecorder().recordLostEvent(DiscardReason.BEFORE_SEND, DataCategory.Transaction);
            return SentryId.EMPTY_ID;
        }
        try {
            SentryEnvelope buildEnvelope = buildEnvelope(executeBeforeSendTransaction, filterForTransaction(getAttachments(hint2)), (Session) null, traceContext, profilingTraceData);
            hint2.clear();
            if (buildEnvelope != null) {
                return sendEnvelope(buildEnvelope, hint2);
            }
            return sentryId2;
        } catch (SentryEnvelopeException | IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing transaction %s failed.", sentryId2);
            return SentryId.EMPTY_ID;
        }
    }

    public SentryId captureCheckIn(CheckIn checkIn, IScope iScope, Hint hint) {
        if (hint == null) {
            hint = new Hint();
        }
        if (checkIn.getEnvironment() == null) {
            checkIn.setEnvironment(this.options.getEnvironment());
        }
        if (checkIn.getRelease() == null) {
            checkIn.setRelease(this.options.getRelease());
        }
        if (shouldApplyScopeData(checkIn, hint)) {
            checkIn = applyScope(checkIn, iScope);
        }
        if (CheckInUtils.isIgnored(this.options.getIgnoredCheckIns(), checkIn.getMonitorSlug())) {
            this.options.getLogger().log(SentryLevel.DEBUG, "Check-in was dropped as slug %s is ignored", checkIn.getMonitorSlug());
            return SentryId.EMPTY_ID;
        }
        this.options.getLogger().log(SentryLevel.DEBUG, "Capturing check-in: %s", checkIn.getCheckInId());
        SentryId checkInId = checkIn.getCheckInId();
        TraceContext traceContext = null;
        if (iScope != null) {
            try {
                ITransaction transaction = iScope.getTransaction();
                if (transaction != null) {
                    traceContext = transaction.traceContext();
                } else {
                    traceContext = TracingUtils.maybeUpdateBaggage(iScope, this.options).traceContext();
                }
            } catch (IOException e) {
                this.options.getLogger().log(SentryLevel.WARNING, e, "Capturing check-in %s failed.", checkInId);
                return SentryId.EMPTY_ID;
            }
        }
        SentryEnvelope buildEnvelope = buildEnvelope(checkIn, traceContext);
        hint.clear();
        return sendEnvelope(buildEnvelope, hint);
    }

    private List<Attachment> filterForTransaction(List<Attachment> list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (Attachment next : list) {
            if (next.isAddToTransactions()) {
                arrayList.add(next);
            }
        }
        return arrayList;
    }

    private SentryEvent applyScope(SentryEvent sentryEvent, IScope iScope, Hint hint) {
        if (iScope == null) {
            return sentryEvent;
        }
        applyScope(sentryEvent, iScope);
        if (sentryEvent.getTransaction() == null) {
            sentryEvent.setTransaction(iScope.getTransactionName());
        }
        if (sentryEvent.getFingerprints() == null) {
            sentryEvent.setFingerprints(iScope.getFingerprint());
        }
        if (iScope.getLevel() != null) {
            sentryEvent.setLevel(iScope.getLevel());
        }
        ISpan span = iScope.getSpan();
        if (sentryEvent.getContexts().getTrace() == null) {
            if (span == null) {
                sentryEvent.getContexts().setTrace(TransactionContext.fromPropagationContext(iScope.getPropagationContext()));
            } else {
                sentryEvent.getContexts().setTrace(span.getSpanContext());
            }
        }
        return processEvent(sentryEvent, hint, iScope.getEventProcessors());
    }

    private CheckIn applyScope(CheckIn checkIn, IScope iScope) {
        if (iScope != null) {
            ISpan span = iScope.getSpan();
            if (checkIn.getContexts().getTrace() == null) {
                if (span == null) {
                    checkIn.getContexts().setTrace(TransactionContext.fromPropagationContext(iScope.getPropagationContext()));
                } else {
                    checkIn.getContexts().setTrace(span.getSpanContext());
                }
            }
        }
        return checkIn;
    }

    private <T extends SentryBaseEvent> T applyScope(T t, IScope iScope) {
        if (iScope != null) {
            if (t.getRequest() == null) {
                t.setRequest(iScope.getRequest());
            }
            if (t.getUser() == null) {
                t.setUser(iScope.getUser());
            }
            if (t.getTags() == null) {
                t.setTags(new HashMap(iScope.getTags()));
            } else {
                for (Map.Entry next : iScope.getTags().entrySet()) {
                    if (!t.getTags().containsKey(next.getKey())) {
                        t.getTags().put((String) next.getKey(), (String) next.getValue());
                    }
                }
            }
            if (t.getBreadcrumbs() == null) {
                t.setBreadcrumbs(new ArrayList(iScope.getBreadcrumbs()));
            } else {
                sortBreadcrumbsByDate(t, iScope.getBreadcrumbs());
            }
            if (t.getExtras() == null) {
                t.setExtras(new HashMap(iScope.getExtras()));
            } else {
                for (Map.Entry next2 : iScope.getExtras().entrySet()) {
                    if (!t.getExtras().containsKey(next2.getKey())) {
                        t.getExtras().put((String) next2.getKey(), next2.getValue());
                    }
                }
            }
            Contexts contexts = t.getContexts();
            for (Map.Entry entry : new Contexts(iScope.getContexts()).entrySet()) {
                if (!contexts.containsKey(entry.getKey())) {
                    contexts.put((String) entry.getKey(), entry.getValue());
                }
            }
        }
        return t;
    }

    private void sortBreadcrumbsByDate(SentryBaseEvent sentryBaseEvent, Collection<Breadcrumb> collection) {
        List<Breadcrumb> breadcrumbs = sentryBaseEvent.getBreadcrumbs();
        if (breadcrumbs != null && !collection.isEmpty()) {
            breadcrumbs.addAll(collection);
            Collections.sort(breadcrumbs, this.sortBreadcrumbsByDate);
        }
    }

    private SentryEvent executeBeforeSend(SentryEvent sentryEvent, Hint hint) {
        SentryOptions.BeforeSendCallback beforeSend = this.options.getBeforeSend();
        if (beforeSend == null) {
            return sentryEvent;
        }
        try {
            return beforeSend.execute(sentryEvent, hint);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeSend callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    private SentryTransaction executeBeforeSendTransaction(SentryTransaction sentryTransaction, Hint hint) {
        SentryOptions.BeforeSendTransactionCallback beforeSendTransaction = this.options.getBeforeSendTransaction();
        if (beforeSendTransaction == null) {
            return sentryTransaction;
        }
        try {
            return beforeSendTransaction.execute(sentryTransaction, hint);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, "The BeforeSendTransaction callback threw an exception. It will be added as breadcrumb and continue.", th);
            return null;
        }
    }

    public void close() {
        close(false);
    }

    public void close(boolean z) {
        long j;
        this.options.getLogger().log(SentryLevel.INFO, "Closing SentryClient.", new Object[0]);
        try {
            this.metricsAggregator.close();
        } catch (IOException e) {
            this.options.getLogger().log(SentryLevel.WARNING, "Failed to close the metrics aggregator.", (Throwable) e);
        }
        if (z) {
            j = 0;
        } else {
            try {
                j = this.options.getShutdownTimeoutMillis();
            } catch (IOException e2) {
                this.options.getLogger().log(SentryLevel.WARNING, "Failed to close the connection to the Sentry Server.", (Throwable) e2);
            }
        }
        flush(j);
        this.transport.close(z);
        for (EventProcessor next : this.options.getEventProcessors()) {
            if (next instanceof Closeable) {
                try {
                    ((Closeable) next).close();
                } catch (IOException e3) {
                    this.options.getLogger().log(SentryLevel.WARNING, "Failed to close the event processor {}.", next, e3);
                }
            }
        }
        this.enabled = false;
    }

    public void flush(long j) {
        this.transport.flush(j);
    }

    public RateLimiter getRateLimiter() {
        return this.transport.getRateLimiter();
    }

    public boolean isHealthy() {
        return this.transport.isHealthy();
    }

    private boolean sample() {
        if (this.options.getSampleRate() == null || this.random == null || this.options.getSampleRate().doubleValue() >= this.random.nextDouble()) {
            return true;
        }
        return false;
    }

    public IMetricsAggregator getMetricsAggregator() {
        return this.metricsAggregator;
    }

    public SentryId captureMetrics(EncodedMetrics encodedMetrics) {
        SentryId captureEnvelope = captureEnvelope(new SentryEnvelope(new SentryEnvelopeHeader(new SentryId(), this.options.getSdkVersion(), (TraceContext) null), Collections.singleton(SentryEnvelopeItem.fromMetrics(encodedMetrics))));
        return captureEnvelope != null ? captureEnvelope : SentryId.EMPTY_ID;
    }

    private static final class SortBreadcrumbsByDate implements Comparator<Breadcrumb> {
        private SortBreadcrumbsByDate() {
        }

        public int compare(Breadcrumb breadcrumb, Breadcrumb breadcrumb2) {
            return breadcrumb.getTimestamp().compareTo(breadcrumb2.getTimestamp());
        }
    }
}
