package io.sentry;

import io.sentry.util.Objects;

public final class SamplingContext {
    private final CustomSamplingContext customSamplingContext;
    private final TransactionContext transactionContext;

    public SamplingContext(TransactionContext transactionContext2, CustomSamplingContext customSamplingContext2) {
        this.transactionContext = (TransactionContext) Objects.requireNonNull(transactionContext2, "transactionContexts is required");
        this.customSamplingContext = customSamplingContext2;
    }

    public CustomSamplingContext getCustomSamplingContext() {
        return this.customSamplingContext;
    }

    public TransactionContext getTransactionContext() {
        return this.transactionContext;
    }
}
