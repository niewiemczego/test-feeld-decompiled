package expo.modules.image.thumbhash;

import expo.modules.kotlin.exception.CodedException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0018\u00010\u0005j\u0004\u0018\u0001`\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"Lexpo/modules/image/thumbhash/ThumbhashDecodingFailure;", "Lexpo/modules/kotlin/exception/CodedException;", "thumbhash", "", "cause", "Ljava/lang/Exception;", "Lkotlin/Exception;", "(Ljava/lang/String;Ljava/lang/Exception;)V", "expo-image_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ThumbhashFetcher.kt */
public final class ThumbhashDecodingFailure extends CodedException {
    public ThumbhashDecodingFailure(String str, Exception exc) {
        super("Cannot decode provided thumbhash '" + str + "' " + exc, (Throwable) null, 2, (DefaultConstructorMarker) null);
    }
}
