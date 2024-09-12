package expo.modules.kotlin.objects;

import com.braze.ui.actions.brazeactions.steps.StepData;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.jni.CppType;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIFunctionBody;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t¨\u0006\u0011"}, d2 = {"Lexpo/modules/kotlin/objects/PropertyComponent;", "", "name", "", "getter", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "setter", "(Ljava/lang/String;Lexpo/modules/kotlin/functions/SyncFunctionComponent;Lexpo/modules/kotlin/functions/SyncFunctionComponent;)V", "getGetter", "()Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "getName", "()Ljava/lang/String;", "getSetter", "attachToJSObject", "", "jsObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: PropertyComponent.kt */
public final class PropertyComponent {
    private final SyncFunctionComponent getter;
    private final String name;
    private final SyncFunctionComponent setter;

    public PropertyComponent(String str, SyncFunctionComponent syncFunctionComponent, SyncFunctionComponent syncFunctionComponent2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.getter = syncFunctionComponent;
        this.setter = syncFunctionComponent2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PropertyComponent(String str, SyncFunctionComponent syncFunctionComponent, SyncFunctionComponent syncFunctionComponent2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : syncFunctionComponent, (i & 4) != 0 ? null : syncFunctionComponent2);
    }

    public final String getName() {
        return this.name;
    }

    public final SyncFunctionComponent getGetter() {
        return this.getter;
    }

    public final SyncFunctionComponent getSetter() {
        return this.setter;
    }

    public final void attachToJSObject(JavaScriptModuleObject javaScriptModuleObject) {
        PropertyComponent$$ExternalSyntheticLambda0 propertyComponent$$ExternalSyntheticLambda0;
        ExpectedType expectedType;
        List<ExpectedType> cppRequiredTypes;
        Intrinsics.checkNotNullParameter(javaScriptModuleObject, "jsObject");
        PropertyComponent$$ExternalSyntheticLambda1 propertyComponent$$ExternalSyntheticLambda1 = null;
        if (this.getter != null) {
            propertyComponent$$ExternalSyntheticLambda0 = new PropertyComponent$$ExternalSyntheticLambda0(this);
        } else {
            JNIFunctionBody jNIFunctionBody = null;
            propertyComponent$$ExternalSyntheticLambda0 = null;
        }
        if (this.setter != null) {
            propertyComponent$$ExternalSyntheticLambda1 = new PropertyComponent$$ExternalSyntheticLambda1(this);
        } else {
            JNIFunctionBody jNIFunctionBody2 = null;
        }
        String str = this.name;
        SyncFunctionComponent syncFunctionComponent = this.setter;
        if (syncFunctionComponent == null || (cppRequiredTypes = syncFunctionComponent.getCppRequiredTypes()) == null || (expectedType = (ExpectedType) CollectionsKt.first(cppRequiredTypes)) == null) {
            expectedType = new ExpectedType(CppType.NONE);
        }
        javaScriptModuleObject.registerProperty(str, expectedType, propertyComponent$$ExternalSyntheticLambda0, propertyComponent$$ExternalSyntheticLambda1);
    }

    /* access modifiers changed from: private */
    /* renamed from: attachToJSObject$lambda-0  reason: not valid java name */
    public static final Object m788attachToJSObject$lambda0(PropertyComponent propertyComponent, Object[] objArr) {
        Intrinsics.checkNotNullParameter(propertyComponent, "this$0");
        Intrinsics.checkNotNullParameter(objArr, "it");
        return propertyComponent.getter.call(new Object[0]);
    }

    /* access modifiers changed from: private */
    /* renamed from: attachToJSObject$lambda-1  reason: not valid java name */
    public static final Object m789attachToJSObject$lambda1(PropertyComponent propertyComponent, Object[] objArr) {
        Intrinsics.checkNotNullParameter(propertyComponent, "this$0");
        Intrinsics.checkNotNullParameter(objArr, StepData.ARGS);
        propertyComponent.setter.call(objArr);
        return null;
    }
}
