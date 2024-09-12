package com.facebook.react.devsupport;

import com.facebook.fbreact.specs.NativeJSCHeapCaptureSpec;
import com.facebook.react.bridge.JavaScriptModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.io.File;

@ReactModule(name = "JSCHeapCapture", needsEagerInit = true)
public class JSCHeapCapture extends NativeJSCHeapCaptureSpec {
    public static final String TAG = "JSCHeapCapture";
    private CaptureCallback mCaptureInProgress = null;

    public interface CaptureCallback {
        void onFailure(CaptureException captureException);

        void onSuccess(File file);
    }

    public interface HeapCapture extends JavaScriptModule {
        void captureHeap(String str);
    }

    public String getName() {
        return TAG;
    }

    public static class CaptureException extends Exception {
        CaptureException(String str) {
            super(str);
        }

        CaptureException(String str, Throwable th) {
            super(str, th);
        }
    }

    public JSCHeapCapture(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0052, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void captureHeap(java.lang.String r3, com.facebook.react.devsupport.JSCHeapCapture.CaptureCallback r4) {
        /*
            r2 = this;
            monitor-enter(r2)
            com.facebook.react.devsupport.JSCHeapCapture$CaptureCallback r0 = r2.mCaptureInProgress     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0011
            com.facebook.react.devsupport.JSCHeapCapture$CaptureException r3 = new com.facebook.react.devsupport.JSCHeapCapture$CaptureException     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "Heap capture already in progress."
            r3.<init>(r0)     // Catch:{ all -> 0x0053 }
            r4.onFailure(r3)     // Catch:{ all -> 0x0053 }
            monitor-exit(r2)
            return
        L_0x0011:
            java.io.File r0 = new java.io.File     // Catch:{ all -> 0x0053 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0053 }
            r1.<init>()     // Catch:{ all -> 0x0053 }
            java.lang.StringBuilder r3 = r1.append(r3)     // Catch:{ all -> 0x0053 }
            java.lang.String r1 = "/capture.json"
            java.lang.StringBuilder r3 = r3.append(r1)     // Catch:{ all -> 0x0053 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0053 }
            r0.<init>(r3)     // Catch:{ all -> 0x0053 }
            r0.delete()     // Catch:{ all -> 0x0053 }
            com.facebook.react.bridge.ReactApplicationContext r3 = r2.getReactApplicationContextIfActiveOrWarn()     // Catch:{ all -> 0x0053 }
            if (r3 == 0) goto L_0x0051
            java.lang.Class<com.facebook.react.devsupport.JSCHeapCapture$HeapCapture> r1 = com.facebook.react.devsupport.JSCHeapCapture.HeapCapture.class
            com.facebook.react.bridge.JavaScriptModule r3 = r3.getJSModule(r1)     // Catch:{ all -> 0x0053 }
            com.facebook.react.devsupport.JSCHeapCapture$HeapCapture r3 = (com.facebook.react.devsupport.JSCHeapCapture.HeapCapture) r3     // Catch:{ all -> 0x0053 }
            if (r3 != 0) goto L_0x0048
            com.facebook.react.devsupport.JSCHeapCapture$CaptureException r3 = new com.facebook.react.devsupport.JSCHeapCapture$CaptureException     // Catch:{ all -> 0x0053 }
            java.lang.String r0 = "Heap capture js module not registered."
            r3.<init>(r0)     // Catch:{ all -> 0x0053 }
            r4.onFailure(r3)     // Catch:{ all -> 0x0053 }
            monitor-exit(r2)
            return
        L_0x0048:
            r2.mCaptureInProgress = r4     // Catch:{ all -> 0x0053 }
            java.lang.String r4 = r0.getPath()     // Catch:{ all -> 0x0053 }
            r3.captureHeap(r4)     // Catch:{ all -> 0x0053 }
        L_0x0051:
            monitor-exit(r2)
            return
        L_0x0053:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.devsupport.JSCHeapCapture.captureHeap(java.lang.String, com.facebook.react.devsupport.JSCHeapCapture$CaptureCallback):void");
    }

    public synchronized void captureComplete(String str, String str2) {
        CaptureCallback captureCallback = this.mCaptureInProgress;
        if (captureCallback != null) {
            if (str2 == null) {
                captureCallback.onSuccess(new File(str));
            } else {
                captureCallback.onFailure(new CaptureException(str2));
            }
            this.mCaptureInProgress = null;
        }
    }
}
