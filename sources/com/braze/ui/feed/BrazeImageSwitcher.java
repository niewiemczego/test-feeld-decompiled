package com.braze.ui.feed;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.ImageSwitcher;
import com.braze.support.BrazeLogger;
import com.braze.ui.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR(\u0010\u000e\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@GX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\r¨\u0006\u0011"}, d2 = {"Lcom/braze/ui/feed/BrazeImageSwitcher;", "Landroid/widget/ImageSwitcher;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "<set-?>", "Landroid/graphics/drawable/Drawable;", "readIcon", "getReadIcon", "()Landroid/graphics/drawable/Drawable;", "setReadIcon", "(Landroid/graphics/drawable/Drawable;)V", "unReadIcon", "getUnReadIcon", "setUnReadIcon", "android-sdk-ui_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: BrazeImageSwitcher.kt */
public final class BrazeImageSwitcher extends ImageSwitcher {
    private Drawable readIcon;
    private Drawable unReadIcon;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BrazeImageSwitcher(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Drawable drawable;
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.com_braze_ui_feed_BrazeImageSwitcher);
            Intrinsics.checkNotNullExpressionValue(obtainStyledAttributes, "context.obtainStyledAttr…_feed_BrazeImageSwitcher)");
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == R.styleable.com_braze_ui_feed_BrazeImageSwitcher_brazeFeedCustomReadIcon) {
                    Drawable drawable2 = obtainStyledAttributes.getDrawable(index);
                    if (drawable2 != null) {
                        this.readIcon = drawable2;
                    }
                } else if (obtainStyledAttributes.getIndex(i) == R.styleable.com_braze_ui_feed_BrazeImageSwitcher_brazeFeedCustomUnReadIcon && (drawable = obtainStyledAttributes.getDrawable(index)) != null) {
                    this.unReadIcon = drawable;
                }
            }
            obtainStyledAttributes.recycle();
        } catch (Exception e) {
            BrazeLogger.INSTANCE.brazelog((Object) this, BrazeLogger.Priority.W, (Throwable) e, (Function0<String>) AnonymousClass1.INSTANCE);
        }
    }

    public final Drawable getReadIcon() {
        return this.readIcon;
    }

    public final void setReadIcon(Drawable drawable) {
        this.readIcon = drawable;
    }

    public final Drawable getUnReadIcon() {
        return this.unReadIcon;
    }

    public final void setUnReadIcon(Drawable drawable) {
        this.unReadIcon = drawable;
    }
}
