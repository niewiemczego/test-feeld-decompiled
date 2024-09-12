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
@BindUsing(binder = SizeBinder.class)
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0014\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003R\u000f\u0010\u0004\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u000f\u0010\u0002\u001a\u00020\u0003¢\u0006\u0006\u001a\u0004\b\u0002\u0010\u0005¨\u0006\u0006"}, d2 = {"Lexpo/modules/kotlin/records/Size;", "", "min", "", "max", "()I", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: Validators.kt */
public @interface Size {
    int max() default Integer.MAX_VALUE;

    int min() default 0;
}
