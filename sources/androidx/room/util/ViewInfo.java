package androidx.room.util;

import androidx.sqlite.db.SupportSQLiteDatabase;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0013\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0001H\u0002J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\u0003H\u0016R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Landroidx/room/util/ViewInfo;", "", "name", "", "sql", "(Ljava/lang/String;Ljava/lang/String;)V", "equals", "", "other", "hashCode", "", "toString", "Companion", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ViewInfo.kt */
public final class ViewInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public final String name;
    public final String sql;

    @JvmStatic
    public static final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    public ViewInfo(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "name");
        this.name = str;
        this.sql = str2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ViewInfo)) {
            return false;
        }
        ViewInfo viewInfo = (ViewInfo) obj;
        if (Intrinsics.areEqual((Object) this.name, (Object) viewInfo.name)) {
            String str = this.sql;
            String str2 = viewInfo.sql;
            if (str != null ? Intrinsics.areEqual((Object) str, (Object) str2) : str2 == null) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = this.name.hashCode() * 31;
        String str = this.sql;
        return hashCode + (str != null ? str.hashCode() : 0);
    }

    public String toString() {
        return "ViewInfo{name='" + this.name + "', sql='" + this.sql + "'}";
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0007¨\u0006\t"}, d2 = {"Landroidx/room/util/ViewInfo$Companion;", "", "()V", "read", "Landroidx/room/util/ViewInfo;", "database", "Landroidx/sqlite/db/SupportSQLiteDatabase;", "viewName", "", "room-runtime_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ViewInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x005a, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x005b, code lost:
            kotlin.io.CloseableKt.closeFinally(r7, r8);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x005e, code lost:
            throw r0;
         */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final androidx.room.util.ViewInfo read(androidx.sqlite.db.SupportSQLiteDatabase r7, java.lang.String r8) {
            /*
                r6 = this;
                java.lang.String r0 = "database"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
                java.lang.String r0 = "viewName"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r0.<init>()
                java.lang.String r1 = "SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '"
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.StringBuilder r0 = r0.append(r8)
                r1 = 39
                java.lang.StringBuilder r0 = r0.append(r1)
                java.lang.String r0 = r0.toString()
                android.database.Cursor r7 = r7.query((java.lang.String) r0)
                int r0 = android.os.Build.VERSION.SDK_INT
                r1 = 1
                java.lang.String r2 = "cursor.getString(0)"
                r3 = 0
                r4 = 0
                r5 = 15
                if (r0 <= r5) goto L_0x005f
                java.io.Closeable r7 = (java.io.Closeable) r7
                r0 = r7
                android.database.Cursor r0 = (android.database.Cursor) r0     // Catch:{ all -> 0x0058 }
                boolean r5 = r0.moveToFirst()     // Catch:{ all -> 0x0058 }
                if (r5 == 0) goto L_0x004e
                androidx.room.util.ViewInfo r8 = new androidx.room.util.ViewInfo     // Catch:{ all -> 0x0058 }
                java.lang.String r3 = r0.getString(r3)     // Catch:{ all -> 0x0058 }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r2)     // Catch:{ all -> 0x0058 }
                java.lang.String r0 = r0.getString(r1)     // Catch:{ all -> 0x0058 }
                r8.<init>(r3, r0)     // Catch:{ all -> 0x0058 }
                goto L_0x0054
            L_0x004e:
                androidx.room.util.ViewInfo r0 = new androidx.room.util.ViewInfo     // Catch:{ all -> 0x0058 }
                r0.<init>(r8, r4)     // Catch:{ all -> 0x0058 }
                r8 = r0
            L_0x0054:
                kotlin.io.CloseableKt.closeFinally(r7, r4)
                goto L_0x007f
            L_0x0058:
                r8 = move-exception
                throw r8     // Catch:{ all -> 0x005a }
            L_0x005a:
                r0 = move-exception
                kotlin.io.CloseableKt.closeFinally(r7, r8)
                throw r0
            L_0x005f:
                boolean r0 = r7.moveToFirst()     // Catch:{ all -> 0x0080 }
                if (r0 == 0) goto L_0x0076
                androidx.room.util.ViewInfo r8 = new androidx.room.util.ViewInfo     // Catch:{ all -> 0x0080 }
                java.lang.String r0 = r7.getString(r3)     // Catch:{ all -> 0x0080 }
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)     // Catch:{ all -> 0x0080 }
                java.lang.String r1 = r7.getString(r1)     // Catch:{ all -> 0x0080 }
                r8.<init>(r0, r1)     // Catch:{ all -> 0x0080 }
                goto L_0x007c
            L_0x0076:
                androidx.room.util.ViewInfo r0 = new androidx.room.util.ViewInfo     // Catch:{ all -> 0x0080 }
                r0.<init>(r8, r4)     // Catch:{ all -> 0x0080 }
                r8 = r0
            L_0x007c:
                r7.close()
            L_0x007f:
                return r8
            L_0x0080:
                r8 = move-exception
                r7.close()
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.ViewInfo.Companion.read(androidx.sqlite.db.SupportSQLiteDatabase, java.lang.String):androidx.room.util.ViewInfo");
        }
    }
}
