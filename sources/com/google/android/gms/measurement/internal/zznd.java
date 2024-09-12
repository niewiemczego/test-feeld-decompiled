package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.webkit.ProxyConfig;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.CollectionUtils;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzcv;
import com.google.android.gms.internal.measurement.zzot;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.firebase.dynamiclinks.DynamicLink;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;
import org.apache.commons.lang3.time.DateUtils;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.dataflow.qual.Pure;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zznd extends zzic {
    private static final String[] zza = {"firebase_", "google_", "ga_"};
    private static final String[] zzb = {"_err"};
    private SecureRandom zzc;
    private final AtomicLong zzd = new AtomicLong(0);
    private int zze;
    private MeasurementManagerFutures zzf;
    private Boolean zzg;
    private Integer zzh = null;

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b1  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00c9 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ca  */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x015f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:73:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zza(java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.Object r19, android.os.Bundle r20, java.util.List<java.lang.String> r21, boolean r22, boolean r23) {
        /*
            r15 = this;
            r7 = r15
            r8 = r18
            r0 = r19
            r1 = r20
            r15.zzt()
            boolean r2 = zza((java.lang.Object) r19)
            java.lang.String r3 = "param"
            r9 = 0
            r10 = 1
            if (r2 == 0) goto L_0x0090
            if (r23 == 0) goto L_0x008d
            java.lang.String[] r2 = com.google.android.gms.measurement.internal.zzik.zzc
            boolean r2 = zza((java.lang.String) r8, (java.lang.String[]) r2)
            if (r2 != 0) goto L_0x0021
            r0 = 20
            return r0
        L_0x0021:
            com.google.android.gms.measurement.internal.zzhf r2 = r7.zzu
            com.google.android.gms.measurement.internal.zzkp r2 = r2.zzr()
            boolean r2 = r2.zzai()
            if (r2 != 0) goto L_0x0030
            r0 = 25
            return r0
        L_0x0030:
            boolean r2 = r0 instanceof android.os.Parcelable[]
            r4 = 200(0xc8, float:2.8E-43)
            if (r2 == 0) goto L_0x003b
            r5 = r0
            android.os.Parcelable[] r5 = (android.os.Parcelable[]) r5
            int r5 = r5.length
            goto L_0x0046
        L_0x003b:
            boolean r5 = r0 instanceof java.util.ArrayList
            if (r5 == 0) goto L_0x005b
            r5 = r0
            java.util.ArrayList r5 = (java.util.ArrayList) r5
            int r5 = r5.size()
        L_0x0046:
            if (r5 <= r4) goto L_0x005b
            com.google.android.gms.measurement.internal.zzfr r6 = r15.zzj()
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzv()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r11 = "Parameter array is too long; discarded. Value kind, name, array length"
            r6.zza(r11, r3, r8, r5)
            r5 = r9
            goto L_0x005c
        L_0x005b:
            r5 = r10
        L_0x005c:
            if (r5 != 0) goto L_0x0090
            r5 = 17
            if (r2 == 0) goto L_0x0072
            r2 = r0
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            int r6 = r2.length
            if (r6 <= r4) goto L_0x008b
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r2, r4)
            android.os.Parcelable[] r2 = (android.os.Parcelable[]) r2
            r1.putParcelableArray(r8, r2)
            goto L_0x008b
        L_0x0072:
            boolean r2 = r0 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x008b
            r2 = r0
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            int r6 = r2.size()
            if (r6 <= r4) goto L_0x008b
            java.util.ArrayList r6 = new java.util.ArrayList
            java.util.List r2 = r2.subList(r9, r4)
            r6.<init>(r2)
            r1.putParcelableArrayList(r8, r6)
        L_0x008b:
            r11 = r5
            goto L_0x0091
        L_0x008d:
            r0 = 21
            return r0
        L_0x0090:
            r11 = r9
        L_0x0091:
            boolean r1 = zzg(r17)
            if (r1 != 0) goto L_0x00b1
            boolean r1 = zzg(r18)
            if (r1 == 0) goto L_0x009e
            goto L_0x00b1
        L_0x009e:
            com.google.android.gms.measurement.internal.zzaf r1 = r15.zze()
            com.google.android.gms.measurement.internal.zzhf r2 = r7.zzu
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzh()
            java.lang.String r2 = r2.zzad()
            int r1 = r1.zzb(r2)
            goto L_0x00c3
        L_0x00b1:
            com.google.android.gms.measurement.internal.zzaf r1 = r15.zze()
            com.google.android.gms.measurement.internal.zzhf r2 = r7.zzu
            com.google.android.gms.measurement.internal.zzfl r2 = r2.zzh()
            java.lang.String r2 = r2.zzad()
            int r1 = r1.zzc(r2)
        L_0x00c3:
            boolean r1 = r15.zza((java.lang.String) r3, (java.lang.String) r8, (int) r1, (java.lang.Object) r0)
            if (r1 == 0) goto L_0x00ca
            return r11
        L_0x00ca:
            if (r23 == 0) goto L_0x0160
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 == 0) goto L_0x00e4
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r21
            r6 = r22
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
        L_0x00e1:
            r9 = r10
            goto L_0x015d
        L_0x00e4:
            boolean r1 = r0 instanceof android.os.Parcelable[]
            if (r1 == 0) goto L_0x011b
            r12 = r0
            android.os.Parcelable[] r12 = (android.os.Parcelable[]) r12
            int r13 = r12.length
            r14 = r9
        L_0x00ed:
            if (r14 >= r13) goto L_0x00e1
            r0 = r12[r14]
            boolean r1 = r0 instanceof android.os.Bundle
            if (r1 != 0) goto L_0x0107
            com.google.android.gms.measurement.internal.zzfr r1 = r15.zzj()
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzv()
            java.lang.Class r0 = r0.getClass()
            java.lang.String r2 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r1.zza(r2, r0, r8)
            goto L_0x015d
        L_0x0107:
            r4 = r0
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r21
            r6 = r22
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
            int r14 = r14 + 1
            goto L_0x00ed
        L_0x011b:
            boolean r1 = r0 instanceof java.util.ArrayList
            if (r1 == 0) goto L_0x015d
            r12 = r0
            java.util.ArrayList r12 = (java.util.ArrayList) r12
            int r13 = r12.size()
            r0 = r9
        L_0x0127:
            if (r0 >= r13) goto L_0x00e1
            java.lang.Object r1 = r12.get(r0)
            int r14 = r0 + 1
            boolean r0 = r1 instanceof android.os.Bundle
            if (r0 != 0) goto L_0x014a
            com.google.android.gms.measurement.internal.zzfr r0 = r15.zzj()
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzv()
            if (r1 == 0) goto L_0x0142
            java.lang.Class r1 = r1.getClass()
            goto L_0x0144
        L_0x0142:
            java.lang.String r1 = "null"
        L_0x0144:
            java.lang.String r2 = "All ArrayList elements must be of type Bundle. Value type, name"
            r0.zza(r2, r1, r8)
            goto L_0x015d
        L_0x014a:
            r4 = r1
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r15
            r1 = r16
            r2 = r17
            r3 = r18
            r5 = r21
            r6 = r22
            r0.zza((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r3, (android.os.Bundle) r4, (java.util.List<java.lang.String>) r5, (boolean) r6)
            r0 = r14
            goto L_0x0127
        L_0x015d:
            if (r9 == 0) goto L_0x0160
            return r11
        L_0x0160:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznd.zza(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* access modifiers changed from: protected */
    public final boolean zzo() {
        return true;
    }

    /* access modifiers changed from: package-private */
    public final int zza(String str, Object obj) {
        boolean z;
        if ("_ldl".equals(str)) {
            z = zza("user property referrer", str, zzm(str), obj);
        } else {
            z = zza("user property", str, zzm(str), obj);
        }
        return z ? 0 : 7;
    }

    /* access modifiers changed from: package-private */
    public final int zza(String str) {
        if (!zzb("event", str)) {
            return 2;
        }
        if (!zza("event", zzii.zza, zzii.zzb, str)) {
            return 13;
        }
        if (!zza("event", 40, str)) {
            return 2;
        }
        return 0;
    }

    private final int zzk(String str) {
        if (!zzb("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        if (!zza("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    private final int zzl(String str) {
        if (!zzc("event param", str)) {
            return 3;
        }
        if (!zza("event param", (String[]) null, str)) {
            return 14;
        }
        if (!zza("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        if (!zzb("user property", str)) {
            return 6;
        }
        if (!zza("user property", zzij.zza, str)) {
            return 15;
        }
        if (!zza("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    static int zzc() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    @EnsuresNonNull({"this.apkVersion"})
    public final int zzg() {
        if (this.zzh == null) {
            this.zzh = Integer.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(zza()) / 1000);
        }
        return this.zzh.intValue();
    }

    private static int zzm(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        if (!"_lgclid".equals(str) && !"_gbraid".equals(str)) {
            return 36;
        }
        return 100;
    }

    public final int zza(int i) {
        return GoogleApiAvailabilityLight.getInstance().isGooglePlayServicesAvailable(zza(), GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
    }

    /* access modifiers changed from: package-private */
    public final long zzc(String str) {
        if (zza().getPackageManager() == null) {
            return 0;
        }
        int i = 0;
        try {
            ApplicationInfo applicationInfo = Wrappers.packageManager(zza()).getApplicationInfo(str, 0);
            if (applicationInfo != null) {
                i = applicationInfo.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            zzj().zzn().zza("PackageManager failed to find running app: app_id", str);
        }
        return (long) i;
    }

    /* access modifiers changed from: package-private */
    public final long zzh() {
        long j;
        zzt();
        if (!zzd(this.zzu.zzh().zzad())) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j = 8;
        } else {
            j = zzc() < zzbi.zzau.zza(null).intValue() ? 16 : 0;
        }
        if (!zze("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j |= 2;
        }
        if (j == 0 && !zzy()) {
            j |= 64;
        }
        if (j == 0) {
            return 1;
        }
        return j;
    }

    /* access modifiers changed from: package-private */
    public final long zza(Context context, String str) {
        zzt();
        Preconditions.checkNotNull(context);
        Preconditions.checkNotEmpty(str);
        PackageManager packageManager = context.getPackageManager();
        MessageDigest zzu = zzu();
        if (zzu == null) {
            zzj().zzg().zza("Could not get MD5 instance");
            return -1;
        }
        if (packageManager != null) {
            try {
                if (!zzb(context, str)) {
                    PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(zza().getPackageName(), 64);
                    if (packageInfo.signatures != null && packageInfo.signatures.length > 0) {
                        return zza(zzu.digest(packageInfo.signatures[0].toByteArray()));
                    }
                    zzj().zzu().zza("Could not get signatures");
                    return -1;
                }
            } catch (PackageManager.NameNotFoundException e) {
                zzj().zzg().zza("Package name not found", e);
            }
        }
        return 0;
    }

    static long zza(byte[] bArr) {
        Preconditions.checkNotNull(bArr);
        int i = 0;
        Preconditions.checkState(bArr.length > 0);
        long j = 0;
        int length = bArr.length - 1;
        while (length >= 0 && length >= bArr.length - 8) {
            j += (((long) bArr[length]) & 255) << i;
            i += 8;
            length--;
        }
        return j;
    }

    public static long zza(zzbb zzbb) {
        long j = 0;
        if (zzbb == null) {
            return 0;
        }
        Iterator<String> it = zzbb.iterator();
        while (it.hasNext()) {
            Object zzc2 = zzbb.zzc(it.next());
            if (zzc2 instanceof Parcelable[]) {
                j += (long) ((Parcelable[]) zzc2).length;
            }
        }
        return j;
    }

    public final long zzm() {
        long andIncrement;
        long j;
        if (this.zzd.get() == 0) {
            synchronized (this.zzd) {
                long nextLong = new Random(System.nanoTime() ^ zzb().currentTimeMillis()).nextLong();
                int i = this.zze + 1;
                this.zze = i;
                j = nextLong + ((long) i);
            }
            return j;
        }
        synchronized (this.zzd) {
            this.zzd.compareAndSet(-1, 1);
            andIncrement = this.zzd.getAndIncrement();
        }
        return andIncrement;
    }

    public static long zza(long j, long j2) {
        return (j + (j2 * 60000)) / DateUtils.MILLIS_PER_DAY;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Context zza() {
        return super.zza();
    }

    public static Bundle zza(List<zznc> list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        for (zznc next : list) {
            if (next.zzd != null) {
                bundle.putString(next.zza, next.zzd);
            } else if (next.zzc != null) {
                bundle.putLong(next.zza, next.zzc.longValue());
            } else if (next.zzf != null) {
                bundle.putDouble(next.zza, next.zzf.doubleValue());
            }
        }
        return bundle;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zza(Uri uri, boolean z, boolean z2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        Uri uri2 = uri;
        if (uri2 == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                str9 = uri2.getQueryParameter("utm_campaign");
                str8 = uri2.getQueryParameter("utm_source");
                str7 = uri2.getQueryParameter("utm_medium");
                str6 = uri2.getQueryParameter("gclid");
                str5 = z2 ? uri2.getQueryParameter("gbraid") : null;
                str4 = uri2.getQueryParameter("utm_id");
                str3 = uri2.getQueryParameter("dclid");
                str2 = uri2.getQueryParameter("srsltid");
                str = z ? uri2.getQueryParameter("sfmc_id") : null;
            } else {
                str9 = null;
                str8 = null;
                str7 = null;
                str6 = null;
                str5 = null;
                str4 = null;
                str3 = null;
                str2 = null;
                str = null;
            }
            if (TextUtils.isEmpty(str9) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && ((!z2 || TextUtils.isEmpty(str5)) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && (!z || TextUtils.isEmpty(str)))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (!TextUtils.isEmpty(str9)) {
                str10 = "sfmc_id";
                bundle.putString("campaign", str9);
            } else {
                str10 = "sfmc_id";
            }
            if (!TextUtils.isEmpty(str8)) {
                bundle.putString("source", str8);
            }
            if (!TextUtils.isEmpty(str7)) {
                bundle.putString("medium", str7);
            }
            if (!TextUtils.isEmpty(str6)) {
                bundle.putString("gclid", str6);
            }
            if (z2 && !TextUtils.isEmpty(str5)) {
                bundle.putString("gbraid", str5);
            }
            String queryParameter = uri2.getQueryParameter(DynamicLink.GoogleAnalyticsParameters.KEY_UTM_TERM);
            if (!TextUtils.isEmpty(queryParameter)) {
                bundle.putString(FirebaseAnalytics.Param.TERM, queryParameter);
            }
            String queryParameter2 = uri2.getQueryParameter(DynamicLink.GoogleAnalyticsParameters.KEY_UTM_CONTENT);
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("content", queryParameter2);
            }
            String queryParameter3 = uri2.getQueryParameter(FirebaseAnalytics.Param.ACLID);
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString(FirebaseAnalytics.Param.ACLID, queryParameter3);
            }
            String queryParameter4 = uri2.getQueryParameter(FirebaseAnalytics.Param.CP1);
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString(FirebaseAnalytics.Param.CP1, queryParameter4);
            }
            String queryParameter5 = uri2.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("anid", queryParameter5);
            }
            if (!TextUtils.isEmpty(str4)) {
                bundle.putString(FirebaseAnalytics.Param.CAMPAIGN_ID, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                bundle.putString("dclid", str3);
            }
            String queryParameter6 = uri2.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString(FirebaseAnalytics.Param.SOURCE_PLATFORM, queryParameter6);
            }
            String queryParameter7 = uri2.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString(FirebaseAnalytics.Param.CREATIVE_FORMAT, queryParameter7);
            }
            String queryParameter8 = uri2.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString(FirebaseAnalytics.Param.MARKETING_TACTIC, queryParameter8);
            }
            if (!TextUtils.isEmpty(str2)) {
                bundle.putString("srsltid", str2);
            }
            if (z && !TextUtils.isEmpty(str)) {
                bundle.putString(str10, str);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            zzj().zzu().zza("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public static Bundle zza(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final Bundle zzb(Bundle bundle) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str : bundle.keySet()) {
                Object zzb2 = zzb(str, bundle.get(str));
                if (zzb2 == null) {
                    zzj().zzv().zza("Param value can't be null", zzi().zzb(str));
                } else {
                    zza(bundle2, str, zzb2);
                }
            }
        }
        return bundle2;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v0, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zza(java.lang.String r20, java.lang.String r21, android.os.Bundle r22, java.util.List<java.lang.String> r23, boolean r24) {
        /*
            r19 = this;
            r9 = r19
            r10 = r21
            r11 = r22
            r12 = r23
            java.lang.String[] r0 = com.google.android.gms.measurement.internal.zzii.zzd
            boolean r13 = zza((java.lang.String) r10, (java.lang.String[]) r0)
            if (r11 == 0) goto L_0x00ee
            android.os.Bundle r15 = new android.os.Bundle
            r15.<init>(r11)
            com.google.android.gms.measurement.internal.zzaf r0 = r19.zze()
            int r8 = r0.zzg()
            java.util.TreeSet r0 = new java.util.TreeSet
            java.util.Set r1 = r22.keySet()
            r0.<init>(r1)
            java.util.Iterator r16 = r0.iterator()
            r17 = 0
            r18 = r17
        L_0x002e:
            boolean r0 = r16.hasNext()
            if (r0 == 0) goto L_0x00ec
            java.lang.Object r0 = r16.next()
            r7 = r0
            java.lang.String r7 = (java.lang.String) r7
            if (r12 == 0) goto L_0x0047
            boolean r0 = r12.contains(r7)
            if (r0 != 0) goto L_0x0044
            goto L_0x0047
        L_0x0044:
            r0 = r17
            goto L_0x0056
        L_0x0047:
            if (r24 != 0) goto L_0x004e
            int r0 = r9.zzl(r7)
            goto L_0x0050
        L_0x004e:
            r0 = r17
        L_0x0050:
            if (r0 != 0) goto L_0x0056
            int r0 = r9.zzk(r7)
        L_0x0056:
            if (r0 == 0) goto L_0x0066
            r1 = 3
            if (r0 != r1) goto L_0x005d
            r1 = r7
            goto L_0x005e
        L_0x005d:
            r1 = 0
        L_0x005e:
            zza((android.os.Bundle) r15, (int) r0, (java.lang.String) r7, (java.lang.String) r7, (java.lang.Object) r1)
            r15.remove(r7)
            r9 = r8
            goto L_0x00a4
        L_0x0066:
            java.lang.Object r4 = r11.get(r7)
            r0 = r19
            r1 = r20
            r2 = r21
            r3 = r7
            r5 = r15
            r6 = r23
            r14 = r7
            r7 = r24
            r9 = r8
            r8 = r13
            int r0 = r0.zza(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = 17
            if (r0 != r1) goto L_0x0089
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r17)
            zza((android.os.Bundle) r15, (int) r0, (java.lang.String) r14, (java.lang.String) r14, (java.lang.Object) r1)
            goto L_0x00a8
        L_0x0089:
            if (r0 == 0) goto L_0x00a8
            java.lang.String r1 = "_ev"
            boolean r1 = r1.equals(r14)
            if (r1 != 0) goto L_0x00a8
            r1 = 21
            if (r0 != r1) goto L_0x0099
            r7 = r10
            goto L_0x009a
        L_0x0099:
            r7 = r14
        L_0x009a:
            java.lang.Object r1 = r11.get(r14)
            zza((android.os.Bundle) r15, (int) r0, (java.lang.String) r7, (java.lang.String) r14, (java.lang.Object) r1)
            r15.remove(r14)
        L_0x00a4:
            r8 = r9
            r9 = r19
            goto L_0x002e
        L_0x00a8:
            boolean r0 = zzh(r14)
            if (r0 == 0) goto L_0x00a4
            int r0 = r18 + 1
            if (r0 <= r9) goto L_0x00e9
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            java.lang.String r2 = "Event can't contain more than "
            r1.<init>(r2)
            java.lang.StringBuilder r1 = r1.append(r9)
            java.lang.String r2 = " params"
            java.lang.StringBuilder r1 = r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.google.android.gms.measurement.internal.zzfr r2 = r19.zzj()
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzh()
            com.google.android.gms.measurement.internal.zzfq r3 = r19.zzi()
            java.lang.String r3 = r3.zza((java.lang.String) r10)
            com.google.android.gms.measurement.internal.zzfq r4 = r19.zzi()
            java.lang.String r4 = r4.zza((android.os.Bundle) r11)
            r2.zza(r1, r3, r4)
            r1 = 5
            zzb((android.os.Bundle) r15, (int) r1)
            r15.remove(r14)
        L_0x00e9:
            r18 = r0
            goto L_0x00a4
        L_0x00ec:
            r14 = r15
            goto L_0x00ef
        L_0x00ee:
            r14 = 0
        L_0x00ef:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zznd.zza(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final MeasurementManagerFutures zzn() {
        if (this.zzf == null) {
            this.zzf = MeasurementManagerFutures.from(zza());
        }
        return this.zzf;
    }

    @Pure
    public final /* bridge */ /* synthetic */ Clock zzb() {
        return super.zzb();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzae zzd() {
        return super.zzd();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzaf zze() {
        return super.zze();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzba zzf() {
        return super.zzf();
    }

    /* access modifiers changed from: package-private */
    public final zzbg zza(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (zza(str2) == 0) {
            if (bundle == null) {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            Bundle zza2 = zza(str, str2, bundle3, (List<String>) CollectionUtils.listOf("_o"), true);
            if (z) {
                zza2 = zzb(zza2);
            }
            Preconditions.checkNotNull(zza2);
            return new zzbg(str2, new zzbb(zza2), str3, j);
        }
        zzj().zzg().zza("Invalid conditional property event name", zzi().zzc(str2));
        throw new IllegalArgumentException();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzfq zzi() {
        return super.zzi();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzfr zzj() {
        return super.zzj();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgd zzk() {
        return super.zzk();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zzgy zzl() {
        return super.zzl();
    }

    @Pure
    public final /* bridge */ /* synthetic */ zznd zzq() {
        return super.zzq();
    }

    /* access modifiers changed from: package-private */
    public final Object zzb(String str, Object obj) {
        int i;
        if ("_ev".equals(str)) {
            return zza(zze().zzc(this.zzu.zzh().zzad()), obj, true, true);
        }
        if (zzg(str)) {
            i = zze().zzc(this.zzu.zzh().zzad());
        } else {
            i = zze().zzb(this.zzu.zzh().zzad());
        }
        return zza(i, obj, false, true);
    }

    /* access modifiers changed from: package-private */
    public final Object zzc(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return zza(zzm(str), obj, true, false);
        }
        return zza(zzm(str), obj, false, false);
    }

    private final Object zza(int i, Object obj, boolean z, boolean z2) {
        Bundle zzb2;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1 : 0);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return zza(String.valueOf(obj), i, z);
            }
            if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if ((parcelable instanceof Bundle) && (zzb2 = zzb((Bundle) parcelable)) != null && !zzb2.isEmpty()) {
                    arrayList.add(zzb2);
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    /* access modifiers changed from: package-private */
    public final String zzp() {
        byte[] bArr = new byte[16];
        zzv().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    public static String zza(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (!z) {
            return null;
        }
        return str.substring(0, str.offsetByCodePoints(0, i)) + "...";
    }

    public final URL zza(long j, String str, String str2, long j2, String str3) {
        try {
            Preconditions.checkNotEmpty(str2);
            Preconditions.checkNotEmpty(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{Long.valueOf(j), Integer.valueOf(zzg())}), str2, str, Long.valueOf(j2)});
            if (str.equals(zze().zzo())) {
                format = format.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    format = format.concat("&");
                }
                format = format.concat(str3);
            }
            return new URL(format);
        } catch (IllegalArgumentException | MalformedURLException e) {
            zzj().zzg().zza("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    static MessageDigest zzu() {
        int i = 0;
        while (i < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.MD5);
                if (instance != null) {
                    return instance;
                }
                i++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    @EnsuresNonNull({"this.secureRandom"})
    public final SecureRandom zzv() {
        zzt();
        if (this.zzc == null) {
            this.zzc = new SecureRandom();
        }
        return this.zzc;
    }

    public static ArrayList<Bundle> zzb(List<zzad> list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList<Bundle> arrayList = new ArrayList<>(list.size());
        for (zzad next : list) {
            Bundle bundle = new Bundle();
            bundle.putString("app_id", next.zza);
            bundle.putString("origin", next.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, next.zzd);
            bundle.putString("name", next.zzc.zza);
            zzie.zza(bundle, Preconditions.checkNotNull(next.zzc.zza()));
            bundle.putBoolean("active", next.zze);
            if (next.zzf != null) {
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, next.zzf);
            }
            if (next.zzg != null) {
                zzbg zzbg = next.zzg;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, zzbg.zza);
                if (zzbg.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, zzbg.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, next.zzh);
            if (next.zzi != null) {
                zzbg zzbg2 = next.zzi;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, zzbg2.zza);
                if (zzbg2.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, zzbg2.zzb.zzb());
                }
            }
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, next.zzc.zzb);
            bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, next.zzj);
            if (next.zzk != null) {
                zzbg zzbg3 = next.zzk;
                bundle.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, zzbg3.zza);
                if (zzbg3.zzb != null) {
                    bundle.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, zzbg3.zzb.zzb());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    zznd(zzhf zzhf) {
        super(zzhf);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            zzj().zzu().zza("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    private static void zza(Bundle bundle, int i, String str, String str2, Object obj) {
        if (zzb(bundle, i)) {
            bundle.putString("_ev", zza(str, 40, true));
            if (obj != null) {
                Preconditions.checkNotNull(bundle);
                if (obj == null) {
                    return;
                }
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) String.valueOf(obj).length());
                }
            }
        }
    }

    public static void zza(zzki zzki, Bundle bundle, boolean z) {
        if (bundle != null && zzki != null && (!bundle.containsKey("_sc") || z)) {
            if (zzki.zza != null) {
                bundle.putString("_sn", zzki.zza);
            } else {
                bundle.remove("_sn");
            }
            if (zzki.zzb != null) {
                bundle.putString("_sc", zzki.zzb);
            } else {
                bundle.remove("_sc");
            }
            bundle.putLong("_si", zzki.zzc);
        } else if (bundle != null && zzki == null && z) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String str : bundle2.keySet()) {
                if (!bundle.containsKey(str)) {
                    zzq().zza(bundle, str, bundle2.get(str));
                }
            }
        }
    }

    public final /* bridge */ /* synthetic */ void zzr() {
        super.zzr();
    }

    public final /* bridge */ /* synthetic */ void zzs() {
        super.zzs();
    }

    public final /* bridge */ /* synthetic */ void zzt() {
        super.zzt();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Parcelable[] parcelableArr, int i, boolean z) {
        Preconditions.checkNotNull(parcelableArr);
        for (Bundle bundle : parcelableArr) {
            int i2 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (zzh(str) && !zza(str, zzik.zzd) && (i2 = i2 + 1) > i) {
                    if (z) {
                        zzj().zzh().zza("Param can't contain more than " + i + " item-scoped custom parameters", zzi().zzb(str), zzi().zza(bundle));
                        zzb(bundle, 28);
                    } else {
                        zzj().zzh().zza("Param cannot contain item-scoped custom parameters", zzi().zzb(str), zzi().zza(bundle));
                        zzb(bundle, 23);
                    }
                    bundle.remove(str);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzfv zzfv, int i) {
        int i2 = 0;
        for (String str : new TreeSet(zzfv.zzb.keySet())) {
            if (zzh(str) && (i2 = i2 + 1) > i) {
                zzj().zzh().zza("Event can't contain more than " + i + " params", zzi().zza(zzfv.zza), zzi().zza(zzfv.zzb));
                zzb(zzfv.zzb, 5);
                zzfv.zzb.remove(str);
            }
        }
    }

    public static void zza(zznf zznf, int i, String str, String str2, int i2) {
        zza(zznf, (String) null, i, str, str2, i2);
    }

    static void zza(zznf zznf, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        zzb(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", (long) i2);
        }
        zznf.zza(str, "_err", bundle);
    }

    /* access modifiers changed from: protected */
    public final void zzz() {
        zzt();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                zzj().zzu().zza("Utils falling back to Random for random id");
            }
        }
        this.zzd.set(nextLong);
    }

    /* access modifiers changed from: package-private */
    public final void zza(Bundle bundle, String str, Object obj) {
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                zzj().zzv().zza("Not putting event parameter. Invalid value type. name, type", zzi().zzb(str), obj != null ? obj.getClass().getSimpleName() : null);
            }
        }
    }

    public final void zza(zzcv zzcv, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            zzcv.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning boolean value to wrapper", e);
        }
    }

    public final void zza(zzcv zzcv, ArrayList<Bundle> arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            zzcv.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning bundle list to wrapper", e);
        }
    }

    public final void zza(zzcv zzcv, Bundle bundle) {
        try {
            zzcv.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning bundle value to wrapper", e);
        }
    }

    public final void zza(zzcv zzcv, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            zzcv.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning byte array to wrapper", e);
        }
    }

    public final void zza(zzcv zzcv, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            zzcv.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning int value to wrapper", e);
        }
    }

    public final void zza(zzcv zzcv, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            zzcv.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning long value to wrapper", e);
        }
    }

    public final void zza(zzcv zzcv, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            zzcv.zza(bundle);
        } catch (RemoteException e) {
            this.zzu.zzj().zzu().zza("Error returning string value to wrapper", e);
        }
    }

    private final void zza(String str, String str2, String str3, Bundle bundle, List<String> list, boolean z) {
        int i;
        String str4;
        int i2;
        String str5 = str2;
        Bundle bundle2 = bundle;
        List<String> list2 = list;
        if (bundle2 != null) {
            int zzc2 = zze().zzc();
            int i3 = 0;
            for (String str6 : new TreeSet(bundle.keySet())) {
                if (list2 == null || !list2.contains(str6)) {
                    i = !z ? zzl(str6) : 0;
                    if (i == 0) {
                        i = zzk(str6);
                    }
                } else {
                    i = 0;
                }
                if (i != 0) {
                    zza(bundle2, i, str6, str6, (Object) i == 3 ? str6 : null);
                    bundle2.remove(str6);
                } else {
                    if (zza(bundle2.get(str6))) {
                        zzj().zzv().zza("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str5, str3, str6);
                        i2 = 22;
                        str4 = str6;
                    } else {
                        String str7 = str3;
                        str4 = str6;
                        i2 = zza(str, str2, str6, bundle2.get(str6), bundle, list, z, false);
                    }
                    if (i2 != 0 && !"_ev".equals(str4)) {
                        zza(bundle2, i2, str4, str4, bundle2.get(str4));
                        bundle2.remove(str4);
                    } else if (zzh(str4) && !zza(str4, zzik.zzd)) {
                        int i4 = i3 + 1;
                        if (!zza(231100000, true)) {
                            zzj().zzh().zza("Item array not supported on client's version of Google Play Services (Android Only)", zzi().zza(str5), zzi().zza(bundle2));
                            zzb(bundle2, 23);
                            bundle2.remove(str4);
                        } else if (i4 > zzc2) {
                            if (!zzot.zza() || !zze().zza(zzbi.zzcc)) {
                                zzj().zzh().zza("Item cannot contain custom parameters", zzi().zza(str5), zzi().zza(bundle2));
                                zzb(bundle2, 23);
                                bundle2.remove(str4);
                            } else {
                                zzj().zzh().zza("Item can't contain more than " + zzc2 + " item-scoped custom params", zzi().zza(str5), zzi().zza(bundle2));
                                zzb(bundle2, 28);
                                bundle2.remove(str4);
                            }
                        }
                        i3 = i4;
                    }
                }
            }
        }
    }

    private static boolean zzb(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i);
        return true;
    }

    static boolean zzd(String str) {
        String zza2 = zzbi.zzay.zza(null);
        return zza2.equals(ProxyConfig.MATCH_ALL_SCHEMES) || Arrays.asList(zza2.split(",")).contains(str);
    }

    private static boolean zza(String str, String[] strArr) {
        Preconditions.checkNotNull(strArr);
        for (String zza2 : strArr) {
            if (zzng.zza(str, zza2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (zzn(str)) {
                return true;
            }
            if (this.zzu.zzae()) {
                zzj().zzh().zza("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", zzfr.zza(str));
            }
            return false;
        } else if (TextUtils.isEmpty(str2)) {
            if (this.zzu.zzae()) {
                zzj().zzh().zza("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        } else if (zzn(str2)) {
            return true;
        } else {
            zzj().zzh().zza("Invalid admob_app_id. Analytics disabled.", zzfr.zza(str2));
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, int i, String str2) {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        } else {
            zzj().zzh().zza("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String str2) {
        return zza(str, strArr, (String[]) null, str2);
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String[] strArr, String[] strArr2, String str2) {
        boolean z;
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        }
        Preconditions.checkNotNull(str2);
        String[] strArr3 = zza;
        int length = strArr3.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else if (str2.startsWith(strArr3[i])) {
                z = true;
                break;
            } else {
                i++;
            }
        }
        if (z) {
            zzj().zzh().zza("Name starts with reserved prefix. Type, name", str, str2);
            return false;
        } else if (strArr == null || !zza(str2, strArr) || (strArr2 != null && zza(str2, strArr2))) {
            return true;
        } else {
            zzj().zzh().zza("Name is reserved. Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String valueOf = String.valueOf(obj);
            if (valueOf.codePointCount(0, valueOf.length()) > i) {
                zzj().zzv().zza("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(valueOf.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzb(String str, String str2) {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzj().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (Character.isLetter(codePointAt) || codePointAt == 95) {
                int length = str2.length();
                int charCount = Character.charCount(codePointAt);
                while (charCount < length) {
                    int codePointAt2 = str2.codePointAt(charCount);
                    if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                        charCount += Character.charCount(codePointAt2);
                    } else {
                        zzj().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                        return false;
                    }
                }
                return true;
            }
            zzj().zzh().zza("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzc(String str, String str2) {
        if (str2 == null) {
            zzj().zzh().zza("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            zzj().zzh().zza("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                zzj().zzh().zza("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    zzj().zzh().zza("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    static boolean zza(Bundle bundle, int i) {
        int i2 = 0;
        if (bundle.size() <= i) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i2++;
            if (i2 > i) {
                bundle.remove(str);
            }
        }
        return true;
    }

    private final boolean zzy() {
        Integer num;
        Object e;
        if (this.zzg == null) {
            MeasurementManagerFutures zzn = zzn();
            if (zzn == null) {
                return false;
            }
            try {
                num = (Integer) zzn.getMeasurementApiStatusAsync().get(10000, TimeUnit.MILLISECONDS);
                boolean z = true;
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            this.zzg = Boolean.valueOf(z);
                            zzj().zzp().zza("Measurement manager api status result", num);
                        }
                    } catch (CancellationException e2) {
                        e = e2;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = false;
                        zzj().zzp().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (ExecutionException e3) {
                        e = e3;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = false;
                        zzj().zzp().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (InterruptedException e4) {
                        e = e4;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = false;
                        zzj().zzp().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    } catch (TimeoutException e5) {
                        e = e5;
                        zzj().zzu().zza("Measurement manager api exception", e);
                        this.zzg = false;
                        zzj().zzp().zza("Measurement manager api status result", num);
                        return this.zzg.booleanValue();
                    }
                }
                z = false;
                this.zzg = Boolean.valueOf(z);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e6) {
                e = e6;
                num = null;
                zzj().zzu().zza("Measurement manager api exception", e);
                this.zzg = false;
                zzj().zzp().zza("Measurement manager api status result", num);
                return this.zzg.booleanValue();
            }
            zzj().zzp().zza("Measurement manager api status result", num);
        }
        return this.zzg.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean zze(String str) {
        zzt();
        if (Wrappers.packageManager(zza()).checkCallingOrSelfPermission(str) == 0) {
            return true;
        }
        zzj().zzc().zza("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzf(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return zze().zzn().equals(str);
    }

    static boolean zza(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    private final boolean zzb(Context context, String str) {
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(str, 64);
            if (packageInfo == null || packageInfo.signatures == null || packageInfo.signatures.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(packageInfo.signatures[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e) {
            zzj().zzg().zza("Error obtaining certificate", e);
            return true;
        } catch (PackageManager.NameNotFoundException e2) {
            zzj().zzg().zza("Package name not found", e2);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean zzw() {
        zzt();
        return zzh() == 1;
    }

    public final boolean zzx() {
        try {
            zza().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final boolean zza(int i, boolean z) {
        Boolean zzab = this.zzu.zzr().zzab();
        if (zzg() < i / 1000) {
            return zzab != null && !zzab.booleanValue();
        }
        return true;
    }

    static boolean zzg(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    static boolean zzh(String str) {
        Preconditions.checkNotEmpty(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    static boolean zza(Context context) {
        ActivityInfo receiverInfo;
        Preconditions.checkNotNull(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    private static boolean zzc(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean zza(Context context, boolean z) {
        Preconditions.checkNotNull(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return zzc(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return zzc(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    public final boolean zzi(String str) {
        List<ResolveInfo> queryIntentActivities;
        if (!TextUtils.isEmpty(str) && (queryIntentActivities = zza().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0)) != null && !queryIntentActivities.isEmpty()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, double d) {
        try {
            SharedPreferences.Editor edit = zza().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            edit.putString(SDKConstants.PARAM_TOURNAMENTS_DEEPLINK, str);
            edit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return edit.commit();
        } catch (RuntimeException e) {
            zzj().zzg().zza("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    static boolean zza(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean zzj(String str) {
        for (String equals : zzb) {
            if (equals.equals(str)) {
                return false;
            }
        }
        return true;
    }

    static boolean zza(String str, String str2, String str3, String str4) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            Preconditions.checkNotNull(str);
            return !str.equals(str2);
        } else if (isEmpty && isEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        } else {
            if (isEmpty || !isEmpty2) {
                return TextUtils.isEmpty(str3) || !str3.equals(str4);
            }
            if (TextUtils.isEmpty(str4)) {
                return false;
            }
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
    }

    private static boolean zzn(String str) {
        Preconditions.checkNotNull(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    static byte[] zza(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    static Bundle[] zzb(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        } else if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        } else if (!(obj instanceof ArrayList)) {
            return null;
        } else {
            ArrayList arrayList = (ArrayList) obj;
            return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }
}
