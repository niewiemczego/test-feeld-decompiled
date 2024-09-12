package androidx.room;

import java.lang.annotation.RetentionPolicy;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Landroidx/room/OnConflictStrategy;", "", "Companion", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
@Retention(AnnotationRetention.BINARY)
@java.lang.annotation.Retention(RetentionPolicy.CLASS)
/* compiled from: OnConflictStrategy.kt */
public @interface OnConflictStrategy {
    public static final int ABORT = 3;
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int FAIL = 4;
    public static final int IGNORE = 5;
    public static final int NONE = 0;
    public static final int REPLACE = 1;
    public static final int ROLLBACK = 2;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u0006\u0010\u0002R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006XT¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002¨\u0006\f"}, d2 = {"Landroidx/room/OnConflictStrategy$Companion;", "", "()V", "ABORT", "", "FAIL", "getFAIL$annotations", "IGNORE", "NONE", "REPLACE", "ROLLBACK", "getROLLBACK$annotations", "room-common"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: OnConflictStrategy.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ABORT = 3;
        public static final int FAIL = 4;
        public static final int IGNORE = 5;
        public static final int NONE = 0;
        public static final int REPLACE = 1;
        public static final int ROLLBACK = 2;

        @Deprecated(message = "Use ABORT instead.")
        public static /* synthetic */ void getFAIL$annotations() {
        }

        @Deprecated(message = "Use ABORT instead.")
        public static /* synthetic */ void getROLLBACK$annotations() {
        }

        private Companion() {
        }
    }
}
