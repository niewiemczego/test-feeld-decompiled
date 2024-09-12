package zendesk.conversationkit.android.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0003\u0006\u0007\b¨\u0006\t"}, d2 = {"Lzendesk/conversationkit/android/model/AuthenticationType;", "", "()V", "Jwt", "SessionToken", "Unauthenticated", "Lzendesk/conversationkit/android/model/AuthenticationType$SessionToken;", "Lzendesk/conversationkit/android/model/AuthenticationType$Jwt;", "Lzendesk/conversationkit/android/model/AuthenticationType$Unauthenticated;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthenticationType.kt */
public abstract class AuthenticationType {
    public /* synthetic */ AuthenticationType(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AuthenticationType() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/model/AuthenticationType$SessionToken;", "Lzendesk/conversationkit/android/model/AuthenticationType;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuthenticationType.kt */
    public static final class SessionToken extends AuthenticationType {
        private final String value;

        public static /* synthetic */ SessionToken copy$default(SessionToken sessionToken, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionToken.value;
            }
            return sessionToken.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final SessionToken copy(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return new SessionToken(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SessionToken) && Intrinsics.areEqual((Object) this.value, (Object) ((SessionToken) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "SessionToken(value=" + this.value + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SessionToken(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lzendesk/conversationkit/android/model/AuthenticationType$Jwt;", "Lzendesk/conversationkit/android/model/AuthenticationType;", "value", "", "(Ljava/lang/String;)V", "getValue", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuthenticationType.kt */
    public static final class Jwt extends AuthenticationType {
        private final String value;

        public static /* synthetic */ Jwt copy$default(Jwt jwt, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = jwt.value;
            }
            return jwt.copy(str);
        }

        public final String component1() {
            return this.value;
        }

        public final Jwt copy(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            return new Jwt(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Jwt) && Intrinsics.areEqual((Object) this.value, (Object) ((Jwt) obj).value);
        }

        public int hashCode() {
            return this.value.hashCode();
        }

        public String toString() {
            return "Jwt(value=" + this.value + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Jwt(String str) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(str, "value");
            this.value = str;
        }

        public final String getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lzendesk/conversationkit/android/model/AuthenticationType$Unauthenticated;", "Lzendesk/conversationkit/android/model/AuthenticationType;", "()V", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AuthenticationType.kt */
    public static final class Unauthenticated extends AuthenticationType {
        public static final Unauthenticated INSTANCE = new Unauthenticated();

        private Unauthenticated() {
            super((DefaultConstructorMarker) null);
        }
    }
}
