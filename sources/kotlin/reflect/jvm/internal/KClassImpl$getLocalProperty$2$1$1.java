package kotlin.reflect.jvm.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FunctionReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KDeclarationContainer;
import kotlin.reflect.jvm.internal.impl.descriptors.PropertyDescriptor;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.MemberDeserializer;

@Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: KClassImpl.kt */
/* synthetic */ class KClassImpl$getLocalProperty$2$1$1 extends FunctionReference implements Function2<MemberDeserializer, ProtoBuf.Property, PropertyDescriptor> {
    public static final KClassImpl$getLocalProperty$2$1$1 INSTANCE = new KClassImpl$getLocalProperty$2$1$1();

    KClassImpl$getLocalProperty$2$1$1() {
        super(2);
    }

    public final String getName() {
        return "loadProperty";
    }

    public final String getSignature() {
        return "loadProperty(Lorg/jetbrains/kotlin/metadata/ProtoBuf$Property;)Lorg/jetbrains/kotlin/descriptors/PropertyDescriptor;";
    }

    public final KDeclarationContainer getOwner() {
        return Reflection.getOrCreateKotlinClass(MemberDeserializer.class);
    }

    public final PropertyDescriptor invoke(MemberDeserializer memberDeserializer, ProtoBuf.Property property) {
        Intrinsics.checkNotNullParameter(memberDeserializer, "p0");
        Intrinsics.checkNotNullParameter(property, "p1");
        return memberDeserializer.loadProperty(property);
    }
}
