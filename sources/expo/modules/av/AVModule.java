package expo.modules.av;

import android.content.Context;
import expo.modules.core.ExportedModule;
import expo.modules.core.ModuleRegistry;
import expo.modules.core.Promise;
import expo.modules.core.arguments.ReadableArguments;
import expo.modules.core.interfaces.ExpoMethod;
import expo.modules.interfaces.permissions.Permissions;

public class AVModule extends ExportedModule {
    private AVManagerInterface mAVManager;
    private ModuleRegistry mModuleRegistry;

    public String getName() {
        return "ExponentAV";
    }

    public AVModule(Context context) {
        super(context);
    }

    public void onCreate(ModuleRegistry moduleRegistry) {
        this.mModuleRegistry = moduleRegistry;
        this.mAVManager = (AVManagerInterface) moduleRegistry.getModule(AVManagerInterface.class);
    }

    @ExpoMethod
    public void setAudioIsEnabled(Boolean bool, Promise promise) {
        this.mAVManager.setAudioIsEnabled(bool);
        promise.resolve((Object) null);
    }

    @ExpoMethod
    public void setAudioMode(ReadableArguments readableArguments, Promise promise) {
        this.mAVManager.setAudioMode(readableArguments);
        promise.resolve((Object) null);
    }

    @ExpoMethod
    public void loadForSound(ReadableArguments readableArguments, ReadableArguments readableArguments2, Promise promise) {
        this.mAVManager.loadForSound(readableArguments, readableArguments2, promise);
    }

    @ExpoMethod
    public void unloadForSound(Integer num, Promise promise) {
        this.mAVManager.unloadForSound(num, promise);
    }

    @ExpoMethod
    public void setStatusForSound(Integer num, ReadableArguments readableArguments, Promise promise) {
        this.mAVManager.setStatusForSound(num, readableArguments, promise);
    }

    @ExpoMethod
    public void replaySound(Integer num, ReadableArguments readableArguments, Promise promise) {
        this.mAVManager.replaySound(num, readableArguments, promise);
    }

    @ExpoMethod
    public void getStatusForSound(Integer num, Promise promise) {
        this.mAVManager.getStatusForSound(num, promise);
    }

    @ExpoMethod
    public void loadForVideo(Integer num, ReadableArguments readableArguments, ReadableArguments readableArguments2, Promise promise) {
        this.mAVManager.loadForVideo(num, readableArguments, readableArguments2, promise);
    }

    @ExpoMethod
    public void unloadForVideo(Integer num, Promise promise) {
        this.mAVManager.unloadForVideo(num, promise);
    }

    @ExpoMethod
    public void setStatusForVideo(Integer num, ReadableArguments readableArguments, Promise promise) {
        this.mAVManager.setStatusForVideo(num, readableArguments, promise);
    }

    @ExpoMethod
    public void replayVideo(Integer num, ReadableArguments readableArguments, Promise promise) {
        this.mAVManager.replayVideo(num, readableArguments, promise);
    }

    @ExpoMethod
    public void getStatusForVideo(Integer num, Promise promise) {
        this.mAVManager.getStatusForVideo(num, promise);
    }

    @ExpoMethod
    public void prepareAudioRecorder(ReadableArguments readableArguments, Promise promise) {
        this.mAVManager.prepareAudioRecorder(readableArguments, promise);
    }

    @ExpoMethod
    public void getAvailableInputs(Promise promise) {
        this.mAVManager.getAvailableInputs(promise);
    }

    @ExpoMethod
    public void getCurrentInput(Promise promise) {
        this.mAVManager.getCurrentInput(promise);
    }

    @ExpoMethod
    public void setInput(String str, Promise promise) {
        this.mAVManager.setInput(str, promise);
    }

    @ExpoMethod
    public void startAudioRecording(Promise promise) {
        this.mAVManager.startAudioRecording(promise);
    }

    @ExpoMethod
    public void pauseAudioRecording(Promise promise) {
        this.mAVManager.pauseAudioRecording(promise);
    }

    @ExpoMethod
    public void stopAudioRecording(Promise promise) {
        this.mAVManager.stopAudioRecording(promise);
    }

    @ExpoMethod
    public void getAudioRecordingStatus(Promise promise) {
        this.mAVManager.getAudioRecordingStatus(promise);
    }

    @ExpoMethod
    public void unloadAudioRecorder(Promise promise) {
        this.mAVManager.unloadAudioRecorder(promise);
    }

    @ExpoMethod
    public void requestPermissionsAsync(Promise promise) {
        Permissions.askForPermissionsWithPermissionsManager((Permissions) this.mModuleRegistry.getModule(Permissions.class), promise, "android.permission.RECORD_AUDIO");
    }

    @ExpoMethod
    public void getPermissionsAsync(Promise promise) {
        Permissions.getPermissionsWithPermissionsManager((Permissions) this.mModuleRegistry.getModule(Permissions.class), promise, "android.permission.RECORD_AUDIO");
    }
}
