package io.sentry.util;

import io.sentry.ILogger;
import io.sentry.ISerializer;
import io.sentry.JsonSerializable;
import io.sentry.SentryLevel;
import java.io.BufferedWriter;
import java.io.ByteArrayOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicIntegerArray;

public final class JsonSerializationUtils {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static Map<String, Object> calendarToMap(Calendar calendar) {
        HashMap hashMap = new HashMap();
        hashMap.put("year", Integer.valueOf(calendar.get(1)));
        hashMap.put("month", Integer.valueOf(calendar.get(2)));
        hashMap.put("dayOfMonth", Integer.valueOf(calendar.get(5)));
        hashMap.put("hourOfDay", Integer.valueOf(calendar.get(11)));
        hashMap.put("minute", Integer.valueOf(calendar.get(12)));
        hashMap.put("second", Integer.valueOf(calendar.get(13)));
        return hashMap;
    }

    public static List<Object> atomicIntegerArrayToList(AtomicIntegerArray atomicIntegerArray) {
        int length = atomicIntegerArray.length();
        ArrayList arrayList = new ArrayList(length);
        for (int i = 0; i < length; i++) {
            arrayList.add(Integer.valueOf(atomicIntegerArray.get(i)));
        }
        return arrayList;
    }

    public static byte[] bytesFrom(ISerializer iSerializer, ILogger iLogger, JsonSerializable jsonSerializable) {
        BufferedWriter bufferedWriter;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                bufferedWriter = new BufferedWriter(new OutputStreamWriter(byteArrayOutputStream, UTF_8));
                iSerializer.serialize(jsonSerializable, (Writer) bufferedWriter);
                byte[] byteArray = byteArrayOutputStream.toByteArray();
                bufferedWriter.close();
                byteArrayOutputStream.close();
                return byteArray;
            } catch (Throwable th) {
                byteArrayOutputStream.close();
                throw th;
            }
            throw th;
        } catch (Throwable th2) {
            iLogger.log(SentryLevel.ERROR, "Could not serialize serializable", th2);
            return null;
        }
    }
}
