package io.sentry;

import java.util.Queue;

final class SynchronizedQueue<E> extends SynchronizedCollection<E> implements Queue<E> {
    private static final long serialVersionUID = 1;

    static <E> SynchronizedQueue<E> synchronizedQueue(Queue<E> queue) {
        return new SynchronizedQueue<>(queue);
    }

    private SynchronizedQueue(Queue<E> queue) {
        super(queue);
    }

    protected SynchronizedQueue(Queue<E> queue, Object obj) {
        super(queue, obj);
    }

    /* access modifiers changed from: protected */
    public Queue<E> decorated() {
        return (Queue) super.decorated();
    }

    public E element() {
        E element;
        synchronized (this.lock) {
            element = decorated().element();
        }
        return element;
    }

    public boolean equals(Object obj) {
        boolean equals;
        if (obj == this) {
            return true;
        }
        synchronized (this.lock) {
            equals = decorated().equals(obj);
        }
        return equals;
    }

    public int hashCode() {
        int hashCode;
        synchronized (this.lock) {
            hashCode = decorated().hashCode();
        }
        return hashCode;
    }

    public boolean offer(E e) {
        boolean offer;
        synchronized (this.lock) {
            offer = decorated().offer(e);
        }
        return offer;
    }

    public E peek() {
        E peek;
        synchronized (this.lock) {
            peek = decorated().peek();
        }
        return peek;
    }

    public E poll() {
        E poll;
        synchronized (this.lock) {
            poll = decorated().poll();
        }
        return poll;
    }

    public E remove() {
        E remove;
        synchronized (this.lock) {
            remove = decorated().remove();
        }
        return remove;
    }

    public Object[] toArray() {
        Object[] array;
        synchronized (this.lock) {
            array = decorated().toArray();
        }
        return array;
    }

    public <T> T[] toArray(T[] tArr) {
        T[] array;
        synchronized (this.lock) {
            array = decorated().toArray(tArr);
        }
        return array;
    }
}
