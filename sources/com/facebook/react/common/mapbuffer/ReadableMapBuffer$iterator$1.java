package com.facebook.react.common.mapbuffer;

import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.ReadableMapBuffer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\u000b\u001a\u00020\fH\u0002J\t\u0010\r\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006¨\u0006\u000e"}, d2 = {"com/facebook/react/common/mapbuffer/ReadableMapBuffer$iterator$1", "", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "current", "", "getCurrent", "()I", "setCurrent", "(I)V", "last", "getLast", "hasNext", "", "next", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ReadableMapBuffer.kt */
public final class ReadableMapBuffer$iterator$1 implements Iterator<MapBuffer.Entry>, KMappedMarker {
    private int current;
    private final int last;
    final /* synthetic */ ReadableMapBuffer this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    ReadableMapBuffer$iterator$1(ReadableMapBuffer readableMapBuffer) {
        this.this$0 = readableMapBuffer;
        this.last = readableMapBuffer.getCount() - 1;
    }

    public final int getCurrent() {
        return this.current;
    }

    public final void setCurrent(int i) {
        this.current = i;
    }

    public final int getLast() {
        return this.last;
    }

    public boolean hasNext() {
        return this.current <= this.last;
    }

    public MapBuffer.Entry next() {
        ReadableMapBuffer readableMapBuffer = this.this$0;
        int i = this.current;
        this.current = i + 1;
        return new ReadableMapBuffer.MapBufferEntry(readableMapBuffer, readableMapBuffer.getKeyOffsetForBucketIndex(i));
    }
}
