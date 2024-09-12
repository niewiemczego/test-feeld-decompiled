package expo.modules.kotlin.exception;

import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0002\b\t\b\u0017\u0018\u0000 \u000f2\u00060\u0001j\u0002`\u0002:\u0001\u000fB#\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u000f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\tB\u0007\b\u0016¢\u0006\u0002\u0010\nB\u001b\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bR\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lexpo/modules/kotlin/exception/CodedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "code", "", "message", "cause", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V", "(Ljava/lang/Throwable;)V", "()V", "(Ljava/lang/String;Ljava/lang/Throwable;)V", "getCode", "()Ljava/lang/String;", "providedCode", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CodedException.kt */
public class CodedException extends Exception {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private String providedCode;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CodedException(String str, Throwable th, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : th);
    }

    public CodedException(String str, Throwable th) {
        super(str, th);
    }

    public final String getCode() {
        String str = this.providedCode;
        return str == null ? Companion.inferCode(getClass()) : str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CodedException(String str, String str2, Throwable th) {
        this(str2, th);
        Intrinsics.checkNotNullParameter(str, "code");
        this.providedCode = str;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public CodedException(Throwable th) {
        this(th.getLocalizedMessage(), th);
        Intrinsics.checkNotNullParameter(th, "cause");
    }

    public CodedException() {
        this((String) null, (Throwable) null);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\n\u0010\u0005\u001a\u0006\u0012\u0002\b\u00030\u0006H\u0001¨\u0006\u0007"}, d2 = {"Lexpo/modules/kotlin/exception/CodedException$Companion;", "", "()V", "inferCode", "", "clazz", "Ljava/lang/Class;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CodedException.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String inferCode(Class<?> cls) {
            Intrinsics.checkNotNullParameter(cls, "clazz");
            String simpleName = cls.getSimpleName();
            if (simpleName != null) {
                Regex regex = new Regex("(Exception)$");
                String replace = new Regex("(.)([A-Z])").replace((CharSequence) regex.replace((CharSequence) simpleName, ""), "$1_$2");
                Locale locale = Locale.ROOT;
                Intrinsics.checkNotNullExpressionValue(locale, "ROOT");
                String upperCase = replace.toUpperCase(locale);
                Intrinsics.checkNotNullExpressionValue(upperCase, "this as java.lang.String).toUpperCase(locale)");
                return "ERR_" + upperCase;
            }
            throw new IllegalArgumentException("Cannot infer code name from class name. We don't support anonymous classes.".toString());
        }
    }
}
