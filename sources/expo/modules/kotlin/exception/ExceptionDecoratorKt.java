package expo.modules.kotlin.exception;

import expo.modules.core.errors.CodedException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aH\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u00012!\u0010\u0002\u001a\u001d\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\nH\bø\u0001\u0000¢\u0006\u0002\u0010\u000b\u0002\u0007\n\u0005\b20\u0001¨\u0006\f"}, d2 = {"exceptionDecorator", "T", "decoratorBlock", "Lkotlin/Function1;", "Lexpo/modules/kotlin/exception/CodedException;", "Lkotlin/ParameterName;", "name", "e", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "expo-modules-core_release"}, k = 2, mv = {1, 7, 1}, xi = 48)
/* compiled from: ExceptionDecorator.kt */
public final class ExceptionDecoratorKt {
    public static final <T> T exceptionDecorator(Function1<? super CodedException, ? extends Throwable> function1, Function0<? extends T> function0) throws CodedException {
        Intrinsics.checkNotNullParameter(function1, "decoratorBlock");
        Intrinsics.checkNotNullParameter(function0, "block");
        try {
            return function0.invoke();
        } catch (CodedException e) {
            throw ((Throwable) function1.invoke(e));
        } catch (CodedException e2) {
            String code = e2.getCode();
            Intrinsics.checkNotNullExpressionValue(code, "e.code");
            throw ((Throwable) function1.invoke(new CodedException(code, e2.getMessage(), e2.getCause())));
        } catch (Throwable th) {
            throw ((Throwable) function1.invoke(new UnexpectedException(th)));
        }
    }
}
