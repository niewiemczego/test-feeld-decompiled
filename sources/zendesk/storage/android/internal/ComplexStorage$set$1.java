package zendesk.storage.android.internal;

import java.io.FileWriter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "T", "Ljava/io/FileWriter;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ComplexStorage.kt */
final class ComplexStorage$set$1 extends Lambda implements Function1<FileWriter, Unit> {
    final /* synthetic */ Class<T> $type;
    final /* synthetic */ T $value;
    final /* synthetic */ ComplexStorage this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ComplexStorage$set$1(ComplexStorage complexStorage, T t, Class<T> cls) {
        super(1);
        this.this$0 = complexStorage;
        this.$value = t;
        this.$type = cls;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FileWriter) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(FileWriter fileWriter) {
        Intrinsics.checkNotNullParameter(fileWriter, "$this$writer");
        fileWriter.write(this.this$0.serializer.serialize(this.$value, this.$type));
    }
}
