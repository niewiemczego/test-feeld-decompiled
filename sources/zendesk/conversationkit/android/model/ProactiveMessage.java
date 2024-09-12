package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001B7\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0005¢\u0006\u0002\u0010\nJ\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÆ\u0003JE\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001J\t\u0010\u001e\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\f¨\u0006\u001f"}, d2 = {"Lzendesk/conversationkit/android/model/ProactiveMessage;", "", "id", "", "title", "", "body", "campaignId", "campaignVersion", "jwt", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V", "getBody", "()Ljava/lang/String;", "getCampaignId", "getCampaignVersion", "()I", "getId", "getJwt", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ProactiveMessage.kt */
public final class ProactiveMessage {
    private final String body;
    private final String campaignId;
    private final int campaignVersion;
    private final int id;
    private final String jwt;
    private final String title;

    public static /* synthetic */ ProactiveMessage copy$default(ProactiveMessage proactiveMessage, int i, String str, String str2, String str3, int i2, String str4, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = proactiveMessage.id;
        }
        if ((i3 & 2) != 0) {
            str = proactiveMessage.title;
        }
        String str5 = str;
        if ((i3 & 4) != 0) {
            str2 = proactiveMessage.body;
        }
        String str6 = str2;
        if ((i3 & 8) != 0) {
            str3 = proactiveMessage.campaignId;
        }
        String str7 = str3;
        if ((i3 & 16) != 0) {
            i2 = proactiveMessage.campaignVersion;
        }
        int i4 = i2;
        if ((i3 & 32) != 0) {
            str4 = proactiveMessage.jwt;
        }
        return proactiveMessage.copy(i, str5, str6, str7, i4, str4);
    }

    public final int component1() {
        return this.id;
    }

    public final String component2() {
        return this.title;
    }

    public final String component3() {
        return this.body;
    }

    public final String component4() {
        return this.campaignId;
    }

    public final int component5() {
        return this.campaignVersion;
    }

    public final String component6() {
        return this.jwt;
    }

    public final ProactiveMessage copy(int i, String str, String str2, String str3, int i2, String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "body");
        Intrinsics.checkNotNullParameter(str3, "campaignId");
        Intrinsics.checkNotNullParameter(str4, "jwt");
        return new ProactiveMessage(i, str, str2, str3, i2, str4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ProactiveMessage)) {
            return false;
        }
        ProactiveMessage proactiveMessage = (ProactiveMessage) obj;
        return this.id == proactiveMessage.id && Intrinsics.areEqual((Object) this.title, (Object) proactiveMessage.title) && Intrinsics.areEqual((Object) this.body, (Object) proactiveMessage.body) && Intrinsics.areEqual((Object) this.campaignId, (Object) proactiveMessage.campaignId) && this.campaignVersion == proactiveMessage.campaignVersion && Intrinsics.areEqual((Object) this.jwt, (Object) proactiveMessage.jwt);
    }

    public int hashCode() {
        return (((((((((Integer.hashCode(this.id) * 31) + this.title.hashCode()) * 31) + this.body.hashCode()) * 31) + this.campaignId.hashCode()) * 31) + Integer.hashCode(this.campaignVersion)) * 31) + this.jwt.hashCode();
    }

    public String toString() {
        return "ProactiveMessage(id=" + this.id + ", title=" + this.title + ", body=" + this.body + ", campaignId=" + this.campaignId + ", campaignVersion=" + this.campaignVersion + ", jwt=" + this.jwt + ')';
    }

    public ProactiveMessage(int i, String str, String str2, String str3, int i2, String str4) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "body");
        Intrinsics.checkNotNullParameter(str3, "campaignId");
        Intrinsics.checkNotNullParameter(str4, "jwt");
        this.id = i;
        this.title = str;
        this.body = str2;
        this.campaignId = str3;
        this.campaignVersion = i2;
        this.jwt = str4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ProactiveMessage(int i, String str, String str2, String str3, int i2, String str4, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? UUID.randomUUID().hashCode() : i, str, str2, str3, i2, str4);
    }

    public final int getId() {
        return this.id;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getBody() {
        return this.body;
    }

    public final String getCampaignId() {
        return this.campaignId;
    }

    public final int getCampaignVersion() {
        return this.campaignVersion;
    }

    public final String getJwt() {
        return this.jwt;
    }
}
