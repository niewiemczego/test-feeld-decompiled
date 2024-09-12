package zendesk.ui.android.conversation.avatar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.core.content.res.ResourcesCompat;
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat;
import coil.ImageLoader;
import coil.request.Disposable;
import coil.request.Gifs;
import coil.request.ImageRequest;
import com.google.android.material.imageview.ShapeableImageView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.ShapeAppearanceModel;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ImageLoaderFactory;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0018\u001a\u00020\u0019H\u0014J\u001c\u0010\u001a\u001a\u00020\u00192\u0012\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u001cH\u0016R\u000e\u0010\f\u001a\u00020\u0001X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0012\u001a\u0004\u0018\u00010\u00138BX\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001d"}, d2 = {"Lzendesk/ui/android/conversation/avatar/AvatarImageView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/avatar/AvatarImageRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "container", "imageLoaderDisposable", "Lcoil/request/Disposable;", "imageView", "Lcom/google/android/material/imageview/ShapeableImageView;", "rendering", "skeletonLoaderDrawable", "Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "getSkeletonLoaderDrawable", "()Landroidx/vectordrawable/graphics/drawable/AnimatedVectorDrawableCompat;", "skeletonLoaderDrawable$delegate", "Lkotlin/Lazy;", "onDetachedFromWindow", "", "render", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AvatarImageView.kt */
public final class AvatarImageView extends FrameLayout implements Renderer<AvatarImageRendering> {
    private final FrameLayout container;
    private Disposable imageLoaderDisposable;
    private final ShapeableImageView imageView;
    private AvatarImageRendering rendering;
    private final Lazy skeletonLoaderDrawable$delegate;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AvatarImageView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AvatarMask.values().length];
            iArr[AvatarMask.NONE.ordinal()] = 1;
            iArr[AvatarMask.CIRCLE.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AvatarImageView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AvatarImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public AvatarImageView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AvatarImageView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AvatarImageView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new AvatarImageRendering();
        this.skeletonLoaderDrawable$delegate = LazyKt.lazy(new AvatarImageView$skeletonLoaderDrawable$2(context));
        FrameLayout.inflate(context, R.layout.zuia_view_avatar_image, this);
        View findViewById = findViewById(R.id.zuia_avatar_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_avatar_container)");
        this.container = (FrameLayout) findViewById;
        View findViewById2 = findViewById(R.id.zuia_avatar_image_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_avatar_image_view)");
        this.imageView = (ShapeableImageView) findViewById2;
        render(AnonymousClass1.INSTANCE);
    }

    private final AnimatedVectorDrawableCompat getSkeletonLoaderDrawable() {
        return (AnimatedVectorDrawableCompat) this.skeletonLoaderDrawable$delegate.getValue();
    }

    public void render(Function1<? super AvatarImageRendering, AvatarImageRendering> function1) {
        ShapeAppearanceModel shapeAppearanceModel;
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        this.rendering = function1.invoke(this.rendering);
        int dimensionPixelSize = getResources().getDimensionPixelSize(this.rendering.getState$zendesk_ui_ui_android().getAvatarSize());
        ShapeableImageView shapeableImageView = this.imageView;
        int i = WhenMappings.$EnumSwitchMapping$0[this.rendering.getState$zendesk_ui_ui_android().getMask().ordinal()];
        if (i == 1) {
            shapeAppearanceModel = new ShapeAppearanceModel().toBuilder().setAllCorners(0, 0.0f).build();
        } else if (i == 2) {
            shapeAppearanceModel = new ShapeAppearanceModel().toBuilder().setAllCorners(0, ((float) dimensionPixelSize) / ((float) 2)).build();
        } else {
            throw new NoWhenBranchMatchedException();
        }
        Intrinsics.checkNotNullExpressionValue(shapeAppearanceModel, "when (rendering.state.ma…   .build()\n            }");
        shapeableImageView.setShapeAppearanceModel(shapeAppearanceModel);
        MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(shapeAppearanceModel);
        Integer backgroundColor = this.rendering.getState$zendesk_ui_ui_android().getBackgroundColor();
        materialShapeDrawable.setFillColor(backgroundColor != null ? ColorStateList.valueOf(backgroundColor.intValue()) : null);
        shapeableImageView.setBackground(materialShapeDrawable);
        shapeableImageView.setImageDrawable(getSkeletonLoaderDrawable());
        AnimatedVectorDrawableCompat skeletonLoaderDrawable = getSkeletonLoaderDrawable();
        if (skeletonLoaderDrawable != null) {
            skeletonLoaderDrawable.start();
        }
        FrameLayout frameLayout = this.container;
        ViewGroup.LayoutParams layoutParams = frameLayout.getLayoutParams();
        layoutParams.height = dimensionPixelSize;
        layoutParams.width = dimensionPixelSize;
        frameLayout.setClipChildren(true);
        frameLayout.setClipToOutline(true);
        ShapeableImageView shapeableImageView2 = this.imageView;
        ViewGroup.LayoutParams layoutParams2 = shapeableImageView2.getLayoutParams();
        layoutParams2.height = dimensionPixelSize;
        layoutParams2.width = dimensionPixelSize;
        Disposable disposable = this.imageLoaderDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        Uri uri = this.rendering.getState$zendesk_ui_ui_android().getUri();
        if (uri != null) {
            ImageLoaderFactory imageLoaderFactory = ImageLoaderFactory.INSTANCE;
            Context context = shapeableImageView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ImageLoader imageLoader = imageLoaderFactory.getImageLoader(context);
            Context context2 = shapeableImageView2.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            ImageRequest.Builder placeholder = new ImageRequest.Builder(context2).data(uri).error(ResourcesCompat.getDrawable(shapeableImageView2.getContext().getResources(), R.drawable.zuia_avatar_default, shapeableImageView2.getContext().getTheme())).fallback((Drawable) getSkeletonLoaderDrawable()).placeholder((Drawable) getSkeletonLoaderDrawable());
            if (!this.rendering.getState$zendesk_ui_ui_android().getShouldAnimate()) {
                Gifs.repeatCount(placeholder, 0);
            }
            this.imageLoaderDisposable = imageLoader.enqueue(placeholder.target((ImageView) shapeableImageView2).build());
            return;
        }
        shapeableImageView2.setBackground((Drawable) null);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.imageLoaderDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
        AnimatedVectorDrawableCompat skeletonLoaderDrawable = getSkeletonLoaderDrawable();
        if (skeletonLoaderDrawable != null) {
            skeletonLoaderDrawable.stop();
        }
    }
}
