package com.swmansion.gesturehandler.react;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.PaintDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;
import android.os.Build;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.ViewGroupKt;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import com.facebook.react.uimanager.ViewManagerDelegate;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerDelegate;
import com.facebook.react.viewmanagers.RNGestureHandlerButtonManagerInterface;
import com.swmansion.gesturehandler.core.GestureHandler;
import com.swmansion.gesturehandler.core.NativeViewGestureHandler;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 %2\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0002$%B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\u00022\u0006\u0010\b\u001a\u00020\tH\u0016J\u0010\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006H\u0014J\b\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0014J\u0018\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0011\u001a\u00020\u0012H\u0017J\u0018\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0017J\u0018\u0010\u0016\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0015H\u0017J\u0018\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0019\u001a\u00020\u0015H\u0017J\u0018\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u0015H\u0017J\u001f\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0017¢\u0006\u0002\u0010\u001fJ\u0018\u0010 \u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u001eH\u0017J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010#\u001a\u00020\u0015H\u0017R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager;", "Lcom/facebook/react/uimanager/ViewGroupManager;", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "Lcom/facebook/react/viewmanagers/RNGestureHandlerButtonManagerInterface;", "()V", "mDelegate", "Lcom/facebook/react/uimanager/ViewManagerDelegate;", "createViewInstance", "context", "Lcom/facebook/react/uimanager/ThemedReactContext;", "getDelegate", "getName", "", "onAfterUpdateTransaction", "", "view", "setBorderRadius", "borderRadius", "", "setBorderless", "useBorderlessDrawable", "", "setEnabled", "enabled", "setExclusive", "exclusive", "setForeground", "useDrawableOnForeground", "setRippleColor", "rippleColor", "", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;Ljava/lang/Integer;)V", "setRippleRadius", "rippleRadius", "setTouchSoundDisabled", "touchSoundDisabled", "ButtonViewGroup", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@ReactModule(name = "RNGestureHandlerButton")
/* compiled from: RNGestureHandlerButtonViewManager.kt */
public final class RNGestureHandlerButtonViewManager extends ViewGroupManager<ButtonViewGroup> implements RNGestureHandlerButtonManagerInterface<ButtonViewGroup> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String REACT_CLASS = "RNGestureHandlerButton";
    private final ViewManagerDelegate<ButtonViewGroup> mDelegate = new RNGestureHandlerButtonManagerDelegate(this);

    public String getName() {
        return REACT_CLASS;
    }

    public ButtonViewGroup createViewInstance(ThemedReactContext themedReactContext) {
        Intrinsics.checkNotNullParameter(themedReactContext, "context");
        return new ButtonViewGroup(themedReactContext);
    }

    @ReactProp(name = "foreground")
    public void setForeground(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.setUseDrawableOnForeground(z);
    }

    @ReactProp(name = "borderless")
    public void setBorderless(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.setUseBorderlessDrawable(z);
    }

    @ReactProp(name = "enabled")
    public void setEnabled(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.setEnabled(z);
    }

    @ReactProp(name = "borderRadius")
    public void setBorderRadius(ButtonViewGroup buttonViewGroup, float f) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.setBorderRadius(f);
    }

    @ReactProp(name = "rippleColor")
    public void setRippleColor(ButtonViewGroup buttonViewGroup, Integer num) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.setRippleColor(num);
    }

    @ReactProp(name = "rippleRadius")
    public void setRippleRadius(ButtonViewGroup buttonViewGroup, int i) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.setRippleRadius(Integer.valueOf(i));
    }

    @ReactProp(name = "exclusive")
    public void setExclusive(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.setExclusive(z);
    }

    @ReactProp(name = "touchSoundDisabled")
    public void setTouchSoundDisabled(ButtonViewGroup buttonViewGroup, boolean z) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.setSoundEffectsEnabled(!z);
    }

    /* access modifiers changed from: protected */
    public void onAfterUpdateTransaction(ButtonViewGroup buttonViewGroup) {
        Intrinsics.checkNotNullParameter(buttonViewGroup, ViewHierarchyConstants.VIEW_KEY);
        buttonViewGroup.updateBackground();
    }

    /* access modifiers changed from: protected */
    public ViewManagerDelegate<ButtonViewGroup> getDelegate() {
        return this.mDelegate;
    }

    @Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 N2\u00020\u00012\u00020\u0002:\u0001NB\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020\u0010H\u0016J\n\u00101\u001a\u0004\u0018\u000102H\u0002J\u0018\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0018\u00106\u001a\u00020-2\u0006\u00104\u001a\u00020\t2\u0006\u00105\u001a\u00020\tH\u0016J\u0018\u00107\u001a\u00020\u00102\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020:09H\u0002J\u0010\u0010;\u001a\u00020\u00102\u0006\u0010<\u001a\u00020/H\u0016J0\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020\u00102\u0006\u0010?\u001a\u00020\u00072\u0006\u0010@\u001a\u00020\u00072\u0006\u0010A\u001a\u00020\u00072\u0006\u0010B\u001a\u00020\u0007H\u0014J\u0010\u0010C\u001a\u00020\u00102\u0006\u0010.\u001a\u00020/H\u0017J\b\u0010D\u001a\u00020\u0010H\u0016J\u0010\u0010E\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0007H\u0016J\u0010\u0010F\u001a\u00020-2\u0006\u0010G\u001a\u00020\u0010H\u0016J\b\u0010H\u001a\u00020-H\u0002J\b\u0010I\u001a\u00020\u0010H\u0002J\u0006\u0010J\u001a\u00020-J\u0017\u0010K\u001a\u00020-2\f\u0010L\u001a\b\u0012\u0004\u0012\u00020-0MH\bR\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R$\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0012\"\u0004\b\u0016\u0010\u0014R\u000e\u0010\u0017\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000R*\u0010\u001c\u001a\u0004\u0018\u00010\u00072\b\u0010\u001b\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R*\u0010\"\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0007@FX\u000e¢\u0006\u0010\n\u0002\u0010!\u001a\u0004\b#\u0010\u001e\"\u0004\b$\u0010 R\u001a\u0010%\u001a\u00020\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u0012\"\u0004\b'\u0010\u0014R$\u0010)\u001a\u00020\u00102\u0006\u0010(\u001a\u00020\u0010@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\u0012\"\u0004\b+\u0010\u0014¨\u0006O"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "Landroid/view/ViewGroup;", "Lcom/swmansion/gesturehandler/core/NativeViewGestureHandler$NativeViewGestureHandlerHook;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "_backgroundColor", "", "radius", "", "borderRadius", "getBorderRadius", "()F", "setBorderRadius", "(F)V", "exclusive", "", "getExclusive", "()Z", "setExclusive", "(Z)V", "isTouched", "setTouched", "lastAction", "lastEventTime", "", "needBackgroundUpdate", "color", "rippleColor", "getRippleColor", "()Ljava/lang/Integer;", "setRippleColor", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "rippleRadius", "getRippleRadius", "setRippleRadius", "useBorderlessDrawable", "getUseBorderlessDrawable", "setUseBorderlessDrawable", "useForeground", "useDrawableOnForeground", "getUseDrawableOnForeground", "setUseDrawableOnForeground", "afterGestureEnd", "", "event", "Landroid/view/MotionEvent;", "canBegin", "createSelectableDrawable", "Landroid/graphics/drawable/Drawable;", "dispatchDrawableHotspotChanged", "x", "y", "drawableHotspotChanged", "isChildTouched", "children", "Lkotlin/sequences/Sequence;", "Landroid/view/View;", "onInterceptTouchEvent", "ev", "onLayout", "changed", "l", "t", "r", "b", "onTouchEvent", "performClick", "setBackgroundColor", "setPressed", "pressed", "tryFreeingResponder", "tryGrabbingResponder", "updateBackground", "withBackgroundUpdate", "block", "Lkotlin/Function0;", "Companion", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNGestureHandlerButtonViewManager.kt */
    public static final class ButtonViewGroup extends ViewGroup implements NativeViewGestureHandler.NativeViewGestureHandlerHook {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        /* access modifiers changed from: private */
        public static View.OnClickListener dummyClickListener = new RNGestureHandlerButtonViewManager$ButtonViewGroup$$ExternalSyntheticLambda0();
        /* access modifiers changed from: private */
        public static TypedValue resolveOutValue = new TypedValue();
        /* access modifiers changed from: private */
        public static ButtonViewGroup soundResponder;
        /* access modifiers changed from: private */
        public static ButtonViewGroup touchResponder;
        private int _backgroundColor;
        private float borderRadius;
        private boolean exclusive = true;
        private boolean isTouched;
        private int lastAction = -1;
        private long lastEventTime = -1;
        private boolean needBackgroundUpdate;
        private Integer rippleColor;
        private Integer rippleRadius;
        private boolean useBorderlessDrawable;
        private boolean useDrawableOnForeground;

        /* access modifiers changed from: private */
        /* renamed from: dummyClickListener$lambda-5  reason: not valid java name */
        public static final void m638dummyClickListener$lambda5(View view) {
        }

        public void dispatchDrawableHotspotChanged(float f, float f2) {
        }

        /* access modifiers changed from: protected */
        public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        }

        public void handleEventBeforeActivation(MotionEvent motionEvent) {
            NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.handleEventBeforeActivation(this, motionEvent);
        }

        public boolean shouldCancelRootViewGestureHandlerIfNecessary() {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.shouldCancelRootViewGestureHandlerIfNecessary(this);
        }

        public boolean shouldRecognizeSimultaneously(GestureHandler<?> gestureHandler) {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.shouldRecognizeSimultaneously(this, gestureHandler);
        }

        public boolean wantsToHandleEventBeforeActivation() {
            return NativeViewGestureHandler.NativeViewGestureHandlerHook.DefaultImpls.wantsToHandleEventBeforeActivation(this);
        }

        public ButtonViewGroup(Context context) {
            super(context);
            setOnClickListener(dummyClickListener);
            setClickable(true);
            setFocusable(true);
            this.needBackgroundUpdate = true;
        }

        public final Integer getRippleColor() {
            return this.rippleColor;
        }

        public final void setRippleColor(Integer num) {
            this.rippleColor = num;
            this.needBackgroundUpdate = true;
        }

        public final Integer getRippleRadius() {
            return this.rippleRadius;
        }

        public final void setRippleRadius(Integer num) {
            this.rippleRadius = num;
            this.needBackgroundUpdate = true;
        }

        public final boolean getUseDrawableOnForeground() {
            return this.useDrawableOnForeground;
        }

        public final void setUseDrawableOnForeground(boolean z) {
            this.useDrawableOnForeground = z;
            this.needBackgroundUpdate = true;
        }

        public final boolean getUseBorderlessDrawable() {
            return this.useBorderlessDrawable;
        }

        public final void setUseBorderlessDrawable(boolean z) {
            this.useBorderlessDrawable = z;
        }

        public final float getBorderRadius() {
            return this.borderRadius;
        }

        public final void setBorderRadius(float f) {
            this.borderRadius = f * getResources().getDisplayMetrics().density;
            this.needBackgroundUpdate = true;
        }

        public final boolean getExclusive() {
            return this.exclusive;
        }

        public final void setExclusive(boolean z) {
            this.exclusive = z;
        }

        public final boolean isTouched() {
            return this.isTouched;
        }

        public final void setTouched(boolean z) {
            this.isTouched = z;
        }

        private final void withBackgroundUpdate(Function0<Unit> function0) {
            function0.invoke();
            this.needBackgroundUpdate = true;
        }

        public void setBackgroundColor(int i) {
            this._backgroundColor = i;
            this.needBackgroundUpdate = true;
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "ev");
            if (super.onInterceptTouchEvent(motionEvent)) {
                return true;
            }
            onTouchEvent(motionEvent);
            return isPressed();
        }

        public boolean onTouchEvent(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            if (motionEvent.getAction() == 3) {
                tryFreeingResponder();
            }
            long eventTime = motionEvent.getEventTime();
            int action = motionEvent.getAction();
            if (this.lastEventTime == eventTime && this.lastAction == action) {
                return false;
            }
            this.lastEventTime = eventTime;
            this.lastAction = action;
            return super.onTouchEvent(motionEvent);
        }

        public final void updateBackground() {
            if (this.needBackgroundUpdate) {
                this.needBackgroundUpdate = false;
                if (this._backgroundColor == 0) {
                    setBackground((Drawable) null);
                }
                if (Build.VERSION.SDK_INT >= 23) {
                    setForeground((Drawable) null);
                }
                Drawable createSelectableDrawable = createSelectableDrawable();
                if (!(this.borderRadius == 0.0f) && Build.VERSION.SDK_INT >= 21 && (createSelectableDrawable instanceof RippleDrawable)) {
                    PaintDrawable paintDrawable = new PaintDrawable(-1);
                    paintDrawable.setCornerRadius(this.borderRadius);
                    ((RippleDrawable) createSelectableDrawable).setDrawableByLayerId(16908334, paintDrawable);
                }
                if (this.useDrawableOnForeground && Build.VERSION.SDK_INT >= 23) {
                    setForeground(createSelectableDrawable);
                    int i = this._backgroundColor;
                    if (i != 0) {
                        setBackgroundColor(i);
                    }
                } else if (this._backgroundColor == 0 && this.rippleColor == null) {
                    setBackground(createSelectableDrawable);
                } else {
                    PaintDrawable paintDrawable2 = new PaintDrawable(this._backgroundColor);
                    float f = this.borderRadius;
                    if (!(f == 0.0f)) {
                        paintDrawable2.setCornerRadius(f);
                    }
                    setBackground(new LayerDrawable(createSelectableDrawable != null ? new Drawable[]{paintDrawable2, createSelectableDrawable} : (Drawable[]) new PaintDrawable[]{paintDrawable2}));
                }
            }
        }

        private final Drawable createSelectableDrawable() {
            ColorStateList colorStateList;
            if (Build.VERSION.SDK_INT < 21) {
                getContext().getTheme().resolveAttribute(16843534, resolveOutValue, true);
                return getResources().getDrawable(resolveOutValue.resourceId);
            }
            Integer num = this.rippleColor;
            if (num != null && num.intValue() == 0 && Build.VERSION.SDK_INT >= 33) {
                return null;
            }
            int[][] iArr = {new int[]{16842910}};
            Integer num2 = this.rippleRadius;
            Integer num3 = this.rippleColor;
            if (num3 != null) {
                Intrinsics.checkNotNull(num3);
                colorStateList = new ColorStateList(iArr, new int[]{num3.intValue()});
            } else {
                getContext().getTheme().resolveAttribute(16843820, resolveOutValue, true);
                colorStateList = new ColorStateList(iArr, new int[]{resolveOutValue.data});
            }
            RippleDrawable rippleDrawable = new RippleDrawable(colorStateList, (Drawable) null, this.useBorderlessDrawable ? null : new ShapeDrawable(new RectShape()));
            if (Build.VERSION.SDK_INT >= 23 && num2 != null) {
                rippleDrawable.setRadius((int) PixelUtil.toPixelFromDIP((float) num2.intValue()));
            }
            return rippleDrawable;
        }

        public void drawableHotspotChanged(float f, float f2) {
            ButtonViewGroup buttonViewGroup = touchResponder;
            if (buttonViewGroup == null || buttonViewGroup == this) {
                super.drawableHotspotChanged(f, f2);
            }
        }

        public boolean canBegin() {
            boolean tryGrabbingResponder = tryGrabbingResponder();
            if (tryGrabbingResponder) {
                this.isTouched = true;
            }
            return tryGrabbingResponder;
        }

        public void afterGestureEnd(MotionEvent motionEvent) {
            Intrinsics.checkNotNullParameter(motionEvent, "event");
            tryFreeingResponder();
            this.isTouched = false;
        }

        private final void tryFreeingResponder() {
            if (touchResponder == this) {
                touchResponder = null;
                soundResponder = this;
            }
        }

        private final boolean tryGrabbingResponder() {
            if (isChildTouched$default(this, (Sequence) null, 1, (Object) null)) {
                return false;
            }
            ButtonViewGroup buttonViewGroup = touchResponder;
            if (buttonViewGroup == null) {
                touchResponder = this;
                return true;
            }
            if (!this.exclusive) {
                if (!(buttonViewGroup != null ? buttonViewGroup.exclusive : false)) {
                    return true;
                }
            } else if (buttonViewGroup == this) {
                return true;
            }
            return false;
        }

        static /* synthetic */ boolean isChildTouched$default(ButtonViewGroup buttonViewGroup, Sequence<View> sequence, int i, Object obj) {
            if ((i & 1) != 0) {
                sequence = ViewGroupKt.getChildren(buttonViewGroup);
            }
            return buttonViewGroup.isChildTouched(sequence);
        }

        private final boolean isChildTouched(Sequence<? extends View> sequence) {
            for (View view : sequence) {
                if (view instanceof ButtonViewGroup) {
                    ButtonViewGroup buttonViewGroup = (ButtonViewGroup) view;
                    if (buttonViewGroup.isTouched || buttonViewGroup.isPressed()) {
                        return true;
                    }
                }
                if ((view instanceof ViewGroup) && isChildTouched(ViewGroupKt.getChildren((ViewGroup) view))) {
                    return true;
                }
            }
            return false;
        }

        public boolean performClick() {
            if (isChildTouched$default(this, (Sequence) null, 1, (Object) null) || !Intrinsics.areEqual((Object) soundResponder, (Object) this)) {
                return false;
            }
            tryFreeingResponder();
            soundResponder = null;
            return super.performClick();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
            if (isChildTouched$default(r3, (kotlin.sequences.Sequence) null, 1, (java.lang.Object) null) == false) goto L_0x0026;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void setPressed(boolean r4) {
            /*
                r3 = this;
                if (r4 == 0) goto L_0x000a
                boolean r0 = r3.tryGrabbingResponder()
                if (r0 == 0) goto L_0x000a
                soundResponder = r3
            L_0x000a:
                boolean r0 = r3.exclusive
                r1 = 1
                r2 = 0
                if (r0 != 0) goto L_0x0025
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = touchResponder
                if (r0 == 0) goto L_0x001a
                boolean r0 = r0.exclusive
                if (r0 != r1) goto L_0x001a
                r0 = r1
                goto L_0x001b
            L_0x001a:
                r0 = r2
            L_0x001b:
                if (r0 != 0) goto L_0x0025
                r0 = 0
                boolean r0 = isChildTouched$default(r3, r0, r1, r0)
                if (r0 != 0) goto L_0x0025
                goto L_0x0026
            L_0x0025:
                r1 = r2
            L_0x0026:
                if (r4 == 0) goto L_0x002e
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r0 = touchResponder
                if (r0 == r3) goto L_0x002e
                if (r1 == 0) goto L_0x0033
            L_0x002e:
                r3.isTouched = r4
                super.setPressed(r4)
            L_0x0033:
                if (r4 != 0) goto L_0x003b
                com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager$ButtonViewGroup r4 = touchResponder
                if (r4 != r3) goto L_0x003b
                r3.isTouched = r2
            L_0x003b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.swmansion.gesturehandler.react.RNGestureHandlerButtonViewManager.ButtonViewGroup.setPressed(boolean):void");
        }

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0012\"\u0004\b\u0017\u0010\u0014¨\u0006\u0018"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup$Companion;", "", "()V", "dummyClickListener", "Landroid/view/View$OnClickListener;", "getDummyClickListener", "()Landroid/view/View$OnClickListener;", "setDummyClickListener", "(Landroid/view/View$OnClickListener;)V", "resolveOutValue", "Landroid/util/TypedValue;", "getResolveOutValue", "()Landroid/util/TypedValue;", "setResolveOutValue", "(Landroid/util/TypedValue;)V", "soundResponder", "Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "getSoundResponder", "()Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;", "setSoundResponder", "(Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$ButtonViewGroup;)V", "touchResponder", "getTouchResponder", "setTouchResponder", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        /* compiled from: RNGestureHandlerButtonViewManager.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }

            public final TypedValue getResolveOutValue() {
                return ButtonViewGroup.resolveOutValue;
            }

            public final void setResolveOutValue(TypedValue typedValue) {
                Intrinsics.checkNotNullParameter(typedValue, "<set-?>");
                ButtonViewGroup.resolveOutValue = typedValue;
            }

            public final ButtonViewGroup getTouchResponder() {
                return ButtonViewGroup.touchResponder;
            }

            public final void setTouchResponder(ButtonViewGroup buttonViewGroup) {
                ButtonViewGroup.touchResponder = buttonViewGroup;
            }

            public final ButtonViewGroup getSoundResponder() {
                return ButtonViewGroup.soundResponder;
            }

            public final void setSoundResponder(ButtonViewGroup buttonViewGroup) {
                ButtonViewGroup.soundResponder = buttonViewGroup;
            }

            public final View.OnClickListener getDummyClickListener() {
                return ButtonViewGroup.dummyClickListener;
            }

            public final void setDummyClickListener(View.OnClickListener onClickListener) {
                Intrinsics.checkNotNullParameter(onClickListener, "<set-?>");
                ButtonViewGroup.dummyClickListener = onClickListener;
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/swmansion/gesturehandler/react/RNGestureHandlerButtonViewManager$Companion;", "", "()V", "REACT_CLASS", "", "react-native-gesture-handler_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: RNGestureHandlerButtonViewManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
