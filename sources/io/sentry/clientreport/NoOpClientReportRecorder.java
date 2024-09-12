package io.sentry.clientreport;

import io.sentry.DataCategory;
import io.sentry.SentryEnvelope;
import io.sentry.SentryEnvelopeItem;

public final class NoOpClientReportRecorder implements IClientReportRecorder {
    public SentryEnvelope attachReportToEnvelope(SentryEnvelope sentryEnvelope) {
        return sentryEnvelope;
    }

    public void recordLostEnvelope(DiscardReason discardReason, SentryEnvelope sentryEnvelope) {
    }

    public void recordLostEnvelopeItem(DiscardReason discardReason, SentryEnvelopeItem sentryEnvelopeItem) {
    }

    public void recordLostEvent(DiscardReason discardReason, DataCategory dataCategory) {
    }
}
