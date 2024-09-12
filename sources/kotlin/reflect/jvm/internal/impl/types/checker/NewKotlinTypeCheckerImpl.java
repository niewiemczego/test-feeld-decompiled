package kotlin.reflect.jvm.internal.impl.types.checker;

import com.braze.Constants;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.AbstractTypeChecker;
import kotlin.reflect.jvm.internal.impl.types.KotlinType;
import kotlin.reflect.jvm.internal.impl.types.TypeCheckerState;
import kotlin.reflect.jvm.internal.impl.types.UnwrappedType;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypePreparator;

/* compiled from: NewKotlinTypeChecker.kt */
public final class NewKotlinTypeCheckerImpl implements NewKotlinTypeChecker {
    private final KotlinTypePreparator kotlinTypePreparator;
    private final KotlinTypeRefiner kotlinTypeRefiner;
    private final OverridingUtil overridingUtil;

    public NewKotlinTypeCheckerImpl(KotlinTypeRefiner kotlinTypeRefiner2, KotlinTypePreparator kotlinTypePreparator2) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner2, "kotlinTypeRefiner");
        Intrinsics.checkNotNullParameter(kotlinTypePreparator2, "kotlinTypePreparator");
        this.kotlinTypeRefiner = kotlinTypeRefiner2;
        this.kotlinTypePreparator = kotlinTypePreparator2;
        OverridingUtil createWithTypeRefiner = OverridingUtil.createWithTypeRefiner(getKotlinTypeRefiner());
        Intrinsics.checkNotNullExpressionValue(createWithTypeRefiner, "createWithTypeRefiner(kotlinTypeRefiner)");
        this.overridingUtil = createWithTypeRefiner;
    }

    public KotlinTypeRefiner getKotlinTypeRefiner() {
        return this.kotlinTypeRefiner;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ NewKotlinTypeCheckerImpl(KotlinTypeRefiner kotlinTypeRefiner2, KotlinTypePreparator kotlinTypePreparator2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(kotlinTypeRefiner2, (i & 2) != 0 ? KotlinTypePreparator.Default.INSTANCE : kotlinTypePreparator2);
    }

    public KotlinTypePreparator getKotlinTypePreparator() {
        return this.kotlinTypePreparator;
    }

    public OverridingUtil getOverridingUtil() {
        return this.overridingUtil;
    }

    public boolean isSubtypeOf(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, "subtype");
        Intrinsics.checkNotNullParameter(kotlinType2, "supertype");
        return isSubtypeOf(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(true, false, (ClassicTypeSystemContext) null, getKotlinTypePreparator(), getKotlinTypeRefiner(), 6, (Object) null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public boolean equalTypes(KotlinType kotlinType, KotlinType kotlinType2) {
        Intrinsics.checkNotNullParameter(kotlinType, Constants.BRAZE_PUSH_CONTENT_KEY);
        Intrinsics.checkNotNullParameter(kotlinType2, "b");
        return equalTypes(ClassicTypeCheckerStateKt.createClassicTypeCheckerState$default(false, false, (ClassicTypeSystemContext) null, getKotlinTypePreparator(), getKotlinTypeRefiner(), 6, (Object) null), kotlinType.unwrap(), kotlinType2.unwrap());
    }

    public final boolean equalTypes(TypeCheckerState typeCheckerState, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "<this>");
        Intrinsics.checkNotNullParameter(unwrappedType, Constants.BRAZE_PUSH_CONTENT_KEY);
        Intrinsics.checkNotNullParameter(unwrappedType2, "b");
        return AbstractTypeChecker.INSTANCE.equalTypes(typeCheckerState, unwrappedType, unwrappedType2);
    }

    public final boolean isSubtypeOf(TypeCheckerState typeCheckerState, UnwrappedType unwrappedType, UnwrappedType unwrappedType2) {
        Intrinsics.checkNotNullParameter(typeCheckerState, "<this>");
        Intrinsics.checkNotNullParameter(unwrappedType, "subType");
        Intrinsics.checkNotNullParameter(unwrappedType2, "superType");
        return AbstractTypeChecker.isSubtypeOf$default(AbstractTypeChecker.INSTANCE, typeCheckerState, unwrappedType, unwrappedType2, false, 8, (Object) null);
    }
}
