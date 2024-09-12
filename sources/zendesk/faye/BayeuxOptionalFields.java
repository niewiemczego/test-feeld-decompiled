package zendesk.faye;

import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u0000 \n2\u00020\u0001:\u0002\t\nB\u001b\b\u0002\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u000b"}, d2 = {"Lzendesk/faye/BayeuxOptionalFields;", "", "ext", "", "id", "(Ljava/lang/String;Ljava/lang/String;)V", "getExt", "()Ljava/lang/String;", "getId", "Builder", "Companion", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BayeuxOptionalFields.kt */
public final class BayeuxOptionalFields {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String ext;
    private final String id;

    public /* synthetic */ BayeuxOptionalFields(String str, String str2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2);
    }

    @JvmStatic
    public static final Builder builder() {
        return Companion.builder();
    }

    private BayeuxOptionalFields(String str, String str2) {
        this.ext = str;
        this.id = str2;
    }

    public final String getExt() {
        return this.ext;
    }

    public final String getId() {
        return this.id;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007J\u000e\u0010\b\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u000e\u0010\t\u001a\u00020\u00002\u0006\u0010\u0005\u001a\u00020\u0004R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lzendesk/faye/BayeuxOptionalFields$Builder;", "", "()V", "ext", "", "id", "build", "Lzendesk/faye/BayeuxOptionalFields;", "withExt", "withId", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BayeuxOptionalFields.kt */
    public static final class Builder {
        private String ext;
        private String id;

        public final Builder withExt(String str) {
            Intrinsics.checkNotNullParameter(str, "ext");
            Builder builder = this;
            this.ext = str;
            return this;
        }

        public final Builder withId(String str) {
            Intrinsics.checkNotNullParameter(str, "id");
            Builder builder = this;
            this.id = str;
            return this;
        }

        public final BayeuxOptionalFields build() {
            return new BayeuxOptionalFields(this.ext, this.id, (DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0007¨\u0006\u0005"}, d2 = {"Lzendesk/faye/BayeuxOptionalFields$Companion;", "", "()V", "builder", "Lzendesk/faye/BayeuxOptionalFields$Builder;", "zendesk.faye_faye"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: BayeuxOptionalFields.kt */
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
