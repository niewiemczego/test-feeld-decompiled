package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.JNIAsyncFunctionBody;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.jni.PromiseImpl;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class SuspendFunctionComponent$$ExternalSyntheticLambda0 implements JNIAsyncFunctionBody {
    public final /* synthetic */ SuspendFunctionComponent f$0;
    public final /* synthetic */ AppContext f$1;
    public final /* synthetic */ JavaScriptModuleObject f$2;

    public /* synthetic */ SuspendFunctionComponent$$ExternalSyntheticLambda0(SuspendFunctionComponent suspendFunctionComponent, AppContext appContext, JavaScriptModuleObject javaScriptModuleObject) {
        this.f$0 = suspendFunctionComponent;
        this.f$1 = appContext;
        this.f$2 = javaScriptModuleObject;
    }

    public final void invoke(Object[] objArr, PromiseImpl promiseImpl) {
        SuspendFunctionComponent.m786attachToJSObject$lambda1(this.f$0, this.f$1, this.f$2, objArr, promiseImpl);
    }
}
