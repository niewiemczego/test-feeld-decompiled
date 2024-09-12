package com.adapty.internal.utils;

import com.adapty.internal.data.models.AnalyticsData;
import com.adapty.internal.data.models.AnalyticsEvent;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u0000 \u00122\b\u0012\u0004\u0012\u00020\u00020\u00012\b\u0012\u0004\u0012\u00020\u00020\u0003:\u0001\u0012B\u0005¢\u0006\u0002\u0010\u0004J\"\u0010\b\u001a\u0004\u0018\u00010\u00022\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\rH\u0016J \u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0011H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/adapty/internal/utils/AnalyticsDataTypeAdapter;", "Lcom/google/gson/JsonDeserializer;", "Lcom/adapty/internal/data/models/AnalyticsData;", "Lcom/google/gson/JsonSerializer;", "()V", "eventsListType", "Ljava/lang/reflect/Type;", "kotlin.jvm.PlatformType", "deserialize", "jsonElement", "Lcom/google/gson/JsonElement;", "type", "context", "Lcom/google/gson/JsonDeserializationContext;", "serialize", "src", "typeOfSrc", "Lcom/google/gson/JsonSerializationContext;", "Companion", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* compiled from: AnalyticsDataTypeAdapter.kt */
public final class AnalyticsDataTypeAdapter implements JsonDeserializer<AnalyticsData>, JsonSerializer<AnalyticsData> {
    private static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    @Deprecated
    public static final String EVENTS = "events";
    @Deprecated
    public static final String PREV_ORDINAL = "prev_ordinal";
    private final Type eventsListType = new AnalyticsDataTypeAdapter$eventsListType$1().getType();

    public AnalyticsData deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) {
        Object obj;
        Object obj2;
        Intrinsics.checkNotNullParameter(jsonElement, "jsonElement");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(jsonDeserializationContext, "context");
        long j = 0;
        Long l = null;
        if (jsonElement instanceof JsonObject) {
            try {
                Result.Companion companion = Result.Companion;
                AnalyticsDataTypeAdapter analyticsDataTypeAdapter = this;
                obj = Result.m983constructorimpl(((JsonObject) jsonElement).getAsJsonArray("events"));
            } catch (Throwable th) {
                Result.Companion companion2 = Result.Companion;
                obj = Result.m983constructorimpl(ResultKt.createFailure(th));
            }
            if (Result.m989isFailureimpl(obj)) {
                obj = null;
            }
            JsonArray jsonArray = (JsonArray) obj;
            ArrayList arrayList = jsonArray != null ? (ArrayList) jsonDeserializationContext.deserialize(jsonArray, this.eventsListType) : null;
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            try {
                Result.Companion companion3 = Result.Companion;
                AnalyticsDataTypeAdapter analyticsDataTypeAdapter2 = this;
                obj2 = Result.m983constructorimpl(Long.valueOf(((JsonObject) jsonElement).getAsJsonPrimitive(PREV_ORDINAL).getAsLong()));
            } catch (Throwable th2) {
                Result.Companion companion4 = Result.Companion;
                obj2 = Result.m983constructorimpl(ResultKt.createFailure(th2));
            }
            if (!Result.m989isFailureimpl(obj2)) {
                l = obj2;
            }
            Long l2 = l;
            if (l2 != null) {
                j = l2.longValue();
            }
            return new AnalyticsData(arrayList, j);
        } else if (!(jsonElement instanceof JsonArray)) {
            return null;
        } else {
            Iterable iterable = (Iterable) jsonDeserializationContext.deserialize(jsonElement, this.eventsListType);
            int i = 0;
            for (Object next : iterable) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ((AnalyticsEvent) next).setOrdinal((long) i2);
                i = i2;
            }
            ArrayList arrayList2 = (ArrayList) iterable;
            Intrinsics.checkNotNullExpressionValue(arrayList2, "events");
            List list = arrayList2;
            AnalyticsEvent analyticsEvent = (AnalyticsEvent) CollectionsKt.lastOrNull(list);
            if (analyticsEvent != null) {
                j = analyticsEvent.getOrdinal();
            }
            return new AnalyticsData(list, j);
        }
    }

    public JsonElement serialize(AnalyticsData analyticsData, Type type, JsonSerializationContext jsonSerializationContext) {
        Intrinsics.checkNotNullParameter(analyticsData, "src");
        Intrinsics.checkNotNullParameter(type, "typeOfSrc");
        Intrinsics.checkNotNullParameter(jsonSerializationContext, "context");
        JsonObject jsonObject = new JsonObject();
        jsonObject.add("events", jsonSerializationContext.serialize(analyticsData.getEvents(), this.eventsListType));
        jsonObject.addProperty(PREV_ORDINAL, (Number) Long.valueOf(analyticsData.getPrevOrdinal()));
        return jsonObject;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/adapty/internal/utils/AnalyticsDataTypeAdapter$Companion;", "", "()V", "EVENTS", "", "PREV_ORDINAL", "adapty_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* compiled from: AnalyticsDataTypeAdapter.kt */
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
