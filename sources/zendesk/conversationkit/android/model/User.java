package zendesk.conversationkit.android.model;

import com.squareup.moshi.JsonClass;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import zendesk.conversationkit.android.model.AuthenticationType;

@JsonClass(generateAdapter = true)
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0001\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u0012\u0006\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\u0010\u0012\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0013J\t\u0010$\u001a\u00020\u0003HÆ\u0003J\t\u0010%\u001a\u00020\u0010HÆ\u0003J\u0010\u0010&\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b'J\u0010\u0010(\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b)J\u000b\u0010*\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010+\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010,\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010.\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010/\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000f\u00100\u001a\b\u0012\u0004\u0012\u00020\f0\u000bHÆ\u0003J\t\u00101\u001a\u00020\u000eHÆ\u0003J\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\u0006\u00106\u001a\u000207J\t\u00108\u001a\u000209HÖ\u0001J\t\u0010:\u001a\u00020\u0003HÖ\u0001R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0017R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0017R\u0016\u0010\u0012\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0017R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0017R\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0016\u0010\u0011\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0017R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0017R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#¨\u0006;"}, d2 = {"Lzendesk/conversationkit/android/model/User;", "", "id", "", "externalId", "givenName", "surname", "email", "locale", "signedUpAt", "conversations", "", "Lzendesk/conversationkit/android/model/Conversation;", "realtimeSettings", "Lzendesk/conversationkit/android/model/RealtimeSettings;", "typingSettings", "Lzendesk/conversationkit/android/model/TypingSettings;", "sessionToken", "jwt", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lzendesk/conversationkit/android/model/RealtimeSettings;Lzendesk/conversationkit/android/model/TypingSettings;Ljava/lang/String;Ljava/lang/String;)V", "getConversations", "()Ljava/util/List;", "getEmail", "()Ljava/lang/String;", "getExternalId", "getGivenName", "getId", "getJwt$zendesk_conversationkit_conversationkit_android", "getLocale", "getRealtimeSettings", "()Lzendesk/conversationkit/android/model/RealtimeSettings;", "getSessionToken$zendesk_conversationkit_conversationkit_android", "getSignedUpAt", "getSurname", "getTypingSettings", "()Lzendesk/conversationkit/android/model/TypingSettings;", "component1", "component10", "component11", "component11$zendesk_conversationkit_conversationkit_android", "component12", "component12$zendesk_conversationkit_conversationkit_android", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "getAuthenticationType", "Lzendesk/conversationkit/android/model/AuthenticationType;", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: User.kt */
public final class User {
    private final List<Conversation> conversations;
    private final String email;
    private final String externalId;
    private final String givenName;
    private final String id;
    private final String jwt;
    private final String locale;
    private final RealtimeSettings realtimeSettings;
    private final String sessionToken;
    private final String signedUpAt;
    private final String surname;
    private final TypingSettings typingSettings;

    public static /* synthetic */ User copy$default(User user, String str, String str2, String str3, String str4, String str5, String str6, String str7, List list, RealtimeSettings realtimeSettings2, TypingSettings typingSettings2, String str8, String str9, int i, Object obj) {
        User user2 = user;
        int i2 = i;
        return user.copy((i2 & 1) != 0 ? user2.id : str, (i2 & 2) != 0 ? user2.externalId : str2, (i2 & 4) != 0 ? user2.givenName : str3, (i2 & 8) != 0 ? user2.surname : str4, (i2 & 16) != 0 ? user2.email : str5, (i2 & 32) != 0 ? user2.locale : str6, (i2 & 64) != 0 ? user2.signedUpAt : str7, (i2 & 128) != 0 ? user2.conversations : list, (i2 & 256) != 0 ? user2.realtimeSettings : realtimeSettings2, (i2 & 512) != 0 ? user2.typingSettings : typingSettings2, (i2 & 1024) != 0 ? user2.sessionToken : str8, (i2 & 2048) != 0 ? user2.jwt : str9);
    }

    public final String component1() {
        return this.id;
    }

    public final TypingSettings component10() {
        return this.typingSettings;
    }

    public final String component11$zendesk_conversationkit_conversationkit_android() {
        return this.sessionToken;
    }

    public final String component12$zendesk_conversationkit_conversationkit_android() {
        return this.jwt;
    }

    public final String component2() {
        return this.externalId;
    }

    public final String component3() {
        return this.givenName;
    }

    public final String component4() {
        return this.surname;
    }

    public final String component5() {
        return this.email;
    }

    public final String component6() {
        return this.locale;
    }

    public final String component7() {
        return this.signedUpAt;
    }

    public final List<Conversation> component8() {
        return this.conversations;
    }

    public final RealtimeSettings component9() {
        return this.realtimeSettings;
    }

    public final User copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<Conversation> list, RealtimeSettings realtimeSettings2, TypingSettings typingSettings2, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "id");
        List<Conversation> list2 = list;
        Intrinsics.checkNotNullParameter(list2, "conversations");
        RealtimeSettings realtimeSettings3 = realtimeSettings2;
        Intrinsics.checkNotNullParameter(realtimeSettings3, "realtimeSettings");
        TypingSettings typingSettings3 = typingSettings2;
        Intrinsics.checkNotNullParameter(typingSettings3, "typingSettings");
        return new User(str, str2, str3, str4, str5, str6, str7, list2, realtimeSettings3, typingSettings3, str8, str9);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof User)) {
            return false;
        }
        User user = (User) obj;
        return Intrinsics.areEqual((Object) this.id, (Object) user.id) && Intrinsics.areEqual((Object) this.externalId, (Object) user.externalId) && Intrinsics.areEqual((Object) this.givenName, (Object) user.givenName) && Intrinsics.areEqual((Object) this.surname, (Object) user.surname) && Intrinsics.areEqual((Object) this.email, (Object) user.email) && Intrinsics.areEqual((Object) this.locale, (Object) user.locale) && Intrinsics.areEqual((Object) this.signedUpAt, (Object) user.signedUpAt) && Intrinsics.areEqual((Object) this.conversations, (Object) user.conversations) && Intrinsics.areEqual((Object) this.realtimeSettings, (Object) user.realtimeSettings) && Intrinsics.areEqual((Object) this.typingSettings, (Object) user.typingSettings) && Intrinsics.areEqual((Object) this.sessionToken, (Object) user.sessionToken) && Intrinsics.areEqual((Object) this.jwt, (Object) user.jwt);
    }

    public int hashCode() {
        int hashCode = this.id.hashCode() * 31;
        String str = this.externalId;
        int i = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.givenName;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.surname;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.email;
        int hashCode5 = (hashCode4 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.locale;
        int hashCode6 = (hashCode5 + (str5 == null ? 0 : str5.hashCode())) * 31;
        String str6 = this.signedUpAt;
        int hashCode7 = (((((((hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31) + this.conversations.hashCode()) * 31) + this.realtimeSettings.hashCode()) * 31) + this.typingSettings.hashCode()) * 31;
        String str7 = this.sessionToken;
        int hashCode8 = (hashCode7 + (str7 == null ? 0 : str7.hashCode())) * 31;
        String str8 = this.jwt;
        if (str8 != null) {
            i = str8.hashCode();
        }
        return hashCode8 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("User(id=").append(this.id).append(", externalId=").append(this.externalId).append(", givenName=").append(this.givenName).append(", surname=").append(this.surname).append(", email=").append(this.email).append(", locale=").append(this.locale).append(", signedUpAt=").append(this.signedUpAt).append(", conversations=").append(this.conversations).append(", realtimeSettings=").append(this.realtimeSettings).append(", typingSettings=").append(this.typingSettings).append(", sessionToken=").append(this.sessionToken).append(", jwt=");
        sb.append(this.jwt).append(')');
        return sb.toString();
    }

    public User(String str, String str2, String str3, String str4, String str5, String str6, String str7, List<Conversation> list, RealtimeSettings realtimeSettings2, TypingSettings typingSettings2, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "id");
        Intrinsics.checkNotNullParameter(list, "conversations");
        Intrinsics.checkNotNullParameter(realtimeSettings2, "realtimeSettings");
        Intrinsics.checkNotNullParameter(typingSettings2, "typingSettings");
        this.id = str;
        this.externalId = str2;
        this.givenName = str3;
        this.surname = str4;
        this.email = str5;
        this.locale = str6;
        this.signedUpAt = str7;
        this.conversations = list;
        this.realtimeSettings = realtimeSettings2;
        this.typingSettings = typingSettings2;
        this.sessionToken = str8;
        this.jwt = str9;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ User(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, java.lang.String r23, java.util.List r24, zendesk.conversationkit.android.model.RealtimeSettings r25, zendesk.conversationkit.android.model.TypingSettings r26, java.lang.String r27, java.lang.String r28, int r29, kotlin.jvm.internal.DefaultConstructorMarker r30) {
        /*
            r16 = this;
            r0 = r29
            r1 = r0 & 1024(0x400, float:1.435E-42)
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r14 = r2
            goto L_0x000b
        L_0x0009:
            r14 = r27
        L_0x000b:
            r0 = r0 & 2048(0x800, float:2.87E-42)
            if (r0 == 0) goto L_0x0011
            r15 = r2
            goto L_0x0013
        L_0x0011:
            r15 = r28
        L_0x0013:
            r3 = r16
            r4 = r17
            r5 = r18
            r6 = r19
            r7 = r20
            r8 = r21
            r9 = r22
            r10 = r23
            r11 = r24
            r12 = r25
            r13 = r26
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.conversationkit.android.model.User.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, zendesk.conversationkit.android.model.RealtimeSettings, zendesk.conversationkit.android.model.TypingSettings, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getId() {
        return this.id;
    }

    public final String getExternalId() {
        return this.externalId;
    }

    public final String getGivenName() {
        return this.givenName;
    }

    public final String getSurname() {
        return this.surname;
    }

    public final String getEmail() {
        return this.email;
    }

    public final String getLocale() {
        return this.locale;
    }

    public final String getSignedUpAt() {
        return this.signedUpAt;
    }

    public final List<Conversation> getConversations() {
        return this.conversations;
    }

    public final RealtimeSettings getRealtimeSettings() {
        return this.realtimeSettings;
    }

    public final TypingSettings getTypingSettings() {
        return this.typingSettings;
    }

    public final String getSessionToken$zendesk_conversationkit_conversationkit_android() {
        return this.sessionToken;
    }

    public final String getJwt$zendesk_conversationkit_conversationkit_android() {
        return this.jwt;
    }

    public final AuthenticationType getAuthenticationType() {
        if (this.jwt != null) {
            return new AuthenticationType.Jwt(this.jwt);
        }
        if (this.sessionToken != null) {
            return new AuthenticationType.SessionToken(this.sessionToken);
        }
        return AuthenticationType.Unauthenticated.INSTANCE;
    }
}
