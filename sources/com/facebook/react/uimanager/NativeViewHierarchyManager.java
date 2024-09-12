package com.facebook.react.uimanager;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.PopupMenu;
import com.facebook.common.logging.FLog;
import com.facebook.react.R;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.JSApplicationIllegalArgumentException;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.RetryableMountingLayerException;
import com.facebook.react.bridge.SoftAssertions;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.touch.JSResponderHandler;
import com.facebook.react.uimanager.layoutanimation.LayoutAnimationController;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class NativeViewHierarchyManager {
    private static final String TAG = "NativeViewHierarchyManager";
    private final boolean DEBUG_MODE;
    private final RectF mBoundingBox;
    private final JSResponderHandler mJSResponderHandler;
    private boolean mLayoutAnimationEnabled;
    private final LayoutAnimationController mLayoutAnimator;
    /* access modifiers changed from: private */
    public HashMap<Integer, Set<Integer>> mPendingDeletionsForTag;
    private PopupMenu mPopupMenu;
    private final SparseBooleanArray mRootTags;
    private final RootViewManager mRootViewManager;
    private final SparseArray<ViewManager> mTagsToViewManagers;
    private final SparseArray<View> mTagsToViews;
    private final ViewManagerRegistry mViewManagers;

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry) {
        this(viewManagerRegistry, new RootViewManager());
    }

    public NativeViewHierarchyManager(ViewManagerRegistry viewManagerRegistry, RootViewManager rootViewManager) {
        this.DEBUG_MODE = false;
        this.mJSResponderHandler = new JSResponderHandler();
        this.mLayoutAnimator = new LayoutAnimationController();
        this.mBoundingBox = new RectF();
        this.mViewManagers = viewManagerRegistry;
        this.mTagsToViews = new SparseArray<>();
        this.mTagsToViewManagers = new SparseArray<>();
        this.mRootTags = new SparseBooleanArray();
        this.mRootViewManager = rootViewManager;
    }

    public final synchronized View resolveView(int i) {
        View view;
        view = this.mTagsToViews.get(i);
        if (view == null) {
            throw new IllegalViewOperationException("Trying to resolve view with tag " + i + " which doesn't exist");
        }
        return view;
    }

    public final synchronized ViewManager resolveViewManager(int i) {
        ViewManager viewManager;
        viewManager = this.mTagsToViewManagers.get(i);
        if (viewManager == null) {
            throw new IllegalViewOperationException("ViewManager for tag " + i + " could not be found.\n");
        }
        return viewManager;
    }

    public void setLayoutAnimationEnabled(boolean z) {
        this.mLayoutAnimationEnabled = z;
    }

    public synchronized void updateInstanceHandle(int i, long j) {
        UiThreadUtil.assertOnUiThread();
        try {
            updateInstanceHandle(resolveView(i), j);
        } catch (IllegalViewOperationException e) {
            FLog.e(TAG, "Unable to update properties for view tag " + i, (Throwable) e);
        }
        return;
    }

    public synchronized void updateProperties(int i, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.assertOnUiThread();
        try {
            ViewManager resolveViewManager = resolveViewManager(i);
            View resolveView = resolveView(i);
            if (reactStylesDiffMap != null) {
                resolveViewManager.updateProperties(resolveView, reactStylesDiffMap);
            }
        } catch (IllegalViewOperationException e) {
            FLog.e(TAG, "Unable to update properties for view tag " + i, (Throwable) e);
        }
        return;
    }

    public synchronized void updateViewExtraData(int i, Object obj) {
        UiThreadUtil.assertOnUiThread();
        resolveViewManager(i).updateExtraData(resolveView(i), obj);
    }

    public synchronized void updateLayout(int i, int i2, int i3, int i4, int i5, int i6) {
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0, "NativeViewHierarchyManager_updateLayout").arg("parentTag", i).arg("tag", i2).flush();
        try {
            View resolveView = resolveView(i2);
            resolveView.measure(View.MeasureSpec.makeMeasureSpec(i5, 1073741824), View.MeasureSpec.makeMeasureSpec(i6, 1073741824));
            ViewParent parent = resolveView.getParent();
            if (parent instanceof RootView) {
                parent.requestLayout();
            }
            if (!this.mRootTags.get(i)) {
                ViewManager viewManager = this.mTagsToViewManagers.get(i);
                if (viewManager instanceof IViewManagerWithChildren) {
                    IViewManagerWithChildren iViewManagerWithChildren = (IViewManagerWithChildren) viewManager;
                    if (iViewManagerWithChildren != null && !iViewManagerWithChildren.needsCustomLayoutForChildren()) {
                        updateLayout(resolveView, i3, i4, i5, i6);
                    }
                } else {
                    throw new IllegalViewOperationException("Trying to use view with tag " + i + " as a parent, but its Manager doesn't implement IViewManagerWithChildren");
                }
            } else {
                updateLayout(resolveView, i3, i4, i5, i6);
            }
        } finally {
            Systrace.endSection(0);
        }
    }

    private void updateInstanceHandle(View view, long j) {
        UiThreadUtil.assertOnUiThread();
        view.setTag(R.id.view_tag_instance_handle, Long.valueOf(j));
    }

    public long getInstanceHandle(int i) {
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            Long l = (Long) view.getTag(R.id.view_tag_instance_handle);
            if (l != null) {
                return l.longValue();
            }
            throw new IllegalViewOperationException("Unable to find instanceHandle for tag: " + i);
        }
        throw new IllegalViewOperationException("Unable to find view for tag: " + i);
    }

    private void updateLayout(View view, int i, int i2, int i3, int i4) {
        if (!this.mLayoutAnimationEnabled || !this.mLayoutAnimator.shouldAnimateLayout(view)) {
            view.layout(i, i2, i3 + i, i4 + i2);
        } else {
            this.mLayoutAnimator.applyLayoutUpdate(view, i, i2, i3, i4);
        }
    }

    public synchronized void createView(ThemedReactContext themedReactContext, int i, String str, ReactStylesDiffMap reactStylesDiffMap) {
        UiThreadUtil.assertOnUiThread();
        SystraceMessage.beginSection(0, "NativeViewHierarchyManager_createView").arg("tag", i).arg("className", (Object) str).flush();
        try {
            ViewManager viewManager = this.mViewManagers.get(str);
            this.mTagsToViews.put(i, viewManager.createView(i, themedReactContext, reactStylesDiffMap, (StateWrapper) null, this.mJSResponderHandler));
            this.mTagsToViewManagers.put(i, viewManager);
        } finally {
            Systrace.endSection(0);
        }
    }

    private static String constructManageChildrenErrorMessage(ViewGroup viewGroup, ViewGroupManager viewGroupManager, int[] iArr, ViewAtIndex[] viewAtIndexArr, int[] iArr2) {
        StringBuilder sb = new StringBuilder();
        if (viewGroup != null) {
            sb.append("View tag:" + viewGroup.getId() + " View Type:" + viewGroup.getClass().toString() + "\n");
            sb.append("  children(" + viewGroupManager.getChildCount(viewGroup) + "): [\n");
            for (int i = 0; viewGroupManager.getChildAt(viewGroup, i) != null; i += 16) {
                int i2 = 0;
                while (true) {
                    int i3 = i + i2;
                    if (viewGroupManager.getChildAt(viewGroup, i3) == null || i2 >= 16) {
                        sb.append("\n");
                    } else {
                        sb.append(viewGroupManager.getChildAt(viewGroup, i3).getId() + ",");
                        i2++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (iArr != null) {
            sb.append("  indicesToRemove(" + iArr.length + "): [\n");
            for (int i4 = 0; i4 < iArr.length; i4 += 16) {
                int i5 = 0;
                while (true) {
                    int i6 = i4 + i5;
                    if (i6 >= iArr.length || i5 >= 16) {
                        sb.append("\n");
                    } else {
                        sb.append(iArr[i6] + ",");
                        i5++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (viewAtIndexArr != null) {
            sb.append("  viewsToAdd(" + viewAtIndexArr.length + "): [\n");
            for (int i7 = 0; i7 < viewAtIndexArr.length; i7 += 16) {
                int i8 = 0;
                while (true) {
                    int i9 = i7 + i8;
                    if (i9 >= viewAtIndexArr.length || i8 >= 16) {
                        sb.append("\n");
                    } else {
                        sb.append("[" + viewAtIndexArr[i9].mIndex + "," + viewAtIndexArr[i9].mTag + "],");
                        i8++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ],\n");
        }
        if (iArr2 != null) {
            sb.append("  tagsToDelete(" + iArr2.length + "): [\n");
            for (int i10 = 0; i10 < iArr2.length; i10 += 16) {
                int i11 = 0;
                while (true) {
                    int i12 = i10 + i11;
                    if (i12 >= iArr2.length || i11 >= 16) {
                        sb.append("\n");
                    } else {
                        sb.append(iArr2[i12] + ",");
                        i11++;
                    }
                }
                sb.append("\n");
            }
            sb.append(" ]\n");
        }
        return sb.toString();
    }

    private Set<Integer> getPendingDeletionsForTag(int i) {
        if (this.mPendingDeletionsForTag == null) {
            this.mPendingDeletionsForTag = new HashMap<>();
        }
        if (!this.mPendingDeletionsForTag.containsKey(Integer.valueOf(i))) {
            this.mPendingDeletionsForTag.put(Integer.valueOf(i), new HashSet());
        }
        return this.mPendingDeletionsForTag.get(Integer.valueOf(i));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:77:0x01f5, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void manageChildren(int r18, int[] r19, com.facebook.react.uimanager.ViewAtIndex[] r20, int[] r21) {
        /*
            r17 = this;
            r8 = r17
            r0 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            monitor-enter(r17)
            com.facebook.react.bridge.UiThreadUtil.assertOnUiThread()     // Catch:{ all -> 0x0220 }
            java.util.Set r12 = r17.getPendingDeletionsForTag(r18)     // Catch:{ all -> 0x0220 }
            android.util.SparseArray<android.view.View> r1 = r8.mTagsToViews     // Catch:{ all -> 0x0220 }
            java.lang.Object r1 = r1.get(r0)     // Catch:{ all -> 0x0220 }
            r13 = r1
            android.view.ViewGroup r13 = (android.view.ViewGroup) r13     // Catch:{ all -> 0x0220 }
            com.facebook.react.uimanager.ViewManager r1 = r17.resolveViewManager(r18)     // Catch:{ all -> 0x0220 }
            r14 = r1
            com.facebook.react.uimanager.ViewGroupManager r14 = (com.facebook.react.uimanager.ViewGroupManager) r14     // Catch:{ all -> 0x0220 }
            if (r13 == 0) goto L_0x01f6
            int r1 = r14.getChildCount(r13)     // Catch:{ all -> 0x0220 }
            if (r9 == 0) goto L_0x0100
            int r2 = r9.length     // Catch:{ all -> 0x0220 }
            int r2 = r2 + -1
        L_0x002d:
            if (r2 < 0) goto L_0x0100
            r3 = r9[r2]     // Catch:{ all -> 0x0220 }
            if (r3 < 0) goto L_0x00cf
            android.view.View r4 = r14.getChildAt(r13, r3)     // Catch:{ all -> 0x0220 }
            if (r4 != 0) goto L_0x007a
            android.util.SparseBooleanArray r1 = r8.mRootTags     // Catch:{ all -> 0x0220 }
            boolean r1 = r1.get(r0)     // Catch:{ all -> 0x0220 }
            if (r1 == 0) goto L_0x0049
            int r1 = r14.getChildCount(r13)     // Catch:{ all -> 0x0220 }
            if (r1 != 0) goto L_0x0049
            monitor-exit(r17)
            return
        L_0x0049:
            com.facebook.react.uimanager.IllegalViewOperationException r1 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0220 }
            r2.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r4 = "Trying to remove a view index above child count "
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = " view tag: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = "\n detail: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = constructManageChildrenErrorMessage(r13, r14, r9, r10, r11)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0220 }
            r1.<init>(r0)     // Catch:{ all -> 0x0220 }
            throw r1     // Catch:{ all -> 0x0220 }
        L_0x007a:
            if (r3 >= r1) goto L_0x009e
            android.view.View r1 = r14.getChildAt(r13, r3)     // Catch:{ all -> 0x0220 }
            boolean r4 = r8.mLayoutAnimationEnabled     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x0097
            com.facebook.react.uimanager.layoutanimation.LayoutAnimationController r4 = r8.mLayoutAnimator     // Catch:{ all -> 0x0220 }
            boolean r4 = r4.shouldAnimateLayout(r1)     // Catch:{ all -> 0x0220 }
            if (r4 == 0) goto L_0x0097
            int r1 = r1.getId()     // Catch:{ all -> 0x0220 }
            boolean r1 = r8.arrayContains(r11, r1)     // Catch:{ all -> 0x0220 }
            if (r1 == 0) goto L_0x0097
            goto L_0x009a
        L_0x0097:
            r14.removeViewAt(r13, r3)     // Catch:{ all -> 0x0220 }
        L_0x009a:
            int r2 = r2 + -1
            r1 = r3
            goto L_0x002d
        L_0x009e:
            com.facebook.react.uimanager.IllegalViewOperationException r1 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0220 }
            r2.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r4 = "Trying to remove an out of order view index:"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = " view tag: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = "\n detail: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = constructManageChildrenErrorMessage(r13, r14, r9, r10, r11)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0220 }
            r1.<init>(r0)     // Catch:{ all -> 0x0220 }
            throw r1     // Catch:{ all -> 0x0220 }
        L_0x00cf:
            com.facebook.react.uimanager.IllegalViewOperationException r1 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0220 }
            r2.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r4 = "Trying to remove a negative view index:"
            java.lang.StringBuilder r2 = r2.append(r4)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = " view tag: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r0 = r2.append(r0)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = "\n detail: "
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = constructManageChildrenErrorMessage(r13, r14, r9, r10, r11)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r0 = r0.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0220 }
            r1.<init>(r0)     // Catch:{ all -> 0x0220 }
            throw r1     // Catch:{ all -> 0x0220 }
        L_0x0100:
            if (r11 == 0) goto L_0x0175
            r7 = 0
        L_0x0103:
            int r1 = r11.length     // Catch:{ all -> 0x0220 }
            if (r7 >= r1) goto L_0x0175
            r1 = r11[r7]     // Catch:{ all -> 0x0220 }
            android.util.SparseArray<android.view.View> r2 = r8.mTagsToViews     // Catch:{ all -> 0x0220 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x0220 }
            r6 = r2
            android.view.View r6 = (android.view.View) r6     // Catch:{ all -> 0x0220 }
            if (r6 == 0) goto L_0x014c
            boolean r2 = r8.mLayoutAnimationEnabled     // Catch:{ all -> 0x0220 }
            if (r2 == 0) goto L_0x013f
            com.facebook.react.uimanager.layoutanimation.LayoutAnimationController r2 = r8.mLayoutAnimator     // Catch:{ all -> 0x0220 }
            boolean r2 = r2.shouldAnimateLayout(r6)     // Catch:{ all -> 0x0220 }
            if (r2 == 0) goto L_0x013f
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0220 }
            r12.add(r1)     // Catch:{ all -> 0x0220 }
            com.facebook.react.uimanager.layoutanimation.LayoutAnimationController r5 = r8.mLayoutAnimator     // Catch:{ all -> 0x0220 }
            com.facebook.react.uimanager.NativeViewHierarchyManager$1 r4 = new com.facebook.react.uimanager.NativeViewHierarchyManager$1     // Catch:{ all -> 0x0220 }
            r1 = r4
            r2 = r17
            r3 = r14
            r15 = r4
            r4 = r13
            r0 = r5
            r5 = r6
            r9 = r6
            r6 = r12
            r16 = r7
            r7 = r18
            r1.<init>(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0220 }
            r0.deleteView(r9, r15)     // Catch:{ all -> 0x0220 }
            goto L_0x0145
        L_0x013f:
            r9 = r6
            r16 = r7
            r8.dropView(r9)     // Catch:{ all -> 0x0220 }
        L_0x0145:
            int r7 = r16 + 1
            r0 = r18
            r9 = r19
            goto L_0x0103
        L_0x014c:
            com.facebook.react.uimanager.IllegalViewOperationException r0 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0220 }
            r2.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = "Trying to destroy unknown view tag: "
            java.lang.StringBuilder r2 = r2.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r1 = r2.append(r1)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = "\n detail: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0220 }
            r2 = r19
            java.lang.String r2 = constructManageChildrenErrorMessage(r13, r14, r2, r10, r11)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0220 }
            r0.<init>(r1)     // Catch:{ all -> 0x0220 }
            throw r0     // Catch:{ all -> 0x0220 }
        L_0x0175:
            r2 = r9
            if (r10 == 0) goto L_0x01e5
            r0 = 0
        L_0x0179:
            int r1 = r10.length     // Catch:{ all -> 0x0220 }
            if (r0 >= r1) goto L_0x01e5
            r1 = r10[r0]     // Catch:{ all -> 0x0220 }
            android.util.SparseArray<android.view.View> r3 = r8.mTagsToViews     // Catch:{ all -> 0x0220 }
            int r4 = r1.mTag     // Catch:{ all -> 0x0220 }
            java.lang.Object r3 = r3.get(r4)     // Catch:{ all -> 0x0220 }
            android.view.View r3 = (android.view.View) r3     // Catch:{ all -> 0x0220 }
            if (r3 == 0) goto L_0x01bc
            int r4 = r1.mIndex     // Catch:{ all -> 0x0220 }
            boolean r5 = r12.isEmpty()     // Catch:{ all -> 0x0220 }
            if (r5 != 0) goto L_0x01b6
            r4 = 0
            r5 = 0
        L_0x0194:
            int r6 = r13.getChildCount()     // Catch:{ all -> 0x0220 }
            if (r4 >= r6) goto L_0x01b6
            int r6 = r1.mIndex     // Catch:{ all -> 0x0220 }
            if (r5 != r6) goto L_0x019f
            goto L_0x01b6
        L_0x019f:
            android.view.View r6 = r13.getChildAt(r4)     // Catch:{ all -> 0x0220 }
            int r6 = r6.getId()     // Catch:{ all -> 0x0220 }
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)     // Catch:{ all -> 0x0220 }
            boolean r6 = r12.contains(r6)     // Catch:{ all -> 0x0220 }
            if (r6 != 0) goto L_0x01b3
            int r5 = r5 + 1
        L_0x01b3:
            int r4 = r4 + 1
            goto L_0x0194
        L_0x01b6:
            r14.addView(r13, r3, r4)     // Catch:{ all -> 0x0220 }
            int r0 = r0 + 1
            goto L_0x0179
        L_0x01bc:
            com.facebook.react.uimanager.IllegalViewOperationException r0 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0220 }
            r3.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r4 = "Trying to add unknown view tag: "
            java.lang.StringBuilder r3 = r3.append(r4)     // Catch:{ all -> 0x0220 }
            int r1 = r1.mTag     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r1 = r3.append(r1)     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = "\n detail: "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = constructManageChildrenErrorMessage(r13, r14, r2, r10, r11)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0220 }
            r0.<init>(r1)     // Catch:{ all -> 0x0220 }
            throw r0     // Catch:{ all -> 0x0220 }
        L_0x01e5:
            boolean r0 = r12.isEmpty()     // Catch:{ all -> 0x0220 }
            if (r0 == 0) goto L_0x01f4
            java.util.HashMap<java.lang.Integer, java.util.Set<java.lang.Integer>> r0 = r8.mPendingDeletionsForTag     // Catch:{ all -> 0x0220 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r18)     // Catch:{ all -> 0x0220 }
            r0.remove(r1)     // Catch:{ all -> 0x0220 }
        L_0x01f4:
            monitor-exit(r17)
            return
        L_0x01f6:
            r2 = r9
            com.facebook.react.uimanager.IllegalViewOperationException r0 = new com.facebook.react.uimanager.IllegalViewOperationException     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0220 }
            r1.<init>()     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = "Trying to manageChildren view with tag "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0220 }
            r3 = r18
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.String r3 = " which doesn't exist\n detail: "
            java.lang.StringBuilder r1 = r1.append(r3)     // Catch:{ all -> 0x0220 }
            java.lang.String r2 = constructManageChildrenErrorMessage(r13, r14, r2, r10, r11)     // Catch:{ all -> 0x0220 }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x0220 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0220 }
            r0.<init>(r1)     // Catch:{ all -> 0x0220 }
            throw r0     // Catch:{ all -> 0x0220 }
        L_0x0220:
            r0 = move-exception
            monitor-exit(r17)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.uimanager.NativeViewHierarchyManager.manageChildren(int, int[], com.facebook.react.uimanager.ViewAtIndex[], int[]):void");
    }

    private boolean arrayContains(int[] iArr, int i) {
        if (iArr == null) {
            return false;
        }
        for (int i2 : iArr) {
            if (i2 == i) {
                return true;
            }
        }
        return false;
    }

    private static String constructSetChildrenErrorMessage(ViewGroup viewGroup, ViewGroupManager viewGroupManager, ReadableArray readableArray) {
        ViewAtIndex[] viewAtIndexArr = new ViewAtIndex[readableArray.size()];
        for (int i = 0; i < readableArray.size(); i++) {
            viewAtIndexArr[i] = new ViewAtIndex(readableArray.getInt(i), i);
        }
        return constructManageChildrenErrorMessage(viewGroup, viewGroupManager, (int[]) null, viewAtIndexArr, (int[]) null);
    }

    public synchronized void setChildren(int i, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        ViewGroup viewGroup = (ViewGroup) this.mTagsToViews.get(i);
        ViewGroupManager viewGroupManager = (ViewGroupManager) resolveViewManager(i);
        int i2 = 0;
        while (i2 < readableArray.size()) {
            View view = this.mTagsToViews.get(readableArray.getInt(i2));
            if (view != null) {
                viewGroupManager.addView(viewGroup, view, i2);
                i2++;
            } else {
                throw new IllegalViewOperationException("Trying to add unknown view tag: " + readableArray.getInt(i2) + "\n detail: " + constructSetChildrenErrorMessage(viewGroup, viewGroupManager, readableArray));
            }
        }
    }

    public synchronized void addRootView(int i, View view) {
        addRootViewGroup(i, view);
    }

    /* access modifiers changed from: protected */
    public final synchronized void addRootViewGroup(int i, View view) {
        if (view.getId() != -1) {
            FLog.e(TAG, "Trying to add a root view with an explicit id (" + view.getId() + ") already set. React Native uses the id field to track react tags and will overwrite this field. If that is fine, explicitly overwrite the id field to View.NO_ID before calling addRootView.");
        }
        this.mTagsToViews.put(i, view);
        this.mTagsToViewManagers.put(i, this.mRootViewManager);
        this.mRootTags.put(i, true);
        view.setId(i);
    }

    /* access modifiers changed from: protected */
    public synchronized void dropView(View view) {
        UiThreadUtil.assertOnUiThread();
        if (view != null) {
            if (this.mTagsToViewManagers.get(view.getId()) != null) {
                if (!this.mRootTags.get(view.getId())) {
                    resolveViewManager(view.getId()).onDropViewInstance(view);
                }
                ViewManager viewManager = this.mTagsToViewManagers.get(view.getId());
                if ((view instanceof ViewGroup) && (viewManager instanceof ViewGroupManager)) {
                    ViewGroup viewGroup = (ViewGroup) view;
                    ViewGroupManager viewGroupManager = (ViewGroupManager) viewManager;
                    for (int childCount = viewGroupManager.getChildCount(viewGroup) - 1; childCount >= 0; childCount--) {
                        View childAt = viewGroupManager.getChildAt(viewGroup, childCount);
                        if (childAt == null) {
                            FLog.e(TAG, "Unable to drop null child view");
                        } else if (this.mTagsToViews.get(childAt.getId()) != null) {
                            dropView(childAt);
                        }
                    }
                    viewGroupManager.removeAllViews(viewGroup);
                }
                this.mTagsToViews.remove(view.getId());
                this.mTagsToViewManagers.remove(view.getId());
            }
        }
    }

    public synchronized void removeRootView(int i) {
        UiThreadUtil.assertOnUiThread();
        if (!this.mRootTags.get(i)) {
            SoftAssertions.assertUnreachable("View with tag " + i + " is not registered as a root view");
        }
        dropView(this.mTagsToViews.get(i));
        this.mRootTags.delete(i);
    }

    public synchronized void measure(int i, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            View view2 = (View) RootViewUtil.getRootView(view);
            if (view2 != null) {
                computeBoundingBox(view2, iArr);
                int i2 = iArr[0];
                int i3 = iArr[1];
                computeBoundingBox(view, iArr);
                iArr[0] = iArr[0] - i2;
                iArr[1] = iArr[1] - i3;
            } else {
                throw new NoSuchNativeViewException("Native view " + i + " is no longer on screen");
            }
        } else {
            throw new NoSuchNativeViewException("No native view for " + i + " currently exists");
        }
    }

    private void computeBoundingBox(View view, int[] iArr) {
        this.mBoundingBox.set(0.0f, 0.0f, (float) view.getWidth(), (float) view.getHeight());
        mapRectFromViewToWindowCoords(view, this.mBoundingBox);
        iArr[0] = Math.round(this.mBoundingBox.left);
        iArr[1] = Math.round(this.mBoundingBox.top);
        iArr[2] = Math.round(this.mBoundingBox.right - this.mBoundingBox.left);
        iArr[3] = Math.round(this.mBoundingBox.bottom - this.mBoundingBox.top);
    }

    private void mapRectFromViewToWindowCoords(View view, RectF rectF) {
        Matrix matrix = view.getMatrix();
        if (!matrix.isIdentity()) {
            matrix.mapRect(rectF);
        }
        rectF.offset((float) view.getLeft(), (float) view.getTop());
        ViewParent parent = view.getParent();
        while (parent instanceof View) {
            View view2 = (View) parent;
            rectF.offset((float) (-view2.getScrollX()), (float) (-view2.getScrollY()));
            Matrix matrix2 = view2.getMatrix();
            if (!matrix2.isIdentity()) {
                matrix2.mapRect(rectF);
            }
            rectF.offset((float) view2.getLeft(), (float) view2.getTop());
            parent = view2.getParent();
        }
    }

    public synchronized void measureInWindow(int i, int[] iArr) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            view.getLocationOnScreen(iArr);
            Rect rect = new Rect();
            view.getWindowVisibleDisplayFrame(rect);
            iArr[0] = iArr[0] - rect.left;
            iArr[1] = iArr[1] - rect.top;
            iArr[2] = view.getWidth();
            iArr[3] = view.getHeight();
        } else {
            throw new NoSuchNativeViewException("No native view for " + i + " currently exists");
        }
    }

    public synchronized int findTargetTagForTouch(int i, float f, float f2) {
        View view;
        UiThreadUtil.assertOnUiThread();
        view = this.mTagsToViews.get(i);
        if (view != null) {
        } else {
            throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
        }
        return TouchTargetHelper.findTargetTagForTouch(f, f2, (ViewGroup) view);
    }

    public synchronized void setJSResponder(int i, int i2, boolean z) {
        if (!z) {
            this.mJSResponderHandler.setJSResponder(i2, (ViewParent) null);
            return;
        }
        View view = this.mTagsToViews.get(i);
        if (i2 == i || !(view instanceof ViewParent)) {
            if (this.mRootTags.get(i)) {
                SoftAssertions.assertUnreachable("Cannot block native responder on " + i + " that is a root view");
            }
            this.mJSResponderHandler.setJSResponder(i2, view.getParent());
            return;
        }
        this.mJSResponderHandler.setJSResponder(i2, (ViewParent) view);
    }

    public void clearJSResponder() {
        this.mJSResponderHandler.clearJSResponder();
    }

    /* access modifiers changed from: package-private */
    public void configureLayoutAnimation(ReadableMap readableMap, Callback callback) {
        this.mLayoutAnimator.initializeFromConfig(readableMap, callback);
    }

    /* access modifiers changed from: package-private */
    public void clearLayoutAnimation() {
        this.mLayoutAnimator.reset();
    }

    @Deprecated
    public synchronized void dispatchCommand(int i, int i2, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            resolveViewManager(i).receiveCommand(view, i2, readableArray);
        } else {
            throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i + "] and command " + i2);
        }
    }

    public synchronized void dispatchCommand(int i, String str, ReadableArray readableArray) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            ViewManager resolveViewManager = resolveViewManager(i);
            ViewManagerDelegate delegate = resolveViewManager.getDelegate();
            if (delegate != null) {
                delegate.receiveCommand(view, str, readableArray);
            } else {
                resolveViewManager.receiveCommand(view, str, readableArray);
            }
        } else {
            throw new RetryableMountingLayerException("Trying to send command to a non-existing view with tag [" + i + "] and command " + str);
        }
    }

    public synchronized void showPopupMenu(int i, ReadableArray readableArray, Callback callback, Callback callback2) {
        UiThreadUtil.assertOnUiThread();
        View view = this.mTagsToViews.get(i);
        if (view == null) {
            callback2.invoke("Can't display popup. Could not find view with tag " + i);
            return;
        }
        PopupMenu popupMenu = new PopupMenu(getReactContextForView(i), view);
        this.mPopupMenu = popupMenu;
        Menu menu = popupMenu.getMenu();
        for (int i2 = 0; i2 < readableArray.size(); i2++) {
            menu.add(0, 0, i2, readableArray.getString(i2));
        }
        PopupMenuCallbackHandler popupMenuCallbackHandler = new PopupMenuCallbackHandler(callback);
        this.mPopupMenu.setOnMenuItemClickListener(popupMenuCallbackHandler);
        this.mPopupMenu.setOnDismissListener(popupMenuCallbackHandler);
        this.mPopupMenu.show();
    }

    public void dismissPopupMenu() {
        PopupMenu popupMenu = this.mPopupMenu;
        if (popupMenu != null) {
            popupMenu.dismiss();
        }
    }

    private static class PopupMenuCallbackHandler implements PopupMenu.OnMenuItemClickListener, PopupMenu.OnDismissListener {
        boolean mConsumed;
        final Callback mSuccess;

        private PopupMenuCallbackHandler(Callback callback) {
            this.mConsumed = false;
            this.mSuccess = callback;
        }

        public void onDismiss(PopupMenu popupMenu) {
            if (!this.mConsumed) {
                this.mSuccess.invoke(UIManagerModuleConstants.ACTION_DISMISSED);
                this.mConsumed = true;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            if (this.mConsumed) {
                return false;
            }
            this.mSuccess.invoke(UIManagerModuleConstants.ACTION_ITEM_SELECTED, Integer.valueOf(menuItem.getOrder()));
            this.mConsumed = true;
            return true;
        }
    }

    private ThemedReactContext getReactContextForView(int i) {
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            return (ThemedReactContext) view.getContext();
        }
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
    }

    public void sendAccessibilityEvent(int i, int i2) {
        View view = this.mTagsToViews.get(i);
        if (view != null) {
            view.sendAccessibilityEvent(i2);
            return;
        }
        throw new JSApplicationIllegalArgumentException("Could not find view with tag " + i);
    }
}
