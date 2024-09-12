package com.google.android.gms.dynamite;

import android.content.Context;
import android.content.pm.ProviderInfo;
import android.database.Cursor;
import android.os.IBinder;
import android.os.IInterface;
import android.util.Log;
import com.google.android.exoplayer2.extractor.ts.TsExtractor;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.common.internal.Preconditions;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
public final class DynamiteModule {
    public static final int LOCAL = -1;
    public static final int NONE = 0;
    public static final int NO_SELECTION = 0;
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION = new zzi();
    public static final VersionPolicy PREFER_HIGHEST_OR_LOCAL_VERSION_NO_FORCE_STAGING = new zzj();
    public static final VersionPolicy PREFER_HIGHEST_OR_REMOTE_VERSION = new zzk();
    public static final VersionPolicy PREFER_LOCAL = new zzg();
    public static final VersionPolicy PREFER_REMOTE = new zzf();
    public static final VersionPolicy PREFER_REMOTE_VERSION_NO_FORCE_STAGING = new zzh();
    public static final int REMOTE = 1;
    public static final VersionPolicy zza = new zzl();
    private static Boolean zzb = null;
    private static String zzc = null;
    private static boolean zzd = false;
    private static int zze = -1;
    private static Boolean zzf;
    private static final ThreadLocal zzg = new ThreadLocal();
    private static final ThreadLocal zzh = new zzd();
    private static final VersionPolicy.IVersions zzi = new zze();
    private static zzq zzk;
    private static zzr zzl;
    private final Context zzj;

    /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public static class DynamiteLoaderClassLoader {
        public static ClassLoader sClassLoader;
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public static class LoadingException extends Exception {
        /* synthetic */ LoadingException(String str, zzp zzp) {
            super(str);
        }

        /* synthetic */ LoadingException(String str, Throwable th, zzp zzp) {
            super(str, th);
        }
    }

    /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
    public interface VersionPolicy {

        /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
        public interface IVersions {
            int zza(Context context, String str);

            int zzb(Context context, String str, boolean z) throws LoadingException;
        }

        /* compiled from: com.google.android.gms:play-services-basement@@18.2.0 */
        public static class SelectionResult {
            public int localVersion = 0;
            public int remoteVersion = 0;
            public int selection = 0;
        }

        SelectionResult selectModule(Context context, String str, IVersions iVersions) throws LoadingException;
    }

    private DynamiteModule(Context context) {
        Preconditions.checkNotNull(context);
        this.zzj = context;
    }

    public static int getLocalVersion(Context context, String str) {
        try {
            ClassLoader classLoader = context.getApplicationContext().getClassLoader();
            Class<?> loadClass = classLoader.loadClass("com.google.android.gms.dynamite.descriptors." + str + ".ModuleDescriptor");
            Field declaredField = loadClass.getDeclaredField("MODULE_ID");
            Field declaredField2 = loadClass.getDeclaredField("MODULE_VERSION");
            if (Objects.equal(declaredField.get((Object) null), str)) {
                return declaredField2.getInt((Object) null);
            }
            String valueOf = String.valueOf(declaredField.get((Object) null));
            Log.e("DynamiteModule", "Module descriptor id '" + valueOf + "' didn't match expected id '" + str + "'");
            return 0;
        } catch (ClassNotFoundException unused) {
            Log.w("DynamiteModule", "Local module descriptor class for " + str + " not found.");
            return 0;
        } catch (Exception e) {
            Log.e("DynamiteModule", "Failed to load module descriptor class: ".concat(String.valueOf(e.getMessage())));
            return 0;
        }
    }

    public static int getRemoteVersion(Context context, String str) {
        return zza(context, str, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01d7, code lost:
        r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01db, code lost:
        if (r2 == null) goto L_0x0200;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01dd, code lost:
        r4 = new com.google.android.gms.dynamite.DynamiteModule((android.content.Context) r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01e8, code lost:
        if (r10 != 0) goto L_0x01ee;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01ea, code lost:
        r9.remove();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01ee, code lost:
        r9.set(java.lang.Long.valueOf(r10));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x01f5, code lost:
        r1 = r8.zza;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:108:0x01f7, code lost:
        if (r1 == null) goto L_0x01fc;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x01f9, code lost:
        r1.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x01fc, code lost:
        r0.set(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x01ff, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:114:0x0208, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to load remote module.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:116:0x0211, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to create IDynamiteLoader.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:117:0x0212, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:118:0x021c, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to determine which loading route to use.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x022f, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0231, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0233, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00b1, code lost:
        if (r15 == null) goto L_0x0212;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b8, code lost:
        if (r15.booleanValue() == false) goto L_0x0169;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00ba, code lost:
        android.util.Log.i("DynamiteModule", "Selected remote version of " + r3 + ", version >= " + r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d8, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        r2 = zzl;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00db, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00dc, code lost:
        if (r2 == null) goto L_0x0157;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:?, code lost:
        r6 = (com.google.android.gms.dynamite.zzn) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00e4, code lost:
        if (r6 == null) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x00e8, code lost:
        if (r6.zza == null) goto L_0x014c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x00ea, code lost:
        r15 = r18.getApplicationContext();
        r6 = r6.zza;
        com.google.android.gms.dynamic.ObjectWrapper.wrap(null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:0x00f5, code lost:
        monitor-enter(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x00f6, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00fa, code lost:
        if (zze < 2) goto L_0x00fe;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x00fc, code lost:
        r12 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x00fe, code lost:
        r12 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x00ff, code lost:
        r5 = java.lang.Boolean.valueOf(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0103, code lost:
        monitor-exit(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:63:0x0108, code lost:
        if (r5.booleanValue() == false) goto L_0x011e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:64:0x010a, code lost:
        android.util.Log.v("DynamiteModule", "Dynamite loader version >= 2, using loadModule2NoCrashUtils");
        r2 = r2.zzf(com.google.android.gms.dynamic.ObjectWrapper.wrap(r15), r3, r13, com.google.android.gms.dynamic.ObjectWrapper.wrap(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:65:0x011e, code lost:
        android.util.Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to loadModule2");
        r2 = r2.zze(com.google.android.gms.dynamic.ObjectWrapper.wrap(r15), r3, r13, com.google.android.gms.dynamic.ObjectWrapper.wrap(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0131, code lost:
        r2 = (android.content.Context) com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x0137, code lost:
        if (r2 == null) goto L_0x0140;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:68:0x0139, code lost:
        r4 = new com.google.android.gms.dynamite.DynamiteModule(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0148, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("Failed to get module context", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:76:0x014c, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:77:0x0156, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("No result cursor", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0157, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:79:0x0161, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("DynamiteLoaderV2 was not cached.", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:80:0x0162, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:81:0x0163, code lost:
        r17 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:?, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x0167, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0169, code lost:
        r17 = r5;
        android.util.Log.i("DynamiteModule", "Selected remote version of " + r3 + ", version >= " + r13);
        r2 = zzg(r18);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:89:0x018d, code lost:
        if (r2 == null) goto L_0x0209;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x018f, code lost:
        r4 = r2.zze();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x0194, code lost:
        if (r4 < 3) goto L_0x01b6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0196, code lost:
        r4 = (com.google.android.gms.dynamite.zzn) r0.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x019c, code lost:
        if (r4 == null) goto L_0x01ad;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x019e, code lost:
        r2 = r2.zzi(com.google.android.gms.dynamic.ObjectWrapper.wrap(r18), r3, r13, com.google.android.gms.dynamic.ObjectWrapper.wrap(r4.zza));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:96:0x01b5, code lost:
        throw new com.google.android.gms.dynamite.DynamiteModule.LoadingException("No cached result cursor holder", (com.google.android.gms.dynamite.zzp) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01b6, code lost:
        if (r4 != 2) goto L_0x01c8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01b8, code lost:
        android.util.Log.w("DynamiteModule", "IDynamite loader version = 2");
        r2 = r2.zzj(com.google.android.gms.dynamic.ObjectWrapper.wrap(r18), r3, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01c8, code lost:
        android.util.Log.w("DynamiteModule", "Dynamite loader version < 2, falling back to createModuleContext");
        r2 = r2.zzh(com.google.android.gms.dynamic.ObjectWrapper.wrap(r18), r3, r13);
     */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x0277 A[Catch:{ all -> 0x0302 }] */
    @com.google.errorprone.annotations.ResultIgnorabilityUnspecified
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.google.android.gms.dynamite.DynamiteModule load(android.content.Context r18, com.google.android.gms.dynamite.DynamiteModule.VersionPolicy r19, java.lang.String r20) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r1 = r18
            r2 = r19
            r3 = r20
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r4 = com.google.android.gms.dynamite.DynamiteModule.class
            android.content.Context r5 = r18.getApplicationContext()
            r6 = 0
            if (r5 == 0) goto L_0x0325
            java.lang.ThreadLocal r0 = zzg
            java.lang.Object r7 = r0.get()
            com.google.android.gms.dynamite.zzn r7 = (com.google.android.gms.dynamite.zzn) r7
            com.google.android.gms.dynamite.zzn r8 = new com.google.android.gms.dynamite.zzn
            r8.<init>(r6)
            r0.set(r8)
            java.lang.ThreadLocal r9 = zzh
            java.lang.Object r10 = r9.get()
            java.lang.Long r10 = (java.lang.Long) r10
            long r10 = r10.longValue()
            long r14 = android.os.SystemClock.elapsedRealtime()     // Catch:{ all -> 0x0302 }
            java.lang.Long r14 = java.lang.Long.valueOf(r14)     // Catch:{ all -> 0x0302 }
            r9.set(r14)     // Catch:{ all -> 0x0302 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$IVersions r14 = zzi     // Catch:{ all -> 0x0302 }
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r14 = r2.selectModule(r1, r3, r14)     // Catch:{ all -> 0x0302 }
            java.lang.String r15 = "DynamiteModule"
            int r6 = r14.localVersion     // Catch:{ all -> 0x0302 }
            int r12 = r14.remoteVersion     // Catch:{ all -> 0x0302 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0302 }
            r13.<init>()     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "Considering local module "
            r13.append(r2)     // Catch:{ all -> 0x0302 }
            r13.append(r3)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = ":"
            r13.append(r2)     // Catch:{ all -> 0x0302 }
            r13.append(r6)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = " and remote module "
            r13.append(r2)     // Catch:{ all -> 0x0302 }
            r13.append(r3)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = ":"
            r13.append(r2)     // Catch:{ all -> 0x0302 }
            r13.append(r12)     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = r13.toString()     // Catch:{ all -> 0x0302 }
            android.util.Log.i(r15, r2)     // Catch:{ all -> 0x0302 }
            int r2 = r14.selection     // Catch:{ all -> 0x0302 }
            if (r2 == 0) goto L_0x02d1
            r6 = -1
            if (r2 != r6) goto L_0x007a
            int r2 = r14.localVersion     // Catch:{ all -> 0x0302 }
            if (r2 == 0) goto L_0x02d1
            r2 = r6
        L_0x007a:
            r12 = 1
            if (r2 != r12) goto L_0x0081
            int r13 = r14.remoteVersion     // Catch:{ all -> 0x0302 }
            if (r13 == 0) goto L_0x02d1
        L_0x0081:
            if (r2 != r6) goto L_0x00a3
            com.google.android.gms.dynamite.DynamiteModule r1 = zzc(r5, r3)     // Catch:{ all -> 0x0302 }
            r2 = 0
            int r2 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r2 != 0) goto L_0x0091
            r9.remove()
            goto L_0x0098
        L_0x0091:
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r9.set(r2)
        L_0x0098:
            android.database.Cursor r2 = r8.zza
            if (r2 == 0) goto L_0x009f
            r2.close()
        L_0x009f:
            r0.set(r7)
            return r1
        L_0x00a3:
            if (r2 != r12) goto L_0x02b9
            int r13 = r14.remoteVersion     // Catch:{ LoadingException -> 0x0256 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            boolean r15 = zzf(r18)     // Catch:{ all -> 0x022a }
            if (r15 == 0) goto L_0x021d
            java.lang.Boolean r15 = zzb     // Catch:{ all -> 0x022a }
            monitor-exit(r4)     // Catch:{ all -> 0x022a }
            if (r15 == 0) goto L_0x0212
            boolean r15 = r15.booleanValue()     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            r12 = 2
            if (r15 == 0) goto L_0x0169
            java.lang.String r15 = "DynamiteModule"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            r6.<init>()     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            java.lang.String r2 = "Selected remote version of "
            r6.append(r2)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            r6.append(r3)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            java.lang.String r2 = ", version >= "
            r6.append(r2)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            r6.append(r13)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            java.lang.String r2 = r6.toString()     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            android.util.Log.i(r15, r2)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            com.google.android.gms.dynamite.zzr r2 = zzl     // Catch:{ all -> 0x0162 }
            monitor-exit(r4)     // Catch:{ all -> 0x0162 }
            if (r2 == 0) goto L_0x0157
            java.lang.Object r6 = r0.get()     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            com.google.android.gms.dynamite.zzn r6 = (com.google.android.gms.dynamite.zzn) r6     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            if (r6 == 0) goto L_0x014c
            android.database.Cursor r15 = r6.zza     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            if (r15 == 0) goto L_0x014c
            android.content.Context r15 = r18.getApplicationContext()     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            android.database.Cursor r6 = r6.zza     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            r16 = 0
            com.google.android.gms.dynamic.ObjectWrapper.wrap(r16)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            monitor-enter(r4)     // Catch:{ RemoteException -> 0x0248, LoadingException -> 0x0244, all -> 0x0235 }
            r17 = r5
            int r5 = zze     // Catch:{ all -> 0x0149 }
            if (r5 < r12) goto L_0x00fe
            r12 = 1
            goto L_0x00ff
        L_0x00fe:
            r12 = 0
        L_0x00ff:
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r12)     // Catch:{ all -> 0x0149 }
            monitor-exit(r4)     // Catch:{ all -> 0x0149 }
            boolean r4 = r5.booleanValue()     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            if (r4 == 0) goto L_0x011e
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r5 = "Dynamite loader version >= 2, using loadModule2NoCrashUtils"
            android.util.Log.v(r4, r5)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r6)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzf(r4, r3, r13, r5)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            goto L_0x0131
        L_0x011e:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r5 = "Dynamite loader version < 2, falling back to loadModule2"
            android.util.Log.w(r4, r5)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r15)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r6)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zze(r4, r3, r13, r5)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x0131:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            if (r2 == 0) goto L_0x0140
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            goto L_0x01e4
        L_0x0140:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r2 = "Failed to get module context"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x0149:
            r0 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x0149 }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x014c:
            r17 = r5
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r2 = "No result cursor"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x0157:
            r17 = r5
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r2 = "DynamiteLoaderV2 was not cached."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x0162:
            r0 = move-exception
            r17 = r5
        L_0x0165:
            monitor-exit(r4)     // Catch:{ all -> 0x0167 }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x0167:
            r0 = move-exception
            goto L_0x0165
        L_0x0169:
            r17 = r5
            java.lang.String r2 = "DynamiteModule"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            r4.<init>()     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r5 = "Selected remote version of "
            r4.append(r5)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            r4.append(r3)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r5 = ", version >= "
            r4.append(r5)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            r4.append(r13)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r4 = r4.toString()     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            android.util.Log.i(r2, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamite.zzq r2 = zzg(r18)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            if (r2 == 0) goto L_0x0209
            int r4 = r2.zze()     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            r5 = 3
            if (r4 < r5) goto L_0x01b6
            java.lang.Object r4 = r0.get()     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamite.zzn r4 = (com.google.android.gms.dynamite.zzn) r4     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            if (r4 == 0) goto L_0x01ad
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            android.database.Cursor r4 = r4.zza     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzi(r5, r3, r13, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            goto L_0x01d7
        L_0x01ad:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r2 = "No cached result cursor holder"
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x01b6:
            if (r4 != r12) goto L_0x01c8
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r5 = "IDynamite loader version = 2"
            android.util.Log.w(r4, r5)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzj(r4, r3, r13)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            goto L_0x01d7
        L_0x01c8:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r5 = "Dynamite loader version < 2, falling back to createModuleContext"
            android.util.Log.w(r4, r5)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r4 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r18)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzh(r4, r3, r13)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x01d7:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            if (r2 == 0) goto L_0x0200
            com.google.android.gms.dynamite.DynamiteModule r4 = new com.google.android.gms.dynamite.DynamiteModule     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            android.content.Context r2 = (android.content.Context) r2     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x01e4:
            r1 = 0
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x01ee
            r9.remove()
            goto L_0x01f5
        L_0x01ee:
            java.lang.Long r1 = java.lang.Long.valueOf(r10)
            r9.set(r1)
        L_0x01f5:
            android.database.Cursor r1 = r8.zza
            if (r1 == 0) goto L_0x01fc
            r1.close()
        L_0x01fc:
            r0.set(r7)
            return r4
        L_0x0200:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r2 = "Failed to load remote module."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x0209:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r2 = "Failed to create IDynamiteLoader."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x0212:
            r17 = r5
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            java.lang.String r2 = "Failed to determine which loading route to use."
            r4 = 0
            r0.<init>(r2, r4)     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x021d:
            r17 = r5
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0228 }
            java.lang.String r2 = "Remote loading disabled"
            r5 = 0
            r0.<init>(r2, r5)     // Catch:{ all -> 0x0228 }
            throw r0     // Catch:{ all -> 0x0228 }
        L_0x0228:
            r0 = move-exception
            goto L_0x022d
        L_0x022a:
            r0 = move-exception
            r17 = r5
        L_0x022d:
            monitor-exit(r4)     // Catch:{ all -> 0x0228 }
            throw r0     // Catch:{ RemoteException -> 0x0233, LoadingException -> 0x0231, all -> 0x022f }
        L_0x022f:
            r0 = move-exception
            goto L_0x0238
        L_0x0231:
            r0 = move-exception
            goto L_0x0247
        L_0x0233:
            r0 = move-exception
            goto L_0x024b
        L_0x0235:
            r0 = move-exception
            r17 = r5
        L_0x0238:
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r1, r0)     // Catch:{ LoadingException -> 0x0254 }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r2 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x0254 }
            java.lang.String r4 = "Failed to load remote module."
            r5 = 0
            r2.<init>(r4, r0, r5)     // Catch:{ LoadingException -> 0x0254 }
            throw r2     // Catch:{ LoadingException -> 0x0254 }
        L_0x0244:
            r0 = move-exception
            r17 = r5
        L_0x0247:
            throw r0     // Catch:{ LoadingException -> 0x0254 }
        L_0x0248:
            r0 = move-exception
            r17 = r5
        L_0x024b:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r2 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ LoadingException -> 0x0254 }
            java.lang.String r4 = "Failed to load remote module."
            r5 = 0
            r2.<init>(r4, r0, r5)     // Catch:{ LoadingException -> 0x0254 }
            throw r2     // Catch:{ LoadingException -> 0x0254 }
        L_0x0254:
            r0 = move-exception
            goto L_0x0259
        L_0x0256:
            r0 = move-exception
            r17 = r5
        L_0x0259:
            java.lang.String r2 = "DynamiteModule"
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0302 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0302 }
            r5.<init>()     // Catch:{ all -> 0x0302 }
            java.lang.String r6 = "Failed to load remote module: "
            r5.append(r6)     // Catch:{ all -> 0x0302 }
            r5.append(r4)     // Catch:{ all -> 0x0302 }
            java.lang.String r4 = r5.toString()     // Catch:{ all -> 0x0302 }
            android.util.Log.w(r2, r4)     // Catch:{ all -> 0x0302 }
            int r2 = r14.localVersion     // Catch:{ all -> 0x0302 }
            if (r2 == 0) goto L_0x02b0
            com.google.android.gms.dynamite.zzo r4 = new com.google.android.gms.dynamite.zzo     // Catch:{ all -> 0x0302 }
            r5 = 0
            r4.<init>(r2, r5)     // Catch:{ all -> 0x0302 }
            r2 = r19
            com.google.android.gms.dynamite.DynamiteModule$VersionPolicy$SelectionResult r1 = r2.selectModule(r1, r3, r4)     // Catch:{ all -> 0x0302 }
            int r1 = r1.selection     // Catch:{ all -> 0x0302 }
            r2 = -1
            if (r1 != r2) goto L_0x02b0
            r1 = r17
            com.google.android.gms.dynamite.DynamiteModule r0 = zzc(r1, r3)     // Catch:{ all -> 0x0302 }
            r1 = 0
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x029a
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x02a3
        L_0x029a:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r1.set(r2)
        L_0x02a3:
            android.database.Cursor r1 = r8.zza
            if (r1 == 0) goto L_0x02aa
            r1.close()
        L_0x02aa:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r7)
            return r0
        L_0x02b0:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r1 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0302 }
            java.lang.String r2 = "Remote load failed. No local fallback found."
            r3 = 0
            r1.<init>(r2, r0, r3)     // Catch:{ all -> 0x0302 }
            throw r1     // Catch:{ all -> 0x0302 }
        L_0x02b9:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0302 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0302 }
            r1.<init>()     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = "VersionPolicy returned invalid code:"
            r1.append(r3)     // Catch:{ all -> 0x0302 }
            r1.append(r2)     // Catch:{ all -> 0x0302 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0302 }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0302 }
            throw r0     // Catch:{ all -> 0x0302 }
        L_0x02d1:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x0302 }
            int r1 = r14.localVersion     // Catch:{ all -> 0x0302 }
            int r2 = r14.remoteVersion     // Catch:{ all -> 0x0302 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0302 }
            r4.<init>()     // Catch:{ all -> 0x0302 }
            java.lang.String r5 = "No acceptable module "
            r4.append(r5)     // Catch:{ all -> 0x0302 }
            r4.append(r3)     // Catch:{ all -> 0x0302 }
            java.lang.String r3 = " found. Local version is "
            r4.append(r3)     // Catch:{ all -> 0x0302 }
            r4.append(r1)     // Catch:{ all -> 0x0302 }
            java.lang.String r1 = " and remote version is "
            r4.append(r1)     // Catch:{ all -> 0x0302 }
            r4.append(r2)     // Catch:{ all -> 0x0302 }
            java.lang.String r1 = "."
            r4.append(r1)     // Catch:{ all -> 0x0302 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0302 }
            r2 = 0
            r0.<init>(r1, r2)     // Catch:{ all -> 0x0302 }
            throw r0     // Catch:{ all -> 0x0302 }
        L_0x0302:
            r0 = move-exception
            r1 = 0
            int r1 = (r10 > r1 ? 1 : (r10 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x030f
            java.lang.ThreadLocal r1 = zzh
            r1.remove()
            goto L_0x0318
        L_0x030f:
            java.lang.ThreadLocal r1 = zzh
            java.lang.Long r2 = java.lang.Long.valueOf(r10)
            r1.set(r2)
        L_0x0318:
            android.database.Cursor r1 = r8.zza
            if (r1 == 0) goto L_0x031f
            r1.close()
        L_0x031f:
            java.lang.ThreadLocal r1 = zzg
            r1.set(r7)
            throw r0
        L_0x0325:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r0 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException
            java.lang.String r1 = "null application Context"
            r2 = 0
            r0.<init>(r1, r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.load(android.content.Context, com.google.android.gms.dynamite.DynamiteModule$VersionPolicy, java.lang.String):com.google.android.gms.dynamite.DynamiteModule");
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index: 0, Size: 0
        	at java.util.ArrayList.rangeCheck(ArrayList.java:659)
        	at java.util.ArrayList.get(ArrayList.java:435)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processIf(RegionMaker.java:693)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:123)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:598)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:31:0x0056=Splitter:B:31:0x0056, B:17:0x003b=Splitter:B:17:0x003b, B:50:0x009c=Splitter:B:50:0x009c} */
    public static int zza(android.content.Context r10, java.lang.String r11, boolean r12) {
        /*
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r0 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r0)     // Catch:{ all -> 0x01c4 }
            java.lang.Boolean r1 = zzb     // Catch:{ all -> 0x01c1 }
            r2 = 0
            r3 = 0
            if (r1 != 0) goto L_0x00da
            android.content.Context r1 = r10.getApplicationContext()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule$DynamiteLoaderClassLoader> r4 = com.google.android.gms.dynamite.DynamiteModule.DynamiteLoaderClassLoader.class
            java.lang.String r4 = r4.getName()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class r1 = r1.loadClass(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.String r4 = "sClassLoader"
            java.lang.reflect.Field r1 = r1.getDeclaredField(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Class r4 = r1.getDeclaringClass()     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            monitor-enter(r4)     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
            java.lang.Object r5 = r1.get(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.ClassLoader r5 = (java.lang.ClassLoader) r5     // Catch:{ all -> 0x00b4 }
            java.lang.ClassLoader r6 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            if (r5 != r6) goto L_0x0036
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x0036:
            if (r5 == 0) goto L_0x003f
            zzd(r5)     // Catch:{ LoadingException -> 0x003b }
        L_0x003b:
            java.lang.Boolean r1 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x003f:
            boolean r5 = zzf(r10)     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x0048
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c1 }
            return r3
        L_0x0048:
            boolean r5 = zzd     // Catch:{ all -> 0x00b4 }
            if (r5 != 0) goto L_0x00a9
            java.lang.Boolean r5 = java.lang.Boolean.TRUE     // Catch:{ all -> 0x00b4 }
            boolean r5 = r5.equals(r2)     // Catch:{ all -> 0x00b4 }
            if (r5 == 0) goto L_0x0055
            goto L_0x00a9
        L_0x0055:
            r5 = 1
            int r5 = zzb(r10, r11, r12, r5)     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r6 = zzc     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x009c
            boolean r6 = r6.isEmpty()     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x0065
            goto L_0x009c
        L_0x0065:
            java.lang.ClassLoader r6 = com.google.android.gms.dynamite.zzb.zza()     // Catch:{ LoadingException -> 0x009f }
            if (r6 == 0) goto L_0x006c
            goto L_0x008f
        L_0x006c:
            int r6 = android.os.Build.VERSION.SDK_INT     // Catch:{ LoadingException -> 0x009f }
            r7 = 29
            if (r6 < r7) goto L_0x0081
            dalvik.system.DelegateLastClassLoader r6 = new dalvik.system.DelegateLastClassLoader     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x009f }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009f }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x009f }
            goto L_0x008f
        L_0x0081:
            com.google.android.gms.dynamite.zzc r6 = new com.google.android.gms.dynamite.zzc     // Catch:{ LoadingException -> 0x009f }
            java.lang.String r7 = zzc     // Catch:{ LoadingException -> 0x009f }
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r7)     // Catch:{ LoadingException -> 0x009f }
            java.lang.ClassLoader r8 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ LoadingException -> 0x009f }
            r6.<init>(r7, r8)     // Catch:{ LoadingException -> 0x009f }
        L_0x008f:
            zzd(r6)     // Catch:{ LoadingException -> 0x009f }
            r1.set(r2, r6)     // Catch:{ LoadingException -> 0x009f }
            java.lang.Boolean r6 = java.lang.Boolean.TRUE     // Catch:{ LoadingException -> 0x009f }
            zzb = r6     // Catch:{ LoadingException -> 0x009f }
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c1 }
            return r5
        L_0x009c:
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            monitor-exit(r0)     // Catch:{ all -> 0x01c1 }
            return r5
        L_0x009f:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
            goto L_0x00b2
        L_0x00a9:
            java.lang.ClassLoader r5 = java.lang.ClassLoader.getSystemClassLoader()     // Catch:{ all -> 0x00b4 }
            r1.set(r2, r5)     // Catch:{ all -> 0x00b4 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x00b4 }
        L_0x00b2:
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            goto L_0x00d8
        L_0x00b4:
            r1 = move-exception
            monitor-exit(r4)     // Catch:{ all -> 0x00b4 }
            throw r1     // Catch:{ ClassNotFoundException -> 0x00bb, IllegalAccessException -> 0x00b9, NoSuchFieldException -> 0x00b7 }
        L_0x00b7:
            r1 = move-exception
            goto L_0x00bc
        L_0x00b9:
            r1 = move-exception
            goto L_0x00bc
        L_0x00bb:
            r1 = move-exception
        L_0x00bc:
            java.lang.String r4 = "DynamiteModule"
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x01c1 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c1 }
            r5.<init>()     // Catch:{ all -> 0x01c1 }
            java.lang.String r6 = "Failed to load module via V2: "
            r5.append(r6)     // Catch:{ all -> 0x01c1 }
            r5.append(r1)     // Catch:{ all -> 0x01c1 }
            java.lang.String r1 = r5.toString()     // Catch:{ all -> 0x01c1 }
            android.util.Log.w(r4, r1)     // Catch:{ all -> 0x01c1 }
            java.lang.Boolean r1 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x01c1 }
        L_0x00d8:
            zzb = r1     // Catch:{ all -> 0x01c1 }
        L_0x00da:
            monitor-exit(r0)     // Catch:{ all -> 0x01c1 }
            boolean r0 = r1.booleanValue()     // Catch:{ all -> 0x01c4 }
            if (r0 == 0) goto L_0x0102
            int r10 = zzb(r10, r11, r12, r3)     // Catch:{ LoadingException -> 0x00e6 }
            return r10
        L_0x00e6:
            r11 = move-exception
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r11 = r11.getMessage()     // Catch:{ all -> 0x01c4 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r0.<init>()     // Catch:{ all -> 0x01c4 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01c4 }
            r0.append(r11)     // Catch:{ all -> 0x01c4 }
            java.lang.String r11 = r0.toString()     // Catch:{ all -> 0x01c4 }
            android.util.Log.w(r12, r11)     // Catch:{ all -> 0x01c4 }
            return r3
        L_0x0102:
            com.google.android.gms.dynamite.zzq r4 = zzg(r10)     // Catch:{ all -> 0x01c4 }
            if (r4 != 0) goto L_0x010a
            goto L_0x01b8
        L_0x010a:
            int r0 = r4.zze()     // Catch:{ RemoteException -> 0x0197 }
            r1 = 3
            if (r0 < r1) goto L_0x0172
            java.lang.ThreadLocal r0 = zzg     // Catch:{ RemoteException -> 0x0197 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0197 }
            com.google.android.gms.dynamite.zzn r0 = (com.google.android.gms.dynamite.zzn) r0     // Catch:{ RemoteException -> 0x0197 }
            if (r0 == 0) goto L_0x0125
            android.database.Cursor r0 = r0.zza     // Catch:{ RemoteException -> 0x0197 }
            if (r0 == 0) goto L_0x0125
            int r3 = r0.getInt(r3)     // Catch:{ RemoteException -> 0x0197 }
            goto L_0x01b8
        L_0x0125:
            com.google.android.gms.dynamic.IObjectWrapper r5 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0197 }
            java.lang.ThreadLocal r0 = zzh     // Catch:{ RemoteException -> 0x0197 }
            java.lang.Object r0 = r0.get()     // Catch:{ RemoteException -> 0x0197 }
            java.lang.Long r0 = (java.lang.Long) r0     // Catch:{ RemoteException -> 0x0197 }
            long r8 = r0.longValue()     // Catch:{ RemoteException -> 0x0197 }
            r6 = r11
            r7 = r12
            com.google.android.gms.dynamic.IObjectWrapper r11 = r4.zzk(r5, r6, r7, r8)     // Catch:{ RemoteException -> 0x0197 }
            java.lang.Object r11 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r11)     // Catch:{ RemoteException -> 0x0197 }
            android.database.Cursor r11 = (android.database.Cursor) r11     // Catch:{ RemoteException -> 0x0197 }
            if (r11 == 0) goto L_0x015f
            boolean r12 = r11.moveToFirst()     // Catch:{ RemoteException -> 0x016f, all -> 0x016c }
            if (r12 != 0) goto L_0x014a
            goto L_0x015f
        L_0x014a:
            int r12 = r11.getInt(r3)     // Catch:{ RemoteException -> 0x016f, all -> 0x016c }
            if (r12 <= 0) goto L_0x0157
            boolean r0 = zze(r11)     // Catch:{ RemoteException -> 0x016f, all -> 0x016c }
            if (r0 == 0) goto L_0x0157
            goto L_0x0158
        L_0x0157:
            r2 = r11
        L_0x0158:
            if (r2 == 0) goto L_0x015d
            r2.close()     // Catch:{ all -> 0x01c4 }
        L_0x015d:
            r3 = r12
            goto L_0x01b8
        L_0x015f:
            java.lang.String r12 = "DynamiteModule"
            java.lang.String r0 = "Failed to retrieve remote module version."
            android.util.Log.w(r12, r0)     // Catch:{ RemoteException -> 0x016f, all -> 0x016c }
            if (r11 == 0) goto L_0x01b8
            r11.close()     // Catch:{ all -> 0x01c4 }
            goto L_0x01b8
        L_0x016c:
            r12 = move-exception
            r2 = r11
            goto L_0x01bb
        L_0x016f:
            r12 = move-exception
            r2 = r11
            goto L_0x0199
        L_0x0172:
            r1 = 2
            if (r0 != r1) goto L_0x0185
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version = 2, no high precision latency measurement."
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0197 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0197 }
            int r3 = r4.zzg(r0, r11, r12)     // Catch:{ RemoteException -> 0x0197 }
            goto L_0x01b8
        L_0x0185:
            java.lang.String r0 = "DynamiteModule"
            java.lang.String r1 = "IDynamite loader version < 2, falling back to getModuleVersion2"
            android.util.Log.w(r0, r1)     // Catch:{ RemoteException -> 0x0197 }
            com.google.android.gms.dynamic.IObjectWrapper r0 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r10)     // Catch:{ RemoteException -> 0x0197 }
            int r3 = r4.zzf(r0, r11, r12)     // Catch:{ RemoteException -> 0x0197 }
            goto L_0x01b8
        L_0x0195:
            r12 = r11
            goto L_0x01bb
        L_0x0197:
            r11 = move-exception
            r12 = r11
        L_0x0199:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b9 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b9 }
            r0.<init>()     // Catch:{ all -> 0x01b9 }
            java.lang.String r1 = "Failed to retrieve remote module version: "
            r0.append(r1)     // Catch:{ all -> 0x01b9 }
            r0.append(r12)     // Catch:{ all -> 0x01b9 }
            java.lang.String r12 = r0.toString()     // Catch:{ all -> 0x01b9 }
            android.util.Log.w(r11, r12)     // Catch:{ all -> 0x01b9 }
            if (r2 == 0) goto L_0x01b8
            r2.close()     // Catch:{ all -> 0x01c4 }
        L_0x01b8:
            return r3
        L_0x01b9:
            r11 = move-exception
            goto L_0x0195
        L_0x01bb:
            if (r2 == 0) goto L_0x01c0
            r2.close()     // Catch:{ all -> 0x01c4 }
        L_0x01c0:
            throw r12     // Catch:{ all -> 0x01c4 }
        L_0x01c1:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x01c1 }
            throw r11     // Catch:{ all -> 0x01c4 }
        L_0x01c4:
            r11 = move-exception
            com.google.android.gms.common.util.CrashUtils.addDynamiteErrorToDropBox(r10, r11)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zza(android.content.Context, java.lang.String, boolean):int");
    }

    /* JADX WARNING: Removed duplicated region for block: B:56:0x00bc A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x00bd A[Catch:{ all -> 0x00d8 }] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zzb(android.content.Context r10, java.lang.String r11, boolean r12, boolean r13) throws com.google.android.gms.dynamite.DynamiteModule.LoadingException {
        /*
            r0 = 0
            java.lang.ThreadLocal r1 = zzh     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.content.ContentResolver r3 = r10.getContentResolver()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r10 = "api_force_staging"
            java.lang.String r4 = "api"
            r9 = 1
            if (r9 == r12) goto L_0x0019
            r10 = r4
        L_0x0019:
            android.net.Uri$Builder r12 = new android.net.Uri$Builder     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r12.<init>()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "content"
            android.net.Uri$Builder r12 = r12.scheme(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r4 = "com.google.android.gms.chimera"
            android.net.Uri$Builder r12 = r12.authority(r4)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r12.path(r10)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendPath(r11)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            java.lang.String r11 = "requestStartTime"
            java.lang.String r12 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri$Builder r10 = r10.appendQueryParameter(r11, r12)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            android.net.Uri r4 = r10.build()     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x00b5, all -> 0x00b2 }
            if (r10 == 0) goto L_0x00a3
            boolean r11 = r10.moveToFirst()     // Catch:{ Exception -> 0x009b }
            if (r11 == 0) goto L_0x00a3
            r11 = 0
            int r12 = r10.getInt(r11)     // Catch:{ Exception -> 0x009b }
            if (r12 <= 0) goto L_0x008e
            java.lang.Class<com.google.android.gms.dynamite.DynamiteModule> r1 = com.google.android.gms.dynamite.DynamiteModule.class
            monitor-enter(r1)     // Catch:{ Exception -> 0x009b }
            r2 = 2
            java.lang.String r2 = r10.getString(r2)     // Catch:{ all -> 0x008b }
            zzc = r2     // Catch:{ all -> 0x008b }
            java.lang.String r2 = "loaderVersion"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x006f
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            zze = r2     // Catch:{ all -> 0x008b }
        L_0x006f:
            java.lang.String r2 = "disableStandaloneDynamiteLoader2"
            int r2 = r10.getColumnIndex(r2)     // Catch:{ all -> 0x008b }
            if (r2 < 0) goto L_0x0082
            int r2 = r10.getInt(r2)     // Catch:{ all -> 0x008b }
            if (r2 == 0) goto L_0x007e
            goto L_0x007f
        L_0x007e:
            r9 = r11
        L_0x007f:
            zzd = r9     // Catch:{ all -> 0x008b }
            r11 = r9
        L_0x0082:
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            boolean r1 = zze(r10)     // Catch:{ Exception -> 0x009b }
            if (r1 == 0) goto L_0x008e
            r10 = r0
            goto L_0x008e
        L_0x008b:
            r11 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x008b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x008e:
            if (r13 == 0) goto L_0x009d
            if (r11 != 0) goto L_0x0093
            goto L_0x009d
        L_0x0093:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "forcing fallback to container DynamiteLoader impl"
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x009b:
            r11 = move-exception
            goto L_0x00b8
        L_0x009d:
            if (r10 == 0) goto L_0x00a2
            r10.close()
        L_0x00a2:
            return r12
        L_0x00a3:
            java.lang.String r11 = "DynamiteModule"
            java.lang.String r12 = "Failed to retrieve remote module version."
            android.util.Log.w(r11, r12)     // Catch:{ Exception -> 0x009b }
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r11 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ Exception -> 0x009b }
            java.lang.String r12 = "Failed to connect to dynamite module ContentResolver."
            r11.<init>(r12, r0)     // Catch:{ Exception -> 0x009b }
            throw r11     // Catch:{ Exception -> 0x009b }
        L_0x00b2:
            r10 = move-exception
            r11 = r10
            goto L_0x00da
        L_0x00b5:
            r10 = move-exception
            r11 = r10
            r10 = r0
        L_0x00b8:
            boolean r12 = r11 instanceof com.google.android.gms.dynamite.DynamiteModule.LoadingException     // Catch:{ all -> 0x00d8 }
            if (r12 == 0) goto L_0x00bd
            throw r11     // Catch:{ all -> 0x00d8 }
        L_0x00bd:
            com.google.android.gms.dynamite.DynamiteModule$LoadingException r12 = new com.google.android.gms.dynamite.DynamiteModule$LoadingException     // Catch:{ all -> 0x00d8 }
            java.lang.String r13 = r11.getMessage()     // Catch:{ all -> 0x00d8 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00d8 }
            r1.<init>()     // Catch:{ all -> 0x00d8 }
            java.lang.String r2 = "V2 version check failed: "
            r1.append(r2)     // Catch:{ all -> 0x00d8 }
            r1.append(r13)     // Catch:{ all -> 0x00d8 }
            java.lang.String r13 = r1.toString()     // Catch:{ all -> 0x00d8 }
            r12.<init>(r13, r11, r0)     // Catch:{ all -> 0x00d8 }
            throw r12     // Catch:{ all -> 0x00d8 }
        L_0x00d8:
            r11 = move-exception
            r0 = r10
        L_0x00da:
            if (r0 == 0) goto L_0x00df
            r0.close()
        L_0x00df:
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.dynamite.DynamiteModule.zzb(android.content.Context, java.lang.String, boolean, boolean):int");
    }

    private static DynamiteModule zzc(Context context, String str) {
        Log.i("DynamiteModule", "Selected local version of ".concat(String.valueOf(str)));
        return new DynamiteModule(context);
    }

    private static void zzd(ClassLoader classLoader) throws LoadingException {
        zzr zzr;
        try {
            IBinder iBinder = (IBinder) classLoader.loadClass("com.google.android.gms.dynamiteloader.DynamiteLoaderV2").getConstructor(new Class[0]).newInstance(new Object[0]);
            if (iBinder == null) {
                zzr = null;
            } else {
                IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoaderV2");
                if (queryLocalInterface instanceof zzr) {
                    zzr = (zzr) queryLocalInterface;
                } else {
                    zzr = new zzr(iBinder);
                }
            }
            zzl = zzr;
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            throw new LoadingException("Failed to instantiate dynamite loader", e, (zzp) null);
        }
    }

    private static boolean zze(Cursor cursor) {
        zzn zzn = (zzn) zzg.get();
        if (zzn == null || zzn.zza != null) {
            return false;
        }
        zzn.zza = cursor;
        return true;
    }

    private static boolean zzf(Context context) {
        if (Boolean.TRUE.equals((Object) null) || Boolean.TRUE.equals(zzf)) {
            return true;
        }
        boolean z = false;
        if (zzf == null) {
            ProviderInfo resolveContentProvider = context.getPackageManager().resolveContentProvider("com.google.android.gms.chimera", 0);
            if (GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(context, 10000000) == 0 && resolveContentProvider != null && "com.google.android.gms".equals(resolveContentProvider.packageName)) {
                z = true;
            }
            Boolean valueOf = Boolean.valueOf(z);
            zzf = valueOf;
            z = valueOf.booleanValue();
            if (z && resolveContentProvider.applicationInfo != null && (resolveContentProvider.applicationInfo.flags & TsExtractor.TS_STREAM_TYPE_AC3) == 0) {
                Log.i("DynamiteModule", "Non-system-image GmsCore APK, forcing V1");
                zzd = true;
            }
        }
        if (!z) {
            Log.e("DynamiteModule", "Invalid GmsCore APK, remote loading disabled.");
        }
        return z;
    }

    private static zzq zzg(Context context) {
        zzq zzq;
        synchronized (DynamiteModule.class) {
            zzq zzq2 = zzk;
            if (zzq2 != null) {
                return zzq2;
            }
            try {
                IBinder iBinder = (IBinder) context.createPackageContext("com.google.android.gms", 3).getClassLoader().loadClass("com.google.android.gms.chimera.container.DynamiteLoaderImpl").newInstance();
                if (iBinder == null) {
                    zzq = null;
                } else {
                    IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.dynamite.IDynamiteLoader");
                    zzq = queryLocalInterface instanceof zzq ? (zzq) queryLocalInterface : new zzq(iBinder);
                }
                if (zzq != null) {
                    zzk = zzq;
                    return zzq;
                }
            } catch (Exception e) {
                Log.e("DynamiteModule", "Failed to load IDynamiteLoader from GmsCore: " + e.getMessage());
            }
        }
        return null;
    }

    @ResultIgnorabilityUnspecified
    public Context getModuleContext() {
        return this.zzj;
    }

    public IBinder instantiate(String str) throws LoadingException {
        try {
            return (IBinder) this.zzj.getClassLoader().loadClass(str).newInstance();
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new LoadingException("Failed to instantiate module class: ".concat(String.valueOf(str)), e, (zzp) null);
        }
    }
}
