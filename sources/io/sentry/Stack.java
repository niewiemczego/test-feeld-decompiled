package io.sentry;

import io.sentry.util.Objects;
import java.util.Deque;
import java.util.Iterator;
import java.util.concurrent.LinkedBlockingDeque;

final class Stack {
    private final Deque<StackItem> items;
    private final ILogger logger;

    static final class StackItem {
        private volatile ISentryClient client;
        private final SentryOptions options;
        private volatile IScope scope;

        StackItem(SentryOptions sentryOptions, ISentryClient iSentryClient, IScope iScope) {
            this.client = (ISentryClient) Objects.requireNonNull(iSentryClient, "ISentryClient is required.");
            this.scope = (IScope) Objects.requireNonNull(iScope, "Scope is required.");
            this.options = (SentryOptions) Objects.requireNonNull(sentryOptions, "Options is required");
        }

        StackItem(StackItem stackItem) {
            this.options = stackItem.options;
            this.client = stackItem.client;
            this.scope = stackItem.scope.clone();
        }

        public ISentryClient getClient() {
            return this.client;
        }

        public void setClient(ISentryClient iSentryClient) {
            this.client = iSentryClient;
        }

        public IScope getScope() {
            return this.scope;
        }

        public SentryOptions getOptions() {
            return this.options;
        }
    }

    public Stack(ILogger iLogger, StackItem stackItem) {
        LinkedBlockingDeque linkedBlockingDeque = new LinkedBlockingDeque();
        this.items = linkedBlockingDeque;
        this.logger = (ILogger) Objects.requireNonNull(iLogger, "logger is required");
        linkedBlockingDeque.push((StackItem) Objects.requireNonNull(stackItem, "rootStackItem is required"));
    }

    public Stack(Stack stack) {
        this(stack.logger, new StackItem(stack.items.getLast()));
        Iterator<StackItem> descendingIterator = stack.items.descendingIterator();
        if (descendingIterator.hasNext()) {
            descendingIterator.next();
        }
        while (descendingIterator.hasNext()) {
            push(new StackItem(descendingIterator.next()));
        }
    }

    /* access modifiers changed from: package-private */
    public StackItem peek() {
        return this.items.peek();
    }

    /* access modifiers changed from: package-private */
    public void pop() {
        synchronized (this.items) {
            if (this.items.size() != 1) {
                this.items.pop();
            } else {
                this.logger.log(SentryLevel.WARNING, "Attempt to pop the root scope.", new Object[0]);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void push(StackItem stackItem) {
        this.items.push(stackItem);
    }

    /* access modifiers changed from: package-private */
    public int size() {
        return this.items.size();
    }
}
