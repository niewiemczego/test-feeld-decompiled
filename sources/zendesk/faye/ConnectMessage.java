package zendesk.faye;

import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u0000 \u000f2\u00020\u0001:\u0002\u000e\u000fB%\b\u0002\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0002\u0010\bR\u0011\u0010\u0007\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0010"}, d2 = {"Lzendesk/faye/ConnectMessage;", "Lzendesk/faye/BayeuxMessage;", "supportedConnectionTypes", "", "", "handshakeOptionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "connectOptionalFields", "(Ljava/util/List;Lzendesk/faye/BayeuxOptionalFields;Lzendesk/faye/BayeuxOptionalFields;)V", "getConnectOptionalFields", "()Lzendesk/faye/BayeuxOptionalFields;", "getHandshakeOptionalFields", "getSupportedConnectionTypes", "()Ljava/util/List;", "Builder", "Companion", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConnectMessage.kt */
public final class ConnectMessage extends BayeuxMessage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final BayeuxOptionalFields connectOptionalFields;
    private final BayeuxOptionalFields handshakeOptionalFields;
    private final List<String> supportedConnectionTypes;

    public /* synthetic */ ConnectMessage(List list, BayeuxOptionalFields bayeuxOptionalFields, BayeuxOptionalFields bayeuxOptionalFields2, DefaultConstructorMarker defaultConstructorMarker) {
        this(list, bayeuxOptionalFields, bayeuxOptionalFields2);
    }

    @JvmStatic
    public static final Builder builder() {
        return Companion.builder();
    }

    public final List<String> getSupportedConnectionTypes() {
        return this.supportedConnectionTypes;
    }

    public final BayeuxOptionalFields getHandshakeOptionalFields() {
        return this.handshakeOptionalFields;
    }

    public final BayeuxOptionalFields getConnectOptionalFields() {
        return this.connectOptionalFields;
    }

    private ConnectMessage(List<String> list, BayeuxOptionalFields bayeuxOptionalFields, BayeuxOptionalFields bayeuxOptionalFields2) {
        this.supportedConnectionTypes = list;
        this.handshakeOptionalFields = bayeuxOptionalFields;
        this.connectOptionalFields = bayeuxOptionalFields2;
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0007\b\u0000¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u000b\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010\r\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u0014\u0010\u000e\u001a\u00020\u00002\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lzendesk/faye/ConnectMessage$Builder;", "", "()V", "connectOptionalFields", "Lzendesk/faye/BayeuxOptionalFields;", "handshakeOptionalFields", "supportedConnectionTypes", "", "", "build", "Lzendesk/faye/ConnectMessage;", "withConnectOptionalFields", "bayeuxOptionalFields", "withHandshakeOptionalFields", "withSupportedConnectionTypes", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectMessage.kt */
    public static final class Builder {
        private BayeuxOptionalFields connectOptionalFields = BayeuxOptionalFields.Companion.builder().build();
        private BayeuxOptionalFields handshakeOptionalFields = BayeuxOptionalFields.Companion.builder().build();
        private List<String> supportedConnectionTypes = CollectionsKt.emptyList();

        public final Builder withSupportedConnectionTypes(List<String> list) {
            Intrinsics.checkNotNullParameter(list, "supportedConnectionTypes");
            Builder builder = this;
            this.supportedConnectionTypes = list;
            return this;
        }

        public final Builder withHandshakeOptionalFields(BayeuxOptionalFields bayeuxOptionalFields) {
            Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
            Builder builder = this;
            this.handshakeOptionalFields = bayeuxOptionalFields;
            return this;
        }

        public final Builder withConnectOptionalFields(BayeuxOptionalFields bayeuxOptionalFields) {
            Intrinsics.checkNotNullParameter(bayeuxOptionalFields, "bayeuxOptionalFields");
            Builder builder = this;
            this.connectOptionalFields = bayeuxOptionalFields;
            return this;
        }

        public final ConnectMessage build() {
            return new ConnectMessage(this.supportedConnectionTypes, this.handshakeOptionalFields, this.connectOptionalFields, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lzendesk/faye/ConnectMessage$Companion;", "", "()V", "builder", "Lzendesk/faye/ConnectMessage$Builder;", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ConnectMessage.kt */
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
