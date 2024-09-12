package com.swmansion.rnscreens;

import android.app.Activity;
import com.facebook.react.bridge.ReactContext;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H&J\b\u0010\u0011\u001a\u00020\u000fH&J\b\u0010\u0012\u001a\u00020\u000fH&J\b\u0010\u0013\u001a\u00020\u000fH&J\u0010\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0005H&J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0016H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0018H&R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\tX¦\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lcom/swmansion/rnscreens/ScreenFragmentWrapper;", "Lcom/swmansion/rnscreens/FragmentHolder;", "Lcom/swmansion/rnscreens/ScreenEventDispatcher;", "childScreenContainers", "", "Lcom/swmansion/rnscreens/ScreenContainer;", "getChildScreenContainers", "()Ljava/util/List;", "screen", "Lcom/swmansion/rnscreens/Screen;", "getScreen", "()Lcom/swmansion/rnscreens/Screen;", "setScreen", "(Lcom/swmansion/rnscreens/Screen;)V", "addChildScreenContainer", "", "container", "onContainerUpdate", "onViewAnimationEnd", "onViewAnimationStart", "removeChildScreenContainer", "tryGetActivity", "Landroid/app/Activity;", "tryGetContext", "Lcom/facebook/react/bridge/ReactContext;", "react-native-screens_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ScreenFragmentWrapper.kt */
public interface ScreenFragmentWrapper extends FragmentHolder, ScreenEventDispatcher {
    void addChildScreenContainer(ScreenContainer screenContainer);

    List<ScreenContainer> getChildScreenContainers();

    Screen getScreen();

    void onContainerUpdate();

    void onViewAnimationEnd();

    void onViewAnimationStart();

    void removeChildScreenContainer(ScreenContainer screenContainer);

    void setScreen(Screen screen);

    Activity tryGetActivity();

    ReactContext tryGetContext();
}
