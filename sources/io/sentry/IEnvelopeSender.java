package io.sentry;

public interface IEnvelopeSender {
    void processEnvelopeFile(String str, Hint hint);
}
