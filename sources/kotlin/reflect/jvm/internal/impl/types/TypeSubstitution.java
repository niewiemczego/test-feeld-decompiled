package kotlin.reflect.jvm.internal.impl.types;

import com.facebook.react.uimanager.ViewProps;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.descriptors.annotations.Annotations;

/* compiled from: TypeSubstitution.kt */
public abstract class TypeSubstitution {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final TypeSubstitution EMPTY = new TypeSubstitution$Companion$EMPTY$1();

    public boolean approximateCapturedTypes() {
        return false;
    }

    public boolean approximateContravariantCapturedTypes() {
        return false;
    }

    public Annotations filterAnnotations(Annotations annotations) {
        Intrinsics.checkNotNullParameter(annotations, "annotations");
        return annotations;
    }

    public abstract TypeProjection get(KotlinType kotlinType);

    public boolean isEmpty() {
        return false;
    }

    public KotlinType prepareTopLevelType(KotlinType kotlinType, Variance variance) {
        Intrinsics.checkNotNullParameter(kotlinType, "topLevelType");
        Intrinsics.checkNotNullParameter(variance, ViewProps.POSITION);
        return kotlinType;
    }

    /* compiled from: TypeSubstitution.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final TypeSubstitutor buildSubstitutor() {
        TypeSubstitutor create = TypeSubstitutor.create(this);
        Intrinsics.checkNotNullExpressionValue(create, "create(this)");
        return create;
    }

    public final TypeSubstitution replaceWithNonApproximating() {
        return new TypeSubstitution$replaceWithNonApproximating$1(this);
    }
}
