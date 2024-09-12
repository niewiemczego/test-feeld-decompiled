package io.seon.androidsdk.service;

import android.content.Context;
import com.launchdarkly.sdk.android.LDConfig;
import io.seon.androidsdk.logger.Logger;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;

class LocaleProbe extends AbstractSeonProbe {
    static final String[] b = {"region_country", "region_language", "region_timezone", "timezone_identifier"};
    private static final Logger c = Logger.withClass(LocaleProbe.class);
    private Context a;

    LocaleProbe() {
    }

    /* access modifiers changed from: private */
    public String a() {
        try {
            return TimeZone.getDefault().getID();
        } catch (Exception unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public String b() {
        return this.a.getResources().getConfiguration().locale.getCountry();
    }

    /* access modifiers changed from: private */
    public String c() {
        return Locale.getDefault().getLanguage();
    }

    /* access modifiers changed from: private */
    public String d() {
        TimeZone timeZone = TimeZone.getDefault();
        int offset = timeZone.getOffset(Calendar.getInstance(timeZone).getTimeInMillis());
        return (offset >= 0 ? "+" : "-") + String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(Math.abs(offset / LDConfig.DEFAULT_BACKGROUND_POLL_INTERVAL_MILLIS)), Integer.valueOf(Math.abs((offset / 60000) % 60))});
    }

    public void bootstrap(Context context) {
        this.a = context;
    }

    public Map getExperimentalFields() {
        return null;
    }

    public Map scan() {
        HashMap hashMap = new HashMap();
        hashMap.put("region_country", safeGet(new LocaleProbe$$ExternalSyntheticLambda0(this)));
        hashMap.put("region_language", safeGet(new LocaleProbe$$ExternalSyntheticLambda1(this)));
        hashMap.put("region_timezone", safeGet(new LocaleProbe$$ExternalSyntheticLambda2(this)));
        hashMap.put("timezone_identifier", safeGet(new LocaleProbe$$ExternalSyntheticLambda3(this)));
        return hashMap;
    }
}
