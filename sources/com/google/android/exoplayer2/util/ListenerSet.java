package com.google.android.exoplayer2.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.util.FlagSet;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

public final class ListenerSet<T> {
    private static final int MSG_ITERATION_FINISHED = 0;
    private final Clock clock;
    private final ArrayDeque<Runnable> flushingEvents;
    private final HandlerWrapper handler;
    private final IterationFinishedEvent<T> iterationFinishedEvent;
    private final CopyOnWriteArraySet<ListenerHolder<T>> listeners;
    private final ArrayDeque<Runnable> queuedEvents;
    private boolean released;

    public interface Event<T> {
        void invoke(T t);
    }

    public interface IterationFinishedEvent<T> {
        void invoke(T t, FlagSet flagSet);
    }

    public ListenerSet(Looper looper, Clock clock2, IterationFinishedEvent<T> iterationFinishedEvent2) {
        this(new CopyOnWriteArraySet(), looper, clock2, iterationFinishedEvent2);
    }

    private ListenerSet(CopyOnWriteArraySet<ListenerHolder<T>> copyOnWriteArraySet, Looper looper, Clock clock2, IterationFinishedEvent<T> iterationFinishedEvent2) {
        this.clock = clock2;
        this.listeners = copyOnWriteArraySet;
        this.iterationFinishedEvent = iterationFinishedEvent2;
        this.flushingEvents = new ArrayDeque<>();
        this.queuedEvents = new ArrayDeque<>();
        this.handler = clock2.createHandler(looper, new ListenerSet$$ExternalSyntheticLambda0(this));
    }

    public ListenerSet<T> copy(Looper looper, IterationFinishedEvent<T> iterationFinishedEvent2) {
        return copy(looper, this.clock, iterationFinishedEvent2);
    }

    public ListenerSet<T> copy(Looper looper, Clock clock2, IterationFinishedEvent<T> iterationFinishedEvent2) {
        return new ListenerSet<>(this.listeners, looper, clock2, iterationFinishedEvent2);
    }

    public void add(T t) {
        if (!this.released) {
            Assertions.checkNotNull(t);
            this.listeners.add(new ListenerHolder(t));
        }
    }

    public void remove(T t) {
        Iterator<ListenerHolder<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            ListenerHolder next = it.next();
            if (next.listener.equals(t)) {
                next.release(this.iterationFinishedEvent);
                this.listeners.remove(next);
            }
        }
    }

    public void clear() {
        this.listeners.clear();
    }

    public int size() {
        return this.listeners.size();
    }

    public void queueEvent(int i, Event<T> event) {
        this.queuedEvents.add(new ListenerSet$$ExternalSyntheticLambda1(new CopyOnWriteArraySet(this.listeners), i, event));
    }

    static /* synthetic */ void lambda$queueEvent$0(CopyOnWriteArraySet copyOnWriteArraySet, int i, Event event) {
        Iterator it = copyOnWriteArraySet.iterator();
        while (it.hasNext()) {
            ((ListenerHolder) it.next()).invoke(i, event);
        }
    }

    public void flushEvents() {
        if (!this.queuedEvents.isEmpty()) {
            if (!this.handler.hasMessages(0)) {
                HandlerWrapper handlerWrapper = this.handler;
                handlerWrapper.sendMessageAtFrontOfQueue(handlerWrapper.obtainMessage(0));
            }
            boolean z = !this.flushingEvents.isEmpty();
            this.flushingEvents.addAll(this.queuedEvents);
            this.queuedEvents.clear();
            if (!z) {
                while (!this.flushingEvents.isEmpty()) {
                    this.flushingEvents.peekFirst().run();
                    this.flushingEvents.removeFirst();
                }
            }
        }
    }

    public void sendEvent(int i, Event<T> event) {
        queueEvent(i, event);
        flushEvents();
    }

    public void release() {
        Iterator<ListenerHolder<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().release(this.iterationFinishedEvent);
        }
        this.listeners.clear();
        this.released = true;
    }

    /* access modifiers changed from: private */
    public boolean handleMessage(Message message) {
        Iterator<ListenerHolder<T>> it = this.listeners.iterator();
        while (it.hasNext()) {
            it.next().iterationFinished(this.iterationFinishedEvent);
            if (this.handler.hasMessages(0)) {
                return true;
            }
        }
        return true;
    }

    private static final class ListenerHolder<T> {
        private FlagSet.Builder flagsBuilder = new FlagSet.Builder();
        public final T listener;
        private boolean needsIterationFinishedEvent;
        private boolean released;

        public ListenerHolder(T t) {
            this.listener = t;
        }

        public void release(IterationFinishedEvent<T> iterationFinishedEvent) {
            this.released = true;
            if (this.needsIterationFinishedEvent) {
                iterationFinishedEvent.invoke(this.listener, this.flagsBuilder.build());
            }
        }

        public void invoke(int i, Event<T> event) {
            if (!this.released) {
                if (i != -1) {
                    this.flagsBuilder.add(i);
                }
                this.needsIterationFinishedEvent = true;
                event.invoke(this.listener);
            }
        }

        public void iterationFinished(IterationFinishedEvent<T> iterationFinishedEvent) {
            if (!this.released && this.needsIterationFinishedEvent) {
                FlagSet build = this.flagsBuilder.build();
                this.flagsBuilder = new FlagSet.Builder();
                this.needsIterationFinishedEvent = false;
                iterationFinishedEvent.invoke(this.listener, build);
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.listener.equals(((ListenerHolder) obj).listener);
        }

        public int hashCode() {
            return this.listener.hashCode();
        }
    }
}
