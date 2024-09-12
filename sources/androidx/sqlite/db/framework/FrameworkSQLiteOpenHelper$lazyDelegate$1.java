package androidx.sqlite.db.framework;

import android.os.Build;
import androidx.sqlite.db.SupportSQLiteCompat;
import androidx.sqlite.db.framework.FrameworkSQLiteOpenHelper;
import java.io.File;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroidx/sqlite/db/framework/FrameworkSQLiteOpenHelper$OpenHelper;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
/* compiled from: FrameworkSQLiteOpenHelper.kt */
final class FrameworkSQLiteOpenHelper$lazyDelegate$1 extends Lambda implements Function0<FrameworkSQLiteOpenHelper.OpenHelper> {
    final /* synthetic */ FrameworkSQLiteOpenHelper this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FrameworkSQLiteOpenHelper$lazyDelegate$1(FrameworkSQLiteOpenHelper frameworkSQLiteOpenHelper) {
        super(0);
        this.this$0 = frameworkSQLiteOpenHelper;
    }

    public final FrameworkSQLiteOpenHelper.OpenHelper invoke() {
        FrameworkSQLiteOpenHelper.OpenHelper openHelper;
        if (Build.VERSION.SDK_INT < 23 || this.this$0.name == null || !this.this$0.useNoBackupDirectory) {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.context, this.this$0.name, new FrameworkSQLiteOpenHelper.DBRefHolder((FrameworkSQLiteDatabase) null), this.this$0.callback, this.this$0.allowDataLossOnRecovery);
        } else {
            openHelper = new FrameworkSQLiteOpenHelper.OpenHelper(this.this$0.context, new File(SupportSQLiteCompat.Api21Impl.getNoBackupFilesDir(this.this$0.context), this.this$0.name).getAbsolutePath(), new FrameworkSQLiteOpenHelper.DBRefHolder((FrameworkSQLiteDatabase) null), this.this$0.callback, this.this$0.allowDataLossOnRecovery);
        }
        if (Build.VERSION.SDK_INT >= 16) {
            SupportSQLiteCompat.Api16Impl.setWriteAheadLoggingEnabled(openHelper, this.this$0.writeAheadLoggingEnabled);
        }
        return openHelper;
    }
}
