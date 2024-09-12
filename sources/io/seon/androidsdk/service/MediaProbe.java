package io.seon.androidsdk.service;

import android.accessibilityservice.AccessibilityServiceInfo;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.hardware.display.DisplayManager;
import android.media.AudioManager;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaDrm;
import android.media.UnsupportedSchemeException;
import android.os.Build;
import android.view.Display;
import android.view.accessibility.AccessibilityManager;
import io.seon.androidsdk.logger.Logger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.codec.digest.MessageDigestAlgorithms;

class MediaProbe extends AbstractSeonProbe {
    static final String[] g = {"audio_mute_status", "audio_volume_current", "is_remote_control_connected", "remote_control_provider", "is_screen_being_mirrored", "is_click_automator_installed", "enabled_accessibility_apps", "interfering_apps", "media_drm_id"};
    private static final Logger h = Logger.withClass(MediaProbe.class);
    private static final UUID i = new UUID(-1301668207276963122L, -6645017420763422227L);
    private static final UUID j;
    private static final UUID k;
    private static final UUID l;
    private static final ArrayList m;
    final int a = 900;
    AccessibilityManager b;
    DisplayManager c;
    PackageManager d;
    boolean e = false;
    private Context f;

    class SeonAccessibilityAppList {
        ArrayList a;
        ArrayList b;

        SeonAccessibilityAppList(ArrayList arrayList, ArrayList arrayList2) {
            this.a = arrayList;
            this.b = arrayList2;
        }
    }

    static {
        UUID uuid = new UUID(1186680826959645954L, -5988876978535335093L);
        j = uuid;
        UUID uuid2 = new UUID(-2129748144642739255L, 8654423357094679310L);
        k = uuid2;
        UUID uuid3 = new UUID(-7348484286925749626L, -6083546864340672619L);
        l = uuid3;
        m = new ArrayList(Arrays.asList(new UUID[]{uuid, uuid2, uuid3}));
    }

    MediaProbe() {
    }

    /* access modifiers changed from: private */
    public String d() {
        StringBuilder sb = new StringBuilder();
        int codecCount = MediaCodecList.getCodecCount();
        for (int i2 = 0; i2 < codecCount; i2++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
            sb.append(codecInfoAt.getName()).append(Arrays.asList((String[]) codecInfoAt.getSupportedTypes().clone()));
        }
        try {
            String sb2 = sb.toString();
            if (sb2.equals("")) {
                return null;
            }
            if (sb2.trim().equals("")) {
                return null;
            }
            return SeonUtil.b(sb2);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public int f() {
        return (int) ((((double) a(this.f).getStreamVolume(3)) / ((double) a(this.f, 3))) * 100.0d);
    }

    public static String g() {
        return a(i);
    }

    /* access modifiers changed from: private */
    public boolean i() {
        return a(this.f).getRingerMode() != 2;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s() {
        this.b = (AccessibilityManager) this.f.getSystemService("accessibility");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.c = (DisplayManager) this.f.getSystemService("display");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u() {
        this.d = this.f.getPackageManager();
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return this.e;
    }

    /* access modifiers changed from: package-private */
    public ArrayList b() {
        SeonAccessibilityAppList l2 = l();
        if (l2 == null) {
            return null;
        }
        return l2.b;
    }

    public void bootstrap(Context context) {
        this.f = context;
        SeonUtil.a((Runnable) new MediaProbe$$ExternalSyntheticLambda9(this));
    }

    /* access modifiers changed from: package-private */
    public int c() {
        return MediaCodecList.getCodecCount();
    }

    /* access modifiers changed from: package-private */
    public Display[] e() {
        try {
            return this.c.getDisplays();
        } catch (Exception unused) {
            return null;
        }
    }

    public Map getExperimentalFields() {
        HashMap hashMap = new HashMap();
        hashMap.put("codec_count", safeGet(new MediaProbe$$ExternalSyntheticLambda0(this)));
        hashMap.put("codec_hash", safeGet(new MediaProbe$$ExternalSyntheticLambda7(this)));
        hashMap.put("is_accessibility_info_sliced", safeGet(new MediaProbe$$ExternalSyntheticLambda8(this)));
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    public List h() {
        try {
            return this.b.getEnabledAccessibilityServiceList(-1);
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public ArrayList j() {
        SeonAccessibilityAppList l2 = l();
        if (l2 == null) {
            return null;
        }
        return l2.a;
    }

    /* access modifiers changed from: package-private */
    public String k() {
        try {
            if (r().booleanValue()) {
                return "TeamViewer";
            }
            if (n().booleanValue()) {
                return "AnyDesk";
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public SeonAccessibilityAppList l() {
        String str;
        ApplicationInfo applicationInfo;
        List<AccessibilityServiceInfo> h2 = h();
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int i2 = 0;
        this.e = false;
        if (h2 == null) {
            return null;
        }
        for (AccessibilityServiceInfo accessibilityServiceInfo : h2) {
            try {
                ServiceInfo serviceInfo = accessibilityServiceInfo.getResolveInfo().serviceInfo;
                ProviderInfo providerInfo = accessibilityServiceInfo.getResolveInfo().providerInfo;
                ActivityInfo activityInfo = accessibilityServiceInfo.getResolveInfo().activityInfo;
                if (serviceInfo != null) {
                    String replace = serviceInfo.toString().replace("ServiceInfo{", "").replace("}", "");
                    ApplicationInfo applicationInfo2 = serviceInfo.applicationInfo;
                    str = replace;
                    applicationInfo = applicationInfo2;
                } else if (providerInfo == null) {
                    str = activityInfo.toString().replace("ActivityInfo{", "").replace("}", "");
                    applicationInfo = activityInfo.applicationInfo;
                } else {
                    str = providerInfo.toString().replace("ProviderInfo{", "").replace("}", "");
                    applicationInfo = providerInfo.applicationInfo;
                }
                if (str.contains(" ")) {
                    str = str.split(" ")[1];
                }
                PackageManager packageManager = this.d;
                if (packageManager != null) {
                    arrayList2.add((String) packageManager.getApplicationLabel(applicationInfo));
                }
                if (str.length() + i2 > 900) {
                    this.e = true;
                } else {
                    arrayList.add(str);
                    i2 += str.length();
                }
            } catch (Exception unused) {
            }
        }
        return new SeonAccessibilityAppList(arrayList2, arrayList);
    }

    /* access modifiers changed from: package-private */
    public void m() {
        SeonUtil.a((Runnable) new MediaProbe$$ExternalSyntheticLambda4(this));
        SeonUtil.a((Runnable) new MediaProbe$$ExternalSyntheticLambda5(this));
        SeonUtil.a((Runnable) new MediaProbe$$ExternalSyntheticLambda6(this));
    }

    /* access modifiers changed from: package-private */
    public Boolean n() {
        return Boolean.valueOf(b("screencap").booleanValue() && a("com.anydesk").booleanValue());
    }

    /* access modifiers changed from: package-private */
    public Boolean o() {
        try {
            String[] strArr = {"autoclicker", "com.speed.gc.autoclicker", "com.applisto.appcloner", "com.opautoclicker", "paditech.autoclicker", "autoclickerforgames", "quocguyen.autoclicker", "com.inscode.autoclicker"};
            for (int i2 = 0; i2 < 8; i2++) {
                if (a(strArr[i2]).booleanValue()) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: package-private */
    public Boolean p() {
        boolean z;
        try {
            if (!n().booleanValue()) {
                if (!r().booleanValue()) {
                    z = false;
                    return Boolean.valueOf(z);
                }
            }
            z = true;
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: package-private */
    public Boolean q() {
        try {
            boolean z = true;
            if (e().length <= 1) {
                z = false;
            }
            return Boolean.valueOf(z);
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    /* access modifiers changed from: package-private */
    public Boolean r() {
        return b("teamviewer");
    }

    public Map scan() {
        HashMap hashMap = new HashMap();
        hashMap.put("audio_mute_status", safeGet(new MediaProbe$$ExternalSyntheticLambda10(this)));
        hashMap.put("audio_volume_current", safeGet(new MediaProbe$$ExternalSyntheticLambda11(this)));
        hashMap.put("is_remote_control_connected", safeGet(new MediaProbe$$ExternalSyntheticLambda12(this)));
        hashMap.put("remote_control_provider", safeGet(new MediaProbe$$ExternalSyntheticLambda13(this)));
        hashMap.put("is_screen_being_mirrored", safeGet(new MediaProbe$$ExternalSyntheticLambda14(this)));
        hashMap.put("is_click_automator_installed", safeGet(new MediaProbe$$ExternalSyntheticLambda15(this)));
        hashMap.put("enabled_accessibility_apps", safeGet(new MediaProbe$$ExternalSyntheticLambda1(this)));
        hashMap.put("interfering_apps", safeGet(new MediaProbe$$ExternalSyntheticLambda2(this)));
        hashMap.put("media_drm_id", safeGet(new MediaProbe$$ExternalSyntheticLambda3()));
        return hashMap;
    }

    private AudioManager a(Context context) {
        return (AudioManager) context.getSystemService("audio");
    }

    /* access modifiers changed from: package-private */
    public Boolean b(String str) {
        try {
            for (Display name : e()) {
                if (name.getName().contains(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }

    private static String a(UUID uuid) {
        try {
            MediaDrm mediaDrm = new MediaDrm(uuid);
            if (Build.VERSION.SDK_INT >= 30) {
                for (UUID uuid2 : MediaDrm.getSupportedCryptoSchemes()) {
                    ArrayList arrayList = m;
                    if (!arrayList.contains(uuid2)) {
                        arrayList.add(uuid2);
                    }
                }
            }
            byte[] propertyByteArray = mediaDrm.getPropertyByteArray("deviceUniqueId");
            if (Build.VERSION.SDK_INT >= 28) {
                mediaDrm.close();
            } else {
                mediaDrm.release();
            }
            try {
                MessageDigest instance = MessageDigest.getInstance(MessageDigestAlgorithms.SHA_256);
                instance.update(propertyByteArray);
                return SeonUtil.b(instance.digest());
            } catch (NoSuchAlgorithmException e2) {
                h.withCause(e2, 6);
                return null;
            }
        } catch (UnsupportedSchemeException unused) {
            ArrayList arrayList2 = m;
            if (arrayList2.size() > 0) {
                arrayList2.trimToSize();
                a((UUID) arrayList2.remove(0));
            }
        } catch (Exception e3) {
            h.withCause(e3);
        }
    }

    private int a(Context context, int i2) {
        return a(context).getStreamMaxVolume(i2);
    }

    /* access modifiers changed from: package-private */
    public Boolean a(String str) {
        try {
            for (AccessibilityServiceInfo resolveInfo : h()) {
                if (resolveInfo.getResolveInfo().toString().contains(str)) {
                    return Boolean.TRUE;
                }
            }
            return Boolean.FALSE;
        } catch (Exception unused) {
            return Boolean.FALSE;
        }
    }
}
