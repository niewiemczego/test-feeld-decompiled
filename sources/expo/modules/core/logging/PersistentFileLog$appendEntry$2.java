package expo.modules.core.logging;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PersistentFileLog.kt */
final class PersistentFileLog$appendEntry$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Error, Unit> $completionHandler;
    final /* synthetic */ String $entry;
    final /* synthetic */ PersistentFileLog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersistentFileLog$appendEntry$2(PersistentFileLog persistentFileLog, String str, Function1<? super Error, Unit> function1) {
        super(0);
        this.this$0 = persistentFileLog;
        this.$entry = str;
        this.$completionHandler = function1;
    }

    public final void invoke() {
        String str;
        try {
            this.this$0.ensureFileExists();
            if (this.this$0.getFileSize() == 0) {
                str = this.$entry;
            } else {
                str = "\n" + this.$entry;
            }
            this.this$0.appendTextToFile(str);
            this.$completionHandler.invoke(null);
        } catch (Error e) {
            this.$completionHandler.invoke(e);
        }
    }
}
