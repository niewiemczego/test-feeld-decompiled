package com.facebook.internal;

import com.facebook.internal.FileLruCache;
import java.io.File;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"com/facebook/internal/FileLruCache$openPutStream$renameToTargetCallback$1", "Lcom/facebook/internal/FileLruCache$StreamCloseCallback;", "onClose", "", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: FileLruCache.kt */
public final class FileLruCache$openPutStream$renameToTargetCallback$1 implements FileLruCache.StreamCloseCallback {
    final /* synthetic */ File $buffer;
    final /* synthetic */ long $bufferFileCreateTime;
    final /* synthetic */ String $key;
    final /* synthetic */ FileLruCache this$0;

    FileLruCache$openPutStream$renameToTargetCallback$1(long j, FileLruCache fileLruCache, File file, String str) {
        this.$bufferFileCreateTime = j;
        this.this$0 = fileLruCache;
        this.$buffer = file;
        this.$key = str;
    }

    public void onClose() {
        if (this.$bufferFileCreateTime < this.this$0.lastClearCacheTime.get()) {
            this.$buffer.delete();
        } else {
            this.this$0.renameToTargetAndTrim(this.$key, this.$buffer);
        }
    }
}
