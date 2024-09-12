package expo.modules.core.interfaces.services;

import android.os.Bundle;

public interface EventEmitter {

    public static abstract class BaseEvent implements Event {
        public boolean canCoalesce() {
            return true;
        }

        public short getCoalescingKey() {
            return 0;
        }
    }

    public interface Event {
        boolean canCoalesce();

        short getCoalescingKey();

        Bundle getEventBody();

        String getEventName();
    }

    void emit(int i, Event event);

    void emit(int i, String str, Bundle bundle);

    void emit(String str, Bundle bundle);
}
