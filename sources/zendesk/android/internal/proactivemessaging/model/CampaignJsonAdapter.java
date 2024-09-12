package zendesk.android.internal.proactivemessaging.model;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.squareup.moshi.JsonAdapter;
import com.squareup.moshi.JsonReader;
import com.squareup.moshi.JsonWriter;
import com.squareup.moshi.Moshi;
import com.squareup.moshi.Types;
import io.sentry.MonitorConfig;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0010\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u001a\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0002H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0016R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0001X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\u0001X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0001X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006 "}, d2 = {"Lzendesk/android/internal/proactivemessaging/model/CampaignJsonAdapter;", "Lcom/squareup/moshi/JsonAdapter;", "Lzendesk/android/internal/proactivemessaging/model/Campaign;", "moshi", "Lcom/squareup/moshi/Moshi;", "(Lcom/squareup/moshi/Moshi;)V", "intAdapter", "", "integrationAdapter", "Lzendesk/android/internal/proactivemessaging/model/Integration;", "listOfPathAdapter", "", "Lzendesk/android/internal/proactivemessaging/model/Path;", "options", "Lcom/squareup/moshi/JsonReader$Options;", "scheduleAdapter", "Lzendesk/android/internal/proactivemessaging/model/Schedule;", "statusAdapter", "Lzendesk/android/internal/proactivemessaging/model/Status;", "stringAdapter", "", "triggerAdapter", "Lzendesk/android/internal/proactivemessaging/model/Trigger;", "fromJson", "reader", "Lcom/squareup/moshi/JsonReader;", "toJson", "", "writer", "Lcom/squareup/moshi/JsonWriter;", "value_", "toString", "zendesk_zendesk-android"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CampaignJsonAdapter.kt */
public final class CampaignJsonAdapter extends JsonAdapter<Campaign> {
    private final JsonAdapter<Integer> intAdapter;
    private final JsonAdapter<Integration> integrationAdapter;
    private final JsonAdapter<List<Path>> listOfPathAdapter;
    private final JsonReader.Options options;
    private final JsonAdapter<Schedule> scheduleAdapter;
    private final JsonAdapter<Status> statusAdapter;
    private final JsonAdapter<String> stringAdapter;
    private final JsonAdapter<Trigger> triggerAdapter;

    public CampaignJsonAdapter(Moshi moshi) {
        Intrinsics.checkNotNullParameter(moshi, "moshi");
        JsonReader.Options of = JsonReader.Options.of(FirebaseAnalytics.Param.CAMPAIGN_ID, "integration", "when", MonitorConfig.JsonKeys.SCHEDULE, "status", "paths", "version");
        Intrinsics.checkNotNullExpressionValue(of, "of(\"campaign_id\", \"integ…tus\", \"paths\", \"version\")");
        this.options = of;
        JsonAdapter<String> adapter = moshi.adapter(String.class, SetsKt.emptySet(), "campaignId");
        Intrinsics.checkNotNullExpressionValue(adapter, "moshi.adapter(String::cl…et(),\n      \"campaignId\")");
        this.stringAdapter = adapter;
        JsonAdapter<Integration> adapter2 = moshi.adapter(Integration.class, SetsKt.emptySet(), "integration");
        Intrinsics.checkNotNullExpressionValue(adapter2, "moshi.adapter(Integratio…mptySet(), \"integration\")");
        this.integrationAdapter = adapter2;
        JsonAdapter<Trigger> adapter3 = moshi.adapter(Trigger.class, SetsKt.emptySet(), "trigger");
        Intrinsics.checkNotNullExpressionValue(adapter3, "moshi.adapter(Trigger::c…tySet(),\n      \"trigger\")");
        this.triggerAdapter = adapter3;
        JsonAdapter<Schedule> adapter4 = moshi.adapter(Schedule.class, SetsKt.emptySet(), MonitorConfig.JsonKeys.SCHEDULE);
        Intrinsics.checkNotNullExpressionValue(adapter4, "moshi.adapter(Schedule::…  emptySet(), \"schedule\")");
        this.scheduleAdapter = adapter4;
        JsonAdapter<Status> adapter5 = moshi.adapter(Status.class, SetsKt.emptySet(), "status");
        Intrinsics.checkNotNullExpressionValue(adapter5, "moshi.adapter(Status::cl…ptySet(),\n      \"status\")");
        this.statusAdapter = adapter5;
        JsonAdapter<List<Path>> adapter6 = moshi.adapter(Types.newParameterizedType(List.class, Path.class), SetsKt.emptySet(), "paths");
        Intrinsics.checkNotNullExpressionValue(adapter6, "moshi.adapter(Types.newP…mptySet(),\n      \"paths\")");
        this.listOfPathAdapter = adapter6;
        JsonAdapter<Integer> adapter7 = moshi.adapter(Integer.TYPE, SetsKt.emptySet(), "version");
        Intrinsics.checkNotNullExpressionValue(adapter7, "moshi.adapter(Int::class…a, emptySet(), \"version\")");
        this.intAdapter = adapter7;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(30);
        sb.append("GeneratedJsonAdapter(").append("Campaign").append(')');
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "StringBuilder(capacity).…builderAction).toString()");
        return sb2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00fb, code lost:
        r2 = r16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00fd, code lost:
        r9 = r17;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ff, code lost:
        r8 = r18;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zendesk.android.internal.proactivemessaging.model.Campaign fromJson(com.squareup.moshi.JsonReader r21) {
        /*
            r20 = this;
            r0 = r20
            r1 = r21
            java.lang.String r2 = "reader"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r2)
            r21.beginObject()
            r2 = 0
            r4 = r2
            r5 = r4
            r6 = r5
            r7 = r6
            r8 = r7
            r9 = r8
        L_0x0013:
            boolean r3 = r21.hasNext()
            java.lang.String r10 = "when"
            java.lang.String r11 = "trigger"
            java.lang.String r12 = "campaign_id"
            java.lang.String r13 = "campaignId"
            java.lang.String r14 = "version"
            java.lang.String r15 = "paths"
            r16 = r2
            java.lang.String r2 = "status"
            r17 = r9
            java.lang.String r9 = "schedule"
            r18 = r8
            java.lang.String r8 = "integration"
            if (r3 == 0) goto L_0x0103
            com.squareup.moshi.JsonReader$Options r3 = r0.options
            int r3 = r1.selectName(r3)
            switch(r3) {
                case -1: goto L_0x00f5;
                case 0: goto L_0x00dc;
                case 1: goto L_0x00c3;
                case 2: goto L_0x00aa;
                case 3: goto L_0x0091;
                case 4: goto L_0x0074;
                case 5: goto L_0x0058;
                case 6: goto L_0x003f;
                default: goto L_0x003d;
            }
        L_0x003d:
            goto L_0x00fb
        L_0x003f:
            com.squareup.moshi.JsonAdapter<java.lang.Integer> r2 = r0.intAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 == 0) goto L_0x004b
            goto L_0x00fd
        L_0x004b:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r14, r14, r1)
            java.lang.String r2 = "unexpectedNull(\"version\"…       \"version\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0058:
            com.squareup.moshi.JsonAdapter<java.util.List<zendesk.android.internal.proactivemessaging.model.Path>> r2 = r0.listOfPathAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r9 = r2
            java.util.List r9 = (java.util.List) r9
            if (r9 == 0) goto L_0x0067
            r2 = r16
            goto L_0x00ff
        L_0x0067:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r15, r15, r1)
            java.lang.String r2 = "unexpectedNull(\"paths\",\n…         \"paths\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0074:
            com.squareup.moshi.JsonAdapter<zendesk.android.internal.proactivemessaging.model.Status> r3 = r0.statusAdapter
            java.lang.Object r3 = r3.fromJson((com.squareup.moshi.JsonReader) r1)
            r8 = r3
            zendesk.android.internal.proactivemessaging.model.Status r8 = (zendesk.android.internal.proactivemessaging.model.Status) r8
            if (r8 == 0) goto L_0x0084
            r2 = r16
            r9 = r17
            goto L_0x0013
        L_0x0084:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r2, r2, r1)
            java.lang.String r2 = "unexpectedNull(\"status\",…        \"status\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0091:
            com.squareup.moshi.JsonAdapter<zendesk.android.internal.proactivemessaging.model.Schedule> r2 = r0.scheduleAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r7 = r2
            zendesk.android.internal.proactivemessaging.model.Schedule r7 = (zendesk.android.internal.proactivemessaging.model.Schedule) r7
            if (r7 == 0) goto L_0x009d
            goto L_0x00fb
        L_0x009d:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r9, r9, r1)
            java.lang.String r2 = "unexpectedNull(\"schedule…      \"schedule\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00aa:
            com.squareup.moshi.JsonAdapter<zendesk.android.internal.proactivemessaging.model.Trigger> r2 = r0.triggerAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r6 = r2
            zendesk.android.internal.proactivemessaging.model.Trigger r6 = (zendesk.android.internal.proactivemessaging.model.Trigger) r6
            if (r6 == 0) goto L_0x00b6
            goto L_0x00fb
        L_0x00b6:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r11, r10, r1)
            java.lang.String r2 = "unexpectedNull(\"trigger\"…          \"when\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00c3:
            com.squareup.moshi.JsonAdapter<zendesk.android.internal.proactivemessaging.model.Integration> r2 = r0.integrationAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r5 = r2
            zendesk.android.internal.proactivemessaging.model.Integration r5 = (zendesk.android.internal.proactivemessaging.model.Integration) r5
            if (r5 == 0) goto L_0x00cf
            goto L_0x00fb
        L_0x00cf:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r8, r8, r1)
            java.lang.String r2 = "unexpectedNull(\"integrat…\", \"integration\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00dc:
            com.squareup.moshi.JsonAdapter<java.lang.String> r2 = r0.stringAdapter
            java.lang.Object r2 = r2.fromJson((com.squareup.moshi.JsonReader) r1)
            r4 = r2
            java.lang.String r4 = (java.lang.String) r4
            if (r4 == 0) goto L_0x00e8
            goto L_0x00fb
        L_0x00e8:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.unexpectedNull(r13, r12, r1)
            java.lang.String r2 = "unexpectedNull(\"campaign…   \"campaign_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x00f5:
            r21.skipName()
            r21.skipValue()
        L_0x00fb:
            r2 = r16
        L_0x00fd:
            r9 = r17
        L_0x00ff:
            r8 = r18
            goto L_0x0013
        L_0x0103:
            r21.endObject()
            zendesk.android.internal.proactivemessaging.model.Campaign r19 = new zendesk.android.internal.proactivemessaging.model.Campaign
            if (r4 == 0) goto L_0x016c
            if (r5 == 0) goto L_0x0160
            if (r6 == 0) goto L_0x0154
            if (r7 == 0) goto L_0x0148
            if (r18 == 0) goto L_0x013c
            if (r17 == 0) goto L_0x0130
            if (r16 == 0) goto L_0x0124
            int r10 = r16.intValue()
            r3 = r19
            r8 = r18
            r9 = r17
            r3.<init>(r4, r5, r6, r7, r8, r9, r10)
            return r19
        L_0x0124:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r14, r14, r1)
            java.lang.String r2 = "missingProperty(\"version\", \"version\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0130:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r15, r15, r1)
            java.lang.String r2 = "missingProperty(\"paths\", \"paths\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x013c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r2, r2, r1)
            java.lang.String r2 = "missingProperty(\"status\", \"status\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0148:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r9, r9, r1)
            java.lang.String r2 = "missingProperty(\"schedule\", \"schedule\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0154:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r11, r10, r1)
            java.lang.String r2 = "missingProperty(\"trigger\", \"when\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x0160:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r8, r8, r1)
            java.lang.String r2 = "missingProperty(\"integra…ion\",\n            reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        L_0x016c:
            com.squareup.moshi.JsonDataException r1 = com.squareup.moshi.internal.Util.missingProperty(r13, r12, r1)
            java.lang.String r2 = "missingProperty(\"campaig…\", \"campaign_id\", reader)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: zendesk.android.internal.proactivemessaging.model.CampaignJsonAdapter.fromJson(com.squareup.moshi.JsonReader):zendesk.android.internal.proactivemessaging.model.Campaign");
    }

    public void toJson(JsonWriter jsonWriter, Campaign campaign) {
        Intrinsics.checkNotNullParameter(jsonWriter, "writer");
        if (campaign != null) {
            jsonWriter.beginObject();
            jsonWriter.name(FirebaseAnalytics.Param.CAMPAIGN_ID);
            this.stringAdapter.toJson(jsonWriter, campaign.getCampaignId());
            jsonWriter.name("integration");
            this.integrationAdapter.toJson(jsonWriter, campaign.getIntegration());
            jsonWriter.name("when");
            this.triggerAdapter.toJson(jsonWriter, campaign.getTrigger());
            jsonWriter.name(MonitorConfig.JsonKeys.SCHEDULE);
            this.scheduleAdapter.toJson(jsonWriter, campaign.getSchedule());
            jsonWriter.name("status");
            this.statusAdapter.toJson(jsonWriter, campaign.getStatus());
            jsonWriter.name("paths");
            this.listOfPathAdapter.toJson(jsonWriter, campaign.getPaths());
            jsonWriter.name("version");
            this.intAdapter.toJson(jsonWriter, Integer.valueOf(campaign.getVersion()));
            jsonWriter.endObject();
            return;
        }
        throw new NullPointerException("value_ was null! Wrap in .nullSafe() to write nullable values.");
    }
}
