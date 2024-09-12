package expo.modules.av;

public interface AudioEventHandler {
    void handleAudioFocusGained();

    void handleAudioFocusInterruptionBegan();

    void onPause();

    void onResume();

    void pauseImmediately();

    boolean requiresAudioFocus();

    void updateVolumeMuteAndDuck();
}
