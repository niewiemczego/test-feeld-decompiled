package zendesk.ui.android.conversation.quickreply;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/ui/android/conversation/quickreply/QuickReplyOption;", "", "id", "", "text", "(Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getText", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: QuickReplyOption.kt */
public final class QuickReplyOption {
    private final String id;
    private final String text;

    public static /* synthetic */ QuickReplyOption copy$default(QuickReplyOption quickReplyOption, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = quickReplyOption.id;
        }
        if ((i & 2) != 0) {
            str2 = quickReplyOption.text;
        }
        return quickReplyOption.copy(str, str2);
    }

    public final String component1() {
        return this.id;
    }

    public final String component2() {
        return this.text;
    }

    public final QuickReplyOption copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "text");
        return new QuickReplyOption(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof QuickReplyOption)) {
            return false;
        }
        QuickReplyOption quickReplyOption = (QuickReplyOption) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) quickReplyOption.id) && Intrinsics.areEqual((Object) this.text, (Object) quickReplyOption.text);
    }

    public int hashCode() {
        return (this.id.hashCode() * 31) + this.text.hashCode();
    }

    public String toString() {
        return "QuickReplyOption(id=" + this.id + ", text=" + this.text + ')';
    }

    public QuickReplyOption(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(str2, "text");
        this.id = str;
        this.text = str2;
    }

    public final String getId() {
        return this.id;
    }

    public final String getText() {
        return this.text;
    }
}
