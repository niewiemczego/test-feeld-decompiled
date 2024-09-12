package com.google.android.recaptcha.internal;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: com.google.android.recaptcha:recaptcha@@18.4.0 */
public final class zzaz extends SQLiteOpenHelper {
    public static final zzax zza;
    private static final int zzb;
    /* access modifiers changed from: private */
    public static zzaz zzc;

    static {
        zzax zzax = new zzax((DefaultConstructorMarker) null);
        zza = zzax;
        zzb = zzax.zzb("18.4.0");
    }

    public /* synthetic */ zzaz(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        super(context, "cesdb", (SQLiteDatabase.CursorFactory) null, zzb);
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        sQLiteDatabase.execSQL("DROP TABLE IF EXISTS ce");
        sQLiteDatabase.execSQL("CREATE TABLE ce (id INTEGER PRIMARY KEY,ts BIGINT NOT NULL,ss TEXT NOT NULL)");
    }

    public final int zza(List list) {
        if (list.isEmpty()) {
            return 0;
        }
        return getWritableDatabase().delete("ce", "id IN ".concat(String.valueOf(CollectionsKt.joinToString$default(list, ", ", "(", ")", 0, (CharSequence) null, zzay.zza, 24, (Object) null))), (String[]) null);
    }

    public final int zzb() {
        Cursor rawQuery = getReadableDatabase().rawQuery("SELECT COUNT(*) FROM ce", (String[]) null);
        int i = -1;
        try {
            if (rawQuery.moveToNext()) {
                i = rawQuery.getInt(0);
            }
        } catch (Exception unused) {
        } catch (Throwable th) {
            rawQuery.close();
            throw th;
        }
        rawQuery.close();
        return i;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(2:6|7) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0050, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0053, code lost:
        throw r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0046, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
        r1 = kotlin.collections.CollectionsKt.emptyList();
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:6:0x0048 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List zzd() {
        /*
            r8 = this;
            android.database.sqlite.SQLiteDatabase r0 = r8.getReadableDatabase()
            java.lang.String r1 = "ce"
            r2 = 0
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            java.lang.String r7 = "ts ASC"
            android.database.Cursor r0 = r0.query(r1, r2, r3, r4, r5, r6, r7)
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
        L_0x0016:
            boolean r2 = r0.moveToNext()     // Catch:{ Exception -> 0x0048 }
            if (r2 == 0) goto L_0x004c
            java.lang.String r2 = "id"
            int r2 = r0.getColumnIndexOrThrow(r2)     // Catch:{ Exception -> 0x0048 }
            int r2 = r0.getInt(r2)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = "ss"
            int r3 = r0.getColumnIndexOrThrow(r3)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r3 = r0.getString(r3)     // Catch:{ Exception -> 0x0048 }
            java.lang.String r4 = "ts"
            int r4 = r0.getColumnIndexOrThrow(r4)     // Catch:{ Exception -> 0x0048 }
            long r4 = r0.getLong(r4)     // Catch:{ Exception -> 0x0048 }
            com.google.android.recaptcha.internal.zzba r6 = new com.google.android.recaptcha.internal.zzba     // Catch:{ Exception -> 0x0048 }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ Exception -> 0x0048 }
            r6.<init>(r3, r4, r2)     // Catch:{ Exception -> 0x0048 }
            r1.add(r6)     // Catch:{ Exception -> 0x0048 }
            goto L_0x0016
        L_0x0046:
            r1 = move-exception
            goto L_0x0050
        L_0x0048:
            java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()     // Catch:{ all -> 0x0046 }
        L_0x004c:
            r0.close()
            return r1
        L_0x0050:
            r0.close()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.recaptcha.internal.zzaz.zzd():java.util.List");
    }

    public final boolean zzf(zzba zzba) {
        return zza(CollectionsKt.listOf(zzba)) == 1;
    }
}
