package io.sentry.android.core;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.facebook.react.uimanager.ViewProps;
import io.sentry.Attachment;
import io.sentry.EventProcessor;
import io.sentry.Hint;
import io.sentry.ILogger;
import io.sentry.ISerializer;
import io.sentry.SentryEvent;
import io.sentry.SentryLevel;
import io.sentry.android.core.SentryAndroidOptions;
import io.sentry.android.core.internal.gestures.ViewUtils;
import io.sentry.android.core.internal.util.AndroidCurrentDateProvider;
import io.sentry.android.core.internal.util.AndroidMainThreadChecker;
import io.sentry.android.core.internal.util.ClassUtil;
import io.sentry.android.core.internal.util.Debouncer;
import io.sentry.internal.viewhierarchy.ViewHierarchyExporter;
import io.sentry.protocol.SentryTransaction;
import io.sentry.protocol.ViewHierarchy;
import io.sentry.protocol.ViewHierarchyNode;
import io.sentry.util.HintUtils;
import io.sentry.util.IntegrationUtils;
import io.sentry.util.JsonSerializationUtils;
import io.sentry.util.Objects;
import io.sentry.util.thread.IMainThreadChecker;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public final class ViewHierarchyEventProcessor implements EventProcessor {
    private static final long CAPTURE_TIMEOUT_MS = 1000;
    private static final int DEBOUNCE_MAX_EXECUTIONS = 3;
    private static final long DEBOUNCE_WAIT_TIME_MS = 2000;
    private final Debouncer debouncer = new Debouncer(AndroidCurrentDateProvider.getInstance(), 2000, 3);
    private final SentryAndroidOptions options;

    public SentryTransaction process(SentryTransaction sentryTransaction, Hint hint) {
        return sentryTransaction;
    }

    public ViewHierarchyEventProcessor(SentryAndroidOptions sentryAndroidOptions) {
        this.options = (SentryAndroidOptions) Objects.requireNonNull(sentryAndroidOptions, "SentryAndroidOptions is required");
        if (sentryAndroidOptions.isAttachViewHierarchy()) {
            IntegrationUtils.addIntegrationToSdkVersion(getClass());
        }
    }

    public SentryEvent process(SentryEvent sentryEvent, Hint hint) {
        if (!sentryEvent.isErrored()) {
            return sentryEvent;
        }
        if (!this.options.isAttachViewHierarchy()) {
            this.options.getLogger().log(SentryLevel.DEBUG, "attachViewHierarchy is disabled.", new Object[0]);
            return sentryEvent;
        } else if (HintUtils.isFromHybridSdk(hint)) {
            return sentryEvent;
        } else {
            boolean checkForDebounce = this.debouncer.checkForDebounce();
            SentryAndroidOptions.BeforeCaptureCallback beforeViewHierarchyCaptureCallback = this.options.getBeforeViewHierarchyCaptureCallback();
            if (beforeViewHierarchyCaptureCallback != null) {
                if (!beforeViewHierarchyCaptureCallback.execute(sentryEvent, hint, checkForDebounce)) {
                    return sentryEvent;
                }
            } else if (checkForDebounce) {
                return sentryEvent;
            }
            ViewHierarchy snapshotViewHierarchy = snapshotViewHierarchy(CurrentActivityHolder.getInstance().getActivity(), this.options.getViewHierarchyExporters(), this.options.getMainThreadChecker(), this.options.getLogger());
            if (snapshotViewHierarchy != null) {
                hint.setViewHierarchy(Attachment.fromViewHierarchy(snapshotViewHierarchy));
            }
            return sentryEvent;
        }
    }

    public static byte[] snapshotViewHierarchyAsData(Activity activity, IMainThreadChecker iMainThreadChecker, ISerializer iSerializer, ILogger iLogger) {
        ViewHierarchy snapshotViewHierarchy = snapshotViewHierarchy(activity, new ArrayList(0), iMainThreadChecker, iLogger);
        if (snapshotViewHierarchy == null) {
            iLogger.log(SentryLevel.ERROR, "Could not get ViewHierarchy.", new Object[0]);
            return null;
        }
        byte[] bytesFrom = JsonSerializationUtils.bytesFrom(iSerializer, iLogger, snapshotViewHierarchy);
        if (bytesFrom == null) {
            iLogger.log(SentryLevel.ERROR, "Could not serialize ViewHierarchy.", new Object[0]);
            return null;
        } else if (bytesFrom.length >= 1) {
            return bytesFrom;
        } else {
            iLogger.log(SentryLevel.ERROR, "Got empty bytes array after serializing ViewHierarchy.", new Object[0]);
            return null;
        }
    }

    public static ViewHierarchy snapshotViewHierarchy(Activity activity, ILogger iLogger) {
        return snapshotViewHierarchy(activity, new ArrayList(0), AndroidMainThreadChecker.getInstance(), iLogger);
    }

    public static ViewHierarchy snapshotViewHierarchy(Activity activity, List<ViewHierarchyExporter> list, IMainThreadChecker iMainThreadChecker, ILogger iLogger) {
        if (activity == null) {
            iLogger.log(SentryLevel.INFO, "Missing activity for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        Window window = activity.getWindow();
        if (window == null) {
            iLogger.log(SentryLevel.INFO, "Missing window for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        View peekDecorView = window.peekDecorView();
        if (peekDecorView == null) {
            iLogger.log(SentryLevel.INFO, "Missing decor view for view hierarchy snapshot.", new Object[0]);
            return null;
        }
        try {
            if (iMainThreadChecker.isMainThread()) {
                return snapshotViewHierarchy(peekDecorView, list);
            }
            CountDownLatch countDownLatch = new CountDownLatch(1);
            AtomicReference atomicReference = new AtomicReference((Object) null);
            activity.runOnUiThread(new ViewHierarchyEventProcessor$$ExternalSyntheticLambda0(atomicReference, peekDecorView, list, countDownLatch, iLogger));
            if (countDownLatch.await(1000, TimeUnit.MILLISECONDS)) {
                return (ViewHierarchy) atomicReference.get();
            }
            return null;
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Failed to process view hierarchy.", th);
        }
    }

    static /* synthetic */ void lambda$snapshotViewHierarchy$0(AtomicReference atomicReference, View view, List list, CountDownLatch countDownLatch, ILogger iLogger) {
        try {
            atomicReference.set(snapshotViewHierarchy(view, (List<ViewHierarchyExporter>) list));
            countDownLatch.countDown();
        } catch (Throwable th) {
            iLogger.log(SentryLevel.ERROR, "Failed to process view hierarchy.", th);
        }
    }

    public static ViewHierarchy snapshotViewHierarchy(View view) {
        return snapshotViewHierarchy(view, (List<ViewHierarchyExporter>) new ArrayList(0));
    }

    public static ViewHierarchy snapshotViewHierarchy(View view, List<ViewHierarchyExporter> list) {
        ArrayList arrayList = new ArrayList(1);
        ViewHierarchy viewHierarchy = new ViewHierarchy("android_view_system", arrayList);
        ViewHierarchyNode viewToNode = viewToNode(view);
        arrayList.add(viewToNode);
        addChildren(view, viewToNode, list);
        return viewHierarchy;
    }

    private static void addChildren(View view, ViewHierarchyNode viewHierarchyNode, List<ViewHierarchyExporter> list) {
        if (view instanceof ViewGroup) {
            for (ViewHierarchyExporter export : list) {
                if (export.export(viewHierarchyNode, view)) {
                    return;
                }
            }
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            if (childCount != 0) {
                ArrayList arrayList = new ArrayList(childCount);
                for (int i = 0; i < childCount; i++) {
                    View childAt = viewGroup.getChildAt(i);
                    if (childAt != null) {
                        ViewHierarchyNode viewToNode = viewToNode(childAt);
                        arrayList.add(viewToNode);
                        addChildren(childAt, viewToNode, list);
                    }
                }
                viewHierarchyNode.setChildren(arrayList);
            }
        }
    }

    private static ViewHierarchyNode viewToNode(View view) {
        ViewHierarchyNode viewHierarchyNode = new ViewHierarchyNode();
        viewHierarchyNode.setType(ClassUtil.getClassName(view));
        try {
            viewHierarchyNode.setIdentifier(ViewUtils.getResourceId(view));
        } catch (Throwable unused) {
        }
        viewHierarchyNode.setX(Double.valueOf((double) view.getX()));
        viewHierarchyNode.setY(Double.valueOf((double) view.getY()));
        viewHierarchyNode.setWidth(Double.valueOf((double) view.getWidth()));
        viewHierarchyNode.setHeight(Double.valueOf((double) view.getHeight()));
        viewHierarchyNode.setAlpha(Double.valueOf((double) view.getAlpha()));
        int visibility = view.getVisibility();
        if (visibility == 0) {
            viewHierarchyNode.setVisibility(ViewProps.VISIBLE);
        } else if (visibility == 4) {
            viewHierarchyNode.setVisibility("invisible");
        } else if (visibility == 8) {
            viewHierarchyNode.setVisibility("gone");
        }
        return viewHierarchyNode;
    }
}
