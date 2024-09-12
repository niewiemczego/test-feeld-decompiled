package expo.modules.adapters.react;

import com.facebook.jni.HybridData;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.soloader.SoLoader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u001b\u0012\u0014\u0010\u0002\u001a\u0010\u0012\f\u0012\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\n\u001a\u00020\u000bH\u0004J\t\u0010\f\u001a\u00020\tH J\u001c\u0010\r\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u000eH ¢\u0006\u0002\u0010\u000fR\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\t8\u0002X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lexpo/modules/adapters/react/FabricComponentsRegistry;", "", "viewManagerList", "", "Lcom/facebook/react/uimanager/ViewManager;", "(Ljava/util/List;)V", "componentNames", "", "mHybridData", "Lcom/facebook/jni/HybridData;", "finalize", "", "initHybrid", "registerComponentsRegistry", "", "([Ljava/lang/String;)V", "Companion", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: FabricComponentsRegistry.kt */
public final class FabricComponentsRegistry {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final List<String> componentNames;
    private final HybridData mHybridData;

    private final native HybridData initHybrid();

    private final native void registerComponentsRegistry(String[] strArr);

    public FabricComponentsRegistry(List<? extends ViewManager<?, ?>> list) {
        Intrinsics.checkNotNullParameter(list, "viewManagerList");
        Iterable<ViewManager> iterable = list;
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
        for (ViewManager name : iterable) {
            arrayList.add(name.getName());
        }
        List<String> list2 = (List) arrayList;
        this.componentNames = list2;
        this.mHybridData = initHybrid();
        Object[] array = list2.toArray(new String[0]);
        Intrinsics.checkNotNull(array, "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        registerComponentsRegistry((String[]) array);
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/adapters/react/FabricComponentsRegistry$Companion;", "", "()V", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: FabricComponentsRegistry.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }
}
