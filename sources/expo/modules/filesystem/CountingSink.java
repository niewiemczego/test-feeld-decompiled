package expo.modules.filesystem;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.RequestBody;
import okio.Buffer;
import okio.ForwardingSink;
import okio.Sink;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nH\u0016R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/filesystem/CountingSink;", "Lokio/ForwardingSink;", "sink", "Lokio/Sink;", "requestBody", "Lokhttp3/RequestBody;", "progressListener", "Lexpo/modules/filesystem/CountingRequestListener;", "(Lokio/Sink;Lokhttp3/RequestBody;Lexpo/modules/filesystem/CountingRequestListener;)V", "bytesWritten", "", "write", "", "source", "Lokio/Buffer;", "byteCount", "expo-file-system_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CountingRequestBody.kt */
final class CountingSink extends ForwardingSink {
    private long bytesWritten;
    private final CountingRequestListener progressListener;
    private final RequestBody requestBody;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CountingSink(Sink sink, RequestBody requestBody2, CountingRequestListener countingRequestListener) {
        super(sink);
        Intrinsics.checkNotNullParameter(sink, "sink");
        Intrinsics.checkNotNullParameter(requestBody2, "requestBody");
        Intrinsics.checkNotNullParameter(countingRequestListener, "progressListener");
        this.requestBody = requestBody2;
        this.progressListener = countingRequestListener;
    }

    public void write(Buffer buffer, long j) {
        Intrinsics.checkNotNullParameter(buffer, "source");
        super.write(buffer, j);
        long j2 = this.bytesWritten + j;
        this.bytesWritten = j2;
        this.progressListener.onProgress(j2, this.requestBody.contentLength());
    }
}
