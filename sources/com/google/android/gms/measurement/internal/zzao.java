package com.google.android.gms.measurement.internal;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextUtils;
import androidx.collection.ArrayMap;
import androidx.webkit.ProxyConfig;
import com.adapty.internal.crossplatform.AdaptyPaywallTypeAdapterFactory;
import com.adapty.internal.utils.AnalyticsEventTypeAdapter;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.measurement.zzew;
import com.google.android.gms.internal.measurement.zzfi;
import com.google.android.gms.internal.measurement.zzix;
import com.google.android.gms.internal.measurement.zznk;
import com.google.android.gms.internal.measurement.zznp;
import com.google.android.gms.internal.measurement.zznq;
import com.google.android.gms.internal.measurement.zzpg;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.dynamiclinks.DynamicLink;
import io.sentry.protocol.App;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: com.google.android.gms:play-services-measurement@@21.5.0 */
final class zzao extends zzmo {
    /* access modifiers changed from: private */
    public static final String[] zza = {"last_bundled_timestamp", "ALTER TABLE events ADD COLUMN last_bundled_timestamp INTEGER;", "last_bundled_day", "ALTER TABLE events ADD COLUMN last_bundled_day INTEGER;", "last_sampled_complex_event_id", "ALTER TABLE events ADD COLUMN last_sampled_complex_event_id INTEGER;", "last_sampling_rate", "ALTER TABLE events ADD COLUMN last_sampling_rate INTEGER;", "last_exempt_from_sampling", "ALTER TABLE events ADD COLUMN last_exempt_from_sampling INTEGER;", "current_session_count", "ALTER TABLE events ADD COLUMN current_session_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzb = {"origin", "ALTER TABLE user_attributes ADD COLUMN origin TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzc = {App.JsonKeys.APP_VERSION, "ALTER TABLE apps ADD COLUMN app_version TEXT;", "app_store", "ALTER TABLE apps ADD COLUMN app_store TEXT;", "gmp_version", "ALTER TABLE apps ADD COLUMN gmp_version INTEGER;", "dev_cert_hash", "ALTER TABLE apps ADD COLUMN dev_cert_hash INTEGER;", "measurement_enabled", "ALTER TABLE apps ADD COLUMN measurement_enabled INTEGER;", "last_bundle_start_timestamp", "ALTER TABLE apps ADD COLUMN last_bundle_start_timestamp INTEGER;", "day", "ALTER TABLE apps ADD COLUMN day INTEGER;", "daily_public_events_count", "ALTER TABLE apps ADD COLUMN daily_public_events_count INTEGER;", "daily_events_count", "ALTER TABLE apps ADD COLUMN daily_events_count INTEGER;", "daily_conversions_count", "ALTER TABLE apps ADD COLUMN daily_conversions_count INTEGER;", AdaptyPaywallTypeAdapterFactory.REMOTE_CONFIG, "ALTER TABLE apps ADD COLUMN remote_config BLOB;", "config_fetched_time", "ALTER TABLE apps ADD COLUMN config_fetched_time INTEGER;", "failed_config_fetch_time", "ALTER TABLE apps ADD COLUMN failed_config_fetch_time INTEGER;", "app_version_int", "ALTER TABLE apps ADD COLUMN app_version_int INTEGER;", "firebase_instance_id", "ALTER TABLE apps ADD COLUMN firebase_instance_id TEXT;", "daily_error_events_count", "ALTER TABLE apps ADD COLUMN daily_error_events_count INTEGER;", "daily_realtime_events_count", "ALTER TABLE apps ADD COLUMN daily_realtime_events_count INTEGER;", "health_monitor_sample", "ALTER TABLE apps ADD COLUMN health_monitor_sample TEXT;", "android_id", "ALTER TABLE apps ADD COLUMN android_id INTEGER;", "adid_reporting_enabled", "ALTER TABLE apps ADD COLUMN adid_reporting_enabled INTEGER;", "ssaid_reporting_enabled", "ALTER TABLE apps ADD COLUMN ssaid_reporting_enabled INTEGER;", "admob_app_id", "ALTER TABLE apps ADD COLUMN admob_app_id TEXT;", "linked_admob_app_id", "ALTER TABLE apps ADD COLUMN linked_admob_app_id TEXT;", "dynamite_version", "ALTER TABLE apps ADD COLUMN dynamite_version INTEGER;", "safelisted_events", "ALTER TABLE apps ADD COLUMN safelisted_events TEXT;", "ga_app_id", "ALTER TABLE apps ADD COLUMN ga_app_id TEXT;", "config_last_modified_time", "ALTER TABLE apps ADD COLUMN config_last_modified_time TEXT;", "e_tag", "ALTER TABLE apps ADD COLUMN e_tag TEXT;", "session_stitching_token", "ALTER TABLE apps ADD COLUMN session_stitching_token TEXT;", "sgtm_upload_enabled", "ALTER TABLE apps ADD COLUMN sgtm_upload_enabled INTEGER;", "target_os_version", "ALTER TABLE apps ADD COLUMN target_os_version INTEGER;", "session_stitching_token_hash", "ALTER TABLE apps ADD COLUMN session_stitching_token_hash INTEGER;", "ad_services_version", "ALTER TABLE apps ADD COLUMN ad_services_version INTEGER;", "unmatched_first_open_without_ad_id", "ALTER TABLE apps ADD COLUMN unmatched_first_open_without_ad_id INTEGER;", "npa_metadata_value", "ALTER TABLE apps ADD COLUMN npa_metadata_value INTEGER;", "attribution_eligibility_status", "ALTER TABLE apps ADD COLUMN attribution_eligibility_status INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzd = {"realtime", "ALTER TABLE raw_events ADD COLUMN realtime INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zze = {"has_realtime", "ALTER TABLE queue ADD COLUMN has_realtime INTEGER;", "retry_count", "ALTER TABLE queue ADD COLUMN retry_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzg = {"session_scoped", "ALTER TABLE event_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzh = {"session_scoped", "ALTER TABLE property_filters ADD COLUMN session_scoped BOOLEAN;"};
    /* access modifiers changed from: private */
    public static final String[] zzi = {"previous_install_count", "ALTER TABLE app2 ADD COLUMN previous_install_count INTEGER;"};
    /* access modifiers changed from: private */
    public static final String[] zzj = {"consent_source", "ALTER TABLE consent_settings ADD COLUMN consent_source INTEGER;", "dma_consent_settings", "ALTER TABLE consent_settings ADD COLUMN dma_consent_settings TEXT;"};
    /* access modifiers changed from: private */
    public static final String[] zzk = {"idempotent", "CREATE INDEX IF NOT EXISTS trigger_uris_index ON trigger_uris (app_id);"};
    private final zzau zzl = new zzau(this, zza(), "google_app_measurement.db");
    /* access modifiers changed from: private */
    public final zzmi zzm = new zzmi(zzb());

    public final int zza(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            return e_().delete("conditional_properties", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting conditional property", zzfr.zza(str), zzi().zzc(str2), e);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zzc() {
        return false;
    }

    public final long zza(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        try {
            return (long) e_().delete("raw_events", "rowid in (select rowid from raw_events where app_id=? order by rowid desc limit -1 offset ?)", new String[]{str, String.valueOf(Math.max(0, Math.min(1000000, zze().zzb(str, zzbi.zzp))))});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting over the limit events. appId", zzfr.zza(str), e);
            return 0;
        }
    }

    public final long b_() {
        Cursor cursor = null;
        try {
            cursor = e_().rawQuery("select rowid from raw_events order by rowid desc limit 1;", (String[]) null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return -1;
            }
            long j = cursor.getLong(0);
            if (cursor != null) {
                cursor.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying raw events", e);
            if (cursor != null) {
                cursor.close();
            }
            return -1;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final long zza(zzfi.zzj zzj2) throws IOException {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzj2);
        Preconditions.checkNotEmpty(zzj2.zzx());
        byte[] zzbv = zzj2.zzbv();
        long zza2 = g_().zza(zzbv);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzj2.zzx());
        contentValues.put("metadata_fingerprint", Long.valueOf(zza2));
        contentValues.put(TtmlNode.TAG_METADATA, zzbv);
        try {
            e_().insertWithOnConflict("raw_events_metadata", (String) null, contentValues, 4);
            return zza2;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event metadata. appId", zzfr.zza(zzj2.zzx()), e);
            throw e;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    public final long zzb(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        SQLiteDatabase e_ = e_();
        e_.beginTransaction();
        long j = 0;
        try {
            long zza2 = zza("select " + str2 + " from app2 where app_id=?", new String[]{str}, -1);
            if (zza2 == -1) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("app_id", str);
                contentValues.put("first_open_count", 0);
                contentValues.put("previous_install_count", 0);
                if (e_.insertWithOnConflict("app2", (String) null, contentValues, 5) == -1) {
                    zzj().zzg().zza("Failed to insert column (got -1). appId", zzfr.zza(str), str2);
                    e_.endTransaction();
                    return -1;
                }
                zza2 = 0;
            }
            try {
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("app_id", str);
                contentValues2.put(str2, Long.valueOf(1 + zza2));
                if (((long) e_.update("app2", contentValues2, "app_id = ?", new String[]{str})) == 0) {
                    zzj().zzg().zza("Failed to update column (got 0). appId", zzfr.zza(str), str2);
                    e_.endTransaction();
                    return -1;
                }
                e_.setTransactionSuccessful();
                e_.endTransaction();
                return zza2;
            } catch (SQLiteException e) {
                e = e;
                j = zza2;
                try {
                    zzj().zzg().zza("Error inserting column. appId", zzfr.zza(str), str2, e);
                    e_.endTransaction();
                    return j;
                } catch (Throwable th) {
                    e_.endTransaction();
                    throw th;
                }
            }
        } catch (SQLiteException e2) {
            e = e2;
            zzj().zzg().zza("Error inserting column. appId", zzfr.zza(str), str2, e);
            e_.endTransaction();
            return j;
        }
    }

    public final long c_() {
        return zza("select max(bundle_end_timestamp) from queue", (String[]) null, 0);
    }

    public final long d_() {
        return zza("select max(timestamp) from raw_events", (String[]) null, 0);
    }

    public final long zzb(String str) {
        Preconditions.checkNotEmpty(str);
        return zza("select count(1) from events where app_id=? and name not like '!_%' escape '!'", new String[]{str}, 0);
    }

    private final long zzb(String str, String[] strArr) {
        Cursor cursor = null;
        try {
            cursor = e_().rawQuery(str, strArr);
            if (cursor.moveToFirst()) {
                long j = cursor.getLong(0);
                if (cursor != null) {
                    cursor.close();
                }
                return j;
            }
            throw new SQLiteException("Database returned empty set");
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    private final long zza(String str, String[] strArr, long j) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = e_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                long j2 = rawQuery.getLong(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return j2;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return j;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final SQLiteDatabase e_() {
        zzt();
        try {
            return this.zzl.getWritableDatabase();
        } catch (SQLiteException e) {
            zzj().zzu().zza("Error opening database", e);
            throw e;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d1  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00d9  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle zzc(java.lang.String r8) {
        /*
            r7 = this;
            r7.zzt()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.e_()     // Catch:{ SQLiteException -> 0x00c0, all -> 0x00be }
            java.lang.String r2 = "select parameters from default_event_params where app_id=?"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x00c0, all -> 0x00be }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x00c0, all -> 0x00be }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x00c0, all -> 0x00be }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x00bc }
            if (r2 != 0) goto L_0x0030
            com.google.android.gms.measurement.internal.zzfr r8 = r7.zzj()     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.measurement.internal.zzft r8 = r8.zzp()     // Catch:{ SQLiteException -> 0x00bc }
            java.lang.String r2 = "Default event parameters not found"
            r8.zza(r2)     // Catch:{ SQLiteException -> 0x00bc }
            if (r1 == 0) goto L_0x002f
            r1.close()
        L_0x002f:
            return r0
        L_0x0030:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.internal.measurement.zzfi$zze$zza r3 = com.google.android.gms.internal.measurement.zzfi.zze.zze()     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzkm r2 = com.google.android.gms.measurement.internal.zzmz.zza(r3, (byte[]) r2)     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzfi$zze$zza r2 = (com.google.android.gms.internal.measurement.zzfi.zze.zza) r2     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzkj r2 = r2.zzab()     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzix r2 = (com.google.android.gms.internal.measurement.zzix) r2     // Catch:{ IOException -> 0x00a4 }
            com.google.android.gms.internal.measurement.zzfi$zze r2 = (com.google.android.gms.internal.measurement.zzfi.zze) r2     // Catch:{ IOException -> 0x00a4 }
            r7.g_()     // Catch:{ SQLiteException -> 0x00bc }
            java.util.List r8 = r2.zzh()     // Catch:{ SQLiteException -> 0x00bc }
            android.os.Bundle r2 = new android.os.Bundle     // Catch:{ SQLiteException -> 0x00bc }
            r2.<init>()     // Catch:{ SQLiteException -> 0x00bc }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ SQLiteException -> 0x00bc }
        L_0x0056:
            boolean r3 = r8.hasNext()     // Catch:{ SQLiteException -> 0x00bc }
            if (r3 == 0) goto L_0x009e
            java.lang.Object r3 = r8.next()     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.internal.measurement.zzfi$zzg r3 = (com.google.android.gms.internal.measurement.zzfi.zzg) r3     // Catch:{ SQLiteException -> 0x00bc }
            java.lang.String r4 = r3.zzg()     // Catch:{ SQLiteException -> 0x00bc }
            boolean r5 = r3.zzj()     // Catch:{ SQLiteException -> 0x00bc }
            if (r5 == 0) goto L_0x0074
            double r5 = r3.zza()     // Catch:{ SQLiteException -> 0x00bc }
            r2.putDouble(r4, r5)     // Catch:{ SQLiteException -> 0x00bc }
            goto L_0x0056
        L_0x0074:
            boolean r5 = r3.zzk()     // Catch:{ SQLiteException -> 0x00bc }
            if (r5 == 0) goto L_0x0082
            float r3 = r3.zzb()     // Catch:{ SQLiteException -> 0x00bc }
            r2.putFloat(r4, r3)     // Catch:{ SQLiteException -> 0x00bc }
            goto L_0x0056
        L_0x0082:
            boolean r5 = r3.zzn()     // Catch:{ SQLiteException -> 0x00bc }
            if (r5 == 0) goto L_0x0090
            java.lang.String r3 = r3.zzh()     // Catch:{ SQLiteException -> 0x00bc }
            r2.putString(r4, r3)     // Catch:{ SQLiteException -> 0x00bc }
            goto L_0x0056
        L_0x0090:
            boolean r5 = r3.zzl()     // Catch:{ SQLiteException -> 0x00bc }
            if (r5 == 0) goto L_0x0056
            long r5 = r3.zzd()     // Catch:{ SQLiteException -> 0x00bc }
            r2.putLong(r4, r5)     // Catch:{ SQLiteException -> 0x00bc }
            goto L_0x0056
        L_0x009e:
            if (r1 == 0) goto L_0x00a3
            r1.close()
        L_0x00a3:
            return r2
        L_0x00a4:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r7.zzj()     // Catch:{ SQLiteException -> 0x00bc }
            com.google.android.gms.measurement.internal.zzft r3 = r3.zzg()     // Catch:{ SQLiteException -> 0x00bc }
            java.lang.String r4 = "Failed to retrieve default event parameters. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x00bc }
            r3.zza(r4, r8, r2)     // Catch:{ SQLiteException -> 0x00bc }
            if (r1 == 0) goto L_0x00bb
            r1.close()
        L_0x00bb:
            return r0
        L_0x00bc:
            r8 = move-exception
            goto L_0x00c2
        L_0x00be:
            r8 = move-exception
            goto L_0x00d7
        L_0x00c0:
            r8 = move-exception
            r1 = r0
        L_0x00c2:
            com.google.android.gms.measurement.internal.zzfr r2 = r7.zzj()     // Catch:{ all -> 0x00d5 }
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzg()     // Catch:{ all -> 0x00d5 }
            java.lang.String r3 = "Error selecting default event parameters"
            r2.zza(r3, r8)     // Catch:{ all -> 0x00d5 }
            if (r1 == 0) goto L_0x00d4
            r1.close()
        L_0x00d4:
            return r0
        L_0x00d5:
            r8 = move-exception
            r0 = r1
        L_0x00d7:
            if (r0 == 0) goto L_0x00dc
            r0.close()
        L_0x00dc:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zzc(java.lang.String):android.os.Bundle");
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x008c  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.util.Pair<com.google.android.gms.internal.measurement.zzfi.zze, java.lang.Long> zza(java.lang.String r8, java.lang.Long r9) {
        /*
            r7 = this;
            r7.zzt()
            r7.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r7.e_()     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            java.lang.String r2 = "select main_event, children_to_process from main_event_params where app_id=? and event_id=?"
            r3 = 2
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            r4 = 0
            r3[r4] = r8     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            java.lang.String r5 = java.lang.String.valueOf(r9)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            r6 = 1
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            android.database.Cursor r1 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x007b, all -> 0x0079 }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x0077 }
            if (r2 != 0) goto L_0x0037
            com.google.android.gms.measurement.internal.zzfr r8 = r7.zzj()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzft r8 = r8.zzp()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r9 = "Main event not found"
            r8.zza(r9)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0036
            r1.close()
        L_0x0036:
            return r0
        L_0x0037:
            byte[] r2 = r1.getBlob(r4)     // Catch:{ SQLiteException -> 0x0077 }
            long r3 = r1.getLong(r6)     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.Long r3 = java.lang.Long.valueOf(r3)     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.internal.measurement.zzfi$zze$zza r4 = com.google.android.gms.internal.measurement.zzfi.zze.zze()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzkm r2 = com.google.android.gms.measurement.internal.zzmz.zza(r4, (byte[]) r2)     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzfi$zze$zza r2 = (com.google.android.gms.internal.measurement.zzfi.zze.zza) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzkj r2 = r2.zzab()     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzix r2 = (com.google.android.gms.internal.measurement.zzix) r2     // Catch:{ IOException -> 0x005f }
            com.google.android.gms.internal.measurement.zzfi$zze r2 = (com.google.android.gms.internal.measurement.zzfi.zze) r2     // Catch:{ IOException -> 0x005f }
            android.util.Pair r8 = android.util.Pair.create(r2, r3)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x005e
            r1.close()
        L_0x005e:
            return r8
        L_0x005f:
            r2 = move-exception
            com.google.android.gms.measurement.internal.zzfr r3 = r7.zzj()     // Catch:{ SQLiteException -> 0x0077 }
            com.google.android.gms.measurement.internal.zzft r3 = r3.zzg()     // Catch:{ SQLiteException -> 0x0077 }
            java.lang.String r4 = "Failed to merge main event. appId, eventId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r8)     // Catch:{ SQLiteException -> 0x0077 }
            r3.zza(r4, r8, r9, r2)     // Catch:{ SQLiteException -> 0x0077 }
            if (r1 == 0) goto L_0x0076
            r1.close()
        L_0x0076:
            return r0
        L_0x0077:
            r8 = move-exception
            goto L_0x007d
        L_0x0079:
            r8 = move-exception
            goto L_0x0092
        L_0x007b:
            r8 = move-exception
            r1 = r0
        L_0x007d:
            com.google.android.gms.measurement.internal.zzfr r9 = r7.zzj()     // Catch:{ all -> 0x0090 }
            com.google.android.gms.measurement.internal.zzft r9 = r9.zzg()     // Catch:{ all -> 0x0090 }
            java.lang.String r2 = "Error selecting main event"
            r9.zza(r2, r8)     // Catch:{ all -> 0x0090 }
            if (r1 == 0) goto L_0x008f
            r1.close()
        L_0x008f:
            return r0
        L_0x0090:
            r8 = move-exception
            r0 = r1
        L_0x0092:
            if (r0 == 0) goto L_0x0097
            r0.close()
        L_0x0097:
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zza(java.lang.String, java.lang.Long):android.util.Pair");
    }

    /* JADX WARNING: Removed duplicated region for block: B:103:0x02bc  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x02c4  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0129 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x012d A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0161 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x017f A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0182 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0191 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x01ea A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x01ec A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x0246 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0248 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0266 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:79:0x0268 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x0280 A[Catch:{ SQLiteException -> 0x0297 }] */
    /* JADX WARNING: Removed duplicated region for block: B:89:0x0293  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzh zzd(java.lang.String r42) {
        /*
            r41 = this;
            r1 = r42
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r42)
            r41.zzt()
            r41.zzak()
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r41.e_()     // Catch:{ SQLiteException -> 0x02a5, all -> 0x02a1 }
            java.lang.String r4 = "apps"
            java.lang.String r5 = "app_instance_id"
            java.lang.String r6 = "gmp_app_id"
            java.lang.String r7 = "resettable_device_id_hash"
            java.lang.String r8 = "last_bundle_index"
            java.lang.String r9 = "last_bundle_start_timestamp"
            java.lang.String r10 = "last_bundle_end_timestamp"
            java.lang.String r11 = "app_version"
            java.lang.String r12 = "app_store"
            java.lang.String r13 = "gmp_version"
            java.lang.String r14 = "dev_cert_hash"
            java.lang.String r15 = "measurement_enabled"
            java.lang.String r16 = "day"
            java.lang.String r17 = "daily_public_events_count"
            java.lang.String r18 = "daily_events_count"
            java.lang.String r19 = "daily_conversions_count"
            java.lang.String r20 = "config_fetched_time"
            java.lang.String r21 = "failed_config_fetch_time"
            java.lang.String r22 = "app_version_int"
            java.lang.String r23 = "firebase_instance_id"
            java.lang.String r24 = "daily_error_events_count"
            java.lang.String r25 = "daily_realtime_events_count"
            java.lang.String r26 = "health_monitor_sample"
            java.lang.String r27 = "android_id"
            java.lang.String r28 = "adid_reporting_enabled"
            java.lang.String r29 = "admob_app_id"
            java.lang.String r30 = "dynamite_version"
            java.lang.String r31 = "safelisted_events"
            java.lang.String r32 = "ga_app_id"
            java.lang.String r33 = "session_stitching_token"
            java.lang.String r34 = "sgtm_upload_enabled"
            java.lang.String r35 = "target_os_version"
            java.lang.String r36 = "session_stitching_token_hash"
            java.lang.String r37 = "ad_services_version"
            java.lang.String r38 = "unmatched_first_open_without_ad_id"
            java.lang.String r39 = "npa_metadata_value"
            java.lang.String r40 = "attribution_eligibility_status"
            java.lang.String[] r5 = new java.lang.String[]{r5, r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30, r31, r32, r33, r34, r35, r36, r37, r38, r39, r40}     // Catch:{ SQLiteException -> 0x02a5, all -> 0x02a1 }
            java.lang.String r6 = "app_id=?"
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x02a5, all -> 0x02a1 }
            r11 = 0
            r7[r11] = r1     // Catch:{ SQLiteException -> 0x02a5, all -> 0x02a1 }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r3 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ SQLiteException -> 0x02a5, all -> 0x02a1 }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x029d, all -> 0x0299 }
            if (r4 != 0) goto L_0x0079
            if (r3 == 0) goto L_0x0078
            r3.close()
        L_0x0078:
            return r2
        L_0x0079:
            com.google.android.gms.measurement.internal.zzh r4 = new com.google.android.gms.measurement.internal.zzh     // Catch:{ SQLiteException -> 0x029d, all -> 0x0299 }
            r5 = r41
            com.google.android.gms.measurement.internal.zzmp r6 = r5.zzf     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.zzhf r6 = r6.zzk()     // Catch:{ SQLiteException -> 0x0297 }
            r4.<init>(r6, r1)     // Catch:{ SQLiteException -> 0x0297 }
            java.lang.String r6 = r3.getString(r11)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzb((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            java.lang.String r6 = r3.getString(r0)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzf((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 2
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzh((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 3
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzo(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 4
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzp(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 5
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzn(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 6
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzd((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 7
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzc((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 8
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzm(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 9
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzj(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 10
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x00e7
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x00e5
            goto L_0x00e7
        L_0x00e5:
            r6 = r11
            goto L_0x00e8
        L_0x00e7:
            r6 = r0
        L_0x00e8:
            r4.zzb((boolean) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 11
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzi((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 12
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzg((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 13
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzf((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 14
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzd((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 15
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzc((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 16
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzl(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 17
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 == 0) goto L_0x012d
            r6 = -2147483648(0xffffffff80000000, double:NaN)
            goto L_0x0132
        L_0x012d:
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            long r6 = (long) r6     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0132:
            r4.zza((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 18
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zze((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 19
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zze((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 20
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzh((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 21
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzg((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 23
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x016a
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x0168
            goto L_0x016a
        L_0x0168:
            r6 = r11
            goto L_0x016b
        L_0x016a:
            r6 = r0
        L_0x016b:
            r4.zza((boolean) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 24
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zza((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 25
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 == 0) goto L_0x0182
            r6 = 0
            goto L_0x0186
        L_0x0182:
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0186:
            r4.zzk(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 26
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x01a3
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            java.lang.String r7 = ","
            r8 = -1
            java.lang.String[] r6 = r6.split(r7, r8)     // Catch:{ SQLiteException -> 0x0297 }
            java.util.List r6 = java.util.Arrays.asList(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zza((java.util.List<java.lang.String>) r6)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x01a3:
            boolean r6 = com.google.android.gms.internal.measurement.zzps.zza()     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x01ca
            com.google.android.gms.measurement.internal.zzaf r6 = r41.zze()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzbt     // Catch:{ SQLiteException -> 0x0297 }
            boolean r6 = r6.zze(r1, r7)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 != 0) goto L_0x01c1
            com.google.android.gms.measurement.internal.zzaf r6 = r41.zze()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzbr     // Catch:{ SQLiteException -> 0x0297 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x01ca
        L_0x01c1:
            r6 = 28
            java.lang.String r6 = r3.getString(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzi((java.lang.String) r6)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x01ca:
            boolean r6 = com.google.android.gms.internal.measurement.zzqd.zza()     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x01f0
            com.google.android.gms.measurement.internal.zzaf r6 = r41.zze()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzbu     // Catch:{ SQLiteException -> 0x0297 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r7)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x01f0
            r6 = 29
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x01ec
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x01ec
            r6 = r0
            goto L_0x01ed
        L_0x01ec:
            r6 = r11
        L_0x01ed:
            r4.zzc((boolean) r6)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x01f0:
            r6 = 30
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzr(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 31
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzq(r6)     // Catch:{ SQLiteException -> 0x0297 }
            boolean r6 = com.google.android.gms.internal.measurement.zzpg.zza()     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x0226
            com.google.android.gms.measurement.internal.zzaf r6 = r41.zze()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzcf     // Catch:{ SQLiteException -> 0x0297 }
            boolean r6 = r6.zze(r1, r7)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x0226
            r6 = 32
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zza((int) r6)     // Catch:{ SQLiteException -> 0x0297 }
            r6 = 35
            long r6 = r3.getLong(r6)     // Catch:{ SQLiteException -> 0x0297 }
            r4.zzb((long) r6)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0226:
            boolean r6 = com.google.android.gms.internal.measurement.zznk.zza()     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x024c
            com.google.android.gms.measurement.internal.zzaf r6 = r41.zze()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzcr     // Catch:{ SQLiteException -> 0x0297 }
            boolean r6 = r6.zze(r1, r7)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x024c
            r6 = 33
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 != 0) goto L_0x0248
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x0248
            r6 = r0
            goto L_0x0249
        L_0x0248:
            r6 = r11
        L_0x0249:
            r4.zzd((boolean) r6)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x024c:
            boolean r6 = com.google.android.gms.internal.measurement.zznp.zza()     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x0277
            com.google.android.gms.measurement.internal.zzaf r6 = r41.zze()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzbi.zzcm     // Catch:{ SQLiteException -> 0x0297 }
            boolean r6 = r6.zze(r1, r7)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x0277
            r6 = 34
            boolean r7 = r3.isNull(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r7 == 0) goto L_0x0268
            r0 = r2
            goto L_0x0274
        L_0x0268:
            int r6 = r3.getInt(r6)     // Catch:{ SQLiteException -> 0x0297 }
            if (r6 == 0) goto L_0x026f
            goto L_0x0270
        L_0x026f:
            r0 = r11
        L_0x0270:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0274:
            r4.zza((java.lang.Boolean) r0)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0277:
            r4.zzah()     // Catch:{ SQLiteException -> 0x0297 }
            boolean r0 = r3.moveToNext()     // Catch:{ SQLiteException -> 0x0297 }
            if (r0 == 0) goto L_0x0291
            com.google.android.gms.measurement.internal.zzfr r0 = r41.zzj()     // Catch:{ SQLiteException -> 0x0297 }
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x0297 }
            java.lang.String r6 = "Got multiple records for app, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r42)     // Catch:{ SQLiteException -> 0x0297 }
            r0.zza(r6, r7)     // Catch:{ SQLiteException -> 0x0297 }
        L_0x0291:
            if (r3 == 0) goto L_0x0296
            r3.close()
        L_0x0296:
            return r4
        L_0x0297:
            r0 = move-exception
            goto L_0x02a9
        L_0x0299:
            r0 = move-exception
            r5 = r41
            goto L_0x02c1
        L_0x029d:
            r0 = move-exception
            r5 = r41
            goto L_0x02a9
        L_0x02a1:
            r0 = move-exception
            r5 = r41
            goto L_0x02c2
        L_0x02a5:
            r0 = move-exception
            r5 = r41
            r3 = r2
        L_0x02a9:
            com.google.android.gms.measurement.internal.zzfr r4 = r41.zzj()     // Catch:{ all -> 0x02c0 }
            com.google.android.gms.measurement.internal.zzft r4 = r4.zzg()     // Catch:{ all -> 0x02c0 }
            java.lang.String r6 = "Error querying app. appId"
            java.lang.Object r1 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r42)     // Catch:{ all -> 0x02c0 }
            r4.zza(r6, r1, r0)     // Catch:{ all -> 0x02c0 }
            if (r3 == 0) goto L_0x02bf
            r3.close()
        L_0x02bf:
            return r2
        L_0x02c0:
            r0 = move-exception
        L_0x02c1:
            r2 = r3
        L_0x02c2:
            if (r2 == 0) goto L_0x02c7
            r2.close()
        L_0x02c7:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zzd(java.lang.String):com.google.android.gms.measurement.internal.zzh");
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x0123  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x012b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzad zzc(java.lang.String r30, java.lang.String r31) {
        /*
            r29 = this;
            r7 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r30)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r31)
            r29.zzt()
            r29.zzak()
            r8 = 0
            android.database.sqlite.SQLiteDatabase r9 = r29.e_()     // Catch:{ SQLiteException -> 0x0104, all -> 0x0100 }
            java.lang.String r10 = "conditional_properties"
            java.lang.String r11 = "origin"
            java.lang.String r12 = "value"
            java.lang.String r13 = "active"
            java.lang.String r14 = "trigger_event_name"
            java.lang.String r15 = "trigger_timeout"
            java.lang.String r16 = "timed_out_event"
            java.lang.String r17 = "creation_timestamp"
            java.lang.String r18 = "triggered_event"
            java.lang.String r19 = "triggered_timestamp"
            java.lang.String r20 = "time_to_live"
            java.lang.String r21 = "expired_event"
            java.lang.String[] r11 = new java.lang.String[]{r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21}     // Catch:{ SQLiteException -> 0x0104, all -> 0x0100 }
            java.lang.String r12 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r13 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0104, all -> 0x0100 }
            r1 = 0
            r13[r1] = r30     // Catch:{ SQLiteException -> 0x0104, all -> 0x0100 }
            r2 = 1
            r13[r2] = r7     // Catch:{ SQLiteException -> 0x0104, all -> 0x0100 }
            r14 = 0
            r15 = 0
            r16 = 0
            android.database.Cursor r9 = r9.query(r10, r11, r12, r13, r14, r15, r16)     // Catch:{ SQLiteException -> 0x0104, all -> 0x0100 }
            boolean r3 = r9.moveToFirst()     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f8 }
            if (r3 != 0) goto L_0x004e
            if (r9 == 0) goto L_0x004d
            r9.close()
        L_0x004d:
            return r8
        L_0x004e:
            java.lang.String r3 = r9.getString(r1)     // Catch:{ SQLiteException -> 0x00fc, all -> 0x00f8 }
            if (r3 != 0) goto L_0x0056
            java.lang.String r3 = ""
        L_0x0056:
            r10 = r29
            r16 = r3
            java.lang.Object r5 = r10.zza((android.database.Cursor) r9, (int) r2)     // Catch:{ SQLiteException -> 0x00f6 }
            int r0 = r9.getInt(r0)     // Catch:{ SQLiteException -> 0x00f6 }
            if (r0 == 0) goto L_0x0067
            r20 = r2
            goto L_0x0069
        L_0x0067:
            r20 = r1
        L_0x0069:
            r0 = 3
            java.lang.String r21 = r9.getString(r0)     // Catch:{ SQLiteException -> 0x00f6 }
            r0 = 4
            long r23 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzmz r0 = r29.g_()     // Catch:{ SQLiteException -> 0x00f6 }
            r1 = 5
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f6 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbg> r2 = com.google.android.gms.measurement.internal.zzbg.CREATOR     // Catch:{ SQLiteException -> 0x00f6 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f6 }
            r22 = r0
            com.google.android.gms.measurement.internal.zzbg r22 = (com.google.android.gms.measurement.internal.zzbg) r22     // Catch:{ SQLiteException -> 0x00f6 }
            r0 = 6
            long r18 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzmz r0 = r29.g_()     // Catch:{ SQLiteException -> 0x00f6 }
            r1 = 7
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f6 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbg> r2 = com.google.android.gms.measurement.internal.zzbg.CREATOR     // Catch:{ SQLiteException -> 0x00f6 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f6 }
            r25 = r0
            com.google.android.gms.measurement.internal.zzbg r25 = (com.google.android.gms.measurement.internal.zzbg) r25     // Catch:{ SQLiteException -> 0x00f6 }
            r0 = 8
            long r3 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f6 }
            r0 = 9
            long r26 = r9.getLong(r0)     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzmz r0 = r29.g_()     // Catch:{ SQLiteException -> 0x00f6 }
            r1 = 10
            byte[] r1 = r9.getBlob(r1)     // Catch:{ SQLiteException -> 0x00f6 }
            android.os.Parcelable$Creator<com.google.android.gms.measurement.internal.zzbg> r2 = com.google.android.gms.measurement.internal.zzbg.CREATOR     // Catch:{ SQLiteException -> 0x00f6 }
            android.os.Parcelable r0 = r0.zza((byte[]) r1, r2)     // Catch:{ SQLiteException -> 0x00f6 }
            r28 = r0
            com.google.android.gms.measurement.internal.zzbg r28 = (com.google.android.gms.measurement.internal.zzbg) r28     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zznc r17 = new com.google.android.gms.measurement.internal.zznc     // Catch:{ SQLiteException -> 0x00f6 }
            r1 = r17
            r2 = r31
            r6 = r16
            r1.<init>(r2, r3, r5, r6)     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzad r0 = new com.google.android.gms.measurement.internal.zzad     // Catch:{ SQLiteException -> 0x00f6 }
            r14 = r0
            r15 = r30
            r14.<init>(r15, r16, r17, r18, r20, r21, r22, r23, r25, r26, r28)     // Catch:{ SQLiteException -> 0x00f6 }
            boolean r1 = r9.moveToNext()     // Catch:{ SQLiteException -> 0x00f6 }
            if (r1 == 0) goto L_0x00f0
            com.google.android.gms.measurement.internal.zzfr r1 = r29.zzj()     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzg()     // Catch:{ SQLiteException -> 0x00f6 }
            java.lang.String r2 = "Got multiple records for conditional property, expected one"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r30)     // Catch:{ SQLiteException -> 0x00f6 }
            com.google.android.gms.measurement.internal.zzfq r4 = r29.zzi()     // Catch:{ SQLiteException -> 0x00f6 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ SQLiteException -> 0x00f6 }
            r1.zza(r2, r3, r4)     // Catch:{ SQLiteException -> 0x00f6 }
        L_0x00f0:
            if (r9 == 0) goto L_0x00f5
            r9.close()
        L_0x00f5:
            return r0
        L_0x00f6:
            r0 = move-exception
            goto L_0x0108
        L_0x00f8:
            r0 = move-exception
            r10 = r29
            goto L_0x0128
        L_0x00fc:
            r0 = move-exception
            r10 = r29
            goto L_0x0108
        L_0x0100:
            r0 = move-exception
            r10 = r29
            goto L_0x0129
        L_0x0104:
            r0 = move-exception
            r10 = r29
            r9 = r8
        L_0x0108:
            com.google.android.gms.measurement.internal.zzfr r1 = r29.zzj()     // Catch:{ all -> 0x0127 }
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzg()     // Catch:{ all -> 0x0127 }
            java.lang.String r2 = "Error querying conditional property"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r30)     // Catch:{ all -> 0x0127 }
            com.google.android.gms.measurement.internal.zzfq r4 = r29.zzi()     // Catch:{ all -> 0x0127 }
            java.lang.String r4 = r4.zzc(r7)     // Catch:{ all -> 0x0127 }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x0127 }
            if (r9 == 0) goto L_0x0126
            r9.close()
        L_0x0126:
            return r8
        L_0x0127:
            r0 = move-exception
        L_0x0128:
            r8 = r9
        L_0x0129:
            if (r8 == 0) goto L_0x012e
            r8.close()
        L_0x012e:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zzc(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzad");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0085  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x008d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzaq zze(java.lang.String r12) {
        /*
            r11 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r12)
            r11.zzt()
            r11.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r11.e_()     // Catch:{ SQLiteException -> 0x0070, all -> 0x006e }
            java.lang.String r2 = "apps"
            java.lang.String r3 = "remote_config"
            java.lang.String r4 = "config_last_modified_time"
            java.lang.String r5 = "e_tag"
            java.lang.String[] r3 = new java.lang.String[]{r3, r4, r5}     // Catch:{ SQLiteException -> 0x0070, all -> 0x006e }
            java.lang.String r4 = "app_id=?"
            r9 = 1
            java.lang.String[] r5 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0070, all -> 0x006e }
            r10 = 0
            r5[r10] = r12     // Catch:{ SQLiteException -> 0x0070, all -> 0x006e }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0070, all -> 0x006e }
            boolean r2 = r1.moveToFirst()     // Catch:{ SQLiteException -> 0x006c }
            if (r2 != 0) goto L_0x0035
            if (r1 == 0) goto L_0x0034
            r1.close()
        L_0x0034:
            return r0
        L_0x0035:
            byte[] r2 = r1.getBlob(r10)     // Catch:{ SQLiteException -> 0x006c }
            java.lang.String r3 = r1.getString(r9)     // Catch:{ SQLiteException -> 0x006c }
            r4 = 2
            java.lang.String r4 = r1.getString(r4)     // Catch:{ SQLiteException -> 0x006c }
            boolean r5 = r1.moveToNext()     // Catch:{ SQLiteException -> 0x006c }
            if (r5 == 0) goto L_0x0059
            com.google.android.gms.measurement.internal.zzfr r5 = r11.zzj()     // Catch:{ SQLiteException -> 0x006c }
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzg()     // Catch:{ SQLiteException -> 0x006c }
            java.lang.String r6 = "Got multiple records for app config, expected one. appId"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r12)     // Catch:{ SQLiteException -> 0x006c }
            r5.zza(r6, r7)     // Catch:{ SQLiteException -> 0x006c }
        L_0x0059:
            if (r2 != 0) goto L_0x0061
            if (r1 == 0) goto L_0x0060
            r1.close()
        L_0x0060:
            return r0
        L_0x0061:
            com.google.android.gms.measurement.internal.zzaq r5 = new com.google.android.gms.measurement.internal.zzaq     // Catch:{ SQLiteException -> 0x006c }
            r5.<init>(r2, r3, r4)     // Catch:{ SQLiteException -> 0x006c }
            if (r1 == 0) goto L_0x006b
            r1.close()
        L_0x006b:
            return r5
        L_0x006c:
            r2 = move-exception
            goto L_0x0072
        L_0x006e:
            r12 = move-exception
            goto L_0x008b
        L_0x0070:
            r2 = move-exception
            r1 = r0
        L_0x0072:
            com.google.android.gms.measurement.internal.zzfr r3 = r11.zzj()     // Catch:{ all -> 0x0089 }
            com.google.android.gms.measurement.internal.zzft r3 = r3.zzg()     // Catch:{ all -> 0x0089 }
            java.lang.String r4 = "Error querying remote config. appId"
            java.lang.Object r12 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r12)     // Catch:{ all -> 0x0089 }
            r3.zza(r4, r12, r2)     // Catch:{ all -> 0x0089 }
            if (r1 == 0) goto L_0x0088
            r1.close()
        L_0x0088:
            return r0
        L_0x0089:
            r12 = move-exception
            r0 = r1
        L_0x008b:
            if (r0 == 0) goto L_0x0090
            r0.close()
        L_0x0090:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zze(java.lang.String):com.google.android.gms.measurement.internal.zzaq");
    }

    public final zzap zza(long j, String str, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        return zza(j, str, 1, false, false, z3, false, z5);
    }

    public final zzap zza(long j, String str, long j2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        String[] strArr = {str};
        zzap zzap = new zzap();
        Cursor cursor = null;
        try {
            SQLiteDatabase e_ = e_();
            cursor = e_.query("apps", new String[]{"day", "daily_events_count", "daily_public_events_count", "daily_conversions_count", "daily_error_events_count", "daily_realtime_events_count"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                zzj().zzu().zza("Not updating daily counts, app is not known. appId", zzfr.zza(str));
                if (cursor != null) {
                    cursor.close();
                }
                return zzap;
            }
            if (cursor.getLong(0) == j) {
                zzap.zzb = cursor.getLong(1);
                zzap.zza = cursor.getLong(2);
                zzap.zzc = cursor.getLong(3);
                zzap.zzd = cursor.getLong(4);
                zzap.zze = cursor.getLong(5);
            }
            if (z) {
                zzap.zzb += j2;
            }
            if (z2) {
                zzap.zza += j2;
            }
            if (z3) {
                zzap.zzc += j2;
            }
            if (z4) {
                zzap.zzd += j2;
            }
            if (z5) {
                zzap.zze += j2;
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("day", Long.valueOf(j));
            contentValues.put("daily_public_events_count", Long.valueOf(zzap.zza));
            contentValues.put("daily_events_count", Long.valueOf(zzap.zzb));
            contentValues.put("daily_conversions_count", Long.valueOf(zzap.zzc));
            contentValues.put("daily_error_events_count", Long.valueOf(zzap.zzd));
            contentValues.put("daily_realtime_events_count", Long.valueOf(zzap.zze));
            e_.update("apps", contentValues, "app_id=?", strArr);
            if (cursor != null) {
                cursor.close();
            }
            return zzap;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error updating daily counts. appId", zzfr.zza(str), e);
            if (cursor != null) {
                cursor.close();
            }
            return zzap;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final zzay zzf(String str) {
        if (!zznp.zza() || !zze().zza(zzbi.zzcm)) {
            return zzay.zza;
        }
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        return zzay.zza(zza("select dma_consent_settings from consent_settings where app_id=? limit 1;", new String[]{str}, ""));
    }

    /* JADX WARNING: Removed duplicated region for block: B:65:0x0147  */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0150  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzbc zzd(java.lang.String r26, java.lang.String r27) {
        /*
            r25 = this;
            r15 = r27
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r26)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            r25.zzt()
            r25.zzak()
            java.util.ArrayList r0 = new java.util.ArrayList
            java.lang.String r1 = "lifetime_count"
            java.lang.String r2 = "current_bundle_count"
            java.lang.String r3 = "last_fire_timestamp"
            java.lang.String r4 = "last_bundled_timestamp"
            java.lang.String r5 = "last_bundled_day"
            java.lang.String r6 = "last_sampled_complex_event_id"
            java.lang.String r7 = "last_sampling_rate"
            java.lang.String r8 = "last_exempt_from_sampling"
            java.lang.String r9 = "current_session_count"
            java.lang.String[] r1 = new java.lang.String[]{r1, r2, r3, r4, r5, r6, r7, r8, r9}
            java.util.List r1 = java.util.Arrays.asList(r1)
            r0.<init>(r1)
            r18 = 0
            android.database.sqlite.SQLiteDatabase r1 = r25.e_()     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.String r2 = "events"
            r9 = 0
            java.lang.String[] r3 = new java.lang.String[r9]     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.Object[] r0 = r0.toArray(r3)     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r3 = r0
            java.lang.String[] r3 = (java.lang.String[]) r3     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            java.lang.String r4 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r5 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r5[r9] = r26     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r10 = 1
            r5[r10] = r15     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            r6 = 0
            r7 = 0
            r8 = 0
            android.database.Cursor r14 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ SQLiteException -> 0x0127, all -> 0x0125 }
            boolean r1 = r14.moveToFirst()     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            if (r1 != 0) goto L_0x005c
            if (r14 == 0) goto L_0x005b
            r14.close()
        L_0x005b:
            return r18
        L_0x005c:
            long r4 = r14.getLong(r9)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            long r6 = r14.getLong(r10)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            long r11 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            r0 = 3
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            r2 = 0
            if (r1 == 0) goto L_0x0074
            r16 = r2
            goto L_0x007a
        L_0x0074:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            r16 = r0
        L_0x007a:
            r0 = 4
            boolean r1 = r14.isNull(r0)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            if (r1 == 0) goto L_0x0084
            r0 = r18
            goto L_0x008c
        L_0x0084:
            long r0 = r14.getLong(r0)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            java.lang.Long r0 = java.lang.Long.valueOf(r0)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
        L_0x008c:
            r1 = 5
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            if (r8 == 0) goto L_0x0096
            r19 = r18
            goto L_0x00a0
        L_0x0096:
            long r19 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            java.lang.Long r1 = java.lang.Long.valueOf(r19)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            r19 = r1
        L_0x00a0:
            r1 = 6
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            if (r8 == 0) goto L_0x00aa
            r20 = r18
            goto L_0x00b4
        L_0x00aa:
            long r20 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            java.lang.Long r1 = java.lang.Long.valueOf(r20)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            r20 = r1
        L_0x00b4:
            r1 = 7
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            if (r8 != 0) goto L_0x00d0
            long r21 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x00cd }
            r23 = 1
            int r1 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r1 != 0) goto L_0x00c6
            r9 = r10
        L_0x00c6:
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r9)     // Catch:{ SQLiteException -> 0x00cd }
            r21 = r1
            goto L_0x00d2
        L_0x00cd:
            r0 = move-exception
            goto L_0x012a
        L_0x00d0:
            r21 = r18
        L_0x00d2:
            r1 = 8
            boolean r8 = r14.isNull(r1)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            if (r8 == 0) goto L_0x00dc
            r8 = r2
            goto L_0x00e1
        L_0x00dc:
            long r1 = r14.getLong(r1)     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            r8 = r1
        L_0x00e1:
            com.google.android.gms.measurement.internal.zzbc r22 = new com.google.android.gms.measurement.internal.zzbc     // Catch:{ SQLiteException -> 0x0121, all -> 0x011b }
            r1 = r22
            r2 = r26
            r3 = r27
            r10 = r11
            r12 = r16
            r23 = r14
            r14 = r0
            r15 = r19
            r16 = r20
            r17 = r21
            r1.<init>(r2, r3, r4, r6, r8, r10, r12, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            boolean r0 = r23.moveToNext()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            if (r0 == 0) goto L_0x010f
            com.google.android.gms.measurement.internal.zzfr r0 = r25.zzj()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            java.lang.String r1 = "Got multiple records for event aggregates, expected one. appId"
            java.lang.Object r2 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r26)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
            r0.zza(r1, r2)     // Catch:{ SQLiteException -> 0x0117, all -> 0x0115 }
        L_0x010f:
            if (r23 == 0) goto L_0x0114
            r23.close()
        L_0x0114:
            return r22
        L_0x0115:
            r0 = move-exception
            goto L_0x011e
        L_0x0117:
            r0 = move-exception
            r14 = r23
            goto L_0x012a
        L_0x011b:
            r0 = move-exception
            r23 = r14
        L_0x011e:
            r18 = r23
            goto L_0x014e
        L_0x0121:
            r0 = move-exception
            r23 = r14
            goto L_0x012a
        L_0x0125:
            r0 = move-exception
            goto L_0x014e
        L_0x0127:
            r0 = move-exception
            r14 = r18
        L_0x012a:
            com.google.android.gms.measurement.internal.zzfr r1 = r25.zzj()     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzg()     // Catch:{ all -> 0x014b }
            java.lang.String r2 = "Error querying events. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r26)     // Catch:{ all -> 0x014b }
            com.google.android.gms.measurement.internal.zzfq r4 = r25.zzi()     // Catch:{ all -> 0x014b }
            r5 = r27
            java.lang.String r4 = r4.zza((java.lang.String) r5)     // Catch:{ all -> 0x014b }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x014b }
            if (r14 == 0) goto L_0x014a
            r14.close()
        L_0x014a:
            return r18
        L_0x014b:
            r0 = move-exception
            r18 = r14
        L_0x014e:
            if (r18 == 0) goto L_0x0153
            r18.close()
        L_0x0153:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zzd(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzbc");
    }

    public final zzih zzg(String str) {
        Preconditions.checkNotNull(str);
        zzt();
        zzak();
        if (!zznp.zza() || !zze().zza(zzbi.zzcm)) {
            return zzih.zza(zza("select consent_state from consent_settings where app_id=? limit 1;", new String[]{str}, "G1"));
        }
        zzih zzih = (zzih) zza("select consent_state, consent_source from consent_settings where app_id=? limit 1;", new String[]{str}, zzan.zza);
        return zzih == null ? zzih.zza : zzih;
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x00b1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.android.gms.measurement.internal.zzne zze(java.lang.String r19, java.lang.String r20) {
        /*
            r18 = this;
            r8 = r20
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r20)
            r18.zzt()
            r18.zzak()
            r9 = 0
            android.database.sqlite.SQLiteDatabase r10 = r18.e_()     // Catch:{ SQLiteException -> 0x008a, all -> 0x0086 }
            java.lang.String r11 = "user_attributes"
            java.lang.String r0 = "set_timestamp"
            java.lang.String r1 = "value"
            java.lang.String r2 = "origin"
            java.lang.String[] r12 = new java.lang.String[]{r0, r1, r2}     // Catch:{ SQLiteException -> 0x008a, all -> 0x0086 }
            java.lang.String r13 = "app_id=? and name=?"
            r0 = 2
            java.lang.String[] r14 = new java.lang.String[r0]     // Catch:{ SQLiteException -> 0x008a, all -> 0x0086 }
            r1 = 0
            r14[r1] = r19     // Catch:{ SQLiteException -> 0x008a, all -> 0x0086 }
            r2 = 1
            r14[r2] = r8     // Catch:{ SQLiteException -> 0x008a, all -> 0x0086 }
            r15 = 0
            r16 = 0
            r17 = 0
            android.database.Cursor r10 = r10.query(r11, r12, r13, r14, r15, r16, r17)     // Catch:{ SQLiteException -> 0x008a, all -> 0x0086 }
            boolean r3 = r10.moveToFirst()     // Catch:{ SQLiteException -> 0x0082, all -> 0x007e }
            if (r3 != 0) goto L_0x003f
            if (r10 == 0) goto L_0x003e
            r10.close()
        L_0x003e:
            return r9
        L_0x003f:
            long r5 = r10.getLong(r1)     // Catch:{ SQLiteException -> 0x0082, all -> 0x007e }
            r11 = r18
            java.lang.Object r7 = r11.zza((android.database.Cursor) r10, (int) r2)     // Catch:{ SQLiteException -> 0x007c }
            if (r7 != 0) goto L_0x0051
            if (r10 == 0) goto L_0x0050
            r10.close()
        L_0x0050:
            return r9
        L_0x0051:
            java.lang.String r3 = r10.getString(r0)     // Catch:{ SQLiteException -> 0x007c }
            com.google.android.gms.measurement.internal.zzne r0 = new com.google.android.gms.measurement.internal.zzne     // Catch:{ SQLiteException -> 0x007c }
            r1 = r0
            r2 = r19
            r4 = r20
            r1.<init>(r2, r3, r4, r5, r7)     // Catch:{ SQLiteException -> 0x007c }
            boolean r1 = r10.moveToNext()     // Catch:{ SQLiteException -> 0x007c }
            if (r1 == 0) goto L_0x0076
            com.google.android.gms.measurement.internal.zzfr r1 = r18.zzj()     // Catch:{ SQLiteException -> 0x007c }
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzg()     // Catch:{ SQLiteException -> 0x007c }
            java.lang.String r2 = "Got multiple records for user property, expected one. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x007c }
            r1.zza(r2, r3)     // Catch:{ SQLiteException -> 0x007c }
        L_0x0076:
            if (r10 == 0) goto L_0x007b
            r10.close()
        L_0x007b:
            return r0
        L_0x007c:
            r0 = move-exception
            goto L_0x008e
        L_0x007e:
            r0 = move-exception
            r11 = r18
            goto L_0x00ae
        L_0x0082:
            r0 = move-exception
            r11 = r18
            goto L_0x008e
        L_0x0086:
            r0 = move-exception
            r11 = r18
            goto L_0x00af
        L_0x008a:
            r0 = move-exception
            r11 = r18
            r10 = r9
        L_0x008e:
            com.google.android.gms.measurement.internal.zzfr r1 = r18.zzj()     // Catch:{ all -> 0x00ad }
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzg()     // Catch:{ all -> 0x00ad }
            java.lang.String r2 = "Error querying user property. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r19)     // Catch:{ all -> 0x00ad }
            com.google.android.gms.measurement.internal.zzfq r4 = r18.zzi()     // Catch:{ all -> 0x00ad }
            java.lang.String r4 = r4.zzc(r8)     // Catch:{ all -> 0x00ad }
            r1.zza(r2, r3, r4, r0)     // Catch:{ all -> 0x00ad }
            if (r10 == 0) goto L_0x00ac
            r10.close()
        L_0x00ac:
            return r9
        L_0x00ad:
            r0 = move-exception
        L_0x00ae:
            r9 = r10
        L_0x00af:
            if (r9 == 0) goto L_0x00b4
            r9.close()
        L_0x00b4:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zze(java.lang.String, java.lang.String):com.google.android.gms.measurement.internal.zzne");
    }

    private final Object zza(Cursor cursor, int i) {
        int type = cursor.getType(i);
        if (type == 0) {
            zzj().zzg().zza("Loaded invalid null value from database");
            return null;
        } else if (type == 1) {
            return Long.valueOf(cursor.getLong(i));
        } else {
            if (type == 2) {
                return Double.valueOf(cursor.getDouble(i));
            }
            if (type == 3) {
                return cursor.getString(i);
            }
            if (type != 4) {
                zzj().zzg().zza("Loaded invalid unknown value type, ignoring it", Integer.valueOf(type));
                return null;
            }
            zzj().zzg().zza("Loaded invalid blob type value, ignoring it");
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final <T> T zza(java.lang.String r3, java.lang.String[] r4, com.google.android.gms.measurement.internal.zzar<T> r5) {
        /*
            r2 = this;
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r2.e_()     // Catch:{ SQLiteException -> 0x0030, all -> 0x002e }
            android.database.Cursor r3 = r1.rawQuery(r3, r4)     // Catch:{ SQLiteException -> 0x0030, all -> 0x002e }
            boolean r4 = r3.moveToFirst()     // Catch:{ SQLiteException -> 0x002c }
            if (r4 != 0) goto L_0x0022
            com.google.android.gms.measurement.internal.zzfr r4 = r2.zzj()     // Catch:{ SQLiteException -> 0x002c }
            com.google.android.gms.measurement.internal.zzft r4 = r4.zzp()     // Catch:{ SQLiteException -> 0x002c }
            java.lang.String r5 = "No data found"
            r4.zza(r5)     // Catch:{ SQLiteException -> 0x002c }
            if (r3 == 0) goto L_0x0021
            r3.close()
        L_0x0021:
            return r0
        L_0x0022:
            java.lang.Object r4 = r5.zza(r3)     // Catch:{ SQLiteException -> 0x002c }
            if (r3 == 0) goto L_0x002b
            r3.close()
        L_0x002b:
            return r4
        L_0x002c:
            r4 = move-exception
            goto L_0x0032
        L_0x002e:
            r4 = move-exception
            goto L_0x0047
        L_0x0030:
            r4 = move-exception
            r3 = r0
        L_0x0032:
            com.google.android.gms.measurement.internal.zzfr r5 = r2.zzj()     // Catch:{ all -> 0x0045 }
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzg()     // Catch:{ all -> 0x0045 }
            java.lang.String r1 = "Error querying database."
            r5.zza(r1, r4)     // Catch:{ all -> 0x0045 }
            if (r3 == 0) goto L_0x0044
            r3.close()
        L_0x0044:
            return r0
        L_0x0045:
            r4 = move-exception
            r0 = r3
        L_0x0047:
            if (r0 == 0) goto L_0x004c
            r0.close()
        L_0x004c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zza(java.lang.String, java.lang.String[], com.google.android.gms.measurement.internal.zzar):java.lang.Object");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(long r5) {
        /*
            r4 = this;
            r4.zzt()
            r4.zzak()
            r0 = 0
            android.database.sqlite.SQLiteDatabase r1 = r4.e_()     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            java.lang.String r2 = "select app_id from apps where app_id in (select distinct app_id from raw_events) and config_fetched_time < ? order by failed_config_fetch_time limit 1;"
            r3 = 1
            java.lang.String[] r3 = new java.lang.String[r3]     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            java.lang.String r5 = java.lang.String.valueOf(r5)     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            r6 = 0
            r3[r6] = r5     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            android.database.Cursor r5 = r1.rawQuery(r2, r3)     // Catch:{ SQLiteException -> 0x0042, all -> 0x0040 }
            boolean r1 = r5.moveToFirst()     // Catch:{ SQLiteException -> 0x003e }
            if (r1 != 0) goto L_0x0034
            com.google.android.gms.measurement.internal.zzfr r6 = r4.zzj()     // Catch:{ SQLiteException -> 0x003e }
            com.google.android.gms.measurement.internal.zzft r6 = r6.zzp()     // Catch:{ SQLiteException -> 0x003e }
            java.lang.String r1 = "No expired configs for apps with pending events"
            r6.zza(r1)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x0033
            r5.close()
        L_0x0033:
            return r0
        L_0x0034:
            java.lang.String r6 = r5.getString(r6)     // Catch:{ SQLiteException -> 0x003e }
            if (r5 == 0) goto L_0x003d
            r5.close()
        L_0x003d:
            return r6
        L_0x003e:
            r6 = move-exception
            goto L_0x0044
        L_0x0040:
            r6 = move-exception
            goto L_0x0059
        L_0x0042:
            r6 = move-exception
            r5 = r0
        L_0x0044:
            com.google.android.gms.measurement.internal.zzfr r1 = r4.zzj()     // Catch:{ all -> 0x0057 }
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzg()     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = "Error selecting expired configs"
            r1.zza(r2, r6)     // Catch:{ all -> 0x0057 }
            if (r5 == 0) goto L_0x0056
            r5.close()
        L_0x0056:
            return r0
        L_0x0057:
            r6 = move-exception
            r0 = r5
        L_0x0059:
            if (r0 == 0) goto L_0x005e
            r0.close()
        L_0x005e:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zza(long):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0041  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String f_() {
        /*
            r6 = this;
            android.database.sqlite.SQLiteDatabase r0 = r6.e_()
            r1 = 0
            java.lang.String r2 = "select app_id from queue order by has_realtime desc, rowid asc limit 1;"
            android.database.Cursor r0 = r0.rawQuery(r2, r1)     // Catch:{ SQLiteException -> 0x0029, all -> 0x0024 }
            boolean r2 = r0.moveToFirst()     // Catch:{ SQLiteException -> 0x0022 }
            if (r2 == 0) goto L_0x001c
            r2 = 0
            java.lang.String r1 = r0.getString(r2)     // Catch:{ SQLiteException -> 0x0022 }
            if (r0 == 0) goto L_0x001b
            r0.close()
        L_0x001b:
            return r1
        L_0x001c:
            if (r0 == 0) goto L_0x0021
            r0.close()
        L_0x0021:
            return r1
        L_0x0022:
            r2 = move-exception
            goto L_0x002b
        L_0x0024:
            r0 = move-exception
            r5 = r1
            r1 = r0
            r0 = r5
            goto L_0x003f
        L_0x0029:
            r2 = move-exception
            r0 = r1
        L_0x002b:
            com.google.android.gms.measurement.internal.zzfr r3 = r6.zzj()     // Catch:{ all -> 0x003e }
            com.google.android.gms.measurement.internal.zzft r3 = r3.zzg()     // Catch:{ all -> 0x003e }
            java.lang.String r4 = "Database error getting next bundle app id"
            r3.zza(r4, r2)     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x003d
            r0.close()
        L_0x003d:
            return r1
        L_0x003e:
            r1 = move-exception
        L_0x003f:
            if (r0 == 0) goto L_0x0044
            r0.close()
        L_0x0044:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.f_():java.lang.String");
    }

    private final String zza(String str, String[] strArr, String str2) {
        Cursor cursor = null;
        try {
            Cursor rawQuery = e_().rawQuery(str, strArr);
            if (rawQuery.moveToFirst()) {
                String string = rawQuery.getString(0);
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return string;
            }
            if (rawQuery != null) {
                rawQuery.close();
            }
            return str2;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error", str, e);
            throw e;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:90:0x0183 A[EDGE_INSN: B:90:0x0183->B:77:0x0183 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<android.util.Pair<com.google.android.gms.internal.measurement.zzfi.zzj, java.lang.Long>> zza(java.lang.String r19, int r20, int r21) {
        /*
            r18 = this;
            r1 = r21
            r18.zzt()
            r18.zzak()
            r2 = 1
            r3 = 0
            if (r20 <= 0) goto L_0x000e
            r0 = r2
            goto L_0x000f
        L_0x000e:
            r0 = r3
        L_0x000f:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            if (r1 <= 0) goto L_0x0016
            r0 = r2
            goto L_0x0017
        L_0x0016:
            r0 = r3
        L_0x0017:
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0)
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r19)
            r4 = 0
            android.database.sqlite.SQLiteDatabase r5 = r18.e_()     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r6 = "queue"
            java.lang.String r0 = "rowid"
            java.lang.String r7 = "data"
            java.lang.String r8 = "retry_count"
            java.lang.String[] r7 = new java.lang.String[]{r0, r7, r8}     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r8 = "app_id=?"
            java.lang.String[] r9 = new java.lang.String[r2]     // Catch:{ SQLiteException -> 0x018b }
            r9[r3] = r19     // Catch:{ SQLiteException -> 0x018b }
            r10 = 0
            r11 = 0
            java.lang.String r12 = "rowid"
            java.lang.String r13 = java.lang.String.valueOf(r20)     // Catch:{ SQLiteException -> 0x018b }
            android.database.Cursor r4 = r5.query(r6, r7, r8, r9, r10, r11, r12, r13)     // Catch:{ SQLiteException -> 0x018b }
            boolean r0 = r4.moveToFirst()     // Catch:{ SQLiteException -> 0x018b }
            if (r0 != 0) goto L_0x0050
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ SQLiteException -> 0x018b }
            if (r4 == 0) goto L_0x004f
            r4.close()
        L_0x004f:
            return r0
        L_0x0050:
            java.util.ArrayList r5 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x018b }
            r5.<init>()     // Catch:{ SQLiteException -> 0x018b }
            r6 = r3
        L_0x0056:
            long r7 = r4.getLong(r3)     // Catch:{ SQLiteException -> 0x018b }
            byte[] r0 = r4.getBlob(r2)     // Catch:{ IOException -> 0x0165 }
            com.google.android.gms.measurement.internal.zzmz r9 = r18.g_()     // Catch:{ IOException -> 0x0165 }
            byte[] r0 = r9.zzc((byte[]) r0)     // Catch:{ IOException -> 0x0165 }
            boolean r9 = r5.isEmpty()     // Catch:{ SQLiteException -> 0x018b }
            if (r9 != 0) goto L_0x0070
            int r9 = r0.length     // Catch:{ SQLiteException -> 0x018b }
            int r9 = r9 + r6
            if (r9 > r1) goto L_0x0183
        L_0x0070:
            com.google.android.gms.internal.measurement.zzfi$zzj$zza r9 = com.google.android.gms.internal.measurement.zzfi.zzj.zzu()     // Catch:{ IOException -> 0x0152 }
            com.google.android.gms.internal.measurement.zzkm r9 = com.google.android.gms.measurement.internal.zzmz.zza(r9, (byte[]) r0)     // Catch:{ IOException -> 0x0152 }
            com.google.android.gms.internal.measurement.zzfi$zzj$zza r9 = (com.google.android.gms.internal.measurement.zzfi.zzj.zza) r9     // Catch:{ IOException -> 0x0152 }
            boolean r10 = com.google.android.gms.internal.measurement.zznp.zza()     // Catch:{ SQLiteException -> 0x018b }
            if (r10 == 0) goto L_0x012e
            com.google.android.gms.measurement.internal.zzaf r10 = r18.zze()     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean> r11 = com.google.android.gms.measurement.internal.zzbi.zzcq     // Catch:{ SQLiteException -> 0x018b }
            boolean r10 = r10.zza((com.google.android.gms.measurement.internal.zzfi<java.lang.Boolean>) r11)     // Catch:{ SQLiteException -> 0x018b }
            if (r10 == 0) goto L_0x012e
            boolean r10 = r5.isEmpty()     // Catch:{ SQLiteException -> 0x018b }
            if (r10 != 0) goto L_0x012e
            java.lang.Object r10 = r5.get(r3)     // Catch:{ SQLiteException -> 0x018b }
            android.util.Pair r10 = (android.util.Pair) r10     // Catch:{ SQLiteException -> 0x018b }
            java.lang.Object r10 = r10.first     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.internal.measurement.zzfi$zzj r10 = (com.google.android.gms.internal.measurement.zzfi.zzj) r10     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.internal.measurement.zzkj r11 = r9.zzab()     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.internal.measurement.zzix r11 = (com.google.android.gms.internal.measurement.zzix) r11     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.internal.measurement.zzfi$zzj r11 = (com.google.android.gms.internal.measurement.zzfi.zzj) r11     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r12 = r10.zzac()     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r13 = r11.zzac()     // Catch:{ SQLiteException -> 0x018b }
            boolean r12 = r12.equals(r13)     // Catch:{ SQLiteException -> 0x018b }
            if (r12 == 0) goto L_0x012b
            java.lang.String r12 = r10.zzab()     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r13 = r11.zzab()     // Catch:{ SQLiteException -> 0x018b }
            boolean r12 = r12.equals(r13)     // Catch:{ SQLiteException -> 0x018b }
            if (r12 == 0) goto L_0x012b
            boolean r12 = r10.zzas()     // Catch:{ SQLiteException -> 0x018b }
            boolean r13 = r11.zzas()     // Catch:{ SQLiteException -> 0x018b }
            if (r12 != r13) goto L_0x012b
            java.lang.String r12 = r10.zzad()     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r13 = r11.zzad()     // Catch:{ SQLiteException -> 0x018b }
            boolean r12 = r12.equals(r13)     // Catch:{ SQLiteException -> 0x018b }
            if (r12 == 0) goto L_0x012b
            java.util.List r10 = r10.zzaq()     // Catch:{ SQLiteException -> 0x018b }
            java.util.Iterator r10 = r10.iterator()     // Catch:{ SQLiteException -> 0x018b }
        L_0x00e0:
            boolean r12 = r10.hasNext()     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r13 = "_npa"
            r14 = -1
            if (r12 == 0) goto L_0x0101
            java.lang.Object r12 = r10.next()     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.internal.measurement.zzfi$zzn r12 = (com.google.android.gms.internal.measurement.zzfi.zzn) r12     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r2 = r12.zzg()     // Catch:{ SQLiteException -> 0x018b }
            boolean r2 = r13.equals(r2)     // Catch:{ SQLiteException -> 0x018b }
            if (r2 == 0) goto L_0x00ff
            long r16 = r12.zzc()     // Catch:{ SQLiteException -> 0x018b }
            goto L_0x0103
        L_0x00ff:
            r2 = 1
            goto L_0x00e0
        L_0x0101:
            r16 = r14
        L_0x0103:
            java.util.List r2 = r11.zzaq()     // Catch:{ SQLiteException -> 0x018b }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ SQLiteException -> 0x018b }
        L_0x010b:
            boolean r10 = r2.hasNext()     // Catch:{ SQLiteException -> 0x018b }
            if (r10 == 0) goto L_0x0125
            java.lang.Object r10 = r2.next()     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.internal.measurement.zzfi$zzn r10 = (com.google.android.gms.internal.measurement.zzfi.zzn) r10     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r11 = r10.zzg()     // Catch:{ SQLiteException -> 0x018b }
            boolean r11 = r13.equals(r11)     // Catch:{ SQLiteException -> 0x018b }
            if (r11 == 0) goto L_0x010b
            long r14 = r10.zzc()     // Catch:{ SQLiteException -> 0x018b }
        L_0x0125:
            int r2 = (r16 > r14 ? 1 : (r16 == r14 ? 0 : -1))
            if (r2 != 0) goto L_0x012b
            r2 = 1
            goto L_0x012c
        L_0x012b:
            r2 = r3
        L_0x012c:
            if (r2 == 0) goto L_0x0183
        L_0x012e:
            r2 = 2
            boolean r10 = r4.isNull(r2)     // Catch:{ SQLiteException -> 0x018b }
            if (r10 != 0) goto L_0x013c
            int r2 = r4.getInt(r2)     // Catch:{ SQLiteException -> 0x018b }
            r9.zzh((int) r2)     // Catch:{ SQLiteException -> 0x018b }
        L_0x013c:
            int r0 = r0.length     // Catch:{ SQLiteException -> 0x018b }
            int r6 = r6 + r0
            com.google.android.gms.internal.measurement.zzkj r0 = r9.zzab()     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.internal.measurement.zzix r0 = (com.google.android.gms.internal.measurement.zzix) r0     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.internal.measurement.zzfi$zzj r0 = (com.google.android.gms.internal.measurement.zzfi.zzj) r0     // Catch:{ SQLiteException -> 0x018b }
            java.lang.Long r2 = java.lang.Long.valueOf(r7)     // Catch:{ SQLiteException -> 0x018b }
            android.util.Pair r0 = android.util.Pair.create(r0, r2)     // Catch:{ SQLiteException -> 0x018b }
            r5.add(r0)     // Catch:{ SQLiteException -> 0x018b }
            goto L_0x0177
        L_0x0152:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r18.zzj()     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzg()     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r7 = "Failed to merge queued bundle. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x018b }
            r2.zza(r7, r8, r0)     // Catch:{ SQLiteException -> 0x018b }
            goto L_0x0177
        L_0x0165:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r2 = r18.zzj()     // Catch:{ SQLiteException -> 0x018b }
            com.google.android.gms.measurement.internal.zzft r2 = r2.zzg()     // Catch:{ SQLiteException -> 0x018b }
            java.lang.String r7 = "Failed to unzip queued bundle. appId"
            java.lang.Object r8 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r19)     // Catch:{ SQLiteException -> 0x018b }
            r2.zza(r7, r8, r0)     // Catch:{ SQLiteException -> 0x018b }
        L_0x0177:
            boolean r0 = r4.moveToNext()     // Catch:{ SQLiteException -> 0x018b }
            if (r0 == 0) goto L_0x0183
            if (r6 <= r1) goto L_0x0180
            goto L_0x0183
        L_0x0180:
            r2 = 1
            goto L_0x0056
        L_0x0183:
            if (r4 == 0) goto L_0x0188
            r4.close()
        L_0x0188:
            return r5
        L_0x0189:
            r0 = move-exception
            goto L_0x01a7
        L_0x018b:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzfr r1 = r18.zzj()     // Catch:{ all -> 0x0189 }
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzg()     // Catch:{ all -> 0x0189 }
            java.lang.String r2 = "Error querying bundles. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r19)     // Catch:{ all -> 0x0189 }
            r1.zza(r2, r3, r0)     // Catch:{ all -> 0x0189 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0189 }
            if (r4 == 0) goto L_0x01a6
            r4.close()
        L_0x01a6:
            return r0
        L_0x01a7:
            if (r4 == 0) goto L_0x01ac
            r4.close()
        L_0x01ac:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zza(java.lang.String, int, int):java.util.List");
    }

    public final List<zzad> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList(3);
        arrayList.add(str);
        StringBuilder sb = new StringBuilder("app_id=?");
        if (!TextUtils.isEmpty(str2)) {
            arrayList.add(str2);
            sb.append(" and origin=?");
        }
        if (!TextUtils.isEmpty(str3)) {
            arrayList.add(str3 + ProxyConfig.MATCH_ALL_SCHEMES);
            sb.append(" and name glob ?");
        }
        return zza(sb.toString(), (String[]) arrayList.toArray(new String[arrayList.size()]));
    }

    public final List<zzad> zza(String str, String[] strArr) {
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e_().query("conditional_properties", new String[]{"app_id", "origin", "name", "value", "active", AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, "timed_out_event", AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, "triggered_event", AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, "expired_event"}, str, strArr, (String) null, (String) null, "rowid", "1001");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            while (true) {
                if (arrayList.size() < 1000) {
                    boolean z = false;
                    String string = cursor.getString(0);
                    String string2 = cursor.getString(1);
                    String string3 = cursor.getString(2);
                    Object zza2 = zza(cursor, 3);
                    if (cursor.getInt(4) != 0) {
                        z = true;
                    }
                    String string4 = cursor.getString(5);
                    long j = cursor.getLong(6);
                    boolean z2 = z;
                    zzad zzad = r3;
                    zzad zzad2 = new zzad(string, string2, new zznc(string3, cursor.getLong(10), zza2, string2), cursor.getLong(8), z2, string4, (zzbg) g_().zza(cursor.getBlob(7), zzbg.CREATOR), j, (zzbg) g_().zza(cursor.getBlob(9), zzbg.CREATOR), cursor.getLong(11), (zzbg) g_().zza(cursor.getBlob(12), zzbg.CREATOR));
                    arrayList.add(zzad);
                    if (!cursor.moveToNext()) {
                        break;
                    }
                } else {
                    zzj().zzg().zza("Read more than the max allowed conditional properties, ignoring extra", 1000);
                    break;
                }
            }
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying conditional user property value", e);
            List<zzad> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzmh> zzh(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e_().query("trigger_uris", new String[]{"trigger_uri", "timestamp_millis", "source"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", (String) null);
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                String string = cursor.getString(0);
                if (string == null) {
                    string = "";
                }
                arrayList.add(new zzmh(string, cursor.getLong(1), cursor.getInt(2)));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying trigger uris. appId", zzfr.zza(str), e);
            List<zzmh> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    public final List<zzne> zzi(String str) {
        Preconditions.checkNotEmpty(str);
        zzt();
        zzak();
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            cursor = e_().query("user_attributes", new String[]{"name", "origin", "set_timestamp", "value"}, "app_id=?", new String[]{str}, (String) null, (String) null, "rowid", "1000");
            if (!cursor.moveToFirst()) {
                if (cursor != null) {
                    cursor.close();
                }
                return arrayList;
            }
            do {
                String string = cursor.getString(0);
                String string2 = cursor.getString(1);
                if (string2 == null) {
                    string2 = "";
                }
                String str2 = string2;
                long j = cursor.getLong(2);
                Object zza2 = zza(cursor, 3);
                if (zza2 == null) {
                    zzj().zzg().zza("Read invalid user property value, ignoring it. appId", zzfr.zza(str));
                } else {
                    arrayList.add(new zzne(str, str2, string, j, zza2));
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayList;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error querying user properties. appId", zzfr.zza(str), e);
            List<zzne> emptyList = Collections.emptyList();
            if (cursor != null) {
                cursor.close();
            }
            return emptyList;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00f7, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00f8, code lost:
        r13 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ff, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0100, code lost:
        r13 = r22;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0103, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0104, code lost:
        r13 = r22;
        r12 = r23;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ff A[ExcHandler: all (th java.lang.Throwable), PHI: r2 
      PHI: (r2v3 android.database.Cursor) = (r2v0 android.database.Cursor), (r2v0 android.database.Cursor), (r2v0 android.database.Cursor), (r2v5 android.database.Cursor), (r2v0 android.database.Cursor) binds: [B:1:0x0011, B:2:?, B:4:0x0019, B:19:0x0093, B:8:0x002b] A[DONT_GENERATE, DONT_INLINE], Splitter:B:1:0x0011] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x0128  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.google.android.gms.measurement.internal.zzne> zzb(java.lang.String r23, java.lang.String r24, java.lang.String r25) {
        /*
            r22 = this;
            r0 = r25
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r23)
            r22.zzt()
            r22.zzak()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            r2 = 0
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ SQLiteException -> 0x0103, all -> 0x00ff }
            r4 = 3
            r3.<init>(r4)     // Catch:{ SQLiteException -> 0x0103, all -> 0x00ff }
            r12 = r23
            r3.add(r12)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00ff }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00ff }
            java.lang.String r6 = "app_id=?"
            r5.<init>(r6)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00ff }
            boolean r6 = android.text.TextUtils.isEmpty(r24)     // Catch:{ SQLiteException -> 0x00fb, all -> 0x00ff }
            if (r6 != 0) goto L_0x0034
            r6 = r24
            r3.add(r6)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.String r7 = " and origin=?"
            r5.append(r7)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            goto L_0x0036
        L_0x0034:
            r6 = r24
        L_0x0036:
            boolean r7 = android.text.TextUtils.isEmpty(r25)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            if (r7 != 0) goto L_0x0057
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r7.<init>()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.StringBuilder r7 = r7.append(r0)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.String r8 = "*"
            java.lang.StringBuilder r7 = r7.append(r8)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.String r7 = r7.toString()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r3.add(r7)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.String r7 = " and name glob ?"
            r5.append(r7)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
        L_0x0057:
            int r7 = r3.size()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.String[] r7 = new java.lang.String[r7]     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.Object[] r3 = r3.toArray(r7)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r17 = r3
            java.lang.String[] r17 = (java.lang.String[]) r17     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            android.database.sqlite.SQLiteDatabase r13 = r22.e_()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.String r14 = "user_attributes"
            java.lang.String r3 = "name"
            java.lang.String r7 = "set_timestamp"
            java.lang.String r8 = "value"
            java.lang.String r9 = "origin"
            java.lang.String[] r15 = new java.lang.String[]{r3, r7, r8, r9}     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.String r16 = r5.toString()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r18 = 0
            r19 = 0
            java.lang.String r20 = "rowid"
            java.lang.String r21 = "1001"
            android.database.Cursor r2 = r13.query(r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            boolean r3 = r2.moveToFirst()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            if (r3 != 0) goto L_0x0093
            if (r2 == 0) goto L_0x0092
            r2.close()
        L_0x0092:
            return r1
        L_0x0093:
            int r3 = r1.size()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r3 < r5) goto L_0x00af
            com.google.android.gms.measurement.internal.zzfr r0 = r22.zzj()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            com.google.android.gms.measurement.internal.zzft r0 = r0.zzg()     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            java.lang.String r3 = "Read more than the max allowed user properties, ignoring excess"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r0.zza(r3, r4)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r13 = r22
            goto L_0x00ea
        L_0x00af:
            r3 = 0
            java.lang.String r8 = r2.getString(r3)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r3 = 1
            long r9 = r2.getLong(r3)     // Catch:{ SQLiteException -> 0x00f7, all -> 0x00ff }
            r3 = 2
            r13 = r22
            java.lang.Object r11 = r13.zza((android.database.Cursor) r2, (int) r3)     // Catch:{ SQLiteException -> 0x00f5 }
            java.lang.String r3 = r2.getString(r4)     // Catch:{ SQLiteException -> 0x00f5 }
            if (r11 != 0) goto L_0x00d8
            com.google.android.gms.measurement.internal.zzfr r5 = r22.zzj()     // Catch:{ SQLiteException -> 0x00f2 }
            com.google.android.gms.measurement.internal.zzft r5 = r5.zzg()     // Catch:{ SQLiteException -> 0x00f2 }
            java.lang.String r6 = "(2)Read invalid user property value, ignoring it"
            java.lang.Object r7 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r23)     // Catch:{ SQLiteException -> 0x00f2 }
            r5.zza(r6, r7, r3, r0)     // Catch:{ SQLiteException -> 0x00f2 }
            goto L_0x00e4
        L_0x00d8:
            com.google.android.gms.measurement.internal.zzne r14 = new com.google.android.gms.measurement.internal.zzne     // Catch:{ SQLiteException -> 0x00f2 }
            r5 = r14
            r6 = r23
            r7 = r3
            r5.<init>(r6, r7, r8, r9, r11)     // Catch:{ SQLiteException -> 0x00f2 }
            r1.add(r14)     // Catch:{ SQLiteException -> 0x00f2 }
        L_0x00e4:
            boolean r5 = r2.moveToNext()     // Catch:{ SQLiteException -> 0x00f2 }
            if (r5 != 0) goto L_0x00f0
        L_0x00ea:
            if (r2 == 0) goto L_0x00ef
            r2.close()
        L_0x00ef:
            return r1
        L_0x00f0:
            r6 = r3
            goto L_0x0093
        L_0x00f2:
            r0 = move-exception
            r6 = r3
            goto L_0x010a
        L_0x00f5:
            r0 = move-exception
            goto L_0x010a
        L_0x00f7:
            r0 = move-exception
            r13 = r22
            goto L_0x010a
        L_0x00fb:
            r0 = move-exception
            r13 = r22
            goto L_0x0108
        L_0x00ff:
            r0 = move-exception
            r13 = r22
            goto L_0x0126
        L_0x0103:
            r0 = move-exception
            r13 = r22
            r12 = r23
        L_0x0108:
            r6 = r24
        L_0x010a:
            com.google.android.gms.measurement.internal.zzfr r1 = r22.zzj()     // Catch:{ all -> 0x0125 }
            com.google.android.gms.measurement.internal.zzft r1 = r1.zzg()     // Catch:{ all -> 0x0125 }
            java.lang.String r3 = "(2)Error querying user properties"
            java.lang.Object r4 = com.google.android.gms.measurement.internal.zzfr.zza((java.lang.String) r23)     // Catch:{ all -> 0x0125 }
            r1.zza(r3, r4, r6, r0)     // Catch:{ all -> 0x0125 }
            java.util.List r0 = java.util.Collections.emptyList()     // Catch:{ all -> 0x0125 }
            if (r2 == 0) goto L_0x0124
            r2.close()
        L_0x0124:
            return r0
        L_0x0125:
            r0 = move-exception
        L_0x0126:
            if (r2 == 0) goto L_0x012b
            r2.close()
        L_0x012b:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzao.zzb(java.lang.String, java.lang.String, java.lang.String):java.util.List");
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, zzfi.zzl> zzj(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Cursor cursor = null;
        try {
            cursor = e_().query("audience_filter_values", new String[]{"audience_id", "current_results"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, zzfi.zzl> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            ArrayMap arrayMap = new ArrayMap();
            do {
                int i = cursor.getInt(0);
                try {
                    arrayMap.put(Integer.valueOf(i), (zzfi.zzl) ((zzix) ((zzfi.zzl.zza) zzmz.zza(zzfi.zzl.zze(), cursor.getBlob(1))).zzab()));
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter results. appId, audienceId, error", zzfr.zza(str), Integer.valueOf(i), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filter results. appId", zzfr.zza(str), e2);
            Map<Integer, zzfi.zzl> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzew.zzb>> zzk(String str) {
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=?", new String[]{str}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzew.zzb>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzew.zzb zzb2 = (zzew.zzb) ((zzix) ((zzew.zzb.zza) zzmz.zza(zzew.zzb.zzc(), cursor.getBlob(1))).zzab());
                    if (zzb2.zzk()) {
                        int i = cursor.getInt(0);
                        List list = (List) arrayMap.get(Integer.valueOf(i));
                        if (list == null) {
                            list = new ArrayList();
                            arrayMap.put(Integer.valueOf(i), list);
                        }
                        list.add(zzb2);
                    }
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter. appId", zzfr.zza(str), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzfr.zza(str), e2);
            Map<Integer, List<zzew.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzew.zzb>> zzf(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = e_().query("event_filters", new String[]{"audience_id", "data"}, "app_id=? AND event_name=?", new String[]{str, str2}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzew.zzb>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzew.zzb zzb2 = (zzew.zzb) ((zzix) ((zzew.zzb.zza) zzmz.zza(zzew.zzb.zzc(), cursor.getBlob(1))).zzab());
                    int i = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(zzb2);
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter. appId", zzfr.zza(str), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzfr.zza(str), e2);
            Map<Integer, List<zzew.zzb>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<zzew.zze>> zzg(String str, String str2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = e_().query("property_filters", new String[]{"audience_id", "data"}, "app_id=? AND property_name=?", new String[]{str, str2}, (String) null, (String) null, (String) null);
            if (!cursor.moveToFirst()) {
                Map<Integer, List<zzew.zze>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                try {
                    zzew.zze zze2 = (zzew.zze) ((zzix) ((zzew.zze.zza) zzmz.zza(zzew.zze.zzc(), cursor.getBlob(1))).zzab());
                    int i = cursor.getInt(0);
                    List list = (List) arrayMap.get(Integer.valueOf(i));
                    if (list == null) {
                        list = new ArrayList();
                        arrayMap.put(Integer.valueOf(i), list);
                    }
                    list.add(zze2);
                } catch (IOException e) {
                    zzj().zzg().zza("Failed to merge filter", zzfr.zza(str), e);
                }
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e2) {
            zzj().zzg().zza("Database error querying filters. appId", zzfr.zza(str), e2);
            Map<Integer, List<zzew.zze>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public final Map<Integer, List<Integer>> zzl(String str) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        ArrayMap arrayMap = new ArrayMap();
        Cursor cursor = null;
        try {
            cursor = e_().rawQuery("select audience_id, filter_id from event_filters where app_id = ? and session_scoped = 1 UNION select audience_id, filter_id from property_filters where app_id = ? and session_scoped = 1;", new String[]{str, str});
            if (!cursor.moveToFirst()) {
                Map<Integer, List<Integer>> emptyMap = Collections.emptyMap();
                if (cursor != null) {
                    cursor.close();
                }
                return emptyMap;
            }
            do {
                int i = cursor.getInt(0);
                List list = (List) arrayMap.get(Integer.valueOf(i));
                if (list == null) {
                    list = new ArrayList();
                    arrayMap.put(Integer.valueOf(i), list);
                }
                list.add(Integer.valueOf(cursor.getInt(1)));
            } while (cursor.moveToNext());
            if (cursor != null) {
                cursor.close();
            }
            return arrayMap;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying scoped filters. appId", zzfr.zza(str), e);
            Map<Integer, List<Integer>> emptyMap2 = Collections.emptyMap();
            if (cursor != null) {
                cursor.close();
            }
            return emptyMap2;
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
    }

    zzao(zzmp zzmp) {
        super(zzmp);
    }

    public final void zzp() {
        zzak();
        e_().beginTransaction();
    }

    public final void zzu() {
        zzak();
        e_().endTransaction();
    }

    /* access modifiers changed from: package-private */
    public final void zza(List<Long> list) {
        zzt();
        zzak();
        Preconditions.checkNotNull(list);
        Preconditions.checkNotZero(list.size());
        if (zzan()) {
            String str = "(" + TextUtils.join(",", list) + ")";
            if (zzb("SELECT COUNT(1) FROM queue WHERE rowid IN " + str + " AND retry_count =  2147483647 LIMIT 1", (String[]) null) > 0) {
                zzj().zzu().zza("The number of upload retries exceeds the limit. Will remain unchanged.");
            }
            try {
                e_().execSQL("UPDATE queue SET retry_count = IFNULL(retry_count, 0) + 1 WHERE rowid IN " + str + " AND (retry_count IS NULL OR retry_count < 2147483647)");
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error incrementing retry count. error", e);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzv() {
        int delete;
        zzt();
        zzak();
        if (zzan()) {
            long zza2 = zzn().zza.zza();
            long elapsedRealtime = zzb().elapsedRealtime();
            if (Math.abs(elapsedRealtime - zza2) > zzbi.zzy.zza(null).longValue()) {
                zzn().zza.zza(elapsedRealtime);
                zzt();
                zzak();
                if (zzan() && (delete = e_().delete("queue", "abs(bundle_end_timestamp - ?) > cast(? as integer)", new String[]{String.valueOf(zzb().currentTimeMillis()), String.valueOf(zzaf.zzm())})) > 0) {
                    zzj().zzp().zza("Deleted stale rows. rowsDeleted", Integer.valueOf(delete));
                }
            }
        }
    }

    public final void zzh(String str, String str2) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzt();
        zzak();
        try {
            e_().delete("user_attributes", "app_id=? and name=?", new String[]{str, str2});
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error deleting user property. appId", zzfr.zza(str), zzi().zzc(str2), e);
        }
    }

    private static void zza(ContentValues contentValues, String str, Object obj) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(obj);
        if (obj instanceof String) {
            contentValues.put(str, (String) obj);
        } else if (obj instanceof Long) {
            contentValues.put(str, (Long) obj);
        } else if (obj instanceof Double) {
            contentValues.put(str, (Double) obj);
        } else {
            throw new IllegalArgumentException("Invalid value type");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, List<zzew.zza> list) {
        boolean z;
        boolean z2;
        String str2 = str;
        List<zzew.zza> list2 = list;
        Preconditions.checkNotNull(list);
        for (int i = 0; i < list.size(); i++) {
            zzix.zzb zzby = list2.get(i).zzby();
            zzix.zzb zzb2 = zzby;
            zzew.zza.C0036zza zza2 = (zzew.zza.C0036zza) zzby;
            if (zza2.zza() != 0) {
                for (int i2 = 0; i2 < zza2.zza(); i2++) {
                    zzix.zzb zzby2 = zza2.zza(i2).zzby();
                    zzix.zzb zzb3 = zzby2;
                    zzew.zzb.zza zza3 = (zzew.zzb.zza) zzby2;
                    zzew.zzb.zza zza4 = (zzew.zzb.zza) ((zzix.zzb) zza3.clone());
                    String zzb4 = zzii.zzb(zza3.zzb());
                    if (zzb4 != null) {
                        zza4.zza(zzb4);
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    for (int i3 = 0; i3 < zza3.zza(); i3++) {
                        zzew.zzc zza5 = zza3.zza(i3);
                        String zza6 = zzik.zza(zza5.zze());
                        if (zza6 != null) {
                            zzix.zzb zzby3 = zza5.zzby();
                            zzix.zzb zzb5 = zzby3;
                            zza4.zza(i3, (zzew.zzc) ((zzix) ((zzew.zzc.zza) zzby3).zza(zza6).zzab()));
                            z2 = true;
                        }
                    }
                    if (z2) {
                        zza2 = zza2.zza(i2, zza4);
                        list2.set(i, (zzew.zza) ((zzix) zza2.zzab()));
                    }
                }
            }
            if (zza2.zzb() != 0) {
                for (int i4 = 0; i4 < zza2.zzb(); i4++) {
                    zzew.zze zzb6 = zza2.zzb(i4);
                    String zza7 = zzij.zza(zzb6.zze());
                    if (zza7 != null) {
                        zzix.zzb zzby4 = zzb6.zzby();
                        zzix.zzb zzb7 = zzby4;
                        zza2 = zza2.zza(i4, ((zzew.zze.zza) zzby4).zza(zza7));
                        list2.set(i, (zzew.zza) ((zzix) zza2.zzab()));
                    }
                }
            }
        }
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(list);
        SQLiteDatabase e_ = e_();
        e_.beginTransaction();
        try {
            zzak();
            zzt();
            Preconditions.checkNotEmpty(str);
            SQLiteDatabase e_2 = e_();
            e_2.delete("property_filters", "app_id=?", new String[]{str2});
            e_2.delete("event_filters", "app_id=?", new String[]{str2});
            for (zzew.zza next : list) {
                zzak();
                zzt();
                Preconditions.checkNotEmpty(str);
                Preconditions.checkNotNull(next);
                if (!next.zzg()) {
                    zzj().zzu().zza("Audience with no ID. appId", zzfr.zza(str));
                } else {
                    int zza8 = next.zza();
                    Iterator<zzew.zzb> it = next.zze().iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (!it.next().zzl()) {
                                zzj().zzu().zza("Event filter with no ID. Audience definition ignored. appId, audienceId", zzfr.zza(str), Integer.valueOf(zza8));
                                break;
                            }
                        } else {
                            Iterator<zzew.zze> it2 = next.zzf().iterator();
                            while (true) {
                                if (it2.hasNext()) {
                                    if (!it2.next().zzi()) {
                                        zzj().zzu().zza("Property filter with no ID. Audience definition ignored. appId, audienceId", zzfr.zza(str), Integer.valueOf(zza8));
                                        break;
                                    }
                                } else {
                                    Iterator<zzew.zzb> it3 = next.zze().iterator();
                                    while (true) {
                                        if (it3.hasNext()) {
                                            if (!zza(str2, zza8, it3.next())) {
                                                z = false;
                                                break;
                                            }
                                        } else {
                                            z = true;
                                            break;
                                        }
                                    }
                                    if (z) {
                                        Iterator<zzew.zze> it4 = next.zzf().iterator();
                                        while (true) {
                                            if (it4.hasNext()) {
                                                if (!zza(str2, zza8, it4.next())) {
                                                    z = false;
                                                    break;
                                                }
                                            } else {
                                                break;
                                            }
                                        }
                                    }
                                    if (!z) {
                                        zzak();
                                        zzt();
                                        Preconditions.checkNotEmpty(str);
                                        SQLiteDatabase e_3 = e_();
                                        e_3.delete("property_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zza8)});
                                        e_3.delete("event_filters", "app_id=? and audience_id=?", new String[]{str2, String.valueOf(zza8)});
                                    }
                                }
                            }
                        }
                    }
                }
            }
            ArrayList arrayList = new ArrayList();
            for (zzew.zza next2 : list) {
                arrayList.add(next2.zzg() ? Integer.valueOf(next2.zza()) : null);
            }
            zzb(str2, (List<Integer>) arrayList);
            e_.setTransactionSuccessful();
        } finally {
            e_.endTransaction();
        }
    }

    public final void zzw() {
        zzak();
        e_().setTransactionSuccessful();
    }

    public final void zza(zzh zzh2) {
        Preconditions.checkNotNull(zzh2);
        zzt();
        zzak();
        String zzx = zzh2.zzx();
        Preconditions.checkNotNull(zzx);
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzx);
        contentValues.put("app_instance_id", zzh2.zzy());
        contentValues.put("gmp_app_id", zzh2.zzac());
        contentValues.put("resettable_device_id_hash", zzh2.zzae());
        contentValues.put("last_bundle_index", Long.valueOf(zzh2.zzq()));
        contentValues.put("last_bundle_start_timestamp", Long.valueOf(zzh2.zzr()));
        contentValues.put("last_bundle_end_timestamp", Long.valueOf(zzh2.zzp()));
        contentValues.put(App.JsonKeys.APP_VERSION, zzh2.zzaa());
        contentValues.put("app_store", zzh2.zzz());
        contentValues.put("gmp_version", Long.valueOf(zzh2.zzo()));
        contentValues.put("dev_cert_hash", Long.valueOf(zzh2.zzl()));
        contentValues.put("measurement_enabled", Boolean.valueOf(zzh2.zzak()));
        contentValues.put("day", Long.valueOf(zzh2.zzk()));
        contentValues.put("daily_public_events_count", Long.valueOf(zzh2.zzi()));
        contentValues.put("daily_events_count", Long.valueOf(zzh2.zzh()));
        contentValues.put("daily_conversions_count", Long.valueOf(zzh2.zzf()));
        contentValues.put("config_fetched_time", Long.valueOf(zzh2.zze()));
        contentValues.put("failed_config_fetch_time", Long.valueOf(zzh2.zzn()));
        contentValues.put("app_version_int", Long.valueOf(zzh2.zzc()));
        contentValues.put("firebase_instance_id", zzh2.zzab());
        contentValues.put("daily_error_events_count", Long.valueOf(zzh2.zzg()));
        contentValues.put("daily_realtime_events_count", Long.valueOf(zzh2.zzj()));
        contentValues.put("health_monitor_sample", zzh2.zzad());
        contentValues.put("android_id", Long.valueOf(zzh2.zzb()));
        contentValues.put("adid_reporting_enabled", Boolean.valueOf(zzh2.zzaj()));
        contentValues.put("admob_app_id", zzh2.zzv());
        contentValues.put("dynamite_version", Long.valueOf(zzh2.zzm()));
        contentValues.put("session_stitching_token", zzh2.zzaf());
        contentValues.put("sgtm_upload_enabled", Boolean.valueOf(zzh2.zzam()));
        contentValues.put("target_os_version", Long.valueOf(zzh2.zzt()));
        contentValues.put("session_stitching_token_hash", Long.valueOf(zzh2.zzs()));
        if (zzpg.zza() && zze().zze(zzx, zzbi.zzcf)) {
            contentValues.put("ad_services_version", Integer.valueOf(zzh2.zza()));
            contentValues.put("attribution_eligibility_status", Long.valueOf(zzh2.zzd()));
        }
        if (zznk.zza() && zze().zze(zzx, zzbi.zzcr)) {
            contentValues.put("unmatched_first_open_without_ad_id", Boolean.valueOf(zzh2.zzan()));
        }
        List<String> zzag = zzh2.zzag();
        if (zzag != null) {
            if (zzag.isEmpty()) {
                zzj().zzu().zza("Safelisted events should not be an empty list. appId", zzx);
            } else {
                contentValues.put("safelisted_events", TextUtils.join(",", zzag));
            }
        }
        if (zznq.zza() && zze().zza(zzbi.zzbp) && !contentValues.containsKey("safelisted_events")) {
            contentValues.put("safelisted_events", (String) null);
        }
        if (zznp.zza() && zze().zze(zzx, zzbi.zzcm)) {
            contentValues.put("npa_metadata_value", zzh2.zzu());
        }
        try {
            SQLiteDatabase e_ = e_();
            if (((long) e_.update("apps", contentValues, "app_id = ?", new String[]{zzx})) == 0 && e_.insertWithOnConflict("apps", (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update app (got -1). appId", zzfr.zza(zzx));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing app. appId", zzfr.zza(zzx), e);
        }
    }

    public final void zza(String str, zzih zzih) {
        Preconditions.checkNotNull(str);
        Preconditions.checkNotNull(zzih);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("consent_state", zzih.zze());
        if (!zznp.zza() || !zze().zza(zzbi.zzcm)) {
            try {
                if (e_().insertWithOnConflict("consent_settings", (String) null, contentValues, 5) == -1) {
                    zzj().zzg().zza("Failed to insert/update consent setting (got -1). appId", zzfr.zza(str));
                }
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing consent setting. appId, error", zzfr.zza(str), e);
            }
        } else {
            contentValues.put("consent_source", Integer.valueOf(zzih.zza()));
            zza("consent_settings", "app_id", contentValues);
        }
    }

    public final void zza(String str, zzay zzay) {
        if (zznp.zza() && zze().zza(zzbi.zzcm)) {
            Preconditions.checkNotNull(str);
            Preconditions.checkNotNull(zzay);
            zzt();
            zzak();
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", str);
            contentValues.put("dma_consent_settings", zzay.zzf());
            zza("consent_settings", "app_id", contentValues);
        }
    }

    public final void zza(zzbc zzbc) {
        Preconditions.checkNotNull(zzbc);
        zzt();
        zzak();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzbc.zza);
        contentValues.put("name", zzbc.zzb);
        contentValues.put("lifetime_count", Long.valueOf(zzbc.zzc));
        contentValues.put("current_bundle_count", Long.valueOf(zzbc.zzd));
        contentValues.put("last_fire_timestamp", Long.valueOf(zzbc.zzf));
        contentValues.put("last_bundled_timestamp", Long.valueOf(zzbc.zzg));
        contentValues.put("last_bundled_day", zzbc.zzh);
        contentValues.put("last_sampled_complex_event_id", zzbc.zzi);
        contentValues.put("last_sampling_rate", zzbc.zzj);
        contentValues.put("current_session_count", Long.valueOf(zzbc.zze));
        contentValues.put("last_exempt_from_sampling", (zzbc.zzk == null || !zzbc.zzk.booleanValue()) ? null : 1L);
        try {
            if (e_().insertWithOnConflict("events", (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update event aggregates (got -1). appId", zzfr.zza(zzbc.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event aggregates. appId", zzfr.zza(zzbc.zza), e);
        }
    }

    private final void zza(String str, String str2, ContentValues contentValues) {
        try {
            SQLiteDatabase e_ = e_();
            String asString = contentValues.getAsString(str2);
            if (asString == null) {
                zzj().zzh().zza("Value of the primary key is not set.", zzfr.zza(str2));
                return;
            }
            if (((long) e_.update(str, contentValues, str2 + " = ?", new String[]{asString})) == 0 && e_.insertWithOnConflict(str, (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update table (got -1). key", zzfr.zza(str), zzfr.zza(str2));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing into table. key", zzfr.zza(str), zzfr.zza(str2), e);
        }
    }

    private final boolean zzb(String str, List<Integer> list) {
        Preconditions.checkNotEmpty(str);
        zzak();
        zzt();
        SQLiteDatabase e_ = e_();
        try {
            long zzb2 = zzb("select count(1) from audience_filter_values where app_id=?", new String[]{str});
            int max = Math.max(0, Math.min(2000, zze().zzb(str, zzbi.zzaf)));
            if (zzb2 <= ((long) max)) {
                return false;
            }
            ArrayList arrayList = new ArrayList();
            for (int i = 0; i < list.size(); i++) {
                Integer num = list.get(i);
                if (num == null) {
                    return false;
                }
                arrayList.add(Integer.toString(num.intValue()));
            }
            return e_.delete("audience_filter_values", new StringBuilder("audience_id in (select audience_id from audience_filter_values where app_id=? and audience_id not in ").append(new StringBuilder("(").append(TextUtils.join(",", arrayList)).append(")").toString()).append(" order by rowid desc limit -1 offset ?)").toString(), new String[]{str, Integer.toString(max)}) > 0;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Database error querying filters. appId", zzfr.zza(str), e);
            return false;
        }
    }

    public final boolean zzx() {
        return zzb("select count(1) > 0 from raw_events", (String[]) null) != 0;
    }

    public final boolean zzy() {
        return zzb("select count(1) > 0 from queue where has_realtime = 1", (String[]) null) != 0;
    }

    public final boolean zzz() {
        return zzb("select count(1) > 0 from raw_events where realtime = 1", (String[]) null) != 0;
    }

    public final boolean zza(zzfi.zzj zzj2, boolean z) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzj2);
        Preconditions.checkNotEmpty(zzj2.zzx());
        Preconditions.checkState(zzj2.zzbe());
        zzv();
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzj2.zzl() < currentTimeMillis - zzaf.zzm() || zzj2.zzl() > zzaf.zzm() + currentTimeMillis) {
            zzj().zzu().zza("Storing bundle outside of the max uploading time span. appId, now, timestamp", zzfr.zza(zzj2.zzx()), Long.valueOf(currentTimeMillis), Long.valueOf(zzj2.zzl()));
        }
        try {
            byte[] zzb2 = g_().zzb(zzj2.zzbv());
            zzj().zzp().zza("Saving bundle, size", Integer.valueOf(zzb2.length));
            ContentValues contentValues = new ContentValues();
            contentValues.put("app_id", zzj2.zzx());
            contentValues.put("bundle_end_timestamp", Long.valueOf(zzj2.zzl()));
            contentValues.put("data", zzb2);
            contentValues.put("has_realtime", Integer.valueOf(z ? 1 : 0));
            if (zzj2.zzbl()) {
                contentValues.put("retry_count", Integer.valueOf(zzj2.zzf()));
            }
            try {
                if (e_().insert("queue", (String) null, contentValues) != -1) {
                    return true;
                }
                zzj().zzg().zza("Failed to insert bundle (got -1). appId", zzfr.zza(zzj2.zzx()));
                return false;
            } catch (SQLiteException e) {
                zzj().zzg().zza("Error storing bundle. appId", zzfr.zza(zzj2.zzx()), e);
                return false;
            }
        } catch (IOException e2) {
            zzj().zzg().zza("Data loss. Failed to serialize bundle. appId", zzfr.zza(zzj2.zzx()), e2);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzew.zzb zzb2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zzb2);
        Integer num = null;
        if (zzb2.zzf().isEmpty()) {
            zzft zzu = zzj().zzu();
            Object zza2 = zzfr.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zzb2.zzl()) {
                num = Integer.valueOf(zzb2.zzb());
            }
            zzu.zza("Event filter had no event name. Audience definition ignored. appId, audienceId, filterId", zza2, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbv = zzb2.zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zzb2.zzl() ? Integer.valueOf(zzb2.zzb()) : null);
        contentValues.put(AnalyticsEventTypeAdapter.EVENT_NAME, zzb2.zzf());
        contentValues.put("session_scoped", zzb2.zzm() ? Boolean.valueOf(zzb2.zzj()) : null);
        contentValues.put("data", zzbv);
        try {
            if (e_().insertWithOnConflict("event_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert event filter (got -1). appId", zzfr.zza(str));
            return true;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing event filter. appId", zzfr.zza(str), e);
            return false;
        }
    }

    private final boolean zza(String str, int i, zzew.zze zze2) {
        zzak();
        zzt();
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(zze2);
        Integer num = null;
        if (zze2.zze().isEmpty()) {
            zzft zzu = zzj().zzu();
            Object zza2 = zzfr.zza(str);
            Integer valueOf = Integer.valueOf(i);
            if (zze2.zzi()) {
                num = Integer.valueOf(zze2.zza());
            }
            zzu.zza("Property filter had no property name. Audience definition ignored. appId, audienceId, filterId", zza2, valueOf, String.valueOf(num));
            return false;
        }
        byte[] zzbv = zze2.zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("audience_id", Integer.valueOf(i));
        contentValues.put("filter_id", zze2.zzi() ? Integer.valueOf(zze2.zza()) : null);
        contentValues.put("property_name", zze2.zze());
        contentValues.put("session_scoped", zze2.zzj() ? Boolean.valueOf(zze2.zzh()) : null);
        contentValues.put("data", zzbv);
        try {
            if (e_().insertWithOnConflict("property_filters", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert property filter (got -1). appId", zzfr.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing property filter. appId", zzfr.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzaz zzaz, long j, boolean z) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzaz);
        Preconditions.checkNotEmpty(zzaz.zza);
        byte[] zzbv = g_().zza(zzaz).zzbv();
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzaz.zza);
        contentValues.put("name", zzaz.zzb);
        contentValues.put("timestamp", Long.valueOf(zzaz.zzc));
        contentValues.put("metadata_fingerprint", Long.valueOf(j));
        contentValues.put("data", zzbv);
        contentValues.put("realtime", Integer.valueOf(z ? 1 : 0));
        try {
            if (e_().insert("raw_events", (String) null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert raw event (got -1). appId", zzfr.zza(zzaz.zza));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing raw event. appId", zzfr.zza(zzaz.zza), e);
            return false;
        }
    }

    public final boolean zza(String str, zzmh zzmh) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zzmh);
        Preconditions.checkNotEmpty(str);
        long currentTimeMillis = zzb().currentTimeMillis();
        if (zzmh.zzb < currentTimeMillis - zzaf.zzm() || zzmh.zzb > zzaf.zzm() + currentTimeMillis) {
            zzj().zzu().zza("Storing trigger URI outside of the max retention time span. appId, now, timestamp", zzfr.zza(str), Long.valueOf(currentTimeMillis), Long.valueOf(zzmh.zzb));
        }
        zzj().zzp().zza("Saving trigger URI");
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("trigger_uri", zzmh.zza);
        contentValues.put("source", Integer.valueOf(zzmh.zzc));
        contentValues.put("timestamp_millis", Long.valueOf(zzmh.zzb));
        try {
            if (e_().insert("trigger_uris", (String) null, contentValues) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert trigger URI (got -1). appId", zzfr.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing trigger URI. appId", zzfr.zza(str), e);
            return false;
        }
    }

    private final boolean zzan() {
        return zza().getDatabasePath("google_app_measurement.db").exists();
    }

    public final boolean zza(String str, Long l, long j, zzfi.zze zze2) {
        zzt();
        zzak();
        Preconditions.checkNotNull(zze2);
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotNull(l);
        byte[] zzbv = zze2.zzbv();
        zzj().zzp().zza("Saving complex main event, appId, data size", zzi().zza(str), Integer.valueOf(zzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("event_id", l);
        contentValues.put("children_to_process", Long.valueOf(j));
        contentValues.put("main_event", zzbv);
        try {
            if (e_().insertWithOnConflict("main_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert complex main event (got -1). appId", zzfr.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing complex main event. appId", zzfr.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzad zzad) {
        Preconditions.checkNotNull(zzad);
        zzt();
        zzak();
        String str = zzad.zza;
        Preconditions.checkNotNull(str);
        if (zze(str, zzad.zzc.zza) == null) {
            if (zzb("SELECT COUNT(1) FROM conditional_properties WHERE app_id=?", new String[]{str}) >= 1000) {
                return false;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put("origin", zzad.zzb);
        contentValues.put("name", zzad.zzc.zza);
        zza(contentValues, "value", Preconditions.checkNotNull(zzad.zzc.zza()));
        contentValues.put("active", Boolean.valueOf(zzad.zze));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, zzad.zzf);
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.valueOf(zzad.zzh));
        zzq();
        contentValues.put("timed_out_event", zznd.zza((Parcelable) zzad.zzg));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, Long.valueOf(zzad.zzd));
        zzq();
        contentValues.put("triggered_event", zznd.zza((Parcelable) zzad.zzi));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP, Long.valueOf(zzad.zzc.zzb));
        contentValues.put(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.valueOf(zzad.zzj));
        zzq();
        contentValues.put("expired_event", zznd.zza((Parcelable) zzad.zzk));
        try {
            if (e_().insertWithOnConflict("conditional_properties", (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update conditional user property (got -1)", zzfr.zza(str));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing conditional user property", zzfr.zza(str), e);
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(String str, Bundle bundle) {
        zzt();
        zzak();
        byte[] zzbv = g_().zza(new zzaz(this.zzu, "", str, "dep", 0, 0, bundle)).zzbv();
        zzj().zzp().zza("Saving default event parameters, appId, data size", zzi().zza(str), Integer.valueOf(zzbv.length));
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", str);
        contentValues.put(DynamicLink.Builder.KEY_DYNAMIC_LINK_PARAMETERS, zzbv);
        try {
            if (e_().insertWithOnConflict("default_event_params", (String) null, contentValues, 5) != -1) {
                return true;
            }
            zzj().zzg().zza("Failed to insert default event parameters (got -1). appId", zzfr.zza(str));
            return false;
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing default event parameters. appId", zzfr.zza(str), e);
            return false;
        }
    }

    public final boolean zza(zzne zzne) {
        Preconditions.checkNotNull(zzne);
        zzt();
        zzak();
        if (zze(zzne.zza, zzne.zzc) == null) {
            if (zznd.zzh(zzne.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and name not like '!_%' escape '!'", new String[]{zzne.zza}) >= ((long) zze().zza(zzne.zza, zzbi.zzag, 25, 100))) {
                    return false;
                }
            } else if (!"_npa".equals(zzne.zzc)) {
                if (zzb("select count(1) from user_attributes where app_id=? and origin=? AND name like '!_%' escape '!'", new String[]{zzne.zza, zzne.zzb}) >= 25) {
                    return false;
                }
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("app_id", zzne.zza);
        contentValues.put("origin", zzne.zzb);
        contentValues.put("name", zzne.zzc);
        contentValues.put("set_timestamp", Long.valueOf(zzne.zzd));
        zza(contentValues, "value", zzne.zze);
        try {
            if (e_().insertWithOnConflict("user_attributes", (String) null, contentValues, 5) == -1) {
                zzj().zzg().zza("Failed to insert/update user property (got -1). appId", zzfr.zza(zzne.zza));
            }
        } catch (SQLiteException e) {
            zzj().zzg().zza("Error storing user property. appId", zzfr.zza(zzne.zza), e);
        }
        return true;
    }
}
