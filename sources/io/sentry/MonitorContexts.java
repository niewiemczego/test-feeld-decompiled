package io.sentry;

import io.sentry.SpanContext;
import io.sentry.util.Objects;
import io.sentry.vendor.gson.stream.JsonToken;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class MonitorContexts extends ConcurrentHashMap<String, Object> implements JsonSerializable {
    private static final long serialVersionUID = 3987329379811822556L;

    public MonitorContexts() {
    }

    public MonitorContexts(MonitorContexts monitorContexts) {
        for (Map.Entry entry : monitorContexts.entrySet()) {
            if (entry != null) {
                Object value = entry.getValue();
                if (!"trace".equals(entry.getKey()) || !(value instanceof SpanContext)) {
                    put((String) entry.getKey(), value);
                } else {
                    setTrace(new SpanContext((SpanContext) value));
                }
            }
        }
    }

    private <T> T toContextType(String str, Class<T> cls) {
        Object obj = get(str);
        if (cls.isInstance(obj)) {
            return cls.cast(obj);
        }
        return null;
    }

    public SpanContext getTrace() {
        return (SpanContext) toContextType("trace", SpanContext.class);
    }

    public void setTrace(SpanContext spanContext) {
        Objects.requireNonNull(spanContext, "traceContext is required");
        put("trace", spanContext);
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger) throws IOException {
        objectWriter.beginObject();
        ArrayList<String> list = Collections.list(keys());
        Collections.sort(list);
        for (String str : list) {
            Object obj = get(str);
            if (obj != null) {
                objectWriter.name(str).value(iLogger, obj);
            }
        }
        objectWriter.endObject();
    }

    public static final class Deserializer implements JsonDeserializer<MonitorContexts> {
        public MonitorContexts deserialize(JsonObjectReader jsonObjectReader, ILogger iLogger) throws Exception {
            MonitorContexts monitorContexts = new MonitorContexts();
            jsonObjectReader.beginObject();
            while (jsonObjectReader.peek() == JsonToken.NAME) {
                String nextName = jsonObjectReader.nextName();
                nextName.hashCode();
                if (!nextName.equals("trace")) {
                    Object nextObjectOrNull = jsonObjectReader.nextObjectOrNull();
                    if (nextObjectOrNull != null) {
                        monitorContexts.put(nextName, nextObjectOrNull);
                    }
                } else {
                    monitorContexts.setTrace(new SpanContext.Deserializer().deserialize(jsonObjectReader, iLogger));
                }
            }
            jsonObjectReader.endObject();
            return monitorContexts;
        }
    }
}
