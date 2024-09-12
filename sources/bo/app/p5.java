package bo.app;

import com.braze.models.IPutIntoJson;
import java.util.UUID;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

public final class p5 implements IPutIntoJson {
    public static final a d = new a((DefaultConstructorMarker) null);
    private final UUID b;
    private final String c;

    public static final class a {
        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final p5 a() {
            UUID randomUUID = UUID.randomUUID();
            Intrinsics.checkNotNullExpressionValue(randomUUID, "randomUUID()");
            return new p5(randomUUID);
        }

        private a() {
        }

        public final p5 a(String str) {
            Intrinsics.checkNotNullParameter(str, "sessionId");
            UUID fromString = UUID.fromString(str);
            Intrinsics.checkNotNullExpressionValue(fromString, "fromString(sessionId)");
            return new p5(fromString);
        }
    }

    public p5(UUID uuid) {
        Intrinsics.checkNotNullParameter(uuid, "sessionIdUuid");
        this.b = uuid;
        String uuid2 = uuid.toString();
        Intrinsics.checkNotNullExpressionValue(uuid2, "sessionIdUuid.toString()");
        this.c = uuid2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof p5) && Intrinsics.areEqual((Object) this.b, (Object) ((p5) obj).b);
    }

    public int hashCode() {
        return this.b.hashCode();
    }

    public String toString() {
        return this.c;
    }

    /* renamed from: u */
    public String forJsonPut() {
        return this.c;
    }
}
