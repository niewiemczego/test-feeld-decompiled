package zendesk.ui.android.conversation.file;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.format.Formatter;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.facebook.react.modules.appstate.AppStateModule;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import zendesk.ui.android.R;
import zendesk.ui.android.Renderer;
import zendesk.ui.android.internal.ColorExtKt;
import zendesk.ui.android.internal.ThrottledOnClickListenerKt;

@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002B/\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0010\u001a\u00020\u0014H\u0002J\u001c\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00030\u0018H\u0016R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lzendesk/ui/android/conversation/file/FileView;", "Landroid/widget/RelativeLayout;", "Lzendesk/ui/android/Renderer;", "Lzendesk/ui/android/conversation/file/FileRendering;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttrs", "", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "fileIcon", "Landroid/widget/ImageView;", "fileName", "Landroid/widget/TextView;", "fileSize", "rendering", "getFormattedFileSize", "", "", "render", "", "renderingUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileView.kt */
public final class FileView extends RelativeLayout implements Renderer<FileRendering> {
    private final ImageView fileIcon;
    private final TextView fileName;
    private final TextView fileSize;
    /* access modifiers changed from: private */
    public FileRendering rendering;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileView(Context context) {
        this(context, (AttributeSet) null, 0, 0, 14, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FileView(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0, 8, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FileView(Context context, AttributeSet attributeSet, int i, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i, (i3 & 8) != 0 ? 0 : i2);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FileView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        Intrinsics.checkNotNullParameter(context, "context");
        this.rendering = new FileRendering();
        context.getTheme().applyStyle(R.style.ThemeOverlay_ZendeskComponents_TextCellStyle, false);
        RelativeLayout.inflate(context, R.layout.zuia_view_file_cell, this);
        setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.dimen.zuia_horizontal_message_padding);
        int dimensionPixelSize2 = context.getResources().getDimensionPixelSize(R.dimen.zuia_vertical_message_padding);
        setPaddingRelative(dimensionPixelSize, dimensionPixelSize2, dimensionPixelSize, dimensionPixelSize2);
        setClickable(true);
        setFocusable(true);
        View findViewById = findViewById(R.id.zuia_file_icon);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.zuia_file_icon)");
        this.fileIcon = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.zuia_file_name);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.zuia_file_name)");
        this.fileName = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.zuia_file_size);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.zuia_file_size)");
        this.fileSize = (TextView) findViewById3;
        render(AnonymousClass1.INSTANCE);
    }

    public void render(Function1<? super FileRendering, FileRendering> function1) {
        int i;
        Integer backgroundColor$zendesk_ui_ui_android;
        Intrinsics.checkNotNullParameter(function1, "renderingUpdate");
        FileRendering invoke = function1.invoke(this.rendering);
        this.rendering = invoke;
        this.fileName.setText(invoke.getState$zendesk_ui_ui_android().getFileName$zendesk_ui_ui_android());
        this.fileSize.setText(getFormattedFileSize(this.rendering.getState$zendesk_ui_ui_android().getFileSize$zendesk_ui_ui_android()));
        Integer backgroundDrawable$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundDrawable$zendesk_ui_ui_android();
        if (backgroundDrawable$zendesk_ui_ui_android != null) {
            setBackgroundResource(backgroundDrawable$zendesk_ui_ui_android.intValue());
        }
        if (!(getBackground() == null || (backgroundColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getBackgroundColor$zendesk_ui_ui_android()) == null)) {
            Drawable background = getBackground();
            Intrinsics.checkNotNullExpressionValue(background, AppStateModule.APP_STATE_BACKGROUND);
            background.setTint(backgroundColor$zendesk_ui_ui_android.intValue());
        }
        Integer textColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getTextColor$zendesk_ui_ui_android();
        if (textColor$zendesk_ui_ui_android != null) {
            i = textColor$zendesk_ui_ui_android.intValue();
        } else {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            i = ColorExtKt.resolveColorAttr(context, 16842904);
        }
        this.fileName.setTextColor(i);
        this.fileSize.setTextColor(i);
        Integer iconColor$zendesk_ui_ui_android = this.rendering.getState$zendesk_ui_ui_android().getIconColor$zendesk_ui_ui_android();
        if (iconColor$zendesk_ui_ui_android != null) {
            this.fileIcon.setColorFilter(iconColor$zendesk_ui_ui_android.intValue(), PorterDuff.Mode.SRC_IN);
        }
        setOnClickListener(ThrottledOnClickListenerKt.throttledOnClickListener$default(0, new FileView$render$4(this), 1, (Object) null));
    }

    private final String getFormattedFileSize(long j) {
        Context context = getContext();
        if (Build.VERSION.SDK_INT >= 26) {
            long j2 = (long) 1000;
            long j3 = j * j2 * j2;
            long j4 = (long) 1024;
            j = (j3 / j4) / j4;
        }
        String formatFileSize = Formatter.formatFileSize(context, j);
        Intrinsics.checkNotNullExpressionValue(formatFileSize, "formatFileSize(\n        … 1024 else fileSize\n    )");
        return formatFileSize;
    }
}
