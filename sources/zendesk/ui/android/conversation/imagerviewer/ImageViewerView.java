package zendesk.ui.android.conversation.imagerviewer;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import coil.request.Disposable;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.conversation.header.ConversationHeaderRendering;
import zendesk.ui.android.conversation.header.ConversationHeaderView;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\b\u0010\u0017\u001a\u00020\u0018H\u0014J\u001c\u0010\u0019\u001a\u00020\u00182\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u000fH\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R$\u0010\u000e\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000fj\b\u0012\u0004\u0012\u00020\u0010`\u0011X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lzendesk/ui/android/conversation/imagerviewer/ImageViewerView;", "Landroid/widget/FrameLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/imagerviewer/ImageViewerRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "headerView", "Lzendesk/ui/android/conversation/header/ConversationHeaderView;", "headerViewRenderingUpdate", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/header/ConversationHeaderRendering;", "Lzendesk/ui/android/conversation/imagerviewer/RenderingUpdate;", "imageLoaderDisposable", "Lcoil/request/Disposable;", "imageView", "Landroid/widget/ImageView;", "rendering", "onDetachedFromWindow", "", "render", "renderingUpdate", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageViewerView.kt */
public final class ImageViewerView extends FrameLayout implements Renderer<ImageViewerRendering> {
    private final ConversationHeaderView headerView;
    private final Function1<ConversationHeaderRendering, ConversationHeaderRendering> headerViewRenderingUpdate;
    private Disposable imageLoaderDisposable;
    private final ImageView imageView;
    /* access modifiers changed from: private */
    public ImageViewerRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageViewerView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageViewerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ImageViewerView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ImageViewerView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageViewerView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new ImageViewerRendering();
        this.headerViewRenderingUpdate = new ImageViewerView$headerViewRenderingUpdate$1(this);
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_ConversationHeader, false);
        FrameLayout.inflate(context, R.layout.zuia_view_image_viewer, this);
        View findViewById = findViewById(R.id.zuia_header_view);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_header_view)");
        this.headerView = (ConversationHeaderView) findViewById;
        View findViewById2 = findViewById(R.id.zuia_image_view);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_image_view)");
        this.imageView = (ImageView) findViewById2;
        render(AnonymousClass1.INSTANCE);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0039, code lost:
        r1 = r1.get(new coil.memory.MemoryCache.Key(r7, (java.util.Map) null, 2, (kotlin.jvm.internal.DefaultConstructorMarker) null));
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void render(kotlin.jvm.functions.Function1<? super zendesk.ui.android.conversation.imagerviewer.ImageViewerRendering, zendesk.ui.android.conversation.imagerviewer.ImageViewerRendering> r7) {
        /*
            r6 = this;
            java.lang.String r0 = "renderingUpdate"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            zendesk.ui.android.conversation.imagerviewer.ImageViewerRendering r0 = r6.rendering
            java.lang.Object r7 = r7.invoke(r0)
            zendesk.ui.android.conversation.imagerviewer.ImageViewerRendering r7 = (zendesk.ui.android.conversation.imagerviewer.ImageViewerRendering) r7
            r6.rendering = r7
            zendesk.ui.android.conversation.header.ConversationHeaderView r7 = r6.headerView
            kotlin.jvm.functions.Function1<zendesk.ui.android.conversation.header.ConversationHeaderRendering, zendesk.ui.android.conversation.header.ConversationHeaderRendering> r0 = r6.headerViewRenderingUpdate
            r7.render(r0)
            zendesk.ui.android.conversation.imagerviewer.ImageViewerRendering r7 = r6.rendering
            zendesk.ui.android.conversation.imagerviewer.ImageViewerState r7 = r7.getState$zendesk_ui_ui_android()
            java.lang.String r7 = r7.getUri$zendesk_ui_ui_android()
            if (r7 == 0) goto L_0x007b
            zendesk.ui.android.internal.ImageLoaderFactory r0 = zendesk.ui.android.internal.ImageLoaderFactory.INSTANCE
            android.content.Context r1 = r6.getContext()
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            coil.ImageLoader r0 = r0.getImageLoader(r1)
            coil.memory.MemoryCache r1 = r0.getMemoryCache()
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L_0x0049
            coil.memory.MemoryCache$Key r5 = new coil.memory.MemoryCache$Key
            r5.<init>(r7, r4, r3, r4)
            coil.memory.MemoryCache$Value r1 = r1.get(r5)
            if (r1 == 0) goto L_0x0049
            android.graphics.Bitmap r1 = r1.getBitmap()
            goto L_0x004a
        L_0x0049:
            r1 = r4
        L_0x004a:
            if (r1 == 0) goto L_0x0052
            android.widget.ImageView r7 = r6.imageView
            r7.setImageBitmap(r1)
            goto L_0x007b
        L_0x0052:
            coil.request.ImageRequest$Builder r1 = new coil.request.ImageRequest$Builder
            android.content.Context r5 = r6.getContext()
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)
            r1.<init>((android.content.Context) r5)
            coil.request.ImageRequest$Builder r1 = r1.data(r7)
            coil.memory.MemoryCache$Key r2 = new coil.memory.MemoryCache$Key
            r2.<init>(r7, r4, r3, r4)
            coil.request.ImageRequest$Builder r7 = r1.memoryCacheKey((coil.memory.MemoryCache.Key) r2)
            android.widget.ImageView r1 = r6.imageView
            coil.request.ImageRequest$Builder r7 = r7.target((android.widget.ImageView) r1)
            coil.request.ImageRequest r7 = r7.build()
            coil.request.Disposable r7 = r0.enqueue(r7)
            r6.imageLoaderDisposable = r7
        L_0x007b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.ui.android.conversation.imagerviewer.ImageViewerView.render(kotlin.jvm.functions.Function1):void");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Disposable disposable = this.imageLoaderDisposable;
        if (disposable != null) {
            disposable.dispose();
        }
    }
}
