package com.facebook.react.uimanager;

import java.util.Collection;
import javax.annotation.Nullable;

public interface ViewManagerResolver {
    @Nullable
    ViewManager getViewManager(String str);

    Collection<String> getViewManagerNames();
}
