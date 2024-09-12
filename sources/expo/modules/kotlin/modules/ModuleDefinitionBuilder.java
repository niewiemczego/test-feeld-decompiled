package expo.modules.kotlin.modules;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventListenerWithPayload;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.events.OnActivityResultPayload;
import expo.modules.kotlin.objects.ObjectDefinitionBuilder;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.ViewManagerDefinition;
import expo.modules.kotlin.views.ViewManagerDefinitionBuilder;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010&\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011J\u001c\u0010'\u001a\u00020\u00162\u000e\b\u0004\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)H\bø\u0001\u0001J\u001c\u0010*\u001a\u00020\u00162\u000e\b\u0004\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)H\bø\u0001\u0001J\u001c\u0010+\u001a\u00020\u00162\u000e\b\u0004\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)H\bø\u0001\u0001J(\u0010,\u001a\u00020\u00162\u001a\b\u0004\u0010(\u001a\u0014\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00160\u0013H\bø\u0001\u0001J\u001c\u0010/\u001a\u00020\u00162\u000e\b\u0004\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)H\bø\u0001\u0001J\u001c\u00100\u001a\u00020\u00162\u000e\b\u0004\u0010(\u001a\b\u0012\u0004\u0012\u00020\u00160)H\bø\u0001\u0001J\"\u00101\u001a\u00020\u00162\u0014\b\u0004\u0010(\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u001602H\bø\u0001\u0001J7\u00104\u001a\u00020\u00162'\u0010(\u001a#\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0013¢\u0006\u0002\b\u0018ø\u0001\u0000¢\u0006\u0002\u0010\u001dJC\u00105\u001a\u00020\u0016\"\b\b\u0000\u00106*\u0002072\f\u00108\u001a\b\u0012\u0004\u0012\u0002H6092\u001d\u0010(\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H60:\u0012\u0004\u0012\u00020\u001602¢\u0006\u0002\b\u0018H\bø\u0001\u0001J%\u0010;\u001a\u00020\u00162\u0017\u0010(\u001a\u0013\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u001602¢\u0006\u0002\b\u0018H\bø\u0001\u0001J\u0006\u0010=\u001a\u00020>R(\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\fR\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0000X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\n\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000RL\u0010\u0012\u001a%\b\u0001\u0012\u0004\u0012\u00020\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u0015\u0012\u0006\u0012\u0004\u0018\u00010\u0017\u0018\u00010\u0013¢\u0006\u0002\b\u00188\u0000@\u0000X\u000eø\u0001\u0000¢\u0006\u0016\n\u0002\u0010\u001e\u0012\u0004\b\u0019\u0010\n\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001f\u001a\u0004\u0018\u00010 8\u0000@\u0000X\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b!\u0010\n\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010%\u0002\u000b\n\u0002\b\u0019\n\u0005\b20\u0001¨\u0006?"}, d2 = {"Lexpo/modules/kotlin/modules/ModuleDefinitionBuilder;", "Lexpo/modules/kotlin/objects/ObjectDefinitionBuilder;", "module", "Lexpo/modules/kotlin/modules/Module;", "(Lexpo/modules/kotlin/modules/Module;)V", "eventListeners", "", "Lexpo/modules/kotlin/events/EventName;", "Lexpo/modules/kotlin/events/EventListener;", "getEventListeners$annotations", "()V", "getEventListeners", "()Ljava/util/Map;", "getModule$annotations", "getModule", "()Lexpo/modules/kotlin/modules/Module;", "name", "", "registerContracts", "Lkotlin/Function2;", "Lexpo/modules/kotlin/activityresult/AppContextActivityResultCaller;", "Lkotlin/coroutines/Continuation;", "", "", "Lkotlin/ExtensionFunctionType;", "getRegisterContracts$annotations", "getRegisterContracts", "()Lkotlin/jvm/functions/Function2;", "setRegisterContracts", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "viewManagerDefinition", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "getViewManagerDefinition$annotations", "getViewManagerDefinition", "()Lexpo/modules/kotlin/views/ViewManagerDefinition;", "setViewManagerDefinition", "(Lexpo/modules/kotlin/views/ViewManagerDefinition;)V", "Name", "OnActivityDestroys", "body", "Lkotlin/Function0;", "OnActivityEntersBackground", "OnActivityEntersForeground", "OnActivityResult", "Landroid/app/Activity;", "Lexpo/modules/kotlin/events/OnActivityResultPayload;", "OnCreate", "OnDestroy", "OnNewIntent", "Lkotlin/Function1;", "Landroid/content/Intent;", "RegisterActivityContracts", "View", "T", "Landroid/view/View;", "viewType", "Lkotlin/reflect/KClass;", "Lexpo/modules/kotlin/views/ViewDefinitionBuilder;", "ViewManager", "Lexpo/modules/kotlin/views/ViewManagerDefinitionBuilder;", "buildModule", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@DefinitionMarker
/* compiled from: ModuleDefinitionBuilder.kt */
public final class ModuleDefinitionBuilder extends ObjectDefinitionBuilder {
    private final Map<EventName, EventListener> eventListeners;
    private final Module module;
    private String name;
    private Function2<? super AppContextActivityResultCaller, ? super Continuation<? super Unit>, ? extends Object> registerContracts;
    private ViewManagerDefinition viewManagerDefinition;

    public ModuleDefinitionBuilder() {
        this((Module) null, 1, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ void getEventListeners$annotations() {
    }

    public static /* synthetic */ void getModule$annotations() {
    }

    public static /* synthetic */ void getRegisterContracts$annotations() {
    }

    public static /* synthetic */ void getViewManagerDefinition$annotations() {
    }

    public ModuleDefinitionBuilder(Module module2) {
        this.module = module2;
        this.eventListeners = new LinkedHashMap();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ModuleDefinitionBuilder(Module module2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : module2);
    }

    public final Module getModule() {
        return this.module;
    }

    public final ViewManagerDefinition getViewManagerDefinition() {
        return this.viewManagerDefinition;
    }

    public final void setViewManagerDefinition(ViewManagerDefinition viewManagerDefinition2) {
        this.viewManagerDefinition = viewManagerDefinition2;
    }

    public final Map<EventName, EventListener> getEventListeners() {
        return this.eventListeners;
    }

    public final Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> getRegisterContracts() {
        return this.registerContracts;
    }

    public final void setRegisterContracts(Function2<? super AppContextActivityResultCaller, ? super Continuation<? super Unit>, ? extends Object> function2) {
        this.registerContracts = function2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0008, code lost:
        r0 = r0.getClass();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final expo.modules.kotlin.modules.ModuleDefinitionData buildModule() {
        /*
            r7 = this;
            java.lang.String r0 = r7.name
            if (r0 != 0) goto L_0x0014
            expo.modules.kotlin.modules.Module r0 = r7.module
            if (r0 == 0) goto L_0x0013
            java.lang.Class r0 = r0.getClass()
            if (r0 == 0) goto L_0x0013
            java.lang.String r0 = r0.getSimpleName()
            goto L_0x0014
        L_0x0013:
            r0 = 0
        L_0x0014:
            r2 = r0
            expo.modules.kotlin.modules.ModuleDefinitionData r0 = new expo.modules.kotlin.modules.ModuleDefinitionData
            if (r2 == 0) goto L_0x0028
            expo.modules.kotlin.objects.ObjectDefinitionData r3 = r7.buildObject()
            expo.modules.kotlin.views.ViewManagerDefinition r4 = r7.viewManagerDefinition
            java.util.Map<expo.modules.kotlin.events.EventName, expo.modules.kotlin.events.EventListener> r5 = r7.eventListeners
            kotlin.jvm.functions.Function2<? super expo.modules.kotlin.activityresult.AppContextActivityResultCaller, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r6 = r7.registerContracts
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            return r0
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Required value was null."
            java.lang.String r1 = r1.toString()
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.kotlin.modules.ModuleDefinitionBuilder.buildModule():expo.modules.kotlin.modules.ModuleDefinitionData");
    }

    public final void Name(String str) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
    }

    @Deprecated(message = "Use a `View` component instead.")
    public final void ViewManager(Function1<? super ViewManagerDefinitionBuilder, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        if (getViewManagerDefinition() == null) {
            ViewManagerDefinitionBuilder viewManagerDefinitionBuilder = new ViewManagerDefinitionBuilder();
            function1.invoke(viewManagerDefinitionBuilder);
            setViewManagerDefinition(viewManagerDefinitionBuilder.build());
            return;
        }
        throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
    }

    public final <T extends View> void View(KClass<T> kClass, Function1<? super ViewDefinitionBuilder<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(kClass, "viewType");
        Intrinsics.checkNotNullParameter(function1, "body");
        if (getViewManagerDefinition() == null) {
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(kClass);
            function1.invoke(viewDefinitionBuilder);
            setViewManagerDefinition(viewDefinitionBuilder.build());
            return;
        }
        throw new IllegalArgumentException("The module definition may have exported only one view manager.".toString());
    }

    public final void OnCreate(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new ModuleDefinitionBuilder$OnCreate$1(function0)));
    }

    public final void RegisterActivityContracts(Function2<? super AppContextActivityResultCaller, ? super Continuation<? super Unit>, ? extends Object> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        this.registerContracts = function2;
    }

    public final void OnDestroy(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new ModuleDefinitionBuilder$OnDestroy$1(function0)));
    }

    public final void OnActivityEntersForeground(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.ACTIVITY_ENTERS_FOREGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_FOREGROUND, new ModuleDefinitionBuilder$OnActivityEntersForeground$1(function0)));
    }

    public final void OnActivityEntersBackground(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.ACTIVITY_ENTERS_BACKGROUND, new BasicEventListener(EventName.ACTIVITY_ENTERS_BACKGROUND, new ModuleDefinitionBuilder$OnActivityEntersBackground$1(function0)));
    }

    public final void OnActivityDestroys(Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "body");
        getEventListeners().put(EventName.ACTIVITY_DESTROYS, new BasicEventListener(EventName.ACTIVITY_DESTROYS, new ModuleDefinitionBuilder$OnActivityDestroys$1(function0)));
    }

    public final void OnNewIntent(Function1<? super Intent, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "body");
        getEventListeners().put(EventName.ON_NEW_INTENT, new EventListenerWithPayload(EventName.ON_NEW_INTENT, new ModuleDefinitionBuilder$OnNewIntent$1(function1)));
    }

    public final void OnActivityResult(Function2<? super Activity, ? super OnActivityResultPayload, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "body");
        getEventListeners().put(EventName.ON_ACTIVITY_RESULT, new EventListenerWithSenderAndPayload(EventName.ON_ACTIVITY_RESULT, new ModuleDefinitionBuilder$OnActivityResult$1(function2)));
    }
}
