package expo.modules.core.logging;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: PersistentFileLog.kt */
final class PersistentFileLog$purgeEntriesNotMatchingFilter$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function1<Error, Unit> $completionHandler;
    final /* synthetic */ Function1<String, Boolean> $filter;
    final /* synthetic */ PersistentFileLog this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersistentFileLog$purgeEntriesNotMatchingFilter$1(PersistentFileLog persistentFileLog, Function1<? super String, Boolean> function1, Function1<? super Error, Unit> function12) {
        super(0);
        this.this$0 = persistentFileLog;
        this.$filter = function1;
        this.$completionHandler = function12;
    }

    public final void invoke() {
        try {
            this.this$0.ensureFileExists();
            Function1<String, Boolean> function1 = this.$filter;
            Collection arrayList = new ArrayList();
            for (Object next : this.this$0.readFileLinesSync()) {
                if (function1.invoke(next).booleanValue()) {
                    arrayList.add(next);
                }
            }
            this.this$0.writeFileLinesSync((List) arrayList);
            this.$completionHandler.invoke(null);
        } catch (Throwable th) {
            this.$completionHandler.invoke(new Error(th));
        }
    }
}
