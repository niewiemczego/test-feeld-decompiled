package zendesk.ui.android.conversation.actionbutton;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B;\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003JA\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0016\u001a\u00020\u00072\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001J\t\u0010\u001a\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000b¨\u0006\u001b"}, d2 = {"Lzendesk/ui/android/conversation/actionbutton/ActionButton;", "", "text", "", "uri", "fallback", "isSupported", "", "urlSource", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V", "getFallback", "()Ljava/lang/String;", "()Z", "getText", "getUri", "getUrlSource", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "hashCode", "", "toString", "zendesk.ui_ui-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ActionButton.kt */
public final class ActionButton {
    private final String fallback;
    private final boolean isSupported;
    private final String text;
    private final String uri;
    private final String urlSource;

    public static /* synthetic */ ActionButton copy$default(ActionButton actionButton, String str, String str2, String str3, boolean z, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = actionButton.text;
        }
        if ((i & 2) != 0) {
            str2 = actionButton.uri;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = actionButton.fallback;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            z = actionButton.isSupported;
        }
        boolean z2 = z;
        if ((i & 16) != 0) {
            str4 = actionButton.urlSource;
        }
        return actionButton.copy(str, str5, str6, z2, str4);
    }

    public final String component1() {
        return this.text;
    }

    public final String component2() {
        return this.uri;
    }

    public final String component3() {
        return this.fallback;
    }

    public final boolean component4() {
        return this.isSupported;
    }

    public final String component5() {
        return this.urlSource;
    }

    public final ActionButton copy(String str, String str2, String str3, boolean z, String str4) {
        Intrinsics.checkNotNullParameter(str, "text");
        return new ActionButton(str, str2, str3, z, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActionButton)) {
            return false;
        }
        ActionButton actionButton = (ActionButton) obj;
        return Intrinsics.areEqual((Object) this.text, (Object) actionButton.text) && Intrinsics.areEqual((Object) this.uri, (Object) actionButton.uri) && Intrinsics.areEqual((Object) this.fallback, (Object) actionButton.fallback) && this.isSupported == actionButton.isSupported && Intrinsics.areEqual((Object) this.urlSource, (Object) actionButton.urlSource);
    }

    public int hashCode() {
        int hashCode = this.text.hashCode() * 31;
        String str = this.uri;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.fallback;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        boolean z = this.isSupported;
        if (z) {
            z = true;
        }
        int i2 = (hashCode3 + (z ? 1 : 0)) * 31;
        String str3 = this.urlSource;
        if (str3 != null) {
            i = str3.hashCode();
        }
        return i2 + i;
    }

    public String toString() {
        return "ActionButton(text=" + this.text + ", uri=" + this.uri + ", fallback=" + this.fallback + ", isSupported=" + this.isSupported + ", urlSource=" + this.urlSource + ')';
    }

    public ActionButton(String str, String str2, String str3, boolean z, String str4) {
        Intrinsics.checkNotNullParameter(str, "text");
        this.text = str;
        this.uri = str2;
        this.fallback = str3;
        this.isSupported = z;
        this.urlSource = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActionButton(String str, String str2, String str3, boolean z, String str4, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? true : z, (i & 16) != 0 ? null : str4);
    }

    public final String getText() {
        return this.text;
    }

    public final String getUri() {
        return this.uri;
    }

    public final String getFallback() {
        return this.fallback;
    }

    public final boolean isSupported() {
        return this.isSupported;
    }

    public final String getUrlSource() {
        return this.urlSource;
    }
}
