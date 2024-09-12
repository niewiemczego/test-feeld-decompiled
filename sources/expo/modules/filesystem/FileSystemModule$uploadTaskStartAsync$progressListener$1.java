package expo.modules.filesystem;

import android.os.Bundle;
import expo.modules.core.interfaces.services.EventEmitter;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\b²\u0006\n\u0010\t\u001a\u00020\nX\u0002"}, d2 = {"expo/modules/filesystem/FileSystemModule$uploadTaskStartAsync$progressListener$1", "Lexpo/modules/filesystem/CountingRequestListener;", "mLastUpdate", "", "onProgress", "", "bytesWritten", "contentLength", "expo-file-system_release", "eventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FileSystemModule.kt */
public final class FileSystemModule$uploadTaskStartAsync$progressListener$1 implements CountingRequestListener {
    final /* synthetic */ String $uuid;
    private long mLastUpdate = -1;
    final /* synthetic */ FileSystemModule this$0;

    FileSystemModule$uploadTaskStartAsync$progressListener$1(FileSystemModule fileSystemModule, String str) {
        this.this$0 = fileSystemModule;
        this.$uuid = str;
    }

    /* renamed from: onProgress$lambda-0  reason: not valid java name */
    private static final EventEmitter m758onProgress$lambda0(Lazy<? extends EventEmitter> lazy) {
        Object value = lazy.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "onProgress$lambda-0(...)");
        return (EventEmitter) value;
    }

    public void onProgress(long j, long j2) {
        Lazy lazy = LazyKt.lazy(new FileSystemModule$uploadTaskStartAsync$progressListener$1$onProgress$$inlined$moduleRegistry$1(this.this$0.moduleRegistryDelegate));
        Bundle bundle = new Bundle();
        Bundle bundle2 = new Bundle();
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis > this.mLastUpdate + 100 || j == j2) {
            this.mLastUpdate = currentTimeMillis;
            bundle2.putDouble("totalBytesSent", (double) j);
            bundle2.putDouble("totalBytesExpectedToSend", (double) j2);
            bundle.putString("uuid", this.$uuid);
            bundle.putBundle("data", bundle2);
            m758onProgress$lambda0(lazy).emit("expo-file-system.uploadProgress", bundle);
        }
    }
}
