package expo.modules.kotlin.exception;

import com.braze.Constants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\n¨\u0006\f"}, d2 = {"Lexpo/modules/kotlin/exception/ArgumentCastException;", "Lexpo/modules/kotlin/exception/DecoratedException;", "argDesiredType", "Lkotlin/reflect/KType;", "argIndex", "", "providedType", "", "cause", "Lexpo/modules/kotlin/exception/CodedException;", "(Lkotlin/reflect/KType;ILjava/lang/String;Lexpo/modules/kotlin/exception/CodedException;)V", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public final class ArgumentCastException extends DecoratedException {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ArgumentCastException(KType kType, int i, String str, CodedException codedException) {
        super("The " + Companion.formatOrdinalNumber(i + 1) + " argument cannot be cast to type " + kType + " (received " + str + ")", codedException);
        Intrinsics.checkNotNullParameter(kType, "argDesiredType");
        Intrinsics.checkNotNullParameter(str, "providedType");
        Intrinsics.checkNotNullParameter(codedException, "cause");
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/ArgumentCastException$Companion;", "", "()V", "formatOrdinalNumber", "", "number", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CodedException.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String formatOrdinalNumber(int i) {
            int i2 = i % 100;
            boolean z = false;
            if (11 <= i2 && i2 < 14) {
                z = true;
            }
            String str = "th";
            if (!z) {
                int i3 = i % 10;
                if (i3 == 1) {
                    str = "st";
                } else if (i3 == 2) {
                    str = Constants.BRAZE_PUSH_NOTIFICATION_DURATION_KEY;
                } else if (i3 == 3) {
                    str = "rd";
                }
            }
            return i + str;
        }
    }
}
