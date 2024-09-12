package expo.modules.kotlin.objects;

import com.braze.models.FeatureFlag;
import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.events.EventsDefinition;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001Bg\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003\u0012\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\u0002\u0010\u000eR\u001d\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R%\u0010\u0002\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00168F¢\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u001d\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010R\u001d\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00070\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0010¨\u0006\u001c"}, d2 = {"Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "", "constantsProvider", "Lkotlin/Function0;", "", "", "syncFunctions", "Lexpo/modules/kotlin/functions/SyncFunctionComponent;", "asyncFunctions", "Lexpo/modules/kotlin/functions/BaseAsyncFunctionComponent;", "eventsDefinition", "Lexpo/modules/kotlin/events/EventsDefinition;", "properties", "Lexpo/modules/kotlin/objects/PropertyComponent;", "(Lkotlin/jvm/functions/Function0;Ljava/util/Map;Ljava/util/Map;Lexpo/modules/kotlin/events/EventsDefinition;Ljava/util/Map;)V", "getAsyncFunctions", "()Ljava/util/Map;", "getConstantsProvider", "()Lkotlin/jvm/functions/Function0;", "getEventsDefinition", "()Lexpo/modules/kotlin/events/EventsDefinition;", "functions", "Lexpo/modules/kotlin/ConcatIterator;", "Lexpo/modules/kotlin/functions/AnyFunction;", "getFunctions", "()Lexpo/modules/kotlin/ConcatIterator;", "getProperties", "getSyncFunctions", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ObjectDefinitionData.kt */
public final class ObjectDefinitionData {
    private final Map<String, BaseAsyncFunctionComponent> asyncFunctions;
    private final Function0<Map<String, Object>> constantsProvider;
    private final EventsDefinition eventsDefinition;
    private final Map<String, PropertyComponent> properties;
    private final Map<String, SyncFunctionComponent> syncFunctions;

    public ObjectDefinitionData(Function0<? extends Map<String, ? extends Object>> function0, Map<String, SyncFunctionComponent> map, Map<String, ? extends BaseAsyncFunctionComponent> map2, EventsDefinition eventsDefinition2, Map<String, PropertyComponent> map3) {
        Intrinsics.checkNotNullParameter(function0, "constantsProvider");
        Intrinsics.checkNotNullParameter(map, "syncFunctions");
        Intrinsics.checkNotNullParameter(map2, "asyncFunctions");
        Intrinsics.checkNotNullParameter(map3, FeatureFlag.PROPERTIES);
        this.constantsProvider = function0;
        this.syncFunctions = map;
        this.asyncFunctions = map2;
        this.eventsDefinition = eventsDefinition2;
        this.properties = map3;
    }

    public final Function0<Map<String, Object>> getConstantsProvider() {
        return this.constantsProvider;
    }

    public final Map<String, SyncFunctionComponent> getSyncFunctions() {
        return this.syncFunctions;
    }

    public final Map<String, BaseAsyncFunctionComponent> getAsyncFunctions() {
        return this.asyncFunctions;
    }

    public final EventsDefinition getEventsDefinition() {
        return this.eventsDefinition;
    }

    public final Map<String, PropertyComponent> getProperties() {
        return this.properties;
    }

    public final ConcatIterator<AnyFunction> getFunctions() {
        return new ConcatIterator<>(this.syncFunctions.values().iterator(), this.asyncFunctions.values().iterator());
    }
}
