package io.sentry.react;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.EventDispatcherListener;
import io.sentry.ILogger;
import io.sentry.SentryLevel;
import io.sentry.android.core.BuildInfoProvider;
import io.sentry.android.core.internal.util.FirstDrawDoneListener;

public class RNSentryReactFragmentLifecycleTracer extends FragmentManager.FragmentLifecycleCallbacks {
    /* access modifiers changed from: private */
    public final BuildInfoProvider buildInfoProvider;
    private final Runnable emitNewFrameEvent;
    private final ILogger logger;

    public RNSentryReactFragmentLifecycleTracer(BuildInfoProvider buildInfoProvider2, Runnable runnable, ILogger iLogger) {
        this.buildInfoProvider = buildInfoProvider2;
        this.emitNewFrameEvent = runnable;
        this.logger = iLogger;
    }

    public void onFragmentViewCreated(FragmentManager fragmentManager, Fragment fragment, final View view, Bundle bundle) {
        if (!"com.swmansion.rnscreens.ScreenStackFragment".equals(fragment.getClass().getCanonicalName())) {
            this.logger.log(SentryLevel.DEBUG, "Fragment is not a ScreenStackFragment, won't listen for the first draw.", new Object[0]);
        } else if (!(view instanceof ViewGroup)) {
            this.logger.log(SentryLevel.WARNING, "Fragment view is not a ViewGroup, won't listen for the first draw.", new Object[0]);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            if (viewGroup.getChildCount() == 0) {
                this.logger.log(SentryLevel.WARNING, "Fragment view has no children, won't listen for the first draw.", new Object[0]);
                return;
            }
            View childAt = viewGroup.getChildAt(0);
            if (childAt == null || !(childAt.getContext() instanceof ReactContext)) {
                this.logger.log(SentryLevel.WARNING, "Fragment view has no ReactContext, won't listen for the first draw.", new Object[0]);
                return;
            }
            int id = childAt.getId();
            if (id == -1) {
                this.logger.log(SentryLevel.WARNING, "Screen has no id, won't listen for the first draw.", new Object[0]);
                return;
            }
            final EventDispatcher eventDispatcherForReactTag = getEventDispatcherForReactTag(childAt, id);
            if (eventDispatcherForReactTag == null) {
                this.logger.log(SentryLevel.WARNING, "Screen has no event dispatcher, won't listen for the first draw.", new Object[0]);
                return;
            }
            final Runnable runnable = this.emitNewFrameEvent;
            eventDispatcherForReactTag.addListener(new EventDispatcherListener() {
                public void onEventDispatch(Event event) {
                    if ("com.swmansion.rnscreens.events.ScreenAppearEvent".equals(event.getClass().getCanonicalName())) {
                        eventDispatcherForReactTag.removeListener(this);
                        FirstDrawDoneListener.registerForNextDraw(view, runnable, RNSentryReactFragmentLifecycleTracer.this.buildInfoProvider);
                    }
                }
            });
        }
    }

    private static EventDispatcher getEventDispatcherForReactTag(View view, int i) {
        return UIManagerHelper.getEventDispatcherForReactTag(UIManagerHelper.getReactContext(view), i);
    }
}
