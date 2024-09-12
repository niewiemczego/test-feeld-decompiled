package com.facebook;

import android.os.Handler;
import com.facebook.GraphRequestBatch;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u00020\u00012\u00020\u0002B1\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\b\u0010\u0019\u001a\u00020\u0017H\u0016J\b\u0010\u001a\u001a\u00020\u0017H\u0002J\u0012\u0010\u001b\u001a\u00020\u00172\b\u0010\u001c\u001a\u0004\u0018\u00010\tH\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J \u0010\u001d\u001a\u00020\u00172\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0016J\u0010\u0010\u001d\u001a\u00020\u00172\u0006\u0010#\u001a\u00020!H\u0016R\u001e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/facebook/ProgressOutputStream;", "Ljava/io/FilterOutputStream;", "Lcom/facebook/RequestOutputStream;", "out", "Ljava/io/OutputStream;", "requests", "Lcom/facebook/GraphRequestBatch;", "progressMap", "", "Lcom/facebook/GraphRequest;", "Lcom/facebook/RequestProgress;", "maxProgress", "", "(Ljava/io/OutputStream;Lcom/facebook/GraphRequestBatch;Ljava/util/Map;J)V", "<set-?>", "batchProgress", "getBatchProgress", "()J", "currentRequestProgress", "lastReportedProgress", "getMaxProgress", "threshold", "addProgress", "", "size", "close", "reportBatchProgress", "setCurrentRequest", "request", "write", "buffer", "", "offset", "", "length", "oneByte", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: ProgressOutputStream.kt */
public final class ProgressOutputStream extends FilterOutputStream implements RequestOutputStream {
    private long batchProgress;
    private RequestProgress currentRequestProgress;
    private long lastReportedProgress;
    private final long maxProgress;
    private final Map<GraphRequest, RequestProgress> progressMap;
    private final GraphRequestBatch requests;
    private final long threshold = FacebookSdk.getOnProgressThreshold();

    public final long getMaxProgress() {
        return this.maxProgress;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ProgressOutputStream(OutputStream outputStream, GraphRequestBatch graphRequestBatch, Map<GraphRequest, RequestProgress> map, long j) {
        super(outputStream);
        Intrinsics.checkNotNullParameter(outputStream, "out");
        Intrinsics.checkNotNullParameter(graphRequestBatch, "requests");
        Intrinsics.checkNotNullParameter(map, "progressMap");
        this.requests = graphRequestBatch;
        this.progressMap = map;
        this.maxProgress = j;
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
    }

    public final long getBatchProgress() {
        return this.batchProgress;
    }

    private final void addProgress(long j) {
        RequestProgress requestProgress = this.currentRequestProgress;
        if (requestProgress != null) {
            requestProgress.addProgress(j);
        }
        long j2 = this.batchProgress + j;
        this.batchProgress = j2;
        if (j2 >= this.lastReportedProgress + this.threshold || j2 >= this.maxProgress) {
            reportBatchProgress();
        }
    }

    private final void reportBatchProgress() {
        if (this.batchProgress > this.lastReportedProgress) {
            for (GraphRequestBatch.Callback next : this.requests.getCallbacks()) {
                if (next instanceof GraphRequestBatch.OnProgressCallback) {
                    Handler callbackHandler = this.requests.getCallbackHandler();
                    if ((callbackHandler == null ? null : Boolean.valueOf(callbackHandler.post(new ProgressOutputStream$$ExternalSyntheticLambda0(next, this)))) == null) {
                        ((GraphRequestBatch.OnProgressCallback) next).onBatchProgress(this.requests, this.batchProgress, this.maxProgress);
                    }
                }
            }
            this.lastReportedProgress = this.batchProgress;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: reportBatchProgress$lambda-0  reason: not valid java name */
    public static final void m214reportBatchProgress$lambda0(GraphRequestBatch.Callback callback, ProgressOutputStream progressOutputStream) {
        Intrinsics.checkNotNullParameter(callback, "$callback");
        Intrinsics.checkNotNullParameter(progressOutputStream, "this$0");
        ((GraphRequestBatch.OnProgressCallback) callback).onBatchProgress(progressOutputStream.requests, progressOutputStream.getBatchProgress(), progressOutputStream.getMaxProgress());
    }

    public void setCurrentRequest(GraphRequest graphRequest) {
        this.currentRequestProgress = graphRequest != null ? this.progressMap.get(graphRequest) : null;
    }

    public void write(byte[] bArr) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.out.write(bArr);
        addProgress((long) bArr.length);
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        Intrinsics.checkNotNullParameter(bArr, "buffer");
        this.out.write(bArr, i, i2);
        addProgress((long) i2);
    }

    public void write(int i) throws IOException {
        this.out.write(i);
        addProgress(1);
    }

    public void close() throws IOException {
        super.close();
        for (RequestProgress reportProgress : this.progressMap.values()) {
            reportProgress.reportProgress();
        }
        reportBatchProgress();
    }
}
