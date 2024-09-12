package kotlin.reflect.jvm.internal.impl.descriptors;

import com.facebook.react.uimanager.ViewProps;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.name.Name;
import kotlin.reflect.jvm.internal.impl.types.model.SimpleTypeMarker;

/* compiled from: ValueClassRepresentation.kt */
public abstract class ValueClassRepresentation<Type extends SimpleTypeMarker> {
    public /* synthetic */ ValueClassRepresentation(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    public abstract List<Pair<Name, Type>> getUnderlyingPropertyNamesToTypes();

    private ValueClassRepresentation() {
    }

    public final <Other extends SimpleTypeMarker> ValueClassRepresentation<Other> mapUnderlyingType(Function1<? super Type, ? extends Other> function1) {
        Intrinsics.checkNotNullParameter(function1, ViewProps.TRANSFORM);
        if (this instanceof InlineClassRepresentation) {
            InlineClassRepresentation inlineClassRepresentation = (InlineClassRepresentation) this;
            return new InlineClassRepresentation<>(inlineClassRepresentation.getUnderlyingPropertyName(), (SimpleTypeMarker) function1.invoke(inlineClassRepresentation.getUnderlyingType()));
        } else if (this instanceof MultiFieldValueClassRepresentation) {
            Iterable<Pair> underlyingPropertyNamesToTypes = getUnderlyingPropertyNamesToTypes();
            Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(underlyingPropertyNamesToTypes, 10));
            for (Pair pair : underlyingPropertyNamesToTypes) {
                arrayList.add(TuplesKt.to((Name) pair.component1(), function1.invoke((SimpleTypeMarker) pair.component2())));
            }
            return new MultiFieldValueClassRepresentation<>((List) arrayList);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }
}
