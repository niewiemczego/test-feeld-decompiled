package com.facebook.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.pm.PackageManager;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.facebook.FacebookSdk;
import java.lang.reflect.Method;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\t\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u0000 \u00122\u00020\u0001:\u0003\u0012\u0013\u0014B\u0005¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0006R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00042\b\u0010\b\u001a\u0004\u0018\u00010\u0004@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u0006R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\b\u001a\u00020\u000f@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0015"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers;", "", "()V", "androidAdvertiserId", "", "getAndroidAdvertiserId", "()Ljava/lang/String;", "androidAdvertiserIdValue", "<set-?>", "androidInstallerPackage", "getAndroidInstallerPackage", "attributionId", "getAttributionId", "fetchTime", "", "", "isTrackingLimited", "()Z", "Companion", "GoogleAdInfo", "GoogleAdServiceConnection", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: AttributionIdentifiers.kt */
public final class AttributionIdentifiers {
    private static final String ANDROID_ID_COLUMN_NAME = "androidid";
    private static final String ATTRIBUTION_ID_COLUMN_NAME = "aid";
    public static final String ATTRIBUTION_ID_CONTENT_PROVIDER = "com.facebook.katana.provider.AttributionIdProvider";
    private static final String ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI = "com.facebook.wakizashi.provider.AttributionIdProvider";
    private static final int CONNECTION_RESULT_SUCCESS = 0;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final long IDENTIFIER_REFRESH_INTERVAL_MILLIS = 3600000;
    private static final String LIMIT_TRACKING_COLUMN_NAME = "limit_tracking";
    /* access modifiers changed from: private */
    public static final String TAG = AttributionIdentifiers.class.getCanonicalName();
    public static AttributionIdentifiers cachedIdentifiers;
    /* access modifiers changed from: private */
    public String androidAdvertiserIdValue;
    /* access modifiers changed from: private */
    public String androidInstallerPackage;
    /* access modifiers changed from: private */
    public String attributionId;
    /* access modifiers changed from: private */
    public long fetchTime;
    /* access modifiers changed from: private */
    public boolean isTrackingLimited;

    @JvmStatic
    public static final AttributionIdentifiers getAttributionIdentifiers(Context context) {
        return Companion.getAttributionIdentifiers(context);
    }

    @JvmStatic
    public static final boolean isTrackingLimited(Context context) {
        return Companion.isTrackingLimited(context);
    }

    public final String getAttributionId() {
        return this.attributionId;
    }

    public final String getAndroidInstallerPackage() {
        return this.androidInstallerPackage;
    }

    public final boolean isTrackingLimited() {
        return this.isTrackingLimited;
    }

    public final String getAndroidAdvertiserId() {
        FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
        if (FacebookSdk.isInitialized()) {
            FacebookSdk facebookSdk2 = FacebookSdk.INSTANCE;
            if (FacebookSdk.getAdvertiserIDCollectionEnabled()) {
                return this.androidAdvertiserIdValue;
            }
        }
        String str = null;
        return null;
    }

    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0013\u001a\u00020\u00112\u0006\u0010\u0014\u001a\u00020\u0011H\u0002J\u0010\u0010\u0015\u001a\u00020\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0018\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u0019\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001a\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0016\u001a\u00020\u0017H\u0007J\u0012\u0010\u001b\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00048\u0000XT¢\u0006\b\n\u0000\u0012\u0004\b\u0007\u0010\u0002R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0000@\u0000X\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0012\u0010\u0002¨\u0006\u001f"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$Companion;", "", "()V", "ANDROID_ID_COLUMN_NAME", "", "ATTRIBUTION_ID_COLUMN_NAME", "ATTRIBUTION_ID_CONTENT_PROVIDER", "getATTRIBUTION_ID_CONTENT_PROVIDER$facebook_core_release$annotations", "ATTRIBUTION_ID_CONTENT_PROVIDER_WAKIZASHI", "CONNECTION_RESULT_SUCCESS", "", "IDENTIFIER_REFRESH_INTERVAL_MILLIS", "", "LIMIT_TRACKING_COLUMN_NAME", "TAG", "kotlin.jvm.PlatformType", "cachedIdentifiers", "Lcom/facebook/internal/AttributionIdentifiers;", "getCachedIdentifiers$facebook_core_release$annotations", "cacheAndReturnIdentifiers", "identifiers", "getAndroidId", "context", "Landroid/content/Context;", "getAndroidIdViaReflection", "getAndroidIdViaService", "getAttributionIdentifiers", "getInstallerPackageName", "isGooglePlayServicesAvailable", "", "isTrackingLimited", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AttributionIdentifiers.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getATTRIBUTION_ID_CONTENT_PROVIDER$facebook_core_release$annotations() {
        }

        public static /* synthetic */ void getCachedIdentifiers$facebook_core_release$annotations() {
        }

        private Companion() {
        }

        private final AttributionIdentifiers getAndroidId(Context context) {
            AttributionIdentifiers androidIdViaReflection = getAndroidIdViaReflection(context);
            if (androidIdViaReflection != null) {
                return androidIdViaReflection;
            }
            AttributionIdentifiers androidIdViaService = getAndroidIdViaService(context);
            return androidIdViaService == null ? new AttributionIdentifiers() : androidIdViaService;
        }

        private final AttributionIdentifiers getAndroidIdViaReflection(Context context) {
            try {
                if (!isGooglePlayServicesAvailable(context)) {
                    return null;
                }
                Utility utility = Utility.INSTANCE;
                boolean z = false;
                Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.ads.identifier.AdvertisingIdClient", "getAdvertisingIdInfo", (Class<?>[]) new Class[]{Context.class});
                if (methodQuietly == null) {
                    return null;
                }
                Utility utility2 = Utility.INSTANCE;
                Object invokeMethodQuietly = Utility.invokeMethodQuietly((Object) null, methodQuietly, context);
                if (invokeMethodQuietly == null) {
                    return null;
                }
                Utility utility3 = Utility.INSTANCE;
                Method methodQuietly2 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "getId", (Class<?>[]) new Class[0]);
                Utility utility4 = Utility.INSTANCE;
                Method methodQuietly3 = Utility.getMethodQuietly(invokeMethodQuietly.getClass(), "isLimitAdTrackingEnabled", (Class<?>[]) new Class[0]);
                if (methodQuietly2 != null) {
                    if (methodQuietly3 != null) {
                        AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                        Utility utility5 = Utility.INSTANCE;
                        attributionIdentifiers.androidAdvertiserIdValue = (String) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly2, new Object[0]);
                        Utility utility6 = Utility.INSTANCE;
                        Boolean bool = (Boolean) Utility.invokeMethodQuietly(invokeMethodQuietly, methodQuietly3, new Object[0]);
                        if (bool != null) {
                            z = bool.booleanValue();
                        }
                        attributionIdentifiers.isTrackingLimited = z;
                        return attributionIdentifiers;
                    }
                }
                return null;
            } catch (Exception e) {
                Utility utility7 = Utility.INSTANCE;
                Utility.logd("android_id", e);
                return null;
            }
        }

        @JvmStatic
        public final boolean isTrackingLimited(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            AttributionIdentifiers attributionIdentifiers = getAttributionIdentifiers(context);
            return attributionIdentifiers != null && attributionIdentifiers.isTrackingLimited();
        }

        private final boolean isGooglePlayServicesAvailable(Context context) {
            Utility utility = Utility.INSTANCE;
            Method methodQuietly = Utility.getMethodQuietly("com.google.android.gms.common.GooglePlayServicesUtil", "isGooglePlayServicesAvailable", (Class<?>[]) new Class[]{Context.class});
            if (methodQuietly == null) {
                return false;
            }
            Utility utility2 = Utility.INSTANCE;
            Object invokeMethodQuietly = Utility.invokeMethodQuietly((Object) null, methodQuietly, context);
            if (!(invokeMethodQuietly instanceof Integer) || !Intrinsics.areEqual(invokeMethodQuietly, (Object) 0)) {
                return false;
            }
            return true;
        }

        private final AttributionIdentifiers getAndroidIdViaService(Context context) {
            GoogleAdServiceConnection googleAdServiceConnection = new GoogleAdServiceConnection();
            Intent intent = new Intent("com.google.android.gms.ads.identifier.service.START");
            intent.setPackage("com.google.android.gms");
            try {
                if (context.bindService(intent, googleAdServiceConnection, 1)) {
                    try {
                        GoogleAdInfo googleAdInfo = new GoogleAdInfo(googleAdServiceConnection.getBinder());
                        AttributionIdentifiers attributionIdentifiers = new AttributionIdentifiers();
                        attributionIdentifiers.androidAdvertiserIdValue = googleAdInfo.getAdvertiserId();
                        attributionIdentifiers.isTrackingLimited = googleAdInfo.isTrackingLimited();
                        return attributionIdentifiers;
                    } catch (Exception e) {
                        Utility utility = Utility.INSTANCE;
                        Utility.logd("android_id", e);
                    } finally {
                        context.unbindService(googleAdServiceConnection);
                    }
                }
            } catch (SecurityException unused) {
            }
            return null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:22:0x0085 A[Catch:{ Exception -> 0x00f8, all -> 0x00f6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x008a A[Catch:{ Exception -> 0x00f8, all -> 0x00f6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x008f A[Catch:{ Exception -> 0x00f8, all -> 0x00f6 }] */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:63:0x0115  */
        @kotlin.jvm.JvmStatic
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final com.facebook.internal.AttributionIdentifiers getAttributionIdentifiers(android.content.Context r13) {
            /*
                r12 = this;
                java.lang.String r0 = "limit_tracking"
                java.lang.String r1 = "androidid"
                java.lang.String r2 = "aid"
                java.lang.String r3 = "context"
                kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r3)
                com.facebook.internal.AttributionIdentifiers r3 = r12.getAndroidId(r13)
                r4 = 0
                android.os.Looper r5 = android.os.Looper.myLooper()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                android.os.Looper r6 = android.os.Looper.getMainLooper()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r5, (java.lang.Object) r6)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 != 0) goto L_0x00ee
                com.facebook.internal.AttributionIdentifiers r5 = com.facebook.internal.AttributionIdentifiers.cachedIdentifiers     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x0033
                long r6 = java.lang.System.currentTimeMillis()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                long r8 = r5.fetchTime     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                long r6 = r6 - r8
                r8 = 3600000(0x36ee80, double:1.7786363E-317)
                int r6 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
                if (r6 >= 0) goto L_0x0033
                return r5
            L_0x0033:
                java.lang.String[] r7 = new java.lang.String[]{r2, r1, r0}     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                android.content.pm.PackageManager r5 = r13.getPackageManager()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r6 = "com.facebook.katana.provider.AttributionIdProvider"
                r8 = 0
                android.content.pm.ProviderInfo r5 = r5.resolveContentProvider(r6, r8)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                android.content.pm.PackageManager r6 = r13.getPackageManager()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r9 = "com.facebook.wakizashi.provider.AttributionIdProvider"
                android.content.pm.ProviderInfo r6 = r6.resolveContentProvider(r9, r8)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x0065
                com.facebook.internal.FacebookSignatureValidator r8 = com.facebook.internal.FacebookSignatureValidator.INSTANCE     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r5 = r5.packageName     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r8 = "contentProviderInfo.packageName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r8)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                boolean r5 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r13, r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x0065
                java.lang.String r5 = "content://com.facebook.katana.provider.AttributionIdProvider"
                android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
            L_0x0063:
                r6 = r5
                goto L_0x007f
            L_0x0065:
                if (r6 == 0) goto L_0x007e
                com.facebook.internal.FacebookSignatureValidator r5 = com.facebook.internal.FacebookSignatureValidator.INSTANCE     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r5 = r6.packageName     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r6 = "wakizashiProviderInfo.packageName"
                kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r5, r6)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                boolean r5 = com.facebook.internal.FacebookSignatureValidator.validateSignature(r13, r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x007e
                java.lang.String r5 = "content://com.facebook.wakizashi.provider.AttributionIdProvider"
                android.net.Uri r5 = android.net.Uri.parse(r5)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                goto L_0x0063
            L_0x007e:
                r6 = r4
            L_0x007f:
                java.lang.String r5 = r12.getInstallerPackageName(r13)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r5 == 0) goto L_0x0088
                r3.androidInstallerPackage = r5     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
            L_0x0088:
                if (r6 != 0) goto L_0x008f
                com.facebook.internal.AttributionIdentifiers r13 = r12.cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                return r13
            L_0x008f:
                android.content.ContentResolver r5 = r13.getContentResolver()     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                r8 = 0
                r9 = 0
                r10 = 0
                android.database.Cursor r13 = r5.query(r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                if (r13 == 0) goto L_0x00da
                boolean r5 = r13.moveToFirst()     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                if (r5 != 0) goto L_0x00a3
                goto L_0x00da
            L_0x00a3:
                int r2 = r13.getColumnIndex(r2)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                int r1 = r13.getColumnIndex(r1)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                int r0 = r13.getColumnIndex(r0)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                java.lang.String r2 = r13.getString(r2)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                r3.attributionId = r2     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                if (r1 <= 0) goto L_0x00d2
                if (r0 <= 0) goto L_0x00d2
                java.lang.String r2 = r3.getAndroidAdvertiserId()     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                if (r2 != 0) goto L_0x00d2
                java.lang.String r1 = r13.getString(r1)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                r3.androidAdvertiserIdValue = r1     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                java.lang.String r0 = r13.getString(r0)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                boolean r0 = java.lang.Boolean.parseBoolean(r0)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                r3.isTrackingLimited = r0     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
            L_0x00d2:
                r13.close()
                com.facebook.internal.AttributionIdentifiers r13 = r12.cacheAndReturnIdentifiers(r3)
                return r13
            L_0x00da:
                com.facebook.internal.AttributionIdentifiers r0 = r12.cacheAndReturnIdentifiers(r3)     // Catch:{ Exception -> 0x00e9, all -> 0x00e5 }
                if (r13 != 0) goto L_0x00e1
                goto L_0x00e4
            L_0x00e1:
                r13.close()
            L_0x00e4:
                return r0
            L_0x00e5:
                r0 = move-exception
                r4 = r13
                r13 = r0
                goto L_0x0112
            L_0x00e9:
                r0 = move-exception
                r11 = r0
                r0 = r13
                r13 = r11
                goto L_0x00fa
            L_0x00ee:
                com.facebook.FacebookException r13 = new com.facebook.FacebookException     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                java.lang.String r0 = "getAttributionIdentifiers cannot be called on the main thread."
                r13.<init>((java.lang.String) r0)     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
                throw r13     // Catch:{ Exception -> 0x00f8, all -> 0x00f6 }
            L_0x00f6:
                r13 = move-exception
                goto L_0x0112
            L_0x00f8:
                r13 = move-exception
                r0 = r4
            L_0x00fa:
                com.facebook.internal.Utility r1 = com.facebook.internal.Utility.INSTANCE     // Catch:{ all -> 0x0110 }
                java.lang.String r1 = com.facebook.internal.AttributionIdentifiers.TAG     // Catch:{ all -> 0x0110 }
                java.lang.String r2 = "Caught unexpected exception in getAttributionId(): "
                java.lang.String r13 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r13)     // Catch:{ all -> 0x0110 }
                com.facebook.internal.Utility.logd((java.lang.String) r1, (java.lang.String) r13)     // Catch:{ all -> 0x0110 }
                if (r0 != 0) goto L_0x010c
                goto L_0x010f
            L_0x010c:
                r0.close()
            L_0x010f:
                return r4
            L_0x0110:
                r13 = move-exception
                r4 = r0
            L_0x0112:
                if (r4 != 0) goto L_0x0115
                goto L_0x0118
            L_0x0115:
                r4.close()
            L_0x0118:
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.facebook.internal.AttributionIdentifiers.Companion.getAttributionIdentifiers(android.content.Context):com.facebook.internal.AttributionIdentifiers");
        }

        private final AttributionIdentifiers cacheAndReturnIdentifiers(AttributionIdentifiers attributionIdentifiers) {
            attributionIdentifiers.fetchTime = System.currentTimeMillis();
            AttributionIdentifiers.cachedIdentifiers = attributionIdentifiers;
            return attributionIdentifiers;
        }

        private final String getInstallerPackageName(Context context) {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null) {
                return null;
            }
            return packageManager.getInstallerPackageName(context.getPackageName());
        }
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u0010\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u000e\u0010\u0007\u001a\u00020\bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00040\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdServiceConnection;", "Landroid/content/ServiceConnection;", "()V", "binder", "Landroid/os/IBinder;", "getBinder", "()Landroid/os/IBinder;", "consumed", "Ljava/util/concurrent/atomic/AtomicBoolean;", "queue", "Ljava/util/concurrent/BlockingQueue;", "onServiceConnected", "", "name", "Landroid/content/ComponentName;", "service", "onServiceDisconnected", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AttributionIdentifiers.kt */
    private static final class GoogleAdServiceConnection implements ServiceConnection {
        private final AtomicBoolean consumed = new AtomicBoolean(false);
        private final BlockingQueue<IBinder> queue = new LinkedBlockingDeque();

        public void onServiceDisconnected(ComponentName componentName) {
        }

        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            if (iBinder != null) {
                try {
                    this.queue.put(iBinder);
                } catch (InterruptedException unused) {
                }
            }
        }

        public final IBinder getBinder() throws InterruptedException {
            if (!this.consumed.compareAndSet(true, true)) {
                IBinder take = this.queue.take();
                Intrinsics.checkNotNullExpressionValue(take, "queue.take()");
                return take;
            }
            throw new IllegalStateException("Binder already consumed".toString());
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0002\u0018\u0000 \r2\u00020\u0001:\u0001\rB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u00020\u0003H\u0016R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\t\u0010\u000b¨\u0006\u000e"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdInfo;", "Landroid/os/IInterface;", "binder", "Landroid/os/IBinder;", "(Landroid/os/IBinder;)V", "advertiserId", "", "getAdvertiserId", "()Ljava/lang/String;", "isTrackingLimited", "", "()Z", "asBinder", "Companion", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
    /* compiled from: AttributionIdentifiers.kt */
    private static final class GoogleAdInfo implements IInterface {
        public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
        private static final int FIRST_TRANSACTION_CODE = 1;
        private static final int SECOND_TRANSACTION_CODE = 2;
        private final IBinder binder;

        public GoogleAdInfo(IBinder iBinder) {
            Intrinsics.checkNotNullParameter(iBinder, "binder");
            this.binder = iBinder;
        }

        public IBinder asBinder() {
            return this.binder;
        }

        public final String getAdvertiserId() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            Parcel obtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain2, "obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                this.binder.transact(1, obtain, obtain2, 0);
                obtain2.readException();
                return obtain2.readString();
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        public final boolean isTrackingLimited() throws RemoteException {
            Parcel obtain = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain, "obtain()");
            Parcel obtain2 = Parcel.obtain();
            Intrinsics.checkNotNullExpressionValue(obtain2, "obtain()");
            try {
                obtain.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
                boolean z = true;
                obtain.writeInt(1);
                this.binder.transact(2, obtain, obtain2, 0);
                obtain2.readException();
                if (obtain2.readInt() == 0) {
                    z = false;
                }
                return z;
            } finally {
                obtain2.recycle();
                obtain.recycle();
            }
        }

        @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/facebook/internal/AttributionIdentifiers$GoogleAdInfo$Companion;", "", "()V", "FIRST_TRANSACTION_CODE", "", "SECOND_TRANSACTION_CODE", "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
        /* compiled from: AttributionIdentifiers.kt */
        public static final class Companion {
            public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
                this();
            }

            private Companion() {
            }
        }
    }
}
