package expo.modules.kotlin.views;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.defaultmodules.ErrorManagerModule;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.modules.DefinitionMarker;
import expo.modules.kotlin.types.AnyTypeKt;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KFunction;
import kotlin.reflect.KType;
import kotlin.reflect.full.KClasses;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0003\n\u0000\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0013\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005¢\u0006\u0002\u0010\u0006J\u001d\u0010)\u001a\u00020\u000b2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180+H\u0007¢\u0006\u0004\b,\u0010-J\u001f\u0010)\u001a\u00020\u000b2\u0012\u0010*\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00180+\"\u00020\u0018¢\u0006\u0002\u0010-J7\u0010.\u001a\u00020\u000b\"\n\b\u0001\u0010/\u0018\u0001*\u0002002\u001d\u00101\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H/02\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\b3H\bø\u0001\u0000J1\u00104\u001a\u00020\u000b2#\b\u0004\u00101\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u000b0\nH\bø\u0001\u0000JB\u00104\u001a\u00020\u000b\"\n\b\u0001\u00108\u0018\u0001*\u00028\u00002#\b\b\u00101\u001a\u001d\u0012\u0013\u0012\u0011H8¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u000b0\nH\bø\u0001\u0000¢\u0006\u0002\b9J1\u0010:\u001a\u00020\u000b2#\b\u0004\u00101\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u000b0\nH\bø\u0001\u0000JB\u0010:\u001a\u00020\u000b\"\n\b\u0001\u00108\u0018\u0001*\u00028\u00002#\b\b\u00101\u001a\u001d\u0012\u0013\u0012\u0011H8¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0004\u0012\u00020\u000b0\nH\bø\u0001\u0000¢\u0006\u0002\b;JV\u0010<\u001a\u00020\u000b\"\u0006\b\u0001\u0010=\u0018\u00012\u0006\u00106\u001a\u00020\u001828\b\b\u00101\u001a2\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u0011H=¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u000b0>H\bø\u0001\u0000Jg\u0010<\u001a\u00020\u000b\"\n\b\u0001\u00108\u0018\u0001*\u00020\u0002\"\u0006\b\u0002\u0010=\u0018\u00012\u0006\u00106\u001a\u00020\u001828\b\b\u00101\u001a2\u0012\u0013\u0012\u0011H8¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(7\u0012\u0013\u0012\u0011H=¢\u0006\f\b5\u0012\b\b6\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\u000b0>H\bø\u0001\u0000¢\u0006\u0002\b@J\u0006\u0010A\u001a\u00020BJ\u001a\u0010C\u001a\u0014\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020E\u0012\u0004\u0012\u00020\u00020>H\u0002J\u0010\u0010F\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010GH\u0002J \u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020D2\u0006\u0010J\u001a\u00020E2\u0006\u0010K\u001a\u00020LH\u0002R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R2\u0010\t\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\f\u0010\r\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R2\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0013\u0010\r\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R0\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00190\u00178\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u001a\u0010\r\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR&\u0010\u001f\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\r\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%R\"\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u00058\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b&\u0010\r\u001a\u0004\b'\u0010(\u0002\u0007\n\u0005\b20\u0001¨\u0006M"}, d2 = {"Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", "T", "Landroid/view/View;", "", "viewType", "Lkotlin/reflect/KClass;", "(Lkotlin/reflect/KClass;)V", "callbacksDefinition", "Lexpo/modules/kotlin/views/CallbacksDefinition;", "onViewDestroys", "Lkotlin/Function1;", "", "getOnViewDestroys$annotations", "()V", "getOnViewDestroys", "()Lkotlin/jvm/functions/Function1;", "setOnViewDestroys", "(Lkotlin/jvm/functions/Function1;)V", "onViewDidUpdateProps", "getOnViewDidUpdateProps$annotations", "getOnViewDidUpdateProps", "setOnViewDidUpdateProps", "props", "", "", "Lexpo/modules/kotlin/views/AnyViewProp;", "getProps$annotations", "getProps", "()Ljava/util/Map;", "setProps", "(Ljava/util/Map;)V", "viewGroupDefinition", "Lexpo/modules/kotlin/views/ViewGroupDefinition;", "getViewGroupDefinition$annotations", "getViewGroupDefinition", "()Lexpo/modules/kotlin/views/ViewGroupDefinition;", "setViewGroupDefinition", "(Lexpo/modules/kotlin/views/ViewGroupDefinition;)V", "getViewType$annotations", "getViewType", "()Lkotlin/reflect/KClass;", "Events", "callbacks", "", "EventsWithArray", "([Ljava/lang/String;)V", "GroupView", "ParentType", "Landroid/view/ViewGroup;", "body", "Lexpo/modules/kotlin/views/ViewGroupDefinitionBuilder;", "Lkotlin/ExtensionFunctionType;", "OnViewDestroys", "Lkotlin/ParameterName;", "name", "view", "ViewType", "OnViewDestroysGeneric", "OnViewDidUpdateProps", "OnViewDidUpdatePropsGeneric", "Prop", "PropType", "Lkotlin/Function2;", "prop", "PropGeneric", "build", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "createViewFactory", "Landroid/content/Context;", "Lexpo/modules/kotlin/AppContext;", "getPrimaryConstructor", "Lkotlin/reflect/KFunction;", "handleFailureDuringViewCreation", "context", "appContext", "e", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@DefinitionMarker
/* compiled from: ViewDefinitionBuilder.kt */
public final class ViewDefinitionBuilder<T extends View> {
    private CallbacksDefinition callbacksDefinition;
    private Function1<? super View, Unit> onViewDestroys;
    private Function1<? super View, Unit> onViewDidUpdateProps;
    private Map<String, AnyViewProp> props = new LinkedHashMap();
    private ViewGroupDefinition viewGroupDefinition;
    private final KClass<T> viewType;

    public static /* synthetic */ void getOnViewDestroys$annotations() {
    }

    public static /* synthetic */ void getOnViewDidUpdateProps$annotations() {
    }

    public static /* synthetic */ void getProps$annotations() {
    }

    public static /* synthetic */ void getViewGroupDefinition$annotations() {
    }

    public static /* synthetic */ void getViewType$annotations() {
    }

    public ViewDefinitionBuilder(KClass<T> kClass) {
        Intrinsics.checkNotNullParameter(kClass, "viewType");
        this.viewType = kClass;
    }

    public final KClass<T> getViewType() {
        return this.viewType;
    }

    public final Map<String, AnyViewProp> getProps() {
        return this.props;
    }

    public final void setProps(Map<String, AnyViewProp> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.props = map;
    }

    public final Function1<View, Unit> getOnViewDestroys() {
        return this.onViewDestroys;
    }

    public final void setOnViewDestroys(Function1<? super View, Unit> function1) {
        this.onViewDestroys = function1;
    }

    public final Function1<View, Unit> getOnViewDidUpdateProps() {
        return this.onViewDidUpdateProps;
    }

    public final void setOnViewDidUpdateProps(Function1<? super View, Unit> function1) {
        this.onViewDidUpdateProps = function1;
    }

    public final ViewGroupDefinition getViewGroupDefinition() {
        return this.viewGroupDefinition;
    }

    public final void setViewGroupDefinition(ViewGroupDefinition viewGroupDefinition2) {
        this.viewGroupDefinition = viewGroupDefinition2;
    }

    public final ViewManagerDefinition build() {
        return new ViewManagerDefinition(createViewFactory(), JvmClassMappingKt.getJavaClass(this.viewType), this.props, this.onViewDestroys, this.callbacksDefinition, this.viewGroupDefinition, this.onViewDidUpdateProps);
    }

    public final void OnViewDestroys(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        setOnViewDestroys(new ViewDefinitionBuilder$OnViewDestroys$1(function1));
    }

    public final /* synthetic */ <ViewType extends T> void OnViewDestroysGeneric(Function1<? super ViewType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        Intrinsics.needClassReification();
        setOnViewDestroys(new ViewDefinitionBuilder$OnViewDestroys$2(function1));
    }

    public final void OnViewDidUpdateProps(Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        setOnViewDidUpdateProps(new ViewDefinitionBuilder$OnViewDidUpdateProps$1(function1));
    }

    public final /* synthetic */ <ViewType extends T> void OnViewDidUpdatePropsGeneric(Function1<? super ViewType, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        Intrinsics.needClassReification();
        setOnViewDidUpdateProps(new ViewDefinitionBuilder$OnViewDidUpdateProps$2(function1));
    }

    public final /* synthetic */ <PropType> void Prop(String str, Function2<? super T, ? super PropType, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "body");
        Map<String, AnyViewProp> props2 = getProps();
        Intrinsics.reifiedOperationMarker(6, "PropType");
        props2.put(str, new ConcreteViewProp(str, AnyTypeKt.toAnyType((KType) null), function2));
    }

    public final /* synthetic */ <ViewType extends View, PropType> void PropGeneric(String str, Function2<? super ViewType, ? super PropType, Unit> function2) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function2, "body");
        Map<String, AnyViewProp> props2 = getProps();
        Intrinsics.reifiedOperationMarker(6, "PropType");
        props2.put(str, new ConcreteViewProp(str, AnyTypeKt.toAnyType((KType) null), function2));
    }

    public final void Events(String... strArr) {
        Intrinsics.checkNotNullParameter(strArr, "callbacks");
        this.callbacksDefinition = new CallbacksDefinition(strArr);
    }

    public final void EventsWithArray(String[] strArr) {
        Intrinsics.checkNotNullParameter(strArr, "callbacks");
        this.callbacksDefinition = new CallbacksDefinition(strArr);
    }

    public final /* synthetic */ <ParentType extends ViewGroup> void GroupView(Function1<? super ViewGroupDefinitionBuilder<ParentType>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        KClass viewType2 = getViewType();
        Intrinsics.reifiedOperationMarker(4, "ParentType");
        Intrinsics.areEqual((Object) viewType2, (Object) Reflection.getOrCreateKotlinClass(ViewGroup.class));
        if (getViewGroupDefinition() == null) {
            ViewGroupDefinitionBuilder viewGroupDefinitionBuilder = new ViewGroupDefinitionBuilder();
            function1.invoke(viewGroupDefinitionBuilder);
            setViewGroupDefinition(viewGroupDefinitionBuilder.build());
            return;
        }
        throw new IllegalArgumentException("The viewManager definition may have exported only one groupView definition.".toString());
    }

    private final Function2<Context, AppContext, View> createViewFactory() {
        return new ViewDefinitionBuilder$createViewFactory$1(this);
    }

    /* access modifiers changed from: private */
    public final View handleFailureDuringViewCreation(Context context, AppContext appContext, Throwable th) {
        CodedException codedException;
        Log.e("ExpoModulesCore", "Couldn't create view of type " + this.viewType, th);
        ErrorManagerModule errorManager$expo_modules_core_release = appContext.getErrorManager$expo_modules_core_release();
        if (errorManager$expo_modules_core_release != null) {
            if (th instanceof CodedException) {
                codedException = (CodedException) th;
            } else {
                codedException = new UnexpectedException(th);
            }
            errorManager$expo_modules_core_release.reportExceptionToLogBox(codedException);
        }
        return new View(context);
    }

    /* access modifiers changed from: private */
    public final KFunction<T> getPrimaryConstructor() {
        KFunction<T> primaryConstructor = KClasses.getPrimaryConstructor(this.viewType);
        if (primaryConstructor != null) {
            return primaryConstructor;
        }
        return (KFunction) CollectionsKt.firstOrNull(this.viewType.getConstructors());
    }
}
