package com.adapty.internal.data.cache;

import android.content.Context;
import android.content.SharedPreferences;
import com.adapty.internal.crossplatform.AdaptyImmutableMapTypeAdapterFactory;
import com.google.gson.Gson;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010$\n\u0002\b\u0002\b\u0001\u0018\u0000 /2\u00020\u0001:\u0001/B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001f\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010\u0014¢\u0006\u0002\u0010\u0017J2\u0010\u0018\u001a\u0004\u0018\u0001H\u0019\"\u0006\b\u0000\u0010\u0019\u0018\u00012\u0006\u0010\u0015\u001a\u00020\u00122\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u0002H\u0019\u0018\u00010\u001bH\b¢\u0006\u0002\u0010\u001cJ(\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011J\u001f\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010\u0016\u001a\u0004\u0018\u00010!¢\u0006\u0002\u0010\"J\u0010\u0010#\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0012J\u0010\u0010$\u001a\u00020\u00142\u0006\u0010%\u001a\u00020\u0012H\u0002J\u0016\u0010&\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0014J\u0018\u0010(\u001a\u00020\u000f2\u0006\u0010\u0015\u001a\u00020\u00122\b\u0010)\u001a\u0004\u0018\u00010\u0001J\u0016\u0010*\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010'\u001a\u00020!J\u0016\u0010+\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010'\u001a\u00020\u0012J\u001a\u0010,\u001a\u00020\u00142\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120.R\u0016\u0010\u0007\u001a\n \t*\u0004\u0018\u00010\b0\bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \t*\u0004\u0018\u00010\u000b0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rXD¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/adapty/internal/data/cache/PreferenceManager;", "", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "editor", "Landroid/content/SharedPreferences$Editor;", "kotlin.jvm.PlatformType", "pref", "Landroid/content/SharedPreferences;", "privateMode", "", "clearData", "", "keys", "", "", "getBoolean", "", "key", "defaultValue", "(Ljava/lang/String;Ljava/lang/Boolean;)Ljava/lang/Boolean;", "getData", "T", "classOfT", "Ljava/lang/Class;", "(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;", "getKeysToRemove", "containsKeys", "startsWithKeys", "getLong", "", "(Ljava/lang/String;Ljava/lang/Long;)Ljava/lang/Long;", "getString", "isNotEmpty", "str", "saveBoolean", "value", "saveData", "data", "saveLong", "saveString", "saveStrings", "map", "", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: PreferenceManager.kt */
public final class PreferenceManager {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    private static final String PREF_NAME = "AdaptySDKPrefs";
    private final SharedPreferences.Editor editor;
    /* access modifiers changed from: private */
    public final Gson gson;
    /* access modifiers changed from: private */
    public final SharedPreferences pref;
    private final int privateMode;

    public PreferenceManager(Context context, Gson gson2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(gson2, "gson");
        this.gson = gson2;
        SharedPreferences sharedPreferences = context.getSharedPreferences(PREF_NAME, this.privateMode);
        this.pref = sharedPreferences;
        this.editor = sharedPreferences.edit();
    }

    public final /* synthetic */ void clearData(Set set) {
        Intrinsics.checkNotNullParameter(set, "keys");
        SharedPreferences.Editor editor2 = this.editor;
        Iterator it = set.iterator();
        while (it.hasNext()) {
            editor2.remove((String) it.next());
        }
        editor2.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0056, code lost:
        if (r7 != null) goto L_0x0058;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ java.util.Set getKeysToRemove(java.util.Set r11, java.util.Set r12) {
        /*
            r10 = this;
            java.lang.String r0 = "containsKeys"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r11, r0)
            java.lang.String r0 = "startsWithKeys"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            android.content.SharedPreferences r0 = r10.pref
            java.util.Map r0 = r0.getAll()
            java.util.Set r0 = r0.keySet()
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            java.util.Set r1 = (java.util.Set) r1
            java.util.Collection r1 = (java.util.Collection) r1
            java.util.Iterator r0 = r0.iterator()
        L_0x0023:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x005f
            java.lang.Object r2 = r0.next()
            r3 = r2
            java.lang.String r3 = (java.lang.String) r3
            r4 = 0
            if (r3 == 0) goto L_0x0059
            boolean r5 = r11.contains(r3)
            if (r5 != 0) goto L_0x0058
            r5 = r12
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x0040:
            boolean r6 = r5.hasNext()
            r7 = 0
            if (r6 == 0) goto L_0x0056
            java.lang.Object r6 = r5.next()
            r8 = r6
            java.lang.String r8 = (java.lang.String) r8
            r9 = 2
            boolean r7 = kotlin.text.StringsKt.startsWith$default(r3, r8, r4, r9, r7)
            if (r7 == 0) goto L_0x0040
            r7 = r6
        L_0x0056:
            if (r7 == 0) goto L_0x0059
        L_0x0058:
            r4 = 1
        L_0x0059:
            if (r4 == 0) goto L_0x0023
            r1.add(r2)
            goto L_0x0023
        L_0x005f:
            java.util.Set r1 = (java.util.Set) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.PreferenceManager.getKeysToRemove(java.util.Set, java.util.Set):java.util.Set");
    }

    public final /* synthetic */ Boolean getBoolean(String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.pref.contains(str)) {
            return bool;
        }
        return Boolean.valueOf(this.pref.getBoolean(str, bool != null ? bool.booleanValue() : false));
    }

    public final /* synthetic */ boolean saveBoolean(String str, boolean z) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.editor.putBoolean(str, z).commit();
    }

    public final /* synthetic */ Long getLong(String str, Long l) {
        Intrinsics.checkNotNullParameter(str, "key");
        if (!this.pref.contains(str)) {
            return l;
        }
        return Long.valueOf(this.pref.getLong(str, l != null ? l.longValue() : 0));
    }

    public final /* synthetic */ boolean saveLong(String str, long j) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.editor.putLong(str, j).commit();
    }

    public final /* synthetic */ String getString(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.pref.getString(str, (String) null);
    }

    public final /* synthetic */ boolean saveString(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "key");
        Intrinsics.checkNotNullParameter(str2, "value");
        return this.editor.putString(str, str2).commit();
    }

    public final /* synthetic */ boolean saveStrings(Map map) {
        Intrinsics.checkNotNullParameter(map, AdaptyImmutableMapTypeAdapterFactory.MAP);
        SharedPreferences.Editor editor2 = this.editor;
        for (Map.Entry entry : map.entrySet()) {
            editor2.putString((String) entry.getKey(), (String) entry.getValue());
        }
        return editor2.commit();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r2 == null) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ java.lang.Object getData$default(com.adapty.internal.data.cache.PreferenceManager r0, java.lang.String r1, java.lang.Class r2, int r3, java.lang.Object r4) {
        /*
            r3 = r3 & 2
            r4 = 0
            if (r3 == 0) goto L_0x0006
            r2 = r4
        L_0x0006:
            java.lang.String r3 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r3)
            android.content.SharedPreferences r3 = r0.pref
            java.lang.String r1 = r3.getString(r1, r4)
            if (r1 == 0) goto L_0x0040
            boolean r3 = r0.isNotEmpty(r1)
            if (r3 == 0) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r4
        L_0x001d:
            if (r1 == 0) goto L_0x0040
            if (r2 == 0) goto L_0x002b
            com.google.gson.Gson r3 = r0.gson     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r2 = r3.fromJson((java.lang.String) r1, r2)     // Catch:{ Exception -> 0x0040 }
            if (r2 != 0) goto L_0x003f
        L_0x002b:
            com.google.gson.Gson r0 = r0.gson     // Catch:{ Exception -> 0x0040 }
            kotlin.jvm.internal.Intrinsics.needClassReification()     // Catch:{ Exception -> 0x0040 }
            com.adapty.internal.data.cache.PreferenceManager$getData$2$2 r2 = new com.adapty.internal.data.cache.PreferenceManager$getData$2$2     // Catch:{ Exception -> 0x0040 }
            r2.<init>()     // Catch:{ Exception -> 0x0040 }
            java.lang.reflect.Type r2 = r2.getType()     // Catch:{ Exception -> 0x0040 }
            java.lang.Object r2 = r0.fromJson((java.lang.String) r1, (java.lang.reflect.Type) r2)     // Catch:{ Exception -> 0x0040 }
        L_0x003f:
            r4 = r2
        L_0x0040:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.PreferenceManager.getData$default(com.adapty.internal.data.cache.PreferenceManager, java.lang.String, java.lang.Class, int, java.lang.Object):java.lang.Object");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0024, code lost:
        if (r4 == null) goto L_0x0026;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ <T> T getData(java.lang.String r3, java.lang.Class<T> r4) {
        /*
            r2 = this;
            java.lang.String r0 = "key"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            android.content.SharedPreferences r0 = r2.pref
            r1 = 0
            java.lang.String r3 = r0.getString(r3, r1)
            if (r3 == 0) goto L_0x003b
            boolean r0 = r2.isNotEmpty(r3)
            if (r0 == 0) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r3 = r1
        L_0x0018:
            if (r3 == 0) goto L_0x003b
            if (r4 == 0) goto L_0x0026
            com.google.gson.Gson r0 = r2.gson     // Catch:{ Exception -> 0x003b }
            java.lang.Object r4 = r0.fromJson((java.lang.String) r3, r4)     // Catch:{ Exception -> 0x003b }
            if (r4 != 0) goto L_0x003a
        L_0x0026:
            com.google.gson.Gson r4 = r2.gson     // Catch:{ Exception -> 0x003b }
            kotlin.jvm.internal.Intrinsics.needClassReification()     // Catch:{ Exception -> 0x003b }
            com.adapty.internal.data.cache.PreferenceManager$getData$2$2 r0 = new com.adapty.internal.data.cache.PreferenceManager$getData$2$2     // Catch:{ Exception -> 0x003b }
            r0.<init>()     // Catch:{ Exception -> 0x003b }
            java.lang.reflect.Type r0 = r0.getType()     // Catch:{ Exception -> 0x003b }
            java.lang.Object r4 = r4.fromJson((java.lang.String) r3, (java.lang.reflect.Type) r0)     // Catch:{ Exception -> 0x003b }
        L_0x003a:
            r1 = r4
        L_0x003b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.adapty.internal.data.cache.PreferenceManager.getData(java.lang.String, java.lang.Class):java.lang.Object");
    }

    public final /* synthetic */ void saveData(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.editor.putString(str, this.gson.toJson(obj)).commit();
    }

    /* access modifiers changed from: private */
    public final boolean isNotEmpty(String str) {
        return str.length() > 4;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/adapty/internal/data/cache/PreferenceManager$Companion;", "", "()V", "PREF_NAME", "", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: PreferenceManager.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
