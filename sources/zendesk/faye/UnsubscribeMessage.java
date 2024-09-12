package zendesk.faye;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 \f2\u00020\u0001:\u0002\u000b\fB\u0017\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\r"}, d2 = {"Lzendesk/faye/UnsubscribeMessage;", "Lzendesk/faye/BayeuxMessage;", "channel", "", "optionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "(Ljava/lang/String;Lzendesk/faye/BayeuxOptionalFields;)V", "getChannel", "()Ljava/lang/String;", "getOptionalFields", "()Lzendesk/faye/BayeuxOptionalFields;", "Builder", "Companion", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UnsubscribeMessage.kt */
public final class UnsubscribeMessage extends BayeuxMessage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String channel;
    private final BayeuxOptionalFields optionalFields;

    public /* synthetic */ UnsubscribeMessage(String str, BayeuxOptionalFields bayeuxOptionalFields, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, bayeuxOptionalFields);
    }

    @JvmStatic
    public static final Builder builder(String str) {
        return Companion.builder(str);
    }

    public final String getChannel() {
        return this.channel;
    }

    public final BayeuxOptionalFields getOptionalFields() {
        return this.optionalFields;
    }

    private UnsubscribeMessage(String str, BayeuxOptionalFields bayeuxOptionalFields) {
        this.channel = str;
        this.optionalFields = bayeuxOptionalFields;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u000f\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lzendesk/faye/UnsubscribeMessage$Builder;", "", "channel", "", "(Ljava/lang/String;)V", "optionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "build", "Lzendesk/faye/UnsubscribeMessage;", "withOptionalFields", "bayeuxOptionalFields", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnsubscribeMessage.kt */
    public static final class Builder {
        private final String channel;
        private BayeuxOptionalFields optionalFields = BayeuxOptionalFields.Companion.builder().build();

        public Builder(String str) {
            Intrinsics.checkNotNullParameter(str, "channel");
            this.channel = str;
        }

        public final Builder withOptionalFields(BayeuxOptionalFields bayeuxOptionalFields) {
            Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
            Builder builder = this;
            this.optionalFields = bayeuxOptionalFields;
            return this;
        }

        public final UnsubscribeMessage build() {
            return new UnsubscribeMessage(this.channel, this.optionalFields, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lzendesk/faye/UnsubscribeMessage$Companion;", "", "()V", "builder", "Lzendesk/faye/UnsubscribeMessage$Builder;", "channel", "", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UnsubscribeMessage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder(String str) {
            Intrinsics.checkNotNullParameter(str, "channel");
            return new Builder(str);
        }
    }
}
