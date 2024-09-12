package expo.modules.av;

import android.content.Context;
import expo.modules.av.video.VideoView;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.interfaces.permissions.PermissionsResponseListener;

public interface AVManagerInterface {
    void abandonAudioFocusIfUnused();

    void acquireAudioFocus() throws AudioFocusNotAcquiredException;

    void getAudioRecordingStatus(Promise promise);

    void getAvailableInputs(Promise promise);

    Context getContext();

    void getCurrentInput(Promise promise);

    ModuleRegistry getModuleRegistry();

    void getStatusForSound(Integer num, Promise promise);

    void getStatusForVideo(Integer num, Promise promise);

    float getVolumeForDuckAndFocus(boolean z, float f);

    boolean hasAudioPermission();

    void loadForSound(ReadableArguments readableArguments, ReadableArguments readableArguments2, Promise promise);

    void loadForVideo(Integer num, ReadableArguments readableArguments, ReadableArguments readableArguments2, Promise promise);

    void pauseAudioRecording(Promise promise);

    void prepareAudioRecorder(ReadableArguments readableArguments, Promise promise);

    void registerVideoViewForAudioLifecycle(VideoView videoView);

    void replaySound(Integer num, ReadableArguments readableArguments, Promise promise);

    void replayVideo(Integer num, ReadableArguments readableArguments, Promise promise);

    void requestAudioPermission(PermissionsResponseListener permissionsResponseListener);

    void setAudioIsEnabled(Boolean bool);

    void setAudioMode(ReadableArguments readableArguments);

    void setInput(String str, Promise promise);

    void setStatusForSound(Integer num, ReadableArguments readableArguments, Promise promise);

    void setStatusForVideo(Integer num, ReadableArguments readableArguments, Promise promise);

    void startAudioRecording(Promise promise);

    void stopAudioRecording(Promise promise);

    void unloadAudioRecorder(Promise promise);

    void unloadForSound(Integer num, Promise promise);

    void unloadForVideo(Integer num, Promise promise);

    void unregisterVideoViewForAudioLifecycle(VideoView videoView);
}
