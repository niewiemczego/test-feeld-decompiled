package com.th3rdwave.safeareacontext;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b\u0018\u00010\u0006H\u0002J\b\u0010\t\u001a\u00020\u0007H\u0016J\u0016\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0006H\u0016¨\u0006\f"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaContextModule;", "Lcom/th3rdwave/safeareacontext/NativeSafeAreaContextSpec;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lcom/facebook/react/bridge/ReactApplicationContext;)V", "getInitialWindowMetrics", "", "", "", "getName", "getTypedExportedConstants", "Companion", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNCSafeAreaContext")
/* compiled from: SafeAreaContextModule.kt */
public final class SafeAreaContextModule extends NativeSafeAreaContextSpec {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String NAME = "RNCSafeAreaContext";

    public String getName() {
        return NAME;
    }

    public SafeAreaContextModule(ReactApplicationContext reactApplicationContext) {
        super(reactApplicationContext);
    }

    public Map<String, Object> getTypedExportedConstants() {
        return MapsKt.mapOf(TuplesKt.to("initialWindowMetrics", getInitialWindowMetrics()));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000b, code lost:
        r0 = r0.getWindow();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.Map<java.lang.String, java.lang.Object> getInitialWindowMetrics() {
        /*
            r5 = this;
            com.facebook.react.bridge.ReactApplicationContext r0 = r5.getReactApplicationContext()
            android.app.Activity r0 = r0.getCurrentActivity()
            r1 = 0
            if (r0 == 0) goto L_0x0016
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x0016
            android.view.View r0 = r0.getDecorView()
            goto L_0x0017
        L_0x0016:
            r0 = r1
        L_0x0017:
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            if (r0 == 0) goto L_0x0023
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r2 = r0.findViewById(r2)
            goto L_0x0024
        L_0x0023:
            r2 = r1
        L_0x0024:
            if (r2 != 0) goto L_0x0027
            return r1
        L_0x0027:
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            com.th3rdwave.safeareacontext.EdgeInsets r3 = com.th3rdwave.safeareacontext.SafeAreaUtilsKt.getSafeAreaInsets(r3)
            com.th3rdwave.safeareacontext.Rect r0 = com.th3rdwave.safeareacontext.SafeAreaUtilsKt.getFrame(r0, r2)
            if (r3 == 0) goto L_0x0059
            if (r0 != 0) goto L_0x0037
            goto L_0x0059
        L_0x0037:
            r1 = 2
            kotlin.Pair[] r1 = new kotlin.Pair[r1]
            r2 = 0
            java.util.Map r3 = com.th3rdwave.safeareacontext.SerializationUtilsKt.edgeInsetsToJavaMap(r3)
            java.lang.String r4 = "insets"
            kotlin.Pair r3 = kotlin.TuplesKt.to(r4, r3)
            r1[r2] = r3
            r2 = 1
            java.util.Map r0 = com.th3rdwave.safeareacontext.SerializationUtilsKt.rectToJavaMap(r0)
            java.lang.String r3 = "frame"
            kotlin.Pair r0 = kotlin.TuplesKt.to(r3, r0)
            r1[r2] = r0
            java.util.Map r1 = kotlin.collections.MapsKt.mapOf(r1)
            goto L_0x005c
        L_0x0059:
            r0 = r1
            java.util.Map r0 = (java.util.Map) r0
        L_0x005c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.th3rdwave.safeareacontext.SafeAreaContextModule.getInitialWindowMetrics():java.util.Map");
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/th3rdwave/safeareacontext/SafeAreaContextModule$Companion;", "", "()V", "NAME", "", "react-native-safe-area-context_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: SafeAreaContextModule.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
