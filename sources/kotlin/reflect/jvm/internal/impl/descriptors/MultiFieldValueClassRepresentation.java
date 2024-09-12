package kotlin.reflect.jvm.internal.impl.descriptors;

import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: MultiFieldValueClassRepresentation.kt */
public final class MultiFieldValueClassRepresentation<Type extends SimpleTypeMarker> extends ValueClassRepresentation<Type> {
    private final Map<Name, Type> map;
    private final List<Pair<Name, Type>> underlyingPropertyNamesToTypes;

    public List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes() {
        return this.underlyingPropertyNamesToTypes;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MultiFieldValueClassRepresentation(List<? extends Pair<Name, ? extends Type>> list) {
        super((DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(list, "underlyingPropertyNamesToTypes");
        this.underlyingPropertyNamesToTypes = list;
        Map<Name, Type> map2 = MapsKt.toMap(getUnderlyingPropertyNamesToTypes());
        if (map2.size() == getUnderlyingPropertyNamesToTypes().size()) {
            this.map = map2;
            return;
        }
        throw new IllegalArgumentException("Some properties have the same names".toString());
    }
}
