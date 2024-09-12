package zendesk.storage.android.internal;

import java.io.FileReader;
import kotlin.Metadata;
import kotlin.io.TextStreamsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Ljava/io/FileReader;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComplexStorage.kt */
final class ComplexStorage$get$text$1 extends Lambda implements Function1<FileReader, String> {
    public static final ComplexStorage$get$text$1 INSTANCE = new ComplexStorage$get$text$1();

    ComplexStorage$get$text$1() {
        super(1);
    }

    public final String invoke(FileReader fileReader) {
        Intrinsics.checkNotNullParameter(fileReader, "$this$reader");
        return TextStreamsKt.readText(fileReader);
    }
}
