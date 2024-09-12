package zendesk.conversationkit.android.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\b\u0001\u0018\u0000 \n2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\nB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\u000b"}, d2 = {"Lzendesk/conversationkit/android/model/FieldType;", "", "value", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getValue$zendesk_conversationkit_conversationkit_android", "()Ljava/lang/String;", "TEXT", "EMAIL", "SELECT", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Field.kt */
public enum FieldType {
    TEXT("text"),
    EMAIL("email"),
    SELECT("select");
    
    public static final Companion Companion = null;
    private final String value;

    private FieldType(String str) {
        this.value = str;
    }

    public final String getValue$zendesk_conversationkit_conversationkit_android() {
        return this.value;
    }

    static {
        Companion = new Companion((DefaultConstructorMarker) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/model/FieldType$Companion;", "", "()V", "findByValue", "Lzendesk/conversationkit/android/model/FieldType;", "value", "", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: Field.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final FieldType findByValue(String str) {
            Intrinsics.checkNotNullParameter(str, "value");
            for (FieldType fieldType : FieldType.values()) {
                if (Intrinsics.areEqual((Object) fieldType.getValue$zendesk_conversationkit_conversationkit_android(), (Object) str)) {
                    return fieldType;
                }
            }
            return null;
        }
    }
}
