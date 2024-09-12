package kotlin.reflect.jvm.internal.impl.load.kotlin;

import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.load.java.lazy.types.RawTypeImpl;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.metadata.jvm.JvmProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.FlexibleTypeDeserializer;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.KotlinTypeFactory;
import kotlin.reflect.jvm.internal.impl.types.SimpleType;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorTypeKind;
import kotlin.reflect.jvm.internal.impl.types.error.ErrorUtils;

/* compiled from: JavaFlexibleTypeDeserializer.kt */
public final class JavaFlexibleTypeDeserializer implements FlexibleTypeDeserializer {
    public static final JavaFlexibleTypeDeserializer INSTANCE = new JavaFlexibleTypeDeserializer();

    private JavaFlexibleTypeDeserializer() {
    }

    public KotlinType create(ProtoBuf.Type type, String str, SimpleType simpleType, SimpleType simpleType2) {
        Intrinsics.checkNotNullParameter(type, "proto");
        Intrinsics.checkNotNullParameter(str, "flexibleId");
        Intrinsics.checkNotNullParameter(simpleType, "lowerBound");
        Intrinsics.checkNotNullParameter(simpleType2, "upperBound");
        if (!Intrinsics.areEqual((Object) str, (Object) "kotlin.jvm.PlatformType")) {
            return ErrorUtils.createErrorType(ErrorTypeKind.ERROR_FLEXIBLE_TYPE, str, simpleType.toString(), simpleType2.toString());
        } else if (type.hasExtension(JvmProtoBuf.isRaw)) {
            return new RawTypeImpl(simpleType, simpleType2);
        } else {
            return KotlinTypeFactory.flexibleType(simpleType, simpleType2);
        }
    }
}
