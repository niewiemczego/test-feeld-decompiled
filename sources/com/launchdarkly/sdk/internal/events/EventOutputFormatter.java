package com.launchdarkly.sdk.internal.events;

import app.notifee.core.event.LogEvent;
import com.adapty.internal.crossplatform.AdaptyUIActionTypeAdapterFactory;
import com.facebook.hermes.intl.Constants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.stream.JsonWriter;
import com.launchdarkly.sdk.AttributeRef;
import com.launchdarkly.sdk.EvaluationReason;
import com.launchdarkly.sdk.LDContext;
import com.launchdarkly.sdk.LDValue;
import com.launchdarkly.sdk.internal.GsonHelpers;
import com.launchdarkly.sdk.internal.events.Event;
import com.launchdarkly.sdk.internal.events.EventSummarizer;
import io.sentry.clientreport.DiscardedEvent;
import io.sentry.protocol.MetricSummary;
import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.Map;

final class EventOutputFormatter {
    private final EventContextFormatter contextFormatter;

    EventOutputFormatter(EventsConfiguration eventsConfiguration) {
        this.contextFormatter = new EventContextFormatter(eventsConfiguration.allAttributesPrivate, (AttributeRef[]) eventsConfiguration.privateAttributes.toArray(new AttributeRef[eventsConfiguration.privateAttributes.size()]));
    }

    /* access modifiers changed from: package-private */
    public final int writeOutputEvents(Event[] eventArr, EventSummarizer.EventSummary eventSummary, Writer writer) throws IOException {
        JsonWriter jsonWriter = new JsonWriter(writer);
        jsonWriter.beginArray();
        int i = 0;
        for (Event writeOutputEvent : eventArr) {
            if (writeOutputEvent(writeOutputEvent, jsonWriter)) {
                i++;
            }
        }
        if (!eventSummary.isEmpty()) {
            writeSummaryEvent(eventSummary, jsonWriter);
            i++;
        }
        jsonWriter.endArray();
        jsonWriter.flush();
        return i;
    }

    private final boolean writeOutputEvent(Event event, JsonWriter jsonWriter) throws IOException {
        if (event.getContext() != null && event.getContext().isValid()) {
            if (event instanceof Event.FeatureRequest) {
                Event.FeatureRequest featureRequest = (Event.FeatureRequest) event;
                jsonWriter.beginObject();
                writeKindAndCreationDate(jsonWriter, featureRequest.isDebug() ? LogEvent.LEVEL_DEBUG : "feature", event.getCreationDate());
                jsonWriter.name("key").value(featureRequest.getKey());
                if (featureRequest.isDebug()) {
                    writeContext(featureRequest.getContext(), jsonWriter);
                } else {
                    writeContextKeys(featureRequest.getContext(), jsonWriter);
                }
                if (featureRequest.getVersion() >= 0) {
                    jsonWriter.name("version");
                    jsonWriter.value((long) featureRequest.getVersion());
                }
                if (featureRequest.getVariation() >= 0) {
                    jsonWriter.name("variation");
                    jsonWriter.value((long) featureRequest.getVariation());
                }
                writeLDValue("value", featureRequest.getValue(), jsonWriter);
                writeLDValue(Constants.COLLATION_DEFAULT, featureRequest.getDefaultVal(), jsonWriter);
                if (featureRequest.getPrereqOf() != null) {
                    jsonWriter.name("prereqOf");
                    jsonWriter.value(featureRequest.getPrereqOf());
                }
                writeEvaluationReason(DiscardedEvent.JsonKeys.REASON, featureRequest.getReason(), jsonWriter);
                jsonWriter.endObject();
                return true;
            } else if (event instanceof Event.Identify) {
                jsonWriter.beginObject();
                writeKindAndCreationDate(jsonWriter, "identify", event.getCreationDate());
                writeContext(event.getContext(), jsonWriter);
                jsonWriter.endObject();
                return true;
            } else if (event instanceof Event.Custom) {
                Event.Custom custom = (Event.Custom) event;
                jsonWriter.beginObject();
                writeKindAndCreationDate(jsonWriter, AdaptyUIActionTypeAdapterFactory.TYPE_CUSTOM, event.getCreationDate());
                jsonWriter.name("key").value(custom.getKey());
                writeContextKeys(custom.getContext(), jsonWriter);
                writeLDValue("data", custom.getData(), jsonWriter);
                if (custom.getMetricValue() != null) {
                    jsonWriter.name("metricValue");
                    jsonWriter.value((Number) custom.getMetricValue());
                }
                jsonWriter.endObject();
                return true;
            } else if (event instanceof Event.Index) {
                jsonWriter.beginObject();
                writeKindAndCreationDate(jsonWriter, FirebaseAnalytics.Param.INDEX, event.getCreationDate());
                writeContext(event.getContext(), jsonWriter);
                jsonWriter.endObject();
                return true;
            }
        }
        return false;
    }

    private final void writeSummaryEvent(EventSummarizer.EventSummary eventSummary, JsonWriter jsonWriter) throws IOException {
        jsonWriter.beginObject();
        jsonWriter.name("kind");
        jsonWriter.value("summary");
        jsonWriter.name("startDate");
        jsonWriter.value(eventSummary.startDate);
        jsonWriter.name("endDate");
        jsonWriter.value(eventSummary.endDate);
        jsonWriter.name("features");
        jsonWriter.beginObject();
        for (Map.Entry next : eventSummary.counters.entrySet()) {
            EventSummarizer.FlagInfo flagInfo = (EventSummarizer.FlagInfo) next.getValue();
            jsonWriter.name((String) next.getKey());
            jsonWriter.beginObject();
            writeLDValue(Constants.COLLATION_DEFAULT, flagInfo.defaultVal, jsonWriter);
            jsonWriter.name("contextKinds").beginArray();
            for (String value : flagInfo.contextKinds) {
                jsonWriter.value(value);
            }
            jsonWriter.endArray();
            jsonWriter.name("counters");
            jsonWriter.beginArray();
            for (int i = 0; i < flagInfo.versionsAndVariations.size(); i++) {
                int keyAt = flagInfo.versionsAndVariations.keyAt(i);
                EventSummarizer.SimpleIntKeyedMap valueAt = flagInfo.versionsAndVariations.valueAt(i);
                for (int i2 = 0; i2 < valueAt.size(); i2++) {
                    int keyAt2 = valueAt.keyAt(i2);
                    EventSummarizer.CounterValue counterValue = (EventSummarizer.CounterValue) valueAt.valueAt(i2);
                    jsonWriter.beginObject();
                    if (keyAt2 >= 0) {
                        jsonWriter.name("variation").value((long) keyAt2);
                    }
                    if (keyAt >= 0) {
                        jsonWriter.name("version").value((long) keyAt);
                    } else {
                        jsonWriter.name("unknown").value(true);
                    }
                    writeLDValue("value", counterValue.flagValue, jsonWriter);
                    jsonWriter.name(MetricSummary.JsonKeys.COUNT).value(counterValue.count);
                    jsonWriter.endObject();
                }
            }
            jsonWriter.endArray();
            jsonWriter.endObject();
        }
        jsonWriter.endObject();
        jsonWriter.endObject();
    }

    private final void writeKindAndCreationDate(JsonWriter jsonWriter, String str, long j) throws IOException {
        jsonWriter.name("kind").value(str);
        jsonWriter.name("creationDate").value(j);
    }

    private final void writeContext(LDContext lDContext, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("context");
        this.contextFormatter.write(lDContext, jsonWriter);
    }

    private final void writeContextKeys(LDContext lDContext, JsonWriter jsonWriter) throws IOException {
        jsonWriter.name("contextKeys").beginObject();
        for (int i = 0; i < lDContext.getIndividualContextCount(); i++) {
            LDContext individualContext = lDContext.getIndividualContext(i);
            if (individualContext != null) {
                jsonWriter.name(individualContext.getKind().toString()).value(individualContext.getKey());
            }
        }
        jsonWriter.endObject();
    }

    private final void writeLDValue(String str, LDValue lDValue, JsonWriter jsonWriter) throws IOException {
        if (lDValue != null && !lDValue.isNull()) {
            jsonWriter.name(str);
            GsonHelpers.gsonInstance().toJson((Object) lDValue, (Type) LDValue.class, jsonWriter);
        }
    }

    private final void writeEvaluationReason(String str, EvaluationReason evaluationReason, JsonWriter jsonWriter) throws IOException {
        if (evaluationReason != null) {
            jsonWriter.name(str);
            GsonHelpers.gsonInstance().toJson((Object) evaluationReason, (Type) EvaluationReason.class, jsonWriter);
        }
    }
}
