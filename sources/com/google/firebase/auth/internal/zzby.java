package com.google.firebase.auth.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.logging.Logger;
import com.google.android.gms.internal.p002firebaseauthapi.zzafm;
import com.google.android.gms.internal.p002firebaseauthapi.zzxv;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuthProvider;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.MultiFactorInfo;
import com.google.firebase.auth.PhoneMultiFactorInfo;
import com.google.firebase.auth.TotpMultiFactorGenerator;
import com.google.firebase.auth.TotpMultiFactorInfo;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: com.google.firebase:firebase-auth@@22.3.1 */
public final class zzby {
    private Context zza;
    private String zzb;
    private SharedPreferences zzc = this.zza.getSharedPreferences(String.format("com.google.firebase.auth.api.Store.%s", new Object[]{this.zzb}), 0);
    private Logger zzd = new Logger("StorageHelpers", new String[0]);

    public final FirebaseUser zza() {
        String string = this.zzc.getString("com.google.firebase.auth.FIREBASE_USER", (String) null);
        if (TextUtils.isEmpty(string)) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject(string);
            if (jSONObject.has("type") && "com.google.firebase.auth.internal.DefaultFirebaseUser".equalsIgnoreCase(jSONObject.optString("type"))) {
                return zza(jSONObject);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzafm zza(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String string = this.zzc.getString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), (String) null);
        if (string != null) {
            return zzafm.zzb(string);
        }
        return null;
    }

    private final zzaf zza(JSONObject jSONObject) {
        JSONArray jSONArray;
        Object obj;
        zzah zza2;
        try {
            String string = jSONObject.getString("cachedTokenState");
            String string2 = jSONObject.getString("applicationName");
            boolean z = jSONObject.getBoolean("anonymous");
            String str = ExifInterface.GPS_MEASUREMENT_2D;
            String string3 = jSONObject.getString("version");
            if (string3 != null) {
                str = string3;
            }
            JSONArray jSONArray2 = jSONObject.getJSONArray("userInfos");
            int length = jSONArray2.length();
            if (length == 0) {
                return null;
            }
            ArrayList arrayList = new ArrayList(length);
            for (int i = 0; i < length; i++) {
                arrayList.add(zzab.zza(jSONArray2.getString(i)));
            }
            zzaf zzaf = new zzaf(FirebaseApp.getInstance(string2), arrayList);
            if (!TextUtils.isEmpty(string)) {
                zzaf.zza(zzafm.zzb(string));
            }
            if (!z) {
                zzaf.zzb();
            }
            zzaf.zza(str);
            if (jSONObject.has("userMetadata") && (zza2 = zzah.zza(jSONObject.getJSONObject("userMetadata"))) != null) {
                zzaf.zza(zza2);
            }
            if (jSONObject.has("userMultiFactorInfo") && (jSONArray = jSONObject.getJSONArray("userMultiFactorInfo")) != null) {
                ArrayList arrayList2 = new ArrayList();
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject2 = new JSONObject(jSONArray.getString(i2));
                    String optString = jSONObject2.optString(MultiFactorInfo.FACTOR_ID_KEY);
                    if ("phone".equals(optString)) {
                        obj = PhoneMultiFactorInfo.zza(jSONObject2);
                    } else {
                        obj = Objects.equals(optString, TotpMultiFactorGenerator.FACTOR_ID) ? TotpMultiFactorInfo.zza(jSONObject2) : null;
                    }
                    arrayList2.add(obj);
                }
                zzaf.zzb(arrayList2);
            }
            return zzaf;
        } catch (zzxv | ArrayIndexOutOfBoundsException | IllegalArgumentException | JSONException e) {
            this.zzd.wtf(e);
            return null;
        }
    }

    private final String zzc(FirebaseUser firebaseUser) {
        JSONObject jSONObject = new JSONObject();
        if (!zzaf.class.isAssignableFrom(firebaseUser.getClass())) {
            return null;
        }
        zzaf zzaf = (zzaf) firebaseUser;
        try {
            jSONObject.put("cachedTokenState", (Object) zzaf.zze());
            jSONObject.put("applicationName", (Object) zzaf.zza().getName());
            jSONObject.put("type", (Object) "com.google.firebase.auth.internal.DefaultFirebaseUser");
            if (zzaf.zzi() != null) {
                JSONArray jSONArray = new JSONArray();
                List<zzab> zzi = zzaf.zzi();
                int size = zzi.size();
                if (zzi.size() > 30) {
                    this.zzd.w("Provider user info list size larger than max size, truncating list to %d. Actual list size: %d", 30, Integer.valueOf(zzi.size()));
                    size = 30;
                }
                boolean z = false;
                for (int i = 0; i < size; i++) {
                    zzab zzab = zzi.get(i);
                    if (zzab.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                        z = true;
                    }
                    if (i == size - 1 && !z) {
                        break;
                    }
                    jSONArray.put((Object) zzab.zzb());
                }
                if (!z) {
                    int i2 = size - 1;
                    while (true) {
                        if (i2 >= zzi.size() || i2 < 0) {
                            break;
                        }
                        zzab zzab2 = zzi.get(i2);
                        if (zzab2.getProviderId().equals(FirebaseAuthProvider.PROVIDER_ID)) {
                            jSONArray.put((Object) zzab2.zzb());
                            z = true;
                            break;
                        }
                        if (i2 == zzi.size() - 1) {
                            jSONArray.put((Object) zzab2.zzb());
                        }
                        i2++;
                    }
                    if (!z) {
                        this.zzd.w("Malformed user object! No Firebase Auth provider id found. Provider user info list size: %d, trimmed size: %d", Integer.valueOf(zzi.size()), Integer.valueOf(size));
                        if (zzi.size() < 5) {
                            StringBuilder sb = new StringBuilder("Provider user info list:\n");
                            for (zzab providerId : zzi) {
                                sb.append(String.format("Provider - %s\n", new Object[]{providerId.getProviderId()}));
                            }
                            this.zzd.w(sb.toString(), new Object[0]);
                        }
                    }
                }
                jSONObject.put("userInfos", (Object) jSONArray);
            }
            jSONObject.put("anonymous", zzaf.isAnonymous());
            jSONObject.put("version", (Object) ExifInterface.GPS_MEASUREMENT_2D);
            if (zzaf.getMetadata() != null) {
                jSONObject.put("userMetadata", (Object) ((zzah) zzaf.getMetadata()).zza());
            }
            List<MultiFactorInfo> enrolledFactors = ((zzaj) zzaf.getMultiFactor()).getEnrolledFactors();
            if (enrolledFactors != null && !enrolledFactors.isEmpty()) {
                JSONArray jSONArray2 = new JSONArray();
                for (int i3 = 0; i3 < enrolledFactors.size(); i3++) {
                    jSONArray2.put((Object) enrolledFactors.get(i3).toJson());
                }
                jSONObject.put("userMultiFactorInfo", (Object) jSONArray2);
            }
            return jSONObject.toString();
        } catch (Exception e) {
            this.zzd.wtf("Failed to turn object into JSON", e, new Object[0]);
            throw new zzxv(e);
        }
    }

    public zzby(Context context, String str) {
        Preconditions.checkNotNull(context);
        this.zzb = Preconditions.checkNotEmpty(str);
        this.zza = context.getApplicationContext();
    }

    public final void zza(String str) {
        this.zzc.edit().remove(str).apply();
    }

    public final void zzb(FirebaseUser firebaseUser) {
        Preconditions.checkNotNull(firebaseUser);
        String zzc2 = zzc(firebaseUser);
        if (!TextUtils.isEmpty(zzc2)) {
            this.zzc.edit().putString("com.google.firebase.auth.FIREBASE_USER", zzc2).apply();
        }
    }

    public final void zza(FirebaseUser firebaseUser, zzafm zzafm) {
        Preconditions.checkNotNull(firebaseUser);
        Preconditions.checkNotNull(zzafm);
        this.zzc.edit().putString(String.format("com.google.firebase.auth.GET_TOKEN_RESPONSE.%s", new Object[]{firebaseUser.getUid()}), zzafm.zzf()).apply();
    }
}
