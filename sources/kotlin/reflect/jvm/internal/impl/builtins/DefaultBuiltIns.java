package kotlin.reflect.jvm.internal.impl.builtins;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.reflect.jvm.internal.impl.storage.LockBasedStorageManager;

/* compiled from: DefaultBuiltIns.kt */
public final class DefaultBuiltIns extends KotlinBuiltIns {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static final DefaultBuiltIns Instance = new DefaultBuiltIns(false, 1, (DefaultConstructorMarker) null);

    public DefaultBuiltIns() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public DefaultBuiltIns(boolean z) {
        super(new LockBasedStorageManager("DefaultBuiltIns"));
        if (z) {
            createBuiltInsModule(false);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultBuiltIns(boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? true : z);
    }

    /* compiled from: DefaultBuiltIns.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final DefaultBuiltIns getInstance() {
            return DefaultBuiltIns.Instance;
        }
    }
}
