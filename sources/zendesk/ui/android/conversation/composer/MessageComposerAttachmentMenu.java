package zendesk.ui.android.conversation.composer;

import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0010\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\u0006J\u001a\u0010\u0011\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e0\fJ\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lzendesk/ui/android/conversation/composer/MessageComposerAttachmentMenu;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cameraSupported", "", "cameraTextView", "Landroid/widget/TextView;", "gallerySupported", "galleryTextView", "itemClickListener", "Lkotlin/Function1;", "", "", "setCameraSupported", "setGallerySupported", "setOnItemClickListener", "listener", "updateAccessibilityNodeInfo", "view", "Landroid/view/View;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageComposerAttachmentMenu.kt */
public final class MessageComposerAttachmentMenu extends FrameLayout {
    private boolean cameraSupported = true;
    private final TextView cameraTextView;
    private boolean gallerySupported = true;
    private final TextView galleryTextView;
    private Function1<? super Integer, Unit> itemClickListener;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MessageComposerAttachmentMenu(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(context, R.layout.zuia_view_attachment_menu, this);
        View findViewById = findViewById(R.id.menu_item_camera);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.menu_item_camera)");
        TextView textView = (TextView) findViewById;
        this.cameraTextView = textView;
        View findViewById2 = findViewById(R.id.menu_item_gallery);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.menu_item_gallery)");
        TextView textView2 = (TextView) findViewById2;
        this.galleryTextView = textView2;
        updateAccessibilityNodeInfo(textView);
        updateAccessibilityNodeInfo(textView2);
        textView.setOnClickListener(new MessageComposerAttachmentMenu$$ExternalSyntheticLambda0(this));
        textView2.setOnClickListener(new MessageComposerAttachmentMenu$$ExternalSyntheticLambda1(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-0  reason: not valid java name */
    public static final void m2764_init_$lambda0(MessageComposerAttachmentMenu messageComposerAttachmentMenu, View view) {
        Intrinsics.checkNotNullParameter(messageComposerAttachmentMenu, "this$0");
        Function1<? super Integer, Unit> function1 = messageComposerAttachmentMenu.itemClickListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(R.id.menu_item_camera));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m2765_init_$lambda1(MessageComposerAttachmentMenu messageComposerAttachmentMenu, View view) {
        Intrinsics.checkNotNullParameter(messageComposerAttachmentMenu, "this$0");
        Function1<? super Integer, Unit> function1 = messageComposerAttachmentMenu.itemClickListener;
        if (function1 != null) {
            function1.invoke(Integer.valueOf(R.id.menu_item_gallery));
        }
    }

    private final void updateAccessibilityNodeInfo(View view) {
        view.setAccessibilityDelegate(new MessageComposerAttachmentMenu$updateAccessibilityNodeInfo$1());
    }

    public final void setOnItemClickListener(Function1<? super Integer, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.itemClickListener = function1;
    }

    public final void setGallerySupported(boolean z) {
        this.gallerySupported = z;
        this.galleryTextView.setVisibility(z ? 0 : 8);
    }

    public final void setCameraSupported(boolean z) {
        this.cameraSupported = z;
        this.cameraTextView.setVisibility(z ? 0 : 8);
    }
}
