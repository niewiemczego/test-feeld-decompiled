package kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors;

import java.util.Collection;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.jvm.internal.impl.metadata.ProtoBuf;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.protobuf.MessageLite;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.NameResolverUtilKt;
import kotlin.reflect.jvm.internal.impl.serialization.deserialization.descriptors.DeserializedMemberScope;

/* compiled from: DeserializedMemberScope.kt */
final class DeserializedMemberScope$NoReorderImplementation$variableNames$2 extends Lambda implements Function0<Set<? extends Name>> {
    final /* synthetic */ DeserializedMemberScope.NoReorderImplementation this$0;
    final /* synthetic */ DeserializedMemberScope this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DeserializedMemberScope$NoReorderImplementation$variableNames$2(DeserializedMemberScope.NoReorderImplementation noReorderImplementation, DeserializedMemberScope deserializedMemberScope) {
        super(0);
        this.this$0 = noReorderImplementation;
        this.this$1 = deserializedMemberScope;
    }

    public final Set<Name> invoke() {
        DeserializedMemberScope.NoReorderImplementation noReorderImplementation = this.this$0;
        Collection linkedHashSet = new LinkedHashSet();
        DeserializedMemberScope deserializedMemberScope = noReorderImplementation.this$0;
        for (MessageLite messageLite : noReorderImplementation.propertyList) {
            linkedHashSet.add(NameResolverUtilKt.getName(deserializedMemberScope.getC().getNameResolver(), ((ProtoBuf.Property) messageLite).getName()));
        }
        return SetsKt.plus((Set) linkedHashSet, this.this$1.getNonDeclaredVariableNames());
    }
}
