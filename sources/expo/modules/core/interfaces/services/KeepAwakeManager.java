package expo.modules.core.interfaces.services;

import expo.modules.core.errors.CurrentActivityNotFoundException;

public interface KeepAwakeManager {
    void activate(String str, Runnable runnable) throws CurrentActivityNotFoundException;

    void deactivate(String str, Runnable runnable) throws CurrentActivityNotFoundException;

    boolean isActivated();
}
