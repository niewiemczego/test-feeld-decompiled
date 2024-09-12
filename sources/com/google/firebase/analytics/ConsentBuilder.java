package com.google.firebase.analytics;

import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00040\u0013R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0015"}, d2 = {"Lcom/google/firebase/analytics/ConsentBuilder;", "", "()V", "adPersonalization", "Lcom/google/firebase/analytics/FirebaseAnalytics$ConsentStatus;", "getAdPersonalization", "()Lcom/google/firebase/analytics/FirebaseAnalytics$ConsentStatus;", "setAdPersonalization", "(Lcom/google/firebase/analytics/FirebaseAnalytics$ConsentStatus;)V", "adStorage", "getAdStorage", "setAdStorage", "adUserData", "getAdUserData", "setAdUserData", "analyticsStorage", "getAnalyticsStorage", "setAnalyticsStorage", "asMap", "", "Lcom/google/firebase/analytics/FirebaseAnalytics$ConsentType;", "java.com.google.android.gmscore.integ.client.measurement_api_measurement_api"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* compiled from: com.google.android.gms:play-services-measurement-api@@21.5.0 */
public final class ConsentBuilder {
    private FirebaseAnalytics.ConsentStatus zza;
    private FirebaseAnalytics.ConsentStatus zzb;
    private FirebaseAnalytics.ConsentStatus zzc;
    private FirebaseAnalytics.ConsentStatus zzd;

    public final FirebaseAnalytics.ConsentStatus getAdPersonalization() {
        return this.zzd;
    }

    public final FirebaseAnalytics.ConsentStatus getAdStorage() {
        return this.zza;
    }

    public final FirebaseAnalytics.ConsentStatus getAdUserData() {
        return this.zzc;
    }

    public final FirebaseAnalytics.ConsentStatus getAnalyticsStorage() {
        return this.zzb;
    }

    public final Map<FirebaseAnalytics.ConsentType, FirebaseAnalytics.ConsentStatus> asMap() {
        Map<FirebaseAnalytics.ConsentType, FirebaseAnalytics.ConsentStatus> linkedHashMap = new LinkedHashMap<>();
        FirebaseAnalytics.ConsentStatus consentStatus = this.zza;
        if (consentStatus != null) {
            linkedHashMap.put(FirebaseAnalytics.ConsentType.AD_STORAGE, consentStatus);
        }
        FirebaseAnalytics.ConsentStatus consentStatus2 = this.zzb;
        if (consentStatus2 != null) {
            linkedHashMap.put(FirebaseAnalytics.ConsentType.ANALYTICS_STORAGE, consentStatus2);
        }
        FirebaseAnalytics.ConsentStatus consentStatus3 = this.zzc;
        if (consentStatus3 != null) {
            linkedHashMap.put(FirebaseAnalytics.ConsentType.AD_USER_DATA, consentStatus3);
        }
        FirebaseAnalytics.ConsentStatus consentStatus4 = this.zzd;
        if (consentStatus4 != null) {
            linkedHashMap.put(FirebaseAnalytics.ConsentType.AD_PERSONALIZATION, consentStatus4);
        }
        return linkedHashMap;
    }

    public final void setAdPersonalization(FirebaseAnalytics.ConsentStatus consentStatus) {
        this.zzd = consentStatus;
    }

    public final void setAdStorage(FirebaseAnalytics.ConsentStatus consentStatus) {
        this.zza = consentStatus;
    }

    public final void setAdUserData(FirebaseAnalytics.ConsentStatus consentStatus) {
        this.zzc = consentStatus;
    }

    public final void setAnalyticsStorage(FirebaseAnalytics.ConsentStatus consentStatus) {
        this.zzb = consentStatus;
    }
}
