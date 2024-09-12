package kotlin.reflect.jvm.internal.impl.serialization.deserialization;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;

/* compiled from: TypeDeserializer.kt */
final class TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 extends Lambda implements Function1<ProtoBuf.Type, Integer> {
    public static final TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2 INSTANCE = new TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2();

    TypeDeserializer$typeConstructor$notFoundClass$typeParametersCount$2() {
        super(1);
    }

    public final Integer invoke(ProtoBuf.Type type) {
        Intrinsics.checkNotNullParameter(type, "it");
        return Integer.valueOf(type.getArgumentCount());
    }
}
