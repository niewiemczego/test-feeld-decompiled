package expo.modules.camera;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lexpo/modules/camera/CameraExceptions;", "", "()V", "CameraIsNotRunning", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: CameraExceptions.kt */
public final class CameraExceptions {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/camera/CameraExceptions$CameraIsNotRunning;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-camera_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: CameraExceptions.kt */
    public static final class CameraIsNotRunning extends CodedException {
        public CameraIsNotRunning() {
            super("Camera is not running", (Throwable) null, 2, (DefaultConstructorMarker) null);
        }
    }
}
