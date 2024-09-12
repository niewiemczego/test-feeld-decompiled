package zendesk.conversationkit.android.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.telephony.TelephonyManager;
import com.amplitude.reactnative.AndroidContextProvider;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b'\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\b\u0018\u0000 02\u00020\u0001:\u00010BO\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0002\u0010\fJ\u000e\u0010\u0017\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u0018J\u000e\u0010\u0019\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÀ\u0003¢\u0006\u0002\b\u001cJ\u000e\u0010\u001d\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\u001eJ\u000e\u0010\u001f\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b J\u000e\u0010!\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b\"J\u000e\u0010#\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b$J\u000e\u0010%\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b&J\u000e\u0010'\u001a\u00020\u0003HÀ\u0003¢\u0006\u0002\b(Je\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010-\u001a\u00020.HÖ\u0001J\t\u0010/\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0014\u0010\u0006\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0014\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0014\u0010\u0007\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0014\u0010\b\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0014\u0010\t\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000eR\u0014\u0010\n\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u00061"}, d2 = {"Lzendesk/conversationkit/android/internal/HostAppInfo;", "", "appPackage", "", "appInstallerPackage", "appName", "appVersion", "deviceManufacturer", "deviceModel", "deviceOperatingSystem", "deviceOperatingSystemVersion", "deviceCarrierName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAppInstallerPackage$zendesk_conversationkit_conversationkit_android", "()Ljava/lang/String;", "getAppName$zendesk_conversationkit_conversationkit_android", "getAppPackage$zendesk_conversationkit_conversationkit_android", "getAppVersion$zendesk_conversationkit_conversationkit_android", "getDeviceCarrierName$zendesk_conversationkit_conversationkit_android", "getDeviceManufacturer$zendesk_conversationkit_conversationkit_android", "getDeviceModel$zendesk_conversationkit_conversationkit_android", "getDeviceOperatingSystem$zendesk_conversationkit_conversationkit_android", "getDeviceOperatingSystemVersion$zendesk_conversationkit_conversationkit_android", "component1", "component1$zendesk_conversationkit_conversationkit_android", "component2", "component2$zendesk_conversationkit_conversationkit_android", "component3", "component3$zendesk_conversationkit_conversationkit_android", "component4", "component4$zendesk_conversationkit_conversationkit_android", "component5", "component5$zendesk_conversationkit_conversationkit_android", "component6", "component6$zendesk_conversationkit_conversationkit_android", "component7", "component7$zendesk_conversationkit_conversationkit_android", "component8", "component8$zendesk_conversationkit_conversationkit_android", "component9", "component9$zendesk_conversationkit_conversationkit_android", "copy", "equals", "", "other", "hashCode", "", "toString", "Companion", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HostAppInfo.kt */
public final class HostAppInfo {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final String appInstallerPackage;
    private final String appName;
    private final String appPackage;
    private final String appVersion;
    private final String deviceCarrierName;
    private final String deviceManufacturer;
    private final String deviceModel;
    private final String deviceOperatingSystem;
    private final String deviceOperatingSystemVersion;

    public static /* synthetic */ HostAppInfo copy$default(HostAppInfo hostAppInfo, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, int i, Object obj) {
        HostAppInfo hostAppInfo2 = hostAppInfo;
        int i2 = i;
        return hostAppInfo.copy((i2 & 1) != 0 ? hostAppInfo2.appPackage : str, (i2 & 2) != 0 ? hostAppInfo2.appInstallerPackage : str2, (i2 & 4) != 0 ? hostAppInfo2.appName : str3, (i2 & 8) != 0 ? hostAppInfo2.appVersion : str4, (i2 & 16) != 0 ? hostAppInfo2.deviceManufacturer : str5, (i2 & 32) != 0 ? hostAppInfo2.deviceModel : str6, (i2 & 64) != 0 ? hostAppInfo2.deviceOperatingSystem : str7, (i2 & 128) != 0 ? hostAppInfo2.deviceOperatingSystemVersion : str8, (i2 & 256) != 0 ? hostAppInfo2.deviceCarrierName : str9);
    }

    @JvmStatic
    public static final HostAppInfo from(Context context) {
        return Companion.from(context);
    }

    public final String component1$zendesk_conversationkit_conversationkit_android() {
        return this.appPackage;
    }

    public final String component2$zendesk_conversationkit_conversationkit_android() {
        return this.appInstallerPackage;
    }

    public final String component3$zendesk_conversationkit_conversationkit_android() {
        return this.appName;
    }

    public final String component4$zendesk_conversationkit_conversationkit_android() {
        return this.appVersion;
    }

    public final String component5$zendesk_conversationkit_conversationkit_android() {
        return this.deviceManufacturer;
    }

    public final String component6$zendesk_conversationkit_conversationkit_android() {
        return this.deviceModel;
    }

    public final String component7$zendesk_conversationkit_conversationkit_android() {
        return this.deviceOperatingSystem;
    }

    public final String component8$zendesk_conversationkit_conversationkit_android() {
        return this.deviceOperatingSystemVersion;
    }

    public final String component9$zendesk_conversationkit_conversationkit_android() {
        return this.deviceCarrierName;
    }

    public final HostAppInfo copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "appPackage");
        Intrinsics.checkNotNullParameter(str2, "appInstallerPackage");
        Intrinsics.checkNotNullParameter(str4, "appVersion");
        String str10 = str5;
        Intrinsics.checkNotNullParameter(str10, "deviceManufacturer");
        String str11 = str6;
        Intrinsics.checkNotNullParameter(str11, "deviceModel");
        String str12 = str7;
        Intrinsics.checkNotNullParameter(str12, "deviceOperatingSystem");
        String str13 = str8;
        Intrinsics.checkNotNullParameter(str13, "deviceOperatingSystemVersion");
        String str14 = str9;
        Intrinsics.checkNotNullParameter(str14, "deviceCarrierName");
        return new HostAppInfo(str, str2, str3, str4, str10, str11, str12, str13, str14);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof HostAppInfo)) {
            return false;
        }
        HostAppInfo hostAppInfo = (HostAppInfo) obj;
        return Intrinsics.areEqual((Object) this.appPackage, (Object) hostAppInfo.appPackage) && Intrinsics.areEqual((Object) this.appInstallerPackage, (Object) hostAppInfo.appInstallerPackage) && Intrinsics.areEqual((Object) this.appName, (Object) hostAppInfo.appName) && Intrinsics.areEqual((Object) this.appVersion, (Object) hostAppInfo.appVersion) && Intrinsics.areEqual((Object) this.deviceManufacturer, (Object) hostAppInfo.deviceManufacturer) && Intrinsics.areEqual((Object) this.deviceModel, (Object) hostAppInfo.deviceModel) && Intrinsics.areEqual((Object) this.deviceOperatingSystem, (Object) hostAppInfo.deviceOperatingSystem) && Intrinsics.areEqual((Object) this.deviceOperatingSystemVersion, (Object) hostAppInfo.deviceOperatingSystemVersion) && Intrinsics.areEqual((Object) this.deviceCarrierName, (Object) hostAppInfo.deviceCarrierName);
    }

    public int hashCode() {
        int hashCode = ((this.appPackage.hashCode() * 31) + this.appInstallerPackage.hashCode()) * 31;
        String str = this.appName;
        return ((((((((((((hashCode + (str == null ? 0 : str.hashCode())) * 31) + this.appVersion.hashCode()) * 31) + this.deviceManufacturer.hashCode()) * 31) + this.deviceModel.hashCode()) * 31) + this.deviceOperatingSystem.hashCode()) * 31) + this.deviceOperatingSystemVersion.hashCode()) * 31) + this.deviceCarrierName.hashCode();
    }

    public String toString() {
        return "HostAppInfo(appPackage=" + this.appPackage + ", appInstallerPackage=" + this.appInstallerPackage + ", appName=" + this.appName + ", appVersion=" + this.appVersion + ", deviceManufacturer=" + this.deviceManufacturer + ", deviceModel=" + this.deviceModel + ", deviceOperatingSystem=" + this.deviceOperatingSystem + ", deviceOperatingSystemVersion=" + this.deviceOperatingSystemVersion + ", deviceCarrierName=" + this.deviceCarrierName + ')';
    }

    public HostAppInfo(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9) {
        Intrinsics.checkNotNullParameter(str, "appPackage");
        Intrinsics.checkNotNullParameter(str2, "appInstallerPackage");
        Intrinsics.checkNotNullParameter(str4, "appVersion");
        Intrinsics.checkNotNullParameter(str5, "deviceManufacturer");
        Intrinsics.checkNotNullParameter(str6, "deviceModel");
        Intrinsics.checkNotNullParameter(str7, "deviceOperatingSystem");
        Intrinsics.checkNotNullParameter(str8, "deviceOperatingSystemVersion");
        Intrinsics.checkNotNullParameter(str9, "deviceCarrierName");
        this.appPackage = str;
        this.appInstallerPackage = str2;
        this.appName = str3;
        this.appVersion = str4;
        this.deviceManufacturer = str5;
        this.deviceModel = str6;
        this.deviceOperatingSystem = str7;
        this.deviceOperatingSystemVersion = str8;
        this.deviceCarrierName = str9;
    }

    public final String getAppPackage$zendesk_conversationkit_conversationkit_android() {
        return this.appPackage;
    }

    public final String getAppInstallerPackage$zendesk_conversationkit_conversationkit_android() {
        return this.appInstallerPackage;
    }

    public final String getAppName$zendesk_conversationkit_conversationkit_android() {
        return this.appName;
    }

    public final String getAppVersion$zendesk_conversationkit_conversationkit_android() {
        return this.appVersion;
    }

    public final String getDeviceManufacturer$zendesk_conversationkit_conversationkit_android() {
        return this.deviceManufacturer;
    }

    public final String getDeviceModel$zendesk_conversationkit_conversationkit_android() {
        return this.deviceModel;
    }

    public final String getDeviceOperatingSystem$zendesk_conversationkit_conversationkit_android() {
        return this.deviceOperatingSystem;
    }

    public final String getDeviceOperatingSystemVersion$zendesk_conversationkit_conversationkit_android() {
        return this.deviceOperatingSystemVersion;
    }

    public final String getDeviceCarrierName$zendesk_conversationkit_conversationkit_android() {
        return this.deviceCarrierName;
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, d2 = {"Lzendesk/conversationkit/android/internal/HostAppInfo$Companion;", "", "()V", "from", "Lzendesk/conversationkit/android/internal/HostAppInfo;", "context", "Landroid/content/Context;", "zendesk.conversationkit_conversationkit-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: HostAppInfo.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final HostAppInfo from(Context context) {
            String str;
            String str2;
            String str3;
            Intrinsics.checkNotNullParameter(context, "context");
            AndroidBuild create$zendesk_conversationkit_conversationkit_android = AndroidBuild.Companion.create$zendesk_conversationkit_conversationkit_android();
            PackageManager packageManager = context.getPackageManager();
            Intrinsics.checkNotNullExpressionValue(packageManager, "context.packageManager");
            String packageName = context.getPackageName();
            String str4 = packageName == null ? "" : packageName;
            try {
                String str5 = packageManager.getPackageInfo(str4, 0).versionName;
                if (str5 == null) {
                    str5 = "";
                }
                str = str5;
            } catch (PackageManager.NameNotFoundException unused) {
                str = "";
            }
            String installerPackageName = packageManager.getInstallerPackageName(str4);
            if (installerPackageName == null) {
                str2 = "";
            } else {
                str2 = installerPackageName;
            }
            String obj = packageManager.getApplicationLabel(context.getApplicationInfo()).toString();
            String deviceManufacturer = create$zendesk_conversationkit_conversationkit_android.getDeviceManufacturer();
            String deviceModel = create$zendesk_conversationkit_conversationkit_android.getDeviceModel();
            String deviceOperatingSystemVersion = create$zendesk_conversationkit_conversationkit_android.getDeviceOperatingSystemVersion();
            Object systemService = context.getSystemService("phone");
            String str6 = null;
            TelephonyManager telephonyManager = systemService instanceof TelephonyManager ? (TelephonyManager) systemService : null;
            if (telephonyManager != null) {
                str6 = telephonyManager.getNetworkOperatorName();
            }
            if (str6 == null) {
                str3 = "";
            } else {
                str3 = str6;
            }
            return new HostAppInfo(str4, str2, obj, str, deviceManufacturer, deviceModel, AndroidContextProvider.PLATFORM, deviceOperatingSystemVersion, str3);
        }
    }
}
