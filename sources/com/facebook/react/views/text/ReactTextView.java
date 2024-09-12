package com.facebook.react.views.text;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Layout;
import android.text.Spannable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.view.MotionEvent;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.TintContextWrapper;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.ViewCompat;
import androidx.customview.widget.ExploreByTouchHelper;
import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.ReactConstants;
import com.facebook.react.uimanager.PixelUtil;
import com.facebook.react.uimanager.ReactCompoundView;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.view.ReactViewBackgroundManager;
import com.google.firebase.analytics.FirebaseAnalytics;

public class ReactTextView extends AppCompatTextView implements ReactCompoundView {
    private static final ViewGroup.LayoutParams EMPTY_LAYOUT_PARAMS = new ViewGroup.LayoutParams(0, 0);
    private boolean mAdjustsFontSizeToFit;
    private boolean mContainsImages;
    private final int mDefaultGravityHorizontal = getGravityHorizontal();
    private final int mDefaultGravityVertical = (getGravity() & 112);
    private TextUtils.TruncateAt mEllipsizeLocation;
    private int mLinkifyMaskType;
    private boolean mNotifyOnInlineViewLayout;
    private int mNumberOfLines;
    private ReactViewBackgroundManager mReactBackgroundManager;
    private Spannable mSpanned;
    private boolean mTextIsSelectable;

    public boolean hasOverlappingRendering() {
        return false;
    }

    public ReactTextView(Context context) {
        super(context);
        initView();
    }

    private void initView() {
        ReactViewBackgroundManager reactViewBackgroundManager = this.mReactBackgroundManager;
        if (reactViewBackgroundManager != null) {
            reactViewBackgroundManager.cleanup();
        }
        this.mReactBackgroundManager = new ReactViewBackgroundManager(this);
        this.mNumberOfLines = Integer.MAX_VALUE;
        this.mAdjustsFontSizeToFit = false;
        this.mLinkifyMaskType = 0;
        this.mNotifyOnInlineViewLayout = false;
        this.mTextIsSelectable = false;
        this.mEllipsizeLocation = TextUtils.TruncateAt.END;
        this.mSpanned = null;
    }

    /* access modifiers changed from: package-private */
    public void recycleView() {
        initView();
        if (Build.VERSION.SDK_INT >= 23) {
            setBreakStrategy(0);
        }
        setMovementMethod(getDefaultMovementMethod());
        if (Build.VERSION.SDK_INT >= 26) {
            setJustificationMode(0);
        }
        setLayoutParams(EMPTY_LAYOUT_PARAMS);
        super.setText((CharSequence) null);
        setGravityHorizontal(this.mDefaultGravityHorizontal);
        setGravityVertical(this.mDefaultGravityVertical);
        setNumberOfLines(this.mNumberOfLines);
        setAdjustFontSizeToFit(this.mAdjustsFontSizeToFit);
        setLinkifyMask(this.mLinkifyMaskType);
        setTextIsSelectable(this.mTextIsSelectable);
        setIncludeFontPadding(true);
        setEnabled(true);
        setLinkifyMask(0);
        setEllipsizeLocation(this.mEllipsizeLocation);
        setEnabled(true);
        if (Build.VERSION.SDK_INT >= 26) {
            setFocusable(16);
        }
        if (Build.VERSION.SDK_INT >= 23) {
            setHyphenationFrequency(0);
        }
        updateView();
    }

    private static WritableMap inlineViewJson(int i, int i2, int i3, int i4, int i5, int i6) {
        WritableMap createMap = Arguments.createMap();
        if (i == 8) {
            createMap.putString("visibility", "gone");
            createMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
        } else if (i == 0) {
            createMap.putString("visibility", ViewProps.VISIBLE);
            createMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
            createMap.putDouble("left", (double) PixelUtil.toDIPFromPixel((float) i3));
            createMap.putDouble("top", (double) PixelUtil.toDIPFromPixel((float) i4));
            createMap.putDouble("right", (double) PixelUtil.toDIPFromPixel((float) i5));
            createMap.putDouble(ViewProps.BOTTOM, (double) PixelUtil.toDIPFromPixel((float) i6));
        } else {
            createMap.putString("visibility", "unknown");
            createMap.putInt(FirebaseAnalytics.Param.INDEX, i2);
        }
        return createMap;
    }

    private ReactContext getReactContext() {
        Context context = getContext();
        if (context instanceof TintContextWrapper) {
            return (ReactContext) ((TintContextWrapper) context).getBaseContext();
        }
        return (ReactContext) context;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00e3, code lost:
        if (r5 != false) goto L_0x00e5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e8  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00ed  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0109  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010c  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x011a  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x014c A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r23, int r24, int r25, int r26, int r27) {
        /*
            r22 = this;
            r0 = r22
            int r1 = r22.getId()
            java.lang.CharSequence r2 = r22.getText()
            boolean r2 = r2 instanceof android.text.Spanned
            if (r2 == 0) goto L_0x018f
            int r2 = com.facebook.react.uimanager.common.ViewUtil.getUIManagerType(r1)
            r3 = 2
            if (r2 != r3) goto L_0x0017
            goto L_0x018f
        L_0x0017:
            com.facebook.react.bridge.ReactContext r2 = r22.getReactContext()
            java.lang.Class<com.facebook.react.uimanager.UIManagerModule> r3 = com.facebook.react.uimanager.UIManagerModule.class
            com.facebook.react.bridge.NativeModule r2 = r2.getNativeModule(r3)
            com.facebook.react.uimanager.UIManagerModule r2 = (com.facebook.react.uimanager.UIManagerModule) r2
            java.lang.Object r2 = com.facebook.infer.annotation.Assertions.assertNotNull(r2)
            com.facebook.react.uimanager.UIManagerModule r2 = (com.facebook.react.uimanager.UIManagerModule) r2
            java.lang.CharSequence r3 = r22.getText()
            android.text.Spanned r3 = (android.text.Spanned) r3
            android.text.Layout r4 = r22.getLayout()
            if (r4 != 0) goto L_0x0036
            return
        L_0x0036:
            int r5 = r3.length()
            java.lang.Class<com.facebook.react.views.text.TextInlineViewPlaceholderSpan> r6 = com.facebook.react.views.text.TextInlineViewPlaceholderSpan.class
            r7 = 0
            java.lang.Object[] r5 = r3.getSpans(r7, r5, r6)
            com.facebook.react.views.text.TextInlineViewPlaceholderSpan[] r5 = (com.facebook.react.views.text.TextInlineViewPlaceholderSpan[]) r5
            boolean r6 = r0.mNotifyOnInlineViewLayout
            if (r6 == 0) goto L_0x004e
            java.util.ArrayList r6 = new java.util.ArrayList
            int r8 = r5.length
            r6.<init>(r8)
            goto L_0x004f
        L_0x004e:
            r6 = 0
        L_0x004f:
            int r8 = r26 - r24
            int r9 = r27 - r25
            int r10 = r5.length
            r11 = r7
        L_0x0055:
            if (r11 >= r10) goto L_0x0157
            r12 = r5[r11]
            int r13 = r12.getReactTag()
            android.view.View r13 = r2.resolveView(r13)
            int r15 = r3.getSpanStart(r12)
            int r14 = r4.getLineForOffset(r15)
            int r16 = r4.getEllipsisCount(r14)
            r17 = 1
            if (r16 <= 0) goto L_0x0074
            r16 = r17
            goto L_0x0076
        L_0x0074:
            r16 = r7
        L_0x0076:
            if (r16 == 0) goto L_0x0084
            int r16 = r4.getLineStart(r14)
            int r18 = r4.getEllipsisStart(r14)
            int r7 = r16 + r18
            if (r15 >= r7) goto L_0x012c
        L_0x0084:
            int r7 = r0.mNumberOfLines
            if (r14 >= r7) goto L_0x012c
            int r7 = r4.getLineEnd(r14)
            if (r15 < r7) goto L_0x0090
            goto L_0x012c
        L_0x0090:
            int r7 = r12.getWidth()
            int r12 = r12.getHeight()
            r20 = r5
            boolean r5 = r4.isRtlCharAt(r15)
            r27 = r10
            int r10 = r4.getParagraphDirection(r14)
            r21 = r1
            r1 = -1
            if (r10 != r1) goto L_0x00ac
            r1 = r17
            goto L_0x00ad
        L_0x00ac:
            r1 = 0
        L_0x00ad:
            int r10 = r3.length()
            int r10 = r10 + -1
            if (r15 != r10) goto L_0x00c5
            if (r1 == 0) goto L_0x00bf
            float r1 = r4.getLineWidth(r14)
            int r1 = (int) r1
            int r1 = r8 - r1
            goto L_0x00e6
        L_0x00bf:
            float r1 = r4.getLineRight(r14)
            int r1 = (int) r1
            goto L_0x00e5
        L_0x00c5:
            if (r1 != r5) goto L_0x00ca
            r10 = r17
            goto L_0x00cb
        L_0x00ca:
            r10 = 0
        L_0x00cb:
            if (r10 == 0) goto L_0x00d2
            float r10 = r4.getPrimaryHorizontal(r15)
            goto L_0x00d6
        L_0x00d2:
            float r10 = r4.getSecondaryHorizontal(r15)
        L_0x00d6:
            int r10 = (int) r10
            if (r1 == 0) goto L_0x00e2
            float r1 = r4.getLineRight(r14)
            int r1 = (int) r1
            int r1 = r1 - r10
            int r1 = r8 - r1
            goto L_0x00e3
        L_0x00e2:
            r1 = r10
        L_0x00e3:
            if (r5 == 0) goto L_0x00e6
        L_0x00e5:
            int r1 = r1 - r7
        L_0x00e6:
            if (r5 == 0) goto L_0x00ed
            int r5 = r22.getTotalPaddingRight()
            goto L_0x00f1
        L_0x00ed:
            int r5 = r22.getTotalPaddingLeft()
        L_0x00f1:
            int r1 = r1 + r5
            int r5 = r24 + r1
            int r10 = r22.getTotalPaddingTop()
            int r14 = r4.getLineBaseline(r14)
            int r10 = r10 + r14
            int r10 = r10 - r12
            int r14 = r25 + r10
            if (r8 <= r1) goto L_0x0107
            if (r9 > r10) goto L_0x0105
            goto L_0x0107
        L_0x0105:
            r17 = 0
        L_0x0107:
            if (r17 == 0) goto L_0x010c
            r1 = 8
            goto L_0x010d
        L_0x010c:
            r1 = 0
        L_0x010d:
            int r7 = r7 + r5
            int r10 = r14 + r12
            r13.setVisibility(r1)
            r13.layout(r5, r14, r7, r10)
            boolean r12 = r0.mNotifyOnInlineViewLayout
            if (r12 == 0) goto L_0x014c
            r12 = r14
            r14 = r1
            r16 = r5
            r17 = r12
            r18 = r7
            r19 = r10
            com.facebook.react.bridge.WritableMap r1 = inlineViewJson(r14, r15, r16, r17, r18, r19)
            r6.add(r1)
            goto L_0x014c
        L_0x012c:
            r21 = r1
            r20 = r5
            r27 = r10
            r1 = 8
            r13.setVisibility(r1)
            boolean r1 = r0.mNotifyOnInlineViewLayout
            if (r1 == 0) goto L_0x014c
            r14 = 8
            r16 = -1
            r17 = -1
            r18 = -1
            r19 = -1
            com.facebook.react.bridge.WritableMap r1 = inlineViewJson(r14, r15, r16, r17, r18, r19)
            r6.add(r1)
        L_0x014c:
            int r11 = r11 + 1
            r10 = r27
            r5 = r20
            r1 = r21
            r7 = 0
            goto L_0x0055
        L_0x0157:
            r21 = r1
            boolean r1 = r0.mNotifyOnInlineViewLayout
            if (r1 == 0) goto L_0x018f
            com.facebook.react.views.text.ReactTextView$1 r1 = new com.facebook.react.views.text.ReactTextView$1
            r1.<init>()
            java.util.Collections.sort(r6, r1)
            com.facebook.react.bridge.WritableArray r1 = com.facebook.react.bridge.Arguments.createArray()
            java.util.Iterator r3 = r6.iterator()
        L_0x016d:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x017d
            java.lang.Object r4 = r3.next()
            com.facebook.react.bridge.WritableMap r4 = (com.facebook.react.bridge.WritableMap) r4
            r1.pushMap(r4)
            goto L_0x016d
        L_0x017d:
            com.facebook.react.bridge.WritableMap r3 = com.facebook.react.bridge.Arguments.createMap()
            java.lang.String r4 = "inlineViews"
            r3.putArray(r4, r1)
            if (r2 == 0) goto L_0x018f
            java.lang.String r1 = "topInlineViewLayout"
            r4 = r21
            r2.receiveEvent(r4, r1, r3)
        L_0x018f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.react.views.text.ReactTextView.onLayout(boolean, int, int, int, int):void");
    }

    public void setText(ReactTextUpdate reactTextUpdate) {
        int i;
        this.mContainsImages = reactTextUpdate.containsImages();
        if (getLayoutParams() == null) {
            setLayoutParams(EMPTY_LAYOUT_PARAMS);
        }
        Spannable text = reactTextUpdate.getText();
        int i2 = this.mLinkifyMaskType;
        if (i2 > 0) {
            Linkify.addLinks(text, i2);
            setMovementMethod(LinkMovementMethod.getInstance());
        }
        setText(text);
        float paddingLeft = reactTextUpdate.getPaddingLeft();
        float paddingTop = reactTextUpdate.getPaddingTop();
        float paddingRight = reactTextUpdate.getPaddingRight();
        float paddingBottom = reactTextUpdate.getPaddingBottom();
        if (!(paddingLeft == -1.0f || paddingBottom == -1.0f || paddingRight == -1.0f || i == 0)) {
            setPadding((int) Math.floor((double) paddingLeft), (int) Math.floor((double) paddingTop), (int) Math.floor((double) paddingRight), (int) Math.floor((double) paddingBottom));
        }
        int textAlign = reactTextUpdate.getTextAlign();
        if (textAlign != getGravityHorizontal()) {
            setGravityHorizontal(textAlign);
        }
        if (Build.VERSION.SDK_INT >= 23 && getBreakStrategy() != reactTextUpdate.getTextBreakStrategy()) {
            setBreakStrategy(reactTextUpdate.getTextBreakStrategy());
        }
        if (Build.VERSION.SDK_INT >= 26 && getJustificationMode() != reactTextUpdate.getJustificationMode()) {
            setJustificationMode(reactTextUpdate.getJustificationMode());
        }
        requestLayout();
    }

    public int reactTagForTouch(float f, float f2) {
        int i;
        CharSequence text = getText();
        int id = getId();
        int i2 = (int) f;
        int i3 = (int) f2;
        Layout layout = getLayout();
        if (layout == null) {
            return id;
        }
        int lineForVertical = layout.getLineForVertical(i3);
        int lineLeft = (int) layout.getLineLeft(lineForVertical);
        int lineRight = (int) layout.getLineRight(lineForVertical);
        if ((text instanceof Spanned) && i2 >= lineLeft && i2 <= lineRight) {
            Spanned spanned = (Spanned) text;
            try {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, (float) i2);
                ReactTagSpan[] reactTagSpanArr = (ReactTagSpan[]) spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ReactTagSpan.class);
                if (reactTagSpanArr != null) {
                    int length = text.length();
                    for (int i4 = 0; i4 < reactTagSpanArr.length; i4++) {
                        int spanStart = spanned.getSpanStart(reactTagSpanArr[i4]);
                        int spanEnd = spanned.getSpanEnd(reactTagSpanArr[i4]);
                        if (spanEnd >= offsetForHorizontal && (i = spanEnd - spanStart) <= length) {
                            id = reactTagSpanArr[i4].getReactTag();
                            length = i;
                        }
                    }
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                FLog.e(ReactConstants.TAG, "Crash in HorizontalMeasurementProvider: " + e.getMessage());
            }
        }
        return id;
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    return true;
                }
            }
        }
        return super.verifyDrawable(drawable);
    }

    public void invalidateDrawable(Drawable drawable) {
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan drawable2 : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                if (drawable2.getDrawable() == drawable) {
                    invalidate();
                }
            }
        }
        super.invalidateDrawable(drawable);
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onDetachedFromWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onDetachedFromWindow.onDetachedFromWindow();
            }
        }
    }

    public void onStartTemporaryDetach() {
        super.onStartTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onStartTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onStartTemporaryDetach.onStartTemporaryDetach();
            }
        }
    }

    public void setTextIsSelectable(boolean z) {
        this.mTextIsSelectable = z;
        super.setTextIsSelectable(z);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        setTextIsSelectable(this.mTextIsSelectable);
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onAttachedToWindow : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onAttachedToWindow.onAttachedToWindow();
            }
        }
    }

    public void onFinishTemporaryDetach() {
        super.onFinishTemporaryDetach();
        if (this.mContainsImages && (getText() instanceof Spanned)) {
            Spanned spanned = (Spanned) getText();
            for (TextInlineImageSpan onFinishTemporaryDetach : (TextInlineImageSpan[]) spanned.getSpans(0, spanned.length(), TextInlineImageSpan.class)) {
                onFinishTemporaryDetach.onFinishTemporaryDetach();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public int getGravityHorizontal() {
        return getGravity() & GravityCompat.RELATIVE_HORIZONTAL_GRAVITY_MASK;
    }

    /* access modifiers changed from: package-private */
    public void setGravityHorizontal(int i) {
        if (i == 0) {
            i = this.mDefaultGravityHorizontal;
        }
        setGravity(i | (getGravity() & -8 & -8388616));
    }

    /* access modifiers changed from: package-private */
    public void setGravityVertical(int i) {
        if (i == 0) {
            i = this.mDefaultGravityVertical;
        }
        setGravity(i | (getGravity() & -113));
    }

    public void setNumberOfLines(int i) {
        if (i == 0) {
            i = Integer.MAX_VALUE;
        }
        this.mNumberOfLines = i;
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        setSingleLine(z);
        setMaxLines(this.mNumberOfLines);
    }

    public void setAdjustFontSizeToFit(boolean z) {
        this.mAdjustsFontSizeToFit = z;
    }

    public void setEllipsizeLocation(TextUtils.TruncateAt truncateAt) {
        this.mEllipsizeLocation = truncateAt;
    }

    public void setNotifyOnInlineViewLayout(boolean z) {
        this.mNotifyOnInlineViewLayout = z;
    }

    public void updateView() {
        setEllipsize((this.mNumberOfLines == Integer.MAX_VALUE || this.mAdjustsFontSizeToFit) ? null : this.mEllipsizeLocation);
    }

    public void setBackgroundColor(int i) {
        this.mReactBackgroundManager.setBackgroundColor(i);
    }

    public void setBorderWidth(int i, float f) {
        this.mReactBackgroundManager.setBorderWidth(i, f);
    }

    public void setBorderColor(int i, float f, float f2) {
        this.mReactBackgroundManager.setBorderColor(i, f, f2);
    }

    public void setBorderRadius(float f) {
        this.mReactBackgroundManager.setBorderRadius(f);
    }

    public void setBorderRadius(float f, int i) {
        this.mReactBackgroundManager.setBorderRadius(f, i);
    }

    public void setBorderStyle(String str) {
        this.mReactBackgroundManager.setBorderStyle(str);
    }

    public void setSpanned(Spannable spannable) {
        this.mSpanned = spannable;
    }

    public Spannable getSpanned() {
        return this.mSpanned;
    }

    public void setLinkifyMask(int i) {
        this.mLinkifyMaskType = i;
    }

    /* access modifiers changed from: protected */
    public boolean dispatchHoverEvent(MotionEvent motionEvent) {
        if (ViewCompat.hasAccessibilityDelegate(this)) {
            AccessibilityDelegateCompat accessibilityDelegate = ViewCompat.getAccessibilityDelegate(this);
            if (accessibilityDelegate instanceof ExploreByTouchHelper) {
                return ((ExploreByTouchHelper) accessibilityDelegate).dispatchHoverEvent(motionEvent) || super.dispatchHoverEvent(motionEvent);
            }
        }
        return super.dispatchHoverEvent(motionEvent);
    }
}
