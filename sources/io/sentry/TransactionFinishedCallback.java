package io.sentry;

public interface TransactionFinishedCallback {
    void execute(ITransaction iTransaction);
}
