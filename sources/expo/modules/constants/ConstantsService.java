package expo.modules.constants;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import com.facebook.device.yearclass.YearClass;
import com.google.android.exoplayer2.C;
import expo.modules.core.interfaces.InternalModule;
import expo.modules.core.utilities.EmulatorUtilities;
import expo.modules.interfaces.constants.ConstantsInterface;
import io.sentry.ProfilingTraceData;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0016\u0018\u0000 #2\u00020\u00012\u00020\u0002:\u0002#$B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0013\u001a\u00020\u0007H\u0016J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0007H\u0016J\u0016\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0007\u0012\u0006\u0012\u0004\u0018\u00010\u00170\u0016H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\b\u0010\u0019\u001a\u00020\u000eH\u0016J\u0012\u0010\u001a\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u001c0\u001bH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0007H\u0016J\b\u0010 \u001a\u00020\u000eH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00070\u001bH\u0016J\b\u0010\"\u001a\u00020\u0007H\u0016R\u0016\u0010\u0006\u001a\u0004\u0018\u00010\u00078BX\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006%"}, d2 = {"Lexpo/modules/constants/ConstantsService;", "Lexpo/modules/core/interfaces/InternalModule;", "Lexpo/modules/interfaces/constants/ConstantsInterface;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "appConfig", "", "getAppConfig", "()Ljava/lang/String;", "exponentInstallationId", "Lexpo/modules/constants/ExponentInstallationId;", "sessionId", "statusBarHeightInternal", "", "getStatusBarHeightInternal", "()I", "setStatusBarHeightInternal", "(I)V", "getAppOwnership", "getAppScopeKey", "getConstants", "", "", "getDeviceName", "getDeviceYearClass", "getExportedInterfaces", "", "Ljava/lang/Class;", "getIsDevice", "", "getOrCreateInstallationId", "getStatusBarHeight", "getSystemFonts", "getSystemVersion", "Companion", "ExecutionEnvironment", "expo-constants_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
/* compiled from: ConstantsService.kt */
public class ConstantsService implements InternalModule, ConstantsInterface {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final Context context;
    private final ExponentInstallationId exponentInstallationId;
    private final String sessionId;
    private int statusBarHeightInternal;

    public String getAppOwnership() {
        return "guest";
    }

    public ConstantsService(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
        Integer valueOf = Integer.valueOf(context2.getResources().getIdentifier("status_bar_height", "dimen", "android"));
        int i = 0;
        valueOf = !(valueOf.intValue() > 0) ? null : valueOf;
        this.statusBarHeightInternal = valueOf != null ? Companion.convertPixelsToDp((float) context2.getResources().getDimensionPixelSize(valueOf.intValue()), context2) : i;
        String uuid = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(uuid, "randomUUID().toString()");
        this.sessionId = uuid;
        this.exponentInstallationId = new ExponentInstallationId(context2);
    }

    public final int getStatusBarHeightInternal() {
        return this.statusBarHeightInternal;
    }

    public final void setStatusBarHeightInternal(int i) {
        this.statusBarHeightInternal = i;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006j\u0002\b\u0007j\u0002\b\bj\u0002\b\t¨\u0006\n"}, d2 = {"Lexpo/modules/constants/ConstantsService$ExecutionEnvironment;", "", "string", "", "(Ljava/lang/String;ILjava/lang/String;)V", "getString", "()Ljava/lang/String;", "BARE", "STANDALONE", "STORE_CLIENT", "expo-constants_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConstantsService.kt */
    public enum ExecutionEnvironment {
        BARE("bare"),
        STANDALONE("standalone"),
        STORE_CLIENT("storeClient");
        
        private final String string;

        private ExecutionEnvironment(String str) {
            this.string = str;
        }

        public final String getString() {
            return this.string;
        }
    }

    public List<Class<?>> getExportedInterfaces() {
        return CollectionsKt.listOf(ConstantsInterface.class);
    }

    public Map<String, Object> getConstants() {
        Map<String, Object> mutableMapOf = MapsKt.mutableMapOf(TuplesKt.to("sessionId", this.sessionId), TuplesKt.to("executionEnvironment", ExecutionEnvironment.BARE.getString()), TuplesKt.to("statusBarHeight", Integer.valueOf(this.statusBarHeightInternal)), TuplesKt.to("deviceYearClass", Integer.valueOf(getDeviceYearClass())), TuplesKt.to("deviceName", getDeviceName()), TuplesKt.to("isDevice", Boolean.valueOf(getIsDevice())), TuplesKt.to("systemFonts", getSystemFonts()), TuplesKt.to("systemVersion", getSystemVersion()), TuplesKt.to("installationId", getOrCreateInstallationId()), TuplesKt.to("manifest", getAppConfig()), TuplesKt.to("platform", MapsKt.mapOf(TuplesKt.to("android", MapsKt.emptyMap()))));
        try {
            PackageInfo packageInfo = this.context.getPackageManager().getPackageInfo(this.context.getPackageName(), 0);
            mutableMapOf.put("nativeAppVersion", packageInfo.versionName);
            Companion companion = Companion;
            Intrinsics.checkNotNullExpressionValue(packageInfo, "pInfo");
            mutableMapOf.put("nativeBuildVersion", String.valueOf((int) companion.getLongVersionCode(packageInfo)));
        } catch (PackageManager.NameNotFoundException e) {
            Log.e(ConstantsServiceKt.TAG, "Exception: ", e);
        }
        return mutableMapOf;
    }

    public String getAppScopeKey() {
        return this.context.getPackageName();
    }

    public String getDeviceName() {
        String str = Build.MODEL;
        Intrinsics.checkNotNullExpressionValue(str, "MODEL");
        return str;
    }

    public int getDeviceYearClass() {
        return YearClass.get(this.context);
    }

    public boolean getIsDevice() {
        return !EmulatorUtilities.INSTANCE.isRunningOnEmulator();
    }

    public int getStatusBarHeight() {
        return this.statusBarHeightInternal;
    }

    public String getSystemVersion() {
        String str = Build.VERSION.RELEASE;
        Intrinsics.checkNotNullExpressionValue(str, "RELEASE");
        return str;
    }

    public String getOrCreateInstallationId() {
        return this.exponentInstallationId.getOrCreateUUID();
    }

    public List<String> getSystemFonts() {
        return CollectionsKt.listOf(ProfilingTraceData.TRUNCATION_REASON_NORMAL, "notoserif", C.SANS_SERIF_NAME, "sans-serif-light", "sans-serif-thin", "sans-serif-condensed", "sans-serif-medium", C.SERIF_NAME, "Roboto", "monospace");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        kotlin.io.CloseableKt.closeFinally(r1, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.lang.String getAppConfig() {
        /*
            r4 = this;
            r0 = 0
            android.content.Context r1 = r4.context     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            android.content.res.AssetManager r1 = r1.getAssets()     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            java.lang.String r2 = "app.config"
            java.io.InputStream r1 = r1.open(r2)     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            java.io.Closeable r1 = (java.io.Closeable) r1     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            r2 = r1
            java.io.InputStream r2 = (java.io.InputStream) r2     // Catch:{ all -> 0x001c }
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ all -> 0x001c }
            java.lang.String r2 = org.apache.commons.io.IOUtils.toString((java.io.InputStream) r2, (java.nio.charset.Charset) r3)     // Catch:{ all -> 0x001c }
            kotlin.io.CloseableKt.closeFinally(r1, r0)     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            return r2
        L_0x001c:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x001e }
        L_0x001e:
            r3 = move-exception
            kotlin.io.CloseableKt.closeFinally(r1, r2)     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
            throw r3     // Catch:{ FileNotFoundException -> 0x002f, Exception -> 0x0023 }
        L_0x0023:
            r1 = move-exception
            java.lang.String r2 = expo.modules.constants.ConstantsServiceKt.TAG
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            java.lang.String r3 = "Error reading embedded app config"
            android.util.Log.e(r2, r3, r1)
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: expo.modules.constants.ConstantsService.getAppConfig():java.lang.String");
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0003\u001a\u00020\u00048BX\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005¨\u0006\u0010"}, d2 = {"Lexpo/modules/constants/ConstantsService$Companion;", "", "()V", "isRunningOnEmulator", "", "()Z", "convertPixelsToDp", "", "px", "", "context", "Landroid/content/Context;", "getLongVersionCode", "", "info", "Landroid/content/pm/PackageInfo;", "expo-constants_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    /* compiled from: ConstantsService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* access modifiers changed from: private */
        public final int convertPixelsToDp(float f, Context context) {
            return (int) (f / (((float) context.getResources().getDisplayMetrics().densityDpi) / 160.0f));
        }

        private final boolean isRunningOnEmulator() {
            return EmulatorUtilities.INSTANCE.isRunningOnEmulator();
        }

        /* access modifiers changed from: private */
        public final long getLongVersionCode(PackageInfo packageInfo) {
            if (Build.VERSION.SDK_INT >= 28) {
                return packageInfo.getLongVersionCode();
            }
            return (long) packageInfo.versionCode;
        }
    }
}
