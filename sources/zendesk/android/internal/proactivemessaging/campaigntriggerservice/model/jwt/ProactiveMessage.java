package zendesk.android.internal.proactivemessaging.campaigntriggerservice.model.jwt;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessage;", "", "author", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageAuthor;", "content", "Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageContent;", "(Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageAuthor;Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageContent;)V", "getAuthor", "()Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageAuthor;", "getContent", "()Lzendesk/android/internal/proactivemessaging/campaigntriggerservice/model/jwt/ProactiveMessageContent;", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessageResponse.kt */
public final class ProactiveMessage {
    private final ProactiveMessageAuthor author;
    private final ProactiveMessageContent content;

    public static /* synthetic */ ProactiveMessage copy$default(ProactiveMessage proactiveMessage, ProactiveMessageAuthor proactiveMessageAuthor, ProactiveMessageContent proactiveMessageContent, int i, Object obj) {
        if ((i & 1) != 0) {
            proactiveMessageAuthor = proactiveMessage.author;
        }
        if ((i & 2) != 0) {
            proactiveMessageContent = proactiveMessage.content;
        }
        return proactiveMessage.copy(proactiveMessageAuthor, proactiveMessageContent);
    }

    public final ProactiveMessageAuthor component1() {
        return this.author;
    }

    public final ProactiveMessageContent component2() {
        return this.content;
    }

    public final ProactiveMessage copy(ProactiveMessageAuthor proactiveMessageAuthor, ProactiveMessageContent proactiveMessageContent) {
        Intrinsics.checkNotNullParameter(proactiveMessageAuthor, "author");
        Intrinsics.checkNotNullParameter(proactiveMessageContent, "content");
        return new ProactiveMessage(proactiveMessageAuthor, proactiveMessageContent);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProactiveMessage)) {
            return false;
        }
        ProactiveMessage proactiveMessage = (ProactiveMessage) obj;
        return Intrinsics.areEqual((Object) this.author, (Object) proactiveMessage.author) && Intrinsics.areEqual((Object) this.content, (Object) proactiveMessage.content);
    }

    public int hashCode() {
        return (this.author.hashCode() * 31) + this.content.hashCode();
    }

    public String toString() {
        return "ProactiveMessage(author=" + this.author + ", content=" + this.content + ')';
    }

    public ProactiveMessage(ProactiveMessageAuthor proactiveMessageAuthor, ProactiveMessageContent proactiveMessageContent) {
        Intrinsics.checkNotNullParameter(proactiveMessageAuthor, "author");
        Intrinsics.checkNotNullParameter(proactiveMessageContent, "content");
        this.author = proactiveMessageAuthor;
        this.content = proactiveMessageContent;
    }

    public final ProactiveMessageAuthor getAuthor() {
        return this.author;
    }

    public final ProactiveMessageContent getContent() {
        return this.content;
    }
}
