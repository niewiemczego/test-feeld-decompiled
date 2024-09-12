package expo.modules.kotlin.records;

import java.lang.annotation.RetentionPolicy;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;
import kotlin.annotation.Target;

@Target(allowedTargets = {AnnotationTarget.PROPERTY})
@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Target({})
@BindUsing(binder = FloatRangeBinder.class)
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B$\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\bR\u000f\u0010\u0005\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\b\u0005\u0010\tR\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0004\u0010\bR\u000f\u0010\u0007\u001a\u00020\u0006¢\u0006\u0006\u001a\u0004\b\u0007\u0010\t¨\u0006\n"}, d2 = {"Lexpo/modules/kotlin/records/FloatRange;", "", "from", "", "to", "fromInclusive", "", "toInclusive", "()F", "()Z", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: Validators.kt */
public @interface FloatRange {
    float from();

    boolean fromInclusive() default true;

    float to();

    boolean toInclusive() default true;
}
