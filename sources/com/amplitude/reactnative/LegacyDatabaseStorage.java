package com.amplitude.reactnative;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import com.facebook.appevents.UserDataStore;
import java.io.File;
import java.util.List;
import kotlin.Metadata;
import kotlin.NotImplementedError;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0010\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u0005¢\u0006\u0002\u0010\u0016J\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0015\u001a\u00020\u0005J\u001a\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002J\u0010\u0010\u001b\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\u000f2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\"\u0010 \u001a\u00020\u000f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\bH\u0016JY\u0010#\u001a\u0004\u0018\u00010$2\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010\u001a\u001a\u0004\u0018\u00010\u00052\u0010\u0010%\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010&2\b\u0010'\u001a\u0004\u0018\u00010\u00052\u0010\u0010(\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010&2\b\u0010)\u001a\u0004\u0018\u00010\u0005H\u0002¢\u0006\u0002\u0010*J\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,J\u0016\u0010.\u001a\b\u0012\u0004\u0012\u00020-0,2\u0006\u0010\u001a\u001a\u00020\u0005H\u0002J\f\u0010/\u001a\b\u0012\u0004\u0012\u00020-0,J\f\u00100\u001a\b\u0012\u0004\u0012\u00020-0,J\u000e\u00101\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\bJ\u0018\u00103\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u00102\u001a\u00020\bH\u0002J\u000e\u00104\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\bJ\u000e\u00105\u001a\u00020\u000f2\u0006\u00102\u001a\u00020\bJ\u000e\u00106\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0005J\u000e\u00107\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u0005J\u0018\u00108\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u0005H\u0002R\u001e\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/amplitude/reactnative/LegacyDatabaseStorage;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "databaseName", "", "(Landroid/content/Context;Ljava/lang/String;)V", "<set-?>", "", "currentDbVersion", "getCurrentDbVersion", "()I", "file", "Ljava/io/File;", "closeDb", "", "convertIfCursorWindowException", "e", "Ljava/lang/RuntimeException;", "getLongValue", "", "key", "(Ljava/lang/String;)Ljava/lang/Long;", "getValue", "getValueFromTable", "", "table", "handleIfCursorRowTooLargeException", "Ljava/lang/IllegalStateException;", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "newVersion", "queryDb", "Landroid/database/Cursor;", "columns", "", "selection", "selectionArgs", "orderBy", "(Landroid/database/sqlite/SQLiteDatabase;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;", "readEvents", "", "Lorg/json/JSONObject;", "readEventsFromTable", "readIdentifies", "readInterceptedIdentifies", "removeEvent", "eventId", "removeEventFromTable", "removeIdentify", "removeInterceptedIdentify", "removeLongValue", "removeValue", "removeValueFromTable", "amplitude_analytics-react-native_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: LegacyDatabaseStorage.kt */
public final class LegacyDatabaseStorage extends SQLiteOpenHelper {
    private int currentDbVersion = 4;
    private File file;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LegacyDatabaseStorage(Context context, String str) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 4);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, "databaseName");
        File databasePath = context.getDatabasePath(str);
        Intrinsics.checkNotNullExpressionValue(databasePath, "context.getDatabasePath(databaseName)");
        this.file = databasePath;
    }

    public final int getCurrentDbVersion() {
        return this.currentDbVersion;
    }

    public void onCreate(SQLiteDatabase sQLiteDatabase) {
        Intrinsics.checkNotNullParameter(sQLiteDatabase, UserDataStore.DATE_OF_BIRTH);
        throw new NotImplementedError((String) null, 1, (DefaultConstructorMarker) null);
    }

    public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
        this.currentDbVersion = i;
    }

    private final Cursor queryDb(SQLiteDatabase sQLiteDatabase, String str, String[] strArr, String str2, String[] strArr2, String str3) {
        return sQLiteDatabase.query(str, strArr, str2, strArr2, (String) null, (String) null, str3, (String) null);
    }

    private final void handleIfCursorRowTooLargeException(IllegalStateException illegalStateException) {
        CharSequence message = illegalStateException.getMessage();
        if ((message == null || message.length() == 0) || !StringsKt.contains$default(message, (CharSequence) "Couldn't read", false, 2, (Object) null) || !StringsKt.contains$default(message, (CharSequence) "CursorWindow", false, 2, (Object) null)) {
            throw illegalStateException;
        }
        closeDb();
    }

    private final void convertIfCursorWindowException(RuntimeException runtimeException) {
        String message = runtimeException.getMessage();
        CharSequence charSequence = message;
        if ((charSequence == null || charSequence.length() == 0) || (!StringsKt.startsWith$default(message, "Cursor window allocation of", false, 2, (Object) null) && !StringsKt.startsWith$default(message, "Could not allocate CursorWindow", false, 2, (Object) null))) {
            throw runtimeException;
        }
        throw new CursorWindowAllocationException(message);
    }

    private final void closeDb() {
        try {
            close();
        } catch (Exception e) {
            LogcatLogger.Companion.getLogger().error("close failed: " + e.getMessage());
        }
    }

    public final synchronized List<JSONObject> readEvents() {
        return readEventsFromTable("events");
    }

    public final synchronized List<JSONObject> readIdentifies() {
        return readEventsFromTable(DatabaseConstants.IDENTIFY_TABLE_NAME);
    }

    public final synchronized List<JSONObject> readInterceptedIdentifies() {
        if (this.currentDbVersion < 4) {
            return CollectionsKt.emptyList();
        }
        return readEventsFromTable(DatabaseConstants.IDENTIFY_INTERCEPTOR_TABLE_NAME);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0078, code lost:
        if (r3 == null) goto L_0x007b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00d6, code lost:
        if (r3 == null) goto L_0x007b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.List<org.json.JSONObject> readEventsFromTable(java.lang.String r12) {
        /*
            r11 = this;
            java.lang.String r0 = " failed: "
            java.lang.String r1 = "read events from "
            java.io.File r2 = r11.file
            boolean r2 = r2.exists()
            if (r2 != 0) goto L_0x0014
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            java.util.List r12 = (java.util.List) r12
            return r12
        L_0x0014:
            java.util.LinkedList r2 = new java.util.LinkedList
            r2.<init>()
            java.util.List r2 = (java.util.List) r2
            r3 = 0
            android.database.sqlite.SQLiteDatabase r5 = r11.getReadableDatabase()     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            java.lang.String r4 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r4)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            java.lang.String r4 = "id"
            java.lang.String r6 = "event"
            java.lang.String[] r7 = new java.lang.String[]{r4, r6}     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            r8 = 0
            r9 = 0
            java.lang.String r10 = "id ASC"
            r4 = r11
            r6 = r12
            android.database.Cursor r3 = r4.queryDb(r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
        L_0x0037:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r3)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            boolean r4 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            if (r4 == 0) goto L_0x0067
            r4 = 0
            long r5 = r3.getLong(r4)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            r7 = 1
            java.lang.String r8 = r3.getString(r7)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            r9 = r8
            java.lang.CharSequence r9 = (java.lang.CharSequence) r9     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            if (r9 == 0) goto L_0x0055
            int r9 = r9.length()     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            if (r9 != 0) goto L_0x0056
        L_0x0055:
            r4 = r7
        L_0x0056:
            if (r4 == 0) goto L_0x0059
            goto L_0x0037
        L_0x0059:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            r4.<init>((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            java.lang.String r7 = "event_id"
            r4.put((java.lang.String) r7, (long) r5)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            r2.add(r4)     // Catch:{ SQLiteException -> 0x00ac, StackOverflowError -> 0x007f, IllegalStateException -> 0x0074, RuntimeException -> 0x006d }
            goto L_0x0037
        L_0x0067:
            r3.close()
            goto L_0x007b
        L_0x006b:
            r12 = move-exception
            goto L_0x00da
        L_0x006d:
            r12 = move-exception
            r11.convertIfCursorWindowException(r12)     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x007b
            goto L_0x0067
        L_0x0074:
            r12 = move-exception
            r11.handleIfCursorRowTooLargeException(r12)     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x007b
            goto L_0x0067
        L_0x007b:
            r11.close()
            goto L_0x00d9
        L_0x007f:
            r4 = move-exception
            com.amplitude.reactnative.LogcatLogger$Companion r5 = com.amplitude.reactnative.LogcatLogger.Companion     // Catch:{ all -> 0x006b }
            com.amplitude.reactnative.LogcatLogger r5 = r5.getLogger()     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r6.<init>()     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r1 = r6.append(r1)     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r12 = r1.append(r12)     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r0 = r4.getMessage()     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x006b }
            r5.error(r12)     // Catch:{ all -> 0x006b }
            r11.closeDb()     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x007b
            goto L_0x0067
        L_0x00ac:
            r4 = move-exception
            com.amplitude.reactnative.LogcatLogger$Companion r5 = com.amplitude.reactnative.LogcatLogger.Companion     // Catch:{ all -> 0x006b }
            com.amplitude.reactnative.LogcatLogger r5 = r5.getLogger()     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x006b }
            r6.<init>()     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r1 = r6.append(r1)     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r12 = r1.append(r12)     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r0 = r4.getMessage()     // Catch:{ all -> 0x006b }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x006b }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x006b }
            r5.error(r12)     // Catch:{ all -> 0x006b }
            r11.closeDb()     // Catch:{ all -> 0x006b }
            if (r3 == 0) goto L_0x007b
            goto L_0x0067
        L_0x00d9:
            return r2
        L_0x00da:
            if (r3 == 0) goto L_0x00df
            r3.close()
        L_0x00df:
            r11.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.reactnative.LegacyDatabaseStorage.readEventsFromTable(java.lang.String):java.util.List");
    }

    public final synchronized void removeEvent(int i) {
        removeEventFromTable("events", i);
    }

    public final synchronized void removeIdentify(int i) {
        removeEventFromTable(DatabaseConstants.IDENTIFY_TABLE_NAME, i);
    }

    public final synchronized void removeInterceptedIdentify(int i) {
        if (this.currentDbVersion >= 4) {
            removeEventFromTable(DatabaseConstants.IDENTIFY_INTERCEPTOR_TABLE_NAME, i);
        }
    }

    private final void removeEventFromTable(String str, int i) {
        try {
            getWritableDatabase().delete(str, "id = ?", new String[]{String.valueOf(i)});
        } catch (SQLiteException e) {
            LogcatLogger.Companion.getLogger().error("remove events from " + str + " failed: " + e.getMessage());
            closeDb();
        } catch (StackOverflowError e2) {
            LogcatLogger.Companion.getLogger().error("remove events from " + str + " failed: " + e2.getMessage());
            closeDb();
        } catch (Throwable th) {
            close();
            throw th;
        }
        close();
    }

    public final synchronized String getValue(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (String) getValueFromTable(DatabaseConstants.STORE_TABLE_NAME, str);
    }

    public final synchronized Long getLongValue(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return (Long) getValueFromTable(DatabaseConstants.LONG_STORE_TABLE_NAME, str);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v2, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v9, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v4, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v18, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v5, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v16, resolved type: android.database.Cursor} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v21, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v22, resolved type: java.lang.Object} */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c9, code lost:
        if (r13 != null) goto L_0x004d;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0067 A[Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d, all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006f A[Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d, all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009d A[Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d, all -> 0x00cd }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00d1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.Object getValueFromTable(java.lang.String r12, java.lang.String r13) {
        /*
            r11 = this;
            java.lang.String r0 = " failed: "
            java.lang.String r1 = "getValue from "
            java.io.File r2 = r11.file
            boolean r2 = r2.exists()
            r3 = 0
            if (r2 != 0) goto L_0x000e
            return r3
        L_0x000e:
            android.database.sqlite.SQLiteDatabase r5 = r11.getReadableDatabase()     // Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d }
            java.lang.String r2 = "db"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r2)     // Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d }
            java.lang.String r2 = "key"
            java.lang.String r4 = "value"
            java.lang.String[] r7 = new java.lang.String[]{r2, r4}     // Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d }
            java.lang.String r8 = "key = ?"
            r2 = 1
            java.lang.String[] r9 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d }
            r4 = 0
            r9[r4] = r13     // Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d }
            r10 = 0
            r4 = r11
            r6 = r12
            android.database.Cursor r13 = r4.queryDb(r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x009e, StackOverflowError -> 0x0070, IllegalStateException -> 0x0068, RuntimeException -> 0x0060, all -> 0x005d }
            kotlin.jvm.internal.Intrinsics.checkNotNull(r13)     // Catch:{ SQLiteException -> 0x005b, StackOverflowError -> 0x0059, IllegalStateException -> 0x0057, RuntimeException -> 0x0055 }
            boolean r4 = r13.moveToFirst()     // Catch:{ SQLiteException -> 0x005b, StackOverflowError -> 0x0059, IllegalStateException -> 0x0057, RuntimeException -> 0x0055 }
            if (r4 == 0) goto L_0x004d
            java.lang.String r4 = "store"
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r4)     // Catch:{ SQLiteException -> 0x005b, StackOverflowError -> 0x0059, IllegalStateException -> 0x0057, RuntimeException -> 0x0055 }
            if (r4 == 0) goto L_0x0044
            java.lang.String r12 = r13.getString(r2)     // Catch:{ SQLiteException -> 0x005b, StackOverflowError -> 0x0059, IllegalStateException -> 0x0057, RuntimeException -> 0x0055 }
            goto L_0x004c
        L_0x0044:
            long r4 = r13.getLong(r2)     // Catch:{ SQLiteException -> 0x005b, StackOverflowError -> 0x0059, IllegalStateException -> 0x0057, RuntimeException -> 0x0055 }
            java.lang.Long r12 = java.lang.Long.valueOf(r4)     // Catch:{ SQLiteException -> 0x005b, StackOverflowError -> 0x0059, IllegalStateException -> 0x0057, RuntimeException -> 0x0055 }
        L_0x004c:
            r3 = r12
        L_0x004d:
            r13.close()
        L_0x0050:
            r11.close()
            goto L_0x00cc
        L_0x0055:
            r12 = move-exception
            goto L_0x0062
        L_0x0057:
            r12 = move-exception
            goto L_0x006a
        L_0x0059:
            r2 = move-exception
            goto L_0x0072
        L_0x005b:
            r2 = move-exception
            goto L_0x00a0
        L_0x005d:
            r12 = move-exception
            goto L_0x00cf
        L_0x0060:
            r12 = move-exception
            r13 = r3
        L_0x0062:
            r11.convertIfCursorWindowException(r12)     // Catch:{ all -> 0x00cd }
            if (r13 == 0) goto L_0x0050
            goto L_0x004d
        L_0x0068:
            r12 = move-exception
            r13 = r3
        L_0x006a:
            r11.handleIfCursorRowTooLargeException(r12)     // Catch:{ all -> 0x00cd }
            if (r13 == 0) goto L_0x0050
            goto L_0x004d
        L_0x0070:
            r2 = move-exception
            r13 = r3
        L_0x0072:
            com.amplitude.reactnative.LogcatLogger$Companion r4 = com.amplitude.reactnative.LogcatLogger.Companion     // Catch:{ all -> 0x00cd }
            com.amplitude.reactnative.LogcatLogger r4 = r4.getLogger()     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r5.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r1 = r5.append(r1)     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r12 = r1.append(r12)     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = r2.getMessage()     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x00cd }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00cd }
            r4.error(r12)     // Catch:{ all -> 0x00cd }
            r11.closeDb()     // Catch:{ all -> 0x00cd }
            if (r13 == 0) goto L_0x0050
            goto L_0x004d
        L_0x009e:
            r2 = move-exception
            r13 = r3
        L_0x00a0:
            com.amplitude.reactnative.LogcatLogger$Companion r4 = com.amplitude.reactnative.LogcatLogger.Companion     // Catch:{ all -> 0x00cd }
            com.amplitude.reactnative.LogcatLogger r4 = r4.getLogger()     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x00cd }
            r5.<init>()     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r1 = r5.append(r1)     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r12 = r1.append(r12)     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x00cd }
            java.lang.String r0 = r2.getMessage()     // Catch:{ all -> 0x00cd }
            java.lang.StringBuilder r12 = r12.append(r0)     // Catch:{ all -> 0x00cd }
            java.lang.String r12 = r12.toString()     // Catch:{ all -> 0x00cd }
            r4.error(r12)     // Catch:{ all -> 0x00cd }
            r11.closeDb()     // Catch:{ all -> 0x00cd }
            if (r13 == 0) goto L_0x0050
            goto L_0x004d
        L_0x00cc:
            return r3
        L_0x00cd:
            r12 = move-exception
            r3 = r13
        L_0x00cf:
            if (r3 == 0) goto L_0x00d4
            r3.close()
        L_0x00d4:
            r11.close()
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amplitude.reactnative.LegacyDatabaseStorage.getValueFromTable(java.lang.String, java.lang.String):java.lang.Object");
    }

    public final synchronized void removeValue(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        removeValueFromTable(DatabaseConstants.STORE_TABLE_NAME, str);
    }

    public final synchronized void removeLongValue(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        removeValueFromTable(DatabaseConstants.LONG_STORE_TABLE_NAME, str);
    }

    private final void removeValueFromTable(String str, String str2) {
        try {
            getWritableDatabase().delete(str, "key = ?", new String[]{str2});
        } catch (SQLiteException e) {
            LogcatLogger.Companion.getLogger().error("remove value from " + str + " failed: " + e.getMessage());
            closeDb();
        } catch (StackOverflowError e2) {
            LogcatLogger.Companion.getLogger().error("remove value from " + str + " failed: " + e2.getMessage());
            closeDb();
        } catch (Throwable th) {
            close();
            throw th;
        }
        close();
    }
}
