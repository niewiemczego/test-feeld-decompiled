package com.ReactNativeBlobUtil.Response;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public class ReactNativeBlobUtilFileResp extends ResponseBody {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesDownloaded = 0;
    boolean isEndMarkerReceived;
    String mPath;
    String mTaskId;
    FileOutputStream ofStream;
    ResponseBody originalBody;
    ReactApplicationContext rctContext;

    public ReactNativeBlobUtilFileResp(ResponseBody responseBody) {
        this.originalBody = responseBody;
    }

    public ReactNativeBlobUtilFileResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, String str2, boolean z) throws IOException {
        this.rctContext = reactApplicationContext;
        this.mTaskId = str;
        this.originalBody = responseBody;
        this.mPath = str2;
        this.isEndMarkerReceived = false;
        if (str2 != null) {
            boolean z2 = !z;
            String replace = str2.replace("?append=true", "");
            this.mPath = replace;
            File file = new File(replace);
            File parentFile = file.getParentFile();
            if (parentFile == null || parentFile.exists() || parentFile.mkdirs()) {
                if (!file.exists()) {
                    file.createNewFile();
                }
                this.ofStream = new FileOutputStream(new File(replace), z2);
                return;
            }
            throw new IllegalStateException("Couldn't create dir: " + parentFile);
        }
    }

    public MediaType contentType() {
        return this.originalBody.contentType();
    }

    public long contentLength() {
        if (this.originalBody.contentLength() > 2147483647L) {
            return 2147483647L;
        }
        return this.originalBody.contentLength();
    }

    public boolean isDownloadComplete() {
        return this.bytesDownloaded == contentLength() || (contentLength() == -1 && this.isEndMarkerReceived);
    }

    public BufferedSource source() {
        return Okio.buffer((Source) new ProgressReportingSource());
    }

    private class ProgressReportingSource implements Source {
        public Timeout timeout() {
            return null;
        }

        private ProgressReportingSource() {
        }

        public long read(Buffer buffer, long j) throws IOException {
            int i = (int) j;
            try {
                byte[] bArr = new byte[i];
                long read = (long) ReactNativeBlobUtilFileResp.this.originalBody.byteStream().read(bArr, 0, i);
                int i2 = (read > 0 ? 1 : (read == 0 ? 0 : -1));
                ReactNativeBlobUtilFileResp.this.bytesDownloaded += i2 > 0 ? read : 0;
                if (i2 > 0) {
                    ReactNativeBlobUtilFileResp.this.ofStream.write(bArr, 0, (int) read);
                } else if (ReactNativeBlobUtilFileResp.this.contentLength() == -1 && read == -1) {
                    ReactNativeBlobUtilFileResp.this.isEndMarkerReceived = true;
                }
                ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilFileResp.this.mTaskId);
                if (ReactNativeBlobUtilFileResp.this.contentLength() != 0) {
                    float contentLength = ReactNativeBlobUtilFileResp.this.contentLength() != -1 ? (float) (ReactNativeBlobUtilFileResp.this.bytesDownloaded / ReactNativeBlobUtilFileResp.this.contentLength()) : ReactNativeBlobUtilFileResp.this.isEndMarkerReceived ? 1.0f : 0.0f;
                    if (reportProgress != null && reportProgress.shouldReport(contentLength)) {
                        if (ReactNativeBlobUtilFileResp.this.contentLength() != -1) {
                            reportProgress(ReactNativeBlobUtilFileResp.this.mTaskId, ReactNativeBlobUtilFileResp.this.bytesDownloaded, ReactNativeBlobUtilFileResp.this.contentLength());
                        } else if (!ReactNativeBlobUtilFileResp.this.isEndMarkerReceived) {
                            reportProgress(ReactNativeBlobUtilFileResp.this.mTaskId, 0, ReactNativeBlobUtilFileResp.this.contentLength());
                        } else {
                            reportProgress(ReactNativeBlobUtilFileResp.this.mTaskId, ReactNativeBlobUtilFileResp.this.bytesDownloaded, ReactNativeBlobUtilFileResp.this.bytesDownloaded);
                        }
                    }
                }
                return read;
            } catch (Exception unused) {
                return -1;
            }
        }

        private void reportProgress(String str, long j, long j2) {
            WritableMap createMap = Arguments.createMap();
            createMap.putString("taskId", str);
            createMap.putString("written", String.valueOf(j));
            createMap.putString("total", String.valueOf(j2));
            ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilFileResp.this.rctContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, createMap);
        }

        public void close() throws IOException {
            ReactNativeBlobUtilFileResp.this.ofStream.close();
        }
    }
}
