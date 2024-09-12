package zendesk.conversationkit.android.internal.rest.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0012"}, d2 = {"Lzendesk/conversationkit/android/internal/rest/model/MessageFieldOptionDto;", "", "name", "", "label", "(Ljava/lang/String;Ljava/lang/String;)V", "getLabel", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: MessageDto.kt */
public final class MessageFieldOptionDto {
    private final String label;
    private final String name;

    public static /* synthetic */ MessageFieldOptionDto copy$default(MessageFieldOptionDto messageFieldOptionDto, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = messageFieldOptionDto.name;
        }
        if ((i & 2) != 0) {
            str2 = messageFieldOptionDto.label;
        }
        return messageFieldOptionDto.copy(str, str2);
    }

    public final String component1() {
        return this.name;
    }

    public final String component2() {
        return this.label;
    }

    public final MessageFieldOptionDto copy(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "label");
        return new MessageFieldOptionDto(str, str2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof MessageFieldOptionDto)) {
            return false;
        }
        MessageFieldOptionDto messageFieldOptionDto = (MessageFieldOptionDto) obj;
        return Intrinsics.areEqual((Object) this.name, (Object) messageFieldOptionDto.name) && Intrinsics.areEqual((Object) this.label, (Object) messageFieldOptionDto.label);
    }

    public int hashCode() {
        return (this.name.hashCode() * 31) + this.label.hashCode();
    }

    public String toString() {
        return "MessageFieldOptionDto(name=" + this.name + ", label=" + this.label + ')';
    }

    public MessageFieldOptionDto(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(str2, "label");
        this.name = str;
        this.label = str2;
    }

    public final String getName() {
        return this.name;
    }

    public final String getLabel() {
        return this.label;
    }
}
