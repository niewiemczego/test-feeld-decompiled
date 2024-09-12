package io.sentry.transport;

import com.google.android.gms.common.Scopes;
import io.sentry.DataCategory;
import io.sentry.Hint;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;
import io.sentry.SentryLevel;
import io.sentry.SentryOptions;
import io.sentry.cache.EnvelopeCache;
import io.sentry.clientreport.DiscardReason;
import io.sentry.hints.Retryable;
import io.sentry.hints.SubmissionResult;
import io.sentry.util.HintUtils;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class RateLimiter {
    private static final int HTTP_RETRY_AFTER_DEFAULT_DELAY_MILLIS = 60000;
    private final ICurrentDateProvider currentDateProvider;
    private final SentryOptions options;
    private final Map<DataCategory, Date> sentryRetryAfterLimit;

    public RateLimiter(ICurrentDateProvider iCurrentDateProvider, SentryOptions sentryOptions) {
        this.sentryRetryAfterLimit = new ConcurrentHashMap();
        this.currentDateProvider = iCurrentDateProvider;
        this.options = sentryOptions;
    }

    public RateLimiter(SentryOptions sentryOptions) {
        this(CurrentDateProvider.getInstance(), sentryOptions);
    }

    public SentryEnvelope filter(SentryEnvelope sentryEnvelope, Hint hint) {
        ArrayList arrayList = null;
        for (SentryEnvelopeItem next : sentryEnvelope.getItems()) {
            if (isRetryAfter(next.getHeader().getType().getItemType())) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                arrayList.add(next);
                this.options.getClientReportRecorder().recordLostEnvelopeItem(DiscardReason.RATELIMIT_BACKOFF, next);
            }
        }
        if (arrayList == null) {
            return sentryEnvelope;
        }
        this.options.getLogger().log(SentryLevel.INFO, "%d items will be dropped due rate limiting.", Integer.valueOf(arrayList.size()));
        ArrayList arrayList2 = new ArrayList();
        for (SentryEnvelopeItem next2 : sentryEnvelope.getItems()) {
            if (!arrayList.contains(next2)) {
                arrayList2.add(next2);
            }
        }
        if (!arrayList2.isEmpty()) {
            return new SentryEnvelope(sentryEnvelope.getHeader(), arrayList2);
        }
        this.options.getLogger().log(SentryLevel.INFO, "Envelope discarded due all items rate limited.", new Object[0]);
        markHintWhenSendingFailed(hint, false);
        return null;
    }

    public boolean isActiveForCategory(DataCategory dataCategory) {
        Date date;
        Date date2 = new Date(this.currentDateProvider.getCurrentTimeMillis());
        Date date3 = this.sentryRetryAfterLimit.get(DataCategory.All);
        if (date3 != null && !date2.after(date3)) {
            return true;
        }
        if (!DataCategory.Unknown.equals(dataCategory) && (date = this.sentryRetryAfterLimit.get(dataCategory)) != null) {
            return !date2.after(date);
        }
        return false;
    }

    public boolean isAnyRateLimitActive() {
        Date date = new Date(this.currentDateProvider.getCurrentTimeMillis());
        for (DataCategory dataCategory : this.sentryRetryAfterLimit.keySet()) {
            Date date2 = this.sentryRetryAfterLimit.get(dataCategory);
            if (date2 != null && !date.after(date2)) {
                return true;
            }
        }
        return false;
    }

    private static void markHintWhenSendingFailed(Hint hint, boolean z) {
        HintUtils.runIfHasType(hint, SubmissionResult.class, new RateLimiter$$ExternalSyntheticLambda0());
        HintUtils.runIfHasType(hint, Retryable.class, new RateLimiter$$ExternalSyntheticLambda1(z));
    }

    private boolean isRetryAfter(String str) {
        return isActiveForCategory(getCategoryFromItemType(str));
    }

    private DataCategory getCategoryFromItemType(String str) {
        str.hashCode();
        char c = 65535;
        switch (str.hashCode()) {
            case -1963501277:
                if (str.equals("attachment")) {
                    c = 0;
                    break;
                }
                break;
            case -892481627:
                if (str.equals("statsd")) {
                    c = 1;
                    break;
                }
                break;
            case -309425751:
                if (str.equals(Scopes.PROFILE)) {
                    c = 2;
                    break;
                }
                break;
            case 96891546:
                if (str.equals("event")) {
                    c = 3;
                    break;
                }
                break;
            case 1536888764:
                if (str.equals("check_in")) {
                    c = 4;
                    break;
                }
                break;
            case 1984987798:
                if (str.equals(EnvelopeCache.PREFIX_CURRENT_SESSION_FILE)) {
                    c = 5;
                    break;
                }
                break;
            case 2141246174:
                if (str.equals("transaction")) {
                    c = 6;
                    break;
                }
                break;
        }
        switch (c) {
            case 0:
                return DataCategory.Attachment;
            case 1:
                return DataCategory.MetricBucket;
            case 2:
                return DataCategory.Profile;
            case 3:
                return DataCategory.Error;
            case 4:
                return DataCategory.Monitor;
            case 5:
                return DataCategory.Session;
            case 6:
                return DataCategory.Transaction;
            default:
                return DataCategory.Unknown;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x00a6  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void updateRetryAfterLimits(java.lang.String r19, java.lang.String r20, int r21) {
        /*
            r18 = this;
            r1 = r18
            r0 = r19
            if (r0 == 0) goto L_0x00ee
            java.lang.String r2 = ","
            r3 = -1
            java.lang.String[] r2 = r0.split(r2, r3)
            int r4 = r2.length
            r5 = 0
            r6 = r5
        L_0x0010:
            if (r6 >= r4) goto L_0x010b
            r0 = r2[r6]
            java.lang.String r7 = " "
            java.lang.String r8 = ""
            java.lang.String r0 = r0.replace(r7, r8)
            java.lang.String r7 = ":"
            java.lang.String[] r0 = r0.split(r7, r3)
            int r7 = r0.length
            r9 = 4
            if (r7 <= r9) goto L_0x0029
            r7 = r0[r9]
            goto L_0x002a
        L_0x0029:
            r7 = 0
        L_0x002a:
            int r9 = r0.length
            if (r9 <= 0) goto L_0x00e0
            r9 = r0[r5]
            long r9 = r1.parseRetryAfterOrDefault(r9)
            int r11 = r0.length
            r12 = 1
            if (r11 <= r12) goto L_0x00e0
            r0 = r0[r12]
            java.util.Date r11 = new java.util.Date
            io.sentry.transport.ICurrentDateProvider r13 = r1.currentDateProvider
            long r13 = r13.getCurrentTimeMillis()
            long r13 = r13 + r9
            r11.<init>(r13)
            if (r0 == 0) goto L_0x00d5
            boolean r9 = r0.isEmpty()
            if (r9 != 0) goto L_0x00d5
            java.lang.String r9 = ";"
            java.lang.String[] r10 = r0.split(r9, r3)
            int r13 = r10.length
            r14 = r5
        L_0x0055:
            if (r14 >= r13) goto L_0x00e0
            r15 = r10[r14]
            io.sentry.DataCategory r16 = io.sentry.DataCategory.Unknown
            java.lang.String r0 = io.sentry.util.StringUtils.camelCase(r15)     // Catch:{ IllegalArgumentException -> 0x0086 }
            if (r0 == 0) goto L_0x006a
            io.sentry.DataCategory r0 = io.sentry.DataCategory.valueOf(r0)     // Catch:{ IllegalArgumentException -> 0x0086 }
            r16 = r0
            r21 = r2
            goto L_0x007f
        L_0x006a:
            io.sentry.SentryOptions r0 = r1.options     // Catch:{ IllegalArgumentException -> 0x0086 }
            io.sentry.ILogger r0 = r0.getLogger()     // Catch:{ IllegalArgumentException -> 0x0086 }
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.ERROR     // Catch:{ IllegalArgumentException -> 0x0086 }
            java.lang.String r5 = "Couldn't capitalize: %s"
            r21 = r2
            java.lang.Object[] r2 = new java.lang.Object[r12]     // Catch:{ IllegalArgumentException -> 0x0084 }
            r17 = 0
            r2[r17] = r15     // Catch:{ IllegalArgumentException -> 0x0084 }
            r0.log((io.sentry.SentryLevel) r3, (java.lang.String) r5, (java.lang.Object[]) r2)     // Catch:{ IllegalArgumentException -> 0x0084 }
        L_0x007f:
            r0 = r16
            r17 = 0
            goto L_0x009e
        L_0x0084:
            r0 = move-exception
            goto L_0x0089
        L_0x0086:
            r0 = move-exception
            r21 = r2
        L_0x0089:
            io.sentry.SentryOptions r2 = r1.options
            io.sentry.ILogger r2 = r2.getLogger()
            io.sentry.SentryLevel r3 = io.sentry.SentryLevel.INFO
            java.lang.Object[] r5 = new java.lang.Object[r12]
            r17 = 0
            r5[r17] = r15
            java.lang.String r15 = "Unknown category: %s"
            r2.log(r3, r0, r15, r5)
            r0 = r16
        L_0x009e:
            io.sentry.DataCategory r2 = io.sentry.DataCategory.Unknown
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00a8
            r2 = -1
            goto L_0x00cd
        L_0x00a8:
            io.sentry.DataCategory r2 = io.sentry.DataCategory.MetricBucket
            boolean r2 = r2.equals(r0)
            if (r2 == 0) goto L_0x00c9
            if (r7 == 0) goto L_0x00c9
            boolean r2 = r7.equals(r8)
            if (r2 != 0) goto L_0x00c9
            r2 = -1
            java.lang.String[] r3 = r7.split(r9, r2)
            int r5 = r3.length
            if (r5 <= 0) goto L_0x00ca
            java.lang.String r5 = "custom"
            boolean r3 = io.sentry.util.CollectionUtils.contains(r3, r5)
            if (r3 != 0) goto L_0x00ca
            goto L_0x00cd
        L_0x00c9:
            r2 = -1
        L_0x00ca:
            r1.applyRetryAfterOnlyIfLonger(r0, r11)
        L_0x00cd:
            int r14 = r14 + 1
            r3 = r2
            r5 = r17
            r2 = r21
            goto L_0x0055
        L_0x00d5:
            r21 = r2
            r2 = r3
            r17 = r5
            io.sentry.DataCategory r0 = io.sentry.DataCategory.All
            r1.applyRetryAfterOnlyIfLonger(r0, r11)
            goto L_0x00e5
        L_0x00e0:
            r21 = r2
            r2 = r3
            r17 = r5
        L_0x00e5:
            int r6 = r6 + 1
            r3 = r2
            r5 = r17
            r2 = r21
            goto L_0x0010
        L_0x00ee:
            r0 = 429(0x1ad, float:6.01E-43)
            r2 = r21
            if (r2 != r0) goto L_0x010b
            r0 = r20
            long r2 = r1.parseRetryAfterOrDefault(r0)
            java.util.Date r0 = new java.util.Date
            io.sentry.transport.ICurrentDateProvider r4 = r1.currentDateProvider
            long r4 = r4.getCurrentTimeMillis()
            long r4 = r4 + r2
            r0.<init>(r4)
            io.sentry.DataCategory r2 = io.sentry.DataCategory.All
            r1.applyRetryAfterOnlyIfLonger(r2, r0)
        L_0x010b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.sentry.transport.RateLimiter.updateRetryAfterLimits(java.lang.String, java.lang.String, int):void");
    }

    private void applyRetryAfterOnlyIfLonger(DataCategory dataCategory, Date date) {
        Date date2 = this.sentryRetryAfterLimit.get(dataCategory);
        if (date2 == null || date.after(date2)) {
            this.sentryRetryAfterLimit.put(dataCategory, date);
        }
    }

    private long parseRetryAfterOrDefault(String str) {
        if (str != null) {
            try {
                return (long) (Double.parseDouble(str) * 1000.0d);
            } catch (NumberFormatException unused) {
            }
        }
        return 60000;
    }
}
