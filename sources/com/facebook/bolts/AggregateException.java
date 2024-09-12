package com.facebook.bolts;

import androidx.core.app.NotificationCompat;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0003\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000e2\u00060\u0001j\u0002`\u0002:\u0001\u000eB!\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\u0010\u0010\u0005\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0007\u0018\u00010\u0006¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\rH\u0016R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/facebook/bolts/AggregateException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "detailMessage", "", "innerThrowables", "", "", "(Ljava/lang/String;Ljava/util/List;)V", "printStackTrace", "", "err", "Ljava/io/PrintStream;", "Ljava/io/PrintWriter;", "Companion", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AggregateException.kt */
public final class AggregateException extends Exception {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long serialVersionUID = 1;
    private final List<Throwable> innerThrowables;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AggregateException(String str, List<? extends Throwable> list) {
        super(str, (list == null || !(list.isEmpty() ^ true)) ? null : (Throwable) list.get(0));
        List<Throwable> unmodifiableList = Collections.unmodifiableList(list == null ? CollectionsKt.emptyList() : list);
        Intrinsics.checkNotNullExpressionValue(unmodifiableList, "unmodifiableList(innerThrowables ?: emptyList())");
        this.innerThrowables = unmodifiableList;
    }

    public void printStackTrace(PrintStream printStream) {
        Intrinsics.checkNotNullParameter(printStream, NotificationCompat.CATEGORY_ERROR);
        super.printStackTrace(printStream);
        int i = -1;
        for (Throwable next : this.innerThrowables) {
            printStream.append("\n");
            printStream.append("  Inner throwable #");
            i++;
            printStream.append(String.valueOf(i));
            printStream.append(": ");
            if (next != null) {
                next.printStackTrace(printStream);
            }
            printStream.append("\n");
        }
    }

    public void printStackTrace(PrintWriter printWriter) {
        Intrinsics.checkNotNullParameter(printWriter, NotificationCompat.CATEGORY_ERROR);
        super.printStackTrace(printWriter);
        int i = -1;
        for (Throwable next : this.innerThrowables) {
            printWriter.append("\n");
            printWriter.append("  Inner throwable #");
            i++;
            printWriter.append(String.valueOf(i));
            printWriter.append(": ");
            if (next != null) {
                next.printStackTrace(printWriter);
            }
            printWriter.append("\n");
        }
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/facebook/bolts/AggregateException$Companion;", "", "()V", "serialVersionUID", "", "facebook-bolts_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AggregateException.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
