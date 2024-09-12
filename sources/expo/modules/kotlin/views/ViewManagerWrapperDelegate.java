package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.common.MapBuilder;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.events.KModuleEventEmitterWrapperKt;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KClass;
import kotlin.reflect.KProperty1;
import kotlin.reflect.full.KClasses;
import kotlin.reflect.jvm.KCallablesJvm;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u000e\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u001aJ\u0014\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u001cJ\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017¢\u0006\u0002\u0010\u001eJ\u0016\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010 \u001a\u00020!R\u0014\u0010\u0005\u001a\u00020\u00068BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\u0004R\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118@X\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013¨\u0006\""}, d2 = {"Lexpo/modules/kotlin/views/ViewManagerWrapperDelegate;", "", "moduleHolder", "Lexpo/modules/kotlin/ModuleHolder;", "(Lexpo/modules/kotlin/ModuleHolder;)V", "definition", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getDefinition", "()Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getModuleHolder$expo_modules_core_release", "()Lexpo/modules/kotlin/ModuleHolder;", "setModuleHolder$expo_modules_core_release", "name", "", "getName", "()Ljava/lang/String;", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getViewGroupDefinition$expo_modules_core_release", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "configureView", "", "view", "Landroid/view/View;", "createView", "context", "Landroid/content/Context;", "getExportedCustomDirectEventTypeConstants", "", "onDestroy", "(Landroid/view/View;)Lkotlin/Unit;", "setProxiedProperties", "proxiedProperties", "Lcom/facebook/react/bridge/ReadableMap;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewManagerWrapperDelegate.kt */
public final class ViewManagerWrapperDelegate {
    private ModuleHolder moduleHolder;

    public ViewManagerWrapperDelegate(ModuleHolder moduleHolder2) {
        Intrinsics.checkNotNullParameter(moduleHolder2, "moduleHolder");
        this.moduleHolder = moduleHolder2;
    }

    public final ModuleHolder getModuleHolder$expo_modules_core_release() {
        return this.moduleHolder;
    }

    public final void setModuleHolder$expo_modules_core_release(ModuleHolder moduleHolder2) {
        Intrinsics.checkNotNullParameter(moduleHolder2, "<set-?>");
        this.moduleHolder = moduleHolder2;
    }

    private final ViewManagerDefinition getDefinition() {
        ViewManagerDefinition viewManagerDefinition = this.moduleHolder.getDefinition().getViewManagerDefinition();
        if (viewManagerDefinition != null) {
            return viewManagerDefinition;
        }
        throw new IllegalArgumentException("Required value was null.".toString());
    }

    public final ViewGroupDefinition getViewGroupDefinition$expo_modules_core_release() {
        return getDefinition().getViewGroupDefinition();
    }

    public final String getName() {
        return this.moduleHolder.getName();
    }

    public final View createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        View createView = getDefinition().createView(context, this.moduleHolder.getModule().getAppContext());
        configureView(createView);
        return createView;
    }

    public final void setProxiedProperties(View view, ReadableMap readableMap) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(readableMap, "proxiedProperties");
        getDefinition().setProps(readableMap, view);
        Function1<View, Unit> onViewDidUpdateProps = getDefinition().getOnViewDidUpdateProps();
        if (onViewDidUpdateProps != null) {
            onViewDidUpdateProps.invoke(view);
        }
    }

    public final Unit onDestroy(View view) {
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Function1<View, Unit> onViewDestroys = getDefinition().getOnViewDestroys();
        if (onViewDestroys == null) {
            return null;
        }
        onViewDestroys.invoke(view);
        return Unit.INSTANCE;
    }

    public final Map<String, Object> getExportedCustomDirectEventTypeConstants() {
        String[] names;
        MapBuilder.Builder builder = MapBuilder.builder();
        CallbacksDefinition callbacksDefinition = getDefinition().getCallbacksDefinition();
        if (!(callbacksDefinition == null || (names = callbacksDefinition.getNames()) == null)) {
            for (String str : names) {
                builder.put(KModuleEventEmitterWrapperKt.normalizeEventName(str), MapBuilder.of("registrationName", str));
            }
        }
        return builder.build();
    }

    private final void configureView(View view) {
        String[] names;
        CallbacksDefinition callbacksDefinition = getDefinition().getCallbacksDefinition();
        if (callbacksDefinition != null && (names = callbacksDefinition.getNames()) != null) {
            KClass<?> kotlinClass = JvmClassMappingKt.getKotlinClass(view.getClass());
            Iterable declaredMemberProperties = KClasses.getDeclaredMemberProperties(kotlinClass);
            Map linkedHashMap = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault(declaredMemberProperties, 10)), 16));
            for (Object next : declaredMemberProperties) {
                linkedHashMap.put(((KProperty1) next).getName(), next);
            }
            for (String str : names) {
                Object obj = linkedHashMap.get(str);
                if (obj == null) {
                    Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Property `" + str + "` does not exist in " + kotlinClass.getSimpleName(), (Throwable) null, 2, (Object) null);
                } else {
                    KProperty1 kProperty1 = (KProperty1) obj;
                    KCallablesJvm.setAccessible(kProperty1, true);
                    Object delegate = kProperty1.getDelegate(view);
                    if (delegate == null) {
                        Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Property delegate for `" + str + "` in " + kotlinClass.getSimpleName() + " does not exist", (Throwable) null, 2, (Object) null);
                    } else {
                        ViewEventDelegate viewEventDelegate = delegate instanceof ViewEventDelegate ? (ViewEventDelegate) delegate : null;
                        if (viewEventDelegate == null) {
                            Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ Property delegate for `" + str + "` cannot be cased to `ViewCallbackDelegate`", (Throwable) null, 2, (Object) null);
                        } else {
                            viewEventDelegate.setValidated$expo_modules_core_release(true);
                        }
                    }
                }
            }
        }
    }
}
