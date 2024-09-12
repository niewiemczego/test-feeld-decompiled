package app.notifee.core.interfaces;

import app.notifee.core.event.BlockStateEvent;
import app.notifee.core.event.ForegroundServiceEvent;
import app.notifee.core.event.LogEvent;
import app.notifee.core.event.NotificationEvent;

public interface EventListener {
    void onBlockStateEvent(BlockStateEvent blockStateEvent);

    void onForegroundServiceEvent(ForegroundServiceEvent foregroundServiceEvent);

    void onLogEvent(LogEvent logEvent);

    void onNotificationEvent(NotificationEvent notificationEvent);
}
