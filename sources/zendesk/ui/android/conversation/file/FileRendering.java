package zendesk.ui.android.conversation.file;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0001\u0010B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000f\u001a\u00020\u0004R\u001a\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lzendesk/ui/android/conversation/file/FileRendering;", "", "()V", "builder", "Lzendesk/ui/android/conversation/file/FileRendering$Builder;", "(Lzendesk/ui/android/conversation/file/FileRendering$Builder;)V", "onCellClicked", "Lkotlin/Function0;", "", "getOnCellClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "state", "Lzendesk/ui/android/conversation/file/FileState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/file/FileState;", "toBuilder", "Builder", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FileRendering.kt */
public final class FileRendering {
    private final Function0<Unit> onCellClicked;
    private final FileState state;

    public FileRendering(Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        this.onCellClicked = builder.getOnCellClicked$zendesk_ui_ui_android();
        this.state = builder.getState$zendesk_ui_ui_android();
    }

    public final Function0<Unit> getOnCellClicked$zendesk_ui_ui_android() {
        return this.onCellClicked;
    }

    public final FileState getState$zendesk_ui_ui_android() {
        return this.state;
    }

    public FileRendering() {
        this(new Builder());
    }

    public final Builder toBuilder() {
        return new Builder(this);
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0011\b\u0010\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0005¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0013\u001a\u00020\u0003J\u0014\u0010\u0006\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007J\u001a\u0010\r\u001a\u00020\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e0\u0015R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u0016"}, d2 = {"Lzendesk/ui/android/conversation/file/FileRendering$Builder;", "", "rendering", "Lzendesk/ui/android/conversation/file/FileRendering;", "(Lzendesk/ui/android/conversation/file/FileRendering;)V", "()V", "onCellClicked", "Lkotlin/Function0;", "", "getOnCellClicked$zendesk_ui_ui_android", "()Lkotlin/jvm/functions/Function0;", "setOnCellClicked$zendesk_ui_ui_android", "(Lkotlin/jvm/functions/Function0;)V", "state", "Lzendesk/ui/android/conversation/file/FileState;", "getState$zendesk_ui_ui_android", "()Lzendesk/ui/android/conversation/file/FileState;", "setState$zendesk_ui_ui_android", "(Lzendesk/ui/android/conversation/file/FileState;)V", "build", "stateUpdate", "Lkotlin/Function1;", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: FileRendering.kt */
    public static final class Builder {
        private Function0<Unit> onCellClicked;
        private FileState state;

        public Builder() {
            this.onCellClicked = FileRendering$Builder$onCellClicked$1.INSTANCE;
            this.state = new FileState((String) null, 0, (Integer) null, (Integer) null, (Integer) null, (Integer) null, 63, (DefaultConstructorMarker) null);
        }

        public final Function0<Unit> getOnCellClicked$zendesk_ui_ui_android() {
            return this.onCellClicked;
        }

        public final void setOnCellClicked$zendesk_ui_ui_android(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "<set-?>");
            this.onCellClicked = function0;
        }

        public final FileState getState$zendesk_ui_ui_android() {
            return this.state;
        }

        public final void setState$zendesk_ui_ui_android(FileState fileState) {
            Intrinsics.checkNotNullParameter(fileState, "<set-?>");
            this.state = fileState;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Builder(FileRendering fileRendering) {
            this();
            Intrinsics.checkNotNullParameter(fileRendering, "rendering");
            this.onCellClicked = fileRendering.getOnCellClicked$zendesk_ui_ui_android();
            this.state = fileRendering.getState$zendesk_ui_ui_android();
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Builder(FileRendering fileRendering, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? new FileRendering() : fileRendering);
        }

        public final Builder onCellClicked(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "onCellClicked");
            Builder builder = this;
            this.onCellClicked = function0;
            return this;
        }

        public final Builder state(Function1<? super FileState, FileState> function1) {
            Intrinsics.checkNotNullParameter(function1, "stateUpdate");
            Builder builder = this;
            this.state = function1.invoke(this.state);
            return this;
        }

        public final FileRendering build() {
            return new FileRendering(this);
        }
    }
}
