package io.sentry.util;

import io.sentry.DateUtils;
import io.sentry.ILogger;
import io.sentry.JsonSerializable;
import io.sentry.ObjectWriter;
import io.sentry.SentryLevel;
import java.io.IOException;
import java.net.InetAddress;
import java.net.URI;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Currency;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class MapObjectWriter implements ObjectWriter {
    final Map<String, Object> root;
    final ArrayDeque<Object> stack;

    public MapObjectWriter(Map<String, Object> map) {
        this.root = map;
        ArrayDeque<Object> arrayDeque = new ArrayDeque<>();
        this.stack = arrayDeque;
        arrayDeque.addLast(map);
    }

    public MapObjectWriter name(String str) throws IOException {
        this.stack.add(str);
        return this;
    }

    public MapObjectWriter value(ILogger iLogger, Object obj) throws IOException {
        if (obj == null) {
            nullValue();
        } else if (obj instanceof Character) {
            value(Character.toString(((Character) obj).charValue()));
        } else if (obj instanceof String) {
            value((String) obj);
        } else if (obj instanceof Boolean) {
            value(((Boolean) obj).booleanValue());
        } else if (obj instanceof Number) {
            value((Number) obj);
        } else if (obj instanceof Date) {
            serializeDate(iLogger, (Date) obj);
        } else if (obj instanceof TimeZone) {
            serializeTimeZone(iLogger, (TimeZone) obj);
        } else if (obj instanceof JsonSerializable) {
            ((JsonSerializable) obj).serialize(this, iLogger);
        } else if (obj instanceof Collection) {
            serializeCollection(iLogger, (Collection) obj);
        } else if (obj.getClass().isArray()) {
            serializeCollection(iLogger, Arrays.asList((Object[]) obj));
        } else if (obj instanceof Map) {
            serializeMap(iLogger, (Map) obj);
        } else if (obj instanceof Locale) {
            value(obj.toString());
        } else if (obj instanceof AtomicIntegerArray) {
            serializeCollection(iLogger, JsonSerializationUtils.atomicIntegerArrayToList((AtomicIntegerArray) obj));
        } else if (obj instanceof AtomicBoolean) {
            value(((AtomicBoolean) obj).get());
        } else if (obj instanceof URI) {
            value(obj.toString());
        } else if (obj instanceof InetAddress) {
            value(obj.toString());
        } else if (obj instanceof UUID) {
            value(obj.toString());
        } else if (obj instanceof Currency) {
            value(obj.toString());
        } else if (obj instanceof Calendar) {
            serializeMap(iLogger, JsonSerializationUtils.calendarToMap((Calendar) obj));
        } else if (obj.getClass().isEnum()) {
            value(obj.toString());
        } else {
            iLogger.log(SentryLevel.WARNING, "Failed serializing unknown object.", obj);
        }
        return this;
    }

    public MapObjectWriter beginArray() throws IOException {
        this.stack.add(new ArrayList());
        return this;
    }

    public MapObjectWriter endArray() throws IOException {
        endObject();
        return this;
    }

    public MapObjectWriter beginObject() throws IOException {
        this.stack.addLast(new HashMap());
        return this;
    }

    public MapObjectWriter endObject() throws IOException {
        postValue(this.stack.removeLast());
        return this;
    }

    public MapObjectWriter value(String str) throws IOException {
        postValue(str);
        return this;
    }

    public MapObjectWriter nullValue() throws IOException {
        postValue((Object) null);
        return this;
    }

    public MapObjectWriter value(boolean z) throws IOException {
        postValue(Boolean.valueOf(z));
        return this;
    }

    public MapObjectWriter value(Boolean bool) throws IOException {
        postValue(bool);
        return this;
    }

    public MapObjectWriter value(double d) throws IOException {
        postValue(Double.valueOf(d));
        return this;
    }

    public MapObjectWriter value(long j) throws IOException {
        postValue(Long.valueOf(j));
        return this;
    }

    public MapObjectWriter value(Number number) throws IOException {
        postValue(number);
        return this;
    }

    private void serializeDate(ILogger iLogger, Date date) throws IOException {
        try {
            value(DateUtils.getTimestamp(date));
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, "Error when serializing Date", (Throwable) e);
            nullValue();
        }
    }

    private void serializeTimeZone(ILogger iLogger, TimeZone timeZone) throws IOException {
        try {
            value(timeZone.getID());
        } catch (Exception e) {
            iLogger.log(SentryLevel.ERROR, "Error when serializing TimeZone", (Throwable) e);
            nullValue();
        }
    }

    private void serializeCollection(ILogger iLogger, Collection<?> collection) throws IOException {
        beginArray();
        for (Object value : collection) {
            value(iLogger, (Object) value);
        }
        endArray();
    }

    private void serializeMap(ILogger iLogger, Map<?, ?> map) throws IOException {
        beginObject();
        for (Object next : map.keySet()) {
            if (next instanceof String) {
                name((String) next);
                value(iLogger, (Object) map.get(next));
            }
        }
        endObject();
    }

    private void postValue(Object obj) {
        Object peekLast = this.stack.peekLast();
        if (peekLast instanceof List) {
            ((List) peekLast).add(obj);
        } else if (peekLast instanceof String) {
            peekObject().put((String) this.stack.removeLast(), obj);
        } else {
            throw new IllegalStateException("Invalid stack state, expected array or string on top");
        }
    }

    private Map<String, Object> peekObject() {
        Object peekLast = this.stack.peekLast();
        if (peekLast == null) {
            throw new IllegalStateException("Stack is empty.");
        } else if (peekLast instanceof Map) {
            return (Map) peekLast;
        } else {
            throw new IllegalStateException("Stack element is not a Map.");
        }
    }
}
