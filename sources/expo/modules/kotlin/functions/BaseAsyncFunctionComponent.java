package expo.modules.kotlin.functions;

import com.facebook.react.bridge.ReadableArray;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.types.AnyType;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H&J\u000e\u0010\u0016\u001a\u00020\u00002\u0006\u0010\b\u001a\u00020\tR\u001a\u0010\b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "Lexpo/modules/kotlin/functions/AnyFunction;", "name", "", "desiredArgsTypes", "", "Lexpo/modules/kotlin/types/AnyType;", "(Ljava/lang/String;[Lexpo/modules/kotlin/types/AnyType;)V", "queue", "Lexpo/modules/kotlin/functions/Queues;", "getQueue", "()Lexpo/modules/kotlin/functions/Queues;", "setQueue", "(Lexpo/modules/kotlin/functions/Queues;)V", "call", "", "holder", "Lexpo/modules/kotlin/ModuleHolder;", "args", "Lcom/facebook/react/bridge/ReadableArray;", "promise", "Lexpo/modules/kotlin/Promise;", "runOnQueue", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: BaseAsyncFunctionComponent.kt */
public abstract class BaseAsyncFunctionComponent extends AnyFunction {
    private Queues queue = Queues.DEFAULT;

    public abstract void call(ModuleHolder moduleHolder, ReadableArray readableArray, Promise promise);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BaseAsyncFunctionComponent(String str, AnyType[] anyTypeArr) {
        super(str, anyTypeArr);
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(anyTypeArr, "desiredArgsTypes");
    }

    /* access modifiers changed from: protected */
    public final Queues getQueue() {
        return this.queue;
    }

    /* access modifiers changed from: protected */
    public final void setQueue(Queues queues) {
        Intrinsics.checkNotNullParameter(queues, "<set-?>");
        this.queue = queues;
    }

    public final BaseAsyncFunctionComponent runOnQueue(Queues queues) {
        Intrinsics.checkNotNullParameter(queues, "queue");
        BaseAsyncFunctionComponent baseAsyncFunctionComponent = this;
        this.queue = queues;
        return this;
    }
}
