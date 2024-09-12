package io.sentry.react;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import io.sentry.SentryDate;
import io.sentry.SentryDateProvider;
import io.sentry.android.core.AndroidLogger;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.SentryAndroidDateProvider;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;
import java.util.Map;

public class RNSentryOnDrawReporterManager extends SimpleViewManager<RNSentryOnDrawReporterView> {
    public static final String REACT_CLASS = "RNSentryOnDrawReporter";
    private final ReactApplicationContext mCallerContext;

    public String getName() {
        return REACT_CLASS;
    }

    public RNSentryOnDrawReporterManager(ReactApplicationContext reactApplicationContext) {
        this.mCallerContext = reactApplicationContext;
    }

    /* access modifiers changed from: protected */
    public RNSentryOnDrawReporterView createViewInstance(ThemedReactContext themedReactContext) {
        return new RNSentryOnDrawReporterView(this.mCallerContext, new BuildInfoProvider(new AndroidLogger()));
    }

    @ReactProp(defaultBoolean = false, name = "initialDisplay")
    public void setInitialDisplay(RNSentryOnDrawReporterView rNSentryOnDrawReporterView, boolean z) {
        rNSentryOnDrawReporterView.setInitialDisplay(z);
    }

    @ReactProp(defaultBoolean = false, name = "fullDisplay")
    public void setFullDisplay(RNSentryOnDrawReporterView rNSentryOnDrawReporterView, boolean z) {
        rNSentryOnDrawReporterView.setFullDisplay(z);
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("onDrawNextFrameView", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onDrawNextFrame"))).build();
    }

    public static class RNSentryOnDrawReporterView extends View {
        private final BuildInfoProvider buildInfo;
        private final SentryDateProvider dateProvider;
        private final Runnable emitFullDisplayEvent;
        private final Runnable emitInitialDisplayEvent;
        private final ReactApplicationContext reactContext;

        public RNSentryOnDrawReporterView(Context context) {
            super(context);
            this.dateProvider = new SentryAndroidDateProvider();
            this.reactContext = null;
            this.buildInfo = null;
            this.emitInitialDisplayEvent = null;
            this.emitFullDisplayEvent = null;
        }

        public RNSentryOnDrawReporterView(ReactApplicationContext reactApplicationContext, BuildInfoProvider buildInfoProvider) {
            super(reactApplicationContext);
            this.dateProvider = new SentryAndroidDateProvider();
            this.reactContext = reactApplicationContext;
            this.buildInfo = buildInfoProvider;
            this.emitInitialDisplayEvent = new RNSentryOnDrawReporterManager$RNSentryOnDrawReporterView$$ExternalSyntheticLambda0(this);
            this.emitFullDisplayEvent = new RNSentryOnDrawReporterManager$RNSentryOnDrawReporterView$$ExternalSyntheticLambda1(this);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$new$0$io-sentry-react-RNSentryOnDrawReporterManager$RNSentryOnDrawReporterView  reason: not valid java name */
        public /* synthetic */ void m935lambda$new$0$iosentryreactRNSentryOnDrawReporterManager$RNSentryOnDrawReporterView() {
            emitDisplayEvent("initialDisplay");
        }

        /* access modifiers changed from: package-private */
        /* renamed from: lambda$new$1$io-sentry-react-RNSentryOnDrawReporterManager$RNSentryOnDrawReporterView  reason: not valid java name */
        public /* synthetic */ void m936lambda$new$1$iosentryreactRNSentryOnDrawReporterManager$RNSentryOnDrawReporterView() {
            emitDisplayEvent("fullDisplay");
        }

        public void setFullDisplay(boolean z) {
            if (z) {
                registerForNextDraw(this.emitFullDisplayEvent);
            }
        }

        public void setInitialDisplay(boolean z) {
            if (z) {
                registerForNextDraw(this.emitInitialDisplayEvent);
            }
        }

        private void registerForNextDraw(Runnable runnable) {
            Activity currentActivity;
            BuildInfoProvider buildInfoProvider;
            ReactApplicationContext reactApplicationContext = this.reactContext;
            if (reactApplicationContext != null && (currentActivity = reactApplicationContext.getCurrentActivity()) != null && runnable != null && (buildInfoProvider = this.buildInfo) != null) {
                FirstDrawDoneListener.registerForNextDraw(currentActivity, runnable, buildInfoProvider);
            }
        }

        private void emitDisplayEvent(String str) {
            SentryDate now = this.dateProvider.now();
            WritableMap createMap = Arguments.createMap();
            createMap.putString("type", str);
            createMap.putDouble("newFrameTimestampInSeconds", ((double) now.nanoTimestamp()) / 1.0E9d);
            ReactApplicationContext reactApplicationContext = this.reactContext;
            if (reactApplicationContext != null) {
                ((RCTEventEmitter) reactApplicationContext.getJSModule(RCTEventEmitter.class)).receiveEvent(getId(), "onDrawNextFrameView", createMap);
            }
        }
    }
}
