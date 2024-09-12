package kotlin.reflect.jvm.internal.impl.descriptors;

import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty;
import kotlin.reflect.jvm.internal.impl.resolve.descriptorUtil.DescriptorUtilsKt;
import kotlin.reflect.jvm.internal.impl.resolve.scopes.MemberScope;
import kotlin.reflect.jvm.internal.impl.storage.NotNullLazyValue;
import kotlin.reflect.jvm.internal.impl.storage.StorageKt;
import kotlin.reflect.jvm.internal.impl.storage.StorageManager;
import kotlin.reflect.jvm.internal.impl.types.TypeConstructor;
import kotlin.reflect.jvm.internal.impl.types.checker.KotlinTypeRefiner;

/* compiled from: ScopesHolderForClass.kt */
public final class ScopesHolderForClass<T extends MemberScope> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(Reflection.getOrCreateKotlinClass(ScopesHolderForClass.class), "scopeForOwnerModule", "getScopeForOwnerModule()Lorg/jetbrains/kotlin/resolve/scopes/MemberScope;"))};
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final ClassDescriptor classDescriptor;
    /* access modifiers changed from: private */
    public final KotlinTypeRefiner kotlinTypeRefinerForOwnerModule;
    /* access modifiers changed from: private */
    public final Function1<KotlinTypeRefiner, T> scopeFactory;
    private final NotNullLazyValue scopeForOwnerModule$delegate;

    public /* synthetic */ ScopesHolderForClass(ClassDescriptor classDescriptor2, StorageManager storageManager, Function1 function1, KotlinTypeRefiner kotlinTypeRefiner, DefaultConstructorMarker defaultConstructorMarker) {
        this(classDescriptor2, storageManager, function1, kotlinTypeRefiner);
    }

    private ScopesHolderForClass(ClassDescriptor classDescriptor2, StorageManager storageManager, Function1<? super KotlinTypeRefiner, ? extends T> function1, KotlinTypeRefiner kotlinTypeRefiner) {
        this.classDescriptor = classDescriptor2;
        this.scopeFactory = function1;
        this.kotlinTypeRefinerForOwnerModule = kotlinTypeRefiner;
        this.scopeForOwnerModule$delegate = storageManager.createLazyValue(new ScopesHolderForClass$scopeForOwnerModule$2(this));
    }

    private final T getScopeForOwnerModule() {
        return (MemberScope) StorageKt.getValue(this.scopeForOwnerModule$delegate, (Object) this, (KProperty<?>) $$delegatedProperties[0]);
    }

    public final T getScope(KotlinTypeRefiner kotlinTypeRefiner) {
        Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefiner");
        if (!kotlinTypeRefiner.isRefinementNeededForModule(DescriptorUtilsKt.getModule(this.classDescriptor))) {
            return getScopeForOwnerModule();
        }
        TypeConstructor typeConstructor = this.classDescriptor.getTypeConstructor();
        Intrinsics.checkNotNullExpressionValue(typeConstructor, "classDescriptor.typeConstructor");
        if (!kotlinTypeRefiner.isRefinementNeededForTypeConstructor(typeConstructor)) {
            return getScopeForOwnerModule();
        }
        return kotlinTypeRefiner.getOrPutScopeForClass(this.classDescriptor, new ScopesHolderForClass$getScope$1(this, kotlinTypeRefiner));
    }

    /* compiled from: ScopesHolderForClass.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final <T extends MemberScope> ScopesHolderForClass<T> create(ClassDescriptor classDescriptor, StorageManager storageManager, KotlinTypeRefiner kotlinTypeRefiner, Function1<? super KotlinTypeRefiner, ? extends T> function1) {
            Intrinsics.checkNotNullParameter(classDescriptor, "classDescriptor");
            Intrinsics.checkNotNullParameter(storageManager, "storageManager");
            Intrinsics.checkNotNullParameter(kotlinTypeRefiner, "kotlinTypeRefinerForOwnerModule");
            Intrinsics.checkNotNullParameter(function1, "scopeFactory");
            return new ScopesHolderForClass(classDescriptor, storageManager, function1, kotlinTypeRefiner, (DefaultConstructorMarker) null);
        }
    }
}
