package io.sentry;

import io.sentry.util.JsonSerializationUtils;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class JsonObjectSerializer {
    public static final String OBJECT_PLACEHOLDER = "[OBJECT]";
    public final JsonReflectionObjectSerializer jsonReflectionObjectSerializer;

    public JsonObjectSerializer(int i) {
        this.jsonReflectionObjectSerializer = new JsonReflectionObjectSerializer(i);
    }

    public void serialize(ObjectWriter objectWriter, ILogger iLogger, Object obj) throws IOException {
        if (obj == null) {
            objectWriter.nullValue();
        } else if (obj instanceof Character) {
            objectWriter.value(Character.toString(((Character) obj).charValue()));
        } else if (obj instanceof String) {
            objectWriter.value((String) obj);
        } else if (obj instanceof Boolean) {
            objectWriter.value(((Boolean) obj).booleanValue());
        } else if (obj instanceof Number) {
            objectWriter.value((Number) obj);
        } else if (obj instanceof Date) {
            serializeDate(objectWriter, iLogger, (Date) obj);
        } else if (obj instanceof TimeZone) {
            serializeTimeZone(objectWriter, iLogger, (TimeZone) obj);
        } else if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serialize(objectWriter, iLogger);
        } else if (obj instanceof Collection) {
            serializeCollection(objectWriter, iLogger, (Collection) obj);
        } else if (obj.getClass().isArray()) {
            serializeCollection(objectWriter, iLogger, Arrays.asList((Object[]) obj));
        } else if (obj instanceof Map) {
            serializeMap(objectWriter, iLogger, (Map) obj);
        } else if (obj instanceof Locale) {
            objectWriter.value(obj.toString());
        } else if (obj instanceof AtomicIntegerArray) {
            serializeCollection(objectWriter, iLogger, JsonSerializationUtils.atomicIntegerArrayToList((AtomicIntegerArray) obj));
        } else if (obj instanceof AtomicBoolean) {
            objectWriter.value(((AtomicBoolean) obj).get());
        } else if (obj instanceof URI) {
            objectWriter.value(obj.toString());
        } else if (obj instanceof InetAddress) {
            objectWriter.value(obj.toString());
        } else if (obj instanceof UUID) {
            objectWriter.value(obj.toString());
        } else if (obj instanceof Currency) {
            objectWriter.value(obj.toString());
        } else if (obj instanceof Calendar) {
            serializeMap(objectWriter, iLogger, JsonSerializationUtils.calendarToMap((Calendar) obj));
        } else if (obj.getClass().isEnum()) {
            objectWriter.value(obj.toString());
        } else {
            try {
                serialize(objectWriter, iLogger, this.jsonReflectionObjectSerializer.serialize(obj, iLogger));
            } catch (Exception e) {
                iLogger.log(SentryLevel.ERROR, "Failed serializing unknown object.", (Throwable) e);
                objectWriter.value(OBJECT_PLACEHOLDER);
            }
        }
    }

    private void serializeDate(ObjectWriter objectWriter, ILogger iLogger, Date date) throws IOException {
        try {
            objectWriter.value(DateUtils.getTimestamp(date));
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, "Error when serializing Date", (Throwable) e);
            objectWriter.nullValue();
        }
    }

    private void serializeTimeZone(ObjectWriter objectWriter, ILogger iLogger, TimeZone timeZone) throws IOException {
        try {
            objectWriter.value(timeZone.getID());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, "Error when serializing TimeZone", (Throwable) e);
            objectWriter.nullValue();
        }
    }

    private void serializeCollection(ObjectWriter objectWriter, ILogger iLogger, Collection<?> collection) throws IOException {
        objectWriter.beginArray();
        for (Object serialize : collection) {
            serialize(objectWriter, iLogger, serialize);
        }
        objectWriter.endArray();
    }

    private void serializeMap(ObjectWriter objectWriter, ILogger iLogger, Map<?, ?> map) throws IOException {
        objectWriter.beginObject();
        for (Object next : map.keySet()) {
            if (next instanceof String) {
                objectWriter.name((String) next);
                serialize(objectWriter, iLogger, map.get(next));
            }
        }
        objectWriter.endObject();
    }
}
