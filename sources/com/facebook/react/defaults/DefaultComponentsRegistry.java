package com.facebook.react.defaults;

import com.facebook.jni.HybridData;
import com.facebook.react.fabric.ComponentFactory;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 \b2\u00020\u0001:\u0001\bB\u000f\b\u0003\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0011\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u0003H R\u0010\u0010\u0005\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\t"}, d2 = {"Lcom/facebook/react/defaults/DefaultComponentsRegistry;", "", "componentFactory", "Lcom/facebook/react/fabric/ComponentFactory;", "(Lcom/facebook/react/fabric/ComponentFactory;)V", "hybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "Companion", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DefaultComponentsRegistry.kt */
public final class DefaultComponentsRegistry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final HybridData hybridData;

    public /* synthetic */ DefaultComponentsRegistry(ComponentFactory componentFactory, DefaultConstructorMarker defaultConstructorMarker) {
        this(componentFactory);
    }

    private final native HybridData initHybrid(ComponentFactory componentFactory);

    @JvmStatic
    public static final DefaultComponentsRegistry register(ComponentFactory componentFactory) {
        return Companion.register(componentFactory);
    }

    private DefaultComponentsRegistry(ComponentFactory componentFactory) {
        this.hybridData = initHybrid(componentFactory);
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lcom/facebook/react/defaults/DefaultComponentsRegistry$Companion;", "", "()V", "register", "Lcom/facebook/react/defaults/DefaultComponentsRegistry;", "componentFactory", "Lcom/facebook/react/fabric/ComponentFactory;", "ReactAndroid_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DefaultComponentsRegistry.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final DefaultComponentsRegistry register(ComponentFactory componentFactory) {
            Intrinsics.checkNotNullParameter(componentFactory, "componentFactory");
            return new DefaultComponentsRegistry(componentFactory, (DefaultConstructorMarker) null);
        }
    }
}
