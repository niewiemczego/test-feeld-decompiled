package kotlin.reflect.jvm.internal.impl.types.checker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.resolve.OverridingUtil;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: NewKotlinTypeChecker.kt */
public interface NewKotlinTypeChecker extends KotlinTypeChecker {
    public static final Companion Companion = Companion.$$INSTANCE;

    KotlinTypeRefiner getKotlinTypeRefiner();

    OverridingUtil getOverridingUtil();

    /* compiled from: NewKotlinTypeChecker.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        private static final NewKotlinTypeCheckerImpl Default = new NewKotlinTypeCheckerImpl(KotlinTypeRefiner.Default.INSTANCE, (KotlinTypePreparator) null, 2, (DefaultConstructorMarker) null);

        private Companion() {
        }

        public final NewKotlinTypeCheckerImpl getDefault() {
            return Default;
        }
    }
}
