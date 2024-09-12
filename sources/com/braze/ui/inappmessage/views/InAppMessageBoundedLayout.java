package com.braze.ui.inappmessage.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import com.braze.ui.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0010\u001a\u00020\tH\u0014R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/braze/ui/inappmessage/views/InAppMessageBoundedLayout;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "maxDefinedHeightPixels", "", "maxDefinedWidthPixels", "minDefinedHeightPixels", "minDefinedWidthPixels", "onMeasure", "", "widthMeasureSpec", "heightMeasureSpec", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: InAppMessageBoundedLayout.kt */
public class InAppMessageBoundedLayout extends RelativeLayout {
    private int maxDefinedHeightPixels;
    private int maxDefinedWidthPixels;
    private int minDefinedHeightPixels;
    private int minDefinedWidthPixels;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageBoundedLayout(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public InAppMessageBoundedLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.InAppMessageBoundedLayout);
        Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…nAppMessageBoundedLayout)");
        this.maxDefinedWidthPixels = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMaxWidth, 0);
        this.minDefinedWidthPixels = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMinWidth, 0);
        this.maxDefinedHeightPixels = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMaxHeight, 0);
        this.minDefinedHeightPixels = obtainStyledAttributes.getDimensionPixelSize(R.styleable.InAppMessageBoundedLayout_inAppMessageBoundedLayoutMinHeight, 0);
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int i3 = this.minDefinedWidthPixels;
        if (i3 <= 0 || size >= i3) {
            int i4 = this.maxDefinedWidthPixels;
            if (i4 > 0 && size > i4) {
                i = View.MeasureSpec.makeMeasureSpec(this.maxDefinedWidthPixels, View.MeasureSpec.getMode(i));
            }
        } else {
            i = View.MeasureSpec.makeMeasureSpec(this.minDefinedWidthPixels, View.MeasureSpec.getMode(i));
        }
        int size2 = View.MeasureSpec.getSize(i2);
        int i5 = this.minDefinedHeightPixels;
        if (i5 <= 0 || size2 >= i5) {
            int i6 = this.maxDefinedHeightPixels;
            if (i6 > 0 && size2 > i6) {
                i2 = View.MeasureSpec.makeMeasureSpec(this.maxDefinedHeightPixels, View.MeasureSpec.getMode(i2));
            }
        } else {
            i2 = View.MeasureSpec.makeMeasureSpec(this.minDefinedHeightPixels, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }
}
