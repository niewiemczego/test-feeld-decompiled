package expo.modules.kotlin.functions;

import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.JNIAsyncFunctionBody;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.jni.PromiseImpl;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class AsyncFunction$$ExternalSyntheticLambda0 implements JNIAsyncFunctionBody {
    public final /* synthetic */ AsyncFunction f$0;
    public final /* synthetic */ AppContext f$1;
    public final /* synthetic */ JavaScriptModuleObject f$2;

    public /* synthetic */ AsyncFunction$$ExternalSyntheticLambda0(AsyncFunction asyncFunction, AppContext appContext, JavaScriptModuleObject javaScriptModuleObject) {
        this.f$0 = asyncFunction;
        this.f$1 = appContext;
        this.f$2 = javaScriptModuleObject;
    }

    public final void invoke(Object[] objArr, PromiseImpl promiseImpl) {
        AsyncFunction.m785attachToJSObject$lambda1(this.f$0, this.f$1, this.f$2, objArr, promiseImpl);
    }
}
