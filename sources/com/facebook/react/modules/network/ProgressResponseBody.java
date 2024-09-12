package com.facebook.react.modules.network;

import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.ForwardingSource;
import okio.Okio;
import okio.Source;

public class ProgressResponseBody extends ResponseBody {
    private BufferedSource mBufferedSource;
    /* access modifiers changed from: private */
    public final ProgressListener mProgressListener;
    /* access modifiers changed from: private */
    public final ResponseBody mResponseBody;
    /* access modifiers changed from: private */
    public long mTotalBytesRead = 0;

    static /* synthetic */ long access$014(ProgressResponseBody progressResponseBody, long j) {
        long j2 = progressResponseBody.mTotalBytesRead + j;
        progressResponseBody.mTotalBytesRead = j2;
        return j2;
    }

    public ProgressResponseBody(ResponseBody responseBody, ProgressListener progressListener) {
        this.mResponseBody = responseBody;
        this.mProgressListener = progressListener;
    }

    public MediaType contentType() {
        return this.mResponseBody.contentType();
    }

    public long contentLength() {
        return this.mResponseBody.contentLength();
    }

    public long totalBytesRead() {
        return this.mTotalBytesRead;
    }

    public BufferedSource source() {
        if (this.mBufferedSource == null) {
            this.mBufferedSource = Okio.buffer(source(this.mResponseBody.source()));
        }
        return this.mBufferedSource;
    }

    private Source source(Source source) {
        return new ForwardingSource(source) {
            public long read(Buffer buffer, long j) throws IOException {
                long read = super.read(buffer, j);
                int i = (read > -1 ? 1 : (read == -1 ? 0 : -1));
                ProgressResponseBody.access$014(ProgressResponseBody.this, i != 0 ? read : 0);
                ProgressResponseBody.this.mProgressListener.onProgress(ProgressResponseBody.this.mTotalBytesRead, ProgressResponseBody.this.mResponseBody.contentLength(), i == 0);
                return read;
            }
        };
    }
}
