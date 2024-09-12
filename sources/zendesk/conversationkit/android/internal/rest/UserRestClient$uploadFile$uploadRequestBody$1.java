package zendesk.conversationkit.android.internal.rest;

import java.io.File;
import kotlin.Metadata;
import okhttp3.MediaType;
import okhttp3.RequestBody;

@Metadata(d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0006\u001a\u00020\u0005H\u0016J\n\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"zendesk/conversationkit/android/internal/rest/UserRestClient$uploadFile$uploadRequestBody$1", "Lokhttp3/RequestBody;", "emptyArray", "", "fileLength", "", "contentLength", "contentType", "Lokhttp3/MediaType;", "writeTo", "", "sink", "Lokio/BufferedSink;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UserRestClient.kt */
public final class UserRestClient$uploadFile$uploadRequestBody$1 extends RequestBody {
    final /* synthetic */ MediaType $mediaType;
    final /* synthetic */ File $sourceFile;
    private final byte[] emptyArray;
    private final long fileLength;

    UserRestClient$uploadFile$uploadRequestBody$1(File file, MediaType mediaType) {
        this.$sourceFile = file;
        this.$mediaType = mediaType;
        this.fileLength = file.length();
        byte[] bArr = new byte[1];
        for (int i = 0; i < 1; i++) {
            bArr[i] = 0;
        }
        this.emptyArray = bArr;
    }

    public MediaType contentType() {
        return this.$mediaType;
    }

    public long contentLength() {
        long j = this.fileLength;
        return j > 0 ? j : (long) this.emptyArray.length;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        kotlin.io.CloseableKt.closeFinally(r0, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0026, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r1 = move-exception;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeTo(okio.BufferedSink r5) {
        /*
            r4 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            long r0 = r4.fileLength
            r2 = 0
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L_0x0027
            java.io.File r0 = r4.$sourceFile
            okio.Source r0 = okio.Okio.source((java.io.File) r0)
            java.io.Closeable r0 = (java.io.Closeable) r0
            r1 = 0
            r2 = r0
            okio.Source r2 = (okio.Source) r2     // Catch:{ all -> 0x0020 }
            r5.writeAll(r2)     // Catch:{ all -> 0x0020 }
            kotlin.io.CloseableKt.closeFinally(r0, r1)
            goto L_0x002c
        L_0x0020:
            r5 = move-exception
            throw r5     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r1 = move-exception
            kotlin.io.CloseableKt.closeFinally(r0, r5)
            throw r1
        L_0x0027:
            byte[] r0 = r4.emptyArray
            r5.write((byte[]) r0)
        L_0x002c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.internal.rest.UserRestClient$uploadFile$uploadRequestBody$1.writeTo(okio.BufferedSink):void");
    }
}
