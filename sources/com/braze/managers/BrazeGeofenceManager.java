package com.braze.managers;

import android.app.PendingIntent;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import bo.app.i2;
import bo.app.i3;
import bo.app.j;
import bo.app.l5;
import bo.app.x1;
import bo.app.z1;
import com.braze.configuration.BrazeConfigurationProvider;
import com.braze.enums.GeofenceTransitionType;
import com.braze.models.BrazeGeofence;
import com.braze.models.IBrazeLocation;
import com.braze.support.BrazeLogger;
import com.braze.support.DateTimeUtils;
import com.braze.support.PermissionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000®\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 v2\u00020\u00012\u00020\u0002:\u0001vB7\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010q\u001a\u00020\u000e\u0012\u0006\u0010&\u001a\u00020%\u0012\u0006\u0010+\u001a\u00020*\u0012\u0006\u0010.\u001a\u00020-\u0012\u0006\u0010s\u001a\u00020r¢\u0006\u0004\bt\u0010uJ\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\n\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0007H\u0007J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0007J\u0018\u0010\u0012\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0011\u001a\u00020\u0010H\u0007J\u0012\u0010\u0014\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000f\u001a\u00020\u000eH\u0007J\u0018\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0010H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0017H\u0016J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u001a\u001a\u00020\u0007H\u0016J\u0010\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\u0016\u0010 \u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u001eH\u0016J\b\u0010!\u001a\u00020\u0003H\u0016J\u0012\u0010\"\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010#\u001a\u00020\u0003H\u0007J\u001e\u0010$\u001a\u00020\u00032\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00130\u001e2\u0006\u0010\f\u001a\u00020\u000bH\u0007R\u0017\u0010&\u001a\u00020%8\u0006¢\u0006\f\n\u0004\b&\u0010'\u001a\u0004\b(\u0010)R\u0014\u0010+\u001a\u00020*8\u0002X\u0004¢\u0006\u0006\n\u0004\b+\u0010,R\u0014\u0010.\u001a\u00020-8\u0002X\u0004¢\u0006\u0006\n\u0004\b.\u0010/R \u00101\u001a\u0002008\u0006X\u0004¢\u0006\u0012\n\u0004\b1\u00102\u0012\u0004\b5\u00106\u001a\u0004\b3\u00104R \u00108\u001a\u0002078\u0006X\u0004¢\u0006\u0012\n\u0004\b8\u00109\u0012\u0004\b<\u00106\u001a\u0004\b:\u0010;R\u001c\u0010>\u001a\n =*\u0004\u0018\u00010\u00050\u00058\u0002X\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\u0014\u0010A\u001a\u00020@8\u0002X\u0004¢\u0006\u0006\n\u0004\bA\u0010BR \u0010D\u001a\u00020C8\u0006X\u0004¢\u0006\u0012\n\u0004\bD\u0010E\u0012\u0004\bH\u00106\u001a\u0004\bF\u0010GR&\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130I8\u0006X\u0004¢\u0006\u0012\n\u0004\bJ\u0010K\u0012\u0004\bN\u00106\u001a\u0004\bL\u0010MR\"\u0010O\u001a\u0004\u0018\u00010\u000b8\u0006X\u0004¢\u0006\u0012\n\u0004\bO\u0010P\u0012\u0004\bS\u00106\u001a\u0004\bQ\u0010RR(\u0010U\u001a\u00020T8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bU\u0010V\u0012\u0004\b[\u00106\u001a\u0004\bW\u0010X\"\u0004\bY\u0010ZR*\u0010\\\u001a\u0004\u0018\u00010\u00178\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\b\\\u0010]\u0012\u0004\bb\u00106\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR(\u0010c\u001a\u00020\u00078\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bc\u0010d\u0012\u0004\bh\u00106\u001a\u0004\bc\u0010e\"\u0004\bf\u0010gR(\u0010j\u001a\u00020i8\u0006@\u0006X\u000e¢\u0006\u0018\n\u0004\bj\u0010k\u0012\u0004\bp\u00106\u001a\u0004\bl\u0010m\"\u0004\bn\u0010o¨\u0006w"}, d2 = {"Lcom/braze/managers/BrazeGeofenceManager;", "", "Lcom/braze/managers/IBrazeGeofenceLocationUpdateListener;", "", "initializeGeofences", "Landroid/content/Context;", "context", "", "isGeofencesEnabledFromEnvironment", "reRegisterGeofences", "setUpGeofences", "Landroid/app/PendingIntent;", "geofenceRequestIntent", "tearDownGeofences", "", "geofenceId", "Lcom/braze/enums/GeofenceTransitionType;", "geofenceTransitionType", "analyticsEnabledForGeofenceId", "Lcom/braze/models/BrazeGeofence;", "getBrazeGeofenceForGeofenceId", "transitionType", "postGeofenceReport", "Lcom/braze/models/IBrazeLocation;", "location", "requestGeofenceRefresh", "ignoreRateLimit", "Lbo/app/j5;", "serverConfig", "configureFromServerConfig", "", "geofenceList", "registerGeofences", "unregisterGeofences", "onLocationRequestComplete", "requestSingleLocationUpdateFromGooglePlay", "registerGeofencesWithGooglePlay", "Lbo/app/z1;", "brazeManager", "Lbo/app/z1;", "getBrazeManager", "()Lbo/app/z1;", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "Lcom/braze/configuration/BrazeConfigurationProvider;", "Lbo/app/l5;", "serverConfigStorageProvider", "Lbo/app/l5;", "Lbo/app/l;", "brazeGeofenceApi", "Lbo/app/l;", "getBrazeGeofenceApi", "()Lbo/app/l;", "getBrazeGeofenceApi$annotations", "()V", "Lbo/app/n;", "brazeLocationApi", "Lbo/app/n;", "getBrazeLocationApi", "()Lbo/app/n;", "getBrazeLocationApi$annotations", "kotlin.jvm.PlatformType", "applicationContext", "Landroid/content/Context;", "Ljava/util/concurrent/locks/ReentrantLock;", "geofenceListLock", "Ljava/util/concurrent/locks/ReentrantLock;", "Landroid/content/SharedPreferences;", "geofenceStorageSharedPreferences", "Landroid/content/SharedPreferences;", "getGeofenceStorageSharedPreferences", "()Landroid/content/SharedPreferences;", "getGeofenceStorageSharedPreferences$annotations", "", "brazeGeofences", "Ljava/util/List;", "getBrazeGeofences", "()Ljava/util/List;", "getBrazeGeofences$annotations", "geofenceTransitionPendingIntent", "Landroid/app/PendingIntent;", "getGeofenceTransitionPendingIntent", "()Landroid/app/PendingIntent;", "getGeofenceTransitionPendingIntent$annotations", "Lbo/app/m;", "brazeGeofenceReEligibilityManager", "Lbo/app/m;", "getBrazeGeofenceReEligibilityManager", "()Lbo/app/m;", "setBrazeGeofenceReEligibilityManager", "(Lbo/app/m;)V", "getBrazeGeofenceReEligibilityManager$annotations", "geofenceRequestLocation", "Lcom/braze/models/IBrazeLocation;", "getGeofenceRequestLocation", "()Lcom/braze/models/IBrazeLocation;", "setGeofenceRequestLocation", "(Lcom/braze/models/IBrazeLocation;)V", "getGeofenceRequestLocation$annotations", "isGeofencesEnabled", "Z", "()Z", "setGeofencesEnabled", "(Z)V", "isGeofencesEnabled$annotations", "", "maxNumToRegister", "I", "getMaxNumToRegister", "()I", "setMaxNumToRegister", "(I)V", "getMaxNumToRegister$annotations", "apiKey", "Lbo/app/i2;", "internalIEventMessenger", "<init>", "(Landroid/content/Context;Ljava/lang/String;Lbo/app/z1;Lcom/braze/configuration/BrazeConfigurationProvider;Lbo/app/l5;Lbo/app/i2;)V", "Companion", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
public final class BrazeGeofenceManager implements IBrazeGeofenceLocationUpdateListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String GEOFENCE_STORAGE_SHARED_PREFS_LOCATION = "com.appboy.managers.geofences.storage";
    private final Context applicationContext;
    private final bo.app.l brazeGeofenceApi;
    private bo.app.m brazeGeofenceReEligibilityManager;
    private final List<BrazeGeofence> brazeGeofences;
    private final bo.app.n brazeLocationApi;
    private final z1 brazeManager;
    private final BrazeConfigurationProvider configurationProvider;
    private final ReentrantLock geofenceListLock = new ReentrantLock();
    private IBrazeLocation geofenceRequestLocation;
    private final SharedPreferences geofenceStorageSharedPreferences;
    private final PendingIntent geofenceTransitionPendingIntent;
    private boolean isGeofencesEnabled;
    private int maxNumToRegister;
    private final l5 serverConfigStorageProvider;

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0007J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0007J\u0010\u0010\u000b\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\tH\u0007J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0007J\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\u00102\u0006\u0010\u000f\u001a\u00020\u000eH\u0007R\u0014\u0010\u0013\u001a\u00020\u00028\u0002XT¢\u0006\u0006\n\u0004\b\u0013\u0010\u0014¨\u0006\u0017"}, d2 = {"Lcom/braze/managers/BrazeGeofenceManager$Companion;", "", "", "apiKey", "getGeofenceSharedPreferencesName", "Lcom/braze/configuration/BrazeConfigurationProvider;", "configurationProvider", "", "getGeofencesEnabledFromConfiguration", "Lbo/app/l5;", "serverConfigStorageProvider", "getGeofencesEnabledFromServerConfig", "", "getMaxNumToRegister", "Landroid/content/SharedPreferences;", "sharedPreferences", "", "Lcom/braze/models/BrazeGeofence;", "retrieveBrazeGeofencesFromLocalStorage", "GEOFENCE_STORAGE_SHARED_PREFS_LOCATION", "Ljava/lang/String;", "<init>", "()V", "android-sdk-base_release"}, k = 1, mv = {1, 8, 0})
    public static final class Companion {

        static final class a extends Lambda implements Function0 {
            public static final a b = new a();

            a() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Geofences enabled in server configuration.";
            }
        }

        static final class b extends Lambda implements Function0 {
            public static final b b = new b();

            b() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Geofences explicitly disabled via server configuration.";
            }
        }

        static final class c extends Lambda implements Function0 {
            public static final c b = new c();

            c() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Geofences implicitly disabled via server configuration.";
            }
        }

        static final class d extends Lambda implements Function0 {
            public static final d b = new d();

            d() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Did not find stored geofences.";
            }
        }

        static final class e extends Lambda implements Function0 {
            public static final e b = new e();

            e() {
                super(0);
            }

            /* renamed from: a */
            public final String invoke() {
                return "Failed to find stored geofence keys.";
            }
        }

        static final class f extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            f(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Received null or blank serialized geofence string for geofence id " + this.b + " from shared preferences. Not parsing.";
            }
        }

        static final class g extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            g(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Encountered Json exception while parsing stored geofence: " + this.b;
            }
        }

        static final class h extends Lambda implements Function0 {
            final /* synthetic */ String b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            h(String str) {
                super(0);
                this.b = str;
            }

            /* renamed from: a */
            public final String invoke() {
                return "Encountered unexpected exception while parsing stored geofence: " + this.b;
            }
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final String getGeofenceSharedPreferencesName(String str) {
            Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
            return "com.appboy.managers.geofences.storage." + str;
        }

        @JvmStatic
        public final boolean getGeofencesEnabledFromConfiguration(BrazeConfigurationProvider brazeConfigurationProvider) {
            Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
            return brazeConfigurationProvider.isGeofencesEnabled();
        }

        @JvmStatic
        public final boolean getGeofencesEnabledFromServerConfig(l5 l5Var) {
            Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
            if (!l5Var.C()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) c.b, 2, (Object) null);
                return false;
            } else if (l5Var.B()) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) a.b, 2, (Object) null);
                return true;
            } else {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) b.b, 2, (Object) null);
                return false;
            }
        }

        @JvmStatic
        public final int getMaxNumToRegister(l5 l5Var) {
            Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
            if (l5Var.p() > 0) {
                return l5Var.p();
            }
            return 20;
        }

        /* JADX WARNING: Removed duplicated region for block: B:29:0x006a A[Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }] */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x007b A[Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }] */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.util.List<com.braze.models.BrazeGeofence> retrieveBrazeGeofencesFromLocalStorage(android.content.SharedPreferences r15) {
            /*
                r14 = this;
                java.lang.String r0 = "sharedPreferences"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r15, r0)
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Map r1 = r15.getAll()
                r2 = 0
                r3 = 1
                if (r1 == 0) goto L_0x001b
                boolean r4 = r1.isEmpty()
                if (r4 == 0) goto L_0x0019
                goto L_0x001b
            L_0x0019:
                r4 = r2
                goto L_0x001c
            L_0x001b:
                r4 = r3
            L_0x001c:
                if (r4 == 0) goto L_0x002b
                com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.managers.BrazeGeofenceManager$Companion$d r9 = com.braze.managers.BrazeGeofenceManager.Companion.d.b
                r7 = 0
                r8 = 0
                r10 = 3
                r11 = 0
                r6 = r14
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                return r0
            L_0x002b:
                java.util.Set r1 = r1.keySet()
                boolean r4 = r1.isEmpty()
                if (r4 == 0) goto L_0x0043
                com.braze.support.BrazeLogger r5 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.W
                com.braze.managers.BrazeGeofenceManager$Companion$e r9 = com.braze.managers.BrazeGeofenceManager.Companion.e.b
                r8 = 0
                r10 = 2
                r11 = 0
                r6 = r14
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r5, (java.lang.Object) r6, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r8, (kotlin.jvm.functions.Function0) r9, (int) r10, (java.lang.Object) r11)
                return r0
            L_0x0043:
                java.util.Iterator r1 = r1.iterator()
            L_0x0047:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L_0x00a3
                java.lang.Object r4 = r1.next()
                java.lang.String r4 = (java.lang.String) r4
                r5 = 0
                java.lang.String r5 = r15.getString(r4, r5)
                if (r5 == 0) goto L_0x0067
                boolean r6 = kotlin.text.StringsKt.isBlank(r5)     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                if (r6 == 0) goto L_0x0061
                goto L_0x0067
            L_0x0061:
                r6 = r2
                goto L_0x0068
            L_0x0063:
                r4 = move-exception
                goto L_0x0089
            L_0x0065:
                r4 = move-exception
                goto L_0x0096
            L_0x0067:
                r6 = r3
            L_0x0068:
                if (r6 == 0) goto L_0x007b
                com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                com.braze.support.BrazeLogger$Priority r9 = com.braze.support.BrazeLogger.Priority.W     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                r10 = 0
                com.braze.managers.BrazeGeofenceManager$Companion$f r11 = new com.braze.managers.BrazeGeofenceManager$Companion$f     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                r11.<init>(r4)     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                r12 = 2
                r13 = 0
                r8 = r14
                com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r7, (java.lang.Object) r8, (com.braze.support.BrazeLogger.Priority) r9, (java.lang.Throwable) r10, (kotlin.jvm.functions.Function0) r11, (int) r12, (java.lang.Object) r13)     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                goto L_0x0047
            L_0x007b:
                org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                r4.<init>((java.lang.String) r5)     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                com.braze.models.BrazeGeofence r6 = new com.braze.models.BrazeGeofence     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                r6.<init>(r4)     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                r0.add(r6)     // Catch:{ JSONException -> 0x0065, Exception -> 0x0063 }
                goto L_0x0047
            L_0x0089:
                com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.E
                com.braze.managers.BrazeGeofenceManager$Companion$h r8 = new com.braze.managers.BrazeGeofenceManager$Companion$h
                r8.<init>(r5)
                r6.brazelog((java.lang.Object) r14, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0<java.lang.String>) r8)
                goto L_0x0047
            L_0x0096:
                com.braze.support.BrazeLogger r6 = com.braze.support.BrazeLogger.INSTANCE
                com.braze.support.BrazeLogger$Priority r7 = com.braze.support.BrazeLogger.Priority.E
                com.braze.managers.BrazeGeofenceManager$Companion$g r8 = new com.braze.managers.BrazeGeofenceManager$Companion$g
                r8.<init>(r5)
                r6.brazelog((java.lang.Object) r14, (com.braze.support.BrazeLogger.Priority) r7, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0<java.lang.String>) r8)
                goto L_0x0047
            L_0x00a3:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.braze.managers.BrazeGeofenceManager.Companion.retrieveBrazeGeofencesFromLocalStorage(android.content.SharedPreferences):java.util.List");
        }

        private Companion() {
        }
    }

    static final class a extends Lambda implements Function0 {
        public static final a b = new a();

        a() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "***Geofence API not found. Please include the android-sdk-location module***";
        }
    }

    static final class a0 extends Lambda implements Function0 {
        public static final a0 b = new a0();

        a0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Geofences not set up.";
        }
    }

    static final class b extends Lambda implements Function0 {
        final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(boolean z) {
            super(0);
            this.b = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences enabled server config value " + this.b + " received.";
        }
    }

    static final class b0 extends Lambda implements Function0 {
        public static final b0 b = new b0();

        b0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Could not get pending intent to setup geofences";
        }
    }

    static final class c extends Lambda implements Function0 {
        final /* synthetic */ BrazeGeofenceManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(BrazeGeofenceManager brazeGeofenceManager) {
            super(0);
            this.b = brazeGeofenceManager;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences enabled status newly set to " + this.b.isGeofencesEnabled() + " during server config update.";
        }
    }

    static final class c0 extends Lambda implements Function0 {
        public static final c0 b = new c0();

        c0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Tearing down geofences.";
        }
    }

    static final class d extends Lambda implements Function0 {
        final /* synthetic */ boolean b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(boolean z) {
            super(0);
            this.b = z;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Geofences enabled status of `" + this.b + "` was unchanged during server config update.";
        }
    }

    static final class d0 extends Lambda implements Function0 {
        public static final d0 b = new d0();

        d0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Unregistering any Braze geofences from Google Play Services.";
        }
    }

    static final class e extends Lambda implements Function0 {
        final /* synthetic */ BrazeGeofenceManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(BrazeGeofenceManager brazeGeofenceManager) {
            super(0);
            this.b = brazeGeofenceManager;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Max number to register newly set to " + this.b.getMaxNumToRegister() + " via server config.";
        }
    }

    static final class e0 extends Lambda implements Function0 {
        public static final e0 b = new e0();

        e0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Deleting locally stored geofences.";
        }
    }

    static final class f extends Lambda implements Function0 {
        public static final f b = new f();

        f() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Request to set up geofences received.";
        }
    }

    static final class f0 extends Lambda implements Function0 {
        public static final f0 b = new f0();

        f0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not un-registering geofences.";
        }
    }

    static final class g extends Lambda implements Function0 {
        public static final g b = new g();

        g() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Not automatically requesting Geofences on initialization due to configuration.";
        }
    }

    static final class g0 extends Lambda implements Function0 {
        public static final g0 b = new g0();

        g0() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Tearing down all geofences.";
        }
    }

    static final class h extends Lambda implements Function0 {
        public static final h b = new h();

        h() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze Geofences disabled or Braze location collection disabled in local configuration. Geofences not enabled.";
        }
    }

    static final class i extends Lambda implements Function0 {
        public static final i b = new i();

        i() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Fine grained location permissions not found. Geofences not enabled.";
        }
    }

    static final class j extends Lambda implements Function0 {
        public static final j b = new j();

        j() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Background location access permission not found. Geofences not enabled.";
        }
    }

    static final class k extends Lambda implements Function0 {
        public static final k b = new k();

        k() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services not available. Geofences not enabled.";
        }
    }

    static final class l extends Lambda implements Function0 {
        public static final l b = new l();

        l() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze Geofence API is not available";
        }
    }

    static final class m extends Lambda implements Function0 {
        public static final m b = new m();

        m() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Google Play Services Location API not found. Geofences not enabled.";
        }
    }

    static final class n extends Lambda implements Function0 {
        public static final n b = new n();

        n() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Location permissions granted and Google Play Services available. Braze Geofencing enabled via config.";
        }
    }

    static final class o extends Lambda implements Function0 {
        final /* synthetic */ IBrazeLocation b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(IBrazeLocation iBrazeLocation) {
            super(0);
            this.b = iBrazeLocation;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Single location request was successful, requesting Geofence refresh. Location:\n " + this.b;
        }
    }

    static final class p extends Lambda implements Function0 {
        public static final p b = new p();

        p() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Single location request was unsuccessful, not storing last updated time.";
        }
    }

    static final class q extends Lambda implements Function0 {
        public static final q b = new q();

        q() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not posting geofence report.";
        }
    }

    static final class r extends Lambda implements Function0 {
        final /* synthetic */ String b;
        final /* synthetic */ GeofenceTransitionType c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        r(String str, GeofenceTransitionType geofenceTransitionType) {
            super(0);
            this.b = str;
            this.c = geofenceTransitionType;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Failed to record geofence " + this.b + " transition with transition type " + this.c + '.';
        }
    }

    static final class s extends Lambda implements Function0 {
        public static final s b = new s();

        s() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not adding new geofences to local storage.";
        }
    }

    static final class t extends Lambda implements Function0 {
        final /* synthetic */ List b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        t(List list) {
            super(0);
            this.b = list;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Received new geofence list of size: " + this.b.size();
        }
    }

    static final class u extends Lambda implements Function0 {
        final /* synthetic */ BrazeGeofenceManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(BrazeGeofenceManager brazeGeofenceManager) {
            super(0);
            this.b = brazeGeofenceManager;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Reached maximum number of new geofences: " + this.b.getMaxNumToRegister();
        }
    }

    static final class v extends Lambda implements Function0 {
        final /* synthetic */ BrazeGeofence b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        v(BrazeGeofence brazeGeofence) {
            super(0);
            this.b = brazeGeofence;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Adding new geofence to local storage: " + this.b;
        }
    }

    static final class w extends Lambda implements Function0 {
        final /* synthetic */ BrazeGeofenceManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(BrazeGeofenceManager brazeGeofenceManager) {
            super(0);
            this.b = brazeGeofenceManager;
        }

        /* renamed from: a */
        public final String invoke() {
            return "Added " + this.b.getBrazeGeofences().size() + " new geofences to local storage.";
        }
    }

    static final class x extends Lambda implements Function0 {
        public static final x b = new x();

        x() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not requesting geofences.";
        }
    }

    static final class y extends Lambda implements Function0 {
        public static final y b = new y();

        y() {
            super(0);
        }

        /* renamed from: a */
        public final String invoke() {
            return "Braze geofences not enabled. Not requesting geofences.";
        }
    }

    static final class z extends Lambda implements Function1 {
        final /* synthetic */ BrazeGeofenceManager b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        z(BrazeGeofenceManager brazeGeofenceManager) {
            super(1);
            this.b = brazeGeofenceManager;
        }

        public final void a(IBrazeLocation iBrazeLocation) {
            Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
            this.b.onLocationRequestComplete(iBrazeLocation);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((IBrazeLocation) obj);
            return Unit.INSTANCE;
        }
    }

    public BrazeGeofenceManager(Context context, String str, z1 z1Var, BrazeConfigurationProvider brazeConfigurationProvider, l5 l5Var, i2 i2Var) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(str, DynamicLink.Builder.KEY_API_KEY);
        Intrinsics.checkNotNullParameter(z1Var, "brazeManager");
        Intrinsics.checkNotNullParameter(brazeConfigurationProvider, "configurationProvider");
        Intrinsics.checkNotNullParameter(l5Var, "serverConfigStorageProvider");
        Intrinsics.checkNotNullParameter(i2Var, "internalIEventMessenger");
        this.brazeManager = z1Var;
        this.configurationProvider = brazeConfigurationProvider;
        this.serverConfigStorageProvider = l5Var;
        bo.app.l lVar = new bo.app.l();
        this.brazeGeofenceApi = lVar;
        this.brazeLocationApi = new bo.app.n(context, a.d.a(brazeConfigurationProvider), brazeConfigurationProvider);
        this.applicationContext = context.getApplicationContext();
        Companion companion = Companion;
        boolean z2 = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(companion.getGeofenceSharedPreferencesName(str), 0);
        Intrinsics.checkNotNullExpressionValue(sharedPreferences, "context.getSharedPrefere…ontext.MODE_PRIVATE\n    )");
        this.geofenceStorageSharedPreferences = sharedPreferences;
        this.brazeGeofences = CollectionsKt.toMutableList(companion.retrieveBrazeGeofencesFromLocalStorage(sharedPreferences));
        this.geofenceTransitionPendingIntent = lVar.b(context);
        this.brazeGeofenceReEligibilityManager = new bo.app.m(context, str, l5Var, i2Var);
        if (companion.getGeofencesEnabledFromServerConfig(l5Var) && isGeofencesEnabledFromEnvironment(context) && lVar.a()) {
            z2 = true;
        }
        this.isGeofencesEnabled = z2;
        this.maxNumToRegister = companion.getMaxNumToRegister(l5Var);
        if (!lVar.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) a.b, 2, (Object) null);
        }
        setUpGeofences(true);
    }

    public static /* synthetic */ void getBrazeGeofenceApi$annotations() {
    }

    public static /* synthetic */ void getBrazeGeofenceReEligibilityManager$annotations() {
    }

    public static /* synthetic */ void getBrazeGeofences$annotations() {
    }

    public static /* synthetic */ void getBrazeLocationApi$annotations() {
    }

    public static /* synthetic */ void getGeofenceRequestLocation$annotations() {
    }

    @JvmStatic
    public static final String getGeofenceSharedPreferencesName(String str) {
        return Companion.getGeofenceSharedPreferencesName(str);
    }

    public static /* synthetic */ void getGeofenceStorageSharedPreferences$annotations() {
    }

    public static /* synthetic */ void getGeofenceTransitionPendingIntent$annotations() {
    }

    @JvmStatic
    public static final boolean getGeofencesEnabledFromConfiguration(BrazeConfigurationProvider brazeConfigurationProvider) {
        return Companion.getGeofencesEnabledFromConfiguration(brazeConfigurationProvider);
    }

    @JvmStatic
    public static final boolean getGeofencesEnabledFromServerConfig(l5 l5Var) {
        return Companion.getGeofencesEnabledFromServerConfig(l5Var);
    }

    @JvmStatic
    public static final int getMaxNumToRegister(l5 l5Var) {
        return Companion.getMaxNumToRegister(l5Var);
    }

    public static /* synthetic */ void getMaxNumToRegister$annotations() {
    }

    public static /* synthetic */ void isGeofencesEnabled$annotations() {
    }

    @JvmStatic
    public static final List<BrazeGeofence> retrieveBrazeGeofencesFromLocalStorage(SharedPreferences sharedPreferences) {
        return Companion.retrieveBrazeGeofencesFromLocalStorage(sharedPreferences);
    }

    public final boolean analyticsEnabledForGeofenceId(String str, GeofenceTransitionType geofenceTransitionType) {
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        Intrinsics.checkNotNullParameter(geofenceTransitionType, "geofenceTransitionType");
        ReentrantLock reentrantLock = this.geofenceListLock;
        reentrantLock.lock();
        try {
            BrazeGeofence brazeGeofenceForGeofenceId = getBrazeGeofenceForGeofenceId(str);
            if (brazeGeofenceForGeofenceId != null) {
                if (geofenceTransitionType == GeofenceTransitionType.ENTER) {
                    return brazeGeofenceForGeofenceId.getAnalyticsEnabledEnter();
                }
                if (geofenceTransitionType == GeofenceTransitionType.EXIT) {
                    boolean analyticsEnabledExit = brazeGeofenceForGeofenceId.getAnalyticsEnabledExit();
                    reentrantLock.unlock();
                    return analyticsEnabledExit;
                }
            }
            reentrantLock.unlock();
            return false;
        } finally {
            reentrantLock.unlock();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x0039  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0077  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void configureFromServerConfig(bo.app.j5 r12) {
        /*
            r11 = this;
            java.lang.String r0 = "serverConfig"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r12, r0)
            boolean r0 = r12.n()
            com.braze.support.BrazeLogger r8 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.managers.BrazeGeofenceManager$b r5 = new com.braze.managers.BrazeGeofenceManager$b
            r5.<init>(r0)
            r3 = 0
            r4 = 0
            r6 = 3
            r7 = 0
            r1 = r8
            r2 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            r9 = 1
            r10 = 0
            if (r0 == 0) goto L_0x0034
            android.content.Context r0 = r11.applicationContext
            java.lang.String r1 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            boolean r0 = r11.isGeofencesEnabledFromEnvironment(r0)
            if (r0 == 0) goto L_0x0034
            bo.app.l r0 = r11.brazeGeofenceApi
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x0034
            r0 = r9
            goto L_0x0035
        L_0x0034:
            r0 = r10
        L_0x0035:
            boolean r1 = r11.isGeofencesEnabled
            if (r0 == r1) goto L_0x0063
            r11.isGeofencesEnabled = r0
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I
            com.braze.managers.BrazeGeofenceManager$c r5 = new com.braze.managers.BrazeGeofenceManager$c
            r5.<init>(r11)
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r8
            r2 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
            boolean r0 = r11.isGeofencesEnabled
            if (r0 == 0) goto L_0x005d
            r11.setUpGeofences(r10)
            com.braze.configuration.BrazeConfigurationProvider r0 = r11.configurationProvider
            boolean r0 = r0.isAutomaticGeofenceRequestsEnabled()
            if (r0 == 0) goto L_0x0071
            r11.requestGeofenceRefresh((boolean) r9)
            goto L_0x0071
        L_0x005d:
            android.app.PendingIntent r0 = r11.geofenceTransitionPendingIntent
            r11.tearDownGeofences(r0)
            goto L_0x0071
        L_0x0063:
            com.braze.managers.BrazeGeofenceManager$d r5 = new com.braze.managers.BrazeGeofenceManager$d
            r5.<init>(r0)
            r3 = 0
            r4 = 0
            r6 = 3
            r7 = 0
            r1 = r8
            r2 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
        L_0x0071:
            int r0 = r12.s()
            if (r0 < 0) goto L_0x0088
            r11.maxNumToRegister = r0
            com.braze.support.BrazeLogger$Priority r3 = com.braze.support.BrazeLogger.Priority.I
            com.braze.managers.BrazeGeofenceManager$e r5 = new com.braze.managers.BrazeGeofenceManager$e
            r5.<init>(r11)
            r4 = 0
            r6 = 2
            r7 = 0
            r1 = r8
            r2 = r11
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r1, (java.lang.Object) r2, (com.braze.support.BrazeLogger.Priority) r3, (java.lang.Throwable) r4, (kotlin.jvm.functions.Function0) r5, (int) r6, (java.lang.Object) r7)
        L_0x0088:
            bo.app.m r0 = r11.brazeGeofenceReEligibilityManager
            r0.a((bo.app.j5) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.managers.BrazeGeofenceManager.configureFromServerConfig(bo.app.j5):void");
    }

    public final bo.app.l getBrazeGeofenceApi() {
        return this.brazeGeofenceApi;
    }

    public final BrazeGeofence getBrazeGeofenceForGeofenceId(String str) {
        T t2;
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        ReentrantLock reentrantLock = this.geofenceListLock;
        reentrantLock.lock();
        try {
            Iterator<T> it = this.brazeGeofences.iterator();
            while (true) {
                if (!it.hasNext()) {
                    t2 = null;
                    break;
                }
                t2 = it.next();
                if (Intrinsics.areEqual((Object) ((BrazeGeofence) t2).getId(), (Object) str)) {
                    break;
                }
            }
            return (BrazeGeofence) t2;
        } finally {
            reentrantLock.unlock();
        }
    }

    public final bo.app.m getBrazeGeofenceReEligibilityManager() {
        return this.brazeGeofenceReEligibilityManager;
    }

    public final List<BrazeGeofence> getBrazeGeofences() {
        return this.brazeGeofences;
    }

    public final bo.app.n getBrazeLocationApi() {
        return this.brazeLocationApi;
    }

    public final z1 getBrazeManager() {
        return this.brazeManager;
    }

    public final IBrazeLocation getGeofenceRequestLocation() {
        return this.geofenceRequestLocation;
    }

    public final SharedPreferences getGeofenceStorageSharedPreferences() {
        return this.geofenceStorageSharedPreferences;
    }

    public final PendingIntent getGeofenceTransitionPendingIntent() {
        return this.geofenceTransitionPendingIntent;
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void initializeGeofences() {
        /*
            r8 = this;
            com.braze.support.BrazeLogger r7 = com.braze.support.BrazeLogger.INSTANCE
            com.braze.managers.BrazeGeofenceManager$f r4 = com.braze.managers.BrazeGeofenceManager.f.b
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r0 = r7
            r1 = r8
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
            com.braze.managers.BrazeGeofenceManager$Companion r0 = Companion
            bo.app.l5 r1 = r8.serverConfigStorageProvider
            boolean r0 = r0.getGeofencesEnabledFromServerConfig(r1)
            r1 = 1
            if (r0 == 0) goto L_0x002f
            android.content.Context r0 = r8.applicationContext
            java.lang.String r2 = "applicationContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r2)
            boolean r0 = r8.isGeofencesEnabledFromEnvironment(r0)
            if (r0 == 0) goto L_0x002f
            bo.app.l r0 = r8.brazeGeofenceApi
            boolean r0 = r0.a()
            if (r0 == 0) goto L_0x002f
            r0 = r1
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            r8.isGeofencesEnabled = r0
            com.braze.configuration.BrazeConfigurationProvider r0 = r8.configurationProvider
            boolean r0 = r0.isAutomaticGeofenceRequestsEnabled()
            if (r0 == 0) goto L_0x003e
            r8.requestGeofenceRefresh((boolean) r1)
            goto L_0x0049
        L_0x003e:
            com.braze.managers.BrazeGeofenceManager$g r4 = com.braze.managers.BrazeGeofenceManager.g.b
            r2 = 0
            r3 = 0
            r5 = 3
            r6 = 0
            r0 = r7
            r1 = r8
            com.braze.support.BrazeLogger.brazelog$default((com.braze.support.BrazeLogger) r0, (java.lang.Object) r1, (com.braze.support.BrazeLogger.Priority) r2, (java.lang.Throwable) r3, (kotlin.jvm.functions.Function0) r4, (int) r5, (java.lang.Object) r6)
        L_0x0049:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.braze.managers.BrazeGeofenceManager.initializeGeofences():void");
    }

    public final boolean isGeofencesEnabled() {
        return this.isGeofencesEnabled;
    }

    public final boolean isGeofencesEnabledFromEnvironment(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (!Companion.getGeofencesEnabledFromConfiguration(this.configurationProvider)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) h.b, 3, (Object) null);
            return false;
        } else if (!PermissionUtils.hasPermission(context, "android.permission.ACCESS_FINE_LOCATION")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) i.b, 2, (Object) null);
            return false;
        } else if (Build.VERSION.SDK_INT >= 29 && !PermissionUtils.hasPermission(context, "android.permission.ACCESS_BACKGROUND_LOCATION")) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.I, (Throwable) null, (Function0) j.b, 2, (Object) null);
            return false;
        } else if (!com.braze.support.f.a(context)) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) k.b, 3, (Object) null);
            return false;
        } else if (!this.brazeGeofenceApi.a()) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) l.b, 3, (Object) null);
            return false;
        } else {
            try {
                Class.forName("com.google.android.gms.location.LocationServices", false, BrazeGeofenceManager.class.getClassLoader());
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) n.b, 3, (Object) null);
                return true;
            } catch (Exception unused) {
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) m.b, 3, (Object) null);
                return false;
            }
        }
    }

    public void onLocationRequestComplete(IBrazeLocation iBrazeLocation) {
        if (iBrazeLocation != null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new o(iBrazeLocation), 3, (Object) null);
            requestGeofenceRefresh(iBrazeLocation);
            this.brazeGeofenceReEligibilityManager.a(DateTimeUtils.nowInSeconds());
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) p.b, 3, (Object) null);
    }

    public void postGeofenceReport(String str, GeofenceTransitionType geofenceTransitionType) {
        Unit unit;
        Intrinsics.checkNotNullParameter(str, "geofenceId");
        Intrinsics.checkNotNullParameter(geofenceTransitionType, "transitionType");
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) q.b, 2, (Object) null);
            return;
        }
        j.a aVar = bo.app.j.h;
        String obj = geofenceTransitionType.toString();
        Locale locale = Locale.US;
        Intrinsics.checkNotNullExpressionValue(locale, "US");
        String lowerCase = obj.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(locale)");
        x1 c2 = aVar.c(str, lowerCase);
        if (c2 != null) {
            if (analyticsEnabledForGeofenceId(str, geofenceTransitionType)) {
                this.brazeManager.a(c2);
            }
            BrazeGeofence brazeGeofenceForGeofenceId = getBrazeGeofenceForGeofenceId(str);
            boolean z2 = true;
            if (brazeGeofenceForGeofenceId == null || !this.brazeGeofenceReEligibilityManager.a(DateTimeUtils.nowInSeconds(), brazeGeofenceForGeofenceId, geofenceTransitionType)) {
                z2 = false;
            }
            if (z2) {
                this.brazeManager.b(c2);
            }
            unit = Unit.INSTANCE;
        } else {
            unit = null;
        }
        if (unit == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.E, (Throwable) null, (Function0) new r(str, geofenceTransitionType), 2, (Object) null);
        }
    }

    /* JADX INFO: finally extract failed */
    public void registerGeofences(List<BrazeGeofence> list) {
        Intrinsics.checkNotNullParameter(list, "geofenceList");
        List<T> mutableList = CollectionsKt.toMutableList(list);
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, BrazeLogger.Priority.W, (Throwable) null, (Function0) s.b, 2, (Object) null);
            return;
        }
        if (this.geofenceRequestLocation != null) {
            for (T t2 : mutableList) {
                IBrazeLocation iBrazeLocation = this.geofenceRequestLocation;
                if (iBrazeLocation != null) {
                    t2.setDistanceFromGeofenceRefresh(i3.a(iBrazeLocation.getLatitude(), iBrazeLocation.getLongitude(), t2.getLatitude(), t2.getLongitude()));
                }
            }
            CollectionsKt.sort(mutableList);
        }
        ReentrantLock reentrantLock = this.geofenceListLock;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new t(mutableList), 3, (Object) null);
            SharedPreferences.Editor edit = this.geofenceStorageSharedPreferences.edit();
            edit.clear();
            this.brazeGeofences.clear();
            int i2 = 0;
            Iterator<T> it = mutableList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                BrazeGeofence brazeGeofence = (BrazeGeofence) it.next();
                if (i2 == this.maxNumToRegister) {
                    BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new u(this), 3, (Object) null);
                    break;
                }
                this.brazeGeofences.add(brazeGeofence);
                BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new v(brazeGeofence), 3, (Object) null);
                edit.putString(brazeGeofence.getId(), brazeGeofence.forJsonPut().toString());
                i2++;
            }
            edit.apply();
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) new w(this), 3, (Object) null);
            Unit unit = Unit.INSTANCE;
            reentrantLock.unlock();
            this.brazeGeofenceReEligibilityManager.a((List) mutableList);
            setUpGeofences(true);
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    public final void registerGeofencesWithGooglePlay(List<BrazeGeofence> list, PendingIntent pendingIntent) {
        Intrinsics.checkNotNullParameter(list, "geofenceList");
        Intrinsics.checkNotNullParameter(pendingIntent, "geofenceRequestIntent");
        bo.app.l lVar = this.brazeGeofenceApi;
        Context context = this.applicationContext;
        Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
        lVar.a(context, list, pendingIntent);
    }

    public void requestGeofenceRefresh(IBrazeLocation iBrazeLocation) {
        Intrinsics.checkNotNullParameter(iBrazeLocation, FirebaseAnalytics.Param.LOCATION);
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) x.b, 3, (Object) null);
            return;
        }
        this.geofenceRequestLocation = iBrazeLocation;
        if (iBrazeLocation != null) {
            this.brazeManager.a(iBrazeLocation);
        }
    }

    public final void requestSingleLocationUpdateFromGooglePlay() {
        this.brazeLocationApi.a(new z(this));
    }

    public final void setBrazeGeofenceReEligibilityManager(bo.app.m mVar) {
        Intrinsics.checkNotNullParameter(mVar, "<set-?>");
        this.brazeGeofenceReEligibilityManager = mVar;
    }

    public final void setGeofenceRequestLocation(IBrazeLocation iBrazeLocation) {
        this.geofenceRequestLocation = iBrazeLocation;
    }

    public final void setGeofencesEnabled(boolean z2) {
        this.isGeofencesEnabled = z2;
    }

    public final void setMaxNumToRegister(int i2) {
        this.maxNumToRegister = i2;
    }

    public final void setUpGeofences(boolean z2) {
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) a0.b, 3, (Object) null);
            return;
        }
        PendingIntent pendingIntent = this.geofenceTransitionPendingIntent;
        if (pendingIntent == null) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) b0.b, 3, (Object) null);
        } else if (z2) {
            ReentrantLock reentrantLock = this.geofenceListLock;
            reentrantLock.lock();
            try {
                registerGeofencesWithGooglePlay(this.brazeGeofences, pendingIntent);
                Unit unit = Unit.INSTANCE;
            } finally {
                reentrantLock.unlock();
            }
        }
    }

    public final void tearDownGeofences(PendingIntent pendingIntent) {
        BrazeLogger brazeLogger = BrazeLogger.INSTANCE;
        BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) c0.b, 3, (Object) null);
        if (pendingIntent != null) {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) d0.b, 3, (Object) null);
            bo.app.l lVar = this.brazeGeofenceApi;
            Context context = this.applicationContext;
            Intrinsics.checkNotNullExpressionValue(context, "applicationContext");
            lVar.a(context, pendingIntent);
        }
        ReentrantLock reentrantLock = this.geofenceListLock;
        reentrantLock.lock();
        try {
            BrazeLogger.brazelog$default(brazeLogger, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) e0.b, 3, (Object) null);
            this.geofenceStorageSharedPreferences.edit().clear().apply();
            this.brazeGeofences.clear();
            Unit unit = Unit.INSTANCE;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void unregisterGeofences() {
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) f0.b, 3, (Object) null);
            return;
        }
        BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) g0.b, 3, (Object) null);
        tearDownGeofences(this.geofenceTransitionPendingIntent);
    }

    public final int getMaxNumToRegister() {
        return this.maxNumToRegister;
    }

    public void requestGeofenceRefresh(boolean z2) {
        if (!this.isGeofencesEnabled) {
            BrazeLogger.brazelog$default(BrazeLogger.INSTANCE, (Object) this, (BrazeLogger.Priority) null, (Throwable) null, (Function0) y.b, 3, (Object) null);
        } else if (this.brazeGeofenceReEligibilityManager.a(z2, DateTimeUtils.nowInSeconds())) {
            requestSingleLocationUpdateFromGooglePlay();
        }
    }
}
