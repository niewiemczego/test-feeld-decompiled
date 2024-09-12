package com.airbnb.android.react.lottie;

import android.animation.Animator;
import android.content.Context;
import android.content.ContextWrapper;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.RenderMode;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Map;
import java.util.WeakHashMap;

class LottieAnimationViewManager extends SimpleViewManager<LottieAnimationView> {
    private static final int COMMAND_PAUSE = 3;
    private static final int COMMAND_PLAY = 1;
    private static final int COMMAND_RESET = 2;
    private static final int COMMAND_RESUME = 4;
    private static final String REACT_CLASS = "LottieAnimationView";
    private static final String TAG = "LottieAnimationViewManager";
    private static final int VERSION = 1;
    private Map<LottieAnimationView, LottieAnimationViewPropertyManager> propManagersMap = new WeakHashMap();

    public String getName() {
        return REACT_CLASS;
    }

    LottieAnimationViewManager() {
    }

    public Map<String, Object> getExportedViewConstants() {
        return MapBuilder.builder().put("VERSION", 1).build();
    }

    public LottieAnimationView createViewInstance(ThemedReactContext themedReactContext) {
        final LottieAnimationView lottieAnimationView = new LottieAnimationView(themedReactContext);
        lottieAnimationView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
        lottieAnimationView.addAnimatorListener(new Animator.AnimatorListener() {
            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
            }

            public void onAnimationEnd(Animator animator) {
                LottieAnimationViewManager.this.sendOnAnimationFinishEvent(lottieAnimationView, false);
            }

            public void onAnimationCancel(Animator animator) {
                LottieAnimationViewManager.this.sendOnAnimationFinishEvent(lottieAnimationView, true);
            }
        });
        return lottieAnimationView;
    }

    /* access modifiers changed from: private */
    public void sendOnAnimationFinishEvent(LottieAnimationView lottieAnimationView, boolean z) {
        ReactContext reactContext;
        WritableMap createMap = Arguments.createMap();
        createMap.putBoolean("isCancelled", z);
        Context context = lottieAnimationView.getContext();
        while (true) {
            if (!(context instanceof ContextWrapper)) {
                reactContext = null;
                break;
            } else if (context instanceof ReactContext) {
                reactContext = (ReactContext) context;
                break;
            } else {
                context = ((ContextWrapper) context).getBaseContext();
            }
        }
        if (reactContext != null) {
            ((RCTEventEmitter) reactContext.getJSModule(RCTEventEmitter.class)).receiveEvent(lottieAnimationView.getId(), "animationFinish", createMap);
        }
    }

    public Map getExportedCustomBubblingEventTypeConstants() {
        return MapBuilder.builder().put("animationFinish", MapBuilder.of("phasedRegistrationNames", MapBuilder.of("bubbled", "onAnimationFinish"))).build();
    }

    public Map<String, Integer> getCommandsMap() {
        return MapBuilder.of("play", 1, "reset", 2, "pause", 3, "resume", 4);
    }

    public void receiveCommand(final LottieAnimationView lottieAnimationView, int i, final ReadableArray readableArray) {
        if (i == 1) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    int i = readableArray.getInt(0);
                    int i2 = readableArray.getInt(1);
                    if (!(i == -1 || i2 == -1)) {
                        if (i > i2) {
                            lottieAnimationView.setMinAndMaxFrame(i2, i);
                            if (lottieAnimationView.getSpeed() > 0.0f) {
                                lottieAnimationView.reverseAnimationSpeed();
                            }
                        } else {
                            lottieAnimationView.setMinAndMaxFrame(i, i2);
                            if (lottieAnimationView.getSpeed() < 0.0f) {
                                lottieAnimationView.reverseAnimationSpeed();
                            }
                        }
                    }
                    if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
                        lottieAnimationView.setProgress(0.0f);
                        lottieAnimationView.playAnimation();
                        return;
                    }
                    lottieAnimationView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
                        public void onViewAttachedToWindow(View view) {
                            LottieAnimationView lottieAnimationView = (LottieAnimationView) view;
                            lottieAnimationView.setProgress(0.0f);
                            lottieAnimationView.playAnimation();
                            lottieAnimationView.removeOnAttachStateChangeListener(this);
                        }

                        public void onViewDetachedFromWindow(View view) {
                            lottieAnimationView.removeOnAttachStateChangeListener(this);
                        }
                    });
                }
            });
        } else if (i == 2) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
                        lottieAnimationView.cancelAnimation();
                        lottieAnimationView.setProgress(0.0f);
                    }
                }
            });
        } else if (i == 3) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
                        lottieAnimationView.pauseAnimation();
                    }
                }
            });
        } else if (i == 4) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (ViewCompat.isAttachedToWindow(lottieAnimationView)) {
                        lottieAnimationView.resumeAnimation();
                    }
                }
            });
        }
    }

    @ReactProp(name = "sourceName")
    public void setSourceName(LottieAnimationView lottieAnimationView, String str) {
        if (!str.contains(".")) {
            str = str + ".json";
        }
        getOrCreatePropertyManager(lottieAnimationView).setAnimationName(str);
    }

    @ReactProp(name = "sourceJson")
    public void setSourceJson(LottieAnimationView lottieAnimationView, String str) {
        getOrCreatePropertyManager(lottieAnimationView).setAnimationJson(str);
    }

    @ReactProp(name = "sourceURL")
    public void setSourceURL(final LottieAnimationView lottieAnimationView, final String str) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new URL(str).openStream()));
                    final String str = "";
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            str = str + readLine;
                        } else {
                            bufferedReader.close();
                            new Handler(Looper.getMainLooper()).post(new Runnable() {
                                public void run() {
                                    LottieAnimationViewManager.this.getOrCreatePropertyManager(lottieAnimationView).setAnimationJson(str);
                                    LottieAnimationViewManager.this.getOrCreatePropertyManager(lottieAnimationView).commitChanges();
                                }
                            });
                            return;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error loading animation from URL: " + e);
                }
            }
        }).start();
    }

    @ReactProp(name = "cacheComposition")
    public void setCacheComposition(LottieAnimationView lottieAnimationView, boolean z) {
        lottieAnimationView.setCacheComposition(z);
    }

    @ReactProp(name = "resizeMode")
    public void setResizeMode(LottieAnimationView lottieAnimationView, String str) {
        ImageView.ScaleType scaleType;
        if ("cover".equals(str)) {
            scaleType = ImageView.ScaleType.CENTER_CROP;
        } else if ("contain".equals(str)) {
            scaleType = ImageView.ScaleType.CENTER_INSIDE;
        } else {
            scaleType = TtmlNode.CENTER.equals(str) ? ImageView.ScaleType.CENTER : null;
        }
        getOrCreatePropertyManager(lottieAnimationView).setScaleType(scaleType);
    }

    @ReactProp(name = "renderMode")
    public void setRenderMode(LottieAnimationView lottieAnimationView, String str) {
        RenderMode renderMode;
        if ("AUTOMATIC".equals(str)) {
            renderMode = RenderMode.AUTOMATIC;
        } else if ("HARDWARE".equals(str)) {
            renderMode = RenderMode.HARDWARE;
        } else {
            renderMode = "SOFTWARE".equals(str) ? RenderMode.SOFTWARE : null;
        }
        getOrCreatePropertyManager(lottieAnimationView).setRenderMode(renderMode);
    }

    @ReactProp(name = "progress")
    public void setProgress(LottieAnimationView lottieAnimationView, float f) {
        getOrCreatePropertyManager(lottieAnimationView).setProgress(Float.valueOf(f));
    }

    @ReactProp(name = "speed")
    public void setSpeed(LottieAnimationView lottieAnimationView, double d) {
        getOrCreatePropertyManager(lottieAnimationView).setSpeed((float) d);
    }

    @ReactProp(name = "loop")
    public void setLoop(LottieAnimationView lottieAnimationView, boolean z) {
        getOrCreatePropertyManager(lottieAnimationView).setLoop(z);
    }

    @ReactProp(name = "imageAssetsFolder")
    public void setImageAssetsFolder(LottieAnimationView lottieAnimationView, String str) {
        getOrCreatePropertyManager(lottieAnimationView).setImageAssetsFolder(str);
    }

    @ReactProp(name = "enableMergePathsAndroidForKitKatAndAbove")
    public void setEnableMergePaths(LottieAnimationView lottieAnimationView, boolean z) {
        getOrCreatePropertyManager(lottieAnimationView).setEnableMergePaths(z);
    }

    @ReactProp(name = "colorFilters")
    public void setColorFilters(LottieAnimationView lottieAnimationView, ReadableArray readableArray) {
        getOrCreatePropertyManager(lottieAnimationView).setColorFilters(readableArray);
    }

    @ReactProp(name = "textFiltersAndroid")
    public void setTextFilters(LottieAnimationView lottieAnimationView, ReadableArray readableArray) {
        getOrCreatePropertyManager(lottieAnimationView).setTextFilters(readableArray);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(LottieAnimationView lottieAnimationView) {
        super.onAfterUpdateTransaction(lottieAnimationView);
        getOrCreatePropertyManager(lottieAnimationView).commitChanges();
    }

    /* access modifiers changed from: private */
    public LottieAnimationViewPropertyManager getOrCreatePropertyManager(LottieAnimationView lottieAnimationView) {
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager = this.propManagersMap.get(lottieAnimationView);
        if (lottieAnimationViewPropertyManager != null) {
            return lottieAnimationViewPropertyManager;
        }
        LottieAnimationViewPropertyManager lottieAnimationViewPropertyManager2 = new LottieAnimationViewPropertyManager(lottieAnimationView);
        this.propManagersMap.put(lottieAnimationView, lottieAnimationViewPropertyManager2);
        return lottieAnimationViewPropertyManager2;
    }
}
