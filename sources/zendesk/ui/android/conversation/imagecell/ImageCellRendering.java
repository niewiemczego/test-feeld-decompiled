package zendesk.ui.android.conversation.imagecell;

import android.net.Uri;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0016B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0004R&\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR(\u0010\f\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\rj\u0004\u0018\u0001`\u000eX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0011\u001a\u00020\u0012X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageCellRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/imagecell/ImageCellRendering$Builder;", "(Lzendesk/ui/android/conversation/imagecell/ImageCellRendering$Builder;)V", "onActionButtonClicked", "Lkotlin/Function2;", "", "", "getOnActionButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function2;", "onImageCellClicked", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/imagecell/OnClickLambda;", "getOnImageCellClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "state", "Lzendesk/ui/android/conversation/imagecell/ImageCellState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/imagecell/ImageCellState;", "toBuilder", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCellRendering.kt */
public final class ImageCellRendering {
    private final Function2<String, String, Unit> onActionButtonClicked;
    private final Function1<String, Unit> onImageCellClicked;
    private final ImageCellState state;

    public ImageCellRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onImageCellClicked = builder.getOnImageCellClicked$zendesk_ui_ui_android();
        this.onActionButtonClicked = builder.getOnActionButtonClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function1<String, Unit> getOnImageCellClicked$zendesk_ui_ui_android() {
        return this.onImageCellClicked;
    }

    public final Function2<String, String, Unit> getOnActionButtonClicked$zendesk_ui_ui_android() {
        return this.onActionButtonClicked;
    }

    public final ImageCellState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public ImageCellRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u001b\u001a\u00020\u0003J \u0010\u0006\u001a\u00020\u00002\u0018\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007J\"\u0010\u000e\u001a\u00020\u00002\u001a\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010J\u001a\u0010\u0015\u001a\u00020\u00002\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00160\u000fR,\u0010\u0006\u001a\u0014\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR.\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u000fj\u0004\u0018\u0001`\u0010X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001a¨\u0006\u001d"}, d2 = {"Lzendesk/ui/android/conversation/imagecell/ImageCellRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/imagecell/ImageCellRendering;", "(Lzendesk/ui/android/conversation/imagecell/ImageCellRendering;)V", "()V", "onActionButtonClicked", "Lkotlin/Function2;", "", "", "getOnActionButtonClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function2;", "setOnActionButtonClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function2;)V", "onImageCellClicked", "Lkotlin/Function1;", "Lzendesk/ui/android/conversation/imagecell/OnClickLambda;", "getOnImageCellClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function1;", "setOnImageCellClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function1;)V", "state", "Lzendesk/ui/android/conversation/imagecell/ImageCellState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/imagecell/ImageCellState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/imagecell/ImageCellState;)V", "build", "stateUpdate", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageCellRendering.kt */
    public static final class Builder {
        private Function2<? super String, ? super String, Unit> onActionButtonClicked;
        private Function1<? super String, Unit> onImageCellClicked;
        private ImageCellState state;

        public Builder() {
            this.onActionButtonClicked = ImageCellRendering$Builder$onActionButtonClicked$1.INSTANCE;
            this.state = new ImageCellState((Uri) null, (Uri) null, (String) null, (String) null, false, false, (List) null, (Integer) null, (Integer) null, (Integer) null, (String) null, (ImageCellDirection) null, 4095, (DefaultConstructorMarker) null);
        }

        public final Function1<String, Unit> getOnImageCellClicked$zendesk_ui_ui_android() {
            return this.onImageCellClicked;
        }

        public final void setOnImageCellClicked$zendesk_ui_ui_android(Function1<? super String, Unit> function1) {
            this.onImageCellClicked = function1;
        }

        public final Function2<String, String, Unit> getOnActionButtonClicked$zendesk_ui_ui_android() {
            return this.onActionButtonClicked;
        }

        public final void setOnActionButtonClicked$zendesk_ui_ui_android(Function2<? super String, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "<set-?>");
            this.onActionButtonClicked = function2;
        }

        public final ImageCellState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(ImageCellState imageCellState) {
            Intrinsics.checkNotNullParameter(imageCellState, "<set-?>");
            this.state = imageCellState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(ImageCellRendering imageCellRendering) {
            this();
            Intrinsics.checkNotNullParameter(imageCellRendering, "rendering");
            this.onImageCellClicked = imageCellRendering.getOnImageCellClicked$zendesk_ui_ui_android();
            this.state = imageCellRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(ImageCellRendering imageCellRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new ImageCellRendering() : imageCellRendering);
        }

        public final Builder onImageCellClicked(Function1<? super String, Unit> function1) {
            Builder builder = this;
            this.onImageCellClicked = function1;
            return this;
        }

        public final Builder onActionButtonClicked(Function2<? super String, ? super String, Unit> function2) {
            Intrinsics.checkNotNullParameter(function2, "onActionButtonClicked");
            Builder builder = this;
            this.onActionButtonClicked = function2;
            return this;
        }

        public final Builder state(Function1<? super ImageCellState, ImageCellState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final ImageCellRendering build() {
            return new ImageCellRendering(this);
        }
    }
}
