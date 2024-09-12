package com.ReactNativeBlobUtil.Response;

import com.ReactNativeBlobUtil.ReactNativeBlobUtilConst;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilProgressConfig;
import com.ReactNativeBlobUtil.ReactNativeBlobUtilReq;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import java.io.IOException;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.ResponseBody;
import okio.Buffer;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;
import okio.Timeout;

public class ReactNativeBlobUtilDefaultResp extends ResponseBody {
    boolean isIncrement;
    String mTaskId;
    ResponseBody originalBody;
    ReactApplicationContext rctContext;

    public ReactNativeBlobUtilDefaultResp(ReactApplicationContext reactApplicationContext, String str, ResponseBody responseBody, boolean z) {
        this.rctContext = reactApplicationContext;
        this.mTaskId = str;
        this.originalBody = responseBody;
        this.isIncrement = z;
    }

    public MediaType contentType() {
        return this.originalBody.contentType();
    }

    public long contentLength() {
        return this.originalBody.contentLength();
    }

    public BufferedSource source() {
        return Okio.buffer((Source) new ProgressReportingSource(this.originalBody.source()));
    }

    private class ProgressReportingSource implements Source {
        long bytesRead = 0;
        BufferedSource mOriginalSource;

        public void close() throws IOException {
        }

        public Timeout timeout() {
            return null;
        }

        ProgressReportingSource(BufferedSource bufferedSource) {
            this.mOriginalSource = bufferedSource;
        }

        public long read(Buffer buffer, long j) throws IOException {
            long read = this.mOriginalSource.read(buffer, j);
            this.bytesRead += read > 0 ? read : 0;
            ReactNativeBlobUtilProgressConfig reportProgress = ReactNativeBlobUtilReq.getReportProgress(ReactNativeBlobUtilDefaultResp.this.mTaskId);
            long contentLength = ReactNativeBlobUtilDefaultResp.this.contentLength();
            if (!(reportProgress == null || contentLength == 0 || !reportProgress.shouldReport((float) (this.bytesRead / ReactNativeBlobUtilDefaultResp.this.contentLength())))) {
                WritableMap createMap = Arguments.createMap();
                createMap.putString("taskId", ReactNativeBlobUtilDefaultResp.this.mTaskId);
                createMap.putString("written", String.valueOf(this.bytesRead));
                createMap.putString("total", String.valueOf(ReactNativeBlobUtilDefaultResp.this.contentLength()));
                if (ReactNativeBlobUtilDefaultResp.this.isIncrement) {
                    createMap.putString("chunk", buffer.readString(Charset.defaultCharset()));
                } else {
                    createMap.putString("chunk", "");
                }
                ((DeviceEventManagerModule.RCTDeviceEventEmitter) ReactNativeBlobUtilDefaultResp.this.rctContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit(ReactNativeBlobUtilConst.EVENT_PROGRESS, createMap);
            }
            return read;
        }
    }
}
