package zendesk.android;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0001*\u0006\b\u0001\u0010\u0002 \u00012\u00020\u0003:\u0002\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0004\u0001\u0002\u0007\b¨\u0006\t"}, d2 = {"Lzendesk/android/ZendeskResult;", "T", "E", "", "()V", "Failure", "Success", "Lzendesk/android/ZendeskResult$Success;", "Lzendesk/android/ZendeskResult$Failure;", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ZendeskResult.kt */
public abstract class ZendeskResult<T, E> {
    public /* synthetic */ ZendeskResult(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ZendeskResult() {
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u00020\u00030\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lzendesk/android/ZendeskResult$Success;", "T", "Lzendesk/android/ZendeskResult;", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lzendesk/android/ZendeskResult$Success;", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZendeskResult.kt */
    public static final class Success<T> extends ZendeskResult {
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

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u0000*\u0004\b\u0002\u0010\u00012\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u0002H\u00010\u0002B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0002¢\u0006\u0002\u0010\u0005J\u000e\u0010\t\u001a\u00028\u0002HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00028\u0002HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001J\t\u0010\u0012\u001a\u00020\u0013HÖ\u0001R\u0013\u0010\u0004\u001a\u00028\u0002¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0014"}, d2 = {"Lzendesk/android/ZendeskResult$Failure;", "E", "Lzendesk/android/ZendeskResult;", "", "error", "(Ljava/lang/Object;)V", "getError", "()Ljava/lang/Object;", "Ljava/lang/Object;", "component1", "copy", "(Ljava/lang/Object;)Lzendesk/android/ZendeskResult$Failure;", "equals", "", "other", "", "hashCode", "", "toString", "", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ZendeskResult.kt */
    public static final class Failure<E> extends ZendeskResult {
        private final E error;

        public static /* synthetic */ Failure copy$default(Failure failure, E e, int i, Object obj) {
            if ((i & 1) != 0) {
                e = failure.error;
            }
            return failure.copy(e);
        }

        public final E component1() {
            return this.error;
        }

        public final Failure<E> copy(E e) {
            return new Failure<>(e);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Failure) && Intrinsics.areEqual((Object) this.error, (Object) ((Failure) obj).error);
        }

        public int hashCode() {
            E e = this.error;
            if (e == null) {
                return 0;
            }
            return e.hashCode();
        }

        public String toString() {
            return "Failure(error=" + this.error + ')';
        }

        public Failure(E e) {
            super((DefaultConstructorMarker) null);
            this.error = e;
        }

        public final E getError() {
            return this.error;
        }
    }
}
