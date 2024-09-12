package zendesk.messaging.android;

import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\u00020\u0002:\u0002\u0004\u0005B\u0007\b\u0004¢\u0006\u0002\u0010\u0003\u0001\u0002\u0006\u0007¨\u0006\b"}, d2 = {"Lzendesk/messaging/android/MessagingResult;", "T", "", "()V", "Failure", "Success", "Lzendesk/messaging/android/MessagingResult$Success;", "Lzendesk/messaging/android/MessagingResult$Failure;", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Deprecated(message = "Please use Zendesk SDK")
/* compiled from: MessagingResult.kt */
public abstract class MessagingResult<T> {
    public /* synthetic */ MessagingResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MessagingResult() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0001\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0001¢\u0006\u0002\u0010\u0004J\u000e\u0010\b\u001a\u00028\u0001HÆ\u0003¢\u0006\u0002\u0010\u0006J\u001e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002\b\b\u0002\u0010\u0003\u001a\u00028\u0001HÆ\u0001¢\u0006\u0002\u0010\nJ\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0013\u0010\u0003\u001a\u00028\u0001¢\u0006\n\n\u0002\u0010\u0007\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013"}, d2 = {"Lzendesk/messaging/android/MessagingResult$Success;", "T", "Lzendesk/messaging/android/MessagingResult;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lzendesk/messaging/android/MessagingResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessagingResult.kt */
    public static final class Success<T> extends MessagingResult<T> {
        private final T value;

        public static /* synthetic */ Success copy$default(Success success, T t, int i, Object obj) {
            if ((i & 1) != 0) {
                t = success.value;
            }
            return success.copy(t);
        }

        public final T component1() {
            return this.value;
        }

        public final Success<T> copy(T t) {
            return new Success<>(t);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Success) && Intrinsics.areEqual((Object) this.value, (Object) ((Success) obj).value);
        }

        public int hashCode() {
            T t = this.value;
            if (t == null) {
                return 0;
            }
            return t.hashCode();
        }

        public String toString() {
            return "Success(value=" + this.value + ')';
        }

        public Success(T t) {
            super((DefaultConstructorMarker) null);
            this.value = t;
        }

        public final T getValue() {
            return this.value;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u0015\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001J\t\u0010\u0014\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0015"}, d2 = {"Lzendesk/messaging/android/MessagingResult$Failure;", "Lzendesk/messaging/android/MessagingResult;", "", "cause", "Lzendesk/messaging/android/MessagingError;", "(Lzendesk/messaging/android/MessagingError;)V", "getCause", "()Lzendesk/messaging/android/MessagingError;", "message", "", "getMessage", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "zendesk.messaging_messaging-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: MessagingResult.kt */
    public static final class Failure extends MessagingResult {
        private final MessagingError cause;
        private final String message;

        public Failure() {
            this((MessagingError) null, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ Failure copy$default(Failure failure, MessagingError messagingError, int i, Object obj) {
            if ((i & 1) != 0) {
                messagingError = failure.cause;
            }
            return failure.copy(messagingError);
        }

        public final MessagingError component1() {
            return this.cause;
        }

        public final Failure copy(MessagingError messagingError) {
            return new Failure(messagingError);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.cause, (Object) ((Failure) obj).cause);
        }

        public int hashCode() {
            MessagingError messagingError = this.cause;
            if (messagingError == null) {
                return 0;
            }
            return messagingError.hashCode();
        }

        public String toString() {
            return "Failure(cause=" + this.cause + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Failure(MessagingError messagingError, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : messagingError);
        }

        public final MessagingError getCause() {
            return this.cause;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
            r2 = r2.getMessage();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Failure(zendesk.messaging.android.MessagingError r2) {
            /*
                r1 = this;
                r0 = 0
                r1.<init>(r0)
                r1.cause = r2
                if (r2 == 0) goto L_0x000e
                java.lang.String r2 = r2.getMessage()
                if (r2 != 0) goto L_0x0010
            L_0x000e:
                java.lang.String r2 = ""
            L_0x0010:
                r1.message = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: zendesk.messaging.android.MessagingResult.Failure.<init>(zendesk.messaging.android.MessagingError):void");
        }

        public final String getMessage() {
            return this.message;
        }
    }
}
