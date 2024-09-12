package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B1\b\u0000\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, d2 = {"Lzendesk/conversationkit/android/model/Author;", "", "userId", "", "type", "Lzendesk/conversationkit/android/model/AuthorType;", "displayName", "avatarUrl", "(Ljava/lang/String;Lzendesk/conversationkit/android/model/AuthorType;Ljava/lang/String;Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "getDisplayName", "getType", "()Lzendesk/conversationkit/android/model/AuthorType;", "getUserId", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Author.kt */
public final class Author {
    private final String avatarUrl;
    private final String displayName;
    private final AuthorType type;
    private final String userId;

    public Author() {
        this((String) null, (AuthorType) null, (String) null, (String) null, 15, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ Author copy$default(Author author, String str, AuthorType authorType, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = author.userId;
        }
        if ((i & 2) != 0) {
            authorType = author.type;
        }
        if ((i & 4) != 0) {
            str2 = author.displayName;
        }
        if ((i & 8) != 0) {
            str3 = author.avatarUrl;
        }
        return author.copy(str, authorType, str2, str3);
    }

    public final String component1() {
        return this.userId;
    }

    public final AuthorType component2() {
        return this.type;
    }

    public final String component3() {
        return this.displayName;
    }

    public final String component4() {
        return this.avatarUrl;
    }

    public final Author copy(String str, AuthorType authorType, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(authorType, "type");
        Intrinsics.checkNotNullParameter(str2, "displayName");
        return new Author(str, authorType, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Author)) {
            return false;
        }
        Author author = (Author) obj;
        return Intrinsics.areEqual((Object) this.userId, (Object) author.userId) && this.type == author.type && Intrinsics.areEqual((Object) this.displayName, (Object) author.displayName) && Intrinsics.areEqual((Object) this.avatarUrl, (Object) author.avatarUrl);
    }

    public int hashCode() {
        int hashCode = ((((this.userId.hashCode() * 31) + this.type.hashCode()) * 31) + this.displayName.hashCode()) * 31;
        String str = this.avatarUrl;
        return hashCode + (str == null ? 0 : str.hashCode());
    }

    public String toString() {
        return "Author(userId=" + this.userId + ", type=" + this.type + ", displayName=" + this.displayName + ", avatarUrl=" + this.avatarUrl + ')';
    }

    public Author(String str, AuthorType authorType, String str2, String str3) {
        Intrinsics.checkNotNullParameter(str, "userId");
        Intrinsics.checkNotNullParameter(authorType, "type");
        Intrinsics.checkNotNullParameter(str2, "displayName");
        this.userId = str;
        this.type = authorType;
        this.displayName = str2;
        this.avatarUrl = str3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ Author(java.lang.String r1, zendesk.conversationkit.android.model.AuthorType r2, java.lang.String r3, java.lang.String r4, int r5, kotlin.jvm.internal.DefaultConstructorMarker r6) {
        /*
            r0 = this;
            r6 = r5 & 1
            if (r6 == 0) goto L_0x0011
            java.util.UUID r1 = java.util.UUID.randomUUID()
            java.lang.String r1 = r1.toString()
            java.lang.String r6 = "randomUUID().toString()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r6)
        L_0x0011:
            r6 = r5 & 2
            if (r6 == 0) goto L_0x0017
            zendesk.conversationkit.android.model.AuthorType r2 = zendesk.conversationkit.android.model.AuthorType.USER
        L_0x0017:
            r6 = r5 & 4
            if (r6 == 0) goto L_0x001d
            java.lang.String r3 = ""
        L_0x001d:
            r5 = r5 & 8
            if (r5 == 0) goto L_0x0022
            r4 = 0
        L_0x0022:
            r0.<init>(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.Author.<init>(java.lang.String, zendesk.conversationkit.android.model.AuthorType, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getUserId() {
        return this.userId;
    }

    public final AuthorType getType() {
        return this.type;
    }

    public final String getDisplayName() {
        return this.displayName;
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }
}
