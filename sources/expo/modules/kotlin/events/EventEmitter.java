package expo.modules.kotlin.events;

import com.facebook.react.bridge.WritableMap;
import expo.modules.kotlin.records.Record;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0000\bf\u0018\u00002\u00020\u0001J3\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bH&¢\u0006\u0002\u0010\fJ\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u001a\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\rH&J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0010\u0010\b\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010\u000eH&¨\u0006\u000f"}, d2 = {"Lexpo/modules/kotlin/events/EventEmitter;", "Lexpo/modules/core/interfaces/services/EventEmitter;", "emit", "", "viewId", "", "eventName", "", "eventBody", "Lcom/facebook/react/bridge/WritableMap;", "coalescingKey", "", "(ILjava/lang/String;Lcom/facebook/react/bridge/WritableMap;Ljava/lang/Short;)V", "Lexpo/modules/kotlin/records/Record;", "", "expo-modules-core_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: EventEmitter.kt */
public interface EventEmitter extends expo.modules.core.interfaces.services.EventEmitter {
    void emit(int i, String str, WritableMap writableMap, Short sh);

    void emit(String str, WritableMap writableMap);

    void emit(String str, Record record);

    void emit(String str, Map<?, ?> map);

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    /* compiled from: EventEmitter.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void emit$default(EventEmitter eventEmitter, int i, String str, WritableMap writableMap, Short sh, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    sh = null;
                }
                eventEmitter.emit(i, str, writableMap, sh);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: emit");
        }
    }
}
