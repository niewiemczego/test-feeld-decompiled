package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.exoplayer2.C;
import com.google.android.gms.internal.measurement.zzfy;
import com.google.android.gms.internal.measurement.zzgk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.apache.commons.lang3.time.DateUtils;

/* compiled from: com.google.android.gms:play-services-measurement-impl@@21.5.0 */
public final class zzbi {
    public static final zzfi<Long> zza = zza("measurement.ad_id_cache_time", 10000L, 10000L, zzbk.zza);
    public static final zzfi<Long> zzaa;
    public static final zzfi<Long> zzab = zza("measurement.upload.retry_time", 1800000L, 1800000L, zzbv.zza);
    public static final zzfi<Integer> zzac = zza("measurement.upload.retry_count", 6, 6, zzby.zza);
    public static final zzfi<Long> zzad = zza("measurement.upload.max_queue_time", 2419200000L, 2419200000L, zzbx.zza);
    public static final zzfi<Integer> zzae = zza("measurement.lifetimevalue.max_currency_tracked", 4, 4, zzbz.zza);
    public static final zzfi<Integer> zzaf = zza("measurement.audience.filter_result_max_count", 200, 200, zzcc.zza);
    public static final zzfi<Integer> zzag = zza("measurement.upload.max_public_user_properties", 25, 25, (zzfg) null);
    public static final zzfi<Integer> zzah = zza("measurement.upload.max_event_name_cardinality", 500, 500, (zzfg) null);
    public static final zzfi<Integer> zzai = zza("measurement.upload.max_public_event_params", 25, 25, (zzfg) null);
    public static final zzfi<Long> zzaj = zza("measurement.service_client.idle_disconnect_millis", 5000L, 5000L, zzcb.zza);
    public static final zzfi<Boolean> zzak = zza("measurement.test.boolean_flag", false, false, zzce.zza);
    public static final zzfi<String> zzal = zza("measurement.test.string_flag", "---", "---", zzcd.zza);
    public static final zzfi<Long> zzam = zza("measurement.test.long_flag", -1L, -1L, zzcg.zza);
    public static final zzfi<Integer> zzan = zza("measurement.test.int_flag", -2, -2, zzci.zza);
    public static final zzfi<Double> zzao;
    public static final zzfi<Integer> zzap = zza("measurement.experiment.max_ids", 50, 50, zzck.zza);
    public static final zzfi<Integer> zzaq = zza("measurement.upload.max_item_scoped_custom_parameters", 27, 27, zzcj.zza);
    public static final zzfi<Integer> zzar = zza("measurement.max_bundles_per_iteration", 100, 100, zzco.zza);
    public static final zzfi<Long> zzas = zza("measurement.sdk.attribution.cache.ttl", 604800000L, 604800000L, zzcn.zza);
    public static final zzfi<Long> zzat = zza("measurement.redaction.app_instance_id.ttl", 7200000L, 7200000L, zzcq.zza);
    public static final zzfi<Integer> zzau = zza("measurement.rb.attribution.client.min_ad_services_version", 7, 7, zzcp.zza);
    public static final zzfi<String> zzav = zza("measurement.rb.attribution.uri_scheme", "https", "https", zzcr.zza);
    public static final zzfi<String> zzaw = zza("measurement.rb.attribution.uri_authority", "google-analytics.com", "google-analytics.com", zzcu.zza);
    public static final zzfi<String> zzax = zza("measurement.rb.attribution.uri_path", "privacy-sandbox/register-app-conversion", "privacy-sandbox/register-app-conversion", zzct.zza);
    public static final zzfi<String> zzay = zza("measurement.rb.attribution.app_allowlist", "com.labpixies.flood,", "com.labpixies.flood,", zzcw.zza);
    public static final zzfi<String> zzaz = zza("measurement.rb.attribution.user_properties", "_npa,npa", "_npa,npa", zzcv.zza);
    public static final zzfi<Long> zzb;
    public static final zzfi<String> zzba = zza("measurement.rb.attribution.event_params", "value|currency", "value|currency", zzcx.zza);
    public static final zzfi<String> zzbb = zza("measurement.rb.attribution.query_parameters_to_remove", "", "", zzda.zza);
    public static final zzfi<Boolean> zzbc = zza("measurement.collection.log_event_and_bundle_v2", true, true, zzcz.zza);
    public static final zzfi<Boolean> zzbd = zza("measurement.quality.checksum", false, false, (zzfg) null);
    public static final zzfi<Boolean> zzbe = zza("measurement.audience.use_bundle_end_timestamp_for_non_sequence_property_filters", false, false, zzdc.zza);
    public static final zzfi<Boolean> zzbf = zza("measurement.audience.refresh_event_count_filters_timestamp", false, false, zzde.zza);
    public static final zzfi<Boolean> zzbg = zza("measurement.audience.use_bundle_timestamp_for_event_count_filters", false, false, zzdd.zza);
    public static final zzfi<Boolean> zzbh = zza("measurement.sdk.collection.retrieve_deeplink_from_bow_2", true, true, zzdg.zza);
    public static final zzfi<Boolean> zzbi = zza("measurement.sdk.collection.last_deep_link_referrer_campaign2", false, false, zzdf.zza);
    public static final zzfi<Boolean> zzbj = zza("measurement.lifecycle.app_in_background_parameter", false, false, zzdi.zza);
    public static final zzfi<Boolean> zzbk = zza("measurement.integration.disable_firebase_instance_id", false, false, zzdh.zza);
    public static final zzfi<Boolean> zzbl = zza("measurement.collection.service.update_with_analytics_fix", false, false, zzdj.zza);
    public static final zzfi<Boolean> zzbm = zza("measurement.client.firebase_feature_rollout.v1.enable", true, true, zzdm.zza);
    public static final zzfi<Boolean> zzbn = zza("measurement.client.sessions.check_on_reset_and_enable2", true, true, zzdl.zza);
    public static final zzfi<Integer> zzbo = zza("measurement.service.storage_consent_support_version", 203600, 203600, zzdn.zza);
    public static final zzfi<Boolean> zzbp = zza("measurement.service.store_null_safelist", true, true, zzds.zza);
    public static final zzfi<Boolean> zzbq = zza("measurement.service.store_safelist", true, true, zzdr.zza);
    public static final zzfi<Boolean> zzbr = zza("measurement.collection.enable_session_stitching_token.first_open_fix", true, true, zzdu.zza);
    public static final zzfi<Boolean> zzbs = zza("measurement.collection.enable_session_stitching_token.client.dev", true, true, zzdt.zza);
    public static final zzfi<Boolean> zzbt = zza("measurement.session_stitching_token_enabled", false, false, zzdv.zza);
    public static final zzfi<Boolean> zzbu = zza("measurement.sgtm.service", false, false, zzea.zza);
    public static final zzfi<Boolean> zzbv = zza("measurement.redaction.retain_major_os_version", true, true, zzdz.zza);
    public static final zzfi<Boolean> zzbw = zza("measurement.redaction.scion_payload_generator", true, true, zzec.zza);
    public static final zzfi<Boolean> zzbx = zza("measurement.sessionid.enable_client_session_id", true, true, zzeb.zza);
    public static final zzfi<Boolean> zzby = zza("measurement.sfmc.client", true, true, zzee.zza);
    public static final zzfi<Boolean> zzbz = zza("measurement.sfmc.service", true, true, zzed.zza);
    public static final zzfi<Long> zzc;
    public static final zzfi<Boolean> zzca = zza("measurement.gmscore_feature_tracking", true, true, zzeg.zza);
    public static final zzfi<Boolean> zzcb = zza("measurement.fix_health_monitor_stack_trace", true, true, zzef.zza);
    public static final zzfi<Boolean> zzcc = zza("measurement.item_scoped_custom_parameters.client", true, true, zzeh.zza);
    public static final zzfi<Boolean> zzcd = zza("measurement.item_scoped_custom_parameters.service", false, false, zzej.zza);
    public static final zzfi<Boolean> zzce = zza("measurement.remove_app_background.client", false, false, zzem.zza);
    public static final zzfi<Boolean> zzcf = zza("measurement.rb.attribution.service", false, false, zzel.zza);
    public static final zzfi<Boolean> zzcg = zza("measurement.rb.attribution.client2", false, false, zzeo.zza);
    public static final zzfi<Boolean> zzch = zza("measurement.rb.attribution.uuid_generation", true, true, zzen.zza);
    public static final zzfi<Boolean> zzci = zza("measurement.rb.attribution.enable_trigger_redaction", true, true, zzeq.zza);
    public static final zzfi<Boolean> zzcj = zza("measurement.client.sessions.enable_fix_background_engagement", false, false, zzes.zza);
    public static final zzfi<Boolean> zzck = zza("measurement.client.ad_id_consent_fix", true, true, zzer.zza);
    public static final zzfi<Boolean> zzcl = zza("measurement.dma_consent.client", false, false, zzew.zza);
    public static final zzfi<Boolean> zzcm = zza("measurement.dma_consent.service", false, false, zzev.zza);
    public static final zzfi<Boolean> zzcn = zza("measurement.dma_consent.client_bow_check", false, false, zzey.zza);
    public static final zzfi<Boolean> zzco = zza("measurement.dma_consent.service_gcs_v2", false, false, zzex.zza);
    public static final zzfi<Boolean> zzcp = zza("measurement.dma_consent.service_npa_remote_default", false, false, zzfa.zza);
    public static final zzfi<Boolean> zzcq = zza("measurement.dma_consent.service_split_batch_on_consent", false, false, zzez.zza);
    public static final zzfi<Boolean> zzcr = zza("measurement.service.deferred_first_open", false, false, zzfc.zza);
    public static final zzfi<Boolean> zzcs = zza("measurement.gbraid_campaign.gbraid.client.dev", false, false, zzfb.zza);
    public static final zzfi<Boolean> zzct = zza("measurement.gbraid_campaign.gbraid.service", false, false, zzfe.zza);
    public static zzfi<Boolean> zzcu = zza("measurement.increase_param_lengths", false, false, zzfd.zza);
    /* access modifiers changed from: private */
    public static final List<zzfi<?>> zzcv = Collections.synchronizedList(new ArrayList());
    private static final Set<zzfi<?>> zzcw = Collections.synchronizedSet(new HashSet());
    private static final zzfi<Integer> zzcx = zza("measurement.upload.max_event_parameter_value_length", 100, 100, zzcl.zza);
    private static final zzfi<Boolean> zzcy = zza("measurement.client.click_identifier_control.dev", false, false, zzdq.zza);
    private static final zzfi<Boolean> zzcz = zza("measurement.service.click_identifier_control", false, false, zzdp.zza);
    public static final zzfi<Long> zzd;
    private static final zzfi<Boolean> zzda = zza("measurement.sgtm.client.dev", false, false, zzdy.zza);
    private static final zzfi<Boolean> zzdb = zza("measurement.rb.attribution.followup1.service", false, false, zzep.zza);
    public static final zzfi<String> zze = zza("measurement.config.url_scheme", "https", "https", zzcy.zza);
    public static final zzfi<String> zzf = zza("measurement.config.url_authority", "app-measurement.com", "app-measurement.com", zzdk.zza);
    public static final zzfi<Integer> zzg = zza("measurement.upload.max_bundles", 100, 100, zzdw.zza);
    public static final zzfi<Integer> zzh = zza("measurement.upload.max_batch_size", 65536, 65536, zzei.zza);
    public static final zzfi<Integer> zzi = zza("measurement.upload.max_bundle_size", 65536, 65536, zzeu.zza);
    public static final zzfi<Integer> zzj = zza("measurement.upload.max_events_per_bundle", 1000, 1000, zzbm.zza);
    public static final zzfi<Integer> zzk = zza("measurement.upload.max_events_per_day", 100000, 100000, zzbw.zza);
    public static final zzfi<Integer> zzl = zza("measurement.upload.max_error_events_per_day", 1000, 1000, zzcf.zza);
    public static final zzfi<Integer> zzm = zza("measurement.upload.max_public_events_per_day", 50000, 50000, zzcs.zza);
    public static final zzfi<Integer> zzn = zza("measurement.upload.max_conversions_per_day", 10000, 10000, zzdb.zza);
    public static final zzfi<Integer> zzo = zza("measurement.upload.max_realtime_events_per_day", 10, 10, zzdo.zza);
    public static final zzfi<Integer> zzp = zza("measurement.store.max_stored_events_per_app", 100000, 100000, zzdx.zza);
    public static final zzfi<String> zzq = zza("measurement.upload.url", "https://app-measurement.com/a", "https://app-measurement.com/a", zzek.zza);
    public static final zzfi<Long> zzr = zza("measurement.upload.backoff_period", 43200000L, 43200000L, zzet.zza);
    public static final zzfi<Long> zzs;
    public static final zzfi<Long> zzt;
    public static final zzfi<Long> zzu = zza("measurement.upload.realtime_upload_interval", 10000L, 10000L, zzbn.zza);
    public static final zzfi<Long> zzv = zza("measurement.upload.debug_upload_interval", 1000L, 1000L, zzbq.zza);
    public static final zzfi<Long> zzw = zza("measurement.upload.minimum_delay", 500L, 500L, zzbp.zza);
    public static final zzfi<Long> zzx = zza("measurement.alarm_manager.minimum_interval", 60000L, 60000L, zzbs.zza);
    public static final zzfi<Long> zzy;
    public static final zzfi<Long> zzz = zza("measurement.upload.refresh_blacklisted_config_interval", 604800000L, 604800000L, zzbu.zza);

    private static <V> zzfi<V> zza(String str, V v, V v2, zzfg<V> zzfg) {
        zzfi zzfi = new zzfi(str, v, v2, zzfg);
        zzcv.add(zzfi);
        return zzfi;
    }

    public static Map<String, String> zza(Context context) {
        zzfy zza2 = zzfy.zza(context.getContentResolver(), zzgk.zza("com.google.android.gms.measurement"), zzbh.zza);
        return zza2 == null ? Collections.emptyMap() : zza2.zza();
    }

    static {
        Long valueOf = Long.valueOf(DateUtils.MILLIS_PER_HOUR);
        zzb = zza("measurement.app_uninstalled_additional_ad_id_cache_time", valueOf, valueOf, zzbo.zza);
        Long valueOf2 = Long.valueOf(DateUtils.MILLIS_PER_DAY);
        zzc = zza("measurement.monitoring.sample_period_millis", valueOf2, valueOf2, zzca.zza);
        zzd = zza("measurement.config.cache_time", valueOf2, valueOf, zzcm.zza);
        zzs = zza("measurement.upload.window_interval", valueOf, valueOf, zzbj.zza);
        zzt = zza("measurement.upload.interval", valueOf, valueOf, zzbl.zza);
        zzy = zza("measurement.upload.stale_data_deletion_interval", valueOf2, valueOf2, zzbr.zza);
        Long valueOf3 = Long.valueOf(C.DEFAULT_SEEK_FORWARD_INCREMENT_MS);
        zzaa = zza("measurement.upload.initial_upload_delay_time", valueOf3, valueOf3, zzbt.zza);
        Double valueOf4 = Double.valueOf(-3.0d);
        zzao = zza("measurement.test.double_flag", valueOf4, valueOf4, zzch.zza);
    }
}
