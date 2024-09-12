package io.sentry.util;

public final class LazyEvaluator<T> {
    private final Evaluator<T> evaluator;
    private T value = null;

    public interface Evaluator<T> {
        T evaluate();
    }

    public LazyEvaluator(Evaluator<T> evaluator2) {
        this.evaluator = evaluator2;
    }

    public synchronized T getValue() {
        if (this.value == null) {
            this.value = this.evaluator.evaluate();
        }
        return this.value;
    }
}
