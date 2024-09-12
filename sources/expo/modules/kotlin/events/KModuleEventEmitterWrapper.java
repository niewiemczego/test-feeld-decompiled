package expo.modules.kotlin.events;

import android.os.Bundle;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.WritableMap;
import expo.modules.core.interfaces.services.EventEmitter;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.records.Record;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007¢\u0006\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0011H\u0016J\u001a\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0012H\u0016J\"\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0010\u0010\u000f\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u0013H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lexpo/modules/kotlin/events/KModuleEventEmitterWrapper;", "Lexpo/modules/kotlin/events/KEventEmitterWrapper;", "moduleHolder", "Lexpo/modules/kotlin/ModuleHolder;", "legacyEventEmitter", "Lexpo/modules/core/interfaces/services/EventEmitter;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "(Lexpo/modules/kotlin/ModuleHolder;Lexpo/modules/core/interfaces/services/EventEmitter;Ljava/lang/ref/WeakReference;)V", "checkIfEventWasExported", "", "eventName", "", "emit", "eventBody", "Landroid/os/Bundle;", "Lcom/facebook/react/bridge/WritableMap;", "Lexpo/modules/kotlin/records/Record;", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: KModuleEventEmitterWrapper.kt */
public final class KModuleEventEmitterWrapper extends KEventEmitterWrapper {
    private final ModuleHolder moduleHolder;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public KModuleEventEmitterWrapper(ModuleHolder moduleHolder2, EventEmitter eventEmitter, WeakReference<ReactApplicationContext> weakReference) {
        super(eventEmitter, weakReference);
        Intrinsics.checkNotNullParameter(moduleHolder2, "moduleHolder");
        Intrinsics.checkNotNullParameter(eventEmitter, "legacyEventEmitter");
        Intrinsics.checkNotNullParameter(weakReference, "reactContextHolder");
        this.moduleHolder = moduleHolder2;
    }

    public void emit(String str, Bundle bundle) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        checkIfEventWasExported(str);
        super.emit(str, bundle);
    }

    public void emit(String str, WritableMap writableMap) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        checkIfEventWasExported(str);
        super.emit(str, writableMap);
    }

    public void emit(String str, Record record) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        checkIfEventWasExported(str);
        super.emit(str, record);
    }

    public void emit(String str, Map<?, ?> map) {
        Intrinsics.checkNotNullParameter(str, "eventName");
        checkIfEventWasExported(str);
        super.emit(str, map);
    }

    private final void checkIfEventWasExported(String str) {
        String[] names;
        EventsDefinition eventsDefinition = this.moduleHolder.getDefinition().getEventsDefinition();
        boolean z = true;
        if (eventsDefinition == null || (names = eventsDefinition.getNames()) == null || !ArraysKt.contains((T[]) names, str)) {
            z = false;
        }
        if (!z) {
            throw new IllegalArgumentException(("Unsupported event: " + str + ".").toString());
        }
    }
}
