package expo.modules.kotlin.views;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.Dynamic;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableMap;
import expo.modules.adapters.react.NativeModulesProxy;
import expo.modules.core.ViewManager;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.DynamicExtenstionsKt;
import expo.modules.kotlin.defaultmodules.ErrorManagerModule;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import io.sentry.SentryEvent;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0001\u0012\u0018\u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\b\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\n\u0012\u0016\b\u0002\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\u0013\u0012\u0016\b\u0002\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\u0002\u0010\u0015J\u0016\u0010#\u001a\u00020\u00062\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u0005J\u0006\u0010&\u001a\u00020'J\u0016\u0010(\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u00062\u0006\u0010*\u001a\u00020+J\u0016\u0010,\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u0006R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\u0011¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u001f\u0010\u0014\u001a\u0010\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0019R\u001a\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\f0\nX\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR \u0010\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0003X\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0012\u001a\u0004\u0018\u00010\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u001c\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\bX\u0004¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"¨\u00060"}, d2 = {"Lexpo/modules/kotlin/views/ViewManagerDefinition;", "", "viewFactory", "Lkotlin/Function2;", "Landroid/content/Context;", "Lexpo/modules/kotlin/AppContext;", "Landroid/view/View;", "viewType", "Ljava/lang/Class;", "props", "", "", "Lexpo/modules/kotlin/views/AnyViewProp;", "onViewDestroys", "Lkotlin/Function1;", "", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "onViewDidUpdateProps", "(Lkotlin/jvm/functions/Function2;Ljava/lang/Class;Ljava/util/Map;Lkotlin/jvm/functions/Function1;Lexpo/modules/kotlin/views/CallbacksDefinition;Lexpo/modules/kotlin/views/ViewGroupDefinition;Lkotlin/jvm/functions/Function1;)V", "getCallbacksDefinition", "()Lexpo/modules/kotlin/views/CallbacksDefinition;", "getOnViewDestroys", "()Lkotlin/jvm/functions/Function1;", "getOnViewDidUpdateProps", "propsNames", "", "getPropsNames", "()Ljava/util/List;", "getViewGroupDefinition", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getViewType$expo_modules_core_release", "()Ljava/lang/Class;", "createView", "context", "appContext", "getViewManagerType", "Lexpo/modules/core/ViewManager$ViewManagerType;", "handleException", "view", "exception", "Lexpo/modules/kotlin/exception/CodedException;", "setProps", "propsToSet", "Lcom/facebook/react/bridge/ReadableMap;", "onView", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewManagerDefinition.kt */
public final class ViewManagerDefinition {
    private final CallbacksDefinition callbacksDefinition;
    private final Function1<View, Unit> onViewDestroys;
    private final Function1<View, Unit> onViewDidUpdateProps;
    private final Map<String, AnyViewProp> props;
    private final List<String> propsNames;
    private final Function2<Context, AppContext, View> viewFactory;
    private final ViewGroupDefinition viewGroupDefinition;
    private final Class<? extends View> viewType;

    public ViewManagerDefinition(Function2<? super Context, ? super AppContext, ? extends View> function2, Class<? extends View> cls, Map<String, ? extends AnyViewProp> map, Function1<? super View, Unit> function1, CallbacksDefinition callbacksDefinition2, ViewGroupDefinition viewGroupDefinition2, Function1<? super View, Unit> function12) {
        Intrinsics.checkNotNullParameter(function2, "viewFactory");
        Intrinsics.checkNotNullParameter(cls, "viewType");
        Intrinsics.checkNotNullParameter(map, "props");
        this.viewFactory = function2;
        this.viewType = cls;
        this.props = map;
        this.onViewDestroys = function1;
        this.callbacksDefinition = callbacksDefinition2;
        this.viewGroupDefinition = viewGroupDefinition2;
        this.onViewDidUpdateProps = function12;
        this.propsNames = CollectionsKt.toList(map.keySet());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ViewManagerDefinition(Function2 function2, Class cls, Map map, Function1 function1, CallbacksDefinition callbacksDefinition2, ViewGroupDefinition viewGroupDefinition2, Function1 function12, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2, cls, map, (i & 8) != 0 ? null : function1, (i & 16) != 0 ? null : callbacksDefinition2, (i & 32) != 0 ? null : viewGroupDefinition2, (i & 64) != 0 ? null : function12);
    }

    public final Class<? extends View> getViewType$expo_modules_core_release() {
        return this.viewType;
    }

    public final Function1<View, Unit> getOnViewDestroys() {
        return this.onViewDestroys;
    }

    public final CallbacksDefinition getCallbacksDefinition() {
        return this.callbacksDefinition;
    }

    public final ViewGroupDefinition getViewGroupDefinition() {
        return this.viewGroupDefinition;
    }

    public final Function1<View, Unit> getOnViewDidUpdateProps() {
        return this.onViewDidUpdateProps;
    }

    public final View createView(Context context, AppContext appContext) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        return this.viewFactory.invoke(context, appContext);
    }

    public final List<String> getPropsNames() {
        return this.propsNames;
    }

    public final ViewManager.ViewManagerType getViewManagerType() {
        if (ViewGroup.class.isAssignableFrom(this.viewType)) {
            return ViewManager.ViewManagerType.GROUP;
        }
        return ViewManager.ViewManagerType.SIMPLE;
    }

    public final void setProps(ReadableMap readableMap, View view) {
        Dynamic dynamic;
        Intrinsics.checkNotNullParameter(readableMap, "propsToSet");
        Intrinsics.checkNotNullParameter(view, "onView");
        for (Map.Entry next : this.props.entrySet()) {
            String str = (String) next.getKey();
            AnyViewProp anyViewProp = (AnyViewProp) next.getValue();
            try {
                if (readableMap.hasKey(str)) {
                    dynamic = readableMap.getDynamic(str);
                    Intrinsics.checkNotNullExpressionValue(dynamic, "propsToSet\n            .getDynamic(name)");
                    anyViewProp.set(dynamic, view);
                    Unit unit = Unit.INSTANCE;
                    dynamic.recycle();
                } else if (anyViewProp.isNullable()) {
                    anyViewProp.set(DynamicExtenstionsKt.getDynamicNull(), view);
                }
            } catch (Throwable th) {
                th = th;
                CoreLoggerKt.getLogger().error("❌ Cannot set the '" + str + "' prop on the '" + this.viewType.getSimpleName() + "'", th);
                if (!(th instanceof CodedException)) {
                    th = new UnexpectedException((Throwable) th);
                }
                handleException(view, th);
            }
        }
    }

    public final void handleException(View view, CodedException codedException) {
        ErrorManagerModule errorManager$expo_modules_core_release;
        Intrinsics.checkNotNullParameter(view, ViewHierarchyConstants.VIEW_KEY);
        Intrinsics.checkNotNullParameter(codedException, SentryEvent.JsonKeys.EXCEPTION);
        Context context = view.getContext();
        NativeModulesProxy nativeModulesProxy = null;
        ReactContext reactContext = context instanceof ReactContext ? (ReactContext) context : null;
        if (reactContext != null) {
            CatalystInstance catalystInstance = reactContext.getCatalystInstance();
            NativeModule nativeModule = catalystInstance != null ? catalystInstance.getNativeModule("NativeUnimoduleProxy") : null;
            if (nativeModule instanceof NativeModulesProxy) {
                nativeModulesProxy = (NativeModulesProxy) nativeModule;
            }
            if (nativeModulesProxy != null && (errorManager$expo_modules_core_release = nativeModulesProxy.getKotlinInteropModuleRegistry().getAppContext$expo_modules_core_release().getErrorManager$expo_modules_core_release()) != null) {
                errorManager$expo_modules_core_release.reportExceptionToLogBox(codedException);
            }
        }
    }
}
