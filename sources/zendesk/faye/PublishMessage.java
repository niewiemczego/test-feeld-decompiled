package zendesk.faye;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u000e2\u00020\u0001:\u0002\r\u000eB\u001f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u000f"}, d2 = {"Lzendesk/faye/PublishMessage;", "Lzendesk/faye/BayeuxMessage;", "channel", "", "message", "optionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "(Ljava/lang/String;Ljava/lang/String;Lzendesk/faye/BayeuxOptionalFields;)V", "getChannel", "()Ljava/lang/String;", "getMessage", "getOptionalFields", "()Lzendesk/faye/BayeuxOptionalFields;", "Builder", "Companion", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PublishMessage.kt */
public final class PublishMessage extends BayeuxMessage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String channel;
    private final String message;
    private final BayeuxOptionalFields optionalFields;

    public /* synthetic */ PublishMessage(String str, String str2, BayeuxOptionalFields bayeuxOptionalFields, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, bayeuxOptionalFields);
    }

    @JvmStatic
    public static final Builder builder(String str, String str2) {
        return Companion.builder(str, str2);
    }

    public final String getChannel() {
        return this.channel;
    }

    public final String getMessage() {
        return this.message;
    }

    public final BayeuxOptionalFields getOptionalFields() {
        return this.optionalFields;
    }

    private PublishMessage(String str, String str2, BayeuxOptionalFields bayeuxOptionalFields) {
        this.channel = str;
        this.message = str2;
        this.optionalFields = bayeuxOptionalFields;
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\u00002\u0006\u0010\u000b\u001a\u00020\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lzendesk/faye/PublishMessage$Builder;", "", "channel", "", "message", "(Ljava/lang/String;Ljava/lang/String;)V", "optionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "build", "Lzendesk/faye/PublishMessage;", "withOptionalFields", "bayeuxOptionalFields", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PublishMessage.kt */
    public static final class Builder {
        private final String channel;
        private final String message;
        private BayeuxOptionalFields optionalFields = BayeuxOptionalFields.Companion.builder().build();

        public Builder(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "channel");
            Intrinsics.checkNotNullParameter(str2, "message");
            this.channel = str;
            this.message = str2;
        }

        public final Builder withOptionalFields(BayeuxOptionalFields bayeuxOptionalFields) {
            Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
            Builder builder = this;
            this.optionalFields = bayeuxOptionalFields;
            return this;
        }

        public final PublishMessage build() {
            return new PublishMessage(this.channel, this.message, this.optionalFields, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0007¨\u0006\b"}, d2 = {"Lzendesk/faye/PublishMessage$Companion;", "", "()V", "builder", "Lzendesk/faye/PublishMessage$Builder;", "channel", "", "message", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PublishMessage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final Builder builder(String str, String str2) {
            Intrinsics.checkNotNullParameter(str, "channel");
            Intrinsics.checkNotNullParameter(str2, "message");
            return new Builder(str, str2);
        }
    }
}
