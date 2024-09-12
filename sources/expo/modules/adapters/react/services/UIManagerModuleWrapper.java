package expo.modules.adapters.react.services;

import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.NativeViewHierarchyManager;
import com.facebook.react.uimanager.UIBlock;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.UIManagerModule;
import expo.modules.core.interfaces.ActivityEventListener;
import expo.modules.core.interfaces.ActivityProvider;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.interfaces.JavaScriptContextProvider;
import expo.modules.core.interfaces.LifecycleEventListener;
import expo.modules.core.interfaces.services.UIManager;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

public class UIManagerModuleWrapper implements ActivityProvider, InternalModule, JavaScriptContextProvider, UIManager {
    private Map<ActivityEventListener, com.facebook.react.bridge.ActivityEventListener> mActivityEventListenersMap = new WeakHashMap();
    private Map<LifecycleEventListener, com.facebook.react.bridge.LifecycleEventListener> mLifecycleListenersMap = new WeakHashMap();
    private ReactContext mReactContext;

    public UIManagerModuleWrapper(ReactContext reactContext) {
        this.mReactContext = reactContext;
    }

    /* access modifiers changed from: protected */
    public ReactContext getContext() {
        return this.mReactContext;
    }

    public List<Class> getExportedInterfaces() {
        return Arrays.asList(new Class[]{ActivityProvider.class, JavaScriptContextProvider.class, UIManager.class});
    }

    public <T> void addUIBlock(final int i, final UIManager.UIBlock<T> uIBlock, final Class<T> cls) {
        ((UIManagerModule) getContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(NativeViewHierarchyManager nativeViewHierarchyManager) {
                View resolveView = nativeViewHierarchyManager.resolveView(i);
                if (resolveView == null) {
                    uIBlock.reject(new IllegalArgumentException("Expected view for this tag not to be null."));
                    return;
                }
                try {
                    if (cls.isInstance(resolveView)) {
                        uIBlock.resolve(cls.cast(resolveView));
                    } else {
                        uIBlock.reject(new IllegalStateException("Expected view to be of " + cls + "; found " + resolveView.getClass() + " instead"));
                    }
                } catch (Exception e) {
                    uIBlock.reject(e);
                }
            }
        });
    }

    public void addUIBlock(final UIManager.GroupUIBlock groupUIBlock) {
        ((UIManagerModule) getContext().getNativeModule(UIManagerModule.class)).addUIBlock(new UIBlock() {
            public void execute(final NativeViewHierarchyManager nativeViewHierarchyManager) {
                groupUIBlock.execute(new UIManager.ViewHolder() {
                    public View get(Object obj) {
                        if (obj instanceof Number) {
                            try {
                                return nativeViewHierarchyManager.resolveView(((Number) obj).intValue());
                            } catch (IllegalViewOperationException unused) {
                                return null;
                            }
                        } else {
                            Log.w("E_INVALID_TAG", "Provided tag is of class " + obj.getClass() + " whereas React expects tags to be integers. Are you sure you're providing proper argument to addUIBlock?");
                            return null;
                        }
                    }
                });
            }
        });
    }

    public View resolveView(int i) {
        com.facebook.react.bridge.UIManager uIManagerForReactTag = UIManagerHelper.getUIManagerForReactTag(getContext(), i);
        if (uIManagerForReactTag == null) {
            return null;
        }
        return uIManagerForReactTag.resolveView(i);
    }

    public void runOnUiQueueThread(Runnable runnable) {
        if (getContext().isOnUiQueueThread()) {
            runnable.run();
        } else {
            getContext().runOnUiQueueThread(runnable);
        }
    }

    public void runOnClientCodeQueueThread(Runnable runnable) {
        if (getContext().isOnJSQueueThread()) {
            runnable.run();
        } else {
            getContext().runOnJSQueueThread(runnable);
        }
    }

    public void runOnNativeModulesQueueThread(Runnable runnable) {
        if (this.mReactContext.isOnNativeModulesQueueThread()) {
            runnable.run();
        } else {
            this.mReactContext.runOnNativeModulesQueueThread(runnable);
        }
    }

    public void registerLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        final WeakReference weakReference = new WeakReference(lifecycleEventListener);
        this.mLifecycleListenersMap.put(lifecycleEventListener, new com.facebook.react.bridge.LifecycleEventListener() {
            public void onHostResume() {
                LifecycleEventListener lifecycleEventListener = (LifecycleEventListener) weakReference.get();
                if (lifecycleEventListener != null) {
                    lifecycleEventListener.onHostResume();
                }
            }

            public void onHostPause() {
                LifecycleEventListener lifecycleEventListener = (LifecycleEventListener) weakReference.get();
                if (lifecycleEventListener != null) {
                    lifecycleEventListener.onHostPause();
                }
            }

            public void onHostDestroy() {
                LifecycleEventListener lifecycleEventListener = (LifecycleEventListener) weakReference.get();
                if (lifecycleEventListener != null) {
                    lifecycleEventListener.onHostDestroy();
                }
            }
        });
        this.mReactContext.addLifecycleEventListener(this.mLifecycleListenersMap.get(lifecycleEventListener));
    }

    public void unregisterLifecycleEventListener(LifecycleEventListener lifecycleEventListener) {
        getContext().removeLifecycleEventListener(this.mLifecycleListenersMap.get(lifecycleEventListener));
        this.mLifecycleListenersMap.remove(lifecycleEventListener);
    }

    public void registerActivityEventListener(ActivityEventListener activityEventListener) {
        final WeakReference weakReference = new WeakReference(activityEventListener);
        this.mActivityEventListenersMap.put(activityEventListener, new com.facebook.react.bridge.ActivityEventListener() {
            public void onActivityResult(Activity activity, int i, int i2, Intent intent) {
                ActivityEventListener activityEventListener = (ActivityEventListener) weakReference.get();
                if (activityEventListener != null) {
                    activityEventListener.onActivityResult(activity, i, i2, intent);
                }
            }

            public void onNewIntent(Intent intent) {
                ActivityEventListener activityEventListener = (ActivityEventListener) weakReference.get();
                if (activityEventListener != null) {
                    activityEventListener.onNewIntent(intent);
                }
            }
        });
        this.mReactContext.addActivityEventListener(this.mActivityEventListenersMap.get(activityEventListener));
    }

    public void unregisterActivityEventListener(ActivityEventListener activityEventListener) {
        getContext().removeActivityEventListener(this.mActivityEventListenersMap.get(activityEventListener));
        this.mActivityEventListenersMap.remove(activityEventListener);
    }

    public long getJavaScriptContextRef() {
        return this.mReactContext.getJavaScriptContextHolder().get();
    }

    public CallInvokerHolderImpl getJSCallInvokerHolder() {
        return (CallInvokerHolderImpl) this.mReactContext.getCatalystInstance().getJSCallInvokerHolder();
    }

    public Activity getCurrentActivity() {
        return getContext().getCurrentActivity();
    }
}
