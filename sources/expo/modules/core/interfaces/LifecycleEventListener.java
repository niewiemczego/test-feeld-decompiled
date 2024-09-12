package expo.modules.core.interfaces;

public interface LifecycleEventListener {
    void onHostDestroy();

    void onHostPause();

    void onHostResume();
}
