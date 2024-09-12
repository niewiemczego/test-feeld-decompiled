package zendesk.faye;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 \b2\u00020\u0001:\u0002\u0007\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\t"}, d2 = {"Lzendesk/faye/DisconnectMessage;", "Lzendesk/faye/BayeuxMessage;", "optionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "(Lzendesk/faye/BayeuxOptionalFields;)V", "getOptionalFields", "()Lzendesk/faye/BayeuxOptionalFields;", "Builder", "Companion", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DisconnectMessage.kt */
public final class DisconnectMessage extends BayeuxMessage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final BayeuxOptionalFields optionalFields;

    public /* synthetic */ DisconnectMessage(BayeuxOptionalFields bayeuxOptionalFields, DefaultConstructorMarker defaultConstructorMarker) {
        this(bayeuxOptionalFields);
    }

    @JvmStatic
    public static final Builder builder() {
        return Companion.builder();
    }

    public final BayeuxOptionalFields getOptionalFields() {
        return this.optionalFields;
    }

    private DisconnectMessage(BayeuxOptionalFields bayeuxOptionalFields) {
        this.optionalFields = bayeuxOptionalFields;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lzendesk/faye/DisconnectMessage$Builder;", "", "()V", "optionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "build", "Lzendesk/faye/DisconnectMessage;", "withOptionalFields", "bayeuxOptionalFields", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DisconnectMessage.kt */
    public static final class Builder {
        private BayeuxOptionalFields optionalFields = BayeuxOptionalFields.Companion.builder().build();

        public final Builder withOptionalFields(BayeuxOptionalFields bayeuxOptionalFields) {
            Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
            Builder builder = this;
            this.optionalFields = bayeuxOptionalFields;
            return this;
        }

        public final DisconnectMessage build() {
            return new DisconnectMessage(this.optionalFields, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lzendesk/faye/DisconnectMessage$Companion;", "", "()V", "builder", "Lzendesk/faye/DisconnectMessage$Builder;", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DisconnectMessage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder() {
            return new Builder();
        }
    }
}
