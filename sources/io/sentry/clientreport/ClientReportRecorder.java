package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.DateUtils;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryItemType;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public final class ClientReportRecorder implements IClientReportRecorder {
    private final SentryOptions options;
    private final IClientReportStorage storage = new AtomicClientReportStorage();

    public ClientReportRecorder(SentryOptions sentryOptions) {
        this.options = sentryOptions;
    }

    public SentryEnvelope attachReportToEnvelope(SentryEnvelope sentryEnvelope) {
        ClientReport resetCountsAndGenerateClientReport = resetCountsAndGenerateClientReport();
        if (resetCountsAndGenerateClientReport == null) {
            return sentryEnvelope;
        }
        try {
            this.options.getLogger().log(SentryLevel.DEBUG, "Attaching client report to envelope.", new Object[0]);
            ArrayList arrayList = new ArrayList();
            for (SentryEnvelopeItem add : sentryEnvelope.getItems()) {
                arrayList.add(add);
            }
            arrayList.add(SentryEnvelopeItem.fromClientReport(this.options.getSerializer(), resetCountsAndGenerateClientReport));
            return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Unable to attach client report to envelope.", new Object[0]);
            return sentryEnvelope;
        }
    }

    public void recordLostEnvelope(DiscardReason discardReason, SentryEnvelope sentryEnvelope) {
        if (sentryEnvelope != null) {
            try {
                for (SentryEnvelopeItem recordLostEnvelopeItem : sentryEnvelope.getItems()) {
                    recordLostEnvelopeItem(discardReason, recordLostEnvelopeItem);
                }
            } catch (Throwable th) {
                this.options.getLogger().log(SentryLevel.ERROR, th, "Unable to record lost envelope.", new Object[0]);
            }
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:6|7|8|9|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0022 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recordLostEnvelopeItem(io.sentry.clientreport.DiscardReason r4, io.sentry.SentryEnvelopeItem r5) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            r0 = 0
            io.sentry.SentryEnvelopeItemHeader r1 = r5.getHeader()     // Catch:{ all -> 0x0048 }
            io.sentry.SentryItemType r1 = r1.getType()     // Catch:{ all -> 0x0048 }
            io.sentry.SentryItemType r2 = io.sentry.SentryItemType.ClientReport     // Catch:{ all -> 0x0048 }
            boolean r2 = r2.equals(r1)     // Catch:{ all -> 0x0048 }
            if (r2 == 0) goto L_0x0032
            io.sentry.SentryOptions r4 = r3.options     // Catch:{ Exception -> 0x0022 }
            io.sentry.ISerializer r4 = r4.getSerializer()     // Catch:{ Exception -> 0x0022 }
            io.sentry.clientreport.ClientReport r4 = r5.getClientReport(r4)     // Catch:{ Exception -> 0x0022 }
            r3.restoreCountsFromClientReport(r4)     // Catch:{ Exception -> 0x0022 }
            goto L_0x0058
        L_0x0022:
            io.sentry.SentryOptions r4 = r3.options     // Catch:{ all -> 0x0048 }
            io.sentry.ILogger r4 = r4.getLogger()     // Catch:{ all -> 0x0048 }
            io.sentry.SentryLevel r5 = io.sentry.SentryLevel.ERROR     // Catch:{ all -> 0x0048 }
            java.lang.String r1 = "Unable to restore counts from previous client report."
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ all -> 0x0048 }
            r4.log((io.sentry.SentryLevel) r5, (java.lang.String) r1, (java.lang.Object[]) r2)     // Catch:{ all -> 0x0048 }
            goto L_0x0058
        L_0x0032:
            java.lang.String r4 = r4.getReason()     // Catch:{ all -> 0x0048 }
            io.sentry.DataCategory r5 = r3.categoryFromItemType(r1)     // Catch:{ all -> 0x0048 }
            java.lang.String r5 = r5.getCategory()     // Catch:{ all -> 0x0048 }
            r1 = 1
            java.lang.Long r1 = java.lang.Long.valueOf(r1)     // Catch:{ all -> 0x0048 }
            r3.recordLostEventInternal(r4, r5, r1)     // Catch:{ all -> 0x0048 }
            goto L_0x0058
        L_0x0048:
            r4 = move-exception
            io.sentry.SentryOptions r5 = r3.options
            io.sentry.ILogger r5 = r5.getLogger()
            io.sentry.SentryLevel r1 = io.sentry.SentryLevel.ERROR
            java.lang.Object[] r0 = new java.lang.Object[r0]
            java.lang.String r2 = "Unable to record lost envelope item."
            r5.log(r1, r4, r2, r0)
        L_0x0058:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.clientreport.ClientReportRecorder.recordLostEnvelopeItem(io.sentry.clientreport.DiscardReason, io.sentry.SentryEnvelopeItem):void");
    }

    public void recordLostEvent(DiscardReason discardReason, DataCategory dataCategory) {
        try {
            recordLostEventInternal(discardReason.getReason(), dataCategory.getCategory(), 1L);
        } catch (Throwable th) {
            this.options.getLogger().log(SentryLevel.ERROR, th, "Unable to record lost event.", new Object[0]);
        }
    }

    private void recordLostEventInternal(String str, String str2, Long l) {
        this.storage.addCount(new ClientReportKey(str, str2), l);
    }

    /* access modifiers changed from: package-private */
    public ClientReport resetCountsAndGenerateClientReport() {
        Date currentDateTime = DateUtils.getCurrentDateTime();
        List<DiscardedEvent> resetCountsAndGet = this.storage.resetCountsAndGet();
        if (resetCountsAndGet.isEmpty()) {
            return null;
        }
        return new ClientReport(currentDateTime, resetCountsAndGet);
    }

    private void restoreCountsFromClientReport(ClientReport clientReport) {
        if (clientReport != null) {
            for (DiscardedEvent next : clientReport.getDiscardedEvents()) {
                recordLostEventInternal(next.getReason(), next.getCategory(), next.getQuantity());
            }
        }
    }

    private DataCategory categoryFromItemType(SentryItemType sentryItemType) {
        if (SentryItemType.Event.equals(sentryItemType)) {
            return DataCategory.Error;
        }
        if (SentryItemType.Session.equals(sentryItemType)) {
            return DataCategory.Session;
        }
        if (SentryItemType.Transaction.equals(sentryItemType)) {
            return DataCategory.Transaction;
        }
        if (SentryItemType.UserFeedback.equals(sentryItemType)) {
            return DataCategory.UserReport;
        }
        if (SentryItemType.Profile.equals(sentryItemType)) {
            return DataCategory.Profile;
        }
        if (SentryItemType.Statsd.equals(sentryItemType)) {
            return DataCategory.MetricBucket;
        }
        if (SentryItemType.Attachment.equals(sentryItemType)) {
            return DataCategory.Attachment;
        }
        if (SentryItemType.CheckIn.equals(sentryItemType)) {
            return DataCategory.Monitor;
        }
        return DataCategory.Default;
    }
}
