package zendesk.messaging.android.internal.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b0\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0002\u0005\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/messaging/android/internal/model/TypingUser;", "", "()V", "None", "User", "Lzendesk/messaging/android/internal/model/TypingUser$User;", "Lzendesk/messaging/android/internal/model/TypingUser$None;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TypingUser.kt */
public abstract class TypingUser {
    public /* synthetic */ TypingUser(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private TypingUser() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/messaging/android/internal/model/TypingUser$User;", "Lzendesk/messaging/android/internal/model/TypingUser;", "avatarUrl", "", "(Ljava/lang/String;)V", "getAvatarUrl", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TypingUser.kt */
    public static final class User extends TypingUser {
        private final String avatarUrl;

        public static /* synthetic */ User copy$default(User user, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = user.avatarUrl;
            }
            return user.copy(str);
        }

        public final String component1() {
            return this.avatarUrl;
        }

        public final User copy(String str) {
            Intrinsics.checkNotNullParameter(str, "avatarUrl");
            return new User(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof User) && Intrinsics.areEqual((Object) this.avatarUrl, (Object) ((User) obj).avatarUrl);
        }

        public int hashCode() {
            return this.avatarUrl.hashCode();
        }

        public String toString() {
            return "User(avatarUrl=" + this.avatarUrl + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public User(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "avatarUrl");
            this.avatarUrl = str;
        }

        public final String getAvatarUrl() {
            return this.avatarUrl;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/messaging/android/internal/model/TypingUser$None;", "Lzendesk/messaging/android/internal/model/TypingUser;", "()V", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: TypingUser.kt */
    public static final class None extends TypingUser {
        public static final None INSTANCE = new None();

        private None() {
            super((DefaultConstructorMarker) null);
        }
    }
}
