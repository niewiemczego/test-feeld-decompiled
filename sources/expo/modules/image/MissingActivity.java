package expo.modules.image;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lexpo/modules/image/MissingActivity;", "Lexpo/modules/kotlin/exception/CodedException;", "()V", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: Exceptions.kt */
public final class MissingActivity extends CodedException {
    public MissingActivity() {
        super("The current activity is no longer available", (Throwable) null, 2, (DefaultConstructorMarker) null);
    }
}