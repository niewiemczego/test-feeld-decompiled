package expo.modules.kotlin.records;

import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Retention;

@Target({})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.PROPERTY})
@BindUsing(binder = IsCollectionNotEmptyBinder.class)
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lexpo/modules/kotlin/records/IsNotEmpty;", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Retention(AnnotationRetention.RUNTIME)
@java.lang.annotation.Retention(RetentionPolicy.RUNTIME)
/* compiled from: Validators.kt */
public @interface IsNotEmpty {
}
