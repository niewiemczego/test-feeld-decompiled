package com.facebook.react.common.mapbuffer;

import com.facebook.react.common.mapbuffer.MapBuffer;
import com.facebook.react.common.mapbuffer.WritableMapBuffer;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;

@Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0010(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\t\u0010\t\u001a\u00020\nH\u0002J\t\u0010\u000b\u001a\u00020\u0002H\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"com/facebook/react/common/mapbuffer/WritableMapBuffer$iterator$1", "", "Lcom/facebook/react/common/mapbuffer/MapBuffer$Entry;", "count", "", "getCount", "()I", "setCount", "(I)V", "hasNext", "", "next", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WritableMapBuffer.kt */
public final class WritableMapBuffer$iterator$1 implements Iterator<MapBuffer.Entry>, KMappedMarker {
    private int count;
    final /* synthetic */ WritableMapBuffer this$0;

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    WritableMapBuffer$iterator$1(WritableMapBuffer writableMapBuffer) {
        this.this$0 = writableMapBuffer;
    }

    public final int getCount() {
        return this.count;
    }

    public final void setCount(int i) {
        this.count = i;
    }

    public boolean hasNext() {
        return this.count < this.this$0.values.size();
    }

    public MapBuffer.Entry next() {
        WritableMapBuffer writableMapBuffer = this.this$0;
        int i = this.count;
        this.count = i + 1;
        return new WritableMapBuffer.MapBufferEntry(writableMapBuffer, i);
    }
}
