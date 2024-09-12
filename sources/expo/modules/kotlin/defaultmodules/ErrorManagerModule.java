package expo.modules.kotlin.defaultmodules;

import android.os.Bundle;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b¨\u0006\t"}, d2 = {"Lexpo/modules/kotlin/defaultmodules/ErrorManagerModule;", "Lexpo/modules/kotlin/modules/Module;", "()V", "definition", "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "reportExceptionToLogBox", "", "codedException", "Lexpo/modules/kotlin/exception/CodedException;", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ErrorManagerModule.kt */
public final class ErrorManagerModule extends Module {
    public ModuleDefinitionData definition() {
        ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(this);
        moduleDefinitionBuilder.Name("ExpoModulesCoreErrorManager");
        moduleDefinitionBuilder.Events("ExpoModulesCoreErrorManager.onNewException");
        return moduleDefinitionBuilder.buildModule();
    }

    public final void reportExceptionToLogBox(CodedException codedException) {
        Intrinsics.checkNotNullParameter(codedException, "codedException");
        EventEmitter eventEmitter = getAppContext().eventEmitter(this);
        if (eventEmitter != null) {
            Bundle bundle = new Bundle();
            String message = codedException.getMessage();
            if (message == null) {
                message = codedException.toString();
            }
            bundle.putString("message", message);
            Unit unit = Unit.INSTANCE;
            eventEmitter.emit("ExpoModulesCoreErrorManager.onNewException", bundle);
        }
    }
}
