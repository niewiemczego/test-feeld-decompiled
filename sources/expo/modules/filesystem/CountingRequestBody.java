package expo.modules.filesystem;

import java.io.IOException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lexpo/modules/filesystem/CountingRequestBody;", "Lokhttp3/RequestBody;", "requestBody", "progressListener", "Lexpo/modules/filesystem/CountingRequestListener;", "(Lokhttp3/RequestBody;Lexpo/modules/filesystem/CountingRequestListener;)V", "contentLength", "", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "expo-file-system_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CountingRequestBody.kt */
public final class CountingRequestBody extends RequestBody {
    private final CountingRequestListener progressListener;
    private final RequestBody requestBody;

    public CountingRequestBody(RequestBody requestBody2, CountingRequestListener countingRequestListener) {
        Intrinsics.checkNotNullParameter(requestBody2, "requestBody");
        Intrinsics.checkNotNullParameter(countingRequestListener, "progressListener");
        this.requestBody = requestBody2;
        this.progressListener = countingRequestListener;
    }

    public MediaType contentType() {
        return this.requestBody.contentType();
    }

    public long contentLength() throws IOException {
        return this.requestBody.contentLength();
    }

    public void writeTo(BufferedSink bufferedSink) {
        Intrinsics.checkNotNullParameter(bufferedSink, "sink");
        BufferedSink buffer = Okio.buffer((Sink) new CountingSink(bufferedSink, this, this.progressListener));
        this.requestBody.writeTo(buffer);
        buffer.flush();
    }
}
