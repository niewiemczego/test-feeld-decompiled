package com.swmansion.reanimated.layoutReanimation;

import android.app.Activity;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.facebook.react.bridge.JavaOnlyMap;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableNativeArray;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.uimanager.IViewManagerWithChildren;
import com.facebook.react.uimanager.IllegalViewOperationException;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactStylesDiffMap;
import com.facebook.react.uimanager.RootView;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.modal.ReactModalHostManager;
import com.swmansion.reanimated.AndroidUIScheduler;
import com.swmansion.reanimated.Utils;
import com.swmansion.rnscreens.ScreenStackViewManager;
import com.swmansion.rnscreens.ScreenViewManager;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

public class AnimationsManager implements ViewHierarchyObserver {
    private boolean isInvalidated;
    private HashSet<Integer> mAncestorsToRemove = new HashSet<>();
    private HashMap<Integer, Runnable> mCallbacks = new HashMap<>();
    private ReactContext mContext;
    private HashMap<Integer, Rect> mEnteringViewTargetValues = new HashMap<>();
    private HashSet<Integer> mEnteringViews = new HashSet<>();
    private HashMap<Integer, Integer> mExitingSubviewCountMap = new HashMap<>();
    private HashMap<Integer, View> mExitingViews = new HashMap<>();
    private NativeMethodsHolder mNativeMethodsHolder;
    private ReanimatedNativeHierarchyManager mReanimatedNativeHierarchyManager;
    private SharedTransitionManager mSharedTransitionManager;
    private UIManager mUIManager;
    private WeakReference<AndroidUIScheduler> mWeakAndroidUIScheduler;

    public void setReanimatedNativeHierarchyManager(ReanimatedNativeHierarchyManager reanimatedNativeHierarchyManager) {
        this.mReanimatedNativeHierarchyManager = reanimatedNativeHierarchyManager;
    }

    public ReanimatedNativeHierarchyManager getReanimatedNativeHierarchyManager() {
        return this.mReanimatedNativeHierarchyManager;
    }

    public void setAndroidUIScheduler(AndroidUIScheduler androidUIScheduler) {
        this.mWeakAndroidUIScheduler = new WeakReference<>(androidUIScheduler);
    }

    public AnimationsManager(ReactContext reactContext, UIManager uIManager) {
        this.mContext = reactContext;
        this.mUIManager = uIManager;
        this.isInvalidated = false;
        this.mSharedTransitionManager = new SharedTransitionManager(this);
    }

    public void invalidate() {
        this.isInvalidated = true;
        this.mNativeMethodsHolder = null;
        this.mContext = null;
        this.mUIManager = null;
        this.mExitingViews = null;
        this.mExitingSubviewCountMap = null;
        this.mAncestorsToRemove = null;
        this.mCallbacks = null;
    }

    public void onViewRemoval(View view, ViewGroup viewGroup, Runnable runnable) {
        if (!this.isInvalidated) {
            this.mCallbacks.put(Integer.valueOf(view.getId()), runnable);
            if (!removeOrAnimateExitRecursive(view, true, true)) {
                removeView(view, viewGroup);
            }
        }
    }

    public void onViewCreate(View view, ViewGroup viewGroup, Snapshot snapshot) {
        if (!this.isInvalidated) {
            maybeRegisterSharedView(view);
            if (hasAnimationForTag(view.getId(), 1)) {
                AndroidUIScheduler androidUIScheduler = (AndroidUIScheduler) this.mWeakAndroidUIScheduler.get();
                if (androidUIScheduler != null) {
                    androidUIScheduler.triggerUI();
                }
                int id = view.getId();
                HashMap<String, Object> targetMap = snapshot.toTargetMap();
                if (targetMap != null) {
                    this.mNativeMethodsHolder.startAnimation(id, 1, prepareDataForAnimationWorklet(targetMap, true));
                    this.mEnteringViews.add(Integer.valueOf(id));
                }
            }
        }
    }

    public void onViewUpdate(View view, Snapshot snapshot, Snapshot snapshot2) {
        if (!this.isInvalidated) {
            int id = view.getId();
            if (hasAnimationForTag(id, 3)) {
                HashMap<String, Object> currentMap = snapshot.toCurrentMap();
                HashMap<String, Object> targetMap = snapshot2.toTargetMap();
                boolean z = true;
                for (int i = 0; i < Snapshot.targetKeysToTransform.size(); i++) {
                    if (((Number) currentMap.get(Snapshot.currentKeysToTransform.get(i))).doubleValue() != ((Number) targetMap.get(Snapshot.targetKeysToTransform.get(i))).doubleValue()) {
                        z = false;
                    }
                }
                if (!z) {
                    HashMap<String, Object> prepareDataForAnimationWorklet = prepareDataForAnimationWorklet(currentMap, false);
                    HashMap hashMap = new HashMap(prepareDataForAnimationWorklet(targetMap, true));
                    for (String next : prepareDataForAnimationWorklet.keySet()) {
                        hashMap.put(next, prepareDataForAnimationWorklet.get(next));
                    }
                    this.mNativeMethodsHolder.startAnimation(id, 3, hashMap);
                }
            } else if (this.mEnteringViews.contains(Integer.valueOf(id))) {
                this.mEnteringViewTargetValues.put(Integer.valueOf(id), new Rect(snapshot2.originX, snapshot2.originY, snapshot2.originX + snapshot2.width, snapshot2.originY + snapshot2.height));
                view.layout(snapshot.originX, snapshot.originY, snapshot.originX + snapshot.width, snapshot.originY + snapshot.height);
            }
        }
    }

    public void maybeRegisterSharedView(View view) {
        if (hasAnimationForTag(view.getId(), 4)) {
            this.mSharedTransitionManager.notifyAboutNewView(view);
        }
    }

    private void checkDuplicateSharedTag(View view) {
        int id = view.getId();
        ViewParent parent = view.getParent();
        while (parent != null && !parent.getClass().getSimpleName().equals("Screen")) {
            parent = parent.getParent();
        }
        if (parent != null) {
            this.mNativeMethodsHolder.checkDuplicateSharedTag(id, ((View) parent).getId());
        }
    }

    public void progressLayoutAnimation(int i, Map<String, Object> map, boolean z) {
        ViewGroup viewGroup;
        View resolveView = resolveView(i);
        if (resolveView != null && (viewGroup = (ViewGroup) resolveView.getParent()) != null) {
            ViewManager resolveViewManager = resolveViewManager(i);
            ViewManager resolveViewManager2 = resolveViewManager(viewGroup.getId());
            if (resolveViewManager != null) {
                setNewProps(map, resolveView, resolveViewManager, resolveViewManager2, Integer.valueOf(viewGroup.getId()), z);
            }
        }
    }

    public void endLayoutAnimation(int i, boolean z) {
        View resolveView = resolveView(i);
        if (resolveView != null) {
            Rect rect = this.mEnteringViewTargetValues.get(Integer.valueOf(i));
            if (!z && this.mEnteringViews.contains(Integer.valueOf(i)) && rect != null) {
                resolveView.layout(rect.left, rect.top, rect.right, rect.bottom);
            }
            this.mEnteringViews.remove(Integer.valueOf(i));
            this.mEnteringViewTargetValues.remove(Integer.valueOf(i));
            if (z) {
                if ((resolveView instanceof ViewGroup) && this.mAncestorsToRemove.contains(Integer.valueOf(i))) {
                    cancelAnimationsInSubviews((ViewGroup) resolveView);
                }
                this.mExitingViews.remove(Integer.valueOf(i));
                maybeDropAncestors(resolveView);
                removeView(resolveView, (ViewGroup) resolveView.getParent());
            }
            this.mSharedTransitionManager.finishSharedAnimation(i);
        }
    }

    public void printSubTree(View view, int i) {
        if (i == 0) {
            Log.v("rea", "----------------------");
        }
        if (view != null) {
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (int i3 = 0; i3 < i; i3++) {
                sb.append("+");
            }
            sb.append(" TAG:");
            sb.append(view.getId());
            sb.append(" CLASS:");
            sb.append(view.getClass().getSimpleName());
            Log.v("rea", sb.toString());
            if (view instanceof ViewGroup) {
                while (true) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    if (i2 < viewGroup.getChildCount()) {
                        printSubTree(viewGroup.getChildAt(i2), i + 1);
                        i2++;
                    } else {
                        return;
                    }
                }
            }
        }
    }

    public HashMap<String, Object> prepareDataForAnimationWorklet(HashMap<String, Object> hashMap, boolean z) {
        return prepareDataForAnimationWorklet(hashMap, z, false);
    }

    public HashMap<String, Object> prepareDataForAnimationWorklet(HashMap<String, Object> hashMap, boolean z, boolean z2) {
        ArrayList<String> arrayList;
        HashMap<String, Object> hashMap2 = new HashMap<>();
        if (z) {
            arrayList = Snapshot.targetKeysToTransform;
        } else {
            arrayList = Snapshot.currentKeysToTransform;
        }
        Iterator<String> it = arrayList.iterator();
        while (it.hasNext()) {
            String next = it.next();
            hashMap2.put(next, Float.valueOf(PixelUtil.toDIPFromPixel(Utils.convertToFloat(hashMap.get(next)))));
        }
        if (z2) {
            String str = z ? Snapshot.TARGET_TRANSFORM_MATRIX : Snapshot.CURRENT_TRANSFORM_MATRIX;
            hashMap2.put(str, hashMap.get(str));
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        Activity currentActivity = this.mContext.getCurrentActivity();
        if (currentActivity != null) {
            currentActivity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            int i = displayMetrics.heightPixels;
            hashMap2.put("windowWidth", Float.valueOf(PixelUtil.toDIPFromPixel((float) displayMetrics.widthPixels)));
            hashMap2.put("windowHeight", Float.valueOf(PixelUtil.toDIPFromPixel((float) i)));
        } else {
            hashMap2.put("windowWidth", Float.valueOf(PixelUtil.toDIPFromPixel(0.0f)));
            hashMap2.put("windowHeight", Float.valueOf(PixelUtil.toDIPFromPixel(0.0f)));
        }
        return hashMap2;
    }

    public void setNativeMethods(NativeMethodsHolder nativeMethodsHolder) {
        this.mNativeMethodsHolder = nativeMethodsHolder;
        this.mSharedTransitionManager.setNativeMethods(nativeMethodsHolder);
    }

    public void setNewProps(Map<String, Object> map, View view, ViewManager viewManager, ViewManager viewManager2, Integer num, boolean z) {
        float f;
        float f2;
        float f3;
        float f4;
        Map<String, Object> map2 = map;
        View view2 = view;
        if (map2.get(Snapshot.ORIGIN_X) != null) {
            f = ((Double) map2.get(Snapshot.ORIGIN_X)).floatValue();
        } else {
            f = PixelUtil.toDIPFromPixel((float) view.getLeft());
        }
        float f5 = f;
        if (map2.get(Snapshot.ORIGIN_Y) != null) {
            f2 = ((Double) map2.get(Snapshot.ORIGIN_Y)).floatValue();
        } else {
            f2 = PixelUtil.toDIPFromPixel((float) view.getTop());
        }
        float f6 = f2;
        if (map2.get("width") != null) {
            f3 = ((Double) map2.get("width")).floatValue();
        } else {
            f3 = PixelUtil.toDIPFromPixel((float) view.getWidth());
        }
        float f7 = f3;
        if (map2.get("height") != null) {
            f4 = ((Double) map2.get("height")).floatValue();
        } else {
            f4 = PixelUtil.toDIPFromPixel((float) view.getHeight());
        }
        float f8 = f4;
        if (map2.containsKey(Snapshot.TRANSFORM_MATRIX)) {
            float[] fArr = new float[9];
            if (map2.get(Snapshot.TRANSFORM_MATRIX) instanceof ReadableNativeArray) {
                ReadableNativeArray readableNativeArray = (ReadableNativeArray) map2.get(Snapshot.TRANSFORM_MATRIX);
                for (int i = 0; i < 9; i++) {
                    fArr[i] = Double.valueOf(readableNativeArray.getDouble(i)).floatValue();
                }
            } else {
                ArrayList arrayList = (ArrayList) map2.get(Snapshot.TRANSFORM_MATRIX);
                for (int i2 = 0; i2 < 9; i2++) {
                    fArr[i2] = ((Float) arrayList.get(i2)).floatValue();
                }
            }
            view2.setScaleX(fArr[0]);
            view2.setScaleY(fArr[4]);
            map2.remove(Snapshot.TRANSFORM_MATRIX);
        }
        updateLayout(view, viewManager2, num.intValue(), f5, f6, f7, f8, z);
        map2.remove(Snapshot.ORIGIN_X);
        map2.remove(Snapshot.ORIGIN_Y);
        map2.remove(Snapshot.GLOBAL_ORIGIN_X);
        map2.remove(Snapshot.GLOBAL_ORIGIN_Y);
        map2.remove("width");
        map2.remove("height");
        if (map.size() != 0) {
            JavaOnlyMap javaOnlyMap = new JavaOnlyMap();
            for (String next : map.keySet()) {
                addProp(javaOnlyMap, next, map2.get(next));
            }
            viewManager.updateProperties(view2, new ReactStylesDiffMap(javaOnlyMap));
        }
    }

    private static void addProp(WritableMap writableMap, String str, Object obj) {
        if (obj == null) {
            writableMap.putNull(str);
        } else if (obj instanceof Double) {
            writableMap.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Integer) {
            writableMap.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Number) {
            writableMap.putDouble(str, ((Number) obj).doubleValue());
        } else if (obj instanceof Boolean) {
            writableMap.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof String) {
            writableMap.putString(str, (String) obj);
        } else if (obj instanceof ReadableArray) {
            writableMap.putArray(str, (ReadableArray) obj);
        } else if (obj instanceof ReadableMap) {
            writableMap.putMap(str, (ReadableMap) obj);
        } else {
            throw new IllegalStateException("[Reanimated] Unknown type of animated value for Layout Animations.");
        }
    }

    public void updateLayout(View view, ViewManager viewManager, int i, float f, float f2, float f3, float f4, boolean z) {
        int round = Math.round(PixelUtil.toPixelFromDIP(f));
        int round2 = Math.round(PixelUtil.toPixelFromDIP(f2));
        int round3 = Math.round(PixelUtil.toPixelFromDIP(f3));
        int round4 = Math.round(PixelUtil.toPixelFromDIP(f4));
        view.measure(View.MeasureSpec.makeMeasureSpec(round3, 1073741824), View.MeasureSpec.makeMeasureSpec(round4, 1073741824));
        ViewParent parent = view.getParent();
        if (parent instanceof RootView) {
            parent.requestLayout();
        }
        if (i % 10 != 1 || viewManager == null) {
            if (z) {
                Point convertScreenLocationToViewCoordinates = convertScreenLocationToViewCoordinates(new Point(round, round2), (View) view.getParent());
                round = convertScreenLocationToViewCoordinates.x;
                round2 = convertScreenLocationToViewCoordinates.y;
            }
            view.layout(round, round2, round3 + round, round4 + round2);
        } else if (!(viewManager instanceof IViewManagerWithChildren)) {
            throw new IllegalViewOperationException("[Reanimated] Trying to use view with tag " + i + " as a parent, but its Manager doesn't implement IViewManagerWithChildren.");
        } else if (!((IViewManagerWithChildren) viewManager).needsCustomLayoutForChildren()) {
            view.layout(round, round2, round3 + round, round4 + round2);
        }
    }

    public boolean shouldAnimateExiting(int i, boolean z) {
        return this.mNativeMethodsHolder.shouldAnimateExiting(i, z);
    }

    public boolean hasAnimationForTag(int i, int i2) {
        return this.mNativeMethodsHolder.hasAnimation(i, i2);
    }

    public boolean isLayoutAnimationEnabled() {
        NativeMethodsHolder nativeMethodsHolder = this.mNativeMethodsHolder;
        return nativeMethodsHolder != null && nativeMethodsHolder.isLayoutAnimationEnabled();
    }

    private boolean removeOrAnimateExitRecursive(View view, boolean z, boolean z2) {
        boolean z3;
        int id = view.getId();
        ViewManager resolveViewManager = resolveViewManager(id);
        if (resolveViewManager != null) {
            String name = resolveViewManager.getName();
            if (name.equals(ReactModalHostManager.REACT_CLASS) || name.equals(ScreenViewManager.REACT_CLASS) || name.equals(ScreenStackViewManager.REACT_CLASS)) {
                cancelAnimationsRecursive(view);
                return false;
            }
        }
        boolean shouldAnimateExiting = shouldAnimateExiting(id, z2);
        boolean z4 = shouldAnimateExiting && (hasAnimationForTag(id, 2) || this.mExitingViews.containsKey(Integer.valueOf(id)));
        boolean z5 = z && !z4;
        if (hasAnimationForTag(id, 4)) {
            this.mSharedTransitionManager.notifyAboutRemovedView(view);
            this.mSharedTransitionManager.makeSnapshot(view);
        }
        ArrayList arrayList = new ArrayList();
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            z3 = false;
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (removeOrAnimateExitRecursive(childAt, z5, shouldAnimateExiting)) {
                    z3 = true;
                } else if (z5 && childAt.getId() != -1) {
                    arrayList.add(childAt);
                }
            }
        } else {
            z3 = false;
        }
        boolean z6 = z4 || z3;
        if (z4) {
            HashMap<String, Object> prepareDataForAnimationWorklet = prepareDataForAnimationWorklet(new Snapshot(view, this.mReanimatedNativeHierarchyManager).toCurrentMap(), false);
            if (!this.mExitingViews.containsKey(Integer.valueOf(id))) {
                this.mExitingViews.put(Integer.valueOf(id), view);
                registerExitingAncestors(view);
                this.mNativeMethodsHolder.startAnimation(id, 2, prepareDataForAnimationWorklet);
            }
        }
        this.mNativeMethodsHolder.clearAnimationConfig(id);
        if (!z6) {
            return false;
        }
        if (z3) {
            if (id == -1) {
                cancelAnimationsRecursive(view);
                return false;
            }
            this.mAncestorsToRemove.add(Integer.valueOf(id));
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            removeView((View) it.next(), (ViewGroup) view);
        }
        return true;
    }

    public void clearAnimationConfigRecursive(View view) {
        this.mNativeMethodsHolder.clearAnimationConfig(view.getId());
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                clearAnimationConfigRecursive(viewGroup.getChildAt(i));
            }
        }
    }

    public void cancelAnimationsInSubviews(View view) {
        cancelAnimationsRecursive(view);
        clearAnimationConfigRecursive(view);
    }

    private void registerExitingAncestors(View view) {
        View view2 = (View) view.getParent();
        while (view2 != null && !(view2 instanceof RootView)) {
            int id = view2.getId();
            Integer num = this.mExitingSubviewCountMap.get(Integer.valueOf(id));
            int i = 1;
            if (num != null) {
                i = 1 + num.intValue();
            }
            this.mExitingSubviewCountMap.put(Integer.valueOf(id), Integer.valueOf(i));
            view2 = (View) view2.getParent();
        }
    }

    private void maybeDropAncestors(View view) {
        if (view.getParent() instanceof View) {
            View view2 = (View) view.getParent();
            while (view2 != null && !(view2 instanceof RootView)) {
                View view3 = (View) view2.getParent();
                int id = view2.getId();
                Integer num = this.mExitingSubviewCountMap.get(Integer.valueOf(id));
                Integer valueOf = Integer.valueOf(num != null ? num.intValue() - 1 : 0);
                if (valueOf.intValue() <= 0) {
                    if (this.mAncestorsToRemove.contains(Integer.valueOf(id))) {
                        this.mAncestorsToRemove.remove(Integer.valueOf(id));
                        if (!this.mExitingViews.containsKey(Integer.valueOf(id))) {
                            removeView(view2, (ViewGroup) view3);
                        }
                    }
                    this.mExitingSubviewCountMap.remove(Integer.valueOf(id));
                } else {
                    this.mExitingSubviewCountMap.put(Integer.valueOf(id), valueOf);
                }
                view2 = view3;
            }
        }
    }

    private void removeView(View view, @Nullable ViewGroup viewGroup) {
        int id = view.getId();
        if (this.mCallbacks.containsKey(Integer.valueOf(id))) {
            Runnable runnable = this.mCallbacks.get(Integer.valueOf(id));
            this.mCallbacks.remove(Integer.valueOf(id));
            if (runnable != null) {
                runnable.run();
            }
        } else {
            this.mReanimatedNativeHierarchyManager.publicDropView(view);
        }
        if (viewGroup != null && viewGroup.indexOfChild(view) != -1) {
            viewGroup.removeView(view);
        }
    }

    public void cancelAnimationsRecursive(View view) {
        if (this.mExitingViews.containsKey(Integer.valueOf(view.getId()))) {
            endLayoutAnimation(view.getId(), true);
        } else if ((view instanceof ViewGroup) && this.mExitingSubviewCountMap.containsKey(Integer.valueOf(view.getId()))) {
            cancelAnimationsInSubviews((ViewGroup) view);
        }
    }

    private void cancelAnimationsInSubviews(ViewGroup viewGroup) {
        for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = viewGroup.getChildAt(childCount);
            if (childAt != null) {
                if (this.mExitingViews.containsKey(Integer.valueOf(childAt.getId()))) {
                    endLayoutAnimation(childAt.getId(), true);
                } else if ((childAt instanceof ViewGroup) && this.mExitingSubviewCountMap.containsKey(Integer.valueOf(childAt.getId()))) {
                    cancelAnimationsInSubviews((ViewGroup) childAt);
                }
            }
        }
    }

    private View resolveView(int i) {
        if (this.mExitingViews.containsKey(Integer.valueOf(i))) {
            return this.mExitingViews.get(Integer.valueOf(i));
        }
        View transitioningView = this.mSharedTransitionManager.getTransitioningView(i);
        if (transitioningView != null) {
            return transitioningView;
        }
        try {
            return this.mUIManager.resolveView(i);
        } catch (IllegalViewOperationException unused) {
            return null;
        }
    }

    private ViewManager resolveViewManager(int i) {
        try {
            return this.mReanimatedNativeHierarchyManager.resolveViewManager(i);
        } catch (Exception unused) {
            return null;
        }
    }

    private static Point convertScreenLocationToViewCoordinates(Point point, View view) {
        int[] iArr = {0, 0};
        if (view != null) {
            view.getLocationOnScreen(iArr);
        }
        return new Point(point.x - iArr[0], point.y - iArr[1]);
    }

    public void screenDidLayout(View view) {
        this.mSharedTransitionManager.screenDidLayout(view);
    }

    public void viewDidLayout(View view) {
        this.mSharedTransitionManager.viewDidLayout(view);
    }

    public void notifyAboutViewsRemoval(int[] iArr) {
        this.mSharedTransitionManager.onViewsRemoval(iArr);
    }

    public void notifyAboutScreenWillDisappear() {
        this.mSharedTransitionManager.onScreenWillDisappear();
    }

    public void makeSnapshotOfTopScreenViews(ViewGroup viewGroup) {
        this.mSharedTransitionManager.doSnapshotForTopScreenViews(viewGroup);
    }

    /* access modifiers changed from: protected */
    public ReactContext getContext() {
        return this.mContext;
    }
}
