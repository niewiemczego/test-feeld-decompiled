package zendesk.ui.android.conversation.imagecell;

import android.content.Context;
import android.content.res.ColorStateList;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import coil.request.Disposable;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.imagecell.ImageRoundedCorner;
import zendesk.ui.android.conversation.textcell.TextCellView;
import zendesk.ui.android.internal.ColorExtKt;
import zendesk.ui.android.internal.DimensionExtKt;

@Metadata(d1 = {"\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 42\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u00014B%\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020\u0015H\u0002J \u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\u00152\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020%H\u0002J\b\u0010-\u001a\u00020\tH\u0002J\b\u0010.\u001a\u00020/H\u0014J\b\u00100\u001a\u00020/H\u0002J\u001c\u00101\u001a\u00020/2\u0012\u00102\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u000303H\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0019\u001a\u0004\u0018\u00010\u00188BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001e\u001a\u0004\u0018\u00010\u00188BX\u0002¢\u0006\f\n\u0004\b \u0010\u001d\u001a\u0004\b\u001f\u0010\u001bR\u000e\u0010!\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageCellView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/imagecell/ImageCellRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "cellRadius", "", "errorTextView", "Landroid/widget/TextView;", "imageLoaderDisposable", "Lcoil/request/Disposable;", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "imageViewOverlay", "isLayoutDirectionLtr", "", "rendering", "skeletonLoaderDrawable", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "skeletonLoaderInboundAnimation", "getSkeletonLoaderInboundAnimation", "()Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "skeletonLoaderInboundAnimation$delegate", "Lkotlin/Lazy;", "skeletonLoaderOutboundAnimation", "getSkeletonLoaderOutboundAnimation", "skeletonLoaderOutboundAnimation$delegate", "smallCellRadius", "textCellView", "Lzendesk/ui/android/conversation/textcell/TextCellView;", "buildShapeAppearanceModel", "Lcom/google/android/material/shape/ShapeAppearanceModel;", "isMessageTextViewVisible", "getImageBackground", "Lcom/google/android/material/shape/MaterialShapeDrawable;", "onStart", "state", "Lzendesk/ui/android/conversation/imagecell/ImageCellState;", "shapeAppearance", "getTextCellViewBackgroundResource", "onDetachedFromWindow", "", "populateAccessibilityNodeInfo", "render", "renderingUpdate", "Lkotlin/Function1;", "Companion", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCellView.kt */
public final class ImageCellView extends ConstraintLayout implements Renderer<ImageCellRendering> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final float DEFAULT_ALPHA = 1.0f;
    @Deprecated
    private static final float PENDING_ALPHA = 0.5f;
    @Deprecated
    private static final int ROUNDED_CORNER = 0;
    private final float cellRadius;
    /* access modifiers changed from: private */
    public final TextView errorTextView;
    private Disposable imageLoaderDisposable;
    /* access modifiers changed from: private */
    public final ShapeableImageView imageView;
    private final ShapeableImageView imageViewOverlay;
    private final boolean isLayoutDirectionLtr;
    /* access modifiers changed from: private */
    public ImageCellRendering rendering;
    private AnimatedVectorDrawableCompat skeletonLoaderDrawable;
    private final Lazy skeletonLoaderInboundAnimation$delegate;
    private final Lazy skeletonLoaderOutboundAnimation$delegate;
    private final float smallCellRadius;
    private final TextCellView textCellView;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageCellView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageCellDirection.values().length];
            iArr[ImageCellDirection.INBOUND_SINGLE.ordinal()] = 1;
            iArr[ImageCellDirection.INBOUND_BOTTOM.ordinal()] = 2;
            iArr[ImageCellDirection.INBOUND_TOP.ordinal()] = 3;
            iArr[ImageCellDirection.INBOUND_MIDDLE.ordinal()] = 4;
            iArr[ImageCellDirection.OUTBOUND_SINGLE.ordinal()] = 5;
            iArr[ImageCellDirection.OUTBOUND_BOTTOM.ordinal()] = 6;
            iArr[ImageCellDirection.OUTBOUND_TOP.ordinal()] = 7;
            iArr[ImageCellDirection.OUTBOUND_MIDDLE.ordinal()] = 8;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageCellView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageCellView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageCellView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageCellView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new ImageCellRendering();
        this.isLayoutDirectionLtr = getResources().getConfiguration().getLayoutDirection() == 0;
        this.skeletonLoaderInboundAnimation$delegate = LazyKt.lazy(new ImageCellView$skeletonLoaderInboundAnimation$2(context));
        this.skeletonLoaderOutboundAnimation$delegate = LazyKt.lazy(new ImageCellView$skeletonLoaderOutboundAnimation$2(context));
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_TextCellStyle, false);
        ConstraintLayout.inflate(context, R.layout.zuia_view_image_cell, this);
        View findViewById = findViewById(R.id.zuia_text_cell_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_text_cell_view)");
        this.textCellView = (TextCellView) findViewById;
        View findViewById2 = findViewById(R.id.zuia_image_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_image_view)");
        ShapeableImageView shapeableImageView = (ShapeableImageView) findViewById2;
        this.imageView = shapeableImageView;
        View findViewById3 = findViewById(R.id.zuia_image_view_overlay);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zuia_image_view_overlay)");
        this.imageViewOverlay = (ShapeableImageView) findViewById3;
        View findViewById4 = findViewById(R.id.zuia_error_text);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.zuia_error_text)");
        this.errorTextView = (TextView) findViewById4;
        this.cellRadius = (float) DimensionExtKt.resolveDimensionAttr(context, new int[]{R.attr.messageCellRadiusSize});
        this.smallCellRadius = (float) DimensionExtKt.resolveDimensionAttr(context, new int[]{R.attr.messageCellSmallRadiusSize});
        shapeableImageView.setContentDescription(getResources().getString(R.string.zuia_image_thumbnail_accessibility_label));
        populateAccessibilityNodeInfo();
        render(AnonymousClass1.INSTANCE);
    }

    private final AnimatedVectorDrawableCompat getSkeletonLoaderInboundAnimation() {
        return (AnimatedVectorDrawableCompat) this.skeletonLoaderInboundAnimation$delegate.getValue();
    }

    private final AnimatedVectorDrawableCompat getSkeletonLoaderOutboundAnimation() {
        return (AnimatedVectorDrawableCompat) this.skeletonLoaderOutboundAnimation$delegate.getValue();
    }

    private final void populateAccessibilityNodeInfo() {
        ViewCompat.setAccessibilityDelegate(this.imageView, new ImageCellView$populateAccessibilityNodeInfo$1(this));
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0051  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x009a  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x009c  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00b8  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0130  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0135  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x0151  */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x016e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x017d  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0190  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0198  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01b2  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x01c2  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x020f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(kotlin.jvm.functions.Function1<? super zendesk.ui.android.conversation.imagecell.ImageCellRendering, zendesk.ui.android.conversation.imagecell.ImageCellRendering> r15) {
        /*
            r14 = this;
            java.lang.String r0 = "renderingUpdate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
            zendesk.ui.android.conversation.imagecell.ImageCellRendering r0 = r14.rendering
            java.lang.Object r15 = r15.invoke(r0)
            zendesk.ui.android.conversation.imagecell.ImageCellRendering r15 = (zendesk.ui.android.conversation.imagecell.ImageCellRendering) r15
            r14.rendering = r15
            zendesk.ui.android.conversation.imagecell.ImageCellState r15 = r15.getState$zendesk_ui_ui_android()
            zendesk.ui.android.conversation.textcell.TextCellView r0 = r14.textCellView
            android.view.View r0 = (android.view.View) r0
            java.lang.String r1 = r15.getMessageText$zendesk_ui_ui_android()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r2 = 1
            r3 = 0
            if (r1 == 0) goto L_0x002a
            int r1 = r1.length()
            if (r1 != 0) goto L_0x0028
            goto L_0x002a
        L_0x0028:
            r1 = r3
            goto L_0x002b
        L_0x002a:
            r1 = r2
        L_0x002b:
            if (r1 == 0) goto L_0x004a
            zendesk.ui.android.conversation.imagecell.ImageCellRendering r1 = r14.rendering
            zendesk.ui.android.conversation.imagecell.ImageCellState r1 = r1.getState$zendesk_ui_ui_android()
            java.util.List r1 = r1.getActions$zendesk_ui_ui_android()
            java.util.Collection r1 = (java.util.Collection) r1
            if (r1 == 0) goto L_0x0044
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0042
            goto L_0x0044
        L_0x0042:
            r1 = r3
            goto L_0x0045
        L_0x0044:
            r1 = r2
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            goto L_0x004a
        L_0x0048:
            r1 = r3
            goto L_0x004b
        L_0x004a:
            r1 = r2
        L_0x004b:
            r4 = 8
            if (r1 == 0) goto L_0x0051
            r1 = r3
            goto L_0x0052
        L_0x0051:
            r1 = r4
        L_0x0052:
            r0.setVisibility(r1)
            zendesk.ui.android.conversation.textcell.TextCellView r0 = r14.textCellView
            android.view.View r0 = (android.view.View) r0
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0061
            r0 = r2
            goto L_0x0062
        L_0x0061:
            r0 = r3
        L_0x0062:
            if (r0 == 0) goto L_0x0078
            zendesk.ui.android.conversation.textcell.TextCellView r0 = r14.textCellView
            zendesk.ui.android.conversation.imagecell.ImageCellView$render$1$1 r1 = new zendesk.ui.android.conversation.imagecell.ImageCellView$render$1$1
            r1.<init>(r14, r15)
            kotlin.jvm.functions.Function1 r1 = (kotlin.jvm.functions.Function1) r1
            r0.render(r1)
            zendesk.ui.android.conversation.textcell.TextCellView r0 = r14.textCellView
            r1 = 8388611(0x800003, float:1.1754948E-38)
            r0.setMessageTextGravity$zendesk_ui_ui_android(r1)
        L_0x0078:
            android.widget.TextView r0 = r14.errorTextView
            java.lang.String r1 = r15.getErrorText$zendesk_ui_ui_android()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            android.content.Context r1 = r14.getContext()
            int r5 = zendesk.ui.android.R.color.zuia_color_red
            int r1 = androidx.core.content.ContextCompat.getColor(r1, r5)
            r0.<init>(r1)
            zendesk.ui.android.conversation.textcell.TextCellView r1 = r14.textCellView
            int r1 = r1.getVisibility()
            if (r1 != 0) goto L_0x009c
            r1 = r2
            goto L_0x009d
        L_0x009c:
            r1 = r3
        L_0x009d:
            com.google.android.material.shape.ShapeAppearanceModel r1 = r14.buildShapeAppearanceModel(r1)
            com.google.android.material.imageview.ShapeableImageView r5 = r14.imageView
            r5.setShapeAppearanceModel(r1)
            com.google.android.material.imageview.ShapeableImageView r5 = r14.imageViewOverlay
            r5.setShapeAppearanceModel(r1)
            java.lang.Integer r5 = r15.getBackgroundColor$zendesk_ui_ui_android()
            java.lang.String r6 = "context"
            if (r5 == 0) goto L_0x00b8
            int r5 = r5.intValue()
            goto L_0x00df
        L_0x00b8:
            zendesk.ui.android.conversation.imagecell.ImageCellDirection$Companion r5 = zendesk.ui.android.conversation.imagecell.ImageCellDirection.Companion
            zendesk.ui.android.conversation.imagecell.ImageCellDirection r7 = r15.getImageCellDirection$zendesk_ui_ui_android()
            boolean r5 = r5.isInbound(r7)
            if (r5 == 0) goto L_0x00d2
            android.content.Context r5 = r14.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            int r7 = zendesk.ui.android.R.attr.messageCellInboundBackgroundColor
            int r5 = zendesk.ui.android.internal.ColorExtKt.resolveColorAttr(r5, r7)
            goto L_0x00df
        L_0x00d2:
            android.content.Context r5 = r14.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)
            int r7 = zendesk.ui.android.R.attr.colorPrimary
            int r5 = zendesk.ui.android.internal.ColorExtKt.resolveColorAttr(r5, r7)
        L_0x00df:
            com.google.android.material.shape.MaterialShapeDrawable r9 = new com.google.android.material.shape.MaterialShapeDrawable
            r9.<init>((com.google.android.material.shape.ShapeAppearanceModel) r1)
            android.content.Context r7 = r14.getContext()
            int r8 = zendesk.ui.android.R.color.zuia_color_transparent
            int r7 = androidx.core.content.ContextCompat.getColor(r7, r8)
            android.content.res.ColorStateList r7 = android.content.res.ColorStateList.valueOf(r7)
            r9.setFillColor(r7)
            android.content.res.Resources r7 = r14.getResources()
            int r8 = zendesk.ui.android.R.dimen.zuia_inner_stroke_width
            float r7 = r7.getDimension(r8)
            r9.setStrokeWidth(r7)
            android.content.res.ColorStateList r7 = android.content.res.ColorStateList.valueOf(r5)
            r9.setStrokeColor(r7)
            android.graphics.drawable.ColorDrawable r13 = new android.graphics.drawable.ColorDrawable
            r13.<init>(r5)
            android.graphics.drawable.ColorDrawable r5 = new android.graphics.drawable.ColorDrawable
            android.content.Context r7 = r14.getContext()
            int r8 = zendesk.ui.android.R.color.zuia_color_red
            int r7 = androidx.core.content.ContextCompat.getColor(r7, r8)
            r8 = 1045220557(0x3e4ccccd, float:0.2)
            int r7 = zendesk.ui.android.internal.ColorExtKt.adjustAlpha(r7, r8)
            r5.<init>(r7)
            zendesk.ui.android.conversation.imagecell.ImageCellDirection$Companion r7 = zendesk.ui.android.conversation.imagecell.ImageCellDirection.Companion
            zendesk.ui.android.conversation.imagecell.ImageCellDirection r8 = r15.getImageCellDirection$zendesk_ui_ui_android()
            boolean r7 = r7.isInbound(r8)
            if (r7 == 0) goto L_0x0135
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r7 = r14.getSkeletonLoaderInboundAnimation()
            goto L_0x0139
        L_0x0135:
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r7 = r14.getSkeletonLoaderOutboundAnimation()
        L_0x0139:
            r14.skeletonLoaderDrawable = r7
            com.google.android.material.imageview.ShapeableImageView r8 = r14.imageView
            android.graphics.drawable.Drawable r7 = (android.graphics.drawable.Drawable) r7
            r8.setImageDrawable(r7)
            com.google.android.material.imageview.ShapeableImageView r7 = r14.imageView
            com.google.android.material.shape.MaterialShapeDrawable r1 = r14.getImageBackground(r2, r15, r1)
            android.graphics.drawable.Drawable r1 = (android.graphics.drawable.Drawable) r1
            r7.setBackground(r1)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r1 = r14.skeletonLoaderDrawable
            if (r1 == 0) goto L_0x0154
            r1.start()
        L_0x0154:
            com.google.android.material.imageview.ShapeableImageView r1 = r14.imageView
            r7 = 600(0x258, double:2.964E-321)
            zendesk.ui.android.conversation.imagecell.ImageCellView$render$1$2 r10 = new zendesk.ui.android.conversation.imagecell.ImageCellView$render$1$2
            r10.<init>(r15, r14)
            kotlin.jvm.functions.Function0 r10 = (kotlin.jvm.functions.Function0) r10
            zendesk.ui.android.internal.ThrottledOnClickListener r7 = zendesk.ui.android.internal.ThrottledOnClickListenerKt.throttledOnClickListener(r7, r10)
            android.view.View$OnClickListener r7 = (android.view.View.OnClickListener) r7
            r1.setOnClickListener(r7)
            boolean r1 = r15.isError$zendesk_ui_ui_android()
            if (r1 == 0) goto L_0x017d
            com.google.android.material.imageview.ShapeableImageView r1 = r14.imageViewOverlay
            android.view.View r1 = (android.view.View) r1
            r1.setVisibility(r3)
            com.google.android.material.imageview.ShapeableImageView r1 = r14.imageViewOverlay
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
            r1.setImageDrawable(r5)
            goto L_0x018a
        L_0x017d:
            com.google.android.material.imageview.ShapeableImageView r1 = r14.imageViewOverlay
            android.view.View r1 = (android.view.View) r1
            r1.setVisibility(r4)
            com.google.android.material.imageview.ShapeableImageView r1 = r14.imageViewOverlay
            r4 = 0
            r1.setImageDrawable(r4)
        L_0x018a:
            boolean r1 = r15.isPending$zendesk_ui_ui_android()
            if (r1 == 0) goto L_0x0198
            com.google.android.material.imageview.ShapeableImageView r1 = r14.imageView
            r4 = 1056964608(0x3f000000, float:0.5)
            r1.setAlpha(r4)
            goto L_0x019f
        L_0x0198:
            com.google.android.material.imageview.ShapeableImageView r1 = r14.imageView
            r4 = 1065353216(0x3f800000, float:1.0)
            r1.setAlpha(r4)
        L_0x019f:
            zendesk.ui.android.internal.ImageLoaderFactory r1 = zendesk.ui.android.internal.ImageLoaderFactory.INSTANCE
            android.content.Context r4 = r14.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r6)
            coil.ImageLoader r1 = r1.getImageLoader(r4)
            android.net.Uri r4 = r15.getLocalUri$zendesk_ui_ui_android()
            if (r4 != 0) goto L_0x01b6
            android.net.Uri r4 = r15.getUri$zendesk_ui_ui_android()
        L_0x01b6:
            zendesk.ui.android.conversation.imagecell.ImageType$Companion r5 = zendesk.ui.android.conversation.imagecell.ImageType.Companion
            java.lang.String r15 = r15.getImageType$zendesk_ui_ui_android()
            boolean r15 = r5.isSupported(r15)
            if (r15 == 0) goto L_0x020f
            coil.request.ImageRequest$Builder r15 = new coil.request.ImageRequest$Builder
            android.content.Context r0 = r14.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r6)
            r15.<init>((android.content.Context) r0)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r0 = r14.skeletonLoaderDrawable
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            coil.request.ImageRequest$Builder r15 = r15.fallback((android.graphics.drawable.Drawable) r0)
            androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat r0 = r14.skeletonLoaderDrawable
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            coil.request.ImageRequest$Builder r15 = r15.placeholder((android.graphics.drawable.Drawable) r0)
            zendesk.ui.android.conversation.imagecell.ImageCellView$render$lambda-5$$inlined$listener$1 r0 = new zendesk.ui.android.conversation.imagecell.ImageCellView$render$lambda-5$$inlined$listener$1
            r7 = r0
            r8 = r14
            r10 = r14
            r11 = r14
            r12 = r14
            r7.<init>(r8, r9, r10, r11, r12)
            coil.request.ImageRequest$Listener r0 = (coil.request.ImageRequest.Listener) r0
            coil.request.ImageRequest$Builder r15 = r15.listener(r0)
            android.graphics.drawable.Drawable r13 = (android.graphics.drawable.Drawable) r13
            coil.request.ImageRequest$Builder r15 = r15.placeholder((android.graphics.drawable.Drawable) r13)
            coil.request.ImageRequest$Builder r15 = r15.crossfade((boolean) r2)
            coil.request.ImageRequest$Builder r15 = r15.data(r4)
            com.google.android.material.imageview.ShapeableImageView r0 = r14.imageView
            android.widget.ImageView r0 = (android.widget.ImageView) r0
            coil.request.ImageRequest$Builder r15 = r15.target((android.widget.ImageView) r0)
            coil.request.ImageRequest r15 = r15.build()
            coil.request.Disposable r15 = r1.enqueue(r15)
            r14.imageLoaderDisposable = r15
            goto L_0x0224
        L_0x020f:
            com.google.android.material.imageview.ShapeableImageView r15 = r14.imageView
            android.graphics.drawable.Drawable r9 = (android.graphics.drawable.Drawable) r9
            r15.setBackground(r9)
            com.google.android.material.imageview.ShapeableImageView r15 = r14.imageView
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r15.setImageDrawable(r0)
            android.widget.TextView r15 = r14.errorTextView
            android.view.View r15 = (android.view.View) r15
            r15.setVisibility(r3)
        L_0x0224:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.imagecell.ImageCellView.render(kotlin.jvm.functions.Function1):void");
    }

    private final ShapeAppearanceModel buildShapeAppearanceModel(boolean z) {
        ShapeAppearanceModel.Builder builder;
        ImageRoundedCorner build = new ImageRoundedCorner.Builder(this.cellRadius, this.smallCellRadius, this.rendering.getState$zendesk_ui_ui_android().getImageCellDirection$zendesk_ui_ui_android(), this.isLayoutDirectionLtr).build();
        ShapeAppearanceModel.Builder topRightCorner = new ShapeAppearanceModel().toBuilder().setTopLeftCorner(0, build.getTopLeft()).setTopRightCorner(0, build.getTopRight());
        Intrinsics.checkNotNullExpressionValue(topRightCorner, "ShapeAppearanceModel().t…geRoundedCorner.topRight)");
        if (z) {
            builder = topRightCorner.setBottomRightCorner(0, 0.0f).setBottomLeftCorner(0, 0.0f);
        } else {
            builder = topRightCorner.setBottomRightCorner(0, build.getBottomRight()).setBottomLeftCorner(0, build.getBottomLeft());
        }
        ShapeAppearanceModel build2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(build2, "if (isMessageTextViewVis…omLeft)\n        }.build()");
        return build2;
    }

    /* access modifiers changed from: private */
    public final int getTextCellViewBackgroundResource() {
        switch (WhenMappings.$EnumSwitchMapping$0[this.rendering.getState$zendesk_ui_ui_android().getImageCellDirection$zendesk_ui_ui_android().ordinal()]) {
            case 1:
            case 2:
                return R.drawable.zuia_image_cell_message_inbound_shape_single;
            case 3:
            case 4:
                return R.drawable.zuia_image_cell_message_inbound_shape_middle;
            case 5:
            case 6:
                return R.drawable.zuia_image_cell_message_outbound_shape_single;
            case 7:
            case 8:
                return R.drawable.zuia_image_cell_message_outbound_shape_middle;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    private final MaterialShapeDrawable getImageBackground(boolean z, ImageCellState imageCellState, ShapeAppearanceModel shapeAppearanceModel) {
        int i;
        int i2;
        Integer backgroundColor$zendesk_ui_ui_android = imageCellState.getBackgroundColor$zendesk_ui_ui_android();
        if (backgroundColor$zendesk_ui_ui_android != null) {
            i = backgroundColor$zendesk_ui_ui_android.intValue();
        } else if (ImageCellDirection.Companion.isInbound(imageCellState.getImageCellDirection$zendesk_ui_ui_android())) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = ColorExtKt.resolveColorAttr(context, R.attr.messageCellInboundBackgroundColor);
        } else {
            Context context2 = getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            i = ColorExtKt.resolveColorAttr(context2, R.attr.colorPrimary);
        }
        if (z) {
            i2 = i;
        } else {
            i2 = ContextCompat.getColor(getContext(), R.color.zuia_color_transparent);
        }
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        materialShapeDrawable.setFillColor(ColorStateList.valueOf(i2));
        if (!z) {
            materialShapeDrawable.setStrokeWidth(getResources().getDimension(R.dimen.zuia_inner_stroke_width));
            materialShapeDrawable.setStrokeColor(ColorStateList.valueOf(i));
        }
        return materialShapeDrawable;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.imageLoaderDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = this.skeletonLoaderDrawable;
        if (animatedVectorDrawableCompat != null) {
            animatedVectorDrawableCompat.stop();
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageCellView$Companion;", "", "()V", "DEFAULT_ALPHA", "", "PENDING_ALPHA", "ROUNDED_CORNER", "", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageCellView.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
