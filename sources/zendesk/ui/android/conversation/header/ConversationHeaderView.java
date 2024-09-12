package zendesk.ui.android.conversation.header;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.util.AttributeSet;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout;
import coil.ImageLoader;
import coil.request.Disposable;
import coil.request.ImageRequest;
import coil.target.Target;
import coil.transform.CircleCropTransformation;
import com.google.android.material.appbar.MaterialToolbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ImageLoaderFactory;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0014J\u001c\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0015H\u0016J\u000e\u0010\u0016\u001a\u0004\u0018\u00010\u0017*\u00020\u0018H\u0002R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lzendesk/ui/android/conversation/header/ConversationHeaderView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/header/ConversationHeaderRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "imageLoaderDisposable", "Lcoil/request/Disposable;", "rendering", "toolbar", "Lcom/google/android/material/appbar/MaterialToolbar;", "onDetachedFromWindow", "", "render", "renderingUpdate", "Lkotlin/Function1;", "getActivity", "Landroid/app/Activity;", "Landroid/view/View;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConversationHeaderView.kt */
public final class ConversationHeaderView extends FrameLayout implements Renderer<ConversationHeaderRendering> {
    private Disposable imageLoaderDisposable;
    private ConversationHeaderRendering rendering;
    private final MaterialToolbar toolbar;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConversationHeaderView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConversationHeaderView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ConversationHeaderView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConversationHeaderView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ConversationHeaderView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new ConversationHeaderRendering();
        FrameLayout.inflate(context, R.layout.zuia_view_conversation_header, this);
        View findViewById = findViewById(R.id.zuia_conversation_header_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_c…versation_header_toolbar)");
        this.toolbar = (MaterialToolbar) findViewById;
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super ConversationHeaderRendering, ConversationHeaderRendering> function1) {
        Unit unit;
        Unit unit2;
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        ConversationHeaderRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        MaterialToolbar materialToolbar = this.toolbar;
        Function0<Unit> onBackButtonClicked$zendesk_ui_ui_android = invoke.getOnBackButtonClicked$zendesk_ui_ui_android();
        if (onBackButtonClicked$zendesk_ui_ui_android != null) {
            materialToolbar.setTitleMarginStart(materialToolbar.getResources().getDimensionPixelSize(R.dimen.zuia_header_logo_content_insert));
            materialToolbar.setNavigationIcon(R.drawable.zuia_ic_arrow_back);
            materialToolbar.setNavigationContentDescription((CharSequence) materialToolbar.getResources().getString(R.string.zuia_back_button_accessibility_label));
            materialToolbar.setNavigationOnClickListener(new ConversationHeaderView$$ExternalSyntheticLambda0(onBackButtonClicked$zendesk_ui_ui_android));
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            materialToolbar.setTitleMarginStart(materialToolbar.getResources().getDimensionPixelSize(R.dimen.zuia_header_logo_margin));
            materialToolbar.setNavigationOnClickListener((View.OnClickListener) null);
        }
        Integer backgroundColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundColor$zendesk_ui_ui_android();
        if (backgroundColor$zendesk_ui_ui_android != null) {
            materialToolbar.setBackground(new ColorDrawable(backgroundColor$zendesk_ui_ui_android.intValue()));
        }
        Integer statusBarColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getStatusBarColor$zendesk_ui_ui_android();
        if (statusBarColor$zendesk_ui_ui_android != null) {
            int intValue = statusBarColor$zendesk_ui_ui_android.intValue();
            Activity activity = getActivity(materialToolbar);
            Window window = activity != null ? activity.getWindow() : null;
            if (window != null) {
                window.setStatusBarColor(intValue);
            }
        }
        materialToolbar.setTitle((CharSequence) this.rendering.getState$zendesk_ui_ui_android().getTitle$zendesk_ui_ui_android());
        materialToolbar.setSubtitle((CharSequence) this.rendering.getState$zendesk_ui_ui_android().getDescription$zendesk_ui_ui_android());
        Uri logo$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getLogo$zendesk_ui_ui_android();
        if (logo$zendesk_ui_ui_android != null) {
            int dimensionPixelSize = materialToolbar.getResources().getDimensionPixelSize(R.dimen.zuia_avatar_image_size);
            ImageLoaderFactory imageLoaderFactory = ImageLoaderFactory.INSTANCE;
            Context context = materialToolbar.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            ImageLoader imageLoader = imageLoaderFactory.getImageLoader(context);
            Context context2 = materialToolbar.getContext();
            Intrinsics.checkNotNullExpressionValue(context2, "context");
            this.imageLoaderDisposable = imageLoader.enqueue(new ImageRequest.Builder(context2).data(logo$zendesk_ui_ui_android).size(dimensionPixelSize).transformations(new CircleCropTransformation()).target((Target) new ConversationHeaderView$render$lambda8$lambda6$$inlined$target$default$1(materialToolbar)).build());
            unit2 = Unit.INSTANCE;
        } else {
            unit2 = null;
        }
        if (unit2 == null) {
            materialToolbar.setLogo((Drawable) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: render$lambda-8$lambda-1$lambda-0  reason: not valid java name */
    public static final void m2792render$lambda8$lambda1$lambda0(Function0 function0, View view) {
        Intrinsics.checkNotNullParameter(function0, "$onBackButtonClicked");
        function0.invoke();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.imageLoaderDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }

    private final Activity getActivity(View view) {
        Context context = view.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
            Intrinsics.checkNotNullExpressionValue(context, "context.baseContext");
        }
        return null;
    }
}
