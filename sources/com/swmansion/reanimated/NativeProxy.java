package com.swmansion.reanimated;

import com.facebook.jni.HybridData;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.swmansion.reanimated.layoutReanimation.LayoutAnimations;
import com.swmansion.reanimated.layoutReanimation.NativeMethodsHolder;
import com.swmansion.reanimated.nativeProxy.NativeProxyCommon;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public class NativeProxy extends NativeProxyCommon {
    private final HybridData mHybridData;

    private native HybridData initHybrid(long j, CallInvokerHolderImpl callInvokerHolderImpl, AndroidUIScheduler androidUIScheduler, LayoutAnimations layoutAnimations, MessageQueueThread messageQueueThread, String str);

    public native boolean isAnyHandlerWaitingForEvent(String str, int i);

    public native void performOperations();

    public NativeProxy(ReactApplicationContext reactApplicationContext, String str) {
        super(reactApplicationContext);
        LayoutAnimations layoutAnimations = new LayoutAnimations(reactApplicationContext);
        ReanimatedMessageQueueThread reanimatedMessageQueueThread = new ReanimatedMessageQueueThread();
        this.mHybridData = initHybrid(reactApplicationContext.getJavaScriptContextHolder().get(), (CallInvokerHolderImpl) reactApplicationContext.getCatalystInstance().getJSCallInvokerHolder(), this.mAndroidUIScheduler, layoutAnimations, reanimatedMessageQueueThread, str);
        prepareLayoutAnimations(layoutAnimations);
        installJSIBindings();
    }

    /* access modifiers changed from: protected */
    public HybridData getHybridData() {
        return this.mHybridData;
    }

    public static NativeMethodsHolder createNativeMethodsHolder(LayoutAnimations layoutAnimations) {
        final WeakReference weakReference = new WeakReference(layoutAnimations);
        return new NativeMethodsHolder() {
            public void startAnimation(int i, int i2, HashMap<String, Object> hashMap) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    HashMap hashMap2 = new HashMap();
                    for (String next : hashMap.keySet()) {
                        String obj = hashMap.get(next).toString();
                        if (next.endsWith("TransformMatrix")) {
                            hashMap2.put(next, Utils.simplifyStringNumbersList(obj));
                        } else {
                            hashMap2.put(next, obj);
                        }
                    }
                    layoutAnimations.startAnimationForTag(i, i2, hashMap2);
                }
            }

            public boolean shouldAnimateExiting(int i, boolean z) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.shouldAnimateExiting(i, z);
                }
                return false;
            }

            public boolean isLayoutAnimationEnabled() {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.isLayoutAnimationEnabled();
                }
                return false;
            }

            public boolean hasAnimation(int i, int i2) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.hasAnimationForTag(i, i2);
                }
                return false;
            }

            public void clearAnimationConfig(int i) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.clearAnimationConfigForTag(i);
                }
            }

            public void cancelAnimation(int i) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.cancelAnimationForTag(i);
                }
            }

            public int findPrecedingViewTagForTransition(int i) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    return layoutAnimations.findPrecedingViewTagForTransition(i);
                }
                return -1;
            }

            public void checkDuplicateSharedTag(int i, int i2) {
                LayoutAnimations layoutAnimations = (LayoutAnimations) weakReference.get();
                if (layoutAnimations != null) {
                    layoutAnimations.checkDuplicateSharedTag(i, i2);
                }
            }
        };
    }
}
