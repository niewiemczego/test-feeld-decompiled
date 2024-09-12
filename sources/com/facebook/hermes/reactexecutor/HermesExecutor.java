package com.facebook.hermes.reactexecutor;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.soloader.SoLoader;

public class HermesExecutor extends JavaScriptExecutor {
    private static String mode_;

    public static native boolean canLoadFile(String str);

    private static native HybridData initHybrid(boolean z, String str, long j);

    private static native HybridData initHybridDefaultConfig(boolean z, String str);

    static {
        loadLibrary();
    }

    public static void loadLibrary() throws UnsatisfiedLinkError {
        if (mode_ == null) {
            SoLoader.loadLibrary("hermes");
            SoLoader.loadLibrary("hermes_executor");
            mode_ = "Release";
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    HermesExecutor(@javax.annotation.Nullable com.facebook.hermes.reactexecutor.RuntimeConfig r3, boolean r4, java.lang.String r5) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0007
            com.facebook.jni.HybridData r3 = initHybridDefaultConfig(r4, r5)
            goto L_0x000d
        L_0x0007:
            long r0 = r3.heapSizeMB
            com.facebook.jni.HybridData r3 = initHybrid(r4, r5, r0)
        L_0x000d:
            r2.<init>(r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.hermes.reactexecutor.HermesExecutor.<init>(com.facebook.hermes.reactexecutor.RuntimeConfig, boolean, java.lang.String):void");
    }

    public String getName() {
        return "HermesExecutor" + mode_;
    }
}
