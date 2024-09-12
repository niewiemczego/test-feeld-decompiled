package expo.modules.interfaces.sensors;

public interface SensorServiceSubscriptionInterface {
    Long getUpdateInterval();

    boolean isEnabled();

    void release();

    void setUpdateInterval(long j);

    void start();

    void stop();
}
