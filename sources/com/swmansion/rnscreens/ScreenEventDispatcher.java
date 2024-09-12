package com.swmansion.rnscreens;

import com.swmansion.rnscreens.ScreenFragment;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\b\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\nH&J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0018\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0003H&J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0011"}, d2 = {"Lcom/swmansion/rnscreens/ScreenEventDispatcher;", "", "canDispatchLifecycleEvent", "", "event", "Lcom/swmansion/rnscreens/ScreenFragment$ScreenLifecycleEvent;", "dispatchHeaderBackButtonClickedEvent", "", "dispatchLifecycleEvent", "fragmentWrapper", "Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "dispatchLifecycleEventInChildContainers", "dispatchTransitionProgressEvent", "alpha", "", "closing", "updateLastEventDispatched", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenEventDispatcher.kt */
public interface ScreenEventDispatcher {
    boolean canDispatchLifecycleEvent(ScreenFragment.ScreenLifecycleEvent screenLifecycleEvent);

    void dispatchHeaderBackButtonClickedEvent();

    void dispatchLifecycleEvent(ScreenFragment.ScreenLifecycleEvent screenLifecycleEvent, ScreenFragmentWrapper screenFragmentWrapper);

    void dispatchLifecycleEventInChildContainers(ScreenFragment.ScreenLifecycleEvent screenLifecycleEvent);

    void dispatchTransitionProgressEvent(float f, boolean z);

    void updateLastEventDispatched(ScreenFragment.ScreenLifecycleEvent screenLifecycleEvent);
}
